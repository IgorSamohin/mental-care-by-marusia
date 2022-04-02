package com.polis.api.model.response.components.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Позволяет задать толщину шрифта внутри основных элементов.
 * <p>
 * Значение по умолчанию: <b>regular</b>.
 */
public enum TextWeight {
    @JsonProperty("regular")
    REGULAR("regular"),
    @JsonProperty("medium")
    MEDIUM("medium");

    TextWeight(String textWeight) {

    }
}
