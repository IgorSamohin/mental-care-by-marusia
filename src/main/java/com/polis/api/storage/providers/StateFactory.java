package com.polis.api.storage.providers;

import com.polis.api.model.response.ResponseButton;
import com.polis.api.model.response.components.Command;
import com.polis.api.storage.MarusiaCommand;
import com.polis.api.storage.State;
import com.polis.api.storage.Transition;
import com.polis.api.storage.ZoneButtons;
import com.polis.api.storage.model.AdviceModel;
import com.polis.api.storage.model.Answer;
import com.polis.api.storage.model.AudioModel;
import com.polis.api.storage.model.BreathExerciseModel;
import com.polis.api.storage.model.VideoLinksModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateFactory {
    private final AudioProvider audioProvider;
    private final ButtonsProvider buttonsProvider;
    private final MarusiaAnswerProvider marusiaAnswerProvider;
    private final TransitionsProvider transitionsProvider;
    private final CommandsProvider commandsProvider;
    private final VideoProvider videoProvider;
    private final BreathExerciseProvider breathExerciseProvider;
    private final AdviceProvider adviceProvider;

    @Autowired
    private StateFactory(
            AudioProvider audioProvider,
            BreathExerciseProvider breathExerciseProvider,
            AdviceProvider adviceProvider,
            ButtonsProvider buttonsProvider,
            MarusiaAnswerProvider marusiaAnswerProvider,
            TransitionsProvider transitionsProvider,
            CommandsProvider commandsProvider,
            VideoProvider videoProvider) {
        this.audioProvider = audioProvider;
        this.breathExerciseProvider = breathExerciseProvider;
        this.adviceProvider = adviceProvider;
        this.buttonsProvider = buttonsProvider;
        this.marusiaAnswerProvider = marusiaAnswerProvider;
        this.transitionsProvider = transitionsProvider;
        this.commandsProvider = commandsProvider;
        this.videoProvider = videoProvider;
    }

    public State getState(int stateId) {
        Answer marusiaAnswer = marusiaAnswerProvider.getAnswer(stateId);
        Transition[] transitions = transitionsProvider.getTransitions(stateId);
        ResponseButton[] buttons = buttonsProvider.getButtons(stateId);
        AudioModel audio = audioProvider.getAudio(stateId);
        Command[] commands = commandsProvider.getCommands(stateId);
        BreathExerciseModel breathExerciseModel = breathExerciseProvider.getBreathExerciseModel(stateId);
        AdviceModel adviceModel = adviceProvider.getAdviceModel(stateId);
        VideoLinksModel videoLinks = videoProvider.getVideoLinks(stateId);

        if (marusiaAnswer.isRepeatable()) {
            Repeated repeated = addRepeat(stateId, buttons, transitions);
            transitions = repeated.transitions();
            buttons = repeated.buttons;
        }

        return new State(stateId, marusiaAnswer, transitions, buttons, commands, audio, breathExerciseModel,
                adviceModel, videoLinks);
    }

    record Repeated(Transition[] transitions, ResponseButton[] buttons) {
    }

    private Repeated addRepeat(int stateId, ResponseButton[] buttons, Transition[] transitions) {
        Transition[] tmpTransitions;
        if (transitions != null) {
            tmpTransitions = new Transition[transitions.length + 1];
            System.arraycopy(transitions, 0, tmpTransitions, 0, transitions.length);
        } else {
            tmpTransitions = new Transition[1];
        }
        tmpTransitions[tmpTransitions.length - 1] = new Transition(stateId, MarusiaCommand.MORE);

        ResponseButton[] tmpButtons;
        if (buttons != null) {
            tmpButtons = new ResponseButton[buttons.length + 1];
            System.arraycopy(buttons, 0, tmpButtons, 1, buttons.length);
        } else {
            tmpButtons = new ResponseButton[1];
        }
        tmpButtons[0] = new ResponseButton(ZoneButtons.REPEAT.getRandomButton());

        return new Repeated(tmpTransitions, tmpButtons);
    }
}
