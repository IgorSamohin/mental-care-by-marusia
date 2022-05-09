package com.polis.api.storage.providers;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PictureProvider {
    private final List<String> pictureIdList = new ArrayList<>();


    public List<String> getPictureIdList(int stateId) {
        return pictureIdList;
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        pictureIdList.add("457239017");
        pictureIdList.add("457239018");
    }
}
