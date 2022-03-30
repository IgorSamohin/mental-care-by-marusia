package com.polis.api.model.response.components.base.types;

public enum ActionType {
    OPEN_URL("open_url"),// открыть ссылку (перейти по заданному URL)
    OPEN_MINI_APP("open_mini_app"),// открыть мини-приложение
    OPEN_GAME("open_game");// открыть игру

    ActionType(String type) {
    }
}
