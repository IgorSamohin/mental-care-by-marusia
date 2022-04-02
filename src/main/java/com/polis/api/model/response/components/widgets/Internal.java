package com.polis.api.model.response.components.widgets;

import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;

/**
 * Этот тип виджета можно использовать для оповещения пользователя о событии или новости.
 */
public class Internal extends BaseWidgetPayload {
    public Internal(WidgetElement[] items, Header header, Action action, Footer footer) {
        super(items, header, action, footer);
    }
}
