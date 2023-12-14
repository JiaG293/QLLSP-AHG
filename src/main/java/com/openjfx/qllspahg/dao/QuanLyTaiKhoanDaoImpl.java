package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TaiKhoan;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuanLyTaiKhoanDaoImpl {

    public static QuanLyTaiKhoanDaoImpl getInstance() {
        return new QuanLyTaiKhoanDaoImpl();
    }

    public boolean taoTaiKhoanNhanVien(TaiKhoan taiKhoan) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO TaiKhoan(maTK, matKhau, vaiTro, trangThaiTK) " +
                    "VALUES (?, ?, ?, ?)";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, taiKhoan.getMaTK().getMaNV());
            pst.setString(2, taiKhoan.getMatKhau());
            pst.setString(3, taiKhoan.getVaiTro());
            pst.setBoolean(4, taiKhoan.getTrangThaiTK());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da them tai khoan moi vao csdl!!! ");
        return true;
    }

    public boolean kiemTraTaiKhoanTonTai(String maTaiKhoan) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "SELECT *\n" +
                    "FROM TaiKhoan\n" +
                    "WHERE maTK = ? AND trangThaiTK = 1";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maTaiKhoan);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public TaiKhoan layTaiKhoanTonTai(String maTaiKhoan) {
        Connection con = null;
        PreparedStatement pst = null;
        TaiKhoan tk = new TaiKhoan();

        try {
            String sql = "SELECT *\n" +
                    "FROM TaiKhoan AS TK\n" +
                    "LEFT JOIN NhanVien AS NV ON NV.maNV = TK.maTK\n" +
                    "WHERE maTK = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maTaiKhoan);

            ResultSet rs = pst.executeQuery();
           while (rs.next()){
               String maTK = rs.getString("maTK");
               String tenNV = rs.getString("tenNV");
               String hoNV = rs.getString("hoNV");
               NhanVien nv = new NhanVien(maTK, hoNV, tenNV, new PhongBan());
               String matKhau = rs.getString("matKhau");
               String vaiTro = rs.getString("vaiTro");
               boolean trangThaiTK = rs.getBoolean("trangThaiTK");
               tk = new TaiKhoan(nv, matKhau, vaiTro,trangThaiTK);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public ObservableList<TaiKhoan> layDuLieuLocTaiKhoan(String maTaiKhoan, String trangThaiLoc) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<TaiKhoan> listTK = FXCollections.observableArrayList();

        try {
            String truyVanTruocWhere = "SELECT *\n" +
                    "FROM TaiKhoan AS TK\n" +
                    "LEFT JOIN NhanVien AS NV ON NV.maNV = TK.maTK";
            String sql = SqlQueryBuilder.stringQueryLocTaiKhoanNhanVien(truyVanTruocWhere, maTaiKhoan, trangThaiLoc);
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String maTK = rs.getString("maTK");
                String tenNV = rs.getString("tenNV");
                String hoNV = rs.getString("hoNV");
                NhanVien nv = new NhanVien(maTK);
                String matKhau = rs.getString("matKhau");
                String vaiTro = rs.getString("vaiTro");
                boolean trangThaiTK = rs.getBoolean("trangThaiTK");
                TaiKhoan tk = new TaiKhoan(nv, matKhau, vaiTro,trangThaiTK);
                listTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;
    }

    public boolean capNhatTaiKhoan(TaiKhoan taiKhoan) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE TaiKhoan\n" +
                    "SET matKhau = ?, vaiTro = ?, trangThaiTK = ?\n" +
                    "WHERE maTK = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, taiKhoan.getMatKhau());
            pst.setString(2, taiKhoan.getVaiTro());
            pst.setBoolean(3, taiKhoan.getTrangThaiTK());
            pst.setString(4, taiKhoan.getMaTK().getMaNV());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da cap nhat san pham csdl!!! ");
        return true;
    }
}
