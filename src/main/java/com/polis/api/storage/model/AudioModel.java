package com.polis.api.storage.model;

import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.audio.PlayList;

import java.util.ArrayList;
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

    private PlayList[] getRandomPlaylist() {
        PlayList[] playListArr = new PlayList[PLAYLIST_SIZE];

        List<Integer> indexes = getListOfRandomIndexes();

        for (int i = 0; i < indexes.size(); i++) {
            playListArr[i] = playList.get(i);
        }

        return playListArr;
    }

    private List<Integer> getListOfRandomIndexes() {
        List<Integer> indexes = new ArrayList<>();

        int counter = 0;
        while (counter < PLAYLIST_SIZE) {
            int index = ThreadLocalRandom.current().nextInt(AudioModel.PLAYLIST_SIZE);

            if (!indexes.contains(index)) {
                indexes.add(index);
                counter++;
            }
        }

        return indexes;
    }
}
