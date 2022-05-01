package com.polis.api.storage.providers;

import com.polis.api.model.response.components.audio.AudioPlayer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
class AudioPlayerProvider {
    private final Map<Integer, AudioPlayer> map = new HashMap<>();
    public static final AudioPlayer TEST_AUDIO_PLAYER = new AudioPlayer(new String[]{"2000512010_456239028"});

    /**
     * Возвращает аудио плеер для состояния с заданным id или null, если плеера нет.
     */
    public AudioPlayer getAudioPlayer(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************


    @PostConstruct
    private void init() {
        map.put(4, new AudioPlayer(new String[]{}));
        map.put(5, new AudioPlayer(new String[]{}));
    }
}
