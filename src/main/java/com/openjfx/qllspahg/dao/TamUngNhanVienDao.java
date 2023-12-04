package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TamUngNhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TamUngNhanVienDao {
    public static TamUngNhanVienDao getInstance(){
        return new TamUngNhanVienDao();
    }

    public ObservableList<PhongBan> getAllPB(){
        ObservableList<PhongBan> dsPB= FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[PhongBan]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsPB.add(new PhongBan(rs.getString("maPB"),rs.getString("tenPB")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsPB;
    }

    public ObservableList<TamUngNhanVien> getDSNhanVienDaTamUng(){


        return null;
    }
}
