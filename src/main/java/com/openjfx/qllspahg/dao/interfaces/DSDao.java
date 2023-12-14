package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.ChiTietLuongCongNhan;
import com.openjfx.qllspahg.entity.model.ChiTietLuongNhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSDao {
    public ObservableList<SanPham> DSSANPHAM = FXCollections.observableArrayList();
    public ObservableList<HopDong> DSHOPDONG = FXCollections.observableArrayList();
    public ObservableList<ChiTietHopDong> DSCTHOPDONG = FXCollections.observableArrayList();
    public ObservableList<BangChamCongNhanVien> DSCCNHANVIEN = FXCollections.observableArrayList();
    public ObservableList<NhanVien> DSNHANVIEN = FXCollections.observableArrayList();
    public ObservableList<PhongBan> DSPHONGBAN = FXCollections.observableArrayList();
    public ObservableList<CongDoan> DSCONGDOAN = FXCollections.observableArrayList();
    public ObservableList<BangChamCongCongNhan> DSCHAMCONGCONGNHAN = FXCollections.observableArrayList();
    public ObservableList<BangChamCongCongNhan> DSCHAMCONGCONGNHANUPDATE = FXCollections.observableArrayList(); //khi bangchamcong duoc sua doi se them vao day
    public ObservableList<ChiTietLuongNhanVien> DSCHITIETLUONGNHANVIEN = FXCollections.observableArrayList();
    public ObservableList<ChiTietLuongCongNhan> DSCHITIETLUONGCONGNHAN = FXCollections.observableArrayList();
    public ObservableList<BangLuongCongNhan> DSBANGLUONGCN = FXCollections.observableArrayList();
    public ObservableList<BangLuongCongNhan> DSBANGLUONGCNCHON = FXCollections.observableArrayList();
    public ObservableList<BangLuongNhanVien> DSBANGLUONGNV = FXCollections.observableArrayList();
    public ObservableList<BangLuongNhanVien> DSBANGLUONGNVCHON = FXCollections.observableArrayList();
    public ObservableList<TaiKhoan> DSTAIKHOAN= FXCollections.observableArrayList();
}
