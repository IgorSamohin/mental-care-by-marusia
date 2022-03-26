package com.polis.api.model;

import com.polis.api.model.request.Meta;
import com.polis.api.model.request.Request;
import com.polis.api.model.request.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MarusiaRequest {
    private Meta meta;
    private Request request;
    private Session session;
    private State state;
    private String version;
}
