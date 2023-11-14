package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.ChamCongNhanVienDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSDao {
    public ObservableList<SanPham> DSSANPHAM = FXCollections.observableArrayList();
    public ObservableList<HopDong> DSHOPDONG = FXCollections.observableArrayList();
    public ObservableList<BangChamCongNhanVien> DSCCNHANVIEN = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNHANVIEN = FXCollections.observableArrayList();
    public ObservableList<ChamCongNhanVienDTO> DSCHAMCONGDTO = FXCollections.observableArrayList();
    public ObservableList<PhongBan> DSPHONGBAN = FXCollections.observableArrayList();
}
