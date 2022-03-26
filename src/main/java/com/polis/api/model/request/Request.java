package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@ToString
public class Request {
    public String command;

    @JsonProperty("original_utterance")
    public String originalUtterance;

    public String type;

    public JSONObject payload;

    public Nlu nlu;
}
