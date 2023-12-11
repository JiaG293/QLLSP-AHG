package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class ChamCongCongNhanDaoImpl {
    public static ChamCongCongNhanDaoImpl getInstance() {
        return new ChamCongCongNhanDaoImpl();
    }

    /*public ObservableList<CongNhan> layDuLieuPhanCongCongNhan() {
        Connection con = null;
        ObservableList<BangPhanCongCongNhan> listBPCCN = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT CN.maCN, CN.hoCN, CN.tenCN, PB.* " +
                    "FROM CongNhan AS CN " +
                    "JOIN PhongBan AS PB ON CN.maTSX = PB.maTSX";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                CongNhan nv = new CongNhan(maCN, hoCN, tenCN, pb);
                listCN.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuCongNhan:\n" + listCN + "\n");
        return listCN;
    }*/

    public ObservableList<BangChamCongCongNhan> layDuLieuBangChamCongCongNhan() {
        Connection con = null;
        ObservableList<BangChamCongCongNhan> listBCCCN = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT BCCCN.*, BPCCN.*, TSX.*, CN.* " +
                    "FROM BangChamCongCongNhan AS BCCCN " +
                    "INNER JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN " +
                    "INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN " +
                    "INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maCD = rs.getString("maCD");

                String maTSX = rs.getString("maTSX");
                String tenTSX = rs.getString("tenTSX");

                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                boolean trangThaiCN = rs.getBoolean("trangThaiCN");

                String maBPCCN = rs.getString("maBPCCN");
                int chiTieu = rs.getInt("chiTieu");
                Date ngayPhanCong = rs.getDate("ngayPhanCong");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");

                String maHD = rs.getString("maHD");

                String maBCCCN = rs.getString("maBCCCN");
                Date ngayChamCong = rs.getDate("ngayChamCong");
                int soLuongLamDuoc = rs.getInt("soLuongLamDuoc");
                int soLuongLamCa3 = rs.getInt("soLuongLamCa3");
                boolean nghiPhep = rs.getBoolean("nghiPhep");

                CongDoan cd = new CongDoan(maCD);
                ToSanXuat tsx = new ToSanXuat(maTSX, tenTSX);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, tsx, trangThaiCN);
                HopDong hd = new HopDong(maHD);
                BangPhanCongCongNhan bpccn = new BangPhanCongCongNhan(maBPCCN, cn, cd, hd, chiTieu, ngayPhanCong, ngayKetThuc);

                BangChamCongCongNhan bcccn = new BangChamCongCongNhan(maBCCCN, bpccn, soLuongLamDuoc, soLuongLamCa3, ngayChamCong, nghiPhep);

                listBCCCN.add(bcccn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuJoinBangChamCongNhan:\n" + listBCCCN + "\n");
        return listBCCCN;
    }

    public ObservableList<BangChamCongCongNhan> layDuLieuBangChamCongCongNhanTheoNgayChamCong(String ngayChamCong) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<BangChamCongCongNhan> listBCCCN = FXCollections.observableArrayList();
        try {
            String sql = "SELECT BCCCN.*, BPCCN.*, TSX.*, CN.* " +
                    "FROM BangChamCongCongNhan AS BCCCN " +
                    "INNER JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN " +
                    "INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN " +
                    "INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX " +
                    "WHERE BCCCN.ngayChamCong = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, DateUtils.isFormatDateString(ngayChamCong, "dd-MM-yyyy") ?
                    DateUtils.chuyenDoiSangNgaySQL(ngayChamCong, "dd-MM-yyyy", "yyyy-MM-dd") :
                    ngayChamCong);

            ResultSet rs = pst.executeQuery();
            /**/
            while (rs.next()) {
                String maCD = rs.getString("maCD");

                String maTSX = rs.getString("maTSX");
                String tenTSX = rs.getString("tenTSX");

                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                boolean trangThaiCN = rs.getBoolean("trangThaiCN");

                String maBPCCN = rs.getString("maBPCCN");
                int chiTieu = rs.getInt("chiTieu");
                Date ngayPhanCong = rs.getDate("ngayPhanCong");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");

                String maHD = rs.getString("maHD");

                String maBCCCN = rs.getString("maBCCCN");
                Date ngayCC = rs.getDate("ngayChamCong");
                int soLuongLamDuoc = rs.getInt("soLuongLamDuoc");
                int soLuongLamCa3 = rs.getInt("soLuongLamCa3");
                boolean nghiPhep = rs.getBoolean("nghiPhep");

                CongDoan cd = new CongDoan(maCD);
                ToSanXuat tsx = new ToSanXuat(maTSX, tenTSX);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, tsx, trangThaiCN);
                HopDong hd = new HopDong(maHD);
                BangPhanCongCongNhan bpccn = new BangPhanCongCongNhan(maBPCCN, cn, cd, hd, chiTieu, ngayPhanCong, ngayKetThuc);

                BangChamCongCongNhan bcccn = new BangChamCongCongNhan(maBCCCN, bpccn, soLuongLamDuoc, soLuongLamCa3, ngayCC, nghiPhep);

                listBCCCN.add(bcccn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuJoinBangChamCongNhan:\n" + listBCCCN + "\n");
        return listBCCCN;
    }


    public ObservableList<BangPhanCongCongNhan> layDuLieuBangPhanCongCongNhan(String ngayChamCong) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<BangPhanCongCongNhan> listBPCCN = FXCollections.observableArrayList();
        try {
            String sql = "SELECT BPCCN.*, TSX.*, CN.* " +
                    "FROM BangPhanCongCongNhan AS BPCCN " +
                    "INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN " +
                    "INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX " +
                    "WHERE BPCCN.ngayPhanCong = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, DateUtils.isFormatDateString(ngayChamCong, "dd-MM-yyyy") ?
                    DateUtils.chuyenDoiSangNgaySQL(ngayChamCong, "dd-MM-yyyy", "yyyy-MM-dd") :
                    ngayChamCong);


            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maCD = rs.getString("maCD");

                String maTSX = rs.getString("maTSX");
                String tenTSX = rs.getString("tenTSX");

                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                boolean trangThaiCN = rs.getBoolean("trangThaiCN");

                String maBPCCN = rs.getString("maBPCCN");
                int chiTieu = rs.getInt("chiTieu");
                Date ngayPCCN = rs.getDate("ngayPhanCong");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");

                String maHD = rs.getString("maHD");


                CongDoan cd = new CongDoan(maCD);
                ToSanXuat tsx = new ToSanXuat(maTSX, tenTSX);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, tsx, trangThaiCN);
                HopDong hd = new HopDong(maHD);
                BangPhanCongCongNhan bpccn = new BangPhanCongCongNhan(maBPCCN, cn, cd, hd, chiTieu, ngayPCCN, ngayKetThuc);

                listBPCCN.add(bpccn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuBangPhanCongCongNhan:\n" + listBPCCN + "\n");
        return listBPCCN;
    }


    public boolean taoBangChamCongCongNhanTheoNgay(ObservableList<BangPhanCongCongNhan> listBPCCN, String ngayChamCong) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO BangChamCongCongNhan (maBCCCN, maBPCCN, ngayChamCong) VALUES ( ?, ?, ?)";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            for (BangPhanCongCongNhan bpccn : listBPCCN) {
                pst.setString(1, UUIDUtils.taoMaBangChamCongCongNhanTuMaPhanCong(bpccn.getMaBPCCN()));
                pst.setString(2, bpccn.getMaBPCCN());
                pst.setString(3, DateUtils.isFormatDateString(ngayChamCong, "dd-MM-yyyy") ?
                        DateUtils.chuyenDoiSangNgaySQL(ngayChamCong, "dd-MM-yyyy", "yyyy-MM-dd") :
                        ngayChamCong
                );

                pst.addBatch();
                System.out.println("Da tao bang cham cong cong nhan vao csdl!!! ");
            }
            pst.executeBatch();
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public ObservableList<String> layDuLieuTatCaToSanXuatCongNhan() {
        Connection con = null;
        ObservableList<String> listTenTSX = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT TSX.* FROM ToSanXuat AS TSX";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String tenTSX = rs.getString("tenTSX");
                listTenTSX.add(tenTSX);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuTatCaToSanXuat:\n" + listTenTSX + "\n");
        return listTenTSX;
    }

    public ObservableList<String> layDuLieuToSanXuatCongNhanDuocPhanCong(String ngayPhanCong) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<String> listTenTSX = FXCollections.observableArrayList();
        try {
            String sql = "SELECT DISTINCT TSX.* " +
                    "FROM BangPhanCongCongNhan AS BPCCN " +
                    "INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN " +
                    "INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX " +
                    "WHERE BPCCN.ngayPhanCong = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, DateUtils.isFormatDateString(ngayPhanCong, "dd-MM-yyyy") ?
                    DateUtils.chuyenDoiSangNgaySQL(ngayPhanCong, "dd-MM-yyyy", "yyyy-MM-dd") :
                    ngayPhanCong);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tenTSX = rs.getString("tenTSX");
                listTenTSX.add(tenTSX);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuToSanXuatDuocPhanCong:\n" + listTenTSX + "\n");
        return listTenTSX;
    }

    public boolean capNhatBangChamCongCongNhan(ObservableList<BangChamCongCongNhan> listUpdateBCCCN) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE BangChamCongCongNhan SET soLuongLamDuoc = ?, soLuongLamCa3 = ?, nghiPhep = ? WHERE maBCCCN = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            for (BangChamCongCongNhan bcccn : listUpdateBCCCN) {
                pst.setInt(1, bcccn.getSoLuongLamDuoc());
                pst.setInt(2, bcccn.getSoLuongLamCaBa());
                pst.setBoolean(3, bcccn.isNghiPhep());
                pst.setString(4, bcccn.getMaBCCCN());
                pst.addBatch();
                System.out.println("Da cap nhat bang cham cong cong nhan vao csdl!!! ");
            }
            pst.executeBatch();
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ObservableList<BangChamCongCongNhan> locBangChamCongCongNhan(String maCongNhan, String tenCongNhan, String tenToSanXuat, String ngayChamCong) {
        Connection con = null;
        PreparedStatement pst = null;
        String truyVanTruocWhere = "SELECT BCCCN.*, BPCCN.*, TSX.*, CN.* " +
                "FROM BangChamCongCongNhan AS BCCCN " +
                "INNER JOIN BangPhanCongCongNhan AS BPCCN ON BCCCN.maBPCCN = BPCCN.maBPCCN " +
                "INNER JOIN CongNhan AS CN ON CN.maCN = BPCCN.maCN " +
                "INNER JOIN ToSanXuat AS TSX ON TSX.maTSX = CN.maTSX ";
        String sql = SqlQueryBuilder.stringQueryLocBangChamCongCongNhan(truyVanTruocWhere, maCongNhan, tenCongNhan, tenToSanXuat, ngayChamCong);
        ObservableList<BangChamCongCongNhan> listBCCCN = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maCD = rs.getString("maCD");

                String maTSX = rs.getString("maTSX");
                String tenTSX = rs.getString("tenTSX");

                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                boolean trangThaiCN = rs.getBoolean("trangThaiCN");

                String maBPCCN = rs.getString("maBPCCN");
                int chiTieu = rs.getInt("chiTieu");
                Date ngayPhanCong = rs.getDate("ngayPhanCong");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");

                String maHD = rs.getString("maHD");

                String maBCCCN = rs.getString("maBCCCN");
                Date ngayCC = rs.getDate("ngayChamCong");
                int soLuongLamDuoc = rs.getInt("soLuongLamDuoc");
                int soLuongLamCa3 = rs.getInt("soLuongLamCa3");
                boolean nghiPhep = rs.getBoolean("nghiPhep");

                CongDoan cd = new CongDoan(maCD);
                ToSanXuat tsx = new ToSanXuat(maTSX, tenTSX);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, tsx, trangThaiCN);
                HopDong hd = new HopDong(maHD);
                BangPhanCongCongNhan bpccn = new BangPhanCongCongNhan(maBPCCN, cn, cd, hd, chiTieu, ngayPhanCong, ngayKetThuc);

                BangChamCongCongNhan bcccn = new BangChamCongCongNhan(maBCCCN, bpccn, soLuongLamDuoc, soLuongLamCa3, ngayCC, nghiPhep);

                listBCCCN.add(bcccn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List Lay du lieu LocBangChamCongCongNhan:\n" + listBCCCN + "\n");
        return listBCCCN;
    }



}
