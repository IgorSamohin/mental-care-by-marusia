package com.polis.api.storage.providers;

import com.polis.api.storage.model.AdviceModel;
import com.polis.api.storage.model.Answer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdviceProvider {
    private final Map<Integer, AdviceModel> map = new HashMap<>();

    public AdviceModel getAdviceModel(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(1, new AdviceModel(
                new Answer[]{
                        new Answer("Занимайтесь спортом и чаще бывайте на природе.",
                                "Занимайтесь спортом и чаще бывайте на природе."),
                        new Answer("Позвоните близким и расскажите о проблеме",
                                "Позвоните близким и расскажите о проблеме")
                }
        ));
    }
}
