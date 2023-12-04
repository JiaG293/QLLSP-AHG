package com.openjfx.qllspahg.entity.model.PhanCongCongNhan;

import com.openjfx.qllspahg.entity.BangPhanCongCongNhan;
import com.openjfx.qllspahg.entity.ToSanXuat;

import java.util.Date;

public class BangThongTinCongNhanCoTo {
    private BangThongTinCongNhan bangPCCN;
    private ToSanXuat TSX;
    private Date ngay;

    public BangThongTinCongNhanCoTo(BangThongTinCongNhan bangPCCN, ToSanXuat TSX, Date ngay) {
        this.bangPCCN = bangPCCN;
        this.TSX = TSX;
        this.ngay = ngay;
    }

    public BangThongTinCongNhan getBangPCCN() {
        return bangPCCN;
    }

    public void setBangPCCN(BangThongTinCongNhan bangPCCN) {
        this.bangPCCN = bangPCCN;
    }

    public ToSanXuat getTSX() {
        return TSX;
    }

    public void setTSX(ToSanXuat TSX) {
        this.TSX = TSX;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    @Override
    public String toString() {
        return "BangThongTinCongNhanCoTo{" +
                "bangPCCN=" + bangPCCN +
                ", TSX=" + TSX +
                ", ngay=" + ngay +
                '}';
    }
}
