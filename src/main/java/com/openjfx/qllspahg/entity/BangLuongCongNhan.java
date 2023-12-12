package com.openjfx.qllspahg.entity;

import java.sql.Date;

public class BangLuongCongNhan {
    private String maBLCN;
    private CongNhan maCongNhan;
    private Date ngayTinhLuong;
    private double luongCN;
    private double tongLuongCN;
    private Date ngayNhanLuong;
    private boolean trangThaiLuong;
    private boolean luaChon;

    public BangLuongCongNhan(String maBLCN, CongNhan maCongNhan, Date ngayTinhLuong, double luongCN, double tongLuongCN, Date ngayNhanLuong, boolean trangThaiLuong) {
        this.maBLCN = maBLCN;
        this.maCongNhan = maCongNhan;
        this.ngayTinhLuong = ngayTinhLuong;
        this.luongCN = luongCN;
        this.tongLuongCN = tongLuongCN;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
    }

    public BangLuongCongNhan(String maBLCN, CongNhan maCongNhan, Date ngayTinhLuong, double luongCN, double tongLuongCN, Date ngayNhanLuong, boolean trangThaiLuong, boolean luaChon) {
        this.maBLCN = maBLCN;
        this.maCongNhan = maCongNhan;
        this.ngayTinhLuong = ngayTinhLuong;
        this.luongCN = luongCN;
        this.tongLuongCN = tongLuongCN;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
        this.luaChon = luaChon;
    }

    public boolean isLuaChon() {
        return luaChon;
    }

    public void setLuaChon(boolean luaChon) {
        this.luaChon = luaChon;
    }

    public CongNhan getMaCongNhan() {
        return maCongNhan;
    }

    public void setMaCongNhan(CongNhan maCongNhan) {
        this.maCongNhan = maCongNhan;
    }

    public String getMaBLCN() {
        return maBLCN;
    }

    public void setMaBLCN(String maBLCN) {
        this.maBLCN = maBLCN;
    }

    public Date getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(Date ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public double getLuongCN() {
        return luongCN;
    }

    public void setLuongCN(double luongCN) {
        this.luongCN = luongCN;
    }

    public double getTongLuongCN() {
        return tongLuongCN;
    }

    public void setTongLuongCN(double tongLuongCN) {
        this.tongLuongCN = tongLuongCN;
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

    @Override
    public String toString() {
        return "BangLuongCongNhan{\n" +
                "maBLCN='" + maBLCN + '\'' +
                "maCongNhan='" + maCongNhan + '\'' +
                ", ngayTinhLuong=" + ngayTinhLuong +
                ", luongCN=" + luongCN +
                ", tongLuongCN=" + tongLuongCN +
                ", ngayNhanLuong=" + ngayNhanLuong +
                ", trangThaiLuong=" + trangThaiLuong +
                ", luaChon=" + luaChon +
                "}\n";
    }
}
