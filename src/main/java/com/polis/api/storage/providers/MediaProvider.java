package com.polis.api.storage.providers;

import com.polis.api.storage.media.Media;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class MediaProvider {
    public String getRandomVideo() {
        return getRandomContent(Media.VIDEO.media);
    }

    public String getRandomAdvice() {
        return getRandomContent(Media.ADVICE.media);
    }

    public String getRandomPicture() {
        return getRandomContent(Media.PICTURES.media);
    }

    public String getRandomBreathExercise() {
        return getRandomContent(Media.BREATH_EXERCISE.media);
    }

    private String getRandomContent(String[] arr) {
        int index = ThreadLocalRandom.current().nextInt(arr.length);

        return arr[index];
    }
}
