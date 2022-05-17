package com.polis.api.game;

public record GameNumberAnswer(
        String text,
        String tts,
        boolean endGame,
        Integer prevNumber,
        Integer endGameNumber
) {
    public GameNumberAnswer(String text, String tts, int endGameNUmber) {
        this(text, tts, false, null, endGameNUmber);
    }

    static GameNumberAnswer endGameAnswer(String text, String tts) {
        return new GameNumberAnswer(text, tts, true, null, null);
    }
}
