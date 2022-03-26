package com.polis.api.storage;

import java.util.Map;

public class Data {
    public static Map<Integer, State> states = Map.of(
        -3, new State(
            -1,
            "Возвращайтесь в следующий раз",
            "Возвращайтесь в следующий раз",
            new Transition[]{}),
        -2, new State(
            -1,
            "Я вас не поняла. Попробуйте ещё раз",
            "Я вас не поняла. Попробуйте ещё раз",
            new Transition[]{}),
        -1, new State(
            -1,
            "Ваш личный психолог к вашим услугам. Чего вы хотите?",
            "Ваш личный психолог к вашим услугам. Чего вы хотите?",
            new Transition[]{
                new Transition(0, new String[]{"Хочу отвлечься", "Давай отдохнём", "Отдых", "Релакс"}),
                new Transition(1, new String[]{"Дай совет", "Совет"}),
                new Transition(2, new String[]{"Что ты можешь"}),
                new Transition(3, new String[]{"Скинь видос", "Скинь видео", "Видео"}),
                new Transition(4, new String[]{"Включи успокаивающие звуки", "успокаивающие звуки", "спокойные звуки"}),
                new Transition(5, new String[]{"Включи успокаивающую музыку"}),
                new Transition(6, new String[]{"Давай подышим", "Давай пыхнем", "Дыхательная гимнастика", "Дышать", "Вздох"})}),
        1, new State(),
        2, new State()
    );
}
