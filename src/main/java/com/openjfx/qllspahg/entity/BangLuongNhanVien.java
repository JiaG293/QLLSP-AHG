package com.openjfx.qllspahg.entity;

import java.time.LocalDate;

public class BangLuongNhanVien {
    private BangChamCongNhanVien maBangChamCongNhanVien;
    private TamUngNhanVien maTamUngNhanvien;
    private Double luongNV;
    private Double bhxhNV;
    private Double bhytNV;
    private Double tongLuongNV;
    private LocalDate ngayTinhLuong;

    public BangLuongNhanVien(BangChamCongNhanVien maBangChamCongNhanVien, TamUngNhanVien maTamUngNhanvien, Double luongNV, Double bhxhNV, Double bhytNV, Double tongLuongNV) {
        this.maBangChamCongNhanVien = maBangChamCongNhanVien;
        this.maTamUngNhanvien = maTamUngNhanvien;
        this.luongNV = luongNV;
        this.bhxhNV = bhxhNV;
        this.bhytNV = bhytNV;
        this.tongLuongNV = tongLuongNV;
    }

    public BangChamCongNhanVien getMaBangChamCongNhanVien() {
        return maBangChamCongNhanVien;
    }

    public void setMaBangChamCongNhanVien(BangChamCongNhanVien maBangChamCongNhanVien) {
        this.maBangChamCongNhanVien = maBangChamCongNhanVien;
    }

    public TamUngNhanVien getMaTamUngNhanvien() {
        return maTamUngNhanvien;
    }

    public void setMaTamUngNhanvien(TamUngNhanVien maTamUngNhanvien) {
        this.maTamUngNhanvien = maTamUngNhanvien;
    }

    public LocalDate getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(LocalDate ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }
}
