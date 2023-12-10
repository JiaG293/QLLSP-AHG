package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.PhuCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhuCapDao {
    ObservableList dsPhuCap = FXCollections.observableArrayList();
    public PhuCapDao getInstance(){
        return new PhuCapDao();
    }

    public ObservableList<PhuCap> getAllPhuCapNhanVien() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select * \n" +
                    "from  [dbo].[PhuCap]\n" +
                    "where [maPhuCap] like 'PCCN%'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maPhuCap = rs.getString("maPhuCap");
                double tienChuyenCan = rs.getDouble("tienChuyenCan");
                double tienNangSuat = rs.getDouble("tienNangSuat");
                double tienNhaTro = rs.getDouble("tienNhaTro");
                double tienConNho = rs.getDouble("tienConNho");
                PhuCap pc = new PhuCap(maPhuCap,tienChuyenCan,tienNangSuat,tienNhaTro,tienConNho);
                dsPhuCap.add(pc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsPhuCap;
    }


    public ObservableList<PhuCap> getAllPhuCapNhanVienTheoMa() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select [maPhuCap]\n" +
                    "from [dbo].[PhuCap]\n" +
                    "where [maPhuCap] like 'PCNV%'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);
                dsPhuCap.add(pc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsPhuCap;
    }
}
