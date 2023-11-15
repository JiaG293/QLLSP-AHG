package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class CongNhan {
    private String maCN;
    private String hoCN;
    private String tenNV;
    private boolean gioiTinh;
    private Date ngaySinh;
    private int sDT;
    private String email;
    private Date ngayVaoLam;
    private String sTK;
    private ChucVu chucVuCN;
    private ToSanXuat toSanXuat;
    private PhuCap maPhuCap;

    public CongNhan(String maCN, String hoCN, String tenNV, boolean gioiTinh, Date ngaySinh, int sDT, String email, Date ngayVaoLam, String sTK, ChucVu chucVuCN, ToSanXuat toSanXuat, PhuCap maPhuCap) {
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

    public CongNhan(String maCN, String hoCN, String tenNV) {
        this.maCN = maCN;
        this.hoCN = hoCN;
        this.tenNV = tenNV;
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

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
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

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
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
