package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.audio.PlayList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AudioService implements Audio {


    //TODO change classname
    private final List<PlayList> playList;

    public AudioService(List<PlayList> playList) {
        this.playList = playList;
    }

    @Override
    public AudioPlayer getAudioPlayer() {
        PlayList[] randomPlayList = getRandomPlayList();

        return new AudioPlayer(randomPlayList);
    }


    private PlayList[] getRandomPlayList() {
        int index = ThreadLocalRandom.current().nextInt(playList.size());

        return new PlayList[]{playList.get(index)};
    }
}
