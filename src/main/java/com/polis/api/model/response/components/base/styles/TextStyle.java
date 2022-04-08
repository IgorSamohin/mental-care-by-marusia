package com.polis.api.model.response.components.base.styles;

import com.polis.api.model.response.components.base.TextWeight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TextStyle {
    /**
     * Позволяет задавать толщину шрифта.
     */
    private TextWeight weight;
}
