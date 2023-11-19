package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.CongNhan;
import com.openjfx.qllspahg.entity.ToSanXuat;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class QuanLyTTCongNhanDao {
    private ObservableList<ToSanXuat> dsToSanXuat = FXCollections.observableArrayList();
    private ObservableList<ChucVu> dsChucVu =FXCollections.observableArrayList();
    private ObservableList<CongNhan> dsCongNhan = FXCollections.observableArrayList();


    public static QuanLyTTCongNhanDao getInstance(){
        return new QuanLyTTCongNhanDao();
    }

    //To
    public ObservableList getAllToSanXuat(){
        try{
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select * from [dbo].[ToSanXuat]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsToSanXuat.add(new ToSanXuat(rs.getString("maTSX"),rs.getString("tenTSX")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsToSanXuat;
    }

    //ChucVu hay vai tro
    public ObservableList getAllChucVuCongNhan(){
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select * from [dbo].[ChucVu]\n" +
                    "where maCV like 'CVCN%'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsChucVu.add(new ChucVu(rs.getString("maCV"),rs.getString("tenCV"),rs.getDouble("heSoCV")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsChucVu;
    }

    //Danh Sach Cong Nhan
    public ObservableList locDuLieuQuanLyCongNhan(String gt, String vaiTro, String ToSanXuat){
        String truyVankhongwhere = "select cn.*, cv.tenCV, cv.heSoCV , tsx.tenTSX, pc.maPhuCap\n" +
                "from [dbo].[CongNhan] as cn\n" +
                "join [dbo].[ChucVu] as cv on cn.maCV = cv.maCV\n" +
                "join [dbo].[ToSanXuat] as tsx on tsx.maTSX = cn.maTSX \n" +
                "join [dbo].[PhuCap] as pc on pc.maPhuCap = pc.maPhuCap\n" +
                "where cn.trangThaiNV !=1";
        String truyVan = SqlQueryBuilder.stringQueryLocDanhSachTTCongNhan(truyVankhongwhere,gt,vaiTro,ToSanXuat);
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maCongNhan = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
