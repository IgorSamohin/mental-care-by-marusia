package com.polis.api.storage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.ThreadLocalRandom;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transition {
    @JsonProperty("to_ids")
    private final int[] toIds;
    @JsonProperty("synonyms")
    private final String[] synonyms;

    public Transition(int toId, MarusiaCommand marusiaCommand) {
        this(new int[]{toId}, marusiaCommand);
    }

    public Transition(int[] toIds, MarusiaCommand marusiaCommand) {
        if (toIds.length == 0) {
            throw new IllegalArgumentException("Array 'toIds' has to contain at least one element");
        }

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

    @JsonIgnore
    public int getNextStateId() {
        return toIds[0];
    }

    @JsonIgnore
    public int getRandomNextStateId() {
        if (toIds.length == 1) {
            return toIds[0];
        }

        int i = ThreadLocalRandom.current().nextInt(toIds.length);
        return toIds[i];
    }
}
