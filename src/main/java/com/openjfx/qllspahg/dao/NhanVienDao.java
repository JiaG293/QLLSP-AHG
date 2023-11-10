package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.QuanLyTTNhanVienNhanVienDao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.PhuCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class NhanVienDao implements QuanLyTTNhanVienNhanVienDao {

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
                    "WHERE nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.trangThaiNV != 1";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){  //con dong tiep theo thi tiep tuc lam
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT =rs.getString("sDT");
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
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh = " + GT + " and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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
                    "Where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and cv.tenCV = N" + CV1 + " and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){

                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and pb.tenPB =N" + PB1 +" and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()) {

                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh =" + GT + "and cv.tenCV =N" + CV1 + " and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh =" + GT + " and pb.tenPB =N"+ PB1 + " and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap  and cv.tenCV =N"+ CV1+ "and pb.tenPB =N" +PB1 + " and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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
                    "where nv.maCV = cv.maCV AND nv.maPB =pb.maPB AND nv.maPhuCap = pc.maPhuCap and nv.gioiTinh =" + GT + "and cv.tenCV = N" +CV1+ "and pb.tenPB = N"+PB1 + " and nv.trangThaiNV !=1";
            ResultSet rs = st.executeQuery(truyVan);

            while (rs.next()){
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
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

    @Override
    public boolean saveDSNhanVienThem(ObservableList<NhanVien> dsNhanVienSave) {
        if (dsNhanVienSave.isEmpty()){
            return true;
        } else if (!(dsNhanVienSave.isEmpty())) {
            for (NhanVien nv : dsNhanVienSave){
                String maNV = nv.getMaNV();
                String maPB = nv.getPhongBan().getMaPB();
                String maCV = nv.getChucVuNV().getMaCV();
                String maPhuCap = nv.getPhuCap().getMaPhuCap();
                String hoNV= nv.getHoNV();
                String tenNV = nv.getTenNV();
                boolean gioiTinh = nv.getGioiTinh();
                java.util.Date ngaySinh = nv.getNgaySinh();
                java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());

                String sDT = nv.getsDT();
                String email = nv.getEmail();
                String sTK = nv.getsTK();
                java.util.Date ngayVaoLam = nv.getNgayVaoLam();
                java.sql.Date ngayVaoLamSQL = new java.sql.Date(ngayVaoLam.getTime());
                double luongCobAN = nv.getLuongCoBan();
                try {
                    Connection con = Db.getConnection();
                    String truyVan = "INSERT [dbo].[NhanVien] ([maNV], [maPB], [maCV], [maPhuCap], [hoNV], [tenNV]," +
                            " [gioiTinh], [ngaySinh], [sDT], [email], [ngayVaoLam], [sTK], [luongCoBan]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(truyVan);
                    st.setString(1,maNV);
                    st.setString(2,maPB);
                    st.setString(3,maCV);
                    st.setString(4,maPhuCap);
                    st.setString(5,hoNV);
                    st.setString(6,tenNV);
                    st.setBoolean(7,gioiTinh);
                    st.setDate(8,ngaySinhSQL);
                    st.setString(9,sDT);
                    st.setString(10,email);
                    st.setDate(11,ngayVaoLamSQL);
                    st.setString(12,sTK);
                    st.setDouble(13,luongCobAN);

                    st.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean saveDSNhanVienXoa(ObservableList<NhanVien> dsNhanVienXoa) {

        if (dsNhanVienXoa.isEmpty()){
            return true;
        }else if (!dsNhanVienXoa.isEmpty()){
            for (NhanVien nv : dsNhanVienXoa){
                String maNV = nv.getMaNV();
                String maNVSQL = "'" + maNV + "'";
                try {
                    Connection con = Db.getConnection();
                    String truyVan = "update [dbo].[NhanVien] \n" +
                            "set trangThaiNV = 1 \n" +
                            "where [dbo].[NhanVien].maNV= " + maNVSQL;
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

    @Override
    public boolean svaeDSNhanVienSua(ObservableList<NhanVien> dsNhanVienSua) {
        if (dsNhanVienSua.isEmpty())
            return true;
        else if (!dsNhanVienSua.isEmpty()){
            for (NhanVien nv : dsNhanVienSua){
                String maNV = nv.getMaNV();
                String hoNV = nv.getHoNV();
                String tenNV = nv.getTenNV();
                boolean gioiTinh = nv.getGioiTinh();
                String gioiTinhSQL = gioiTinh == true ? "1" : "0";
                java.util.Date ngaySinh = nv.getNgaySinh();
                java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());
                String sDT =nv.getsDT();
                String email = nv.getEmail();
                java.util.Date ngayVaoLam = nv.getNgayVaoLam();
                java.sql.Date ngayVaolamSQL = new java.sql.Date(ngayVaoLam.getTime());
                String sTK = nv.getsTK();
                double luongCoBan = nv.getLuongCoBan();
                String maPB = nv.getPhongBan().getMaPB();
                String maCV = nv.getChucVuNV().getMaCV();
                String maPC = nv.getPhuCap().getMaPhuCap();

                try {
                    Connection con = Db.getConnection();
                    String truyVan = "Update [dbo].[NhanVien] \n" +
                            "set [maPB] = '"+ maPB +" '"+
                            ",[maCV] ='" + maCV +" '" +
                            ",[maPhuCap] = '" + maPC + " '" +
                            ",[hoNV] = N'" + hoNV + " '" +
                            ",[tenNV] =N'"+ tenNV+ " '" +
                            ",[gioiTinh] ="+ gioiTinhSQL +
                            ",[ngaySinh] = '" + ngaySinhSQL + "'" +
                            ",[sDT] = '" + sDT + "'" +
                            ",[email] = '" + email + "'" +
                            ",[ngayVaoLam] = '" + ngayVaolamSQL + "'" +
                            ",[sTK] = '" + sTK + "'" +
                            ",[luongCoBan] = " + luongCoBan + "\n" +
                            "where [dbo].[NhanVien].maNV = '" + maNV +"'";
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
