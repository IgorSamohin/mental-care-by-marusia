package com.polis.api.model;

import com.polis.api.model.request.Meta;
import com.polis.api.model.request.Request;
import com.polis.api.model.request.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class MarusiaRequest {
    public Meta meta;
    public Request request;
    public Session session;
    public State state;
    public String version;
}
