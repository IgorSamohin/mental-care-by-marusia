package com.polis.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.request.UserSession;
import com.polis.api.model.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MarusiaResponse {
    private Response response;
    private Session session;
    private String version;
    @JsonProperty("session_state")
    private UserSession sessionState;
}
