package com.polis.api.storage.model;

import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.audio.PlayList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class AudioModel {
    private static final int PLAYLIST_SIZE = 5;
    private final List<PlayList> playList;

    public AudioModel(List<PlayList> playList) {
        this.playList = playList;
    }

    public AudioPlayer getAudioPlayer() {
        PlayList[] randomPlayList = getRandomPlaylist();

        return new AudioPlayer(randomPlayList);
    }

    private PlayList[] getRandomPlaylist() {
        return (PlayList[]) Stream.generate(() -> ThreadLocalRandom.current().nextInt(playList.size()))
                .distinct()
                .limit(PLAYLIST_SIZE)
                .map(playList::get)
                .toArray();
    }
}
