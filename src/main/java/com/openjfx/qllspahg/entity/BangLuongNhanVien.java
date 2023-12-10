package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class BangLuongNhanVien {
    private String maBLNV;
    private TamUngNhanVien maTamUngNhanvien;
    private double luongNV; //luong chua truy lanh
    private double bhxhNV;
    private double bhytNV;
    private double tongLuongNV; //luong thuc te
    private Date ngayTinhLuong;
    private Date ngayNhanLuong;
    private boolean trangThaiLuong;

    public BangLuongNhanVien(String maBLNV, TamUngNhanVien maTamUngNhanvien, double luongNV, double bhxhNV, double bhytNV, double tongLuongNV) {
        this.maBLNV = maBLNV;
        this.maTamUngNhanvien = maTamUngNhanvien;
        this.luongNV = luongNV;
        this.bhxhNV = bhxhNV;
        this.bhytNV = bhytNV;
        this.tongLuongNV = tongLuongNV;
    }

    public BangLuongNhanVien(String maBLNV, TamUngNhanVien maTamUngNhanvien, double luongNV, double bhxhNV, double bhytNV, double tongLuongNV, Date ngayTinhLuong, Date ngayNhanLuong, boolean trangThaiLuong) {
        this.maBLNV = maBLNV;
        this.maTamUngNhanvien = maTamUngNhanvien;
        this.luongNV = luongNV;
        this.bhxhNV = bhxhNV;
        this.bhytNV = bhytNV;
        this.tongLuongNV = tongLuongNV;
        this.ngayTinhLuong = ngayTinhLuong;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
    }

    public BangLuongNhanVien(String maBLNV, TamUngNhanVien maTamUngNhanvien, double luongNV, double tongLuongNV, Date ngayTinhLuong, Date ngayNhanLuong, boolean trangThaiLuong) {
        this.maBLNV = maBLNV;
        this.maTamUngNhanvien = maTamUngNhanvien;
        this.luongNV = luongNV;
        this.tongLuongNV = tongLuongNV;
        this.ngayTinhLuong = ngayTinhLuong;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
    }

    public boolean getTrangThaiLuong() {
        return trangThaiLuong;
    }

    public void setTrangThaiLuong(boolean trangThaiLuong) {
        this.trangThaiLuong = trangThaiLuong;
    }

    public String getMaBLNV() {
        return maBLNV;
    }

    public void setMaBLNV(String maBLNV) {
        this.maBLNV = maBLNV;
    }

    public TamUngNhanVien getMaTamUngNhanvien() {
        return maTamUngNhanvien;
    }

    public void setMaTamUngNhanvien(TamUngNhanVien maTamUngNhanvien) {
        this.maTamUngNhanvien = maTamUngNhanvien;
    }

    public double getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(double luongNV) {
        this.luongNV = luongNV;
    }

    public double getBhxhNV() {
        return bhxhNV;
    }

    public void setBhxhNV(double bhxhNV) {
        this.bhxhNV = bhxhNV;
    }

    public double getBhytNV() {
        return bhytNV;
    }

    public void setBhytNV(double bhytNV) {
        this.bhytNV = bhytNV;
    }

    public double getTongLuongNV() {
        return tongLuongNV;
    }

    public void setTongLuongNV(double tongLuongNV) {
        this.tongLuongNV = tongLuongNV;
    }

    public Date getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(Date ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public Date getNgayNhanLuong() {
        return ngayNhanLuong;
    }

    public void setNgayNhanLuong(Date ngayNhanLuong) {
        this.ngayNhanLuong = ngayNhanLuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangLuongNhanVien that = (BangLuongNhanVien) o;
        return Objects.equals(maBLNV, that.maBLNV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBLNV);
    }

    @Override
    public String toString() {
        return "BangLuongNhanVien{\n" +
                "maBLNV='" + maBLNV + '\'' +
                ", maTamUngNhanvien=" + maTamUngNhanvien +
                ", luongNV=" + luongNV +
                ", bhxhNV=" + bhxhNV +
                ", bhytNV=" + bhytNV +
                ", tongLuongNV=" + tongLuongNV +
                ", ngayTinhLuong=" + ngayTinhLuong +
                ", ngayNhanLuong=" + ngayNhanLuong +
                ", trangThaiLuong=" + trangThaiLuong +
                "}\n";
    }
}
