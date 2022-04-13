package com.polis.api.storage.answer;

import com.polis.api.storage.MarusiaAnswer;

public class SingleAnswer implements Answer{

    private final MarusiaAnswer marusiaAnswer;

    public SingleAnswer(MarusiaAnswer marusiaAnswer) {
        this.marusiaAnswer = marusiaAnswer;
    }

    @Override
    public MarusiaAnswer getAnswer() {
        return marusiaAnswer;
    }
}
