package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.AudioPlayer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SoundPlayerProvider extends AudioPlayerProvider {

    @PostConstruct
    private void init() {
        players.add(new AudioPlayer("2000512010_456239034"));
        players.add(new AudioPlayer("2000512010_456239035"));
        players.add(new AudioPlayer("2000512010_456239036"));
    }
}
