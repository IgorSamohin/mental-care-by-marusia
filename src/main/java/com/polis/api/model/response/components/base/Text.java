package com.polis.api.model.response.components.base;

import com.polis.api.model.response.components.base.styles.TextStyle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Text extends BaseComponent {
    /**
     * <b>Обязательный параметр.</b>
     * <p>
     * Текст, который увидит пользователь.
     */
    private String value;

    /**
     * <b>Необязательный параметр.</b>
     * <p>
     * Стиль текста.
     */
    private TextStyle style;

    public Text(String text) {
        this.value = text;
    }

    //todo find out abut style and add it

}
