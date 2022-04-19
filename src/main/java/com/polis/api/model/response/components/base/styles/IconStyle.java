package com.polis.api.model.response.components.base.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.base.VerticalAlign;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IconStyle {
    @JsonProperty("vertical_align")
    private VerticalAlign verticalAlign;
}
