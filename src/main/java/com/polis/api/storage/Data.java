package com.polis.api.storage;

import java.util.HashMap;
import java.util.Map;

public class Data {
    static final Map<Integer, State> states = new HashMap<>();

    static {
        states.put(
                -3, new State(-3, MarusiaAnswer.EXIT_ANSWER, new Transition[]{})
        );
        states.put(
                -2, new State(-2, MarusiaAnswer.ERROR_ANSWER, new Transition[]{})
        );
        states.put(
                -1, new State(-1, MarusiaAnswer.START_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(0, MarusiaCommand.DISTRACTION),
                        new Transition(1, MarusiaCommand.ADVICE),
                        new Transition(2, MarusiaCommand.HELP),
                        new Transition(10, MarusiaCommand.HELP_DISTRACTION),//TODO кажется тут не дб и снизу
                        new Transition(12, MarusiaCommand.HELP_SEDATION),//TODO
                        new Transition(13, MarusiaCommand.SEDATION),
                })
        );

        states.put(
                0, new State(0, MarusiaAnswer.DISTRACTION_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME),
                        new Transition(7, MarusiaCommand.DISTRACTION_YOGA),
                        new Transition(8, MarusiaCommand.DISTRACTION_NUMBER_DIVINATION),
                        new Transition(9, MarusiaCommand.DISTRACTION_COUNT)
                })
        );

        states.put(
                1, new State(1, MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME),
                })
        );

        states.put(
                2, new State(2, MarusiaAnswer.HELP_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME),
                        new Transition(10, MarusiaCommand.HELP_DISTRACTION),
                        new Transition(12, MarusiaCommand.HELP_SEDATION)
                })
        );

        states.put(
                3, new State(3, MarusiaAnswer.VIDEO_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );

        states.put(
                4, new State(4, MarusiaAnswer.SOOTHING_SOUND_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );

        states.put(
                5, new State(5, MarusiaAnswer.MUSIC_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );

        states.put(
                6, new State(6, MarusiaAnswer.BREATHING_EXERCISE_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );

        states.put(
                7, new State(7, MarusiaAnswer.YOGA_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );

        states.put(
                9, new State(9, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );
        states.put(10, new State(10, MarusiaAnswer.HELP_DISTRACTION_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );
        states.put(12, new State(12, MarusiaAnswer.HELP_SEDATION_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME)
                })
        );

        states.put(13, new State(13, MarusiaAnswer.SEDATION_ANSWER, new Transition[]{
                        new Transition(-3, MarusiaCommand.EXIT),
                        new Transition(-1, MarusiaCommand.HOME),
                        new Transition(3, MarusiaCommand.SEDATION_VIDEO),
                        new Transition(4, MarusiaCommand.SEDATION_SOUNDS),
                        new Transition(5, MarusiaCommand.SEDATION_MUSIC),
                        new Transition(6, MarusiaCommand.BREATH_EXERCISE)
                })
        );
    }

    private Data() {
    }
}
