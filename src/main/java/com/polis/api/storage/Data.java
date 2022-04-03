package com.polis.api.storage;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private static final String[] EXIT = new String[]{"пока", "выйди", "хочу выйти"};
    private static final String[] HOME = new String[]{"начало", "вернись в начало", "заново", "давай по новой"};

    public static final Map<Integer, State> states = new HashMap<>();

    static {
        states.put(
                -3, new State(-3, "Возвращайтесь в следующий раз", "Возвращайтесь в следующий раз", new Transition[]{})
        );
        states.put(
                -2, new State(-2, "Я вас не поняла. Попробуйте ещё раз", "Я вас не поняла. Попробуйте ещё раз", new Transition[]{})
        );
        states.put(
                -1, new State(-1, "Чем я могу вам помочь?", "Чем я могу вам помочь?", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(0, new String[]{"хочу отвлечься", "Давай отдохнём", "Отдых", "Релакс"}),
                        new Transition(1, new String[]{"дай совет", "совет"}),
                        new Transition(2, new String[]{"Что ты можешь", "Что ты умеешь", "Твои функции"}),
                        new Transition(10, new String[]{"отвлечь", "давай отвлечемся", "как ты можешь меня отвлечь?"}),
                        new Transition(12, new String[]{"успокоить", "успокой меня", "как ты можешь меня успокоить?"}),
                        new Transition(13, new String[]{"хочу успокоиться", "успокой меня", "успокоение", "успокой"}),
                })
        );

        states.put(
                0, new State(0, "Есть несколько вариантов отдыха. Могу скинуть вам информацию о йоге или можем погадать на числах. Что выберите?", "Есть несколько вариантов отдыха. Могу скинуть вам видео или можем погадать на числах. Что выберите?", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                        new Transition(7, new String[]{"Дай йогу", "йога", "Йогу", "Выбираю йогу"}),
                        new Transition(8, new String[]{"Гадание", "Гадание на числах", "Числа"}),
                        new Transition(9, new String[]{"задание на числа"})
                })
        );

        states.put(
                1, new State(1, "Вот вам совет от психолога", "Вот вам совет от психолога", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                })
        );

        states.put(
                2, new State(2, "Я могу: помочь отдохнуть, дать совет, скинуть видео, включить успокаивающую музыку, включить дыхательную гимнастику, могу отвлечь, а так же могу успокоить!", "Я могу: помочь отдохнуть, дать совет, скинуть видео, включить успокаивающую музыку, включить дыхательную гимнастику, могу отвлечь, а так же могу успокоить!", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                        new Transition(10, new String[]{"как ты можешь отвлечь", "отвлечение"}),
                        new Transition(12, new String[]{"как ты можешь успокоить", "успокоение"})
                })
        );

        states.put(
                3, new State(3, "Посмотрите это видео", "Посмотрите это видео", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                4, new State(4, "Включаю успокаивающие звуки", "Включаю успокаивающие звуки", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                5, new State(5, "Включаю музыку", "Включаю музыку", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                6, new State(6, "Попробуйте выполнить это дыхательное упражнение", "Попробуйте выполнить это дыхательное упражнение", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                7, new State(7, "Смотрите что я вам нашла", "Смотрите что я вам нашла", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(
                9, new State(9, "Давайте погадаем!", "Давайте погадаем!", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );
        states.put(10, new State(10, "Я могу поиграть с вами в загадывание чисел, посчитать числа вместе с вами, скинуть отвлекающее видео", "Я могу поиграть с вами в загадывание чисел, посчитать числа вместе с вами, скинуть отвлекающее видео", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );
        states.put(12, new State(12, "Я могу скинуть вам успокаивающее видео, включить звуки природы, включить успокаивающую музыку, или скинуть дыхательное упражнение", "Я могу скинуть вам успокаивающее видео, включить звуки природы, включить успокаивающую музыку, или скинуть дыхательное упражнение", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME)
                })
        );

        states.put(13, new State(13, "Есть несколько вариантов успокоения и расслабления. Я могу скинуть вам успокаивающее видео, включить звуки природы, включить успокаивающую музыку, или скинуть дыхательное упражнение", "Я могу скинуть вам успокаивающее видео, включить звуки природы, включить успокаивающую музыку, или скинуть дыхательное упражнение", new Transition[]{
                        new Transition(-3, EXIT),
                        new Transition(-1, HOME),
                        new Transition(3, new String[]{"Скинь видос", "Скинь видео", "Видео"}),
                        new Transition(4, new String[]{"Включи успокаивающие звуки", "успокаивающие звуки", "спокойные звуки"}),
                        new Transition(5, new String[]{"Включи успокаивающую музыку"}),
                        new Transition(6, new String[]{"Давай подышим", "Давай пыхнем", "Дыхательная гимнастика", "Дышать", "Вздох"})
                })
        );
    }

    private Data() {
    }
}
