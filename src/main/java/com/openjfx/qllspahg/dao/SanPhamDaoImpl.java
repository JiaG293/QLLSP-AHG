package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.SanPhamDao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//Thuc thi va xu li sql o day
public class SanPhamDaoImpl implements SanPhamDao<SanPham> {

    //Khoi tao doi tuong - goi ham truoc khi muon goi cac ham khac
    public static SanPhamDaoImpl getInstance() {
        return new SanPhamDaoImpl();
    }

    @Override
    public ObservableList<SanPham> layTatCaSP() {
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham";
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

    @Override
    public SanPham laySPBangMa(String maSanPham) {
        SanPham sp = null;
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            /*
            * SELECT * FROM SanPham
                        WHERE maSP= 'maSanPham'*/
            String sql = "SELECT * FROM SanPham" +
                                "WHERE " + "maSP= '" + maSanPham + "' ";
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void themSP(SanPham sanPham) {
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            /*INSERT INTO SanPham(maSP, tenSP, giaSP)
                    VALUES ('maSP', 'tenSP', 'giaSp')*/
            String sql = "INSERT INTO SanPham(maSP, tenSP, giaSP) " +
                    "VALUES ( '" + sanPham.getMaSP() + "', '" + sanPham.getTenSP() + "', " + sanPham.getGiaSP() + ")";
            //Dong duoc insert thanh cong vao csdl
            int rs = st.executeUpdate(sql);
            System.out.println("Da them " + rs + "san pham vao csdl: ");

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
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
