package com.polis.api.model.response;

public enum CardType {
    BIG_IMAGE("BigImage"),
    ITEMS_LIST("ItemsList");

    private String type;

    CardType(String itemsList) {
        this.type = itemsList;
    }
}
