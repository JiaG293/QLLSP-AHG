package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class PhuCap {
    private String maPhuCap;
    private Double tienChuyenCan;
    private Double tienNangSuat;
    private Double tienDienThoai;
    private Double tienNhaTro;
    private Double tienConNho;
    private String loaiPhuCap;

    public PhuCap(String maPhuCap, Double tienChuyenCan, Double tienNangSuat, Double tienDienThoai, Double tienNhaTro, Double tienConNho, String loaiPhuCap) {
        this.maPhuCap = maPhuCap;
        this.tienChuyenCan = tienChuyenCan;
        this.tienNangSuat = tienNangSuat;
        this.tienDienThoai = tienDienThoai;
        this.tienNhaTro = tienNhaTro;
        this.tienConNho = tienConNho;
        this.loaiPhuCap = loaiPhuCap;
    }

    public String getMaPhuCap() {
        return maPhuCap;
    }

    public void setMaPhuCap(String maPhuCap) {
        this.maPhuCap = maPhuCap;
    }

    public Double getTienChuyenCan() {
        return tienChuyenCan;
    }

    public void setTienChuyenCan(Double tienChuyenCan) {
        this.tienChuyenCan = tienChuyenCan;
    }

    public Double getTienNangSuat() {
        return tienNangSuat;
    }

    public void setTienNangSuat(Double tienNangSuat) {
        this.tienNangSuat = tienNangSuat;
    }

    public Double getTienDienThoai() {
        return tienDienThoai;
    }

    public void setTienDienThoai(Double tienDienThoai) {
        this.tienDienThoai = tienDienThoai;
    }

    public Double getTienNhaTro() {
        return tienNhaTro;
    }

    public void setTienNhaTro(Double tienNhaTro) {
        this.tienNhaTro = tienNhaTro;
    }

    public Double getTienConNho() {
        return tienConNho;
    }

    public void setTienConNho(Double tienConNho) {
        this.tienConNho = tienConNho;
    }

    public String getLoaiPhuCap() {
        return loaiPhuCap;
    }

    public void setLoaiPhuCap(String loaiPhuCap) {
        this.loaiPhuCap = loaiPhuCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhuCap phuCap = (PhuCap) o;
        return Objects.equals(maPhuCap, phuCap.maPhuCap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhuCap);
    }
}
