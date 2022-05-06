package com.polis.api.storage.providers;

import com.polis.api.storage.MarusiaAnswer;
import com.polis.api.storage.model.MarusiaAnswerModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
class MarusiaAnswerProvider {
    private final Map<Integer, MarusiaAnswerModel> map = new HashMap<>();

    /**
     * Возвращает ответ для состояния с заданным id или null, если ответа нет.
     */
    public MarusiaAnswerModel getAnswer(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(-4, new MarusiaAnswerModel(MarusiaAnswer.HOME_ANSWER, false));
        map.put(-3, new MarusiaAnswerModel(MarusiaAnswer.EXIT_ANSWER, false));
        map.put(-2, new MarusiaAnswerModel(MarusiaAnswer.ERROR_ANSWER, false));
        map.put(-1, new MarusiaAnswerModel(MarusiaAnswer.START_ANSWER, false));
        map.put(1, new MarusiaAnswerModel(MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER, true));
        map.put(2, new MarusiaAnswerModel(MarusiaAnswer.HELP_ANSWER, false));
        map.put(3, new MarusiaAnswerModel(MarusiaAnswer.VIDEO_ANSWER, true));
        map.put(4, new MarusiaAnswerModel(MarusiaAnswer.SOOTHING_SOUND_ANSWER, true));
        map.put(5, new MarusiaAnswerModel(MarusiaAnswer.MUSIC_ANSWER, true));
        map.put(6, new MarusiaAnswerModel(MarusiaAnswer.BREATHING_EXERCISE_ANSWER, true));
        map.put(7, new MarusiaAnswerModel(MarusiaAnswer.YOGA_ANSWER, true));
        map.put(9, new MarusiaAnswerModel(MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER, true));
        map.put(10, new MarusiaAnswerModel(MarusiaAnswer.HELP_DISTRACTION_ANSWER, false));
        map.put(12, new MarusiaAnswerModel(MarusiaAnswer.HELP_SEDATION_ANSWER, false));
        map.put(13, new MarusiaAnswerModel(MarusiaAnswer.HELP_SEDATION_AND_DISTRACTION_ANSWER, false));
    }
}
