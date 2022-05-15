package com.polis.api.game;

public record GuessNumberAnswer(
        String text,
        String tts,
        boolean endGame,
        Integer endGameNumber
) {
    public GuessNumberAnswer(String text, String tts, int endGameNUmber) {
        this(text, tts, false, endGameNUmber);
    }

    static GuessNumberAnswer endGameAnswer(String text, String tts) {
        return new GuessNumberAnswer(text, tts, true, null);
    }
}
