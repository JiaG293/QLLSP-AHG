package com.openjfx.qllspahg.entity;

import java.sql.Date;

public class BangLuongCongNhan {
    private String maBLCN;
    private BangChamCongCongNhan maBangChamCongCongNhan;
    private TamUngCongNhan maTamUngCongNhan;
    private Date ngayTinhLuong;
    private double luongCN;
    private double bhxhCN;
    private double bhytCN;
    private double tongLuongCN;
    private Date ngayNhanLuong;
    private boolean trangThaiLuong;

    public BangLuongCongNhan(String maBLCN, BangChamCongCongNhan maBangChamCongCongNhan, TamUngCongNhan maTamUngCongNhan, Date ngayTinhLuong, double luongCN, double bhxhCN, double bhytCN, double tongLuongCN, Date ngayNhanLuong, boolean trangThaiLuong) {
        this.maBLCN = maBLCN;
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.ngayTinhLuong = ngayTinhLuong;
        this.luongCN = luongCN;
        this.bhxhCN = bhxhCN;
        this.bhytCN = bhytCN;
        this.tongLuongCN = tongLuongCN;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
    }

    public BangLuongCongNhan(String maBLCN, BangChamCongCongNhan maBangChamCongCongNhan, TamUngCongNhan maTamUngCongNhan, Date ngayTinhLuong, double tongLuongCN, Date ngayNhanLuong, boolean trangThaiLuong) {
        this.maBLCN = maBLCN;
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.ngayTinhLuong = ngayTinhLuong;
        this.tongLuongCN = tongLuongCN;
        this.ngayNhanLuong = ngayNhanLuong;
        this.trangThaiLuong = trangThaiLuong;
    }

    public String getMaBLCN() {
        return maBLCN;
    }

    public void setMaBLCN(String maBLCN) {
        this.maBLCN = maBLCN;
    }

    public BangChamCongCongNhan getMaBangChamCongCongNhan() {
        return maBangChamCongCongNhan;
    }

    public void setMaBangChamCongCongNhan(BangChamCongCongNhan maBangChamCongCongNhan) {
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
    }

    public TamUngCongNhan getMaTamUngCongNhan() {
        return maTamUngCongNhan;
    }

    public void setMaTamUngCongNhan(TamUngCongNhan maTamUngCongNhan) {
        this.maTamUngCongNhan = maTamUngCongNhan;
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

    public double getBhxhCN() {
        return bhxhCN;
    }

    public void setBhxhCN(double bhxhCN) {
        this.bhxhCN = bhxhCN;
    }

    public double getBhytCN() {
        return bhytCN;
    }

    public void setBhytCN(double bhytCN) {
        this.bhytCN = bhytCN;
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
                ", maBangChamCongCongNhan=" + maBangChamCongCongNhan +
                ", maTamUngCongNhan=" + maTamUngCongNhan +
                ", ngayTinhLuong=" + ngayTinhLuong +
                ", luongCN=" + luongCN +
                ", bhxhCN=" + bhxhCN +
                ", bhytCN=" + bhytCN +
                ", tongLuongCN=" + tongLuongCN +
                ", ngayNhanLuong=" + ngayNhanLuong +
                ", trangThaiLuong=" + trangThaiLuong +
                "}\n";
    }
}
