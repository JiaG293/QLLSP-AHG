package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class BangChamCongCongNhan {
    private String maBCCCN;
    private BangPhanCongCongNhan maBangPhanCongCongNhan;
    private int soLuongLamDuoc;
    private int soLuongLamCa3;
    private Date ngayCC;
    private Date ngayKT;
    private boolean nghiPhep;

    public BangChamCongCongNhan(String maBCCCN, BangPhanCongCongNhan maBangPhanCongCongNhan, int soLuongLamDuoc, int soLuongLamCa3, Date ngayCC, Date ngayKT, boolean nghiPhep) {
        this.maBCCCN = maBCCCN;
        this.maBangPhanCongCongNhan = maBangPhanCongCongNhan;
        this.soLuongLamDuoc = soLuongLamDuoc;
        this.soLuongLamCa3 = soLuongLamCa3;
        this.ngayCC = ngayCC;
        this.ngayKT = ngayKT;
        this.nghiPhep = nghiPhep;
    }

    public String getMaBCCCN() {
        return maBCCCN;
    }

    public void setMaBCCCN(String maBCCCN) {
        this.maBCCCN = maBCCCN;
    }

    public BangPhanCongCongNhan getMaBangPhanCongCongNhan() {
        return maBangPhanCongCongNhan;
    }

    public void setMaBangPhanCongCongNhan(BangPhanCongCongNhan maBangPhanCongCongNhan) {
        this.maBangPhanCongCongNhan = maBangPhanCongCongNhan;
    }

    public int getSoLuongLamDuoc() {
        return soLuongLamDuoc;
    }

    public void setSoLuongLamDuoc(int soLuongLamDuoc) {
        this.soLuongLamDuoc = soLuongLamDuoc;
    }

    public int getSoLuongLamCa3() {
        return soLuongLamCa3;
    }

    public void setSoLuongLamCa3(int soLuongLamCa3) {
        this.soLuongLamCa3 = soLuongLamCa3;
    }

    public Date getNgayCC() {
        return ngayCC;
    }

    public void setNgayCC(Date ngayCC) {
        this.ngayCC = ngayCC;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public boolean getNghiPhep() {
        return nghiPhep;
    }

    public void setNghiPhep(boolean nghiPhep) {
        this.nghiPhep = nghiPhep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangChamCongCongNhan that = (BangChamCongCongNhan) o;
        return Objects.equals(maBCCCN, that.maBCCCN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBCCCN);
    }
}
