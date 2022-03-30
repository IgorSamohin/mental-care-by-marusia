package com.polis.api.model.response.components.base.types;

/**
 * Тип источника, из которого нужно загрузить данные в элемент image
 */
public enum ImageType {
    MINI_APP("mini_app"),
    INLINE("inline"),
    PROFILE("profile"),
    GROUP("group");

    ImageType(String type) {
    }
}
