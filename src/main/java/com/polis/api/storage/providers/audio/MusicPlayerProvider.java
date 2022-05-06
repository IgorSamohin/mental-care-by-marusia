package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.AudioPlayer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MusicPlayerProvider extends AudioPlayerProvider {
    @PostConstruct
    private void init() {
        players.add(new AudioPlayer("2000512010_456239038"));
        players.add(new AudioPlayer("2000512010_456239040"));
        players.add(new AudioPlayer("2000512010_456239041"));
        players.add(new AudioPlayer("2000512010_456239042"));
        players.add(new AudioPlayer("2000512010_456239043"));
        players.add(new AudioPlayer("2000512010_456239044"));
        players.add(new AudioPlayer("2000512010_456239045"));
        players.add(new AudioPlayer("2000512010_456239046"));
        players.add(new AudioPlayer("2000512010_456239047"));
        players.add(new AudioPlayer("2000512010_456239048"));
        players.add(new AudioPlayer("2000512010_456239049"));
        players.add(new AudioPlayer("2000512010_456239050"));
        players.add(new AudioPlayer("2000512010_456239051"));
        players.add(new AudioPlayer("2000512010_456239052"));
        players.add(new AudioPlayer("2000512010_456239053"));
        players.add(new AudioPlayer("2000512010_456239054"));
        players.add(new AudioPlayer("2000512010_456239055"));
        players.add(new AudioPlayer("2000512010_456239056"));
        players.add(new AudioPlayer("2000512010_456239057"));
        players.add(new AudioPlayer("2000512010_456239058"));
    }
}
