package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.NhanVien;
import javafx.collections.ObservableList;

public interface ChamCongNhanVienDao {

    public ObservableList<NhanVien> getBangChamCongNV();

    public ObservableList<BangChamCongNhanVien> TaoBangChamCongNhanVien();

    public ObservableList<BangChamCongNhanVien> InsertBangChamCong(ObservableList<NhanVien> listNV);
}
