package com.polis.api.storage.model;

import com.polis.api.model.response.components.widgets.Card;
import com.polis.api.model.response.components.widgets.Link;

import java.util.concurrent.ThreadLocalRandom;

public class VideoLinksModel {
    private Link[] links;

    public VideoLinksModel(Link[] links) {
        this.links = links;
    }

    public VideoLinksModel(Link link) {
        this(new Link[]{link});
    }

    public Card getRandomVideoLink() {
        int i = ThreadLocalRandom.current().nextInt(links.length);
        Link link = links[i];
        return new Card(link);
    }
}
