package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class ChucVu {
    private String maCV;
    private String tenCV;
    private String loaiCV;
    private double heSoCV;

    public ChucVu(String maCV, String tenCV, String loaiCV, double heSoCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.loaiCV = loaiCV;
        this.heSoCV = heSoCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getLoaiCV() {
        return loaiCV;
    }

    public void setLoaiCV(String loaiCV) {
        this.loaiCV = loaiCV;
    }

    public double getHeSoCV() {
        return heSoCV;
    }

    public void setHeSoCV(double heSoCV) {
        this.heSoCV = heSoCV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChucVu chucVu = (ChucVu) o;
        return Objects.equals(maCV, chucVu.maCV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCV);
    }
}
