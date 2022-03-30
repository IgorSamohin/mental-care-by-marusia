package com.polis.api.model.response.components.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polis.api.model.response.components.base.styles.ImageStyle;
import com.polis.api.model.response.components.base.types.ImageType;

/**
 * Предназначен для отображения одного изображения (картинки).
 * <p>
 * Картинка может быть задана как ссылкой на объект профиля, группы или приложения, так и непосредственно внутри объекта в виде массива Image Item.
 */
public class Image {
    /**
     * Тип источника, из которого нужно загрузить данные в элемент image
     */
    private ImageType type;

    /**
     * <b>Необязательный</b> параметр, который необходимо передавать только при <b>type</b> равном <b>mini_app, profile или
     * group</b>.
     * <p>
     * Идентификатор объекта, из которого будет взято изображение для отображения в элементе image.
     * Например, если type имеет значение profile, то в object_id необходимо передать идентификатор пользователя,
     * фотографию которого нужно загрузить в Image
     */
    @JsonProperty("object_id")
    private int objectId;

    /**
     * <b>Необязательный</b> параметр, необходимо передавать только при <b>type</b> равном <b>inline</b>
     */
    private ImageItem[] items;

    /**
     * <b>Необязательный</b> параметр.
     */
    private ImageStyle style;

    private Image(ImageType imageType, int objectId, ImageStyle style) {
        this.type = imageType;
        this.objectId = objectId;
        this.style = style;
    }

    public Image(ImageItem[] items, ImageStyle style) {
        this.items = items;
        this.type = ImageType.INLINE;
    }

    public Image(ImageItem[] items) {
        this(items, null);
    }

    public Image getProfileImage(int userId, ImageStyle style) {
        return new Image(ImageType.PROFILE, userId, style);
    }

    public Image getProfileImage(int userId) {
        return getProfileImage(userId, null);
    }

    public Image getMiniAppImage(int miniAppId, ImageStyle style) {
        return new Image(ImageType.MINI_APP, miniAppId, style);
    }

    public Image getMiniAppImage(int miniAppId) {
        return getMiniAppImage(miniAppId, null);
    }

    public Image getGroupImage(int groupId, ImageStyle style) {
        return new Image(ImageType.GROUP, groupId, style);
    }

    public Image getGroupImage(int groupId) {
        return getMiniAppImage(groupId, null);
    }
}
