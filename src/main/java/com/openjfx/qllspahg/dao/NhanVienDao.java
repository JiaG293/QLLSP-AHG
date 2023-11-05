package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.PhuCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class NhanVienDao implements InterfaceNhanViendao {

    private ObservableList<NhanVien> dsNhanVien = FXCollections.observableArrayList();
    //Khoi tao
    public static NhanVienDao getInstance(){
        return new NhanVienDao();
    }

    @Override
    public ObservableList<NhanVien> getAllNhanVien() {
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "FROM dbo.NhanVien as nv, dbo.ChucVu as cv, dbo.PhongBan as pb, dbo.PhuCap as pc\n" +
                    "WHERE nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){  //con dong tiep theo thi tiep tuc lam
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV,tenCV,heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB,tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,pb,pc, luongCoBan);
                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoGT(String GT) {

        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh = " + GT;
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV,tenCV,heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB,tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,pb,pc, luongCoBan);
                dsNhanVien.add(nv);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoCV(String CV) {
        /**
         * Tai sao phai lam: String CV1 = "'" + CV + "'";
         * vi khi truyen truc tiep bien String CV thi no se sai
         * biến CV trả về tên Chức vụ vd To Truong
         * do cau truy van where phai lacv.tenCV='To Truong'
         */
        String CV1 = "'" + CV + "'";
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "Where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and cv.tenCV = " + CV1;
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){

                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV,tenCV,heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB,tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,pb,pc, luongCoBan);
                dsNhanVien.add(nv);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoPB(String PB) {
        String PB1 = "'" + PB + "'";
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and pb.tenPB =" + PB1;
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()) {

                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV, tenCV, heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, cv, pb, pc, luongCoBan);
                dsNhanVien.add(nv);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoGTvaCV(String GT, String CV) {
        String CV1 = "'" + CV +"'";
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh =" + GT + "and cv.tenCV =" + CV1;
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV, tenCV, heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, cv, pb, pc, luongCoBan);
                dsNhanVien.add(nv);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoGTvaPB(String GT, String PB) {
        String PB1 = "'" + PB + "'";
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh =" + GT + " and pb.tenPB ="+ PB1;
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV, tenCV, heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, cv, pb, pc, luongCoBan);
                dsNhanVien.add(nv);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoCVvaPB(String CV, String PB) {
        String CV1 = "'" + CV + "'";
        String PB1 = "'" + PB + "'";
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap  and cv.tenCV ="+ CV1+ "and pb.tenPB =" +PB1;
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV, tenCV, heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, cv, pb, pc, luongCoBan);
                dsNhanVien.add(nv);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    @Override
    public ObservableList<NhanVien> getNhanVienTheoGTvaCVvaPB(String GT, String CV, String PB) {
        String CV1 = "'" + CV + "'";
        String PB1 = "'" + PB + "'";
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select nv.*, cv.*, pb.*,pc.maPhuCap\n" +
                    "From [dbo].[NhanVien] as nv, [dbo].[ChucVu] as cv, [dbo].[PhongBan] as pb, [dbo].[PhuCap] as pc\n" +
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh =" + GT + "and cv.tenCV =" +CV1+ "and pb.tenPB ="+PB1;
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                int sDT = rs.getInt("sDT");
                String email = rs.getString("email");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String sTK = rs.getString("sTK");

                String maCV = rs.getString("maCV");
                String tenCV = rs.getString("tenCV");
                double heSoCV = rs.getDouble("heSoCV");
                ChucVu cv = new ChucVu(maCV, tenCV, heSoCV);

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                String maPhuCap = rs.getString("maPhuCap");
                PhuCap pc = new PhuCap(maPhuCap);

                double luongCoBan = rs.getDouble("luongCoBan");

                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, gioiTinh, ngaySinh, sDT, email, ngayVaoLam, sTK, cv, pb, pc, luongCoBan);
                dsNhanVien.add(nv);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    @Override
    public String getMaNhanVienLonNhat() {
        NhanVien nv = null;
        String maNV = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "Select Max ([maNV])\n" +
                    "from [dbo].[NhanVien]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                maNV = rs.getString(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNV;
    }

}
