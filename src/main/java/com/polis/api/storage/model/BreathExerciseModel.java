package com.polis.api.storage.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BreathExerciseModel {

    private final List<Answer> exercises;

    public BreathExerciseModel(Answer[] exercises) {
        this.exercises = Arrays.stream(exercises).toList();
    }


    public Answer getRandomAdvice() {
        int index = ThreadLocalRandom.current().nextInt(exercises.size());

        return exercises.get(index);
    }
}
