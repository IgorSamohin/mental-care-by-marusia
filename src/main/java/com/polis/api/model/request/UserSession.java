package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSession {
    @JsonProperty("prev_state_id")
    public int prevStateId = -1;

    @JsonProperty("is_wrong_command")
    public boolean isWrongCommand = false;
}
