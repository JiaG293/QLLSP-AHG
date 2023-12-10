package com.openjfx.qllspahg.entity;

public class TaiKhoan {
    private TaiKhoan maTK;
    private String matKhau;
    private String vaiTro;
    private boolean trangThaiTK;

    public TaiKhoan(TaiKhoan maTK, String matKhau) {
        this.maTK = maTK;
        this.matKhau = matKhau;
    }

    public TaiKhoan(TaiKhoan maTK, String matKhau, String vaiTro) {
        this.maTK = maTK;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public TaiKhoan(TaiKhoan maTK, String matKhau, String vaiTro, boolean trangThaiTK) {
        this.maTK = maTK;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiTK = trangThaiTK;
    }

    public boolean getTrangThaiTK() {
        return trangThaiTK;
    }

    public void setTrangThaiTK(boolean trangThaiTK) {
        this.trangThaiTK = trangThaiTK;
    }

    public TaiKhoan getMaTK() {
        return maTK;
    }

    public void setMaTK(TaiKhoan maTK) {
        this.maTK = maTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "TaiKhoan{\n" +
                "maTK=" + maTK +
                ", matKhau='" + matKhau + '\'' +
                ", vaiTro='" + vaiTro + '\'' +
                ", trangThaiTK='" + trangThaiTK + '\'' +
                "}\n";
    }
}
