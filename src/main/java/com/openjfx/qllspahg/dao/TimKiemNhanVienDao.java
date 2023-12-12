package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.model.timKiemNhanVien.BangTimKiemNhanVien;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Locale;

public class TimKiemNhanVienDao {

    public static TimKiemNhanVienDao getInstance(){
        return new TimKiemNhanVienDao();
    }

    public ObservableList<PhongBan> layTatCaPhongBan(){
        ObservableList<PhongBan> dsPhongBan = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[PhongBan]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsPhongBan.add(new PhongBan(rs.getString("maPB"),rs.getString("tenPB")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsPhongBan;
    }

    public ObservableList<ChucVu> layTatCaChucVu(){
        ObservableList<ChucVu> dsChucVu = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT * FROM [dbo].[ChucVu]";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsChucVu.add(new ChucVu(rs.getString("maCV"),rs.getString("tenCV")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsChucVu;
    }

    public ObservableList<BangTimKiemNhanVien> timKiemNhanVien(String maNhanVien, String machucVu, String maphongBan){
        ObservableList<BangTimKiemNhanVien> dsTimKiem = FXCollections.observableArrayList();

        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVantrcwhere = "SELECT NV.email, NV.hoNV,NV.maNV,NV.sDT, NV.sTK, NV.tenNV, NV.trangThaiNV, PB.*,CV.maCV,CV.tenCV,\n" +
                    "SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) AS SoNgayDiLam,\n" +
                    "SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS SoNgayNghiPhep,\n" +
                    "SUM(CASE WHEN BCC.diLam =0 AND BCC.nghiPhep = 0 THEN 1 ELSE 0 END) AS soNgayNghi\n" +
                    "FROM [dbo].[NhanVien] AS NV \n" +
                    "JOIN [dbo].[BangChamCongNhanVien] AS BCC ON BCC.maNV = NV.maNV\n" +
                    "JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB\n" +
                    "JOIN [dbo].[ChucVu] AS CV ON CV.maCV =NV.maCV\n" +
                    "WHERE MONTH (BCC.ngayChamCong) = "+ LocalDate.now().getMonth().getValue() +" \n" +
                    "AND YEAR (BCC.ngayChamCong) = "+LocalDate.now().getYear()+" ";

            String truyVan = SqlQueryBuilder.TimKiem(truyVantrcwhere,maNhanVien,machucVu,maphongBan);
            ResultSet rs = st.executeQuery(truyVan);
            if (!rs.isBeforeFirst()){
                Alerts.showConfirmation("Thông báo", "Không tìm thấy");
                return null;
            }
            while (rs.next()){
                    String maNV = rs.getString("maNV");
                    String hoNV = rs.getString("hoNV");
                    String tenNV = rs.getString("tenNV");
                    String sDT =rs.getString("sDT");
                    String email = rs.getString("email");
                    String sTK = rs.getString("sTK");
                    ChucVu cv = new ChucVu(rs.getString("maCV"), rs.getString("tenCV"));
                    PhongBan pb = new PhongBan(rs.getString("maPB"),rs.getString("tenPB"));
                    NhanVien nv= new NhanVien(maNV,hoNV,tenNV,sDT,email,sTK,cv,pb);

                    BangTimKiemNhanVien btk = new BangTimKiemNhanVien(rs.getBoolean("trangThaiNV"),
                            nv,rs.getInt("SoNgayDiLam"),
                            rs.getInt("SoNgayNghiPhep"),rs.getInt("soNgayNghi"));
                    dsTimKiem.add(btk);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return dsTimKiem;
    }
}
