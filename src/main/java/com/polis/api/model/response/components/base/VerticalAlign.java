package com.polis.api.model.response.components.base;

/**
 * Позволяет задавать выравнивание основного элемента по вертикали.
 * <p>
 * Может быть использован внутри элементов <b>Image.style</b> и <b>Icon.style</b>.
 * <p>
 * Значение по умолчанию зависит от элемента — top или center.
 */
public enum VerticalAlign {
    TOP("top"),
    CENTER("center"),
    BOTTOM("bottom");

    VerticalAlign(String align) {

    }
}
