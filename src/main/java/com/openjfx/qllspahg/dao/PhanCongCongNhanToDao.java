package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ToSanXuat;
import com.openjfx.qllspahg.entity.model.SoLuonNguoitTrongTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhanCongCongNhanToDao {
    ObservableList<SoLuonNguoitTrongTo> dsSoLuongNguoiTT = FXCollections.observableArrayList();
    public static PhanCongCongNhanToDao getInstance(){
        return new PhanCongCongNhanToDao();
    }
    public ObservableList getSoLuongCoTrongTo(){
        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT [dbo].[ToSanXuat].*,COUNT([dbo].[CongNhan].maCN ) AS Soluong FROM [dbo].[CongNhan] \n" +
                    "LEFT JOIN [dbo].[ToSanXuat] ON [dbo].[ToSanXuat].maTSX= [dbo].[CongNhan].maTSX\n" +
                    "where [dbo].[CongNhan].trangThaiNV !=1 \n" +
                    "GROUP BY [dbo].[ToSanXuat].maTSX, [dbo].[ToSanXuat].tenTSX;";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maTo = rs.getString("maTSX");
                String tenTo = rs.getString("tenTSX");
                ToSanXuat to = new ToSanXuat(maTo,tenTo);
                int soLuong = rs.getInt("SoLuong");
                SoLuonNguoitTrongTo slntt = new SoLuonNguoitTrongTo(to,soLuong);
                dsSoLuongNguoiTT.add(slntt);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsSoLuongNguoiTT;
    }
}
