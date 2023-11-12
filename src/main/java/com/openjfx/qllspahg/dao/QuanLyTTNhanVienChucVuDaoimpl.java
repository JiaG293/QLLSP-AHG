package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuanLyTTNhanVienChucVuDaoimpl implements com.openjfx.qllspahg.dao.interfaces.QuanLyTTNhanVienChucVuDao {

    ObservableList<ChucVu> dsCV = FXCollections.observableArrayList();
    public static QuanLyTTNhanVienChucVuDaoimpl getInstance(){
        return new QuanLyTTNhanVienChucVuDaoimpl();
    }

    @Override
    public ObservableList<ChucVu> getAllChucVuNhanVien() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select * \n" +
                    "from [dbo].[ChucVu] \n" +
                    "where [maCV] like 'CVNV%'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");

                ChucVu cv = new ChucVu(maCV,tenCV,heSoCV);
                dsCV.add(cv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCV;
    }
}
