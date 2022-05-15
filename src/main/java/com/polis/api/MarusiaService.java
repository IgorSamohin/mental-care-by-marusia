package com.polis.api;

import com.polis.api.game.CountNumberAnswer;
import com.polis.api.game.CountTaskService;
import com.polis.api.game.GuessNumberAnswer;
import com.polis.api.game.GuessNumberService;
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
    private final GuessNumberService guessNumberService = new GuessNumberService();

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

        State nextState = repository.getNextState(prevStateId, request.request.command);

        if (prevStateId == 9) {
            return getResponseForCountGame(request, prevStateId);
        }

        if (prevStateId == 8) {
            if (request.request.command.equalsIgnoreCase("Да") ||
                    request.state.session.endGameNumber != null) {
                return getResponseForGuessGame(request, prevStateId);
            }
        }

        //приходит прошлый стейт и команда

        // todo парсить error state

        boolean endSession = config.endSessionId == nextState.getId();

        return createResponse(nextState, endSession, request.session);
    }

    private MarusiaResponse getResponseForCountGame(MarusiaRequest request, int prevStateId) {
        Integer prevNumberGame = request.state.session.prevNumberGame;
        Integer endGameNumber = request.state.session.endGameNumber;

        CountNumberAnswer answer = countTaskService.handleInput(request.request.command, prevNumberGame, endGameNumber);

        Response response = new Response(answer.text(), answer.tts(), false);

        if (answer.endGame()) {
            return new MarusiaResponse(response, request.session, config.version, new UserSession(-1));
        }


        return new MarusiaResponse(response, request.session, config.version, new UserSession(prevStateId, answer.prevNumber(), answer.endGameNUmber()));
    }

    private MarusiaResponse getResponseForGuessGame(MarusiaRequest request, int prevStateId) {

        String command = request.request.command;

        Integer endGameNumber = request.state.session.endGameNumber;

        GuessNumberAnswer answer = guessNumberService.userGuessNumber(command, endGameNumber);

        Response response = new Response(answer.text(), answer.tts(), false);

        if (answer.endGame()) {
            return new MarusiaResponse(response, request.session, config.version, new UserSession(
                    -1,
                    answer.endGameNumber()
            ));
        }

        return new MarusiaResponse(response, request.session, config.version, new UserSession(
                prevStateId,
                answer.endGameNumber()
        ));
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session) {
        Response response = new Response(state, endSession);

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
