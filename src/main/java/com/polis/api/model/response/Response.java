package com.polis.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {
    private List<String> text = new ArrayList<>();
    private String tts;
    private List<Button> buttons;

    @JsonProperty("end_session")
    private boolean endSession;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Card card;

    private List<Command> commands = new ArrayList<>();

    public Response(String text, boolean endSession) {
        this.text.add(text);
        this.tts = text;
        this.endSession = endSession;
    }

    public Response(String text, String tts, boolean endSession) {
        this.text.add(text);
        this.tts = tts;
        this.endSession = endSession;
    }

    public Response(String text, String tts, boolean endSession, List<Button> buttons) {
        this(text, tts, endSession);

        this.buttons = buttons;
    }

    public Response(List<String> text, boolean endSession) {
        this.text = text;
        this.endSession = endSession;
    }

    public Response(List<String> text, String tts, boolean endSession) {
        this.text = text;
        this.tts = tts;
        this.endSession = endSession;
    }
}
