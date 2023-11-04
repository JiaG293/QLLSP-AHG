package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.InterfaceChucVudao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChucVuDao implements InterfaceChucVudao {

    ObservableList<ChucVu> dsCV = FXCollections.observableArrayList();
    public static ChucVuDao getInstance(){
        return new ChucVuDao();
    }

    @Override
    public ObservableList<ChucVu> getAllChucVuNhanVien() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select * \n" +
                    "From ChucVu\n" +
                    "Where ChucVu.loaiCV = 'NV'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                String loaiCV = rs.getString("loaiCV");
                double heSoCV = rs.getDouble("heSoCV");

                ChucVu cv = new ChucVu(maCV,tenCV,loaiCV,heSoCV);
                dsCV.add(cv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCV;
    }
}
