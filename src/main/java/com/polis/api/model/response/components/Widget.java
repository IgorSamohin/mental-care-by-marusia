package com.polis.api.model.response.components;

import com.polis.api.model.response.components.base.types.CommandType;
import com.polis.api.model.response.components.base.types.WidgetType;
import com.polis.api.model.response.components.widgets.BaseWidgetPayload;

public class Widget extends Command {
    private CommandType type = CommandType.WIDGET;
    private BaseWidgetPayload payload;
    private WidgetType layoutName;

    public Widget(BaseWidgetPayload payload, WidgetType layoutName) {
        this.payload = payload;
        this.layoutName = layoutName;
    }
}
