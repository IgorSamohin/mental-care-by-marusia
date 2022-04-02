package com.polis.api.model.response.components.base.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ActionType {
    @JsonProperty("open_url")
    OPEN_URL("open_url"),// открыть ссылку (перейти по заданному URL)
    @JsonProperty("open_mini_app")
    OPEN_MINI_APP("open_mini_app"),// открыть мини-приложение
    @JsonProperty("open_game")
    OPEN_GAME("open_game");// открыть игру

    ActionType(String type) {
    }
}
