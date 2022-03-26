package com.polis.api;

import com.polis.api.model.Request;
import com.polis.api.model.Response;
import com.polis.api.storage.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarusiaService {
    @Autowired
    private RepositoryImpl repository;

    public Response handleRequest(Request request) {
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
    private Response createResponse(Object... args) {
        return null;
    }
}
