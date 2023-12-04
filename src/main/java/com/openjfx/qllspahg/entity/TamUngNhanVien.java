package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class TamUngNhanVien {
    private String maTUNV;
    private NhanVien maNV;
    private Date ngayTamUng;
    private String lyDo;
    private double
            soTienTamUng;

    public TamUngNhanVien(String maTUNV, NhanVien maNV, Date ngayTamUng, String lyDo, double soTienTamUng) {
        this.maTUNV = maTUNV;
        this.maNV = maNV;
        this.ngayTamUng = ngayTamUng;
        this.lyDo = lyDo;
        this.soTienTamUng = soTienTamUng;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public String getMaTUNV() {
        return maTUNV;
    }

    public void setMaTUNV(String maTUNV) {
        this.maTUNV = maTUNV;
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

    public double
    getSoTienTamUng() {
        return soTienTamUng;
    }

    public void setSoTienTamUng(double
                                        soTienTamUng) {
        this.soTienTamUng = soTienTamUng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TamUngNhanVien that = (TamUngNhanVien) o;
        return Objects.equals(maTUNV, that.maTUNV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTUNV);
    }
}
