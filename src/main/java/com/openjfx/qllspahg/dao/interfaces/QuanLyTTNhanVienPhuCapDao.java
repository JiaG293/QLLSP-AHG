package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.PhuCap;
import javafx.collections.ObservableList;

public interface QuanLyTTNhanVienPhuCapDao {

    public ObservableList<PhuCap> getAllPhuCapNhanVien();
    public ObservableList<PhuCap> getAllPhuCapNhanVienTheoMa();
}
