package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Thuc thi va xu li sql o day
public class QuanLySanPhamDaoImpl {
    public static QuanLySanPhamDaoImpl getInstance() {
        return new QuanLySanPhamDaoImpl();
    }

    public ObservableList<SanPham> layTatCaSP() {
        ObservableList<SanPham> listSP = FXCollections.observableArrayList();
        Connection con = null;
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenLoaiSP = rs.getString("tenLoai");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                SanPham sp = new SanPham(maSP, tenSP, tenLoaiSP, giaSP);

                listSP.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public ObservableList<String> taiDanhSachLoaiSanPham() {
        ObservableList<String> listLoaiSP = FXCollections.observableArrayList();
        listLoaiSP.add("Trống");
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT DISTINCT tenLoai FROM SanPham";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String loaiSp = rs.getString("tenLoai");
                listLoaiSP.add(loaiSp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listLoaiSP;
    }

    public boolean themSanPhamMoi(SanPham sanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO SanPham(maSP, tenLoai,  tenSP, giaSP) " +
                    "VALUES (?, ?, ?, ?)";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, sanPham.getMaSP());
            pst.setString(2, sanPham.getTenLoaiSP());
            pst.setString(3, sanPham.getTenSP());
            pst.setDouble(4, sanPham.getGiaSP());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da them san pham moi vao csdl!!! ");
        return true;
    }


    //Tao ma cho danh sach hop dong
    public ObservableList<String> layDanhSachMaSanPham() {
        Connection con = null;
        ObservableList<String> listMaSP = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT SP.maSP " +
                    "FROM SanPham AS SP";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maSP = rs.getString("maSP");
                listMaSP.add(maSP);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuDanhSachMaSanPham:\n" + listMaSP + "\n");
        return listMaSP;
    }

    public SanPham laySPBangMa(String maSanPham) {
        SanPham sp = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham" +
                                "WHERE " + "maSP= '" + maSanPham + "' ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");
                sp = new SanPham(maSP, tenSP, giaSP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public SanPham laySPBangTen(String tenSanPham) {
        SanPham sp = null;
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham" +
                                "WHERE " + "tenSP= '" + tenSanPham + "' ";
            //Thuc thi truy van
            ResultSet rs = st.executeQuery(sql);

            //Them tung doi tuong vao trong danh sach
            while (rs.next()) {

                //Gan du lieu tung table sql
                String maSP = rs.getString("maSP");
//                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                //Dua du lieu vao khuon de khoi tao doi tuong
                sp = new SanPham(maSP, tenSP, giaSP);

            }

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tra ra danh sach doi tuong duoc them vao
        return sp;
    }

    public ObservableList<SanPham> timSPBangMa(String maSanPham) {
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham" +
                    "WHERE " + "tenSP" +
                    "LIKE '%" + maSanPham + "%' ";
            //Thuc thi truy van
            ResultSet rs = st.executeQuery(sql);

            //Them tung doi tuong vao trong danh sach
            while (rs.next()) {

                //Gan du lieu tung table sql
                String maSP = rs.getString("maSP");
//                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                //Dua du lieu vao khuon de khoi tao doi tuong
                SanPham sp = new SanPham(maSP, tenSP, giaSP);

                //Them doi tuong vao danh sach
                list.add(sp);
            }

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tra ra danh sach doi tuong duoc them vao
        return list;
    }

    public ObservableList<SanPham> timSPBangTen(String tenSanPham) {
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham" +
                    "WHERE " + "tenSP" +
                    "LIKE '%" + tenSanPham + "%' ";
            //Thuc thi truy van
            ResultSet rs = st.executeQuery(sql);

            //Them tung doi tuong vao trong danh sach
            while (rs.next()) {

                //Gan du lieu tung table sql
                String maSP = rs.getString("maSP");
//                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                //Dua du lieu vao khuon de khoi tao doi tuong
                SanPham sp = new SanPham(maSP, tenSP, giaSP);

                //Them doi tuong vao danh sach
                list.add(sp);
            }

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tra ra danh sach doi tuong duoc them vao
        return list;
    }



    public void xoaSP(SanPham sanPham) {
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            /*DELETE FROM SanPham
                     WHERE maSP= 'SP9210'*/
            String sql = "DELETE FROM SanPham " +
                    "WHERE " + "maSP= '" + sanPham.getMaSP() + "' ";
            //Dong duoc insert thanh cong vao csdl
            int rs = st.executeUpdate(sql);
            System.out.println("Da chinh sua " + rs + " san pham tren csdl: ");

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaSP(SanPham sanPham) {
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();

            //Khai bao cau lenh sql
            /*UPDATE SanPham
            SET tenSP= 'Balo 9210', giaSP= 150000
            WHERE maSP= 'SP9210'*/
            String sql = "UPDATE SanPham " +
                    "SET " +
                    "tenSP= '" + sanPham.getTenSP() + "', " + "giaSP= '" + sanPham.getGiaSP() + "' " +
                    "WHERE " + "maSP= '" + sanPham.getMaSP() + "' ";
            //Dong duoc insert thanh cong vao csdl
            int rs = st.executeUpdate(sql);
            System.out.println("Da chinh sua " + rs + " san pham tren csdl: ");

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
