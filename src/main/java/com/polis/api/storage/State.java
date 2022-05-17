package com.polis.api.storage;

import com.polis.api.model.response.ResponseButton;
import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.widgets.Link;
import com.polis.api.storage.model.AdviceModel;
import com.polis.api.storage.model.Answer;
import com.polis.api.storage.model.AudioModel;
import com.polis.api.storage.model.BreathExerciseModel;
import com.polis.api.storage.model.VideoLinksModel;
import com.polis.api.storage.model.YogaModel;
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
    public static final int HOME_STATE_ID = -4;

    public static final int COUNT_GAME_STATE_ID = 9;
    public static final int GUESS_GAME_STATE_ID = 14;
    public static final int MENU_ID = 2;

    @Getter
    private int id;

    private Answer answer;
    @Getter
    private List<Transition> possibleTransitions;
    @Getter
    protected List<ResponseButton> buttons;
    @Getter
    private List<Command> commands;
    private AudioPlayer audioPlayer;
    @Getter
    private VideoLinksModel videoLinks;
    @Getter
    private boolean isRepeatable;
    private AudioModel audio;
    private BreathExerciseModel breathExerciseModel;
    private AdviceModel adviceModel;
    private YogaModel yogaModel;

    public State(
            int id,
            Answer answer,
            @Nullable Transition[] possibleTransitions,
            @Nullable ResponseButton[] buttons,
            @Nullable Command[] commands,
            @Nullable AudioModel audio,
            @Nullable BreathExerciseModel breathExerciseModel,
            @Nullable AdviceModel adviceModel,
            @Nullable VideoLinksModel videoLinksModel,
            @Nullable YogaModel yogaModel
    ) {
        this.id = id;
        this.answer = answer;
        this.commands = commands == null ? new ArrayList<>() : List.of(commands);
        this.audio = audio;
        this.breathExerciseModel = breathExerciseModel;
        this.adviceModel = adviceModel;
        this.videoLinks = videoLinksModel;
        this.yogaModel = yogaModel;
        this.possibleTransitions = possibleTransitions == null ? null : Arrays.asList(possibleTransitions);
        this.buttons = buttons == null ? null : List.of(buttons);
    }

    protected State(int id, Answer answer, List<Transition> possibleTransitions, List<ResponseButton> buttons) {
        this.id = id;
        this.answer = answer;
        this.possibleTransitions = possibleTransitions;
        this.buttons = buttons;
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
            return breathExerciseModel.getRandomExercise();
        }

        if (adviceModel != null) {
            return adviceModel.getRandomAdvice();
        }

        if (videoLinks != null) {
            Link link = videoLinks.getRandomVideoLink();
            return new Answer(answer.text() + link.getUrl(), answer.tts(), answer.stubText(), answer.stubTts(), answer.isRepeatable());
        }

        if (yogaModel != null) {
            return yogaModel.getRandomYoga();
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

    public Link getLink() {
        if (videoLinks != null) {
            return videoLinks.getRandomVideoLink();
        }

        return null;
    }
}
