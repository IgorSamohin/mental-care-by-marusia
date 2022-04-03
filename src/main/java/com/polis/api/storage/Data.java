package com.polis.api.storage;

import com.polis.api.Command;

import java.util.HashMap;
import java.util.Map;

public class Data {
    static final Map<Integer, State> states = new HashMap<>();

    static {
        states.put(
                -3, new State(-3, MarusiaAnswer.EXIT_ANSWER.text, MarusiaAnswer.EXIT_ANSWER.tts, new Transition[]{})
        );
        states.put(
                -2, new State(-2, MarusiaAnswer.ERROR_ANSWER.text, MarusiaAnswer.ERROR_ANSWER.tts, new Transition[]{})
        );
        states.put(
                -1, new State(-1, MarusiaAnswer.START_STATE_ANSWER.text, MarusiaAnswer.START_STATE_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(0, Command.DISTRACTION.commands),
                        new Transition(1, Command.ADVICE.commands),
                        new Transition(2, Command.HELP.commands),
                        new Transition(10, Command.HELP_DISTRACTION.commands),//TODO кажется тут не дб и снизу
                        new Transition(12, Command.HELP_SEDATION.commands),//TODO
                        new Transition(13, Command.SEDATION.commands),
                })
        );

        states.put(
                0, new State(0, MarusiaAnswer.DISTRACTION_STATE_ANSWER.text, MarusiaAnswer.DISTRACTION_STATE_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands),
                        new Transition(7, Command.DISTRACTION_YOGA.commands),
                        new Transition(8, Command.DISTRACTION_NUMBER_DIVINATION.commands),
                        new Transition(9, Command.DISTRACTION_COUNT.commands)
                })
        );

        states.put(
                1, new State(1, MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER.text, MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands),
                })
        );

        states.put(
                2, new State(2, MarusiaAnswer.HELP_ANSWER.text, MarusiaAnswer.HELP_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands),
                        new Transition(10, Command.HELP_DISTRACTION.commands),
                        new Transition(12, Command.HELP_SEDATION.commands)
                })
        );

        states.put(
                3, new State(3, MarusiaAnswer.VIDEO_ANSWER.text, MarusiaAnswer.VIDEO_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );

        states.put(
                4, new State(4, MarusiaAnswer.SOOTHING_SOUND_ANSWER.text, MarusiaAnswer.SOOTHING_SOUND_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );

        states.put(
                5, new State(5, MarusiaAnswer.MUSIC_ANSWER.text, MarusiaAnswer.MUSIC_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );

        states.put(
                6, new State(6, MarusiaAnswer.BREATHING_EXERCISE_ANSWER.text, MarusiaAnswer.BREATHING_EXERCISE_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );

        states.put(
                7, new State(7, MarusiaAnswer.YOGA_ANSWER.text, MarusiaAnswer.YOGA_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );

        states.put(
                9, new State(9, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER.text, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );
        states.put(10, new State(10, MarusiaAnswer.HELP_DISTRACTION_ANSWER.text, MarusiaAnswer.HELP_DISTRACTION_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );
        states.put(12, new State(12, MarusiaAnswer.HELP_SEDATION_ANSWER.text, MarusiaAnswer.HELP_SEDATION_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands)
                })
        );

        states.put(13, new State(13, MarusiaAnswer.SEDATION_STATE_ANSWER.text, MarusiaAnswer.SEDATION_STATE_ANSWER.tts, new Transition[]{
                        new Transition(-3, Command.EXIT.commands),
                        new Transition(-1, Command.HOME.commands),
                        new Transition(3, Command.SEDATION_VIDEO.commands),
                        new Transition(4, Command.SEDATION_SOUNDS.commands),
                        new Transition(5, Command.SEDATION_MUSIC.commands),
                        new Transition(6, Command.BREATH_EXERCISE.commands)
                })
        );
    }

    private Data() {
    }
}
