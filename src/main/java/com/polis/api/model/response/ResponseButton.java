package com.polis.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseButton {
    private String title;
    private String url;
    private ResponsePayload payload;
}
