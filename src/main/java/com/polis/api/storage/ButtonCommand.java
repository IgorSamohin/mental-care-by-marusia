package com.polis.api.storage;

/**
 * Команды доступные в каждом state для перехода в другой, которые будут отображаться в в кнопках
 */

//TODO Можно такое создать в команд, или где-то, и проходить все, и собирать в массив
public enum ButtonCommand {

    //FIXME по идее в начало дб в каждом стейте, но нужно ли тут
    FROM_HOME("Хочу отвлечься", "Совет", "Что ты можешь", "Успокой", "В начало", "Выход"),

    FROM_DISTRACTION("Йога", "Загадывание чисел(not work)", "Счет чисел", "В начало", "Выход"),
    FROM_DISTRACTION_YOGA("Еще","В начало", "Выход"),
    FROM_DISTRACTION_COUNT("Еще", "В начало", "Выход"),
    FROM_DISTRACTION_NUMBER_DIVINATION("Еще", "В начало", "Выход"), // пока не реализовано

    FROM_ADVICE("Еще", "В начало", "Выход"),

    FROM_HELP("Отвлечение", "Успокоение", "В начало", "Выход"),
    FROM_HELP_SEDATION("В начало", "Выход"), // возможно одинаковое с SEDATION
    FROM_HELP_DISTRACTION("В начало", "Выход"), // возможно одинаковое с DISTRACTION

    FROM_SEDATION("Видео", "Успокаивающие звуки", "Музыка", "Дыхательное упраженение", "В начало", "Выход"),
    FROM_SEDATION_VIDEO("Еще", "В начало", "Выход"),
    FROM_SEDATION_SOUNDS("Еще", "В начало", "Выход"),
    FROM_SEDATION_MUSIC("Еще", "В начало", "Выход"),
    FROM_BREATH_EXERCISE("Еще", "В начало", "Выход");


    public final String[] buttons;

    ButtonCommand(String... buttons) {
        this.buttons = buttons;
    }
}
