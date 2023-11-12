package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.PhanCongCongNhanChiTietHopDongDao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChiTietHopDong;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhanCongCongNhanChiTietHDDaoimpl implements PhanCongCongNhanChiTietHopDongDao {
    ObservableList<ChiTietHopDong> dsChiTietHD = FXCollections.observableArrayList();
    public static PhanCongCongNhanChiTietHDDaoimpl getInstance(){
        return new PhanCongCongNhanChiTietHDDaoimpl();
    }
    @Override
    public ObservableList<ChiTietHopDong> getAllChiTietHopDong(String maHD) {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select [dbo].[ChiTietHopDong].maHD, [dbo].[SanPham].maSP, [dbo].[SanPham].tenSP, [dbo].[ChiTietHopDong].soLuong\n" +
                    "from [dbo].[ChiTietHopDong] \n" +
                    "Inner Join [dbo].[SanPham] on [dbo].[ChiTietHopDong].maSP = [dbo].[SanPham].maSP\n" +
                    "where [dbo].[ChiTietHopDong].maHD = '" + maHD + "'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maHDSQL = rs.getString("maHD");
                String maSP = rs.getString("maSP");
                String tenSP =rs.getString("tenSP");
                int soLuongLam = rs.getInt("soLuong");
                HopDong hd = new HopDong(maHDSQL);
                SanPham sp = new SanPham(maSP,tenSP);
                ChiTietHopDong cthd = new ChiTietHopDong(hd,sp,soLuongLam);
                dsChiTietHD.add(cthd);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsChiTietHD;
    }
}
