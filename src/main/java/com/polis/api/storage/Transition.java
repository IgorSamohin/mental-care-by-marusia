package com.polis.api.storage;

import lombok.Getter;

@Getter
public class Transition {
    private final int[] toIds;
    private final String[] synonyms;

    public Transition(int toId, MarusiaCommand marusiaCommand) {
        this.toIds = new int[]{toId};
        this.synonyms = marusiaCommand.commands;
    }

    public Transition(int[] toIds, MarusiaCommand marusiaCommand) {
        this.toIds = toIds;
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
