package com.polis.api.model.response.components.audio;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AudioSource {
    @JsonProperty("url")
    URL("url"),
    @JsonProperty("vk")
    VK("vk");

    private final String source;

    AudioSource(String source) {
        this.source = source;
    }
}
