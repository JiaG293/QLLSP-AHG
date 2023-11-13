package com.openjfx.qllspahg.entity;

import javafx.util.StringConverter;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
    private String maNV;
    private String hoNV;
    private String tenNV;
    private boolean gioiTinh;
    private Date ngaySinh;
    private int sDT;
    private String email;
    private Date ngayVaoLam;
    private String sTK;
    private ChucVu chucVuNV;
    private PhongBan phongBan;
    private PhuCap maPhuCap;

    private double luongCoBan;

    public NhanVien(String maNV, String hoNV, String tenNV, boolean gioiTinh, Date ngaySinh, int sDT, String email, Date ngayVaoLam, String sTK, ChucVu chucVuNV, PhongBan phongBan, PhuCap maPhuCap, double luongCoBan) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sDT = sDT;
        this.email = email;
        this.ngayVaoLam = ngayVaoLam;
        this.sTK = sTK;
        this.chucVuNV = chucVuNV;
        this.phongBan = phongBan;
        this.maPhuCap = maPhuCap;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    ///Sample
    public NhanVien(String maNV, String hoNV, String tenNV, boolean gioiTinh) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
    }

    public NhanVien(String maNV, String hoNV, String tenNV, PhongBan phongBan) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.phongBan = phongBan;
    }

    public ChucVu getChucVuNV() {
        return chucVuNV;
    }

    public void setChucVuNV(ChucVu chucVuNV) {
        this.chucVuNV = chucVuNV;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public PhuCap getMaPhuCap() {
        return maPhuCap;
    }

    public void setMaPhuCap(PhuCap maPhuCap) {
        this.maPhuCap = maPhuCap;
    }


    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
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

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return Objects.equals(maNV, nhanVien.maNV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNV);
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", hoNV='" + hoNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", phongBan=" + phongBan.getTenPB() +
                '}';
    }

}

