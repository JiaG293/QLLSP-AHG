package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.BangLuongNhanVien;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class BangLuongNhanVienDaoImpl {
    public static BangLuongNhanVienDaoImpl getInstance() {
        return new BangLuongNhanVienDaoImpl();
    }

    public ObservableList<BangLuongNhanVien> layDanhSachBangLuongNhanVien() {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "SELECT BLNV.*, NV.tenNV, NV.hoNV, PB.tenPB\n" +
                "FROM BangLuongNhanVien AS BLNV\n" +
                "\tLEFT JOIN NhanVien AS NV ON NV.maNV = BLNV.maNV\n" +
                "\tLEFT JOIN PhongBan AS PB ON NV.maPB = PB.maPB\n";
        ObservableList<BangLuongNhanVien> listBLNV = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maBLNV = rs.getString("maBLNV");
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String tenPB = rs.getString("tenPB");

                double luongNV = rs.getDouble("luongNV");
                double tongLuongNV = rs.getDouble("tongLuongNV");

                Date ngayTinhLuong = rs.getDate("ngayTinhLuong");
                Date ngayNhanLuong = rs.getDate("ngayNhanLuong");
                boolean trangThai = rs.getBoolean("trangThaiLuong");

                PhongBan pb = new PhongBan(tenPB);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, pb);
                BangLuongNhanVien blnv = new BangLuongNhanVien(maBLNV, nv, ngayTinhLuong, luongNV, tongLuongNV, ngayNhanLuong, trangThai);
                listBLNV.add(blnv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Danh sach bang luong nv:\n" + listBLNV + "\n");
        return listBLNV;
    }

    public ObservableList<BangLuongNhanVien> locDuLieuDanhSachBangLuongNhanVien(String maNhanVien, String tenNhanVien, String phongBan, String thangBangLuong, String namBangLuong, String trangThaiLuong) {
        Connection con = null;
        PreparedStatement pst = null;
        String truyVanTruocWhere = "SELECT BLNV.*, NV.tenNV, NV.hoNV, PB.tenPB\n" +
                "FROM BangLuongNhanVien AS BLNV\n" +
                "\tLEFT JOIN NhanVien AS NV ON NV.maNV = BLNV.maNV\n" +
                "\tLEFT JOIN PhongBan AS PB ON NV.maPB = PB.maPB\n";
        String sql = SqlQueryBuilder.stringQueryLocBangLuongNhanVien(truyVanTruocWhere, maNhanVien, tenNhanVien, phongBan, thangBangLuong, namBangLuong, trangThaiLuong);
        ObservableList<BangLuongNhanVien> listBLNV = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maBLNV = rs.getString("maBLNV");
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String tenPB = rs.getString("tenPB");

                double luongNV = rs.getDouble("luongNV");
                double tongLuongNV = rs.getDouble("tongLuongNV");

                Date ngayTinhLuong = rs.getDate("ngayTinhLuong");
                Date ngayNhanLuong = rs.getDate("ngayNhanLuong");
                boolean trangThai = rs.getBoolean("trangThaiLuong");

                PhongBan pb = new PhongBan(tenPB);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, pb);
                BangLuongNhanVien blnv = new BangLuongNhanVien(maBLNV, nv, ngayTinhLuong, luongNV, tongLuongNV, ngayNhanLuong, trangThai);
                listBLNV.add(blnv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Danh sach du lieu loc bang luong nv:\n" + listBLNV + "\n");
        return listBLNV;
    }


    public boolean capNhatBangLuong(ObservableList<BangLuongNhanVien> listUpdateBangLuongNV) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE BangLuongNhanVien SET ngayNhanLuong = ?, trangThaiLuong = ? WHERE maBLNV = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            for (BangLuongNhanVien blnv : listUpdateBangLuongNV) {
                if(!getInstance().kiemTraChiTraLuong(blnv.getMaBLNV())){
                    pst.setString(1, Utils.dinhDangNgayHienTai(LocalDate.now(), "yyyy-MM-dd"));
                    pst.setBoolean(2, true);
                    pst.setString(3, blnv.getMaBLNV());

                    pst.addBatch();
                    System.out.println("Da thanh toan 1 bang luong!!! ");
                }
            }
            pst.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean kiemTraChiTraLuong(String maBangLuongNV) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<BangLuongNhanVien> listBangLuongNV = FXCollections.observableArrayList();
        try {
            String sql = "SELECT BLNV.*\n" +
                    "FROM BangLuongNhanVien AS BLNV\n" +
                    "WHERE BLNV.maBLNV = ? AND BLNV.trangThaiLuong = 1";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, maBangLuongNV);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Bang luong da duoc thanh toan");
                return true;
            } else {
                System.out.println("Bang luong chua thanh toan");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
