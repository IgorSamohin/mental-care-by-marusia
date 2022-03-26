package com.polis.api.storage;

import java.util.Map;

public class Data {
    public static Map<Integer, State> states = Map.of(
        -3, new State(
            -3,
            "Возвращайтесь в следующий раз",
            "Возвращайтесь в следующий раз",
            new Transition[]{}),
        -2, new State(
            -2,
            "Я вас не поняла. Попробуйте ещё раз",
            "Я вас не поняла. Попробуйте ещё раз",
            new Transition[]{}),
        -1, new State(
            -1,
            "Чем я могу вам помочь?",
            "Чем я могу вам помочь?",
            new Transition[]{
                new Transition(0, new String[]{"Хочу отвлечься", "Давай отдохнём", "Отдых", "Релакс"}),
                new Transition(1, new String[]{"Дай совет", "Совет"}),
                new Transition(2, new String[]{"Что ты можешь"}),
                new Transition(3, new String[]{"Скинь видос", "Скинь видео", "Видео"}),
                new Transition(4, new String[]{"Включи успокаивающие звуки", "успокаивающие звуки", "спокойные звуки"}),
                new Transition(5, new String[]{"Включи успокаивающую музыку"}),
                new Transition(6, new String[]{"Давай подышим", "Давай пыхнем", "Дыхательная гимнастика", "Дышать", "Вздох"})}),
        0, new State(
            0,
            "Есть несколько вариантов отдыха. Могу скинуть вам информацию о йоге или можем погадать на числах. Что выберите?",
            "Есть несколько вариантов отдыха. Могу скинуть вам видео или можем погадать на числах. Что выберите?",
            new Transition[]{
                new Transition(7, new String[]{"Дай йогу", "Йога", "Йогу", "Выбираю йогу"}),
                new Transition(8, new String[]{"Гадание", "Гадание на числах", "Числа"})}),
        1, new State(),
        2, new State(),
        7, new State(
            7,
            "Смотрите что я вам нашла",
            "Смотрите что я вам нашла",
            new Transition[]{
                new Transition(-1, new String[]{"Давай что-то ещё", "Ещё"})}),
        9, new State(
            9,
            "Давайте погадаем!",
            "Давайте погадаем!",
            new Transition[]{
                new Transition(-1, new String[]{"Давай что-то ещё", "Ещё"})})
    );
}
