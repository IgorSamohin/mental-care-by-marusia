package com.polis.api;

import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.ResponseButton;
import com.polis.api.model.response.Response;
import com.polis.api.storage.MarusiaAnswer;
import com.polis.api.storage.RepositoryImpl;
import com.polis.api.storage.State;
import com.polis.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarusiaService {
    private Logger logger = LoggerFactory.getLogger(MarusiaService.class);

    @Autowired
    private RepositoryImpl repository;

    @Autowired
    private Config config;

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        logger.info("prev state from request: " + request.getState().session.prevStateId);
        int prevStateId = request.state.session.prevStateId;

        //приходит прошлый стейт и команда
        State nextState = repository.getNextState(prevStateId, request.request.command);

        // todo парсить error state

        boolean endSession = config.endSessionId == nextState.getId();

        logger.info("state to output:" + nextState.getId());

        return createResponse(nextState, endSession, request.session);
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session) {
        //Только так вызывать, для одинакового текста и ттса
        MarusiaAnswer marusiaAnswer = state.getAnswer();

        String text = marusiaAnswer.text;
        String tts = marusiaAnswer.tts;

        List<ResponseButton> buttonList = state.getButtons().stream().map(ResponseButton::new).collect(Collectors.toList());

        Response response = new Response(
                text,
                tts,
                endSession,
                buttonList
        );

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
