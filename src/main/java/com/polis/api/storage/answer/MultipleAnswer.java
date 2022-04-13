package com.polis.api.storage.answer;

import com.polis.api.RandomUtils;
import com.polis.api.storage.MarusiaAnswer;

import java.util.Random;

public class MultipleAnswer implements Answer{
    private final MarusiaAnswer[] marusiaAnswer;

    public MultipleAnswer(MarusiaAnswer... marusiaAnswer) {
        this.marusiaAnswer = marusiaAnswer;
    }

    @Override
    public MarusiaAnswer getAnswer() {
        int randomIndex = RandomUtils.randomNumberFromZeroToBound(marusiaAnswer.length);

        return marusiaAnswer[randomIndex];
    }
}
