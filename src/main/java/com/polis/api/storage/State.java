package com.polis.api.storage;

import com.polis.api.RandomUtils;
import com.polis.api.storage.answer.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private Answer answer;
    private List<Transition> possibleTransitions;
    private List<String> buttons;

    //TODO можно сюда сразу массив передавать, а в методе getAnswer рандомить
    public State(int id, Answer answer, Transition[] possibleTransitions, String[] buttons, boolean repeatable) {
        this.id = id;
        this.answer = answer;

        this.possibleTransitions = new ArrayList<>(Arrays.stream(possibleTransitions).toList());
        this.buttons = new ArrayList<>(Arrays.stream(buttons).toList());

        if (repeatable) {
            this.possibleTransitions.add(new Transition(id, MarusiaCommand.MORE));
            this.buttons.add("Еще");
        }
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

    //FIXME возможно так плохо, тк можно вызвать getAnswer().text и сразу после этого getAnswer().tts и буду разные
    // результаты, но кажется если тут завязано на рандоме, так будет всегда, нельяз будет вызывать таким образом
    public MarusiaAnswer getAnswer() {
        return answer.getAnswer();
    }

//    public MarusiaAnswer getAnswer() {
//        if (answers.length == 1) {
//          return answers[0];
//        }
//
//        int randomIndex = RandomUtils.randomNumberFromZeroToBound(answers.length);
//
//
//        return answers[randomIndex];
//    }

        //TODO HMMM
    public List<String> getCommandsArray() {
        return buttons;
    }
}
