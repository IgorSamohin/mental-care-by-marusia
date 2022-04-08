package com.polis.api.model.response.components.base;

import com.polis.api.model.response.components.base.types.FooterType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Предназначен для отображения нижней части виджета.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Footer extends BaseComponent {
    private FooterType type;

    private FooterPayload payload;
}
