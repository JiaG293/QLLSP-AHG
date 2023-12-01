package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class QuanLyTTCongNhanDao {
    private ObservableList<ToSanXuat> dsToSanXuat = FXCollections.observableArrayList();
    private ObservableList<ChucVu> dsChucVu =FXCollections.observableArrayList();
    private ObservableList<PhuCap> dsPhuCap = FXCollections.observableArrayList();
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

    //Phu cap
    public ObservableList getAllPhuCapCongNhan(){
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "select * \n" +
                    "from [dbo].[PhuCap]\n" +
                    "where [maPhuCap] like 'PCCN%'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsPhuCap.add(new PhuCap(rs.getString("maPhuCap")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsPhuCap;
    }

    //Danh Sach Cong Nhan
    public String getMaNhanVienLonNhat() {
        CongNhan cn = null;
        String maCN = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select Max ([maCN])\n" +
                    "from [dbo].[CongNhan]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                maCN = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maCN;
    }
    public ObservableList locDuLieuQuanLyCongNhan(String gt, String vaiTro, String ToSanXuat){
        String truyVankhongwhere = "select DISTINCT cn.*,cv.tenCV,cv.heSoCV, tsx.tenTSX\n" +
                "from [dbo].[CongNhan] as cn\n" +
                "join [dbo].[ChucVu] as cv on cn.maCV = cv.maCV\n" +
                "join [dbo].[ToSanXuat] as tsx on tsx.maTSX = cn.maTSX \n" +
                "join [dbo].[PhuCap] as pc on pc.maPhuCap = pc.maPhuCap\n" +
                "where cn.trangThaiCN !=1";
        String truyVan = SqlQueryBuilder.stringQueryLocDanhSachTTCongNhan(truyVankhongwhere,gt,vaiTro,ToSanXuat);

        try {
            Connection con = Db.getConnection();
            PreparedStatement st = con.prepareStatement(truyVan);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maCongNhan = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                ChucVu cv = new ChucVu(maCV,tenCV);

                String maTo = rs.getString("maTSX");
                String tenTo = rs.getString("tenTSX");
                ToSanXuat tSX =new ToSanXuat(maTo,tenTo);

                String maPC = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPC);

                CongNhan cn = new CongNhan(maCongNhan,hoCN,tenCN,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,tSX,pc);

                dsCongNhan.add(cn);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsCongNhan;
    }
    public boolean saveDSCongNhanThem(ObservableList<CongNhan> dsCongNhanSave) {
        if (dsCongNhanSave.isEmpty()){
            return true;
        } else if (!(dsCongNhanSave.isEmpty())) {
            for (CongNhan cn : dsCongNhanSave){
                String maCN = cn.getMaCN();
                String maTSX = cn.getToSanXuat().getMaTSX();
                String maCV = cn.getChucVuCN().getMaCV();
                String maPhuCap = cn.getMaPhuCap().getMaPhuCap();
                String hoCN= cn.getHoCN();
                String tenCN = cn.getTenCN();
                boolean gioiTinh = cn.getGioiTinh();
                java.util.Date ngaySinh = cn.getNgaySinh();
                java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());

                String sDT = cn.getsDT();
                String email = cn.getEmail();
                String sTK = cn.getsTK();
                java.util.Date ngayVaoLam = cn.getNgayVaoLam();
                java.sql.Date ngayVaoLamSQL = new java.sql.Date(ngayVaoLam.getTime());
                try {
                    Connection con = Db.getConnection();
                    String truyVan = "INSERT [dbo].[CongNhan] ([maCN], [maCV], [maTSX], [maPhuCap], [hoCN], [tenCN]," +
                            " [gioiTinh], [ngaySinh], [sDT], [email], [ngayVaoLam], [sTK]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(truyVan);
                    st.setString(1,maCN);
                    st.setString(2,maCV);
                    st.setString(3,maTSX);
                    st.setString(4,maPhuCap);
                    st.setString(5,hoCN);
                    st.setString(6,tenCN);
                    st.setBoolean(7,gioiTinh);
                    st.setDate(8,ngaySinhSQL);
                    st.setString(9,sDT);
                    st.setString(10,email);
                    st.setDate(11,ngayVaoLamSQL);
                    st.setString(12,sTK);

                    st.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            return true;
        }

        return false;
    }

    public boolean saveDSCongNhanXoa(ObservableList<CongNhan> dsCongNhanXoa) {

        if (dsCongNhanXoa.isEmpty()){
            return true;
        }else if (!dsCongNhanXoa.isEmpty()){
            for (CongNhan cn : dsCongNhanXoa){
                String maCN = cn.getMaCN();
                String maCNSQL = "'" + maCN + "'";
                try {
                    Connection con = Db.getConnection();
                    String truyVan = "update [dbo].[CongNhan] \n" +
                            "set trangThaiNV = 1 \n" +
                            "where [dbo].[CongNhan].maCN= " + maCNSQL;
                    PreparedStatement st = con.prepareStatement(truyVan);

                    st.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

    public boolean svaeDSCongNhanSua(ObservableList<CongNhan> dsCongNhanSua) {
        if (dsCongNhanSua.isEmpty())
            return true;
        else if (!dsCongNhanSua.isEmpty()){
            for (CongNhan cn : dsCongNhanSua){
                String maCN = cn.getMaCN();
                String hoCN = cn.getHoCN();
                String tenCN = cn.getTenCN();
                boolean gioiTinh = cn.getGioiTinh();
                String gioiTinhSQL = gioiTinh == true ? "1" : "0";
                java.util.Date ngaySinh = cn.getNgaySinh();
                java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());
                String sDT = cn.getsDT();
                String email =cn.getEmail();
                java.util.Date ngayVaoLam = cn.getNgayVaoLam();
                java.sql.Date ngayVaolamSQL = new java.sql.Date(ngayVaoLam.getTime());
                String sTK = cn.getsTK();
                String maTSX = cn.getToSanXuat().getMaTSX();;
                String maCV = cn.getChucVuCN().getMaCV();
                String maPC = cn.getMaPhuCap().getMaPhuCap();

                try {
                    Connection con = Db.getConnection();
                    String truyVan = "Update [dbo].[CongNhan] \n" +
                            "set [maTSX] = '"+ maTSX +" '"+
                            ",[maCV] ='" + maCV +" '" +
                            ",[maPhuCap] = '" + maPC + " '" +
                            ",[hoCN] = N'" + hoCN + " '" +
                            ",[tenCN] =N'"+ tenCN+ " '" +
                            ",[gioiTinh] ="+ gioiTinhSQL +
                            ",[ngaySinh] = '" + ngaySinhSQL + "'" +
                            ",[sDT] = '" + sDT + "'" +
                            ",[email] = '" + email + "'" +
                            ",[ngayVaoLam] = '" + ngayVaolamSQL + "'" +
                            ",[sTK] = '" + sTK + "'" +
                            "where [dbo].[CongNhan].maCN = '" + maCN +"'";
                    PreparedStatement st = con.prepareStatement(truyVan);

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
