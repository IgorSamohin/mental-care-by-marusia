package com.polis.api.storage;

import lombok.Getter;

public enum ZoneButtons {
    @Deprecated
    REPEAT("Еще", "Повтори"),//fixme эта зона отличается от остальных - ее нужно вынести в отдельный класс

    COMMON_HELP("Видео", "Музыка", "Звуки", "Дыхательное упражнение"),
    DISTRACTION("Йога", "Счет чисел", "Стоп"),
    SEDATION("Видео", "Музыка", "Звуки", "Дыхательное упражнение", "Стоп"),
    DEFAULT("Что ты можешь", "Успокоение", "Отвлечение", "Совет", "Стоп"),
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
