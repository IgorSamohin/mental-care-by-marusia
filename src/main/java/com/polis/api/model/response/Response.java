package com.polis.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.ResponseCard;
import com.polis.api.model.response.components.Command;
import com.polis.api.storage.State;
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
public class Response {
    private List<String> text = new ArrayList<>();
    private String tts;
    private List<ResponseButton> buttons = new ArrayList<>();

    @JsonProperty("end_session")
    private boolean endSession;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ResponseCard card;

    private List<Command> commands = new ArrayList<>();

    public Response(State state, boolean endSession) {
        this(state.getText(), state.getTts(), state.getCommands(), endSession);
    }

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

    public Response(String text, String tts, Command[] commands, boolean endSession) {
        this.text.add(text);
        this.tts = tts;
        this.commands = List.of(commands);
        this.endSession = endSession;
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
