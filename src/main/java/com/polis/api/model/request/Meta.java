package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;

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
    public MetaInterfaces interfaces;

    @JsonProperty("_city_ru")
    public String city;

    @JsonProperty("client_player_status")
    public ClientPlayerStatus clientPlayerStatus;
}
