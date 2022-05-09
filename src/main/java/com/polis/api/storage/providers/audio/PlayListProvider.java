package com.polis.api.storage.providers.audio;

import com.polis.api.model.response.components.audio.PlayList;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayListProvider {
    protected final List<PlayList> playLists = new ArrayList<>();

    public List<PlayList> getPlayLists() {
        return playLists;
    }
}
