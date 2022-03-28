package com.polis.api.model.response.components.audio;

public enum AudioSource {
    URL("url"),
    VK("vk");

    private final String source;

    AudioSource(String source) {
        this.source = source;
    }
}
