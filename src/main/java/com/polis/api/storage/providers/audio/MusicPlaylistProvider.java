package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.PlayList;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MusicPlaylistProvider extends PlayListProvider {
    @PostConstruct
    private void init() {
        playLists.add(new PlayList("2000512010_456239038"));
        playLists.add(new PlayList("2000512010_456239040"));
        playLists.add(new PlayList("2000512010_456239041"));
        playLists.add(new PlayList("2000512010_456239042"));
        playLists.add(new PlayList("2000512010_456239043"));
        playLists.add(new PlayList("2000512010_456239044"));
        playLists.add(new PlayList("2000512010_456239045"));
        playLists.add(new PlayList("2000512010_456239046"));
        playLists.add(new PlayList("2000512010_456239047"));
        playLists.add(new PlayList("2000512010_456239048"));
        playLists.add(new PlayList("2000512010_456239049"));
        playLists.add(new PlayList("2000512010_456239050"));
        playLists.add(new PlayList("2000512010_456239051"));
        playLists.add(new PlayList("2000512010_456239052"));
        playLists.add(new PlayList("2000512010_456239053"));
        playLists.add(new PlayList("2000512010_456239054"));
        playLists.add(new PlayList("2000512010_456239055"));
        playLists.add(new PlayList("2000512010_456239056"));
        playLists.add(new PlayList("2000512010_456239057"));
        playLists.add(new PlayList("2000512010_456239058"));
    }
}
