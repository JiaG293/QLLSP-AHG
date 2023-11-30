package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Thuc thi va xu li sql o day
public class QuanLySanPhamDaoImpl {
    public static QuanLySanPhamDaoImpl getInstance() {
        return new QuanLySanPhamDaoImpl();
    }

    public ObservableList<SanPham> layDanhSachSanPham() {
        ObservableList<SanPham> listSP = FXCollections.observableArrayList();
        Connection con = null;
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenLoaiSP = rs.getString("tenLoai");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                SanPham sp = new SanPham(maSP, tenSP, tenLoaiSP, giaSP);

                listSP.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public ObservableList<SanPham> layDanhSachSanPhamTheoTrangThai(int trangThai) {
        ObservableList<SanPham> listSP = FXCollections.observableArrayList();
        Connection con = null;
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham WHERE trangThaiSP= " + trangThai;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenLoaiSP = rs.getString("tenLoai");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                SanPham sp = new SanPham(maSP, tenSP, tenLoaiSP, giaSP);

                listSP.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public ObservableList<String> taiDanhSachLoaiSanPham() {
        ObservableList<String> listLoaiSP = FXCollections.observableArrayList();
        listLoaiSP.add("Trống");
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT DISTINCT tenLoai " +
                    "FROM SanPham " +
                    "WHERE tenLoai IS NOT NULL";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String loaiSp = rs.getString("tenLoai");
                listLoaiSP.add(loaiSp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listLoaiSP;
    }

    public boolean themSanPhamMoi(SanPham sanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO SanPham(maSP, tenLoai,  tenSP, giaSP) " +
                    "VALUES (?, ?, ?, ?)";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, sanPham.getMaSP());
            pst.setString(2, sanPham.getTenLoaiSP());
            pst.setString(3, sanPham.getTenSP());
            pst.setDouble(4, sanPham.getGiaSP());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da them san pham moi vao csdl!!! ");
        return true;
    }

    public boolean suaSanPham(SanPham sanPhamSua) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE SanPham " +
                    "SET tenLoai = ?, tenSP = ? , giaSP = ? " +
                    "WHERE maSP = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, sanPhamSua.getTenLoaiSP());
            pst.setString(2, sanPhamSua.getTenSP());
            pst.setDouble(3, sanPhamSua.getGiaSP());
            pst.setString(4, sanPhamSua.getMaSP());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da cap nhat san pham co ma: " + sanPhamSua.getMaSP() + "  o csdl!!! ");
        return true;
    }

    //Xoa san pham tren ung dung, thay doi trang thai o csdl
    public boolean capNhatTrangThaiSanPham(String maSanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE SanPham " +
                    "SET trangThaiSP = 1 " +
                    "WHERE maSP = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maSanPham);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da doi trang thai san pham csdl!!! ");
        return true;
    }


    //Tao ma cho danh sach hop dong
    public ObservableList<String> layDanhSachMaSanPham() {
        Connection con = null;
        ObservableList<String> listMaSP = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT SP.maSP " +
                    "FROM SanPham AS SP";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maSP = rs.getString("maSP");
                listMaSP.add(maSP);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuDanhSachMaSanPham:\n" + listMaSP + "\n");
        return listMaSP;
    }

    //Lay danh sach cong doan theo ma san pham
    public ObservableList<CongDoan> layCongDoanSanPhamTheoMa(String maSanPham) {
        ObservableList<CongDoan> listCD = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "SELECT CD.* FROM CongDoan AS CD " +
                "WHERE CD.maSP=?";
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maSanPham);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maCD = rs.getString("maCD");
                String maSP = rs.getString("maSP");
                String tenCD = rs.getString("tenCD");
                String giaiDoan = rs.getString("giaiDoan");
                Double giaCongDoan = rs.getDouble("giaCongDoan");

                SanPham sp = new SanPham(maSP);

                CongDoan cd = new CongDoan(maCD, sp, tenCD, giaCongDoan, giaiDoan);

                listCD.add(cd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuDanhSachCongDoan:\n" + listCD + "\n");
        return listCD;
    }

