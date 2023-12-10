package com.openjfx.qllspahg.entity.model.TamUngNhanVien;

import com.openjfx.qllspahg.entity.CongNhan;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TamUngNhanVien;

public class BangTamUngNhanVien {
    private TamUngNhanVien tamUng;
    private CongNhan hoVaTenCongNhan;
    private int soNgayDiLam;
    private PhongBan phongBan;

    public BangTamUngNhanVien(TamUngNhanVien tamUng, CongNhan hoVaTenCongNhan, int soNgayDiLam, PhongBan phongBan) {
        this.tamUng = tamUng;
        this.hoVaTenCongNhan = hoVaTenCongNhan;
        this.soNgayDiLam = soNgayDiLam;
        this.phongBan = phongBan;
    }

    public TamUngNhanVien getTamUng() {
        return tamUng;
    }

    public void setTamUng(TamUngNhanVien tamUng) {
        this.tamUng = tamUng;
    }

    public CongNhan getHoVaTenCongNhan() {
        return hoVaTenCongNhan;
    }

    public void setHoVaTenCongNhan(CongNhan hoVaTenCongNhan) {
        this.hoVaTenCongNhan = hoVaTenCongNhan;
    }

    public int getSoNgayDiLam() {
        return soNgayDiLam;
    }

    public void setSoNgayDiLam(int soNgayDiLam) {
        this.soNgayDiLam = soNgayDiLam;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    @Override
    public String toString() {
        return "BangTamUngNhanVien{" +
                "tamUng=" + tamUng +
                ", hoVaTenCongNhan=" + hoVaTenCongNhan +
                ", soNgayDiLam=" + soNgayDiLam +
                ", phongBan=" + phongBan +
                '}';
    }
}
