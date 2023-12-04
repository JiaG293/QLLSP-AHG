package com.openjfx.qllspahg.entity;

import java.sql.Date;
import java.util.Objects;

public class HopDong {
    private String maHD;
    private String tenKH;
    private String sDT;
    private String diaChi;
    private String email;
    private Date ngayKKHD;
    private Date ngayTLHD;
    private boolean trangThaiHD;

    public HopDong(String maHD, String tenKH, String sDT, String diaChi, String email, Date ngayKKHD, Date ngayTLHD, boolean trangThaiHD) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.diaChi = diaChi;
        this.email = email;
        this.ngayKKHD = ngayKKHD;
        this.ngayTLHD = ngayTLHD;
        this.trangThaiHD = trangThaiHD;
    }

    public HopDong(String maHD, Date ngayTLHD) {
        this.maHD = maHD;
        this.ngayTLHD = ngayTLHD;
    }

    public HopDong(String maHD) {
        this.maHD = maHD;
    }

    public HopDong() {
    }

    public HopDong(String maHD, String tenKH, String sDT, String diaChi, String email, Date ngayKKHD, Date ngayTLHD) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.diaChi = diaChi;
        this.email = email;
        this.ngayKKHD = ngayKKHD;
        this.ngayTLHD = ngayTLHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgayKKHD() {
        return ngayKKHD;
    }

    public void setNgayKKHD(Date ngayKKHD) {
        this.ngayKKHD = ngayKKHD;
    }

    public Date getNgayTLHD() {
        return ngayTLHD;
    }

    public void setNgayTLHD(Date ngayTLHD) {
        this.ngayTLHD = ngayTLHD;
    }

    public boolean isTrangThaiHD() {
        return trangThaiHD;
    }

    public void setTrangThaiHD(boolean trangThaiHD) {
        this.trangThaiHD = trangThaiHD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HopDong hopDong = (HopDong) o;
        return Objects.equals(maHD, hopDong.maHD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHD);
    }

    @Override
    public String toString() {
        return "HopDong {" +
                "maHD='" + maHD + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", sDT='" + sDT + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", ngayKKHD=" + ngayKKHD +
                ", ngayTLHD=" + ngayTLHD +
                ", trangThaiHD=" + trangThaiHD +
                '}' + "\n";
    }
}
