package com.openjfx.qllspahg.entity;

import java.util.Date;
import java.util.Objects;

public class BangPhanCongCongNhan {
    private String maBPCCN;
    private CongNhan maCongNhan;
    private CongDoan maCongDoan;
    private HopDong maHopDong;
    private int chiTieu;
    private Date ngayPC;
    private Date ngayKT;

    public BangPhanCongCongNhan(String maBPCCN, CongNhan maCongNhan, CongDoan maCongDoan, HopDong maHopDong, int chiTieu, Date ngayPC, Date ngayKT) {
        this.maBPCCN = maBPCCN;
        this.maCongNhan = maCongNhan;
        this.maCongDoan = maCongDoan;
        this.maHopDong = maHopDong;
        this.chiTieu = chiTieu;
        this.ngayPC = ngayPC;
        this.ngayKT = ngayKT;
    }

    public String getMaBPCCN() {
        return maBPCCN;
    }

    public void setMaBPCCN(String maBPCCN) {
        this.maBPCCN = maBPCCN;
    }

    public CongNhan getMaCongNhan() {
        return maCongNhan;
    }

    public void setMaCongNhan(CongNhan maCongNhan) {
        this.maCongNhan = maCongNhan;
    }

    public CongDoan getMaCongDoan() {
        return maCongDoan;
    }

    public void setMaCongDoan(CongDoan maCongDoan) {
        this.maCongDoan = maCongDoan;
    }

    public HopDong getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(HopDong maHopDong) {
        this.maHopDong = maHopDong;
    }

    public int getChiTieu() {
        return chiTieu;
    }

    public void setChiTieu(int chiTieu) {
        this.chiTieu = chiTieu;
    }

    public Date getNgayPC() {
        return ngayPC;
    }

    public void setNgayPC(Date ngayPC) {
        this.ngayPC = ngayPC;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangPhanCongCongNhan that = (BangPhanCongCongNhan) o;
        return Objects.equals(maBPCCN, that.maBPCCN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBPCCN);
    }

    @Override
    public String toString() {
        return "BangPhanCongCongNhan{" +
                "maBPCCN='" + maBPCCN + '\'' +
                ", maCongNhan=" + maCongNhan +
                ", maCongDoan=" + maCongDoan +
                ", maHopDong=" + maHopDong +
                ", chiTieu=" + chiTieu +
                ", ngayPC=" + ngayPC +
                ", ngayKT=" + ngayKT +
                '}';
    }
}
