package com.openjfx.qllspahg.entity.model.PhanCongCongNhan;

import com.openjfx.qllspahg.entity.ToSanXuat;

import java.util.Objects;

public class BangThongTinSoLuongLamDuocTheoTo {
    private ToSanXuat TSX;
    private int soLuongDaPhanCong;
    private int soNguoiCoTrongTo;

    public BangThongTinSoLuongLamDuocTheoTo(ToSanXuat TSX, int soLuongDaPhanCong, int soNguoiCoTrongTo) {
        this.TSX = TSX;
        this.soLuongDaPhanCong = soLuongDaPhanCong;
        this.soNguoiCoTrongTo = soNguoiCoTrongTo;
    }

    public BangThongTinSoLuongLamDuocTheoTo(ToSanXuat TSX, int soLuongDaPhanCong) {
        this.TSX = TSX;
        this.soLuongDaPhanCong = soLuongDaPhanCong;
    }

    public BangThongTinSoLuongLamDuocTheoTo(ToSanXuat TSX) {
        this.TSX = TSX;
    }

    public ToSanXuat getTSX() {
        return TSX;
    }

    public void setTSX(ToSanXuat TSX) {
        this.TSX = TSX;
    }

    public int getSoLuongDaPhanCong() {
        return soLuongDaPhanCong;
    }

    public void setSoLuongDaPhanCong(int soLuongDaPhanCong) {
        this.soLuongDaPhanCong = soLuongDaPhanCong;
    }

    public int getSoNguoiCoTrongTo() {
        return soNguoiCoTrongTo;
    }

    public void setSoNguoiCoTrongTo(int soNguoiCoTrongTo) {
        this.soNguoiCoTrongTo = soNguoiCoTrongTo;
    }

    @Override
    public String toString() {
        return "BangThongTinSoLuongLamDuocTheoTo{" +
                "TSX=" + TSX +
                ", soLuongDaPhanCong=" + soLuongDaPhanCong +
                ", soNguoiCoTrongTo=" + soNguoiCoTrongTo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangThongTinSoLuongLamDuocTheoTo that = (BangThongTinSoLuongLamDuocTheoTo) o;
        return Objects.equals(TSX, that.TSX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TSX);
    }
}
