package com.polis.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MarusiaRequest {
    private Meta meta;
    private Request request;
    private Session session;
    private State state;
    private String version;
}
