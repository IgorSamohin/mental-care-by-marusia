package com.polis.api.model;

import com.polis.api.model.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarusiaResponse {
    private Response response;
    private Session session;
    private String version;
}
