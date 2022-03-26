package com.polis.api.storage;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Repository
public class RepositoryImpl {
    private Map<Integer, State> states = Data.states;
    private final State defaultState = new State();

    public State getState(String userInput) {
        for (State value : states.values()) {
            if (value.getText().equals(userInput)) {
                return value;
            }
        }
        return defaultState;
    }

    public State getState(int stateId) {
        return states.get(stateId);
    }

    public State getNextState(int currentStateId, String userInput) {
        State currentState = states.get(currentStateId);

        return getState(currentState.getNextStateId(userInput));
    }
}
