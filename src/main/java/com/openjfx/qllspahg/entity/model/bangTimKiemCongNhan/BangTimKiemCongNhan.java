package com.openjfx.qllspahg.entity.model.bangTimKiemCongNhan;

import com.openjfx.qllspahg.entity.CongNhan;
import com.openjfx.qllspahg.entity.NhanVien;

public class BangTimKiemCongNhan {

    private boolean trangThai;
    private CongNhan congNhan;
    private int soNgayDiLam;
    private int soNgaynghiPhep;
    private int soNgayNghiKoPhep;
    private int soLuongDuocPhanCong;
    private int soLuongDaLam;

    public BangTimKiemCongNhan(boolean trangThai, CongNhan congNhan, int soNgayDiLam, int soNgaynghiPhep, int soNgayNghiKoPhep, int soLuongDuocPhanCong, int soLuongDaLam) {
        this.trangThai = trangThai;
        this.congNhan = congNhan;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgaynghiPhep = soNgaynghiPhep;
        this.soNgayNghiKoPhep = soNgayNghiKoPhep;
        this.soLuongDuocPhanCong = soLuongDuocPhanCong;
        this.soLuongDaLam = soLuongDaLam;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
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

    public int getSoLuongDuocPhanCong() {
        return soLuongDuocPhanCong;
    }

    public void setSoLuongDuocPhanCong(int soLuongDuocPhanCong) {
        this.soLuongDuocPhanCong = soLuongDuocPhanCong;
    }

    public int getSoLuongDaLam() {
        return soLuongDaLam;
    }

    public void setSoLuongDaLam(int soLuongDaLam) {
        this.soLuongDaLam = soLuongDaLam;
    }
}
