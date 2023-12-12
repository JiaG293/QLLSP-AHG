package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.PhongBan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TimKiemNhanVienDao {

    public static TimKiemNhanVienDao getInstance(){
        return new TimKiemNhanVienDao();
    }

    public ObservableList<PhongBan> layTatCaPhongBan(){
        ObservableList<PhongBan> dsPhongBan = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[PhongBan]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsPhongBan.add(new PhongBan(rs.getString("maPB"),rs.getString("tenPB")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsPhongBan;
    }

    public ObservableList<ChucVu> layTatCaChucVu(){
        ObservableList<ChucVu> dsChucVu = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[ChucVu]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsChucVu.add(new ChucVu(rs.getString("maCV"),rs.getString("tenCV")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsChucVu;
    }
}
