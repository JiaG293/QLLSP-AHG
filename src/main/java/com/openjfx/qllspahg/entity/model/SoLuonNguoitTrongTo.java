package com.openjfx.qllspahg.entity.model;

import com.openjfx.qllspahg.entity.ToSanXuat;

public class SoLuonNguoitTrongTo {
    private ToSanXuat tsx;
    private int soLuongNguoi;

    public SoLuonNguoitTrongTo(ToSanXuat tsx, int soLuongNguoi) {
        this.tsx = tsx;
        this.soLuongNguoi = soLuongNguoi;
    }

    public ToSanXuat getTsx() {
        return tsx;
    }

    public void setTsx(ToSanXuat tsx) {
        this.tsx = tsx;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }
}
