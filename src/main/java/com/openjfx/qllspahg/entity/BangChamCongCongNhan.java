package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class BangChamCongCongNhan {
    private String maBCCCN;
    private BangPhanCongCongNhan maBangPhanCongCongNhan;
    private int soLuongLamDuoc;
    private int soLuongLamCaBa;
    private Date ngayChamCong;
    private boolean nghiPhep;

    public BangChamCongCongNhan(String maBCCCN, BangPhanCongCongNhan maBangPhanCongCongNhan, int soLuongLamDuoc, int soLuongLamCaBa, Date ngayChamCong, boolean nghiPhep) {
        this.maBCCCN = maBCCCN;
        this.maBangPhanCongCongNhan = maBangPhanCongCongNhan;
        this.soLuongLamDuoc = soLuongLamDuoc;
        this.soLuongLamCaBa = soLuongLamCaBa;
        this.ngayChamCong = ngayChamCong;
        this.nghiPhep = nghiPhep;
    }

    public BangChamCongCongNhan(String maBCCCN, BangPhanCongCongNhan maBangPhanCongCongNhan) {
        this.maBCCCN = maBCCCN;
        this.maBangPhanCongCongNhan = maBangPhanCongCongNhan;
    }

    public BangChamCongCongNhan(String maBCCCN) {
        this.maBCCCN = maBCCCN;
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

    public int getSoLuongLamCaBa() {
        return soLuongLamCaBa;
    }

    public void setSoLuongLamCaBa(int soLuongLamCaBa) {
        this.soLuongLamCaBa = soLuongLamCaBa;
    }

    public Date getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(Date ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public boolean isNghiPhep() {
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

    @Override
    public String toString() {
        return "BangChamCongCongNhan{" +
                "maBCCCN='" + maBCCCN + '\'' +
                ", maBangPhanCongCongNhan=" + maBangPhanCongCongNhan +
                ", soLuongLamDuoc=" + soLuongLamDuoc +
                ", soLuongLamCaBa=" + soLuongLamCaBa +
                ", ngayChamCong=" + ngayChamCong +
                ", nghiPhep=" + nghiPhep +
                "}\n";
    }
}
