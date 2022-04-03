package com.polis.api.storage;

import lombok.Getter;

@Getter
public class Transition {
    private final int toId;
    private final String[] synonyms;

    public Transition(int toId, MarusiaCommand marusiaCommand) {
        this.toId = toId;
        this.synonyms = marusiaCommand.commands;
    }

    public boolean mustGo(String userInput) {
        for (String synonym : synonyms) {
            if (synonym.equalsIgnoreCase(userInput)) {
                return true;
            }
        }
        return false;
    }
}
