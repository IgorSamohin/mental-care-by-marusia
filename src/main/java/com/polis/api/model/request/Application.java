package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Application {
    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("application_type")
    private String applicationType; //todo this field must be enum
}
