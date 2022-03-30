package com.polis.api.model.response.components.base;

/**
 * Позволяет задавать выравнивание основного элемента по горизонтали.
 * <p>
 * Может быть использован внутри <b>любого</b> основного элемента.
 * <p>
 * Значение по умолчанию: <b>center</b>.
 */
public enum Align {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right");

    Align(String align) {

    }
}
