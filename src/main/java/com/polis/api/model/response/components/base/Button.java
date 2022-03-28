package com.polis.api.model.response.components.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@Getter
@Setter
public class Button {
    private String title;
    private String url;
    private JSONObject payload;
}
