package com.polis.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@Getter
@Setter
public class ResponseButton {
    private String title;
    private String url;
    private JSONObject payload;
}
