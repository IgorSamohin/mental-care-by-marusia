package com.polis.api.storage.model;

public record Answer(String text, String tts, boolean isRepeatable) {
    public Answer(String text, String tts) {
        this(text, tts, false);
    }
}
