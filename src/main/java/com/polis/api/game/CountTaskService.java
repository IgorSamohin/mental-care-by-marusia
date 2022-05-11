package com.polis.api.game;

import com.ibm.icu.text.RuleBasedNumberFormat;
import com.polis.api.storage.MarusiaCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class CountTaskService {
    private RuleBasedNumberFormat numberFormat = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"),
            RuleBasedNumberFormat.SPELLOUT);

    public GameAnswer handleInput(String userInput, int prevNumber, int endGameNumber) {
        try {
            int numberFromString = numberFromString(userInput);

            int number = numberFromString == -1 ? Integer.parseInt(userInput) : numberFromString;

            if (endGameNumber == -1) {
                return new GameAnswer("Давайте я начну! Один", "Давайте я начну! Один", false, 1, number);
            }

            if (number <= 1) {
                return new GameAnswer("Число должно быть больше 1", "Число должно быть больше одного", false, prevNumber, endGameNumber);
            }

            if (number > 100) {
                return new GameAnswer("Число должно быть меньше или равняться 100", "Число должно быть меньше или равняться ста", false, prevNumber, endGameNumber);
            }

            if (Math.abs(prevNumber - number) > 1 || number <= prevNumber) {
                return new GameAnswer("Следующее число должно быть на один больше моего", "Следующее число должно быть на один больше моего", false, prevNumber, endGameNumber);
            }

            if (number == endGameNumber) {
                return new GameAnswer("Вы назвали конечное число. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое", "Вы назвали конечное число. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое", true, prevNumber, endGameNumber);
            }

            return getAnswerWithNexNumber(prevNumber, endGameNumber, number);

        } catch (NumberFormatException e) {

            for (String command : MarusiaCommand.DISTRACTION_STOP.commands) {
                if (command.equalsIgnoreCase(userInput) || userInput.equals("on_interrupt")) {
                    return new GameAnswer("Возвращайтесь снова, чтобы поиграть", "Возвращайтесь снова, чтобы поиграть", true, prevNumber, endGameNumber);
                }
            }

            return new GameAnswer("Вы должны выбрать число", "Вы должны выбрать число", false, prevNumber, endGameNumber);
        }
    }

    private GameAnswer getAnswerWithNexNumber(int prevNumber, int endGameNumber, int number) {
        int nextNumber = number + 1;

        String strNextNumber = stringFromNumber(nextNumber);

        if (nextNumber == endGameNumber) {
            return new GameAnswer(strNextNumber + ", Мы досчитали до конца. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое", strNextNumber + ", Мы досчитали до конца. Отличная работа! Можем сыграть снова или вы можете выбрать что-то другое", true, prevNumber, endGameNumber);
        }

        return new GameAnswer(strNextNumber + "! Ваша очередь", strNextNumber + "! Ваша очередь", false, nextNumber, endGameNumber);
    }

    private int numberFromString(String number) {
        try {
            return numberFormat.parse(number).intValue();
        } catch (ParseException e) {
            return -1;
        }
    }

    private String stringFromNumber(int number) {
        return numberFormat.format(number);
    }

}
