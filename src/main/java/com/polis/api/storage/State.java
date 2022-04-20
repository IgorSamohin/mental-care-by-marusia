package com.polis.api.storage;

import com.polis.api.model.response.ResponseButton;
import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@NoArgsConstructor
public class State {
    public static final int START_STATE_ID = -1;
    public static final int ERROR_STATE_ID = -2;
    public static final int EXIT_STATE_ID = -3;
    public static final int MENU_ID = 2;

    private int id;
    private MarusiaAnswer marusiaAnswer;
    private List<Transition> possibleTransitions;
    private List<ResponseButton> buttons;
    private Command[] commands = null;
    private AudioPlayer audioPlayer = null;

    public State(int id, MarusiaAnswer marusiaAnswer, Transition[] possibleTransitions, String[] buttons, boolean repeatable) {

        this(id, marusiaAnswer, possibleTransitions, null, null);

        this.buttons = new ArrayList<>(Arrays.stream(buttons).map(ResponseButton::new).toList());

        if (repeatable) {
            this.possibleTransitions.add(new Transition(id, MarusiaCommand.MORE));
            this.buttons.add(new ResponseButton("Еще"));
        }

    }

    public State(int id, MarusiaAnswer marusiaAnswer, Transition[] possibleTransitions) {
        this(id, marusiaAnswer, possibleTransitions, new Command[]{}, null);
    }

    public State(
            int id,
            MarusiaAnswer marusiaAnswer,
            Transition[] possibleTransitions,
            Command[] commands,
            AudioPlayer audioPlayer) {
        this.id = id;
        this.marusiaAnswer = marusiaAnswer;
        this.possibleTransitions = new ArrayList<>(Arrays.stream(possibleTransitions).toList());
        this.commands = commands;
        this.audioPlayer = audioPlayer;
    }

    /**
     * @param userInput команда от пользователя
     * @return состояние, которое соотвествует команде пользователя
     */
    public int getNextStateId(String userInput) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                int[] toIds = possibleTransition.getToIds();

                return getRandomStateId(toIds);
            }
        }

        return ERROR_STATE_ID;
    }

    private int getRandomStateId(int[] ids) {
        if (ids.length == 1) {
            return ids[0];
        }
        return ids[ThreadLocalRandom.current().nextInt(ids.length)];
    }
}
