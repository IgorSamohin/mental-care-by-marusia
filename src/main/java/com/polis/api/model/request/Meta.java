package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@Getter
@ToString
public class Meta {
    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("interfaces")
    private JSONObject interfaces;

    @JsonProperty("_city_ru")
    private String city;
}
