package com.polis.api.storage.model;

import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.audio.PlayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    private PlayList[] getRandomPlayListWithOneAudio() {
        int index = ThreadLocalRandom.current().nextInt(playList.size());

        return new PlayList[]{playList.get(index)};
    }

    private PlayList[] getRandomPlaylist() {
        List<PlayList> list = new ArrayList<>(this.playList);

        Collections.shuffle(list);

        List<PlayList> sublist = list.subList(0, PLAYLIST_SIZE);

        return sublist.toArray(new PlayList[PLAYLIST_SIZE]);
    }
}
