package com.polis.api;

import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Response;
import com.polis.api.storage.RepositoryImpl;
import com.polis.api.storage.State;
import com.polis.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import org.springframework.stereotype.Service;

@Service
public class MarusiaService {
    private Logger logger = LoggerFactory.getLogger(MarusiaService.class);

    @Autowired
    private RepositoryImpl repository;

    @Autowired
    private Config config;

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        logger.info("is session null? : " + (request.state.session == null));
        logger.info("curr id? : " + request.state.session.prevStateId);

        State nextState = request.state.session.prevStateId == null
            ? repository.getNextState(-1, request.request.command)
            : repository.getNextState(request.state.session.prevStateId, request.request.command);

        logger.info("next statte id" + nextState.getId());

        // todo парсить error state
        boolean endSession = config.endSessionId == nextState.getId();
        return createResponse(nextState, endSession, request.session);
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session) {
        Response response = new Response(state.getText(), state.getTts(), endSession);

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
