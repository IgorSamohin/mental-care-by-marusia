package com.polis.api;

import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Response;
import com.polis.api.storage.RepositoryImpl;
import com.polis.api.storage.State;
import com.polis.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import org.springframework.stereotype.Service;

@Service
public class MarusiaService {

    @Autowired
    private RepositoryImpl repository;

    @Autowired
    private Config config;

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        State nextState = request.state.session == null
                ? repository.getNextState(-1, request.request.command)
                : repository.getNextState(request.state.session.prevStateId, request.request.command);

        //todo парсить error state
        boolean endSession = config.endSessionId == nextState.getId();
        return createResponse(nextState, endSession, request.session);
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session) {
        Response response = new Response(state.getText(), state.getTts(), endSession);

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
