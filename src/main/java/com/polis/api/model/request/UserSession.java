package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSession {
    @JsonProperty("prev_state_id")
    public int prevStateId = -1;

    @JsonProperty("prev_number_game")
    @Nullable
    public Integer prevNumberGame;

    @JsonProperty("end_game_number")
    @Nullable
    public Integer endGameNumber;

    public UserSession(int prevStateId, Integer endGameNumber) {
        this.prevStateId = prevStateId;
        this.endGameNumber = endGameNumber;
    }

    public UserSession(int prevStateId) {
        this.prevStateId = prevStateId;
    }
}
