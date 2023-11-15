package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.BangPhanCongCongNhan;
import com.openjfx.qllspahg.entity.CongNhan;
import com.openjfx.qllspahg.entity.NhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class PhanCongCongNhanCNDao {
ObservableList<CongNhan> dsCN = FXCollections.observableArrayList();
public static PhanCongCongNhanCNDao getInstance (){
    return new PhanCongCongNhanCNDao();
}

public ObservableList<CongNhan> getDSNhanVienTheoTo(String maTSX){
    try {
        Connection con = Db.getConnection();
        Statement st = con.createStatement();
        String truyVan = "select cn.maCN,cn.hoCN,cn.tenCN\n" +
                "from [dbo].[CongNhan] as cn\n" +
                "where maTSX='"+maTSX+"'";
        ResultSet rs = st.executeQuery(truyVan);
        while(rs.next()){
            String maCN = rs.getString("maCN");
            String ho = rs.getString("hoCN");
            String ten = rs.getString("tenCN");
            CongNhan cn = new CongNhan(maCN,ho,ten);
            dsCN.add(cn);
        }
    }catch (SQLException e){
        e.printStackTrace();
    }

    return dsCN;
}

public boolean saveDSPhanCong (ObservableList<BangPhanCongCongNhan> dsPC){
        if (dsPC.isEmpty())
            return true;
        else if(!dsPC.isEmpty()){
            for (BangPhanCongCongNhan bpc : dsPC){
                String maPC = bpc.getMaBPCCN().trim();
                String maCN = bpc.getMaCongNhan().getMaCN();
                String maCD = bpc.getMaCongDoan().getMaCD();
                int chiTieu = bpc.getChiTieu();

                java.util.Date ngayPC = bpc.getNgayPC();
                java.sql.Date ngayPCSQL = new java.sql.Date(ngayPC.getTime());

                java.util.Date ngayKT = bpc.getNgayKT();
                java.sql.Date ngayKTSQL = new java.sql.Date(ngayKT.getTime());

                System.out.println(maPC);

                try {
                    Connection con = Db.getConnection();
                    String truyVan = "INSERT [dbo].[BangPhanCongCongNhan] ([maBPCCN],[maCN],[maCD],[chiTieu],[ngayPhanCong], [ngayKetThuc])\n" +
                            "VALUES (?,?,?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(truyVan);
                    st.setString(1,maPC);
                    st.setString(2,maCN);
                    st.setString(3,maCD);
                    st.setInt(4,chiTieu);
                    st.setDate(5,ngayPCSQL);
                    st.setDate(6,ngayKTSQL);

                    st.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
            return true;
        }


    return false;
}
}
