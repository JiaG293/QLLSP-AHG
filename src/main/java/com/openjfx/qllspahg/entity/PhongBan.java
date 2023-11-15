package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class PhongBan {
    private String maPB;
    private String tenPB;

    public PhongBan(String maPB, String tenPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
    }

    public PhongBan() {
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongBan phongBan = (PhongBan) o;
        return Objects.equals(maPB, phongBan.maPB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPB);
    }

    @Override
    public String toString() {
        return "PhongBan{" +
                "maPB='" + maPB + '\'' +
                ", tenPB='" + tenPB + '\'' +
                '}';
    }
}
