package com.polis.api.storage;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class State {
    public static final int START_STATE_ID = -1;
    public static final int ERROR_STATE_ID = -2;
    public static final int EXIT_STATE_ID = -3;
    public static final int MENU_ID = 2;

    private int id;
    private String text;
    private String tts;

    private Transition[] possibleTransitions;
    private final Random random = new Random();


    public State(int id, MarusiaAnswer marusiaAnswer, Transition[] possibleTransitions) {
        this.id = id;
        this.text = marusiaAnswer.text;
        this.tts = marusiaAnswer.tts;

        this.possibleTransitions = possibleTransitions;
    }


    //TODO про повтор(если не нашел следующую фразу из миро)

    /**
     * @param userInput команда от пользователя
     * @return состояние, которое соотвествует команде пользователя
     */
    public int getNextStateId(String userInput) {
        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return possibleTransition.getToId();
            }
        }

        return ERROR_STATE_ID;
    }

//    //TODO HMMM
//    public List<String> getCommandsArray() {
//        return Arrays.stream(possibleTransitions)
//                .map(transition -> transition.getSynonyms()[0])
//                .collect(Collectors.toList());
//    }
}
