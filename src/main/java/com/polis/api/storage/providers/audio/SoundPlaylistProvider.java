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
        playLists.add(new PlayList("2000512010_456239088"));
        playLists.add(new PlayList("2000512010_456239089"));
        playLists.add(new PlayList("2000512010_456239090"));
        playLists.add(new PlayList("2000512010_456239091"));
        playLists.add(new PlayList("2000512010_456239092"));
        playLists.add(new PlayList("2000512010_456239093"));
        playLists.add(new PlayList("2000512010_456239094"));
        playLists.add(new PlayList("2000512010_456239095"));
    }
}
