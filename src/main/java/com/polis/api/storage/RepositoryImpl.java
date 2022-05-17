package com.polis.api.storage;

import com.polis.api.game.CountTaskService;
import com.polis.api.game.GameNumberAnswer;
import com.polis.api.game.GuessNumberService;
import com.polis.api.model.request.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RepositoryImpl {
    private final DataProvider dataProvider;
    private final GuessNumberService guessNumberService;
    private final CountTaskService countTaskService;

    @Autowired
    public RepositoryImpl(DataProvider provider, GuessNumberService guessNumberService, CountTaskService countTaskService) {
        this.dataProvider = provider;
        this.guessNumberService = guessNumberService;
        this.countTaskService = countTaskService;
    }

    private Map<Integer, State> getStates() {
        return dataProvider.getStates();
    }

    public State getState(int stateId) {
        return getStates().get(stateId);
    }

    public State getNextState(int currentStateId, String userInput, UserSession session) {

        if (userInput.equals("on_interrupt")) {
            return getStates().get(State.EXIT_STATE_ID);
        }


        State currentState = getStates().get(currentStateId);

        int nextStateId = currentState.getRandomNextStateId(userInput);

        if (nextStateId == State.HOME_STATE_ID) {
            return getState(nextStateId);
        }

        if (currentStateId == State.GUESS_GAME_STATE_ID) {
            GameNumberAnswer gameNumberAnswer = guessNumberService.userGuessNumber(userInput, session.endGameNumber);

            if (gameNumberAnswer.endGame()) {
                return new GameState(currentStateId, gameNumberAnswer, null, getState(10).getButtons());
            }

            return new GameState(currentStateId, gameNumberAnswer, null, currentState.getButtons());
        }

        if (currentStateId == State.COUNT_GAME_STATE_ID) {
            GameNumberAnswer gameNumberAnswer = countTaskService.handleInput(userInput, session.prevNumberGame, session.endGameNumber);

            if (gameNumberAnswer.endGame()) {
                return new GameState(currentStateId, gameNumberAnswer, null, getState(10).getButtons());
            }

            return new GameState(currentStateId, gameNumberAnswer, null, currentState.getButtons());
        }

        //не нашли команду, поэтому ошибка
        if (nextStateId == State.ERROR_STATE_ID) {
            return getState(State.ERROR_STATE_ID);
        }


        return getState(nextStateId);
    }

    public State getStartState() {
        return getState(State.START_STATE_ID);
    }
}
