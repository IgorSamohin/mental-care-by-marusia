package com.polis.api.storage;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class State {
    public static final int DEFAULT_STATE_ID = -1;
    public static final int ERROR_STATE_ID = -2;
    public static final int EXIT_STATE_ID = -3;
    public static final int MENU_ID = 2;

    private int id;
    private String text;
    private String tts;
    private Transition[] possibleTransitions;

    public State(int id, MarusiaAnswer marusiaAnswer, Transition[] possibleTransitions) {
        this.id = id;
        this.text = marusiaAnswer.text;
        this.tts = marusiaAnswer.tts;
        this.possibleTransitions = possibleTransitions;
    }

    public int getNextStateId(String userInput) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return possibleTransition.getToId();
            }
        }
        if (id == EXIT_STATE_ID) {
            return DEFAULT_STATE_ID;
        }
        return id;
    }
}
