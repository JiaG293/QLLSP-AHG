package com.openjfx.qllspahg.entity;

import javafx.beans.property.BooleanProperty;

import java.sql.Date;
import java.util.Objects;

public class BangChamCongNhanVien {
    private String maBCCNV;
    private NhanVien maNhanVien;
    private Date ngayCC;
    private boolean diLam;
    private boolean nghiPhep;
    private boolean tangCa;

    public BangChamCongNhanVien(String maBCCNV, NhanVien maNhanVien, Date ngayCC, boolean diLam, boolean nghiPhep, boolean tangCa) {
        this.maBCCNV = maBCCNV;
        this.maNhanVien = maNhanVien;
        this.ngayCC = ngayCC;
        this.diLam = diLam;
        this.nghiPhep = nghiPhep;
        this.tangCa = tangCa;
    }

    public String getMaBCCNV() {
        return maBCCNV;
    }

    public void setMaBCCNV(String maBCCNV) {
        this.maBCCNV = maBCCNV;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayCC() {
        return ngayCC;
    }

    public void setNgayCC(Date ngayCC) {
        this.ngayCC = ngayCC;
    }

    public boolean getDiLam() {
        return diLam;
    }

    public void setDiLam(boolean diLam) {
        this.diLam = diLam;
    }

    public boolean getNghiPhep() {
        return nghiPhep;
    }

    public void setNghiPhep(boolean nghiPhep) {
        this.nghiPhep = nghiPhep;
    }

    public boolean getTangCa() {
        return tangCa;
    }

    public void setTangCa(boolean tangCa) {
        this.tangCa = tangCa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangChamCongNhanVien that = (BangChamCongNhanVien) o;
        return Objects.equals(maBCCNV, that.maBCCNV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBCCNV);
    }

    @Override
    public String toString() {
        return "BangChamCongNhanVien{" +
                "maBCCNV='" + maBCCNV + '\'' +
                ", maNhanVien=" + maNhanVien +
                ", ngayCC=" + ngayCC +
                ", diLam=" + diLam +
                ", nghiPhep=" + nghiPhep +
                ", tangCa=" + tangCa +
                '}';
    }
}
