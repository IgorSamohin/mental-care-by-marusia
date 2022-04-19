package com.polis.api.model.response.components.widgets;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.Getter;
import lombok.Setter;

/**
 * Этот тип виджета можно использовать для получения разрешения пользователя (например, на доступ к его геолокации).
 */
@Getter
@Setter
public class Placeholder extends BaseWidgetPayload {

    @JsonUnwrapped
    private WidgetElement item;

    public Placeholder(WidgetElement item, Header header, Action action, Footer footer) {
        super(null, header, action, footer);
        this.item = item;
    }
}
