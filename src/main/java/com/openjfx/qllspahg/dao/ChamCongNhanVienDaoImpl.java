package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.*;

import java.sql.*;
import java.util.List;

public class ChamCongNhanVienDaoImpl {
    public static ChamCongNhanVienDaoImpl getInstance() {
        return new ChamCongNhanVienDaoImpl();
    }

    public ObservableList<NhanVien> layDuLieuNhanVien() {
        Connection con = null;
        ObservableList<NhanVien> listNV = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.* " +
                    "FROM NhanVien AS NV " +
                    "JOIN PhongBan AS PB ON NV.maPB = PB.maPB";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB, tenPB);

                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, pb);
                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuNhanVien:\n" + listNV + "\n");
        return listNV;
    }

    //Lay du lieu phong ban
    public ObservableList<String> layDuLieuPhongBanNhanVien() {
        Connection con = null;
        ObservableList<String> listTenPB = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT PB.* " +
                    "FROM PhongBan AS PB";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String tenPB = rs.getString("tenPB");
                listTenPB.add(tenPB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuPhongBanNhanVien:\n" + listTenPB + "\n");
        return listTenPB;
    }


    //Tim du lieu phong ban o bang nhan vien
    public ObservableList<BangChamCongNhanVien> locDuLieuPhongBanNhanVien(String maNhanVien, String hoTenNhanVien, String ngayChamCong, String tenPhongBan) {
        Connection con = null;
        PreparedStatement pst = null;
        String truyVanTruocWhere = "SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.*, BCCNV.* \n" +
                "FROM NhanVien AS NV \n" +
                "JOIN PhongBan AS PB ON NV.maPB = PB.maPB \n" +
                "JOIN BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV ";
        String sql = SqlQueryBuilder.stringQueryLocBangChamCongNhanVien(truyVanTruocWhere, tenPhongBan, ngayChamCong, hoTenNhanVien, maNhanVien);
        ObservableList<BangChamCongNhanVien> listBCCNV = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maBCCNV = rs.getString("maBCCNV");
                String maNV = rs.getString("maNV");
                Date ngayCC = rs.getDate("ngayChamCong");
                boolean diLam = rs.getBoolean("diLam");
                boolean nghiPhep = rs.getBoolean("nghiPhep");
                boolean tangCa = rs.getBoolean("tangCa");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String tenPB = rs.getString("tenPB");
                String maPB = rs.getString("maPB");
                PhongBan pb = new PhongBan(maPB, tenPB);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, pb);

                BangChamCongNhanVien bccnv = new BangChamCongNhanVien(maBCCNV, nv, ngayCC, diLam, nghiPhep, tangCa);
                listBCCNV.add(bccnv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuPhongBanNhanVien:\n" + listBCCNV + "\n");
        return listBCCNV;
    }

    public boolean taoBangChamCongNhanVienThangTruoc(ObservableList<NhanVien> listNV) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO BangChamCongNhanVien (maBCCNV, maNV, ngayChamCong) VALUES ( ?, ?, ?)";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            List<String> ngayTiepTheo = Utils.taoDanhSachNgayTrongThangTruoc("dd/MM/yyyy");
            List<String> ngayTiepTheoMaNV = Utils.taoDanhSachNgayTrongThangTruoc("ddMMyy");
            for (NhanVien nv : listNV) {
                for (int i = 0; i < ngayTiepTheo.size(); i++) {
                    pst.setString(1, Utils.taoMaBangChamCong(nv.getMaNV(), ngayTiepTheoMaNV.get(i)));
                    pst.setString(2, nv.getMaNV());
                    pst.setString(3, DateUtils.chuyenDoiSangNgaySQL(ngayTiepTheo.get(i), "dd/MM/yyyy", "yyyy-MM-dd"));
                    pst.addBatch();
                }
                pst.executeBatch();
                System.out.println("Da tao bang cham cong vao csdl!!! ");
            }
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    //Tao du lieu bang cham cong thang tiep theo
    public boolean taoBangChamCongNhanVienThangTiepTheo(ObservableList<NhanVien> listNV) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO BangChamCongNhanVien (maBCCNV, maNV, ngayChamCong) VALUES ( ?, ?, ?)";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            List<String> ngayTiepTheo = Utils.taoDanhSachNgayTrongThangTiepTheo("dd/MM/yyyy");
            List<String> ngayTiepTheoMaNV = Utils.taoDanhSachNgayTrongThangTiepTheo("ddMMyy");
            for (NhanVien nv : listNV) {
                for (int i = 0; i < ngayTiepTheo.size(); i++) {
                    pst.setString(1, Utils.taoMaBangChamCong(nv.getMaNV(), ngayTiepTheoMaNV.get(i)));
                    pst.setString(2, nv.getMaNV());
                    pst.setString(3, DateUtils.chuyenDoiSangNgaySQL(ngayTiepTheo.get(i), "dd/MM/yyyy", "yyyy-MM-dd"));
                    pst.addBatch();
                }
                pst.executeBatch();
                System.out.println("Da tao bang cham cong vao csdl!!! ");
            }
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    //Tao du lieu bang cham cong thang hien tai
    public boolean taoBangChamCongNhanVienThangHienTai(ObservableList<NhanVien> listNV) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO BangChamCongNhanVien (maBCCNV, maNV, ngayChamCong) VALUES ( ?, ?, ?)";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            List<String> ngayTiepTheo = Utils.taoDanhSachNgayTrongThangHienTai("dd/MM/yyyy");
            List<String> ngayTiepTheoMaNV = Utils.taoDanhSachNgayTrongThangHienTai("ddMMyy");
            for (NhanVien nv : listNV) {
                for (int i = 0; i < ngayTiepTheo.size(); i++) {
                    pst.setString(1, Utils.taoMaBangChamCong(nv.getMaNV(), ngayTiepTheoMaNV.get(i)));
                    pst.setString(2, nv.getMaNV());
                    pst.setString(3, DateUtils.chuyenDoiSangNgaySQL(ngayTiepTheo.get(i), "dd/MM/yyyy", "yyyy-MM-dd"));
                    pst.addBatch();
                }
                pst.executeBatch();
                System.out.println("Da tao bang cham cong vao csdl!!! ");
            }
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    //Lay du lieu bang cham cong ngay hien tai
    public ObservableList<BangChamCongNhanVien> layDuLieuChamCongNhanVienNgayHienTai() {
        Connection con = null;
        ObservableList<BangChamCongNhanVien> listBCCNV = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.*, BCCNV.* " +
                    "FROM NhanVien AS NV " +
                    "JOIN PhongBan AS PB ON NV.maPB = PB.maPB " +
                    "JOIN BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV " +
                    "WHERE BCCNV.ngayChamCong = '" + Utils.taoNgayHienTai() + "'";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maBCCNV = rs.getString("maBCCNV");
                String maNV = rs.getString("maNV");
                Date ngayChamCong = rs.getDate("ngayChamCong");
                boolean diLam = rs.getBoolean("diLam");
                boolean nghiPhep = rs.getBoolean("nghiPhep");
                boolean tangCa = rs.getBoolean("tangCa");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String tenPB = rs.getString("tenPB");
                String maPB = rs.getString("maPB");
                PhongBan pb = new PhongBan(maPB, tenPB);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, pb);

                BangChamCongNhanVien bccnv = new BangChamCongNhanVien(maBCCNV, nv, ngayChamCong, diLam, nghiPhep, tangCa);
                listBCCNV.add(bccnv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuBangChamNhanVienNgayHienTai:\n" + listBCCNV + "\n");
        return listBCCNV;
    }

    //Lay du lieu cham cong nhan vien ngay tuy chon cho format date picker
    public ObservableList<BangChamCongNhanVien> layDuLieuChamCongNhanVienNgayTuyChon(String ngayTuyChon) {
        Connection con = null;
        ObservableList<BangChamCongNhanVien> listBCCNV = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.*, BCCNV.* " +
                    "FROM NhanVien AS NV " +
                    "JOIN PhongBan AS PB ON NV.maPB = PB.maPB " +
                    "JOIN BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV " +
                    "WHERE BCCNV.ngayChamCong = '" + ngayTuyChon + "'";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maBCCNV = rs.getString("maBCCNV");
                String maNV = rs.getString("maNV");
                Date ngayChamCong = rs.getDate("ngayChamCong");
                boolean diLam = rs.getBoolean("diLam");
                boolean nghiPhep = rs.getBoolean("nghiPhep");
                boolean tangCa = rs.getBoolean("tangCa");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                String tenPB = rs.getString("tenPB");
                String maPB = rs.getString("maPB");
                PhongBan pb = new PhongBan(maPB, tenPB);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, pb);

                BangChamCongNhanVien bccnv = new BangChamCongNhanVien(maBCCNV, nv, ngayChamCong, diLam, nghiPhep, tangCa);
                listBCCNV.add(bccnv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List LayDuLieuBangChamNhanVienNgayTuyChon:\n" + listBCCNV + "\n");
        return listBCCNV;
    }


    //Cap nhat bang cham cong nhan vien
    public boolean capNhatBangChamCongNhanVien(ObservableList<BangChamCongNhanVien> listUpdateBCCNV) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE BangChamCongNhanVien SET diLam = ?, tangCa = ?, nghiPhep = ? WHERE maBCCNV = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            for (BangChamCongNhanVien bccnv : listUpdateBCCNV) {
                pst.setBoolean(1, bccnv.getDiLam());
                pst.setBoolean(2, bccnv.getTangCa());
                pst.setBoolean(3, bccnv.getNghiPhep());
                pst.setString(4, bccnv.getMaBCCNV());
                pst.addBatch();
                System.out.println("Da cap nhat bang cham cong vao csdl!!! ");
            }
            pst.executeBatch();
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }







    /*public static void main(String[] args) throws ParseException {

        getInstance().TaoBangChamCongNhanVienThangHienTai(getInstance().LayDuLieuNhanVien());
    }*/
}
