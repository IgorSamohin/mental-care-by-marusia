package com.polis.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Button {
    private String title;
    private String url;
    private JSONObject payload;
}
