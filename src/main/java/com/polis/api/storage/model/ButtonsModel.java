package com.polis.api.storage.model;

import com.polis.api.model.response.ResponseButton;
import com.polis.api.storage.ZoneButtons;

import java.util.Arrays;

public final class ButtonsModel {
    private final ResponseButton[] buttons;

    public ButtonsModel(ResponseButton[] buttons) {
        this.buttons = buttons;
    }

    @Deprecated
    public ButtonsModel(ZoneButtons buttons) {
        this.buttons = new ResponseButton[buttons.getButtons().length];
        String[] buttonsButtons = buttons.getButtons();
        for (int i = 0; i < buttonsButtons.length; i++) {
            String button = buttonsButtons[i];
            this.buttons[i] = new ResponseButton(button);
        }
    }

    public ResponseButton[] buttons() {
        return buttons;
    }

}
