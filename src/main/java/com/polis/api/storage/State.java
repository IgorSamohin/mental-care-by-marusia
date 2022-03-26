package com.polis.api.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class State {
    public static final int defaultStateId = -1;

    private int id;
    private String text;
    private String tts;
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
