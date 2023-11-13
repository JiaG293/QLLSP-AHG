package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;

public class CheckCell extends TableCell<BangChamCongNhanVien, Boolean> {

    private CheckBox checkBox;

    public CheckCell() {
        checkBox = new CheckBox();
        setGraphic(checkBox);
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) {
            checkBox.setSelected(item);
        } else {
            checkBox.setSelected(false);
        }
    }
}