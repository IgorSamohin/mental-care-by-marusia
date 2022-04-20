package com.polis.api.storage;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Map;

@Repository
public class RepositoryImpl {
    private final Map<Integer, State> states = Data.states;
    private final State defaultState = new State();

    public State getState(int stateId) {
        return states.get(stateId);
    }

    public State getNextState(int currentStateId, String userInput) {

        if (userInput.equals("on_interrupt")) {
            return states.get(State.EXIT_STATE_ID);
        }

        State currentState = states.get(currentStateId);

        int nextStateId = currentState.getNextStateId(userInput);

        //не нашли команду, поэтому ошибка
        if (nextStateId == State.ERROR_STATE_ID) {
            return getState(State.ERROR_STATE_ID);
        }


        return getState(nextStateId);
    }
}
