package com.polis.api.storage;

import lombok.Getter;

public enum ZoneButtons {
    @Deprecated
    REPEAT("Еще", "Повтори"),//fixme эта зона отличается от остальных - ее нужно вынести в отдельный класс

    START("Успокой меня", "Отвлеки меня", "Что ты умеешь?"),
    MAIN_HELP("Как ты можешь успокоить?", "Как ты можешь отвлечь?"),
    COMMON_HELP("Скинь видео", "Включи музыку", "Включи звуки", "Дыхательное упражнение"),

    DISTRACTION("Йога", "Счет чисел"),
    SEDATION("Скинь видео", "Включи музыку", "Звуки", "Дыхательное упражнение"),
    GUESS_GAME("Да", "Нет"),

    DEFAULT("Что ты умеешь?", "Успокой меня", "Отвлеки меня", "Дай совет"),
    ADVICE("Совет");

    @Getter
    private final String[] buttons;

    ZoneButtons(String... buttons) {
        this.buttons = buttons;
    }

    /**
     * FIXME Если собираешься это использовать для кнопок, которые не REPEAT, то нужно все переделать. (в любом случае нужно это переделать)
     */
    @Deprecated
    public String getRandomButton() {
        return buttons[0];
    }
}
