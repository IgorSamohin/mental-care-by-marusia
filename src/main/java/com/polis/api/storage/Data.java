package com.polis.api.storage;

import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.audio.AudioPlayer;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public static final AudioPlayer TEST_AUDIO_PLAYER = new AudioPlayer(new String[]{"2000512010_456239028"});
    public static final int TEST_ID = Integer.MIN_VALUE;

    static final Map<Integer, State> states = new HashMap<>();

    private static final Transition[] allTransitions = new Transition[]{
            new Transition(-4, MarusiaCommand.HOME),
            new Transition(-3, MarusiaCommand.EXIT),
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
            new Transition(TEST_ID, MarusiaCommand.TEST),

            new Transition(new int[]{3, 4, 5, 6}, MarusiaCommand.SEDATION),
            new Transition(new int[]{3, 4, 5, 6}, MarusiaCommand.DISTRACTION)
    };

    private static final Transition[] emptyTransitions = new Transition[]{};

    //FIXME
    static {
        states.put(TEST_ID, new State(TEST_ID, MarusiaAnswer.TEST_ANSWER, new Transition[]{}, new Command[]{},
                TEST_AUDIO_PLAYER)
        );
        states.put(-4, new State(-4, MarusiaAnswer.HOME_ANSWER, allTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(-3, new State(-3, MarusiaAnswer.EXIT_ANSWER, emptyTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(-2, new State(-2, MarusiaAnswer.ERROR_ANSWER, allTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(-1, new State(-1, MarusiaAnswer.START_ANSWER, allTransitions, ZoneButtons.DEFAULT.buttons, false));
        states.put(1, new State(1, MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER, allTransitions, ZoneButtons.DEFAULT.buttons, true));
        states.put(2, new State(2, MarusiaAnswer.HELP_ANSWER, allTransitions, ZoneButtons.DEFAULT.buttons, true));
        states.put(3, new State(3, MarusiaAnswer.VIDEO_ANSWER, allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(4, new State(4, MarusiaAnswer.SOOTHING_SOUND_ANSWER, allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(5, new State(5, MarusiaAnswer.MUSIC_ANSWER, allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(6, new State(6, MarusiaAnswer.BREATHING_EXERCISE_ANSWER, allTransitions, ZoneButtons.SEDATION.buttons, true));
        states.put(7, new State(7, MarusiaAnswer.YOGA_ANSWER, allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(9, new State(9, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER, allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(10, new State(10, MarusiaAnswer.HELP_DISTRACTION_ANSWER, allTransitions, ZoneButtons.DISTRACTION.buttons, true));
        states.put(12, new State(12, MarusiaAnswer.HELP_SEDATION_ANSWER, allTransitions, ZoneButtons.SEDATION.buttons, true));
    }

    private Data() {
    }
}
