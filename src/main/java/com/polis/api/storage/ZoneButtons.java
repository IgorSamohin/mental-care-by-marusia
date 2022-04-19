package com.polis.api.storage;

public enum ZoneButtons {

    DISTRACTION("Йога", "Счет чисел", "Стоп"),
    SEDATION("Видео", "Музыка", "Звуки", "Дыхательное упражнение", "Стоп"),
    DEFAULT("Что ты можешь", "Успокоение", "Отвлечение", "Совет", "Стоп"),
    ADVICE("Совет");

    public final String[] buttons;

    ZoneButtons(String... buttons) {
        this.buttons = buttons;
    }
}
