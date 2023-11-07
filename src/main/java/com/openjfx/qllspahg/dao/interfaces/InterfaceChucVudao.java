package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.ChucVu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface InterfaceChucVudao {
    public ObservableList<ChucVu> DSChucVu = FXCollections.observableArrayList();
    public ObservableList<ChucVu> getAllChucVuNhanVien();
}
