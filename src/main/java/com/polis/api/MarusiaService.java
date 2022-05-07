package com.polis.api;

import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Response;
import com.polis.api.storage.MarusiaAnswer;
import com.polis.api.storage.RepositoryImpl;
import com.polis.api.storage.State;
import com.polis.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarusiaService {
    private Logger logger = LoggerFactory.getLogger(MarusiaService.class);

    private final RepositoryImpl repository;
    private final Config config;

    @Autowired
    public MarusiaService(RepositoryImpl repository, Config config) {
        this.repository = repository;
        this.config = config;
    }

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        if (request.request.type.equals("DeepLink")) {
            State state = repository.getStartState();
            return createResponse(state, false, request.session);
        }

        int prevStateId = request.state.session.prevStateId;

        //приходит прошлый стейт и команда
        State nextState = repository.getNextState(prevStateId, request.request.command);

        // todo парсить error state

        boolean endSession = config.endSessionId == nextState.getId();

        return createResponse(nextState, endSession, request.session);
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session) {
        Response response = new Response(state, endSession);

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
