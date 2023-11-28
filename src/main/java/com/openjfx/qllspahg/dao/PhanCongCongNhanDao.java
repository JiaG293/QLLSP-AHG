package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PhanCongCongNhanDao {
private ObservableList<CongNhan> dsCN = FXCollections.observableArrayList();
private ObservableList<ChiTietHopDong> dsChiTietHD = FXCollections.observableArrayList();
private ObservableList<CongDoan> dsCD = FXCollections.observableArrayList();
private ObservableList<HopDong> dsHopDong = FXCollections.observableArrayList();

public static PhanCongCongNhanDao getInstance (){
    return new PhanCongCongNhanDao();
}


}
