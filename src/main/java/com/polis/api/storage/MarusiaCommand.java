package com.polis.api.storage;

public enum MarusiaCommand {
    EXIT("пока", "выйди", "хочу выйти", "стоп", "все", "хватит", "выйти", "закончить", "закончи"),
    HOME("начало", "вернись в начало", "заново", "давай по новой", "в начало"),

    DISTRACTION("хочу отвлечься", "давай отдохнём", "отдых", "релакс", "отвлечение", "отвлеки",
            "как ты можешь меня отвлечь", "как ты можешь отвлечь", "отвлекай", "отвлекай меня", "как можешь отвлечь"),
    DISTRACTION_YOGA("дай йогу", "йога", "йогу", "выбираю йогу", "видео с йогой", ""),
    DISTRACTION_COUNT("задание на числа", "давай поиграем", "числа", "играть", "задание с числами"),
    DISTRACTION_NUMBER_DIVINATION("гадание", "гадание на числах"), // пока не реализовано

    ADVICE("дай совет", "совет", "что ты можешь посоветовать", "посоветуй что-нибудь", "посоветуй",
            "дай какой-нибудь совет"),

    HELP("что ты можешь", "что ты умеешь", "твои функции", "помощь", "помоги", "как ты можешь помочь"),
    HELP_SEDATION("как ты можешь меня успокоить", "как ты можешь успокоить", "успокоение",
            "как можешь успокоить"), // возможно одинаковое с SEDATION
    HELP_DISTRACTION("как ты можешь меня отвлечь", "как ты можешь отвлечь", "отвлечение",
            "как можешь отвлечь"), // возможно одинаковое с DISTRACTION

    SEDATION("хочу успокоиться", "успокой меня", "успокоение", "успокой", "как ты можешь меня успокоить",
            "как ты можешь успокоить", "успокаивай", "успокаивай меня", "как можешь успокоить"),
    SEDATION_VIDEO("скинь видос", "скинь видео", "видео", "видос", "успокаивающее видео"),
    SEDATION_SOUNDS("включи успокаивающие звуки", "успокаивающие звуки", "спокойные звуки", "звуки"),
    SEDATION_MUSIC("включи успокаивающую музыку", "музыка"),
    BREATH_EXERCISE("давай подышим", "давай пыхнем", "дыхательная гимнастика", "дышать",
            "упражнение", "дыхательное упражнение", "дыхание", "подышать");

    public final String[] commands;

    MarusiaCommand(String... commands) {
        this.commands = commands;
    }
}
