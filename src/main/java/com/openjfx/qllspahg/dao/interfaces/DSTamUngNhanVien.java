package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TamUngNhanVien;
import com.openjfx.qllspahg.entity.model.TamUngNhanVien.BangTamUngNhanVienKemSoNgayDiLam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSTamUngNhanVien {
    ObservableList<BangTamUngNhanVienKemSoNgayDiLam> DSTamUng = FXCollections.observableArrayList();
    PhongBan phongBan = new PhongBan();



}
