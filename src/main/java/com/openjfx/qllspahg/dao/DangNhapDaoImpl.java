package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TaiKhoan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DangNhapDaoImpl {

    public static DangNhapDaoImpl getInstance() {
        return new DangNhapDaoImpl();
    }

    public boolean kiemTraDangNhap(String taiKhoan, String matKhau) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "SELECT * \n" +
                    "FROM TaiKhoan\n" +
                    "WHERE maTK = ? AND matKhau = ? AND trangThaiTK = 1";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, taiKhoan);
            pst.setString(2, matKhau);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("dang nhap thanh cong");

                return true;
            } else {
                System.out.println("dang nhap that bai");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TaiKhoan layThongTinTaiKhoan(String maNhanVien) {
        Connection con = null;
        PreparedStatement pst = null;
        TaiKhoan taiKhoan = new TaiKhoan();
        try {
            String sql = "SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.tenPB, PB.maPB, CV.tenCV, CV.maCV, TK.vaiTro\n" +
                    "FROM TaiKhoan AS TK \n" +
                    "\tJOIN NhanVien AS NV ON NV.maNV = TK.maTK\n" +
                    "\tJOIN PhongBan AS PB ON PB.maPB = NV.maPB\n" +
                    "\tJOIN ChucVu AS CV ON CV.maCV = NV.maCV\n" +
                    "WHERE NV.maNV = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, maNhanVien);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String tenPB = rs.getString("tenPB");
                String tenCV = rs.getString("tenCV");
                String maPB = rs.getString("maPB");
                String maCV = rs.getString("maCV");
                String vaiTro = rs.getString("vaiTro");
                PhongBan pb = new PhongBan(maPB, tenPB);
                ChucVu cv = new ChucVu(maCV, tenCV);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, cv, pb);
                taiKhoan = new TaiKhoan(nv, vaiTro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuTaiKhoan:\n" + taiKhoan + "\n");
        return taiKhoan;
    }

}
