package com.polis.api.storage.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AdviceModel {
    private final List<Answer> advices;

    public AdviceModel(Answer[] advices) {
        this.advices = Arrays.asList(advices);
    }

    public Answer getRandomAdvice() {
        int index = ThreadLocalRandom.current().nextInt(advices.size());

        return advices.get(index);
    }
}
