package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Request {
    private String command;

    @JsonProperty("original_utterance")
    private String originalUtterance;

    private String type;

    private JSONObject payload;

    private Nlu nlu;
}
