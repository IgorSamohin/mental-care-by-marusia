package com.polis.api.storage;

import com.polis.api.storage.answer.MultipleAnswer;
import com.polis.api.storage.answer.SingleAnswer;

import java.util.HashMap;
import java.util.Map;


//TODO еще добавить, разобраться с блоком команд, где рандомиться, отрефакторить
public class Data {
    static final Map<Integer, State> states = new HashMap<>();
    private static final Transition[] allTransitions = new Transition[]{
            new Transition(-3, MarusiaCommand.EXIT),
            new Transition(-4, MarusiaCommand.HOME),
            new Transition(0, MarusiaCommand.DISTRACTION),
            new Transition(1, MarusiaCommand.ADVICE),
            new Transition(2, MarusiaCommand.HELP),
            new Transition(3, MarusiaCommand.SEDATION_VIDEO),
            new Transition(4, MarusiaCommand.SEDATION_SOUNDS),
            new Transition(5, MarusiaCommand.SEDATION_MUSIC),
            new Transition(6, MarusiaCommand.BREATH_EXERCISE),
            new Transition(7, MarusiaCommand.DISTRACTION_YOGA),
//                new Transition(8, MarusiaCommand.DISTRACTION_NUMBER_DIVINATION),
            new Transition(9, MarusiaCommand.DISTRACTION_COUNT),
            new Transition(10, MarusiaCommand.HELP_DISTRACTION),
            new Transition(12, MarusiaCommand.HELP_SEDATION),
            new Transition(13, MarusiaCommand.SEDATION)
    };

    //FIXME
    static {
        states.put(-3, new State(-3, new SingleAnswer(MarusiaAnswer.EXIT_ANSWER), allTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(-2, new State(-2, new SingleAnswer(MarusiaAnswer.ERROR_ANSWER), allTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(-1, new State(-1, new SingleAnswer(MarusiaAnswer.START_ANSWER), allTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(-4, new State(-4, new SingleAnswer(MarusiaAnswer.HOME_ANSWER), allTransitions, ZoneButtons.DEFAULT.buttons, false));

        states.put(0, new State(0, new MultipleAnswer(MarusiaAnswer.YOGA_ANSWER, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER), allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(1, new State(1, new SingleAnswer(MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER), allTransitions, ZoneButtons.DEFAULT.buttons, true));
        states.put(2, new State(2, new SingleAnswer(MarusiaAnswer.HELP_ANSWER), allTransitions, ZoneButtons.DEFAULT.buttons, true));
        states.put(3, new State(3, new SingleAnswer(MarusiaAnswer.VIDEO_ANSWER), allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(4, new State(4, new SingleAnswer(MarusiaAnswer.SOOTHING_SOUND_ANSWER), allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(5, new State(5, new SingleAnswer(MarusiaAnswer.MUSIC_ANSWER), allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(6, new State(6, new SingleAnswer(MarusiaAnswer.BREATHING_EXERCISE_ANSWER), allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(7, new State(7, new SingleAnswer(MarusiaAnswer.YOGA_ANSWER), allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(9, new State(9, new SingleAnswer(MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER), allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(10, new State(10, new SingleAnswer(MarusiaAnswer.HELP_DISTRACTION_ANSWER), allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(12, new State(12, new SingleAnswer(MarusiaAnswer.HELP_SEDATION_ANSWER), allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(13, new State(13, new MultipleAnswer(MarusiaAnswer.VIDEO_ANSWER, MarusiaAnswer.MUSIC_ANSWER,
                MarusiaAnswer.BREATHING_EXERCISE_ANSWER, MarusiaAnswer.SOOTHING_SOUND_ANSWER), allTransitions, ZoneButtons.SEDATION.buttons, true));
    }

    private Data() {
    }
}
