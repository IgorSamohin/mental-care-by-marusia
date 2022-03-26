package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@ToString
public class Meta {
    @JsonProperty("client_id")
    public String clientId;

    @JsonProperty("locale")
    public String locale;

    @JsonProperty("timezone")
    public String timeZone;

    @JsonProperty("interfaces")
    public JSONObject interfaces;

    @JsonProperty("_city_ru")
    public String city;
}
