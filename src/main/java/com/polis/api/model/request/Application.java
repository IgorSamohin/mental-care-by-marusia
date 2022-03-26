package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Application {
    @JsonProperty("user_id")
    private String applicationId;

    @JsonProperty("application_type")
    private String applicationType;
}
