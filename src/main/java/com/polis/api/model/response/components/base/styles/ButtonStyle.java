package com.polis.api.model.response.components.base.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ButtonStyle {
    @JsonProperty("outline")
    OUTLINE("outline"),
    @JsonProperty("primary")
    PRIMARY("primary"),
    @JsonProperty("secondary")
    SECONDARY("secondary"),
    @JsonProperty("tertiary")
    TERTIARY("tertiary");

    ButtonStyle(String style) {

    }
}
