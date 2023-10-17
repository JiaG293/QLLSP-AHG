package com.openjfx.qllspahg.entity;

import java.time.LocalDate;
import java.util.Objects;

public class CongNhan {
    private String maCN;
    private String hoCN;
    private String tenNV;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private int sDT;
    private String email;
    private LocalDate ngayVaoLam;
    private String sTK;
    private ChucVu chucVuCN;
    private ToSanXuat toSanXuat;
    private PhuCap maPhuCap;

    public CongNhan(String maCN, String hoCN, String tenNV, Boolean gioiTinh, LocalDate ngaySinh, int sDT, String email, LocalDate ngayVaoLam, String sTK, ChucVu chucVuCN, ToSanXuat toSanXuat, PhuCap maPhuCap) {
        this.maCN = maCN;
        this.hoCN = hoCN;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sDT = sDT;
        this.email = email;
        this.ngayVaoLam = ngayVaoLam;
        this.sTK = sTK;
        this.chucVuCN = chucVuCN;
        this.toSanXuat = toSanXuat;
        this.maPhuCap = maPhuCap;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getHoCN() {
        return hoCN;
    }

    public void setHoCN(String hoCN) {
        this.hoCN = hoCN;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getsDT() {
        return sDT;
    }

    public void setsDT(int sDT) {
        this.sDT = sDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getsTK() {
        return sTK;
    }

    public void setsTK(String sTK) {
        this.sTK = sTK;
    }

    public ChucVu getChucVuCN() {
        return chucVuCN;
    }

    public void setChucVuCN(ChucVu chucVuCN) {
        this.chucVuCN = chucVuCN;
    }

    public ToSanXuat getToSanXuat() {
        return toSanXuat;
    }

    public void setToSanXuat(ToSanXuat toSanXuat) {
        this.toSanXuat = toSanXuat;
    }

    public PhuCap getMaPhuCap() {
        return maPhuCap;
    }

    public void setMaPhuCap(PhuCap maPhuCap) {
        this.maPhuCap = maPhuCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongNhan congNhan = (CongNhan) o;
        return Objects.equals(maCN, congNhan.maCN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCN);
    }
}
