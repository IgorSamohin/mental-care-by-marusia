package com.polis.api.storage.providers;

import com.polis.api.storage.MarusiaCommand;
import com.polis.api.storage.Transition;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransitionsProvider {
    private final Map<Integer, Transition[]> map = new HashMap<>();

    /**
     * Возвращает id всех состояний, достижимых из данного состояния id состояния.
     */
    public Transition[] getTransitions(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************
    public static final int TEST_ID = Integer.MIN_VALUE;

    private final Transition[] allTransitions = new Transition[]{
            new Transition(-4, MarusiaCommand.HOME),
            new Transition(-3, MarusiaCommand.EXIT),
            new Transition(-1, MarusiaCommand.START),

            new Transition(1, MarusiaCommand.ADVICE),
            new Transition(2, MarusiaCommand.HELP),
            new Transition(3, MarusiaCommand.SEDATION_VIDEO),
            new Transition(4, MarusiaCommand.SEDATION_SOUNDS),
            new Transition(5, MarusiaCommand.SEDATION_MUSIC),
            new Transition(6, MarusiaCommand.BREATH_EXERCISE),
            new Transition(7, MarusiaCommand.DISTRACTION_YOGA),
            new Transition(8, MarusiaCommand.DISTRACTION_NUMBER_DIVINATION),
            new Transition(9, MarusiaCommand.DISTRACTION_COUNT),
            new Transition(10, MarusiaCommand.HELP_DISTRACTION),
            new Transition(12, MarusiaCommand.HELP_SEDATION),
            new Transition(13, MarusiaCommand.HELP_SEDATION_AND_DISTRACTION),

            new Transition(new int[]{3, 4, 5, 6}, MarusiaCommand.SEDATION),
            new Transition(new int[]{3, 4, 5, 6}, MarusiaCommand.DISTRACTION),
            new Transition(new int[]{1, 3, 4, 5, 6, 7, 9}, MarusiaCommand.MEGA_COMMAND)
    };


    @PostConstruct
    private void init() {
        map.put(-4, allTransitions);        //начало, но не старт
        map.put(-3, new Transition[]{});    //выход
        map.put(-2, allTransitions);        //ошибка
        map.put(-1, allTransitions);        //старт (приветствие)
        map.put(1, allTransitions);         //совет
        map.put(2, allTransitions);         //помощь
        map.put(3, allTransitions);         //успокаивающее видео
        map.put(4, allTransitions);         //успокаивающие звуки
        map.put(5, allTransitions);         //успокаивающая музыка
        map.put(6, allTransitions);         //дыхательное упражнение
        map.put(7, allTransitions);         //йога
        map.put(8, new Transition[]{
                new Transition(-4, MarusiaCommand.GAME_CANCEL),
                new Transition(14, MarusiaCommand.GAME_START)
        });
        map.put(9, new Transition[]{
                new Transition(-4, MarusiaCommand.STOP_GAME)
        });         //счет чисел
        map.put(10, allTransitions);        //помощь отвл
        map.put(12, allTransitions);        //помощь успокоение
        map.put(13, allTransitions);        //помощь отвл + успокоение
        map.put(14, new Transition[]{
                new Transition(-4, MarusiaCommand.STOP_GAME)
        }); //гадание чисел
    }
}
