package com.polis.api.storage.providers;

import com.polis.api.model.response.components.widgets.Link;
import com.polis.api.storage.model.VideoLinksModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

@Component
public class VideoProvider {
    private final Map<Integer, VideoLinksModel> map = new HashMap<>();

    /**
     * Возвращает аудио плеер для состояния с заданным id или null, если плеера нет.
     */
    public VideoLinksModel getVideoLinks(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(3, new VideoLinksModel(
                        new Link[]{
                                new Link("https://vk.cc/cdmJDF", "Птицы в дикой природе",
                                        "Расслабьтесь, наблюдая за птицами", ""),
                                new Link("https://vk.cc/cdmJEM", "Аляска",
                                        "Расслабьтесь, наблюдая за природой", "")
                        }

                )
        );
    }
}
