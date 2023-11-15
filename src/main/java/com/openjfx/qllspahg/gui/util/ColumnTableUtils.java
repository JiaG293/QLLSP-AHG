package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.entity.NhanVien;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ColumnTableUtils {
    public static <S, T> TableColumn<S, String> taoColumnAo(
            String tenColumn,
            Callback<S, Integer> maColumn,
            Callback<Integer, String> giaTriColumn) {

        TableColumn<S, String> column = new TableColumn<>(tenColumn);
        column.setCellValueFactory(param -> {
            S entity = param.getValue();
            int entityId = maColumn.call(entity);
            return new SimpleStringProperty(giaTriColumn.call(entityId));
        });

        return column;
    }
    public static String getNhanVienHoTen(NhanVien nhanVien) {
        return nhanVien.getHoNV() + " " + nhanVien.getTenNV();
    }

    public static String getNhanVienPhongBan(NhanVien nhanVien) {
        return nhanVien.getPhongBan().getTenPB();
    }
}
