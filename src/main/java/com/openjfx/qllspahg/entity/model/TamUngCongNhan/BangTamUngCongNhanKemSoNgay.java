package com.openjfx.qllspahg.entity.model.TamUngCongNhan;

import com.openjfx.qllspahg.entity.TamUngCongNhan;

public class BangTamUngCongNhanKemSoNgay {
    private TamUngCongNhan tamUng;
    private int soNgaydiLam;

    public BangTamUngCongNhanKemSoNgay(TamUngCongNhan tamUng, int soNgaydiLam) {
        this.tamUng = tamUng;
        this.soNgaydiLam = soNgaydiLam;
    }

    public TamUngCongNhan getTamUng() {
        return tamUng;
    }

    public void setTamUng(TamUngCongNhan tamUng) {
        this.tamUng = tamUng;
    }

    public int getSoNgaydiLam() {
        return soNgaydiLam;
    }

    public void setSoNgaydiLam(int soNgaydiLam) {
        this.soNgaydiLam = soNgaydiLam;
    }

    @Override
    public String toString() {
        return "BangTamUngCongNhanKemSoNgay{" +
                "tamUng=" + tamUng +
                ", soNgaydiLam=" + soNgaydiLam +
                '}';
    }
}
