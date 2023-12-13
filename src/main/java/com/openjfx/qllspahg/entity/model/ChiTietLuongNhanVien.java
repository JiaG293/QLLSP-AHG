package com.openjfx.qllspahg.entity.model;

import com.openjfx.qllspahg.entity.*;

public class ChiTietLuongNhanVien {
    private BangLuongNhanVien maBangLuongNhanVien;
    private NhanVien maNhanVien;
    private BangChamCongNhanVien maBangChamCongNhanVien;
    private TamUngNhanVien maTamUngNhanVien;
    private PhuCap maPhuCapNhanVien;
    private int soNgayDiLam;
    private int soNgayTangCa;
    private int soNgayNghi;
    private int soNgayCoPhep;
    private double luongNhanDuoc;
    private double luongThucTe;
    private double phiBHYT;
    private double phiBHXH;
    private String thangBangLuong;
    private String namBangLuong;

    public ChiTietLuongNhanVien(BangLuongNhanVien maBangLuongNhanVien, NhanVien maNhanVien, BangChamCongNhanVien maBangChamCongNhanVien, TamUngNhanVien maTamUngNhanVien, PhuCap maPhuCapNhanVien, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH) {
        this.maBangLuongNhanVien = maBangLuongNhanVien;
        this.maNhanVien = maNhanVien;
        this.maBangChamCongNhanVien = maBangChamCongNhanVien;
        this.maTamUngNhanVien = maTamUngNhanVien;
        this.maPhuCapNhanVien = maPhuCapNhanVien;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
    }

    public ChiTietLuongNhanVien(BangLuongNhanVien maBangLuongNhanVien, NhanVien maNhanVien, TamUngNhanVien maTamUngNhanVien, PhuCap maPhuCapNhanVien, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH) {
        this.maBangLuongNhanVien = maBangLuongNhanVien;
        this.maNhanVien = maNhanVien;
        this.maTamUngNhanVien = maTamUngNhanVien;
        this.maPhuCapNhanVien = maPhuCapNhanVien;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
    }

    public ChiTietLuongNhanVien(NhanVien maNhanVien, TamUngNhanVien maTamUngNhanVien, PhuCap maPhuCapNhanVien, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH) {
        this.maNhanVien = maNhanVien;
        this.maTamUngNhanVien = maTamUngNhanVien;
        this.maPhuCapNhanVien = maPhuCapNhanVien;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
    }

    public ChiTietLuongNhanVien(NhanVien maNhanVien, TamUngNhanVien maTamUngNhanVien, PhuCap maPhuCapNhanVien, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH, String thangBangLuong, String namBangLuong) {
        this.maNhanVien = maNhanVien;
        this.maTamUngNhanVien = maTamUngNhanVien;
        this.maPhuCapNhanVien = maPhuCapNhanVien;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
        this.thangBangLuong = thangBangLuong;
        this.namBangLuong = namBangLuong;
    }

    public String getThangBangLuong() {
        return thangBangLuong;
    }

    public void setThangBangLuong(String thangBangLuong) {
        this.thangBangLuong = thangBangLuong;
    }

    public String getNamBangLuong() {
        return namBangLuong;
    }

    public void setNamBangLuong(String namBangLuong) {
        this.namBangLuong = namBangLuong;
    }

    public BangLuongNhanVien getMaBangLuongNhanVien() {
        return maBangLuongNhanVien;
    }

    public void setMaBangLuongNhanVien(BangLuongNhanVien maBangLuongNhanVien) {
        this.maBangLuongNhanVien = maBangLuongNhanVien;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public BangChamCongNhanVien getMaBangChamCongNhanVien() {
        return maBangChamCongNhanVien;
    }

    public void setMaBangChamCongNhanVien(BangChamCongNhanVien maBangChamCongNhanVien) {
        this.maBangChamCongNhanVien = maBangChamCongNhanVien;
    }

    public TamUngNhanVien getMaTamUngNhanVien() {
        return maTamUngNhanVien;
    }

    public void setMaTamUngNhanVien(TamUngNhanVien maTamUngNhanVien) {
        this.maTamUngNhanVien = maTamUngNhanVien;
    }

    public PhuCap getMaPhuCapNhanVien() {
        return maPhuCapNhanVien;
    }

    public void setMaPhuCapNhanVien(PhuCap maPhuCapNhanVien) {
        this.maPhuCapNhanVien = maPhuCapNhanVien;
    }

    public int getSoNgayDiLam() {
        return soNgayDiLam;
    }

    public void setSoNgayDiLam(int soNgayDiLam) {
        this.soNgayDiLam = soNgayDiLam;
    }

    public int getSoNgayTangCa() {
        return soNgayTangCa;
    }

    public void setSoNgayTangCa(int soNgayTangCa) {
        this.soNgayTangCa = soNgayTangCa;
    }

    public double getLuongNhanDuoc() {
        return luongNhanDuoc;
    }

    public void setLuongNhanDuoc(double luongNhanDuoc) {
        this.luongNhanDuoc = luongNhanDuoc;
    }

    public double getLuongThucTe() {
        return luongThucTe;
    }

    public void setLuongThucTe(double luongThucTe) {
        this.luongThucTe = luongThucTe;
    }

    public double getPhiBHYT() {
        return phiBHYT;
    }

    public void setPhiBHYT(double phiBHYT) {
        this.phiBHYT = phiBHYT;
    }

    public double getPhiBHXH() {
        return phiBHXH;
    }

    public void setPhiBHXH(double phiBHXH) {
        this.phiBHXH = phiBHXH;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public int getSoNgayCoPhep() {
        return soNgayCoPhep;
    }

    public void setSoNgayCoPhep(int soNgayCoPhep) {
        this.soNgayCoPhep = soNgayCoPhep;
    }

    @Override
    public String toString() {
        return "ChiTietLuongNhanVien\n{" +
                "maBangLuongNhanVien=" + maBangLuongNhanVien +
                ", maNhanVien=" + maNhanVien +
                ", maBangChamCongNhanVien=" + maBangChamCongNhanVien +
                ", maTamUngNhanVien=" + maTamUngNhanVien +
                ", maPhuCapNhanVien=" + maPhuCapNhanVien +
                ", soNgayDiLam=" + soNgayDiLam +
                ", soNgayTangCa=" + soNgayTangCa +
                ", soNgayNghi=" + soNgayNghi +
                ", soNgayCoPhep=" + soNgayCoPhep +
                ", luongNhanDuoc=" + luongNhanDuoc +
                ", luongThucTe=" + luongThucTe +
                ", phiBHYT=" + phiBHYT +
                ", phiBHXH=" + phiBHXH +
                "}\n";
    }
}
