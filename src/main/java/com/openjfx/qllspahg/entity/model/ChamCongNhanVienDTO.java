package com.openjfx.qllspahg.entity.model;

import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.NhanVien;
import javafx.collections.ObservableList;

public class ChamCongNhanVienDTO {
    private NhanVien maNhanVien;
    private ObservableList<BangChamCongNhanVien> listChamCongNhanVien;

    public ChamCongNhanVienDTO(NhanVien maNV, ObservableList<BangChamCongNhanVien> listChamCongNhanVien) {
        this.maNhanVien = maNhanVien;
        this.listChamCongNhanVien = listChamCongNhanVien;
    }
    public NhanVien getNhanVien() {
        return maNhanVien;
    }

    public ObservableList<BangChamCongNhanVien> listChamCongNhanVien() {
        return listChamCongNhanVien;
    }
}
