package com.polis.api.storage;

import com.polis.api.game.GameNumberAnswer;
import com.polis.api.model.response.ResponseButton;
import com.polis.api.storage.model.Answer;
import lombok.Getter;

import java.util.List;

public class GameState extends State {
    @Getter
    private final boolean endGame;
    @Getter
    private final Integer prevNumber;
    @Getter
    private final Integer endGameNumber;


    public GameState(int id, GameNumberAnswer gameNumberAnswer, List<Transition> possibleTransitions, List<ResponseButton> buttons) {
        super(id, new Answer(gameNumberAnswer.text(), gameNumberAnswer.tts()), possibleTransitions, buttons);

        this.endGame = gameNumberAnswer.endGame();
        this.prevNumber = gameNumberAnswer.prevNumber();
        this.endGameNumber = gameNumberAnswer.endGameNumber();
    }
}
