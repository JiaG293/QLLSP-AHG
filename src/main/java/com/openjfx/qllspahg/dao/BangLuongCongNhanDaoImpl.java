package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.ChiTietLuongCongNhan;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class BangLuongCongNhanDaoImpl {
    public static BangLuongCongNhanDaoImpl getInstance() {
        return new BangLuongCongNhanDaoImpl();
    }

    public ObservableList<BangLuongCongNhan> layDanhSachBangLuongCongNhan() {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "SELECT BLCN.*, CN.tenCN, CN.hoCN, TSX.tenTSX\n" +
                "FROM BangLuongCongNhan AS BLCN\n" +
                "\tLEFT JOIN CongNhan AS CN ON CN.maCN = BLCN.maCN\n" +
                "\tLEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX\n";
        ObservableList<BangLuongCongNhan> listBLCN = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maBLCN = rs.getString("maBLCN");
                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                String tenTSX = rs.getString("tenTSX");

                double luongCN = rs.getDouble("luongCN");
                double tongLuongCN = rs.getDouble("tongLuongCN");

                Date ngayTinhLuong = rs.getDate("ngayTinhLuong");
                Date ngayNhanLuong = rs.getDate("ngayNhanLuong");
                boolean trangThai = rs.getBoolean("trangThaiLuong");

                ToSanXuat tsx = new ToSanXuat(tenTSX);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, tsx);
                BangLuongCongNhan blcn = new BangLuongCongNhan(maBLCN, cn, ngayTinhLuong, luongCN, tongLuongCN, ngayNhanLuong, trangThai);
                listBLCN.add(blcn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Danh sach bang luong cn:\n" + listBLCN + "\n");
        return listBLCN;
    }

    public ObservableList<BangLuongCongNhan> locDuLieuDanhSachBangLuongCongNhan(String maCongNhan, String tenCongNhan, String toSanXuat, String thangBangLuong, String namBangLuong, String trangThaiLuong) {
        Connection con = null;
        PreparedStatement pst = null;
        String truyVanTruocWhere = "SELECT BLCN.*, CN.tenCN, CN.hoCN, TSX.tenTSX\n" +
                "FROM BangLuongCongNhan AS BLCN\n" +
                "\tLEFT JOIN CongNhan AS CN ON CN.maCN = BLCN.maCN\n" +
                "\tLEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX\n";
        String sql = SqlQueryBuilder.stringQueryLocBangLuongCongNhan(truyVanTruocWhere, maCongNhan, tenCongNhan, toSanXuat, thangBangLuong, namBangLuong, trangThaiLuong);
        ObservableList<BangLuongCongNhan> listBLCN = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maBLCN = rs.getString("maBLCN");
                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                String tenTSX = rs.getString("tenTSX");

                double luongCN = rs.getDouble("luongCN");
                double tongLuongCN = rs.getDouble("tongLuongCN");

                Date ngayTinhLuong = rs.getDate("ngayTinhLuong");
                Date ngayNhanLuong = rs.getDate("ngayNhanLuong");
                boolean trangThai = rs.getBoolean("trangThaiLuong");

                ToSanXuat tsx = new ToSanXuat(tenTSX);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, tsx);
                BangLuongCongNhan blcn = new BangLuongCongNhan(maBLCN, cn, ngayTinhLuong, luongCN, tongLuongCN, ngayNhanLuong, trangThai);
                listBLCN.add(blcn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Danh sach du lieu loc bang luong cn:\n" + listBLCN + "\n");
        return listBLCN;
    }


    public boolean capNhatBangLuong(ObservableList<BangLuongCongNhan> listUpdateBangLuongCN) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE BangLuongCongNhan SET ngayNhanLuong = ?, trangThaiLuong = ? WHERE maBLCN = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            for (BangLuongCongNhan blcn : listUpdateBangLuongCN) {
                if(!getInstance().kiemTraChiTraLuong(blcn.getMaBLCN())){
                    pst.setString(1, Utils.dinhDangNgayHienTai(LocalDate.now(), "yyyy-MM-dd"));
                    pst.setBoolean(2, true);
                    pst.setString(3, blcn.getMaBLCN());

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

    public boolean kiemTraChiTraLuong(String maBangLuongCN) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<BangLuongCongNhan> listBangLuongCN = FXCollections.observableArrayList();
        try {
            String sql = "SELECT BLCN.*\n" +
                    "FROM BangLuongCongNhan AS BLCN\n" +
                    "WHERE BLCN.maBLCN = ? AND BLCN.trangThaiLuong = 1";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, maBangLuongCN);
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

