package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.BangPhanCongCongNhan;
import com.openjfx.qllspahg.entity.model.phanCongCongNhan.BangThongTinCongNhan;
import com.openjfx.qllspahg.entity.model.phanCongCongNhan.BangThongTinCongNhanCoTo;
import com.openjfx.qllspahg.entity.model.phanCongCongNhan.BangThongTinSoLuongLamDuocTheoTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSPhanCongCongNhan {
    ObservableList<BangThongTinCongNhan> DSThongTinCongNhan = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSTTPhanCongCongNhan = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSPhanCongCanSave = FXCollections.observableArrayList();
    ObservableList<BangThongTinCongNhanCoTo> DSTTPhanCongChuaLuuCoTo = FXCollections.observableArrayList();
    ObservableList<BangThongTinSoLuongLamDuocTheoTo> DSLoadSoLuongDaPhanCong = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSPhanCongCongNhanDaLuu = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSPhanCongCongNhanUpdate = FXCollections.observableArrayList();


}
