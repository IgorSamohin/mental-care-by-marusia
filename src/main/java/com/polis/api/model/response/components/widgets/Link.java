package com.polis.api.model.response.components.widgets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Getter
public class Link extends WidgetElement {
    public String url;
    public String title;
    public String text;
    @JsonProperty("image_id")
    public String imageId;

    public Link(String url, String title, String text, String imageId) {
        this.url = url;
        this.title = title;
        this.text = text;
        this.imageId = imageId;
    }

    public Link(String url, String title, String text) {
        this(url, title, text, null);
    }
}
