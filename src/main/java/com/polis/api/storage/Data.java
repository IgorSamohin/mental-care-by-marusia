package com.polis.api.storage;

import java.util.Map;

public class Data {
    public static final String GIVE_SMTH_ELSE = "давай что-то еще";
    public static final String SMTH_ELSE = "еще";

    public static Map<Integer, State> states = Map.of(
            -3, new State(-3, "Возвращайтесь в следующий раз", "Возвращайтесь в следующий раз", new Transition[]{}),
            -2, new State(-2, "Я вас не поняла. Попробуйте ещё раз", "Я вас не поняла. Попробуйте ещё раз", new Transition[]{}),
            -1, new State(-1, "Чем я могу вам помочь?", "Чем я могу вам помочь?", new Transition[]{
                    new Transition(0, new String[]{"хочу отвлечься", "Давай отдохнём", "Отдых", "Релакс"}),
                    new Transition(1, new String[]{"дай совет", "совет"}),
                    new Transition(2, new String[]{"Что ты можешь"}),
                    new Transition(3, new String[]{"Скинь видос", "Скинь видео", "Видео"}),
                    new Transition(4, new String[]{"Включи успокаивающие звуки", "успокаивающие звуки", "спокойные звуки"}),
                    new Transition(5, new String[]{"Включи успокаивающую музыку"}),
                    new Transition(6, new String[]{"Давай подышим", "Давай пыхнем", "Дыхательная гимнастика", "Дышать", "Вздох"})}),
            0, new State(0, "Есть несколько вариантов отдыха. Могу скинуть вам информацию о йоге или можем погадать на числах. Что выберите?", "Есть несколько вариантов отдыха. Могу скинуть вам видео или можем погадать на числах. Что выберите?", new Transition[]{
                    new Transition(7, new String[]{"Дай йогу", "йога", "Йогу", "Выбираю йогу"}),
                    new Transition(8, new String[]{"Гадание", "Гадание на числах", "Числа"})}),
            1, new State(1, "Вот вам совет от психолога", "Вот вам совет от психолога", new Transition[]{
                    new Transition(-1, new String[]{GIVE_SMTH_ELSE, SMTH_ELSE})
            }),

            2, new State(2, "Я могу вас отвлечь или успокоить", "Я могу вас отвлечь или успокоить", new Transition[]{
                    new Transition(10, new String[]{"давай отвлечемся", "как ты можешь меня отвлечь?"}),
                    new Transition(12, new String[]{"успокой меня", "как ты можешь меня успокоить?"})
            }),
            7, new State(7, "Смотрите что я вам нашла", "Смотрите что я вам нашла", new Transition[]{
                    new Transition(-1, new String[]{"Давай что-то ещё", "Ещё"})}),
            9, new State(9, "Давайте погадаем!", "Давайте погадаем!", new Transition[]{
                    new Transition(-1, new String[]{"Давай что-то ещё", "Ещё"})}),
            10, new State(10, "Я могу поиграть с вами в загадывание чисел, посчитать числа вместе с вами, скинуть отвлекающее видео", "Я могу поиграть с вами в загадывание чисел, посчитать числа вместе с вами, скинуть отвлекающее видео", new Transition[]{
                    new Transition(-1, new String[]{GIVE_SMTH_ELSE, SMTH_ELSE})
            }),
            12, new State(12, "Я могу скинуть вам успокаивающее видео, включить звуки природы, включить успокаиющую музыку, или скинуть дыхательное упражнение", "", new Transition[]{
                    new Transition(-1, new String[]{GIVE_SMTH_ELSE, SMTH_ELSE})
            })
    );
}
