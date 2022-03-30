package com.polis.api.model.response.components.base;

import com.polis.api.model.response.components.base.styles.ButtonStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Button {
    /**
     * <b>Обязательный параметр.</b> Действие, которое выполнится при нажатии на кнопку.
     */
    private Action action;

    /**
     * <b>Необязательный параметр.</b> Текст кнопки. Содержит в себе параметр text
     */
    private Text title;

    /**
     * Иконка кнопки.
     */
    private Icon icon;

    /**
     * <b>Необязательный параметр.</b> Стиль кнопки.
     */
    private ButtonStyle style;

    //todo Сделать методы для быстрого создания кнопок при необходимости
}
