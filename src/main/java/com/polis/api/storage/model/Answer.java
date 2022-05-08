package com.polis.api.storage.model;

import com.polis.api.storage.MarusiaAnswer;

public record Answer(String text, String tts, String stubText, String stubTts, boolean isRepeatable) {
    public Answer(String text, String tts, String stubText, String stubTts, boolean isRepeatable) {
        this.text = text;
        this.tts = tts;
        this.isRepeatable = isRepeatable;
        this.stubText = stubText;
        this.stubTts = stubTts;
    }

    public Answer(String text, String tts) {
        this(text, tts, null, null, false);
    }

    public Answer(String text, String tts, boolean isRepeatable) {
        this(text, tts, null, null, isRepeatable);
    }

    @Deprecated
    public Answer(MarusiaAnswer marusiaAnswer, boolean isRepeatable) {
        this(marusiaAnswer.text, marusiaAnswer.tts, marusiaAnswer.stubText, marusiaAnswer.stubTts, isRepeatable);
    }
}
