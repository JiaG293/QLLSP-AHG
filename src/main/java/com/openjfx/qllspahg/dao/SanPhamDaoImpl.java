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
    public static SanPhamDaoImpl getInstance(){
        return new SanPhamDaoImpl();
    }

    @Override
    public ObservableList<SanPham> getAllSanPham(){
        ObservableList<SanPham> list =  FXCollections.observableArrayList();;

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
            Db.closeConnection();

        }catch (Exception e) {
            e.printStackTrace();
        }

        //Tra ra danh sach doi tuong duoc them vao
        return list;
    }

    @Override
    public SanPham getSanPhamBangMa(String maSanPham) {
        return null;
    }

    @Override
    public SanPham getSanPhamBangTen(String tenSanPham) {
        return null;
    }

    @Override
    public void saveSanPham(SanPham sạnPham) {

    }

    @Override
    public void updateSanPham(SanPham sanPham) {

    }

    @Override
    public void deleteProduct(SanPham sanPham) {

    }

    @Override
    public ObservableList<String> getTenSanPham() {
        return null;
    }
}
