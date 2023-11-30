package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class SanPham {
    private String maSP;
    private String tenLoaiSP;
    private String tenSP;
    private double giaSP;
    private boolean trangThaiSP;


    public SanPham(String maSP, String tenSP, double giaSP, boolean trangThaiSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.trangThaiSP = trangThaiSP;
    }

    public SanPham(String maSP, String tenSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham(String maSP, String tenSP, String tenLoaiSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenLoaiSP = tenLoaiSP;
        this.giaSP = giaSP;
    }

    public SanPham(String maSP, String tenLoaiSP, String tenSP, double giaSP, boolean trangThaiSP) {
        this.maSP = maSP;
        this.tenLoaiSP = tenLoaiSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.trangThaiSP = trangThaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public boolean isTrangThaiSP() {
        return trangThaiSP;
    }

    public void setTrangThaiSP(boolean trangThaiSP) {
        this.trangThaiSP = trangThaiSP;
    }

    public SanPham(String maSP) {
        this.maSP = maSP;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPham sanPham = (SanPham) o;
        return Objects.equals(maSP, sanPham.maSP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSP);
    }

    @Override
    public String toString() {
        return "SanPham: " +
                "maSP='" + maSP + '\'' +
                ", tenLoaiSP='" + tenLoaiSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaSP=" + giaSP +
                ", trangThaiSP=" + trangThaiSP +
                '\n';
    }
}
