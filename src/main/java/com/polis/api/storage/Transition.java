package com.polis.api.storage;

import lombok.Getter;

@Getter
public class Transition {
    private int toId;
    private String[] synonyms;

    public boolean mustGo(String userInput) {
        for (String synonym : synonyms) {
            if (synonym.equals(userInput)) {
                return true;
            }
        }
        return false;
    }
}