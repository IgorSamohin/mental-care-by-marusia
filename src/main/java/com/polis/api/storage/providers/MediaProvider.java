package com.polis.api.storage.providers;

import com.polis.api.storage.media.Media;

import java.util.concurrent.ThreadLocalRandom;

public class MediaProvider {

    public String getRandomMusic() {
        return getRandomContent(Media.MUSIC.media);
    }

    public String getRandomSounds() {
        return getRandomContent(Media.SOUNDS.media);
    }

    public String getRandomVideo() {
        return getRandomContent(Media.VIDEO.media);
    }

    public String getRandomAdvice() {
        return getRandomContent(Media.ADVICE.media);
    }

    public String getRandomPicture() {
        return getRandomContent(Media.PICTURES.media);
    }

    private String getRandomContent(String[] arr) {
        int index = ThreadLocalRandom.current().nextInt(arr.length);

        return arr[index];
    }
}
