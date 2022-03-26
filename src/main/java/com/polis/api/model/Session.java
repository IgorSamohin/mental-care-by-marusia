package com.polis.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.request.Application;
import com.polis.api.model.request.User;
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

    public Session(String sessionId, String userId, int messageId) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.messageId = messageId;
    }
}
