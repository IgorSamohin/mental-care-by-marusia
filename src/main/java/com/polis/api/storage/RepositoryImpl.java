package com.polis.api.storage;

import com.polis.api.game.CountTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RepositoryImpl {
    private final DataProvider dataProvider;
    private final CountTaskService countTaskService;

    @Autowired
    public RepositoryImpl(DataProvider provider, CountTaskService countTaskService) {
        this.dataProvider = provider;
        this.countTaskService = countTaskService;
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


    private boolean isCountNumberGameState(int currentStateId) {
        return currentStateId == 9 || currentStateId == 14 || currentStateId == 15 ||
                currentStateId == 16 || currentStateId == 17 || currentStateId == 18;
    }

    public State getStartState() {
        return getState(State.START_STATE_ID);
    }
}
