package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class PhuCap {
    private String maPhuCap;
    private double tienChuyenCan;
    private double tienNangSuat;
    private double tienNhaTro;
    private double tienConNho;


    public PhuCap(String maPhuCap, double tienChuyenCan, double tienNangSuat, double tienNhaTro, double tienConNho) {
        this.maPhuCap = maPhuCap;
        this.tienChuyenCan = tienChuyenCan;
        this.tienNangSuat = tienNangSuat;
        this.tienNhaTro = tienNhaTro;
        this.tienConNho = tienConNho;
    }

    //phu Cap Cong Nhan
    public PhuCap(String maPhuCap, double tienChuyenCan, double tienNhaTro, double tienConNho) {
        this.maPhuCap = maPhuCap;
        this.tienChuyenCan = tienChuyenCan;
        this.tienNhaTro = tienNhaTro;
        this.tienConNho = tienConNho;
    }


    //phu Cap nhan vien
    public PhuCap(double tienChuyenCan, double tienNhaTro, double tienConNho) {
        this.tienChuyenCan = tienChuyenCan;
        this.tienNhaTro = tienNhaTro;
        this.tienConNho = tienConNho;
    }

    public PhuCap() {
    }


    public PhuCap(String maPhuCap) {
        this.maPhuCap = maPhuCap;
    }

    public String getMaPhuCap() {
        return maPhuCap;
    }

    public void setMaPhuCap(String maPhuCap) {
        this.maPhuCap = maPhuCap;
    }

    public double getTienChuyenCan() {
        return tienChuyenCan;
    }

    public void setTienChuyenCan(double tienChuyenCan) {
        this.tienChuyenCan = tienChuyenCan;
    }

    public double getTienNangSuat() {
        return tienNangSuat;
    }

    public void setTienNangSuat(double tienNangSuat) {
        this.tienNangSuat = tienNangSuat;
    }


    public double getTienNhaTro() {
        return tienNhaTro;
    }

    public void setTienNhaTro(double tienNhaTro) {
        this.tienNhaTro = tienNhaTro;
    }

    public double getTienConNho() {
        return tienConNho;
    }

    public void setTienConNho(double tienConNho) {
        this.tienConNho = tienConNho;
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

    @Override
    public String toString() {
        return "PhuCap{" +
                "maPhuCap='" + maPhuCap + '\'' +
                ", tienChuyenCan=" + tienChuyenCan +
                ", tienNangSuat=" + tienNangSuat +
                ", tienNhaTro=" + tienNhaTro +
                ", tienConNho=" + tienConNho +
                '}';
    }
}
