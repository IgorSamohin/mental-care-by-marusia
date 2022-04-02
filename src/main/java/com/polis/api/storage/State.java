package com.polis.api.storage;

import com.polis.api.model.response.components.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class State {
    public static final int defaultStateId = -1;
    public static final int errorStateId = -2;
    public static final int exitStateId = -3;
    public static final int menuId = 2;

    private int id;
    private String text;
    private String tts;
    private Transition[] possibleTransitions;
    private Command[] commands = null;

    public State(int id, String text, String tts, Transition[] possibleTransitions) {
        this.id = id;
        this.text = text;
        this.tts = tts;
        this.possibleTransitions = possibleTransitions;
    }

    public int getNextStateId(String userInput) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return possibleTransition.getToId();
            }
        }
        if (id == exitStateId) {
            return defaultStateId;
        }
        return id;
    }
}
