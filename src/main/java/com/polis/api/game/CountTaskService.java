package com.polis.api.game;

import com.polis.api.storage.MarusiaCommand;
import com.polis.api.utils.NumberTransformUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;

@Component
@RequiredArgsConstructor
public class CountTaskService {
    public GameNumberAnswer handleInput(String userInput, Integer prevNumber, Integer endGameNumber) {
        try {
            int number = NumberTransformUtils.numberFromString(userInput);

            if (endGameNumber == null) {
                return new GameNumberAnswer(
                        "Давайте я начну! Один",
                        "Давайте я начну! Один",
                        false,
                        1,
                        number
                );
            }

            if (number <= 1) {
                return new GameNumberAnswer(
                        "Число должно быть больше 1",
                        "Число должно быть больше одного",
                        false,
                        prevNumber,
                        endGameNumber
                );
            }

            if (number > 100) {
                return new GameNumberAnswer(
                        "Число должно быть меньше или равняться 100",
                        "Число должно быть меньше или равняться ста",
                        false,
                        prevNumber,
                        endGameNumber
                );
            }

            if (Math.abs(prevNumber - number) > 1 || number <= prevNumber) {
                return new GameNumberAnswer(
                        "Следующее число должно быть на один больше моего",
                        "Следующее число должно быть на один больше моего",
                        false,
                        prevNumber,
                        endGameNumber
                );
            }

            if (number == endGameNumber) {
                return new GameNumberAnswer(
                        "Вы назвали конечное число. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое",
                        "Вы назвали конечное число. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое",
                        true,
                        prevNumber,
                        endGameNumber
                );
            }

            return getAnswerWithNextNumber(prevNumber, endGameNumber, number);

        } catch (ParseException e) {

            for (String command : MarusiaCommand.STOP_GAME.commands) {
                if (command.equalsIgnoreCase(userInput)) {
                    return new GameNumberAnswer("Возвращайтесь снова, чтобы поиграть", "Возвращайтесь снова, чтобы поиграть", true, prevNumber, endGameNumber);
                }
            }

            return new GameNumberAnswer("Вы должны выбрать число", "Вы должны выбрать число", false, prevNumber, endGameNumber);
        }
    }

    private GameNumberAnswer getAnswerWithNextNumber(int prevNumber, int endGameNumber, int number) {
        int nextNumber = number + 1;

        String strNextNumber = NumberTransformUtils.stringFromNumber(nextNumber);
        strNextNumber = StringUtils.capitalize(strNextNumber);

        if (nextNumber == endGameNumber) {
            return new GameNumberAnswer(
                    strNextNumber + ", Мы досчитали до конца. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое",
                    strNextNumber + ", Мы досчитали до конца. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое",
                    true,
                    prevNumber,
                    endGameNumber
            );
        }

        return new GameNumberAnswer(
                strNextNumber + "! Ваша очередь",
                strNextNumber + "! Ваша очередь",
                false,
                nextNumber,
                endGameNumber
        );
    }
}
