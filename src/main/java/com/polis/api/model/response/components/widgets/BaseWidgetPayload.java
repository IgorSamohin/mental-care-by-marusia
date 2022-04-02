package com.polis.api.model.response.components.widgets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseWidgetPayload {
    protected WidgetElement[] items;

    @JsonUnwrapped
    protected Header header;

    protected Action action;

    protected Footer footer;
}
