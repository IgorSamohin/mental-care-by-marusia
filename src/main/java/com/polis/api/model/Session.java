package com.polis.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Session {
    @JsonProperty("session_id")
    public String sessionId;

    /**
     * Идентификатор экземпляра приложения, в котором пользователь общается с Марусей, максимум 64 символа
     * <p>
     * Уникален в разрезе: «скилл + приложение (устройство)»
     */
    @JsonProperty("user_id")
    public String userId;

    @JsonProperty("skill_id")
    public String skillId;

    @JsonProperty("new")
    public boolean newSession;

    @JsonProperty("message_id")
    public int messageId;

    /**
     * Идентификатор аккаунта пользователя (максимум 64 символа).
     * <p>
     * Уникален в разрезе: «скилл + аккаунт»
     */
    @JsonProperty("user")
    public User user;

    public Application application;

    @JsonProperty("auth_token")
    public String authToken;

    public Session(String sessionId, String applicationId, String applicationType, String userId, int messageId) {
        this.sessionId = sessionId;
        this.userId = applicationId;
        this.user = new User(userId);
        this.application = new Application(applicationId, applicationType);
        this.messageId = messageId;
    }
}
