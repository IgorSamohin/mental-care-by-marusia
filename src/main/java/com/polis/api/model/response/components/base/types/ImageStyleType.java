package com.polis.api.model.response.components.base.types;

public enum ImageStyleType {
    APP("app"),         // квадрат с большим радиусом скругления
    SQUARE("square"),   // квадрат с маленьким радиусом скругления
    CIRCLE("circle"),   // круг
    POSTER("poster"),   // вертикальный прямоугольник
    TV("tv");           // горизонтальный прямоугольник

    ImageStyleType(String type) {

    }
}
