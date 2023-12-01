package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.BangPhanCongCongNhan;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhan;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhanCoTo;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinSoLuongLamDuocTheoTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DSPhanCongCongNhan {
    ObservableList<BangThongTinCongNhan> DSThongTinCongNhan = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSTTPhanCongCongNhan = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSPhanCongCanSave = FXCollections.observableArrayList();
    ObservableList<BangThongTinCongNhan> DSTTPhanCongChuaLuu = FXCollections.observableArrayList();
    ObservableList<BangThongTinCongNhanCoTo> DSTTPhanCongChuaLuuCoTo = FXCollections.observableArrayList();
    ObservableList<BangThongTinSoLuongLamDuocTheoTo> DSLoadSoLuongDaPhanCong = FXCollections.observableArrayList();
    ObservableList<BangPhanCongCongNhan> DSPhanCongLayLenTuBang = FXCollections.observableArrayList();


}
