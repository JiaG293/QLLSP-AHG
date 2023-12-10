package com.openjfx.qllspahg.entity;


import com.openjfx.qllspahg.gui.util.Utils;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
    private String maNV;
    private String hoNV;
    private String tenNV;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String sDT;
    private String email;
    private Date ngayVaoLam;
    private String sTK;
    private ChucVu chucVuNV;
    private PhongBan phongBan;
    private PhuCap phuCap;
    private double luongCoBan;

    public NhanVien(String maNV, String hoNV, String tenNV, boolean gioiTinh, Date ngaySinh, String sDT, String email, Date ngayVaoLam, String sTK, ChucVu chucVuNV, PhongBan phongBan, PhuCap phuCap, double luongCoBan) {
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
        this.phuCap = phuCap;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien(String maNV, String hoNV, String tenNV, PhongBan phongBan, double luongCoBan) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.phongBan = phongBan;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien(String maNV, String hoNV, String tenNV, PhongBan phongBan) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.phongBan = phongBan;
    }

    public NhanVien(String maNV, String hoNV, String tenNV, ChucVu chucVuNV, PhongBan phongBan, double luongCoBan) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.chucVuNV = chucVuNV;
        this.phongBan = phongBan;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien() {
    }


    public NhanVien(String maNV) {
        this.maNV = maNV;
    }
    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    ///Sample
//    public NhanVien(String maNV, String hoNV, String tenNV, boolean gioiTinh) {
//        this.maNV = maNV;
//        this.hoNV = hoNV;
//        this.tenNV = tenNV;
//        this.gioiTinh = gioiTinh;
//    }

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

    public PhuCap getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(PhuCap phuCap) {
        this.phuCap = phuCap;
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
                ", gioiTinh=" + gioiTinh +
                ", ngaySinh=" + ngaySinh +
                ", sDT='" + sDT + '\'' +
                ", email='" + email + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", sTK='" + sTK + '\'' +
                ", chucVuNV=" + chucVuNV +
                ", phongBan=" + phongBan +
                ", phuCap=" + phuCap +
                ", luongCoBan=" + luongCoBan +
                '}';
    }

    public String toStringChamCongNhanVien() {
        return "NhanVienChamCong{" +
                "maNV='" + maNV + '\'' +
                ", hoNV='" + hoNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", phongBan=" + phongBan +
                '}' + "\n";
    }
}

