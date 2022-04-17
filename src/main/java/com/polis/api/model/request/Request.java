package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.ResponsePayload;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Request {
    public String command;

    @JsonProperty("original_utterance")
    public String originalUtterance;

    public String type;

    public ResponsePayload payload; // fixme change type

    public Nlu nlu;
}
