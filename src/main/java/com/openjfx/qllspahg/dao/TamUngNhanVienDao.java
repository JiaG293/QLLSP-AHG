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
import java.time.LocalDate;

public class TamUngNhanVienDao {
    public static TamUngNhanVienDao getInstance(){
        return new TamUngNhanVienDao();
    }

    public ObservableList<TamUngNhanVien> layTatCaThongTinTamUng(){
        ObservableList<TamUngNhanVien> dsTamUng = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT TU.maTUNV, TU.maNV, TU.ngayTamUng, TU.lyDo, NV.hoNV, NV.tenNV, " +
                    "SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +  \n" +
                    "SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS SoNgayDiLam, PB.*\t\n" +
                    "FROM [dbo].[TamUngNhanVien] AS TU\n" +
                    "JOIN [dbo].[NhanVien] AS NV ON NV.maNV = TU.maNV\n" +
                    "JOIN [dbo].[BangChamCongNhanVien] AS BCC ON BCC.maNV = TU.maNV\n" +
                    "JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB\n" +
                    "where MONTH (BCC.ngayChamCong) = "+ LocalDate.now().getMonth().getValue()
                    +" AND YEAR (BCC.ngayChamCong) = "+ LocalDate.now().getYear() +" AND NV.trangThaiNV != 1\n" +
                    "GROUP BY TU.maNV, TU.maTUNV, TU.ngayTamUng, TU.soTienTamUng,\n" +
                    "TU.trangThaiTUCN, TU.lyDo, NV.tenNV, NV.hoNV, PB.maPB, PB.tenPB";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsTamUng;
    }

}
