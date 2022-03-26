package com.polis.api.storage;

import java.util.Map;

public class Data {
    public static final String GIVE_SMTH_ELSE = "давай что-то еще";
    public static final String SMTH_ELSE = "еще";

    public static Map<Integer, State> states = Map.of(
            -1, new State(),//default state
            //текущее 1, новое со стейтом -1
            1, new State(1, "Вот вам совет от психолога", "Вот вам совет от психолога", new Transition[]{
                    new Transition(-1, new String[]{GIVE_SMTH_ELSE, SMTH_ELSE})
            }),

            2, new State(2, "Я могу вас отвлечь или успокоить", "Я могу вас отвлечь или успокоить", new Transition[]{
                    new Transition(10, new String[]{"давай отвлечемся", "как ты можешь меня отвлечь?"}),
                    new Transition(12, new String[]{"успокой меня", "как ты можешь меня успокоить?"})
            }),
            10, new State(10, "Я могу поиграть с вами в загадывание чисел, посчитать числа вместе с вами, скинуть отвлекающее видео", "Я могу поиграть с вами в загадывание чисел, посчитать числа вместе с вами, скинуть отвлекающее видео", new Transition[]{
                    new Transition(-1, new String[]{GIVE_SMTH_ELSE, SMTH_ELSE})
            }),
            12, new State(12, "Я могу скинуть вам успокаивающее видео, включить звуки природы, включить успокаиющую музыку, или скинуть дыхательное упражнение", "", new Transition[]{
                    new Transition(-1, new String[]{GIVE_SMTH_ELSE, SMTH_ELSE})
            })


    );
}
