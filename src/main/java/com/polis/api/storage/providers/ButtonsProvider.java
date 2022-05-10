package com.polis.api.storage.providers;

import com.polis.api.model.response.ResponseButton;
import com.polis.api.storage.ZoneButtons;
import com.polis.api.storage.model.ButtonsModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
class ButtonsProvider {
    private final Map<Integer, ButtonsModel> map = new HashMap<>();

    /**
     * Возвращает кнопки для состояния с заданным id или null, если кнопок нет.
     */
    public ResponseButton[] getButtons(int stateId) {
        ButtonsModel buttons = map.get(stateId);
        return buttons == null ? null : buttons.buttons();
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(-4, new ButtonsModel(ZoneButtons.DEFAULT));     //начало, но не старт
        map.put(-3, null);     //выход
        map.put(-2, new ButtonsModel(ZoneButtons.DEFAULT));     //ошибка
        map.put(-1, new ButtonsModel(ZoneButtons.START));       //старт (приветствие)
        map.put(1, new ButtonsModel(ZoneButtons.DEFAULT));      //совет
        map.put(2, new ButtonsModel(ZoneButtons.MAIN_HELP));  //помощь
        map.put(3, new ButtonsModel(ZoneButtons.SEDATION));     //успокаивающее видео
        map.put(4, new ButtonsModel(ZoneButtons.SEDATION));     //успокаивающие звуки
        map.put(5, new ButtonsModel(ZoneButtons.SEDATION));     //успокаивающая музыка
        map.put(6, new ButtonsModel(ZoneButtons.SEDATION));     //дыхательное упражнение
        map.put(7, new ButtonsModel(ZoneButtons.DISTRACTION));  //йога
        map.put(9, new ButtonsModel(ZoneButtons.DISTRACTION));  //счет чисел (выкл)
        map.put(10, new ButtonsModel(ZoneButtons.DISTRACTION)); //помощь отвл
        map.put(12, new ButtonsModel(ZoneButtons.SEDATION));    //помощь успокоение
        map.put(13, new ButtonsModel(ZoneButtons.COMMON_HELP)); //помощь отвл + успокоение
    }
}
