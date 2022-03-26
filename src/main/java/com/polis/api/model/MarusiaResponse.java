package com.polis.api.model;

import com.polis.api.model.response.Response;
import com.polis.api.storage.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarusiaResponse {
    private Response response;
    private Session session;
    private String version;

    public static MarusiaResponse build(State state) {//todo nextState + session + обновить request.state;
        return null;
    }
}
