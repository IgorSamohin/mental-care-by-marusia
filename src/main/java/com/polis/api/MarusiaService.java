package com.polis.api;

import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import com.polis.api.model.Session;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Response;
import com.polis.api.model.response.components.audio.PlayList;
import com.polis.api.storage.RepositoryImpl;
import com.polis.api.storage.State;
import com.polis.api.storage.media.Media;
import com.polis.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

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


        if (state.getId() == 5) {
            String[] media = Media.MUSIC.media;
            int index = new Random().nextInt(media.length);

            state.getAudioPlayer().setPlaylist(new PlayList[]{new PlayList(media[index])});
        }
// ПО идее это в многопотоке должно ломаться, т.к плеер у нас у состояний один и тот же
        if (state.getId() == 4) {
            String[] media = Media.SOUNDS.media;
            int index = new Random().nextInt(media.length);

            state.getAudioPlayer().setPlaylist(new PlayList[]{new PlayList(media[index])});
        }

        return new MarusiaResponse(response, session, config.version, new UserSession(state.getId()));
    }
}
