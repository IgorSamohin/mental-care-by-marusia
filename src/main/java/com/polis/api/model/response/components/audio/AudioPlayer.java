package com.polis.api.model.response.components.audio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioPlayer {
    private PlayList[] playlist;

    @JsonProperty("seek_track")
    private int seekTrack;

    @JsonProperty("seek_second")
    private int seekSecond;

    public AudioPlayer(String[] audioVkIds) {
        this.playlist = new PlayList[audioVkIds.length];
        for (int i = 0; i < audioVkIds.length; i++) {
            this.playlist[i] = new PlayList(audioVkIds[i]);
        }
        this.seekSecond = 0;
        this.seekTrack = 0;
    }

    public AudioPlayer(String[] audioVkIds, int trackId, int second) {
        if (trackId >= audioVkIds.length || trackId < 0) {
            throw new IndexOutOfBoundsException("Track id should be in range of audioVkIds");
        }

        if (second < 0) {
            throw new IllegalArgumentException("Second should be positive number or 0");
        }

        this.seekSecond = second;
        this.seekTrack = trackId;
        this.playlist = new PlayList[audioVkIds.length];
        for (int i = 0; i < audioVkIds.length; i++) {
            this.playlist[i] = new PlayList(audioVkIds[i]);
        }
    }
}
