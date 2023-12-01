package com.openjfx.qllspahg.entity.model.PhanCongCongNhan;

import com.openjfx.qllspahg.entity.BangPhanCongCongNhan;
import com.openjfx.qllspahg.entity.ToSanXuat;

public class BangThongTinCongNhanCoTo {
    private BangThongTinCongNhan bangPCCN;
    private ToSanXuat TSX;

    public BangThongTinCongNhanCoTo(BangThongTinCongNhan bangPCCN, ToSanXuat TSX) {
        this.bangPCCN = bangPCCN;
        this.TSX = TSX;
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

    @Override
    public String toString() {
        return "BangThongTinCongNhanCoTo{" +
                "bangPCCN=" + bangPCCN +
                ", TSX=" + TSX +
                '}';
    }
}
