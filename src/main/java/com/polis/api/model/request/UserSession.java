package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserSession {
    @JsonProperty("prev_state_id")
    public int prevStateId;
}
