package com.polis.api.storage;

import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.storage.answer.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
public class State {
    public static final int START_STATE_ID = -1;
    public static final int ERROR_STATE_ID = -2;
    public static final int EXIT_STATE_ID = -3;
    public static final int MENU_ID = 2;

    private int id;
    private Answer answer;
    private List<Transition> possibleTransitions;
    private List<String> buttons;
    private String text;
    private String tts;
    private Command[] commands = null;
    private AudioPlayer audioPlayer = null;

    public State(int id, Answer answer, Transition[] possibleTransitions, String[] buttons, Command[] commands,
                 AudioPlayer audioPlayer, boolean repeatable) {
        this.id = id;
        this.answer = answer;
        this.commands = commands;
        this.audioPlayer = audioPlayer;

        this.possibleTransitions = new ArrayList<>(Arrays.stream(possibleTransitions).toList());
        this.buttons = new ArrayList<>(Arrays.stream(buttons).toList());

        if (repeatable) {
            this.possibleTransitions.add(new Transition(id, MarusiaCommand.MORE));
            this.buttons.add("Еще");
        }
    }

    /**
     * @param userInput команда от пользователя
     * @return состояние, которое соотвествует команде пользователя
     */
    public int getNextStateId(String userInput) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return possibleTransition.getToId();
            }
        }

        return ERROR_STATE_ID;
    }

    //FIXME возможно так плохо, тк можно вызвать getAnswer().text и сразу после этого getAnswer().tts и буду разные
    // результаты, но кажется если тут завязано на рандоме, так будет всегда, нельяз будет вызывать таким образом
    public MarusiaAnswer getAnswer() {
        return answer.getAnswer();
    }
}
