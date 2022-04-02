package com.polis.api.model.response.components.base.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum WidgetType {
    @JsonProperty("universal_informer")
    INFORMER("universal_informer"),
    @JsonProperty("universal_table")
    TABLE("universal_table"),
    @JsonProperty("universal_scroll")
    SCROLL("universal_scroll"),
    @JsonProperty("universal_counter")
    COUNTER("universal_counter"),
    @JsonProperty("universal_grid")
    GRID("universal_grid"),
    @JsonProperty("universal_card")
    CARD("universal_card"),
    @JsonProperty("universal_internal")
    INTERNAL("universal_internal"),
    @JsonProperty("universal_placeholder")
    PLACEHOLDER("universal_placeholder");

    WidgetType(String type) {

    }
}
