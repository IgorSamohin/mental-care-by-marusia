package com.polis.api;

import com.polis.api.game.CountTaskService;
import com.polis.api.game.GameAnswer;
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

    private final RepositoryImpl repository;
    private final Config config;

    private final CountTaskService countTaskService;

    @Autowired
    public MarusiaService(RepositoryImpl repository, Config config, CountTaskService countTaskService) {
        this.repository = repository;
        this.config = config;
        this.countTaskService = countTaskService;
    }

    public MarusiaResponse handleRequest(MarusiaRequest request) {
        if (request.request.type.equals("DeepLink")) {
            State state = repository.getStartState();
            return createResponse(state, false, request.session);
        }

        int prevStateId = request.state.session.prevStateId;

        if (prevStateId == 9) {
            return getResponseForGame(request, prevStateId);
        }

        //приходит прошлый стейт и команда
        State nextState = repository.getNextState(prevStateId, request.request.command);

        // todo парсить error state

        boolean endSession = config.endSessionId == nextState.getId();

        return createResponse(nextState, endSession, request.session);
    }

    private MarusiaResponse getResponseForGame(MarusiaRequest request, int prevStateId) {
        int prevNumberGame = request.state.session.prevNumberGame;
        int endGameNumber = request.state.session.endGameNumber;

        GameAnswer answer = countTaskService.handleInput(request.request.command, prevNumberGame, endGameNumber);

        Response response = new Response(answer.text(), answer.tts(), answer.endSession());

        if (answer.endGame()) {
            return new MarusiaResponse(response, request.session, config.version, new UserSession(-1));
        }


        return new MarusiaResponse(response, request.session, config.version, new UserSession(prevStateId, answer.prevNumber(), answer.endGameNUmber()));
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session) {
        Response response = new Response(state, endSession);

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
