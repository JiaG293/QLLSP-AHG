package com.openjfx.qllspahg.entity;

public class TaiKhoan {
    private TaiKhoan maTK;
    private String matKhau;

    public TaiKhoan(TaiKhoan maTK, String matKhau) {
        this.maTK = maTK;
        this.matKhau = matKhau;
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
}
