package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class CongDoan {
    private String maCD;
    private SanPham maSanPham;
    private String tenCD;
    private double giaCD;
    private String giaiDoanCD;

    public CongDoan(String maCD, SanPham maSanPham, String tenCD, double giaCD, String giaiDoanCD) {
        this.maCD = maCD;
        this.maSanPham = maSanPham;
        this.tenCD = tenCD;
        this.giaCD = giaCD;
        this.giaiDoanCD = giaiDoanCD;
    }

    public CongDoan(String maCD, String tenCD, String giaiDoanCD) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.giaiDoanCD = giaiDoanCD;
    }

    public CongDoan() {
    }

    public CongDoan(String maCD) {
        this.maCD = maCD;
    }

    public CongDoan(String maCD, SanPham maSanPham, double giaCD, String giaiDoanCD) {
        this.maCD = maCD;
        this.maSanPham = maSanPham;
        this.giaCD = giaCD;
        this.giaiDoanCD = giaiDoanCD;
    }

    public CongDoan(String maCD, SanPham maSanPham) {
        this.maCD = maCD;
        this.maSanPham = maSanPham;
    }

    public CongDoan(String maCD, String tenCD) {
        this.maCD = maCD;
        this.tenCD = tenCD;
    }

    public CongDoan(String maCD, SanPham maSanPham, String tenCD) {
        this.maCD = maCD;
        this.maSanPham = maSanPham;
        this.tenCD = tenCD;
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

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getGiaiDoanCD() {
        return giaiDoanCD;
    }

    public void setGiaiDoanCD(String giaiDoanCD) {
        this.giaiDoanCD = giaiDoanCD;
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

    @Override
    public String toString() {
        return "CongDoan: " +
                "maCD='" + maCD + '\'' +
                ", maSanPham=" + maSanPham +
                ", tenCD='" + tenCD + '\'' +
                ", giaCD=" + giaCD +
                ", giaiDoanCD='" + giaiDoanCD + '\'' +
                '\n';
    }
}
