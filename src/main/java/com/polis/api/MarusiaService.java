package com.polis.api;

import org.springframework.beans.factory.annotation.Autowired;
import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import org.springframework.stereotype.Service;

@Service
public class MarusiaService {

    @Autowired
    private RepositoryImpl repository;

    public MarusiaResponse handleRequest(MarusiaRequest request) {

        switch (getCommandFromRequest("")){
            case COMMAND -> {}
            case START_SKILL -> {}
        }

        return null;
    }

    //достаем из строки команду, которую необходимо выполнить
    private Command getCommandFromRequest(String rawCommand) {
        return Command.COMMAND;
    }

    //объединяем аргументы в ответ.
    // todo Object... args - нужно поменять
    private MarusiaResponse createResponse(Object... args) {
        return null;
    }
}
