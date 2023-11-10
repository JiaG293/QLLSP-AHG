package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.PhuCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSQLThongTinNhanVien {
    public ObservableList<NhanVien> DSNhanVien = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNhanVienThem = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNhanVienXoa = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNhanVienSua = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNhanVienreset = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNhanVienphu = FXCollections.observableArrayList();
    public ObservableList<PhongBan> DSPhongBan = FXCollections.observableArrayList();
    public ObservableList<ChucVu> DSChucVu = FXCollections.observableArrayList();
    public ObservableList<PhuCap> DSPhuCap = FXCollections.observableArrayList();

}
