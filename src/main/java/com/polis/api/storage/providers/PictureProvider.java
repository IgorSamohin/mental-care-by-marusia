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
        pictureIdList.add("457239019");
        pictureIdList.add("457239020");
        pictureIdList.add("457239021");
        pictureIdList.add("457239022");
        pictureIdList.add("457239023");
        pictureIdList.add("457239024");
        pictureIdList.add("457239025");
        pictureIdList.add("457239026");
        pictureIdList.add("457239027");
        pictureIdList.add("457239028");
        pictureIdList.add("457239029");
        pictureIdList.add("457239030");
        pictureIdList.add("457239031");
        pictureIdList.add("457239032");
        pictureIdList.add("457239033");
        pictureIdList.add("457239034");
        pictureIdList.add("457239035");
        pictureIdList.add("457239036");
        pictureIdList.add("457239037");
        pictureIdList.add("457239038");
        pictureIdList.add("457239039");
        pictureIdList.add("457239040");
        pictureIdList.add("457239041");
        pictureIdList.add("457239042");
        pictureIdList.add("457239043");
        pictureIdList.add("457239044");
        pictureIdList.add("457239045");
        pictureIdList.add("457239046");
        pictureIdList.add("457239047");
        pictureIdList.add("457239048");
        pictureIdList.add("457239049");
        pictureIdList.add("457239050");
        pictureIdList.add("457239051");
        pictureIdList.add("457239052");
        pictureIdList.add("457239053");
        pictureIdList.add("457239054");
        pictureIdList.add("457239055");
        pictureIdList.add("457239056");
        pictureIdList.add("457239057");
        pictureIdList.add("457239058");
        pictureIdList.add("457239059");
        pictureIdList.add("457239060");
        pictureIdList.add("457239061");
        pictureIdList.add("457239062");
        pictureIdList.add("457239063");
    }
}
