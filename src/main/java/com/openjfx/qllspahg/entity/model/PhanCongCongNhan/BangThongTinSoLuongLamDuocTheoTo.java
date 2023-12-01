package com.openjfx.qllspahg.entity.model.PhanCongCongNhan;

import com.openjfx.qllspahg.entity.ToSanXuat;

public class BangThongTinSoLuongLamDuocTheoTo {
    private ToSanXuat TSX;
    private int soLuongDaPhanCong;

    public BangThongTinSoLuongLamDuocTheoTo(ToSanXuat TSX, int soLuongDaPhanCong) {
        this.TSX = TSX;
        this.soLuongDaPhanCong = soLuongDaPhanCong;
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

    @Override
    public String toString() {
        return "BangThongTinSoLuongLamDuocTheoTo{" +
                "TSX=" + TSX +
                ", soLuongDaPhanCong=" + soLuongDaPhanCong +
                '}';
    }
}
