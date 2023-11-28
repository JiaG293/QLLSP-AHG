package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSPhanCongCongNhan {
    ObservableList<HopDong> DSMaHopDong = FXCollections.observableArrayList();
    ObservableList<ChiTietHopDong> DSChiTietHopDong= FXCollections.observableArrayList();
    ObservableList<CongDoan> DSCongDoan = FXCollections.observableArrayList();
    ObservableList<ToSanXuat> DSToSanXuat = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSPhanCongTungCongNhan = FXCollections.observableArrayList();


}
