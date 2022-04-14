package com.polis.api.storage;

public enum MarusiaCommand {
    EXIT("Выход", "пока", "выйди", "хочу выйти", "стоп", "все", "хватит", "выйти", "закончить", "закончи"),
    HOME("В начало", "начало", "вернись в начало", "заново", "давай по новой"),
    MORE("Еще", "Давай еще", "Давай еще раз", "Повтори", "Еще раз"),

    DISTRACTION("Хочу отвлечься", "давай отдохнём", "отдых", "релакс", "отвлечение", "отвлеки",
            "отвлекай", "отвлекай меня"),
    DISTRACTION_YOGA("Йога", "дай йогу", "йогу", "выбираю йогу", "видео с йогой", ""),
    DISTRACTION_COUNT("Счет чисел", "задание на числа", "давай поиграем", "числа", "играть", "задание с числами"),
    DISTRACTION_NUMBER_DIVINATION("Загадывание чисел", "гадание", "гадание на числах"), // пока не реализовано

    ADVICE("Совет", "дай совет", "что ты можешь посоветовать", "посоветуй что-нибудь", "посоветуй",
            "дай какой-нибудь совет"),

    HELP("Что ты можешь", "что ты умеешь", "твои функции", "помощь", "помоги", "как ты можешь помочь"),
    HELP_SEDATION("как ты можешь меня успокоить", "как ты можешь успокоить",
            "как можешь успокоить"), // возможно одинаковое с SEDATION
    HELP_DISTRACTION("как ты можешь меня отвлечь", "как ты можешь отвлечь",
            "как можешь отвлечь"), // возможно одинаковое с DISTRACTION

    SEDATION("Успокой", "хочу успокоиться", "успокой меня", "успокоение", "успокаивай", "успокаивай меня"),
    SEDATION_VIDEO("Видео", "скинь видос", "скинь видео", "видос", "успокаивающее видео"),
    SEDATION_SOUNDS("Успокаивающие звуки", "включи успокаивающие звуки", "спокойные звуки", "звуки"),
    SEDATION_MUSIC("Музыка", "включи успокаивающую музыку"),
    BREATH_EXERCISE("Дыхательное упражнение", "давай подышим", "давай пыхнем", "дыхательная гимнастика", "дышать",
            "упражнение", "дыхание", "подышать");

    public final String[] commands;

    MarusiaCommand(String... commands) {
        this.commands = commands;
    }
}
