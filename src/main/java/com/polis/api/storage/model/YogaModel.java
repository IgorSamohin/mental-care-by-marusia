package com.polis.api.storage.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class YogaModel {
    private final List<Answer> yogas;

    public YogaModel(Answer[] yogas) {
        this.yogas = Arrays.asList(yogas);
    }


    public Answer getRandomYoga() {
        int index = ThreadLocalRandom.current().nextInt(yogas.size());

        return yogas.get(index);
    }
}
