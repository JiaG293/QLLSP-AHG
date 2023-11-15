package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhanCongCongNhanCongDoanDaoimpl {
    ObservableList<CongDoan> dsCD = FXCollections.observableArrayList();
    public static PhanCongCongNhanCongDoanDaoimpl getInstance(){
        return new PhanCongCongNhanCongDoanDaoimpl();
    }
    public ObservableList<CongDoan> getCongDoanTheoMaSP(String maSP){
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select cd.*, sp.tenSP\n" +
                    "from [dbo].[CongDoan] as cd, [dbo].[SanPham] as sp\n" +
                    "where cd.maSP = '"+ maSP +"' and sp.maSP = cd.maSP";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maCD = rs.getString("maCD");
                String tenCd = rs.getString("tenCD");
                double giaCD = rs.getDouble("giaCongDoan");
                int soLuong = rs.getInt("soLuong");
                String maSanPham = rs.getString("maSP");
                String tenSp = rs.getString("tenSP");
                SanPham sp = new SanPham(maSanPham,tenSp);
                dsCD.add(new CongDoan(maCD,tenCd,giaCD,soLuong,sp));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dsCD;
    }
}
