package com.polis.api.storage.providers;

import com.polis.api.model.response.components.Command;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandsProvider {
    private final Map<Integer, Command[]> map = new HashMap<>();

    /**
     * Данных пока что нет - всегда возвращает null
     */
    public Command[] getCommands(int stateId) {
        return null;
    }

}
