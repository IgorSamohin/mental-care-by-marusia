package com.polis.api.model.response.components.base.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.base.VerticalAlign;
import com.polis.api.model.response.components.base.types.ImageStyleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ImageStyle {
    /**
     * Тип картинки. Значение по умолчанию: square.
     */
    private ImageStyleType type;

    @JsonProperty("vertical_align")
    private VerticalAlign verticalAlign;
}
