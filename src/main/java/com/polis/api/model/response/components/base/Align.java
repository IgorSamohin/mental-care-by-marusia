package com.polis.api.model.response.components.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Позволяет задавать выравнивание основного элемента по горизонтали.
 * <p>
 * Может быть использован внутри <b>любого</b> основного элемента.
 * <p>
 * Значение по умолчанию: <b>center</b>.
 */
public enum Align {
    @JsonProperty("left")
    LEFT("left"),
    @JsonProperty("center")
    CENTER("center"),
    @JsonProperty("right")
    RIGHT("right");

    Align(String align) {

    }
}
