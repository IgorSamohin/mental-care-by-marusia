package com.polis.api.game;

public record CountNumberAnswer(
        String text,
        String tts,
        boolean endGame,
        int prevNumber,
        int endGameNUmber
) {
}
