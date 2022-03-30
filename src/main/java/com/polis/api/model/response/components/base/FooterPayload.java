package com.polis.api.model.response.components.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FooterPayload {
    /**
     * Заголовок. Обязательный при <b>type == accent_button</b>
     */
    private String title; // todo check if there can be Text class instead of String

    /**
     * Обязательный при <b>type == accent_button</b>
     */
    private Action action;

    /**
     * Обязательный при <b>type == user_stack</b>
     */
    private String description;

    /**
     * Обязательный при <b>type == user_stack</b>
     */
    private int count;

    /**
     * Обязательный при <b>type == user_stack</b>
     */
    private Image[] items;

    //todo Сделать методы для быстрого создания кнопок при необходимости

}
