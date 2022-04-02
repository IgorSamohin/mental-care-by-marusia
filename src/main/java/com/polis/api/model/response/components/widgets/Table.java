package com.polis.api.model.response.components.widgets;

import com.polis.api.model.response.components.base.Action;
import com.polis.api.model.response.components.base.Footer;
import com.polis.api.model.response.components.base.Header;
import lombok.Getter;
import lombok.Setter;

/**
 * Этот тип виджета позволяет представить набор из нескольких элементов в виде таблицы.
 * <p>
 * Наполнение и количество строк и столбцов таблицы вы можете определять самостоятельно
 */
@Getter
@Setter
public class Table extends BaseWidgetPayload {
    /**
     * <b>Необязательный</b> параметр.
     * <p>
     * Позволяет задать ширину колонок.
     */
    private int[] sizes;

    /**
     * В доке сказано, что это набор ImageItems, но есть ощущение, что это ложь и на самом деле это набор базовых
     * компонентов или кастомных элементов таблицы
     */
    private WidgetElement[][] items;

    public Table(WidgetElement[][] items, Header header, Action action, Footer footer) {
        super(null, header, action, footer);
        this.items = items;
    }
}
