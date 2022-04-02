package com.polis.api.model.response.components.base.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FooterType {
    @JsonProperty("accent_button")
    ACCENT_BUTTON("accent_button"),
    @JsonProperty("user_stack")
    USER_STACK("user_stack");

    FooterType(String type) {
    }
}
