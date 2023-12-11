package com.openjfx.qllspahg.entity.model;

import com.openjfx.qllspahg.entity.*;

public class ChiTietLuongCongNhan {
    private BangLuongNhanVien maBangLuongCongNhan;
    private CongNhan maCongNhan;
    private BangPhanCongCongNhan maBangPhanCongCongNhan;
    private BangChamCongCongNhan maBangChamCongCongNhan;
    private TamUngCongNhan maTamUngCongNhan;
    private PhuCap maPhuCapCongNhan;
    private int soNgayDiLam;
    private int soNgayTangCa;
    private int soNgayNghi;
    private int soNgayCoPhep;
    private int chiTieuPhanCong;
    private int soLuongLamDuoc;
    private int soLuongLamDuocCaBa;
    private double luongNhanDuoc;
    private double luongThucTe;
    private double phiBHYT;
    private double phiBHXH;
    private String thangBangLuong;
    private String namBangLuong;

    public ChiTietLuongCongNhan(BangLuongNhanVien maBangLuongCongNhan, CongNhan maCongNhan, BangPhanCongCongNhan maBangPhanCongCongNhan, BangChamCongCongNhan maBangChamCongCongNhan, TamUngCongNhan maTamUngCongNhan, PhuCap maPhuCapCongNhan, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH) {
        this.maBangLuongCongNhan = maBangLuongCongNhan;
        this.maCongNhan = maCongNhan;
        this.maBangPhanCongCongNhan = maBangPhanCongCongNhan;
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.maPhuCapCongNhan = maPhuCapCongNhan;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
    }

    public ChiTietLuongCongNhan(CongNhan maCongNhan, TamUngCongNhan maTamUngCongNhan, PhuCap maPhuCapCongNhan, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH) {
        this.maCongNhan = maCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.maPhuCapCongNhan = maPhuCapCongNhan;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
    }

    public ChiTietLuongCongNhan(CongNhan maCongNhan, TamUngCongNhan maTamUngCongNhan, PhuCap maPhuCapCongNhan, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, int chiTieuPhanCong, int soLuongLamDuoc, int soLuongLamDuocCaBa, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH) {
        this.maCongNhan = maCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.maPhuCapCongNhan = maPhuCapCongNhan;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.chiTieuPhanCong = chiTieuPhanCong;
        this.soLuongLamDuoc = soLuongLamDuoc;
        this.soLuongLamDuocCaBa = soLuongLamDuocCaBa;
        this.luongNhanDuoc = luongNhanDuoc;
        this.luongThucTe = luongThucTe;
        this.phiBHYT = phiBHYT;
        this.phiBHXH = phiBHXH;
    }

    public ChiTietLuongCongNhan(CongNhan maCongNhan, TamUngCongNhan maTamUngCongNhan, PhuCap maPhuCapCongNhan, int soNgayDiLam, int soNgayTangCa, int soNgayNghi, int soNgayCoPhep, int chiTieuPhanCong, int soLuongLamDuoc, int soLuongLamDuocCaBa, double luongNhanDuoc, double luongThucTe, double phiBHYT, double phiBHXH, String thangBangLuong, String namBangLuong) {
        this.maCongNhan = maCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.maPhuCapCongNhan = maPhuCapCongNhan;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayTangCa = soNgayTangCa;
        this.soNgayNghi = soNgayNghi;
        this.soNgayCoPhep = soNgayCoPhep;
        this.chiTieuPhanCong = chiTieuPhanCong;
        this.soLuongLamDuoc = soLuongLamDuoc;
        this.soLuongLamDuocCaBa = soLuongLamDuocCaBa;
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

    public int getSoLuongLamDuocCaBa() {
        return soLuongLamDuocCaBa;
    }

    public void setSoLuongLamDuocCaBa(int soLuongLamDuocCaBa) {
        this.soLuongLamDuocCaBa = soLuongLamDuocCaBa;
    }

    public int getChiTieuPhanCong() {
        return chiTieuPhanCong;
    }

    public void setChiTieuPhanCong(int chiTieuPhanCong) {
        this.chiTieuPhanCong = chiTieuPhanCong;
    }

    public int getSoLuongLamDuoc() {
        return soLuongLamDuoc;
    }

    public void setSoLuongLamDuoc(int soLuongLamDuoc) {
        this.soLuongLamDuoc = soLuongLamDuoc;
    }

    public BangLuongNhanVien getMaBangLuongCongNhan() {
        return maBangLuongCongNhan;
    }

    public void setMaBangLuongCongNhan(BangLuongNhanVien maBangLuongCongNhan) {
        this.maBangLuongCongNhan = maBangLuongCongNhan;
    }

    public CongNhan getMaCongNhan() {
        return maCongNhan;
    }

    public void setMaCongNhan(CongNhan maCongNhan) {
        this.maCongNhan = maCongNhan;
    }

    public BangPhanCongCongNhan getMaBangPhanCongCongNhan() {
        return maBangPhanCongCongNhan;
    }

    public void setMaBangPhanCongCongNhan(BangPhanCongCongNhan maBangPhanCongCongNhan) {
        this.maBangPhanCongCongNhan = maBangPhanCongCongNhan;
    }

    public BangChamCongCongNhan getMaBangChamCongCongNhan() {
        return maBangChamCongCongNhan;
    }

    public void setMaBangChamCongCongNhan(BangChamCongCongNhan maBangChamCongCongNhan) {
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
    }

    public TamUngCongNhan getMaTamUngCongNhan() {
        return maTamUngCongNhan;
    }

    public void setMaTamUngCongNhan(TamUngCongNhan maTamUngCongNhan) {
        this.maTamUngCongNhan = maTamUngCongNhan;
    }

    public PhuCap getMaPhuCapCongNhan() {
        return maPhuCapCongNhan;
    }

    public void setMaPhuCapCongNhan(PhuCap maPhuCapCongNhan) {
        this.maPhuCapCongNhan = maPhuCapCongNhan;
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

    @Override
    public String toString() {
        return "ChiTietLuongCongNhan{\n" +
                "maBangLuongCongNhan=" + maBangLuongCongNhan +
                ", maCongNhan=" + maCongNhan +
                ", maBangPhanCongCongNhan=" + maBangPhanCongCongNhan +
                ", maBangChamCongCongNhan=" + maBangChamCongCongNhan +
                ", maTamUngCongNhan=" + maTamUngCongNhan +
                ", maPhuCapCongNhan=" + maPhuCapCongNhan +
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
