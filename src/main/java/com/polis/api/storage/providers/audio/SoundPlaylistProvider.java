package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.PlayList;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SoundPlaylistProvider extends PlayListProvider {

    @PostConstruct
    private void init() {
        playLists.add(new PlayList("2000512010_456239034"));
        playLists.add(new PlayList("2000512010_456239035"));
        playLists.add(new PlayList("2000512010_456239039"));
        playLists.add(new PlayList("2000512010_456239059"));
        playLists.add(new PlayList("2000512010_456239060"));
        playLists.add(new PlayList("2000512010_456239061"));
        playLists.add(new PlayList("2000512010_456239062"));
        playLists.add(new PlayList("2000512010_456239063"));
        playLists.add(new PlayList("2000512010_456239064"));
        playLists.add(new PlayList("2000512010_456239065"));
        playLists.add(new PlayList("2000512010_456239066"));
        playLists.add(new PlayList("2000512010_456239067"));
        playLists.add(new PlayList("2000512010_456239068"));
        playLists.add(new PlayList("2000512010_456239069"));
        playLists.add(new PlayList("2000512010_456239070"));
        playLists.add(new PlayList("2000512010_456239071"));
        playLists.add(new PlayList("2000512010_456239073"));
        playLists.add(new PlayList("2000512010_456239074"));
        playLists.add(new PlayList("2000512010_456239075"));
        playLists.add(new PlayList("2000512010_456239076"));
        playLists.add(new PlayList("2000512010_456239077"));
        playLists.add(new PlayList("2000512010_456239079"));
        playLists.add(new PlayList("2000512010_456239080"));
        playLists.add(new PlayList("2000512010_456239082"));
        playLists.add(new PlayList("2000512010_456239083"));
        playLists.add(new PlayList("2000512010_456239084"));
        playLists.add(new PlayList("2000512010_456239085"));
        playLists.add(new PlayList("2000512010_456239086"));
        playLists.add(new PlayList("2000512010_456239087"));
    }
}
