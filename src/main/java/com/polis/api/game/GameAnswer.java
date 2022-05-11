package com.polis.api.game;

public record GameAnswer(String text, String tts, boolean endSession, boolean endGame, int prevNumber,
                         int endGameNUmber) {
    public GameAnswer(String text, String tts, boolean endGame, int prevNumber, int endGameNUmber) {
        this(text, tts, false, endGame, prevNumber, endGameNUmber);
    }
}
