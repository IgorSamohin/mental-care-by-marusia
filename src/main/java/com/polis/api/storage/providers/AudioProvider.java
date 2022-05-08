package com.polis.api.storage.providers;

import com.polis.api.storage.providers.audio.Audio;
import com.polis.api.storage.providers.audio.AudioService;
import com.polis.api.storage.providers.audio.PlayListProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
class AudioProvider {
    private final Map<Integer, Audio> map = new HashMap<>();
    //    public static final AudioPlayer TEST_AUDIO_PLAYER = new AudioPlayer(new String[]{"2000512010_456239028"}
    private final PlayListProvider musicPlaylistProvider;
    private final PlayListProvider soundPlaylistProvider;

    /**
     * Возвращает аудио плеер для состояния с заданным id или null, если плеера нет.
     */
    public Audio getAudio(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(4, new AudioService(soundPlaylistProvider.getPlayLists()));
        map.put(5, new AudioService(musicPlaylistProvider.getPlayLists()));
    }
}
