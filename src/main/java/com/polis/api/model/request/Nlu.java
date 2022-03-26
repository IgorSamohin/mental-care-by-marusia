package com.polis.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Объект, содержащий слова и именованные сущности, которые Маруся извлекает из запроса пользователя
 */
@AllArgsConstructor
@Getter
public class Nlu {
    private List<String> tokens = new ArrayList<>();
    private List<String> entities = new ArrayList<>();
}
