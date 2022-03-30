package com.polis.api.model.response.components.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.base.types.ActionType;
import lombok.Getter;
import lombok.Setter;

/**
 * Объект, описывающий действие, которое будет выполнено после нажатия на соответствующий элемент виджета.
 * <p>
 * Примеры действий: открыть мини-приложение, открыть ссылку.
 */
@Getter
@Setter
public class Action {
    private ActionType type;

    /**
     * Адрес, на который будет перенаправлен пользователь.
     * <p>
     * <b>Необязательный</b>, ужен только при <b>type=ActionType.OPEN_URL</b>
     */
    private String url;

    /**
     * Идентификатор приложения, по которому будет найден объект мини-приложения в массиве <b>mini_apps</b>
     * <p>
     * <b>Обязательный.</b>
     */
    @JsonProperty("app_id")
    private int appId;

    public Action(String url) {
        this.type = ActionType.OPEN_URL;
        this.url = url;
    }

    public Action(int miniAppId) {
        this.type = ActionType.OPEN_MINI_APP;
        this.appId = miniAppId;
    }
}
