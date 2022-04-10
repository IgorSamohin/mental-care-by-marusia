package com.polis.api.storage;

import lombok.Getter;
import me.xdrop.fuzzywuzzy.FuzzySearch;

@Getter
public class Transition {
    private final int toId;
    private final String[] synonyms;

    public Transition(int toId, MarusiaCommand marusiaCommand) {
        this.toId = toId;
        this.synonyms = marusiaCommand.commands;
    }

    // TODO improve this
    public boolean mustGo(String userInput) {
        for (String synonym : synonyms) {
            int res = FuzzySearch.weightedRatio(userInput, synonym);
            if (res > 80) {
                return true;
            }
        }
        return false;
    }
}
