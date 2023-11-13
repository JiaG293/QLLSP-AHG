package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSDao {
    public ObservableList<SanPham> DSSANPHAM = FXCollections.observableArrayList();
    public ObservableList<HopDong> DSHOPDONG = FXCollections.observableArrayList();
    public ObservableList<BangChamCongNhanVien> DSCCNHANVIEN = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNHANVIEN = FXCollections.observableArrayList();
}
