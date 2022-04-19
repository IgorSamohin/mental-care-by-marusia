package com.polis.api.model.response.components.base.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ImageStyleType {
    @JsonProperty("app")
    APP("app"),         // квадрат с большим радиусом скругления
    @JsonProperty("square")
    SQUARE("square"),   // квадрат с маленьким радиусом скругления
    @JsonProperty("circle")
    CIRCLE("circle"),   // круг
    @JsonProperty("poster")
    POSTER("poster"),   // вертикальный прямоугольник
    @JsonProperty("tv")
    TV("tv");           // горизонтальный прямоугольник

    ImageStyleType(String type) {

    }
}
