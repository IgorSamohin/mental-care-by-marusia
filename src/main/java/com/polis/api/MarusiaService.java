package com.polis.api;

import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Response;
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

    @Autowired
    private RepositoryImpl repository;

    @Autowired
    private Config config;

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        int prevStateId = request.state.session.prevStateId;
        State nextState = repository.getNextState(prevStateId, request.request.command);

        // todo парсить error state
        boolean endSession = config.endSessionId == nextState.getId();
        boolean isStatesEqual = prevStateId == nextState.getId();

        return createResponse(nextState, endSession, request.session, isStatesEqual);
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session, boolean isStatesEqual) {

        logger.info("state id to send in response: " + state.getId());

        Response response = new Response(
                state.getText(),
                state.getTts(),
                endSession,
                Response.getButtonsArray(state.getButtonsCommands())
        );

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }

}
