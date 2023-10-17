package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class ToSanXuat {
    private String maTSX;
    private String tenTSX;

    public ToSanXuat(String maTSX, String tenTSX) {
        this.maTSX = maTSX;
        this.tenTSX = tenTSX;
    }

    public String getMaTSX() {
        return maTSX;
    }

    public void setMaTSX(String maTSX) {
        this.maTSX = maTSX;
    }

    public String getTenTSX() {
        return tenTSX;
    }

    public void setTenTSX(String tenTSX) {
        this.tenTSX = tenTSX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToSanXuat toSanXuat = (ToSanXuat) o;
        return Objects.equals(maTSX, toSanXuat.maTSX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTSX);
    }
}
