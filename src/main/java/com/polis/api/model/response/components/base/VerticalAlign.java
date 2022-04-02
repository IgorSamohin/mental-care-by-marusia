package com.polis.api.model.response.components.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Позволяет задавать выравнивание основного элемента по вертикали.
 * <p>
 * Может быть использован внутри элементов <b>Image.style</b> и <b>Icon.style</b>.
 * <p>
 * Значение по умолчанию зависит от элемента — top или center.
 */
public enum VerticalAlign {
    @JsonProperty("top")
    TOP("top"),
    @JsonProperty("center")
    CENTER("center"),
    @JsonProperty("bottom")
    BOTTOM("bottom");

    VerticalAlign(String align) {

    }
}
