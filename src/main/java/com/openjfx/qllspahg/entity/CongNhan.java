package com.openjfx.qllspahg.entity;

import java.util.Date;
import java.util.Objects;

public class CongNhan {
    private String maCN;
    private String hoCN;
    private String tenCN;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String sDT;
    private String email;
    private Date ngayVaoLam;
    private String sTK;
    private ChucVu chucVuCN;
    private ToSanXuat toSanXuat;
    private PhuCap maPhuCap;

    public CongNhan(String maCN, String hoCN, String tenCN, boolean gioiTinh, Date ngaySinh, String sDT, String email, Date ngayVaoLam, String sTK, ChucVu chucVuCN, ToSanXuat toSanXuat, PhuCap maPhuCap) {
        this.maCN = maCN;
        this.hoCN = hoCN;
        this.tenCN = tenCN;
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

    public CongNhan() {
    }

    public CongNhan(String maCN, String hoCN, String tenNV) {
        this.maCN = maCN;
        this.hoCN = hoCN;
        this.tenCN = tenNV;
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

    public String getTenCN() {
        return tenCN;
    }

    public void setTenCN(String tenCN) {
        this.tenCN = tenCN;
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

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
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

    @Override
    public String toString() {
        return "CongNhan{" +
                "maCN='" + maCN + '\'' +
                ", hoCN='" + hoCN + '\'' +
                ", tenCN='" + tenCN + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", ngaySinh=" + ngaySinh +
                ", sDT='" + sDT + '\'' +
                ", email='" + email + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", sTK='" + sTK + '\'' +
                ", chucVuCN=" + chucVuCN +
                ", toSanXuat=" + toSanXuat +
                ", maPhuCap=" + maPhuCap +
                '}';
    }
}
