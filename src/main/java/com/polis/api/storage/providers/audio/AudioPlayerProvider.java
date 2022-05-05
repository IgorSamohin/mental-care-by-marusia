package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.AudioPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class AudioPlayerProvider {
    protected final List<AudioPlayer> players = new ArrayList<>();

    public AudioPlayer[] getAudioPlayers() {
        return players.toArray(new AudioPlayer[0]);
    }
}
