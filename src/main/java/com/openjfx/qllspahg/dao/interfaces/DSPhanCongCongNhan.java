package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.ChiTietHopDong;
import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.entity.ToSanXuat;
import com.openjfx.qllspahg.entity.model.SoLuonNguoitTrongTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSPhanCongCongNhan {
    ObservableList<HopDong> DSMaHopDong = FXCollections.observableArrayList();
    ObservableList<ChiTietHopDong> DSChiTietHopDong= FXCollections.observableArrayList();
    ObservableList<CongDoan> DSCongDoan = FXCollections.observableArrayList();
    ObservableList<ToSanXuat> DSToSanXuat = FXCollections.observableArrayList();
    ObservableList<SoLuonNguoitTrongTo> DSSoLuongNguoiTrongTo = FXCollections.observableArrayList();

}
