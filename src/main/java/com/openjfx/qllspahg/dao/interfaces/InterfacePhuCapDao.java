package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.PhuCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface InterfacePhuCapDao {
    public ObservableList<PhuCap> DSPhuCap = FXCollections.observableArrayList();
    public ObservableList<PhuCap> getAllPhuCapNhanVien();
    public ObservableList<PhuCap> getAllPhuCapNhanVienTheoMa();
}
