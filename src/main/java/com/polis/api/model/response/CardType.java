package com.polis.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CardType {
    @JsonProperty("BigImage")
    BIG_IMAGE("BigImage"),
    @JsonProperty("ItemsList")
    ITEMS_LIST("ItemsList");

    private String type;

    CardType(String itemsList) {
        this.type = itemsList;
    }
}
