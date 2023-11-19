package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.SoLuonNguoitTrongTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class PhanCongCongNhanDao {
private ObservableList<CongNhan> dsCN = FXCollections.observableArrayList();
private ObservableList<ChiTietHopDong> dsChiTietHD = FXCollections.observableArrayList();
private ObservableList<CongDoan> dsCD = FXCollections.observableArrayList();
private ObservableList<HopDong> dsHopDong = FXCollections.observableArrayList();
private ObservableList<SoLuonNguoitTrongTo> dsSoLuongNguoiTT = FXCollections.observableArrayList();
public static PhanCongCongNhanDao getInstance (){
    return new PhanCongCongNhanDao();
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
                Date ngayPCSQL = new Date(ngayPC.getTime());

                java.util.Date ngayKT = bpc.getNgayKT();
                Date ngayKTSQL = new Date(ngayKT.getTime());

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

//Hop dong
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
//Cong Doan
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
//TO
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
