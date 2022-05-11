package com.polis.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.Command;
import com.polis.api.model.response.components.ResponseCard;
import com.polis.api.model.response.components.audio.AudioPlayer;
import com.polis.api.model.response.components.widgets.Link;
import com.polis.api.storage.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private List<String> text;
    private String tts;
    private List<ResponseButton> buttons;

    @JsonProperty("end_session")
    private boolean endSession;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ResponseCard card;

    private List<Command> commands;

    @JsonProperty("audio_player")
    private AudioPlayer audioPlayer = null;

    public Response(List<String> text, String tts, List<ResponseButton> buttons, boolean endSession, ResponseCard card, List<Command> commands, AudioPlayer audioPlayer) {
        this.text = text;
        this.tts = tts;
        this.buttons = buttons;
        this.endSession = endSession;
        this.card = card;
        this.commands = commands;
        this.audioPlayer = audioPlayer;
    }

    public Response(State state, boolean endSession) {
        this(List.of(state.getAnswer().text()), state.getAnswer().tts(), state.getButtons(), endSession, null, state.getCommands(), state.getAudioPlayer());
        Link link = state.getLink();
        if (link != null) {
            this.card = new ResponseCard(link);
        }
    }

    public Response(String text, String tts, boolean endSession) {
        this.text = List.of(text);
        this.tts = tts;
        this.endSession = endSession;
    }
}
