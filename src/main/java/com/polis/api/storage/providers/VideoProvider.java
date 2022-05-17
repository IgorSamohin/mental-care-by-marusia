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
     * Возвращает видео плеер для состояния с заданным id или null, если плеера нет.
     */
    public VideoLinksModel getVideoLinks(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(3, new VideoLinksModel(new Link[]{
                        new Link("https://vk.cc/cdmJDF", "Птицы в дикой природе",
                                "Расслабьтесь, наблюдая за птицами", ""),
                        new Link("https://vk.cc/cdmJEM", "Аляска",
                                "Расслабьтесь, наблюдая за природой", ""),
                        new Link("https://vk.cc/cdqlke", "Коты",
                                "Расслабьтесь, наблюдая за котами", ""),
                        new Link("https://vk.cc/cdqlnT", "Коты", "Расслабьтесь, наблюдая за котами", ""),
                        new Link("https://vk.cc/cdqlqj", "Коты", "Расслабьтесь, наблюдая за котами", ""),
                        new Link("https://vk.cc/cdqls3", "Коты", "Расслабьтесь, наблюдая за котами", ""),
                        new Link("https://vk.cc/cdqlto", "Птицы в дикой природа", "Расслабьтесь, наблюдая за птицами", ""),
                        new Link("https://vk.cc/cdqlvi", "Животные под щебет птиц", "Расслабьтесь под щебетание птиц", ""),
                        new Link("https://vk.cc/cdqlyJ", "Животные в африки", "Расслабьтесь, наблюдая за животными", ""),
                        new Link("https://vk.cc/cdqlAM", "Дикая природа", "Расслабьтесь, наблюдая за дикой природой", ""),
                        new Link("https://vk.cc/cdqlDh", "Дикая природа", "Расслабьтесь, наблюдая за дикой природой", ""),
                        new Link("https://vk.cc/cdqlEK", "Забавное видео с животными", "Расслабьтесь, посмотрев милое видео с животными", ""),
                        new Link("https://vk.cc/cdqlKw", "Дикая природа", "Расслабьтесь, наблюдая за дикой природой", ""),
                        new Link("https://vk.cc/cdqlMQ", "Милое видео с животными", "Расслабьтесь, посмотрев милое видео с животными", ""),
                        new Link("https://vk.cc/cdqlP8", "Львы", "Расслабьтесь, наблюдая за львами", ""),
                        new Link("https://vk.cc/cdqlSk", "Амазонка", "Расслабьтесь, наблюдая за Амазонкой", ""),
                        new Link("https://vk.cc/cdqlUw", "Видео о диких животных", "Расслабьтесь, наблюдая за дикими животными", ""),
                        new Link("https://vk.cc/cdqlZ3", "Милое видео с животными", "Расслабьтесь, наблюдая за животными", ""),
                        new Link("https://vk.cc/cdqm1r", "Дождь в тропическом лесу", "Расслабьтесь под звуки дождя", ""),
                        new Link("https://vk.cc/cdqm4A", "Животные", "Расслабьтесь, наблюдая за животными", ""),
                        new Link("https://vk.cc/cdqm6L", "Подводный мир", "Расслабьтесь, наблюдая за подводными миром", ""),
                        new Link("https://vk.cc/cdqmlF", "Красивые птицы", "Расслабьтесь, наблюдая за птицами", ""),
                        new Link("https://vk.cc/cdqmns", "Пение птиц", "Расслабьтесь под пение птиц", ""),
                        new Link("https://vk.cc/cdqmpe", "Красочные птица", "Расслабьтесь, наблюдая за красочными птицами", ""),
                        new Link("https://vk.cc/cdqmqT", "Природа", "Расслабьтесь, наблюдая за природой", ""),
                        new Link("https://vk.cc/cdqmsM", "Пением птиц", "Расслабьтесь под пение птиц", ""),
                        new Link("https://vk.cc/cdqmub", "Лес", "Расслабьтесь, наблюдая за лесом", ""),
                        new Link("https://vk.cc/cdqmzb", "Река и пение птиц", "Расслабьтесь под звуки реки и пение птиц", ""),
                        new Link("https://vk.cc/cdqmBa", "Восхитительная природа", "Расслабьтесь, наблюдая за природой", ""),
                        new Link("https://vk.cc/cdqmDA", "Ночное небо", "Расслабьтесь, наблюдая за звездами", ""),
                        new Link("https://vk.cc/cdqmFH", "Природа", "Расслабьтесь, наблюдая за красками природы", ""),
                        new Link("https://vk.cc/cdqmIq", "Калифорния", "Расслабьтесь, наблюдая за красотами Калифорнии", ""),
                        new Link("https://vk.cc/cdqmKG", "Тропический дождь", "Расслабьте под звуки дождя", ""),
                        new Link("https://vk.cc/cdqmMy", "", "Река и успокаивающая музыка", "Расслабьтесь, под успокаивающую музыку"),
                        new Link("https://vk.cc/cdqmPh", "Норвегия", "Расслабьтесь, наблюдая за видами Норвегии", ""),
                        new Link("https://vk.cc/cdqmQD", "Россия", "Расслабьтесь, наблюдая за красивыми видами России", ""),
                        new Link("https://vk.cc/cdqmSB", "Швейцария", "Красивые виды Швейцарии", ""),
                        new Link("https://vk.cc/cdqmU7", "Лесная река", "Расслабьтесь, под звуки реки", ""),
                        new Link("https://vk.cc/cdqmVv", "Утренняя природа", "Расслабьтесь, наблюдая за утренней природой", "")
                }
                )
        );
    }
}
