package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TamUngNhanVien;
import com.openjfx.qllspahg.entity.model.TamUngNhanVien.BangTamUngNhanVienKemSoNgayDiLam;
import com.openjfx.qllspahg.gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class TamUngNhanVienDao {
    public static TamUngNhanVienDao getInstance(){
        return new TamUngNhanVienDao();
    }

    public ObservableList<BangTamUngNhanVienKemSoNgayDiLam> layTatCaThongTinTamUng(){
        ObservableList<BangTamUngNhanVienKemSoNgayDiLam> dsTamUng = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT TU.maTUNV, TU.maNV, TU.ngayTamUng, TU.lyDo, TU.soTienTamUng, NV.hoNV, NV.tenNV, NV.luongCoBan,\n" +
                    "SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +  \n" +
                    "SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS soNgayDiLam, PB.*\t\n" +
                    "FROM [dbo].[TamUngNhanVien] AS TU\n" +
                    "JOIN [dbo].[NhanVien] AS NV ON NV.maNV = TU.maNV\n" +
                    "JOIN [dbo].[BangChamCongNhanVien] AS BCC ON BCC.maNV = TU.maNV\n" +
                    "JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB\n" +
                    "WHERE MONTH (BCC.ngayChamCong) ="+ LocalDate.now().getMonth().getValue() +" \n" +
                    "AND YEAR (BCC.ngayChamCong) ="+ LocalDate.now().getYear() +" AND NV.trangThaiNV != 1\n" +
                    "GROUP BY TU.maNV, TU.maTUNV, TU.ngayTamUng, TU.soTienTamUng\n" +
                    ", TU.lyDo, NV.tenNV, NV.hoNV, NV.luongCoBan,PB.maPB, PB.tenPB";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maTU = rs.getString("maTUNV");

                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("hoNV");
                String tenNV = rs.getString("tenNV");
                double luongCoBan = rs.getDouble("luongCoBan");

                String maPB = rs.getString("maPB");
                String tenPB = rs.getString("tenPB");
                PhongBan pb = new PhongBan(maPB,tenPB);
                NhanVien nv = new NhanVien(maNV,hoNV,tenNV,pb,luongCoBan);

                Date ngayTamUng = rs.getDate("ngayTamUng");
                String lyDo = rs.getString("lyDo");
                double soTienTamUng = rs.getDouble("soTienTamUng");

                TamUngNhanVien TU = new TamUngNhanVien(maTU,nv, ngayTamUng,lyDo,soTienTamUng);

                int soNgayDiLam = rs.getInt("soNgayDiLam");

                BangTamUngNhanVienKemSoNgayDiLam bangTamUngNhanVien = new BangTamUngNhanVienKemSoNgayDiLam(TU,soNgayDiLam);

                dsTamUng.add(bangTamUngNhanVien);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsTamUng;
    }

    public BangTamUngNhanVienKemSoNgayDiLam layThongTinUngLuongTheoMaNV(String maNV){
        BangTamUngNhanVienKemSoNgayDiLam btukndl = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan,PB.*\t\n" +
                    "FROM [dbo].[NhanVien] AS NV \n" +
                    "JOIN [dbo].[PhongBan] AS PB ON PB.maPB = NV.maPB\n" +
                    "WHERE  NV.trangThaiNV != 1\n" +
                    "AND NV.maNV = '"+ maNV +"'\n" +
                    "GROUP BY  NV.maNV, NV.tenNV, NV.hoNV, NV.luongCoBan,PB.maPB, PB.tenPB";
            ResultSet rs = st.executeQuery(truyVan);

            //Kiẻm tra nếu di chuyển con trỏ tối dòng đầu tiên ko có dữ liệu thì dừng lại
            if (!rs.isBeforeFirst()){
                Alerts.showConfirmation("Thông báo", "Không tìm thấy mã nhân viên: "+maNV);
                return null;
            }

            rs.next();

            String maNhanVien = rs.getString("maNV");
            String hoNV = rs.getString("hoNV");
            String tenNV = rs.getString("tenNV");
            Double luongCoBan = rs.getDouble("luongCoBan");
            String maPB = rs.getString("maPB");
            String tenPB = rs.getString("tenPB");
            PhongBan pb = new PhongBan(maPB,tenPB);
            NhanVien nv = new NhanVien(maNhanVien,hoNV,tenNV,pb,luongCoBan);

            String truyVan2 = "SELECT SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +  \n" +
                    "SUM(CASE WHEN BCC.diLam = 1 THEN 1 ELSE 0 END)  AS soNgayDiLam\n" +
                    "FROM [dbo].[BangChamCongNhanVien] AS BCC\n" +
                    "JOIN [dbo].[NhanVien] AS NV ON NV.maNV = BCC.maNV\n" +
                    "WHERE MONTH (BCC.ngayChamCong) = "+ LocalDate.now().getMonth().getValue() +" \n" +
                    "AND YEAR (BCC.ngayChamCong) = "+ LocalDate.now().getYear() +" AND NV.trangThaiNV != 1\n" +
                    "AND NV.maNV = '"+maNhanVien+"'";
            ResultSet rs2 = st.executeQuery(truyVan2);
            rs2.next();
            int soNgayDiLam = rs2.getInt("soNgayDiLam");

            btukndl = new BangTamUngNhanVienKemSoNgayDiLam(new TamUngNhanVien("aaaaa",nv),soNgayDiLam);


        }catch (SQLException e){
            e.printStackTrace();
        }


        return btukndl;
    }

    public boolean luuThongTinTamUng(TamUngNhanVien tuNV){
        try {
           Connection con = Db.getConnection();
           String truyVan = "INSERT [dbo].[TamUngNhanVien] ([maTUNV], [maNV], [ngayTamUng],[lyDo],[soTienTamUng])\n" +
                   "VALUES\n" +
                   "(?,?,?,?,?)";
           PreparedStatement st = con.prepareStatement(truyVan);

           String maTuNV = tuNV.getMaTUNV();
           String maNV = tuNV.getMaNV().getMaNV().trim();
           Date ngayTamUng = tuNV.getNgayTamUng();
           String lyDo = tuNV.getLyDo();
           double soTienTamUng = tuNV.getSoTienTamUng();

           st.setString(1,maTuNV);
           st.setString(2,maNV);
           st.setDate(3,ngayTamUng);
           st.setString(4,lyDo);
           st.setDouble(5,soTienTamUng);
           int a = st.executeUpdate();

           if (a >0)
               return true;
        }catch (SQLException e){{
            e.printStackTrace();
        }}
        return false;
    }


}
