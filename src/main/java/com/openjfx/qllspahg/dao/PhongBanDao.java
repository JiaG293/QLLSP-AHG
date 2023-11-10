package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.QuanLyTTNhanVienPhongBanDao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.PhongBan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PhongBanDao implements QuanLyTTNhanVienPhongBanDao {
    ObservableList<PhongBan> dsPB = FXCollections.observableArrayList();

    public static PhongBanDao getInstance(){
        return new PhongBanDao();
    }

    @Override
    public ObservableList<PhongBan> getAllPhongBan() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select * from PhongBan";
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB,tenPB);

                dsPB.add(pb);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsPB;
    }
}
