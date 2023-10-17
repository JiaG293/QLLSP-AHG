package com.openjfx.qllspahg.entity;

import java.time.LocalDate;
import java.util.Objects;

public class TamUngNhanVien {
    private String maTUNV;
    private LocalDate ngayTamUng;
    private String lyDo;
    private Double soTienTamUng;

    public TamUngNhanVien(String maTUNV, LocalDate ngayTamUng, String lyDo, Double soTienTamUng) {
        this.maTUNV = maTUNV;
        this.ngayTamUng = ngayTamUng;
        this.lyDo = lyDo;
        this.soTienTamUng = soTienTamUng;
    }

    public String getMaTUNV() {
        return maTUNV;
    }

    public void setMaTUNV(String maTUNV) {
        this.maTUNV = maTUNV;
    }

    public LocalDate getNgayTamUng() {
        return ngayTamUng;
    }

    public void setNgayTamUng(LocalDate ngayTamUng) {
        this.ngayTamUng = ngayTamUng;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Double getSoTienTamUng() {
        return soTienTamUng;
    }

    public void setSoTienTamUng(Double soTienTamUng) {
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