    //Them cong doan san pham
    public boolean themCongDoanSanPham(CongDoan congDoan) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO CongDoan(maCD, maSP, tenCD, giaiDoan, giaCongDoan) " +
                    "VALUES (?, ?, ?, ?, ?)";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, congDoan.getMaCD());
            pst.setString(2, congDoan.getMaSanPham().getMaSP());
            pst.setString(3, congDoan.getTenCD());
            pst.setString(4, congDoan.getGiaiDoanCD());
            pst.setDouble(5, congDoan.getGiaCD());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        getInstance().capNhatGiaSanPhamKhiCoThayDoiCongDoan(congDoan.getMaSanPham().getMaSP());
        System.out.println("Da them cong Doan moi vao csdl!!! ");
        return true;
    }

    //Lay danh sach ma cong doan cua 1 san pham
    public ObservableList<String> layDanhSachMaCongDoanTheoSanPham(String maSanPham) {
        ObservableList<String> listMaCD = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "SELECT CD.maCD FROM CongDoan AS CD " +
                "WHERE CD.maSP=?";
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, maSanPham);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maCD = rs.getString("maCD");
                listMaCD.add(maCD);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("List LayDuLieuDanhSachMaCongDoan:\n" + listMaCD + "\n");
        return listMaCD;
    }

    //xoa cong doan san pham khoi csdl
    public boolean xoaCongDoanSanPham(String congDoanSanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM CongDoan WHERE maCD = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, congDoanSanPham);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        getInstance().capNhatGiaSanPhamKhiCoThayDoiCongDoan(UUIDUtils.taoMaSanPhamTuMaCongDoan(congDoanSanPham));
        System.out.println("Da xoa cong doan san pham o csdl!!! ");
        return true;
    }


    public double layGiaSanPhamMoi(String maSanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        double giaspMoi = -1;
        try {
            String sql = "SELECT SUM(CD.giaCongDoan) AS giaSPMoi " +
                    "FROM CongDoan AS CD " +
                    "WHERE CD.maSP = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maSanPham);

            rs = pst.executeQuery();
            while (rs.next()) {
                giaspMoi = rs.getDouble("giaSPMoi");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Gia san pham moi sau khi them cong doan: " + giaspMoi + "\n");
        return giaspMoi;
    }

    public double layGiaSanPhamCu(String maSanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        double giaspCu = -1;
        try {
            String sql = "SELECT SP.* " +
                    "FROM SanPham AS CD " +
                    "WHERE CD.maSP = ?";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maSanPham);

            rs = pst.executeQuery();
            while (rs.next()) {
                giaspCu = rs.getDouble("giaSP");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Gia san pham moi sau khi them cong doan: " + giaspCu + "\n");
        return giaspCu;
    }

    public boolean capNhatGiaSanPhamKhiCoThayDoiCongDoan(String maSanPham) { // gia cong doan thay doi thi se cap nhat gia san pham
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE SanPham " +
                    "SET giaSP = (SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = ?) " +
                    "WHERE maSP = ? " +
                    "AND ( " +
                    "SELECT giaSP FROM SanPham WHERE maSP = ? " +
                    ") <> ( " +
                    "SELECT SUM(CD.giaCongDoan) FROM CongDoan AS CD WHERE CD.maSP = ? " +
                    ")";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maSanPham);
            pst.setString(2, maSanPham);
            pst.setString(3, maSanPham);
            pst.setString(4, maSanPham);

            rs = pst.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da cap nhat gia san pham moi: " + rs + "\n");
        return true;
    }

    public boolean capNhatGiaSanPhamKhiThemCongDoanMoi(String maSanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE SanPham " +
                    "SET giaSP = ( " +
                    "SELECT SUM(CD.giaCongDoan) AS giaSPMoi " +
                    "FROM CongDoan AS CD " +
                    "WHERE CD.maSP = ? " +
                    ") " +
                    "WHERE maSP = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, maSanPham);
            pst.setString(2, maSanPham);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da cap nhat gia san pham khi them cong doan moi san pham o csdl!!! ");
        return true;
    }


    //sua gia cong doan va ten cong doan

    public boolean suaCongDoanSanPham(CongDoan congDoanSua) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE CongDoan " +
                    "SET tenCD = ?, giaCongDoan = ? , giaiDoan = ? " +
                    "WHERE maCD = ?";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, congDoanSua.getTenCD());
            pst.setDouble(2, congDoanSua.getGiaCD());
            pst.setString(3, congDoanSua.getGiaiDoanCD());
            pst.setString(4, congDoanSua.getMaCD());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Da cap nhat cong doan " + congDoanSua.getMaCD() + " cho san pham co ma: " + congDoanSua.getMaSanPham().getMaSP() + "  o csdl!!! ");
        return true;
    }

    public ObservableList<SanPham> locDuLieuDanhSachSanPham(String maSanPham, String tenSanPham, String loaiSanPham) {
        Connection con = null;
        PreparedStatement pst = null;
        String truyVanTruocWhere = "SELECT SP.* FROM SanPham AS SP";
        String sql = SqlQueryBuilder.stringQueryLocDanhSachSanPham(truyVanTruocWhere, maSanPham, tenSanPham, loaiSanPham);
        ObservableList<SanPham> listSP = FXCollections.observableArrayList();
        try {
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                String loaiSP = rs.getString("tenLoai");
                Double giaSP = rs.getDouble("giaSP");
                boolean trangThaiSP = rs.getBoolean("trangThaiSP");

                SanPham sp = new SanPham(maSP, loaiSP, tenSP, giaSP, trangThaiSP);
                listSP.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Dan sach du lieu loc san pham:\n" + listSP + "\n");
        return listSP;
    }


    public SanPham laySPBangMa(String maSanPham) {
        SanPham sp = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham" +
                    "WHERE " + "maSP= '" + maSanPham + "' ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");
                sp = new SanPham(maSP, tenSP, giaSP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public SanPham laySPBangTen(String tenSanPham) {
        SanPham sp = null;
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham" +
                    "WHERE " + "tenSP= '" + tenSanPham + "' ";
            //Thuc thi truy van
            ResultSet rs = st.executeQuery(sql);

            //Them tung doi tuong vao trong danh sach
            while (rs.next()) {

                //Gan du lieu tung table sql
                String maSP = rs.getString("maSP");
//                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                //Dua du lieu vao khuon de khoi tao doi tuong
                sp = new SanPham(maSP, tenSP, giaSP);

            }

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tra ra danh sach doi tuong duoc them vao
        return sp;
    }

    public ObservableList<SanPham> timSPBangMa(String maSanPham) {
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham" +
                    "WHERE " + "tenSP" +
                    "LIKE '%" + maSanPham + "%' ";
            //Thuc thi truy van
            ResultSet rs = st.executeQuery(sql);

            //Them tung doi tuong vao trong danh sach
            while (rs.next()) {

                //Gan du lieu tung table sql
                String maSP = rs.getString("maSP");
//                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                //Dua du lieu vao khuon de khoi tao doi tuong
                SanPham sp = new SanPham(maSP, tenSP, giaSP);

                //Them doi tuong vao danh sach
                list.add(sp);
            }

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tra ra danh sach doi tuong duoc them vao
        return list;
    }

    public ObservableList<SanPham> timSPBangTen(String tenSanPham) {
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            String sql = "SELECT * FROM SanPham" +
                    "WHERE " + "tenSP" +
                    "LIKE '%" + tenSanPham + "%' ";
            //Thuc thi truy van
            ResultSet rs = st.executeQuery(sql);

            //Them tung doi tuong vao trong danh sach
            while (rs.next()) {

                //Gan du lieu tung table sql
                String maSP = rs.getString("maSP");
//                String loaiSP = rs.getString("loaiSP");
                String tenSP = rs.getString("tenSP");
                Double giaSP = rs.getDouble("giaSP");

                //Dua du lieu vao khuon de khoi tao doi tuong
                SanPham sp = new SanPham(maSP, tenSP, giaSP);

                //Them doi tuong vao danh sach
                list.add(sp);
            }

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tra ra danh sach doi tuong duoc them vao
        return list;
    }


    public void xoaSP(SanPham sanPham) {
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();
            //Khai bao cau lenh sql
            /*DELETE FROM SanPham
                     WHERE maSP= 'SP9210'*/
            String sql = "DELETE FROM SanPham " +
                    "WHERE " + "maSP= '" + sanPham.getMaSP() + "' ";
            //Dong duoc insert thanh cong vao csdl
            int rs = st.executeUpdate(sql);
            System.out.println("Da chinh sua " + rs + " san pham tren csdl: ");

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaSP(SanPham sanPham) {
        try {
            //Tao ket noi voi csdl
            Connection con = Db.getConnection();
            //khai bao tao cau lenh thuc thi
            Statement st = con.createStatement();

            //Khai bao cau lenh sql
            /*UPDATE SanPham
            SET tenSP= 'Balo 9210', giaSP= 150000
            WHERE maSP= 'SP9210'*/
            String sql = "UPDATE SanPham " +
                    "SET " +
                    "tenSP= '" + sanPham.getTenSP() + "', " + "giaSP= '" + sanPham.getGiaSP() + "' " +
                    "WHERE " + "maSP= '" + sanPham.getMaSP() + "' ";
            //Dong duoc insert thanh cong vao csdl
            int rs = st.executeUpdate(sql);
            System.out.println("Da chinh sua " + rs + " san pham tren csdl: ");

            //Dong ket noi voi csdl moi khi thuc thi xong cau lenh truy van
//            Db.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
