package com.polis.api.model.response.components.widgets;

import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ДОКА НЕПОЛНАЯ ИЛИ Я ЧТО-ТО НЕ ПОНЯЛ! //FIXME ПОКА ЧТО ЛУЧШЕ НЕ ИСПОЛЬЗОВАТЬ ЭТОТ ВИДЖЕТ
 * <p>
 * Этот тип виджета предполагает построчное размещение базовых элементов.
 * <p>
 * Одна строка (ряд) может содержать набор из нескольких элементов.
 * <p>
 * Наборы могут совпадать и иметь одинаковые части, но это необязательно.
 */
@Getter
@Setter
public class Informer extends BaseWidgetPayload {
    @AllArgsConstructor
    @Getter
    @Setter
    static class InformerRow extends WidgetElement {
        private WidgetElement left;
        private WidgetElement middle;
        private WidgetElement right;
        private Action action;
    }

    private InformerRow[] rows;

    private Informer(InformerRow[] rows, Header header, Action action, Footer footer) {
        super(null, header, action, footer);
        this.rows = rows;
    }
}
