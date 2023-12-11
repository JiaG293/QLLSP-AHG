package com.openjfx.qllspahg.entity.model.TamUngNhanVien;

import com.openjfx.qllspahg.entity.TamUngNhanVien;

public class BangTamUngNhanVienKemSoNgayDiLam {
    private TamUngNhanVien tamUng;
    private int soNgayDiLam;

    public BangTamUngNhanVienKemSoNgayDiLam(TamUngNhanVien tamUng, int soNgayDiLam) {
        this.tamUng = tamUng;
        this.soNgayDiLam = soNgayDiLam;
    }

    public BangTamUngNhanVienKemSoNgayDiLam() {
    }

    public TamUngNhanVien getTamUng() {
        return tamUng;
    }

    public void setTamUng(TamUngNhanVien tamUng) {
        this.tamUng = tamUng;
    }

    public int getSoNgayDiLam() {
        return soNgayDiLam;
    }

    public void setSoNgayDiLam(int soNgayDiLam) {
        this.soNgayDiLam = soNgayDiLam;
    }

    @Override
    public String toString() {
        return "BangTamUngNhanVien{" +
                "tamUng=" + tamUng +
                ", soNgayDiLam=" + soNgayDiLam +
                '}';
    }
}
