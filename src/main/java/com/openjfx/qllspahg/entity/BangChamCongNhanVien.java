package com.openjfx.qllspahg.entity;

import java.time.LocalDate;
import java.util.Objects;

public class BangChamCongNhanVien {
    private String maBCCNV;
    private NhanVien maNhanVien;
    private LocalDate ngayCC;
    private Boolean diLam;
    private Boolean nghiPhep;
    private Boolean tangCa;

    public BangChamCongNhanVien(String maBCCNV, NhanVien maNhanVien, LocalDate ngayCC, Boolean diLam, Boolean nghiPhep, Boolean tangCa) {
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

    public LocalDate getNgayCC() {
        return ngayCC;
    }

    public void setNgayCC(LocalDate ngayCC) {
        this.ngayCC = ngayCC;
    }

    public Boolean getDiLam() {
        return diLam;
    }

    public void setDiLam(Boolean diLam) {
        this.diLam = diLam;
    }

    public Boolean getNghiPhep() {
        return nghiPhep;
    }

    public void setNghiPhep(Boolean nghiPhep) {
        this.nghiPhep = nghiPhep;
    }

    public Boolean getTangCa() {
        return tangCa;
    }

    public void setTangCa(Boolean tangCa) {
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
}
