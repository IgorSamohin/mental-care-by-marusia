package com.polis.api.model.response.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.base.types.CommandType;
import com.polis.api.model.response.components.base.types.WidgetType;
import com.polis.api.model.response.components.widgets.BaseWidgetPayload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Widget extends Command {
    private BaseWidgetPayload payload;
    @JsonProperty("layout_name")
    private WidgetType layoutName;

    public Widget() {
        this.type = CommandType.WIDGET;
    }

    public Widget(BaseWidgetPayload payload, WidgetType layoutName) {
        this();
        this.payload = payload;
        this.layoutName = layoutName;
    }
}
