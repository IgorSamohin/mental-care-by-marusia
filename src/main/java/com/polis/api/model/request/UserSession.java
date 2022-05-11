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

    @JsonProperty("prev_number_game")
    public int prevNumberGame = -1;

    @JsonProperty("end_game_number")
    public int endGameNumber = -1;


    public UserSession(int prevStateId) {
        this.prevStateId = prevStateId;
    }
}
