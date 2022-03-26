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
    public String sessionId;

    @JsonProperty("user_id")
    public String userId;

    @JsonProperty("skill_id")
    public String skillId;

    @JsonProperty("new")
    public boolean newSession;

    @JsonProperty("message_id")
    public int messageId;

    public User user;
    public Application application;

    public Session(String sessionId, String userId, int messageId) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.messageId = messageId;
    }
}
