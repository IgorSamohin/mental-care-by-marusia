package com.polis.api.storage.providers;

import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.storage.providers.audio.AudioPlayerProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
class AudioProvider {
    private final Map<Integer, AudioPlayer[]> map = new HashMap<>();
    //    public static final AudioPlayer TEST_AUDIO_PLAYER = new AudioPlayer(new String[]{"2000512010_456239028"}
    @Autowired
    private final AudioPlayerProvider musicPlayerProvider;
    private final AudioPlayerProvider soundPlayerProvider;

    /**
     * Возвращает аудио плеер для состояния с заданным id или null, если плеера нет.
     */
    public AudioPlayer[] getAudioPlayers(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************


    //FIXME У состояния не может быть 1 аудиоплеер, должны быть аудиоплееры для каждого ответа разный, ну или набор аудиоплееров
    // 1 музыка - 1 аудиоплеер

    @PostConstruct
    private void init() {
        map.put(4, soundPlayerProvider.getAudioPlayers());
        map.put(5, musicPlayerProvider.getAudioPlayers());
    }
}
