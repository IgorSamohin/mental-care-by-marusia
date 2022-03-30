package com.polis.api.model.response.components.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Предназначен для отображения заголовка виджета.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Header {
    @JsonProperty("header_title")
    private String headerTitle;

    @JsonProperty("header_icon")
    private ImageItem[] headerIcon;
}
