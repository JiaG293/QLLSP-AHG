package com.openjfx.qllspahg.entity;

import java.time.LocalDate;
import java.util.Objects;

public class BangChamCongCongNhan {
    private String maBCCCN;
    private BangPhanCongCongNhan maBangPhanCongCongNhan;
    private int soLuongLamDuoc;
    private int soLuongLamCa3;
    private LocalDate ngayCC;
    private LocalDate ngayKT;
    private Boolean nghiPhep;

    public BangChamCongCongNhan(String maBCCCN, BangPhanCongCongNhan maBangPhanCongCongNhan, int soLuongLamDuoc, int soLuongLamCa3, LocalDate ngayCC, LocalDate ngayKT, Boolean nghiPhep) {
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

    public LocalDate getNgayCC() {
        return ngayCC;
    }

    public void setNgayCC(LocalDate ngayCC) {
        this.ngayCC = ngayCC;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.ngayKT = ngayKT;
    }

    public Boolean getNghiPhep() {
        return nghiPhep;
    }

    public void setNghiPhep(Boolean nghiPhep) {
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
