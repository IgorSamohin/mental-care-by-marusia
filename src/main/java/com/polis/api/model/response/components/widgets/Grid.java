package com.polis.api.model.response.components.widgets;

import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.Getter;
import lombok.Setter;

/**
 * Этот тип виджета позволяет формировать плитку элементов.
 */
@Getter
@Setter
public class Grid extends BaseWidgetPayload {
    public Grid(WidgetElement[] items, Header header, Action action, Footer footer) {
        super(items, header, action, footer);
    }
}
