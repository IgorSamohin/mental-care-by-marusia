package com.polis.api.storage.model;

import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.audio.PlayList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AudioModel {
    private final List<PlayList> playList;

    public AudioModel(List<PlayList> playList) {
        this.playList = playList;
    }

    public AudioPlayer getAudioPlayer() {
        PlayList[] randomPlayList = getRandomPlayList();

        return new AudioPlayer(randomPlayList);
    }

    //FIXME

    private PlayList[] getRandomPlayList() {
        int index = ThreadLocalRandom.current().nextInt(playList.size());

        return new PlayList[]{playList.get(index)};
    }
}
