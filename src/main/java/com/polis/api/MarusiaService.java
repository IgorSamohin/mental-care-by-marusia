package com.polis.api;

import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Button;
import com.polis.api.model.response.Response;
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
        int prevStateId = request.state.session.prevStateId;

        //приходит прошлый стейт и команда
        State nextState = repository.getNextState(prevStateId, request.request.command);

        // todo парсить error state

        //FIXME MAGIC NUMBER
        boolean isWrongCommand = nextState.getId() == -2;

        nextState = isWrongCommand ? repository.getState(prevStateId) : nextState;

        boolean endSession = config.endSessionId == nextState.getId();


        return createResponse(nextState, endSession, request.session, isWrongCommand);
    }

    //объединяем аргументы в ответ.
    private MarusiaResponse createResponse(State state, boolean endSession, Session session, boolean isWrongCommand) {

        String text = state.getText();
        String tts = state.getTts();

        /*если прошлый стейт совпадает с текущим -> пришла неверная команда, но фраза мб терминальной, терминальной по идее
        не нужно использовать разные фразы чтобы помочь*/
        if (isWrongCommand) {
            int index = state.getRandomHelpfulPhraseIndex();
            text = state.getHelpPhrases()[index];
            tts = state.getHelpTtsPhrases()[index];
        }

        List<Button> buttonList = state.getCommandsArray().stream().map(Button::new).collect(Collectors.toList());

        Response response = new Response(
                text,
                tts,
                endSession,
                buttonList
        );

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId(), isWrongCommand));
    }
}
