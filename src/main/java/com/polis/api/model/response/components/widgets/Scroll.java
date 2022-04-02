package com.polis.api.model.response.components.widgets;

import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.Getter;
import lombok.Setter;

/**
 * Этот тип виджета позволяет выстроить элементы в одну линию и листать элементы по горизонтали.
 */
@Getter
@Setter
public class Scroll extends BaseWidgetPayload {
    public Scroll(WidgetElement[] items, Header header, Action action, Footer footer) {
        super(items, header, action, footer);
    }
}
