package com.openjfx.qllspahg.entity;

import java.time.LocalDate;
import java.util.Objects;

public class BangPhanCongCongNhan {
    private String maBPCCN;
    private CongNhan maCongNhan;
    private CongDoan maCongDoan;
    private int chiTieu;
    private LocalDate ngayPC;
    private LocalDate ngayKT;

    public BangPhanCongCongNhan(String maBPCCN, CongNhan maCongNhan, CongDoan maCongDoan, int chiTieu, LocalDate ngayPC, LocalDate ngayKT) {
        this.maBPCCN = maBPCCN;
        this.maCongNhan = maCongNhan;
        this.maCongDoan = maCongDoan;
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

    public int getChiTieu() {
        return chiTieu;
    }

    public void setChiTieu(int chiTieu) {
        this.chiTieu = chiTieu;
    }

    public LocalDate getNgayPC() {
        return ngayPC;
    }

    public void setNgayPC(LocalDate ngayPC) {
        this.ngayPC = ngayPC;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
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
}
