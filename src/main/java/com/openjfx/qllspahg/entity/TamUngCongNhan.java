package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class TamUngCongNhan {
    private String maTUCN;
    private CongNhan maCN;
    private Date ngayTamUng;
    private String lyDo;
    private double soTienTamUng;
    private boolean trangThaiTUNV;


    public TamUngCongNhan(String maTUCN, CongNhan maCN, Date ngayTamUng, String lyDo, double soTienTamUng, boolean trangThaiTUNV) {
        this.maTUCN = maTUCN;
        this.maCN = maCN;
        this.ngayTamUng = ngayTamUng;
        this.lyDo = lyDo;
        this.soTienTamUng = soTienTamUng;
        this.trangThaiTUNV = trangThaiTUNV;
    }

    public TamUngCongNhan(String maTUCN, CongNhan maCN, Date ngayTamUng, double soTienTamUng, boolean trangThaiTUNV) {
        this.maTUCN = maTUCN;
        this.maCN = maCN;
        this.ngayTamUng = ngayTamUng;
        this.soTienTamUng = soTienTamUng;
        this.trangThaiTUNV = trangThaiTUNV;
    }

    public TamUngCongNhan(CongNhan maCN, double soTienTamUng, Date ngayTamUng) {
        this.maCN = maCN;
        this.ngayTamUng = ngayTamUng;
        this.soTienTamUng = soTienTamUng;
    }

    public TamUngCongNhan(String maTUCN, CongNhan maCN) {
        this.maTUCN = maTUCN;
        this.maCN = maCN;
    }

    public CongNhan getMaCN() {
        return maCN;
    }

    public void setMaCN(CongNhan maCN) {
        this.maCN = maCN;
    }

    public boolean getTrangThaiTUNV() {
        return trangThaiTUNV;
    }

    public void setTrangThaiTUNV(boolean trangThaiTUNV) {
        this.trangThaiTUNV = trangThaiTUNV;
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

    @Override
    public String toString() {
        return "TamUngCongNhan{\n" +
                "maTUCN='" + maTUCN + '\'' +
                ", maCN=" + maCN +
                ", ngayTamUng=" + ngayTamUng +
                ", lyDo='" + lyDo + '\'' +
                ", soTienTamUng=" + soTienTamUng +
                ", trangThaiTUNV=" + trangThaiTUNV +
                "}\n";
    }
}
