package com.polis.api.model.response.components.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Позволяет добавить в виджет несколько изображений. Все параметры обязательные
 */
@AllArgsConstructor
@Getter
public class ImageItem {
    private int height;
    private int width;

    /**
     * Адрес, по которому необходимо взять изображение и загрузить в виджет.
     */
    private String url;
}
