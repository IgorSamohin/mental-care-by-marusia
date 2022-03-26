package com.polis.api.storage;

import lombok.Getter;

@Getter
public class State {
    public static final int defaultStateId = -1;

    private int id;
    private String text;
    private Transition[] possibleTransitions;

    public int getNextStateId(String userInput) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return possibleTransition.getToId();
            }
        }
        return defaultStateId;
    }
}
