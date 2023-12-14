package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.bangTimKiemCongNhan.BangTimKiemCongNhan;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TimKiemCongNhanDao {
    public static TimKiemCongNhanDao getInstance(){
        return new TimKiemCongNhanDao();
    }
    public ObservableList<ChucVu> layTatCaVaiTroCongNhan(){
        ObservableList<ChucVu> dsChucVu = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[ChucVu]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsChucVu.add(new ChucVu(rs.getString("maCV"),rs.getString("tenCV")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsChucVu;
    }

    public ObservableList<ToSanXuat> layTatCaToSanXuat(){
        ObservableList<ToSanXuat> dsToSanXuat = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[ToSanXuat]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsToSanXuat.add(new ToSanXuat(rs.getString("maTSX"),rs.getString("tenTSX")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsToSanXuat;
    }

    public ObservableList<BangTimKiemCongNhan> TimKiemThongTinCOngNhan(String maCongNhan, String chucVu, String maToSanXuat){
        ObservableList<BangTimKiemCongNhan> dsCongNhan = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVantrcwhere = "SELECT CN.email, CN.hoCN,CN.maCN,CN.sDT, CN.sTK, CN.tenCN, CN.trangThaiCN, TSX.*,CV.maCV,CV.tenCV ,\n" +
                    "SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,\n" +
                    "SUM(CASE WHEN BCC.soLuongLamDuoc > 0 THEN 1 ELSE 0 END)  AS soNgayDiLam,\n" +
                    "SUM(CASE WHEN BCC.nghiPhep = 0 AND BCC.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,\n" +
                    "SUM(BPC.[chiTieu]) AS soLuongDuocPhanCong,\n" +
                    "SUM(BCC.[soLuongLamDuoc]) AS soLuongLamDuoc\n" +
                    "FROM [dbo].[CongNhan] AS CN  \n" +
                    "JOIN [dbo].[BangPhanCongCongNhan] AS BPC ON BPC.maCN = CN.maCN\n" +
                    "JOIN [dbo].[BangChamCongCongNhan] AS BCC ON BCC.maBPCCN = BPC.maBPCCN\n" +
                    "JOIN [dbo].[ChucVu] AS CV ON CV.[maCV] = CN.[maCV]\n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX\n" +
                    "WHERE MONTH (BCC.ngayChamCong) = "+ LocalDate.now().getMonth().getValue() +" \n" +
                    "AND YEAR (BCC.ngayChamCong) = "+LocalDate.now().getYear()+" ";

            String truyVan = SqlQueryBuilder.TimKiemCongNhan(truyVantrcwhere,maCongNhan,chucVu,maToSanXuat);
            ResultSet rs = st.executeQuery(truyVan);
            if (!rs.isBeforeFirst()){
                return null;
            }
            while (rs.next()){
                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                String sDT =rs.getString("sDT");
                String email = rs.getString("email");
                String sTK = rs.getString("sTK");
                ChucVu cv = new ChucVu(rs.getString("maCV"), rs.getString("tenCV"));
                ToSanXuat tSX = new ToSanXuat(rs.getString("maTSX"),rs.getString("tenTSX"));
                CongNhan cn= new CongNhan(maCN,hoCN,tenCN,sDT,email,sTK,cv,tSX);

                BangTimKiemCongNhan btk = new BangTimKiemCongNhan(rs.getBoolean("trangThaiCN"),cn,rs.getInt("soNgayDiLam"),
                        rs.getInt("soNgayNghiPhep"),rs.getInt("soNgayNghi"),rs.getInt("soLuongDuocPhanCong"),rs.getInt("soLuongLamDuoc"));

                dsCongNhan.add(btk);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }



        return dsCongNhan;
    }

}
