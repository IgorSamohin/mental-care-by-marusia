package com.polis.api.storage;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

@Getter
@NoArgsConstructor
public class State {
    public static final int DEFAULT_STATE_ID = -1;
    public static final int ERROR_STATE_ID = -2;
    public static final int EXIT_STATE_ID = -3;
    public static final int MENU_ID = 2;

    private int id;
    private String text;
    private String tts;
//    private String [] helpPhrases;
    private String [] buttonsCommands;
    private Transition[] possibleTransitions;
    private final Random random = new Random();


    public State(int id, MarusiaAnswer marusiaAnswer, ButtonCommand buttonCommand, Transition[] possibleTransitions) {
        this.id = id;
        this.text = marusiaAnswer.text;
        this.tts = marusiaAnswer.tts;
//        this.helpPhrases = marusiaAnswer.helpAnswers;
        this.buttonsCommands = buttonCommand == null ? null : buttonCommand.buttons;
        this.possibleTransitions = possibleTransitions;
    }


    //TODO про повтор(если не нашел следующую фразу из миро)
    /**
     *
     * @param userInput команда от пользователя
     * @return состояние, которое соотвествует команде пользователя
     */
    public int getNextStateId(String userInput) {

        for (Transition possibleTransition : possibleTransitions) {
            if (possibleTransition.mustGo(userInput)) {
                return possibleTransition.getToId();
            }
        }
        if (id == EXIT_STATE_ID) {
            return DEFAULT_STATE_ID;
        }
        return id;
    }

//    public String getRandomHelpfulPhrase() {
//        int phrasesNumber = helpPhrases.length;
//
//        int randomIndex = random.nextInt(phrasesNumber - 1);
//
//        return helpPhrases[randomIndex];
//    }
}
