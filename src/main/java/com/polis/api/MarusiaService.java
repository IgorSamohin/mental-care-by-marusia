package com.polis.api;

import com.polis.api.storage.RepositoryImpl;
import com.polis.api.storage.State;
import org.springframework.beans.factory.annotation.Autowired;
import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import org.springframework.stereotype.Service;

@Service
public class MarusiaService {

    @Autowired
    private RepositoryImpl repository;

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        State nextState = request.state == null
                ? repository.getNextState(-1, request.request.command)
                : repository.getNextState(request.state.session.prevStateId, request.request.command);

        return MarusiaResponse.build(nextState);
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
