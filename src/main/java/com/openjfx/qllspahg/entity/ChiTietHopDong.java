package com.openjfx.qllspahg.entity;

public class ChiTietHopDong {
    private HopDong maHopDong;
    private SanPham maSanPham;
    private int soLuongDat;
    private int soLuongDaLam;

    public ChiTietHopDong(HopDong maHopDong, SanPham maSanPham, int soLuongDat) {
        this.maHopDong = maHopDong;
        this.maSanPham = maSanPham;
        this.soLuongDat = soLuongDat;
    }

    public ChiTietHopDong(HopDong maHopDong, SanPham maSanPham, int soLuongDat, int soLuongDaLam) {
        this.maHopDong = maHopDong;
        this.maSanPham = maSanPham;
        this.soLuongDat = soLuongDat;
        this.soLuongDaLam = soLuongDaLam;
    }

    public ChiTietHopDong(HopDong maHopDong, SanPham maSanPham) {
        this.maHopDong = maHopDong;
        this.maSanPham = maSanPham;
    }

    public ChiTietHopDong(HopDong maHopDong) {
        this.maHopDong = maHopDong;
    }

    public HopDong getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(HopDong maHopDong) {
        this.maHopDong = maHopDong;
    }

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongDat() {
        return soLuongDat;
    }

    public void setSoLuongDat(int soLuongDat) {
        this.soLuongDat = soLuongDat;
    }

    public int getSoLuongDaLam() {
        return soLuongDaLam;
    }

    public void setSoLuongDaLam(int soLuongDaLam) {
        this.soLuongDaLam = soLuongDaLam;
    }

    @Override
    public String toString() {
        return "ChiTietHopDong: " +
                "maHopDong=" + maHopDong +
                ", maSanPham=" + maSanPham +
                ", soLuongDat=" + soLuongDat +
                ", soLuongDaLam=" + soLuongDaLam +
                '\n';
    }
}
