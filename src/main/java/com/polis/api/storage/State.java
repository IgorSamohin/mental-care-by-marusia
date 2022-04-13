package com.polis.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;
import lombok.AllArgsConstructor;
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
    private Command[] commands = null;
    private AudioPlayer audioPlayer = null;

    public State(
            int id,
            String text,
            String tts,
            Transition[] possibleTransitions,
            Command[] commands,
            AudioPlayer audioPlayer
    ) {
        this.id = id;
        this.text = text;
        this.tts = tts;
        this.possibleTransitions = possibleTransitions;
        this.commands = commands;
        this.audioPlayer = audioPlayer;
    }

    public State(int id, MarusiaAnswer marusiaAnswer, Transition[] possibleTransitions) {
        this(id, marusiaAnswer.text, marusiaAnswer.tts, possibleTransitions, new Command[]{}, null);
    }

    public State(
            int id,
            MarusiaAnswer marusiaAnswer,
            Transition[] possibleTransitions,
            Command[] commands,
            AudioPlayer audioPlayer) {
        this(id, marusiaAnswer.text, marusiaAnswer.tts, possibleTransitions, commands, audioPlayer);
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
