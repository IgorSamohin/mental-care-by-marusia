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
        playLists.add(new PlayList("2000512010_456239096"));
        playLists.add(new PlayList("2000512010_456239098"));
        playLists.add(new PlayList("2000512010_456239099"));
        playLists.add(new PlayList("2000512010_456239100"));
        playLists.add(new PlayList("2000512010_456239102"));
        playLists.add(new PlayList("2000512010_456239103"));
        playLists.add(new PlayList("2000512010_456239104"));
        playLists.add(new PlayList("2000512010_456239105"));
        playLists.add(new PlayList("2000512010_456239106"));
        playLists.add(new PlayList("2000512010_456239107"));
        playLists.add(new PlayList("2000512010_456239108"));
        playLists.add(new PlayList("2000512010_456239109"));
        playLists.add(new PlayList("2000512010_456239110"));
        playLists.add(new PlayList("2000512010_456239111"));
        playLists.add(new PlayList("2000512010_456239112"));
        playLists.add(new PlayList("2000512010_456239113"));
        playLists.add(new PlayList("2000512010_456239114"));
        playLists.add(new PlayList("2000512010_456239115"));
        playLists.add(new PlayList("2000512010_456239116"));

    }
}
