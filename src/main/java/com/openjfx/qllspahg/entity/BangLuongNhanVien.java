package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class BangLuongNhanVien {
    private String maBLNV;
    private NhanVien maNhanVien;
    private Date ngayTinhLuong;
    private double luongNV; //luong chua truy lanh
    private double tongLuongNV; //luong thuc te
    private Date ngayNhanLuong;
    private boolean trangThaiLuong;
    private boolean luaChon;

    public BangLuongNhanVien(String maBLNV, NhanVien maNhanVien, Date ngayTinhLuong, double luongNV, double tongLuongNV, Date ngayNhanLuong, boolean trangThaiLuong, boolean luaChon) {
        this.maBLNV = maBLNV;
        this.maNhanVien = maNhanVien;
        this.ngayTinhLuong = ngayTinhLuong;
        this.luongNV = luongNV;
        this.tongLuongNV = tongLuongNV;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
        this.luaChon = luaChon;
    }

    public BangLuongNhanVien(String maBLNV, NhanVien maNhanVien, Date ngayTinhLuong, double luongNV, double tongLuongNV, Date ngayNhanLuong, boolean trangThaiLuong) {
        this.maBLNV = maBLNV;
        this.maNhanVien = maNhanVien;
        this.ngayTinhLuong = ngayTinhLuong;
        this.luongNV = luongNV;
        this.tongLuongNV = tongLuongNV;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
    }


    public String getMaBLNV() {
        return maBLNV;
    }

    public void setMaBLNV(String maBLNV) {
        this.maBLNV = maBLNV;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(Date ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public double getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(double luongNV) {
        this.luongNV = luongNV;
    }

    public double getTongLuongNV() {
        return tongLuongNV;
    }

    public void setTongLuongNV(double tongLuongNV) {
        this.tongLuongNV = tongLuongNV;
    }

    public Date getNgayNhanLuong() {
        return ngayNhanLuong;
    }

    public void setNgayNhanLuong(Date ngayNhanLuong) {
        this.ngayNhanLuong = ngayNhanLuong;
    }

    public boolean getTrangThaiLuong() {
        return trangThaiLuong;
    }

    public void setTrangThaiLuong(boolean trangThaiLuong) {
        this.trangThaiLuong = trangThaiLuong;
    }

    public boolean isLuaChon() {
        return luaChon;
    }

    public void setLuaChon(boolean luaChon) {
        this.luaChon = luaChon;
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
                ", maNhanVien=" + maNhanVien +
                ", ngayTinhLuong=" + ngayTinhLuong +
                ", luongNV=" + luongNV +
                ", tongLuongNV=" + tongLuongNV +
                ", ngayNhanLuong=" + ngayNhanLuong +
                ", trangThaiLuong=" + trangThaiLuong +
                ", luaChon=" + luaChon +
                "}\n";
    }
}
