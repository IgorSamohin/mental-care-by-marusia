package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Session {

    public Session(String sessionId, String userId, int messageId) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.messageId = messageId;
    }

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("skill_id")
    private String skillId;

    @JsonProperty("new")
    private boolean newSession;

    @JsonProperty("message_id")
    private int messageId;

    private User user;
    private Application application;
}
