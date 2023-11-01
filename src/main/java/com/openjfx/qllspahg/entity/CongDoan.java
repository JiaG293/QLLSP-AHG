package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class CongDoan {
    private String maCD;
    private String tenCD;
    private double giaCD;
    private int soLuong;
    private SanPham maSanPham;

    public CongDoan(String maCD, String tenCD, double giaCD, int soLuong, SanPham maSanPham) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.giaCD = giaCD;
        this.soLuong = soLuong;
        this.maSanPham = maSanPham;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public double getGiaCD() {
        return giaCD;
    }

    public void setGiaCD(double giaCD) {
        this.giaCD = giaCD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongDoan congDoan = (CongDoan) o;
        return Objects.equals(maCD, congDoan.maCD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCD);
    }
}
