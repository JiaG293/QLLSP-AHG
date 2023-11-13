package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.ChamCongNhanVienDao;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.database.DbException;
import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.*;

import java.sql.*;

public class ChamCongNhanVienDaoImpl {
    public static ChamCongNhanVienDaoImpl getInstance() {
        return new ChamCongNhanVienDaoImpl();
    }


    public ObservableList<NhanVien> LayDuLieuNhanVien() {
        ObservableList<NhanVien> listNV = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT NV.maNV, NV.hoNV, NV.tenNV, PB.* " +
                    "FROM NhanVien as NV, PhongBan as PB ";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {  //con dong tiep theo thi tiep tuc lam
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
        System.out.println("List ChamCongNhanVien:\n" + listNV);
        return listNV;
    }

    public ObservableList<BangChamCongNhanVien> TaoBangChamCongNhanVien(ObservableList<NhanVien> listNV) {
        ObservableList<BangChamCongNhanVien> listChamCongNV = FXCollections.observableArrayList();
        try {

            Connection con = Db.getConnection();
            String sql = "INSERT INTO BangChamCongNhanVien (maBCCNV, maNV, ngayChamCong) VALUES ( ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            for (NhanVien nv : listNV) {
                pst.setString(1, Utils.TaoMaBangChamCong(nv.getMaNV()));
                pst.setString(2, nv.getMaNV());
                pst.setString(3, Utils.TaoNgayHienTai());

                pst.executeUpdate();

                System.out.println("Da tao bang " + Utils.TaoNgayHienTai() + " cham cong vao csdl");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
