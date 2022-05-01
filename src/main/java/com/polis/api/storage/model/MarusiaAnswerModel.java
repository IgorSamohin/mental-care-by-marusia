package com.polis.api.storage.model;

import com.polis.api.storage.MarusiaAnswer;

public record MarusiaAnswerModel(String text, String tts, String stubText, String stubTts, boolean isRepeatable) {
    public MarusiaAnswerModel(String text, String tts, String stubText, String stubTts, boolean isRepeatable) {
        this.text = text;
        this.tts = tts;
        this.isRepeatable = isRepeatable;
        this.stubText = stubText;
        this.stubTts = stubTts;
    }

    @Deprecated
    public MarusiaAnswerModel(MarusiaAnswer marusiaAnswer, boolean isRepeatable) {
        this(marusiaAnswer.text, marusiaAnswer.tts, marusiaAnswer.stubText, marusiaAnswer.stubTts, isRepeatable);
    }
}
