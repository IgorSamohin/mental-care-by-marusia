package com.polis.api.game;

import com.polis.api.storage.MarusiaCommand;
import com.polis.api.utils.NumberTransformUtils;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class GuessNumberService {
    private static final int MAX_NUMBER_TO_CHOOSE = 100;
    private static final int MIN_NUMBER_TO_CHOOSE = 0;

    public GameNumberAnswer userGuessNumber(String userInput, Integer endGameNumber) {

        if (endGameNumber == null) {
            endGameNumber = ThreadLocalRandom.current().nextInt(MAX_NUMBER_TO_CHOOSE + 1);
        }

        try {
            int number = NumberTransformUtils.numberFromString(userInput);

            if (number > MAX_NUMBER_TO_CHOOSE) {
                return new GameNumberAnswer(
                        "Загаданное число меньше 100. Выберите другое число",
                        "Загаданное число меньше ста. Выберите другое число",
                        false,
                        null,
                        endGameNumber
                );
            }

            if (number <= MIN_NUMBER_TO_CHOOSE) {
                return new GameNumberAnswer(
                        "Загаданное число больше больше, либо равняется нулю. Выберите другое число",
                        "Загаданное число больше больше, либо равняется нулю. Выберите другое число",
                        false,
                        null,
                        endGameNumber
                );
            }

            if (number == endGameNumber) {
                return GameNumberAnswer.endGameAnswer(
                        "Поздравляю, вы отгадали число . Вы можете попробовать сыграть еще или выбрать что-то другое",
                        "Поздравляю, вы отгадали число. Вы можете попробовать сыграть еще или выбрать что-то другое"
                );
            } else if (number > endGameNumber) {
                return new GameNumberAnswer(
                        "Это не то число, которое было загадано, загаданное число меньше вашего",
                        "Это не то число, которое было загадано, загаданное число меньше вашего",
                        endGameNumber
                );
            } else {
                return new GameNumberAnswer(
                        "Это не то число, которое было загадано, загаданное число больше вашего",
                        "Это не то число, которое было загадано, загаданное число больше вашего",
                        endGameNumber
                );
            }


        } catch (ParseException e) {

            for (String command : MarusiaCommand.STOP_GAME.commands) {
                if (command.equalsIgnoreCase(userInput)) {
                    return GameNumberAnswer.endGameAnswer("Возвращайтесь снова, чтобы поиграть", "Возвращайтесь снова, чтобы поиграть");
                }
            }

            return new GameNumberAnswer("Вам надо выбрать число", "Вам надо выбрать число", endGameNumber);
        }
    }
}
