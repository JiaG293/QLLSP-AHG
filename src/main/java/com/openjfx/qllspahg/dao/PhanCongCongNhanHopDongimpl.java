package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.PhanCongCongNhanHopDongDao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.HopDong;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhanCongCongNhanHopDongimpl implements PhanCongCongNhanHopDongDao {
    ObservableList<HopDong> dsHopDong = FXCollections.observableArrayList();
    public static PhanCongCongNhanHopDongimpl getInstance(){
        return new PhanCongCongNhanHopDongimpl();
    }
    @Override
    public ObservableList<HopDong> getAllMaHD() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select [dbo].[HopDong].maHD\n" +
                    "from [dbo].[HopDong]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maHD = rs.getString("maHD");
                HopDong hd = new HopDong(maHD);
                dsHopDong.add(hd);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsHopDong;
    }
}
