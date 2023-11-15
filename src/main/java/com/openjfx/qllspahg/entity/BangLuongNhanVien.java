package com.openjfx.qllspahg.entity;

import java.sql.Date;

public class BangLuongNhanVien {
    private BangChamCongNhanVien maBangChamCongNhanVien;
    private TamUngNhanVien maTamUngNhanvien;
    private double luongNV;
    private double bhxhNV;
    private double bhytNV;
    private double tongLuongNV;
    private Date ngayTinhLuong;

    public BangLuongNhanVien(BangChamCongNhanVien maBangChamCongNhanVien, TamUngNhanVien maTamUngNhanvien, double luongNV, double bhxhNV, double bhytNV, double tongLuongNV) {
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

    public Date getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(Date ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }
}
