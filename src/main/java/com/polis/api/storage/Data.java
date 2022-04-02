package com.polis.api.storage;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private static final String[] EXIT = new String[]{"пока", "выйди", "хочу выйти", "стоп", "все", "хватит"};
    private static final String[] HOME = new String[]{"начало", "вернись в начало", "заново", "давай по новой"};

    public static final Map<Integer, State> states = new HashMap<>();

    static {
        states.put(
                -3, new State(-3, MarusiaAnswer.EXIT_ANSWER.text, MarusiaAnswer.EXIT_ANSWER.tts, new Transition[]{})
        );
        states.put(
                -2, new State(-2, MarusiaAnswer.ERROR_ANSWER.text, MarusiaAnswer.ERROR_ANSWER.tts, new Transition[]{})
        );
        states.put(
                -1, new State(-1, MarusiaAnswer.START_STATE_ANSWER.text, MarusiaAnswer.START_STATE_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(0, new String[]{"хочу отвлечься", "Давай отдохнём", "Отдых", "Релакс", "отвлечение", "отвлеки"}),
                        new Transition(1, new String[]{"дай совет", "совет"}),
                        new Transition(2, new String[]{"Что ты можешь", "Что ты умеешь", "Твои функции", "помощь", "помоги"}),
                        new Transition(10, new String[]{"как ты можешь меня отвлечь?"}),
                        new Transition(12, new String[]{"как ты можешь меня успокоить?"}),
                        new Transition(13, new String[]{"хочу успокоиться", "успокой меня", "успокоение", "успокой"}),
                })
        );

        states.put(
                0, new State(0, MarusiaAnswer.DISTRACTION_STATE_ANSWER.text, MarusiaAnswer.DISTRACTION_STATE_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                        new Transition(7, new String[]{"Дай йогу", "йога", "Йогу", "Выбираю йогу"}),
                        new Transition(8, new String[]{"Гадание", "Гадание на числах"}),
                        new Transition(9, new String[]{"задание на числа", "давай поиграем", "числа", "играть"})
                })
        );

        states.put(
                1, new State(1, MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER.text, MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                })
        );

        states.put(
                2, new State(2, MarusiaAnswer.HELP_ANSWER.text, MarusiaAnswer.HELP_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                        new Transition(10, new String[]{"как ты можешь отвлечь", "отвлечение"}),
                        new Transition(12, new String[]{"как ты можешь успокоить", "успокоение"})
                })
        );

        states.put(
                3, new State(3, MarusiaAnswer.VIDEO_ANSWER.text, MarusiaAnswer.VIDEO_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                4, new State(4, MarusiaAnswer.SOOTHING_SOUND_ANSWER.text, MarusiaAnswer.SOOTHING_SOUND_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                5, new State(5, MarusiaAnswer.MUSIC_ANSWER.text, MarusiaAnswer.MUSIC_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                6, new State(6, MarusiaAnswer.BREATHING_EXERCISE_ANSWER.text, MarusiaAnswer.BREATHING_EXERCISE_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                7, new State(7, MarusiaAnswer.YOGA_ANSWER.text, MarusiaAnswer.YOGA_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                9, new State(9, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER.text, MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );
        states.put(10, new State(10, MarusiaAnswer.DISTRACTION_HELP_ANSWER.text, MarusiaAnswer.DISTRACTION_HELP_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );
        states.put(12, new State(12, MarusiaAnswer.SEDATION_HELP_ANSWER.text, MarusiaAnswer.SEDATION_HELP_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(13, new State(13, MarusiaAnswer.SEDATION_STATE_ANSWER.text, MarusiaAnswer.SEDATION_STATE_ANSWER.tts, new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                        new Transition(3, new String[]{"Скинь видос", "Скинь видео", "Видео", "видос"}),
                        new Transition(4, new String[]{"Включи успокаивающие звуки", "успокаивающие звуки", "спокойные звуки", "звуки"}),
                        new Transition(5, new String[]{"Включи успокаивающую музыку", "музыка"}),
                        new Transition(6, new String[]{"Давай подышим", "Давай пыхнем", "Дыхательная гимнастика", "Дышать", "Вздох"})
                })
        );
    }

    private Data() {
    }
}
