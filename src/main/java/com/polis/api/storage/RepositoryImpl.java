package com.polis.api.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RepositoryImpl {
    private final DataProvider dataProvider;

    @Autowired
    public RepositoryImpl(DataProvider provider) {
        this.dataProvider = provider;
    }

    private Map<Integer, State> getStates() {
        return dataProvider.getStates();
    }

    public State getState(int stateId) {
        return getStates().get(stateId);
    }

    public State getNextState(int currentStateId, String userInput) {

        if (userInput.equals("on_interrupt")) {
            return getStates().get(State.EXIT_STATE_ID);
        }

        State currentState = getStates().get(currentStateId);

        int nextStateId = currentState.getRandomNextStateId(userInput);

        //не нашли команду, поэтому ошибка
        if (nextStateId == State.ERROR_STATE_ID) {
            return getState(State.ERROR_STATE_ID);
        }


        return getState(nextStateId);
    }
}
