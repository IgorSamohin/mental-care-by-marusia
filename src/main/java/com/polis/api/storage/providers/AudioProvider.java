package com.polis.api.storage.providers;

import com.polis.api.storage.model.AudioModel;
import com.polis.api.storage.providers.audio.PlayListProvider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
class AudioProvider {
    private final Map<Integer, AudioModel> map = new HashMap<>();
    private final PlayListProvider musicPlaylistProvider;
    private final PlayListProvider soundPlaylistProvider;

    public AudioProvider(PlayListProvider musicPlaylistProvider, PlayListProvider soundPlaylistProvider) {
        this.musicPlaylistProvider = musicPlaylistProvider;
        this.soundPlaylistProvider = soundPlaylistProvider;
    }

    public AudioModel getAudio(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(4, new AudioModel(soundPlaylistProvider.getPlayLists()));
        map.put(5, new AudioModel(musicPlaylistProvider.getPlayLists()));
    }
}
