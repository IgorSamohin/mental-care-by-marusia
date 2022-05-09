package com.polis.api.storage.providers;

import com.polis.api.storage.model.Answer;
import com.polis.api.storage.model.BreathExerciseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BreathExerciseProvider {
    private final Map<Integer, BreathExerciseModel> map = new HashMap<>();

    public BreathExerciseModel getBreathExerciseModel(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(6, new BreathExerciseModel(new Answer[]{
                new Answer(
                        """
                                Попробуйте выполнить это дыхательное упражнение:
                                1. Устройтесь поудобнее.
                                2. Сделайте полный выдох через рот.
                                3. Теперь закройте рот и начните считать про себя.
                                4. На счет четыре начните медленно выдыхать через нос.
                                5. На счет семь задержите дыхание.
                                6. На счет восемь выдохните полностью через рот.
                                7. Повторите еще три раза.""",
                        """
                                Попробуйте выполнить это дыхательное упражнение:
                                Устройтесь поудобнее.
                                Сделайте полный выдох через рот.
                                Теперь закройте рот и начните считать про себя.
                                На счет четыре начните медленно выдыхать через нос.
                                На счет семь задержите дыхание.
                                На счет восемь выдохните полностью через рот.
                                Повторите еще три раза."""
                ),
                new Answer("""
                        Попробуйте выполнить это дыхательное упражнение:
                        1. Устройтесь поудобнее.
                        2. Сделайте полный выдох через рот.
                        3. Теперь закройте рот и начните считать про себя.
                        4. На счет семь задержите дыхание.
                        5. На счет десять выдохните полностью через рот.
                        """,
                        """
                                Попробуйте выполнить это дыхательное упражнение:
                                Устройтесь поудобнее.
                                Сделайте полный выдох через рот.
                                Теперь закройте рот и начните считать про себя.
                                На счет семь задержите дыхание.
                                На счет десять выдохните полностью через рот.
                                """)
        }));
    }
}
