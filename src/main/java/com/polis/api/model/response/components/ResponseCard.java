package com.polis.api.model.response.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResponseCard {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class ImageId {
        @JsonProperty("image_id")
        int imageId;
    }

    private CardType type;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("image_id")
    private Integer imageId = null;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ImageId[] items = null;

    public ResponseCard(Integer imageId) {
        this.type = CardType.BIG_IMAGE;
        this.imageId = imageId;
    }

    public ResponseCard(int[] items) {
        this.type = CardType.ITEMS_LIST;
        this.items = new ImageId[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = new ImageId(items[i]);
        }
    }
}
