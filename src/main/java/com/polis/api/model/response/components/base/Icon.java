package com.polis.api.model.response.components.base;

import com.polis.api.model.response.components.base.styles.IconStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Предназначен для отображения иконки.
 * <p>
 * <b>!Иконка имеет фиксированный размер.</b>
 */
@AllArgsConstructor
@Getter
public class Icon {
    /**
     * <b>Обязательный параметр.</b>
     */
    private ImageItem[] items;

    /**
     * <b>Необязательный параметр.</b>
     */
    private IconStyle style;

    public Icon(ImageItem[] items) {
        this.items = items;
    }

    public Icon(ImageItem item, IconStyle style) {
        this.items = new ImageItem[1];
        items[0] = item;
        this.style = style;
    }

    public Icon(ImageItem item) {
        this(item, null);
    }
}
