package com.polis.api.storage;

import com.polis.api.model.response.ResponseButton;
import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.storage.model.AdviceModel;
import com.polis.api.storage.model.Answer;
import com.polis.api.storage.model.AudioModel;
import com.polis.api.storage.model.BreathExerciseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class State {
    public static final int START_STATE_ID = -1;
    public static final int ERROR_STATE_ID = -2;
    public static final int EXIT_STATE_ID = -3;
    public static final int MENU_ID = 2;

    @Getter
    private int id;

    private Answer answer;
    @Getter
    private List<Transition> possibleTransitions;
    @Getter
    private List<ResponseButton> buttons;
    @Getter
    private List<Command> commands;
    private AudioModel audio;
    private BreathExerciseModel breathExerciseModel;
    private AdviceModel adviceModel;

    public State(
            int id,
            Answer answer,
            @Nullable Transition[] possibleTransitions,
            @Nullable ResponseButton[] buttons,
            @Nullable Command[] commands,
            @Nullable AudioModel audio,
            @Nullable BreathExerciseModel breathExerciseModel,
            @Nullable AdviceModel adviceModel
    ) {
        this.id = id;
        this.answer = answer;
        this.commands = commands == null ? new ArrayList<>() : List.of(commands);
        this.audio = audio;
        this.breathExerciseModel = breathExerciseModel;
        this.adviceModel = adviceModel;
        this.possibleTransitions = possibleTransitions == null ? null : Arrays.asList(possibleTransitions);
        this.buttons = buttons == null ? null : List.of(buttons);
    }

    private int getNextStateId(String userInput, boolean isRandom) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return isRandom ? possibleTransition.getRandomNextStateId() : possibleTransition.getNextStateId();
            }
        }

        return ERROR_STATE_ID;
    }

    /**
     * @param userInput команда от пользователя
     * @return следующее состояние, которое соотвествует команде пользователя. Если возможных вариантов несколько, то будет выбран первый
     */
    public int getNextStateId(String userInput) {
        return getNextStateId(userInput, false);
    }

    /**
     * @param userInput команда от пользователя
     * @return следующее состояние, которое соотвествует команде пользователя. Если возможных вариантов несколько, то будет выбран случайный
     */
    public int getRandomNextStateId(String userInput) {
        return getNextStateId(userInput, true);
    }

    public Answer getAnswer() {
        if (breathExerciseModel != null) {
            return breathExerciseModel.getRandomAdvice();
        }

        if (adviceModel != null) {
            return adviceModel.getRandomAdvice();
        }

        return answer;
    }

    @Nullable
    public AudioPlayer getAudioPlayer() {
        if (audio == null) {
            return null;
        }

        return audio.getAudioPlayer();
    }
}
