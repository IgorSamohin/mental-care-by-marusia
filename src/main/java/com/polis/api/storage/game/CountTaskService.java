package com.polis.api.storage.game;

import com.polis.api.storage.DataProvider;
import com.polis.api.storage.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CountTaskService {

    private final DataProvider dataProvider;

    public State handleInput(String userInput) {
        Map<Integer, State> states = dataProvider.getStates();
        try {
            int number = Integer.parseInt(userInput);

            if (number <= 1) {
                return states.get(16);
            }

            if (number > 100) {
                return states.get(15);
            }

            State state = states.get(14);

            if (number != 1) {
                state.setText(userInput + "! Ваша очередь");
                state.setTts(userInput + "! Ваша очередь");
            }


            return state;

        } catch (NumberFormatException e) {
            return states.get(17);
        }
    }
}
