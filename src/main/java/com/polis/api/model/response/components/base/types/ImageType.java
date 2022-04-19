package com.polis.api.model.response.components.base.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Тип источника, из которого нужно загрузить данные в элемент image
 */
public enum ImageType {
    @JsonProperty("mini_app")
    MINI_APP("mini_app"),
    @JsonProperty("inline")
    INLINE("inline"),
    @JsonProperty("profile")
    PROFILE("profile"),
    @JsonProperty("group")
    GROUP("group");

    ImageType(String type) {
    }
}
