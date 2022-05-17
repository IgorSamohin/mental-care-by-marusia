package com.polis.api.storage.providers;

import com.polis.api.storage.MarusiaAnswer;
import com.polis.api.storage.model.Answer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
class MarusiaAnswerProvider {
    private final Map<Integer, Answer> map = new HashMap<>();

    /**
     * Возвращает ответ для состояния с заданным id или null, если ответа нет.
     */
    public Answer getAnswer(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(-4, new Answer(MarusiaAnswer.HOME_ANSWER, false));
        map.put(-3, new Answer(MarusiaAnswer.EXIT_ANSWER, false));
        map.put(-2, new Answer(MarusiaAnswer.ERROR_ANSWER, false));
        map.put(-1, new Answer(MarusiaAnswer.START_ANSWER, false));
        map.put(1, new Answer(MarusiaAnswer.ADVICE_FROM_PSYCHOLOGIST_ANSWER, true));
        map.put(2, new Answer(MarusiaAnswer.HELP_ANSWER, false));
        map.put(3, new Answer(MarusiaAnswer.VIDEO_ANSWER, true));
        map.put(4, new Answer(MarusiaAnswer.SOOTHING_SOUND_ANSWER, true));
        map.put(5, new Answer(MarusiaAnswer.MUSIC_ANSWER, true));
        map.put(6, new Answer(MarusiaAnswer.BREATHING_EXERCISE_ANSWER, true));
        map.put(7, new Answer(MarusiaAnswer.YOGA_ANSWER, true));
        map.put(8, new Answer(MarusiaAnswer.NUMBER_GUESS_TASK_ANSWER, false));
        map.put(9, new Answer(MarusiaAnswer.NUMBER_COUNT_TASK_ANSWER, true));
        map.put(10, new Answer(MarusiaAnswer.HELP_DISTRACTION_ANSWER, false));
        map.put(12, new Answer(MarusiaAnswer.HELP_SEDATION_ANSWER, false));
        map.put(13, new Answer(MarusiaAnswer.HELP_SEDATION_AND_DISTRACTION_ANSWER, false));
        map.put(14, new Answer(
                "Давайте начнем! Я загадала число от 0 до 100. Попробуйте его отгадать.",
                "Давайте начнем! Я загадала число от нуля до ста. Попробуйте его отгадать."));
    }
}
