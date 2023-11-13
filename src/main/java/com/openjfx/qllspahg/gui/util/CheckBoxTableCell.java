package com.openjfx.qllspahg.gui.util;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;

public class CheckBoxTableCell<S> extends TableCell<S, Boolean> {
    private final CheckBox checkBox;

    public CheckBoxTableCell() {
        checkBox = new CheckBox();
        checkBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (isEditing()) {
                commitEdit(newVal);
            }
        });
        this.setGraphic(checkBox);
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        this.setEditable(true);
    }

    @Override
    public void startEdit() {
        super.startEdit();
        if (isEmpty()) {
            return;
        }
        checkBox.requestFocus();
        checkBox.setSelected(!checkBox.isSelected());
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        checkBox.setSelected(!checkBox.isSelected());
    }

    @Override
    public void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(checkBox);
        }
    }
}
