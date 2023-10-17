package com.openjfx.qllspahg.entity;

import java.time.LocalDate;
import java.util.Objects;

public class TamUngCongNhan {
    private String maTUCN;
    private LocalDate ngayTamUng;
    private String lyDo;
    private Double soTienTamUng;

    public TamUngCongNhan(String maTUCN, LocalDate ngayTamUng, String lyDo, Double soTienTamUng) {
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
        TamUngCongNhan that = (TamUngCongNhan) o;
        return Objects.equals(maTUCN, that.maTUCN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTUCN);
    }
}
