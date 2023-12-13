package com.openjfx.qllspahg.entity;

import java.util.Objects;

public class TaiKhoan {
    private NhanVien maTK;
    private String matKhau;
    private String vaiTro;
    private boolean trangThaiTK;

    public TaiKhoan() {
    }


    public TaiKhoan(NhanVien maTK, String vaiTro) {
        this.maTK = maTK;
        this.vaiTro = vaiTro;
    }

    public TaiKhoan(NhanVien maTK, String matKhau, String vaiTro) {
        this.maTK = maTK;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }



    public TaiKhoan(NhanVien maTK, String matKhau, String vaiTro, boolean trangThaiTK) {
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

    public NhanVien getMaTK() {
        return maTK;
    }

    public void setMaTK(NhanVien maTK) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaiKhoan taiKhoan = (TaiKhoan) o;

        if (trangThaiTK != taiKhoan.trangThaiTK) return false;
        if (!Objects.equals(maTK, taiKhoan.maTK)) return false;
        if (!Objects.equals(matKhau, taiKhoan.matKhau)) return false;
        return Objects.equals(vaiTro, taiKhoan.vaiTro);
    }

    @Override
    public int hashCode() {
        int result = maTK != null ? maTK.hashCode() : 0;
        result = 31 * result + (matKhau != null ? matKhau.hashCode() : 0);
        result = 31 * result + (vaiTro != null ? vaiTro.hashCode() : 0);
        result = 31 * result + (trangThaiTK ? 1 : 0);
        return result;
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
