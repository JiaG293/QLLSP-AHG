
package com.openjfx.qllspahg.entity.model.timKiemNhanVien;

import com.openjfx.qllspahg.entity.NhanVien;

public class BangTimKiemNhanVien {
    private boolean trangThai;
    private NhanVien nhanVien;
    private int soNgayDiLam;
    private int soNgaynghiPhep;
    private int soNgayNghiKoPhep;

    public BangTimKiemNhanVien(boolean trangThai, NhanVien nhanVien, int soNgayDiLam, int soNgaynghiPhep, int soNgayNghiKoPhep) {
        this.trangThai = trangThai;
        this.nhanVien = nhanVien;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgaynghiPhep = soNgaynghiPhep;
        this.soNgayNghiKoPhep = soNgayNghiKoPhep;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getSoNgayDiLam() {
        return soNgayDiLam;
    }

    public void setSoNgayDiLam(int soNgayDiLam) {
        this.soNgayDiLam = soNgayDiLam;
    }

    public int getSoNgaynghiPhep() {
        return soNgaynghiPhep;
    }

    public void setSoNgaynghiPhep(int soNgaynghiPhep) {
        this.soNgaynghiPhep = soNgaynghiPhep;
    }

    public int getSoNgayNghiKoPhep() {
        return soNgayNghiKoPhep;
    }

    public void setSoNgayNghiKoPhep(int soNgayNghiKoPhep) {
        this.soNgayNghiKoPhep = soNgayNghiKoPhep;
    }

    @Override
    public String toString() {
        return "BangTimKiemNhanVien{" +
                "trangThai=" + trangThai +
                ", nhanVien=" + nhanVien +
                ", soNgayDiLam=" + soNgayDiLam +
                ", soNgaynghiPhep=" + soNgaynghiPhep +
                ", soNgayNghiKoPhep=" + soNgayNghiKoPhep +
                '}';
    }
}
