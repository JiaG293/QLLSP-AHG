package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSQLThongTinCongNhan {
    public ObservableList<CongNhan> DSCongNhan = FXCollections.observableArrayList();
    public ObservableList<CongNhan> DSCongNhanThem = FXCollections.observableArrayList();
    public ObservableList<CongNhan> DSCongNhanXoa = FXCollections.observableArrayList();
    public ObservableList<CongNhan> DSCongNhanSua = FXCollections.observableArrayList();
    public ObservableList<CongNhan> DSCongNhanreset = FXCollections.observableArrayList();
    public ObservableList<CongNhan> DSCongNhanphu = FXCollections.observableArrayList();
    public ObservableList<ToSanXuat> DSToSanXuat = FXCollections.observableArrayList();
    public ObservableList<ChucVu> DSChucVu = FXCollections.observableArrayList();
    public ObservableList<PhuCap> DSPhuCap = FXCollections.observableArrayList();
}
