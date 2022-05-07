package com.polis.api.storage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polis.api.model.response.ResponseButton;
import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.widgets.Card;
import com.polis.api.model.response.components.widgets.Link;
import com.polis.api.storage.model.VideoLinksModel;
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
    private String text;
    private String tts;
    private String stubText;
    private String stubTts;
    @Getter
    private List<Transition> possibleTransitions;
    @Getter
    private List<ResponseButton> buttons;
    @Getter
    private List<Command> commands;
    @Getter
    private AudioPlayer audioPlayer;
    @Getter
    private VideoLinksModel videoLinks;
    @Getter
    private boolean isRepeatable;

    public State(
            int id,
            String text,
            String tts,
            String stubText,
            String stubTts,
            @Nullable Transition[] possibleTransitions,
            @Nullable ResponseButton[] buttons,
            @Nullable Command[] commands,
            @Nullable AudioPlayer audioPlayer,
            @Nullable VideoLinksModel videoLinksModel,
            boolean isRepeatable
    ) {
        this.id = id;
        this.text = text;
        this.tts = tts;
        this.stubText = stubText == null ? text : stubText;
        this.stubTts = stubTts == null ? tts : stubTts;
        this.commands = commands == null ? new ArrayList<>() : List.of(commands);
        this.audioPlayer = audioPlayer;
        this.videoLinks = videoLinksModel;
        this.isRepeatable = isRepeatable;
        this.possibleTransitions = possibleTransitions == null ? null : Arrays.asList(possibleTransitions);
        this.buttons = buttons == null ? null : List.of(buttons);
    }

    public State(int id,
                 MarusiaAnswer marusiaAnswer,
                 @Nullable Transition[] possibleTransitions,
                 @Nullable String[] buttons,
                 @Nullable Command[] commands,
                 @Nullable AudioPlayer audioPlayer,
                 @Nullable VideoLinksModel videoLinksModel,
                 boolean isRepeatable
    ) {
        this(id, marusiaAnswer.text, marusiaAnswer.tts, marusiaAnswer.stubText, marusiaAnswer.stubTts, possibleTransitions,
                buttons == null ? null : (ResponseButton[]) Arrays.stream(buttons).map(ResponseButton::new).toArray(),
                commands, audioPlayer, videoLinksModel, isRepeatable);
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

    public String getText() {
        if (hasProblems()) {
            return stubText;
        }
        if (videoLinks != null) {
            Link link = (Link) videoLinks.getRandomVideoLink().getItem();
            return text + link.getUrl();
        }
        return text;
    }

    public String getTts() {
        if (hasProblems()) {
            return stubTts;
        }
        return tts;
    }

    private boolean hasProblems() {
        return audioPlayer != null && audioPlayer.isEmpty();
    }

    public Card getCard() {
        if (videoLinks != null) {
            return videoLinks.getRandomVideoLink();
        }

        return null;
    }
}
