package com.polis.api.model.response.components.base.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CommandType {
    @JsonProperty("Widget")
    WIDGET("Widget");

    CommandType(String type) {

    }
}
