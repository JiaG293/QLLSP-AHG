package com.openjfx.qllspahg.entity;

public class ChiTietHopDong {
    private HopDong maHopDong;
    private SanPham maSanPham;
    private int soLuong;

    public ChiTietHopDong(HopDong maHopDong, SanPham maSanPham, int soLuong) {
        this.maHopDong = maHopDong;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietHopDong{" +
                "maHopDong=" + maHopDong +
                ", maSanPham=" + maSanPham +
                ", soLuong=" + soLuong +
                '}';
    }
}
