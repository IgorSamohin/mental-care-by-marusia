package com.polis.api.model.response.components.widgets;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.Getter;
import lombok.Setter;

/**
 * Этот тип позволяет создать виджет в формате карточки: отобразить изображение, подпись и, при необходимости,
 * краткое описание.
 */
@Getter
@Setter
public class Card extends BaseWidgetPayload {
    @JsonUnwrapped
    private WidgetElement item;

    public Card(WidgetElement item, Header header, Action action, Footer footer) {
        super(null, header, action, footer);
        this.item = item;
    }
}
