package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class TamUngCongNhan {
    private String maTUCN;
    private Date ngayTamUng;
    private String lyDo;
    private double soTienTamUng;

    public TamUngCongNhan(String maTUCN, Date ngayTamUng, String lyDo, double soTienTamUng) {
        this.maTUCN = maTUCN;
        this.ngayTamUng = ngayTamUng;
        this.lyDo = lyDo;
        this.soTienTamUng = soTienTamUng;
    }

    public String getMaTUCN() {
        return maTUCN;
    }

    public void setMaTUCN(String maTUCN) {
        this.maTUCN = maTUCN;
    }

    public Date getNgayTamUng() {
        return ngayTamUng;
    }

    public void setNgayTamUng(Date ngayTamUng) {
        this.ngayTamUng = ngayTamUng;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public double getSoTienTamUng() {
        return soTienTamUng;
    }

    public void setSoTienTamUng(double soTienTamUng) {
        this.soTienTamUng = soTienTamUng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TamUngCongNhan that = (TamUngCongNhan) o;
        return Objects.equals(maTUCN, that.maTUCN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTUCN);
    }
}
