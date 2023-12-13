package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class DanhSachHopDongImpl {

    public static DanhSachHopDongImpl getInstance() {
        return new DanhSachHopDongImpl();
    }

    //Lay du lieu hop dong
    public ObservableList<HopDong> layDuLieuHopDong() {
        Connection con = null;
        ObservableList<HopDong> listHD = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT HD.* " +
                    "FROM HopDong AS HD";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String tenKH = rs.getString("tenKH");
                Date ngayKKHD = rs.getDate("ngayKKHD");
                Date ngayTLHD = rs.getDate("ngayTLHD");
                boolean trangThaiHD = rs.getBoolean("trangThaiHD");
                String sDT = rs.getString("sDT");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");

                HopDong dshd = new HopDong(maHD, tenKH, sDT, diaChi, email, ngayKKHD, ngayTLHD, trangThaiHD);
                listHD.add(dshd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuDanhSachHopDong:\n" + listHD + "\n");
        return listHD;
    }

    //Lay du lieu chi tiet hop dong
    public ObservableList<ChiTietHopDong> layDuLieuChiTietHopDong(String maHopDong) {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "SELECT CTHD.*, SP.tenSP, SP.giaSP, COALESCE(CD.soLuongCongDoan, 0) AS soLuongCongDoan\n" +
                "FROM ChiTietHopDong AS CTHD\n" +
                "LEFT JOIN SanPham AS SP ON CTHD.maSP = SP.maSP\n" +
                "LEFT JOIN (\n" +
                "    SELECT maSP, COUNT(*) AS soLuongCongDoan\n" +
                "    FROM CongDoan\n" +
                "    GROUP BY maSP\n" +
                ") AS CD ON CTHD.maSP = CD.maSP\n" +
                "WHERE CTHD.maHD = ?";

        ObservableList<ChiTietHopDong> listCTHD = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, maHopDong);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuongDat = rs.getInt("soLuongDat");
                int soLuongLam = rs.getInt("soLuongDaLam");
                int soLuongCongDoan = rs.getInt("soLuongCongDoan");
                double giaSP = rs.getDouble("giaSP");
                HopDong hd = new HopDong(maHD);
                SanPham sp = new SanPham(maSP, tenSP, giaSP);

                ChiTietHopDong dscthd = new ChiTietHopDong(hd, sp, soLuongDat, soLuongLam, soLuongCongDoan);
                listCTHD.add(dscthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuDanhSachChiTietHopDong:\n" + listCTHD + "\n");
        return listCTHD;
    }

    //Lay du lieu hop dong
    public ObservableList<HopDong> layDuLieuHopDongTrangThaiTuyChon(String trangThaiHopDong) {
        Connection con = null;
        ObservableList<HopDong> listHD = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT HD.* " +
                    "FROM HopDong AS HD " +
                    "WHERE HD.trangThaiHD = '" + trangThaiHopDong + "'";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String tenKH = rs.getString("tenKH");
                Date ngayKKHD = rs.getDate("ngayKKHD");
                Date ngayTLHD = rs.getDate("ngayTLHD");
                boolean trangThaiHD = rs.getBoolean("trangThaiHD");
                String sDT = rs.getString("sDT");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");

                HopDong dshd = new HopDong(maHD, tenKH, sDT, diaChi, email, ngayKKHD, ngayTLHD, trangThaiHD);
                listHD.add(dshd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuDanhSachHopDongTuyChon:\n" + listHD + "\n");
        return listHD;
    }


    //Lay toan bo hop dong gom trang thai hd la thanh ly va chua thanh ly
    public ObservableList<String> layDanhSachMaHopDong() {
        Connection con = null;
        ObservableList<String> listMaHD = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT HD.* " +
                    "FROM HopDong AS HD";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maHD = rs.getString("maHD");
                listMaHD.add(maHD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuDanhSachMaHopDong:\n" + listMaHD + "\n");
        return listMaHD;
    }

    //Lay toan bo du lieu san pham
    public ObservableList<SanPham> layDuLieuSanPham() {
        Connection con = null;
        ObservableList<SanPham> listSP = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT SP.* " +
                    "FROM SanPham AS SP";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");
                boolean trangThaiSP = rs.getBoolean("trangThaiSP");

                SanPham dssp = new SanPham(maSP, tenSP, giaSP, trangThaiSP);
                listSP.add(dssp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuDanhSachSanPham:\n" + listSP + "\n");
        return listSP;
    }

    //Tim ma san pham chon o combox dua tren ten
    public String timMaSanPhamDuaTrenTen(String tenSanPham) {
        Connection con = null;
        String maSP = null;
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT SP.maSP " +
                    "FROM SanPham AS SP " +
                    "WHERE SP.tenSP = N'" + tenSanPham + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                maSP = rs.getString("maSP");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maSP;
    }

    public boolean taoHopDongMoi(HopDong hopDong) {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO HopDong(maHD, tenKH, sDT, diaChi, email, ngayKKHD, ngayTLHD) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, hopDong.getMaHD());
            pst.setString(2, hopDong.getTenKH());
            pst.setString(3, hopDong.getsDT());
            pst.setString(4, hopDong.getDiaChi());
            pst.setString(5, hopDong.getEmail());
            pst.setDate(6, hopDong.getNgayKKHD());
            pst.setDate(7, hopDong.getNgayTLHD());
            pst.executeUpdate();
            System.out.println("Da tao hop dong moi vao csdl!!! ");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //Thanh ly hop dong
    public boolean thanhLyHopDong(String maHopDong) {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "UPDATE HopDong SET trangThaiHD = 1 WHERE maHD = ?"; //trangThaiHD: 0 la chua thanh ly, 1 la thanh ly roi
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, maHopDong);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da cap nhat trang thai hop dong duoc chon csdl!!! ");
        return true;
    }

    //Them danh sach san pham cho hop dong
    public boolean themDSSanPhamChoMotHopDong(String maHD, ObservableList<ChiTietHopDong> chiTietHDSP) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO ChiTietHopDong (maHD, maSP, soLuong) VALUES (?, ?, ?)";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            for (ChiTietHopDong cthd : chiTietHDSP) {
                pst.setString(1, maHD);
                pst.setString(2, cthd.getMaSanPham().getMaSP());
                pst.setInt(3, 3); //cthd.getSoLuong()
                pst.addBatch();
            }
            pst.executeBatch();
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da them ds san pham thanh cong vao csdl!!! ");
        return true;
    }

    public boolean themMotSanPhamChoMotHopDong(String maHD, ChiTietHopDong chiTietHopDong) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO ChiTietHopDong (maHD, maSP, soLuongDat) VALUES (?, ?, ?)";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maHD);
            pst.setString(2, chiTietHopDong.getMaSanPham().getMaSP());
            pst.setInt(3, chiTietHopDong.getSoLuongDat());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da them ds san pham thanh cong vao csdl!!! ");
        return true;
    }

   /* SELECT HD.*
    FROM HopDong AS HD
    WHERE HD.ngayKKHD BETWEEN '2022-11-27' AND '2022-12-30' OR HD.ngayTLHD BETWEEN '2022-11-27' AND '2022-12-30';*/

    //Loc du lieu san pham
    public ObservableList<HopDong> locDuLieuDanhSachHopDong(String trangThaiHopDong, String ngayBatDau, String ngayKetThuc) {
        Connection con = null;
        PreparedStatement pst = null;
        String truyVanTruocWhere = "SELECT HD.* " +
                "FROM HopDong AS HD ";
        String sql = SqlQueryBuilder.stringQueryLocDanhSachHopDong(truyVanTruocWhere, trangThaiHopDong, ngayBatDau, ngayKetThuc);
        ObservableList<HopDong> listHD = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String tenKH = rs.getString("tenKH");
                Date ngayKKHD = rs.getDate("ngayKKHD");
                Date ngayTLHD = rs.getDate("ngayTLHD");
                boolean trangThaiHD = rs.getBoolean("trangThaiHD");
                String sDT = rs.getString("sDT");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");

                HopDong hd = new HopDong(maHD, tenKH, sDT, diaChi, email, ngayKKHD, ngayTLHD, trangThaiHD);
                listHD.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuLocHopDong:\n" + listHD + "\n");
        return listHD;
    }


    /*public static void main(String[] args) {
        getInstance().layDuLieuChiTietHopDong("HD100000");
    }*/
}
