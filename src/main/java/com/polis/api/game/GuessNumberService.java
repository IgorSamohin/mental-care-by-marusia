package com.polis.api.game;

import com.polis.api.storage.MarusiaCommand;
import com.polis.api.utils.NumberTransformUtils;

import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberService {
    public GuessNumberAnswer userGuessNumber(String userInput, int endGameNumber) {

        if (endGameNumber == -1) {
            int numberToGuess = ThreadLocalRandom.current().nextInt(101);

            return new GuessNumberAnswer(
                    "Давайте начнем! Я загадала число, попробуйте его отгадать.",
                    "Давайте начнем! Я загадала число, попробуйте его отгадать.",
                    numberToGuess
            );
        }

        try {
            int numberFromString = NumberTransformUtils.numberFromString(userInput);

            int number = numberFromString == -1 ? Integer.parseInt(userInput) : numberFromString;

            if (number > 100) {
                return new GuessNumberAnswer(
                        "Загаданное число меньше 100. Выберите другое число",
                        "Загаданное число меньше ста. Выберите другое число",
                        false,
                        endGameNumber
                );
            }

            if (number < 0) {
                return new GuessNumberAnswer(
                        "Загаданное число больше 0. Выберите другое число",
                        "Загаданное число больше нуля. Выберите другое число",
                        false,
                        endGameNumber
                );
            }

            if (number == endGameNumber) {
                return GuessNumberAnswer.endGameAnswer(
                        "Поздравляю, вы отгадали число . Вы можете попробовать сыграть еще или выбрать что-то другое",
                        "Поздравляю, вы отгадали число. Вы можете попробовать сыграть еще или выбрать что-то другое"
                );
            } else {
                return new GuessNumberAnswer(
                        "Это не то число, которое было загадано",
                        "Это не то число, которое было загадано",
                        endGameNumber
                );
            }


        } catch (NumberFormatException e) {

            for (String command : MarusiaCommand.DISTRACTION_STOP.commands) {
                if (command.equalsIgnoreCase(userInput) || userInput.equals("on_interrupt")) {
                    return GuessNumberAnswer.endGameAnswer("Возвращайтесь снова, чтобы поиграть", "Возвращайтесь снова, чтобы поиграть");
                }
            }

            return new GuessNumberAnswer("Вам надо выбрать число", "Вам надо выбрать число");
        }
    }
}
