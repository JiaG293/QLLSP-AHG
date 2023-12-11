package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.TamUngCongNhan.BangTamUngCongNhanKemSoNgay;
import com.openjfx.qllspahg.entity.model.TamUngNhanVien.BangTamUngNhanVienKemSoNgayDiLam;
import com.openjfx.qllspahg.gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class TamUngCongNhanDao {

    public static TamUngCongNhanDao getInstance(){
        return new TamUngCongNhanDao();
    }

    public ObservableList<BangTamUngCongNhanKemSoNgay> layTatCaThongTinTamUng(){
        ObservableList<BangTamUngCongNhanKemSoNgay> dsTamUng = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT TU.maTUCN, TU.maCN, TU.ngayTamUng, TU.lyDo, TU.soTienTamUng, CN.hoCN, CN.tenCN,\n" +
                    "SUM(CASE WHEN BCC.nghiPhep = 1 THEN 1 ELSE 0 END ) +\n" +
                    "SUM(CASE WHEN BCC.soLuongLamDuoc > 0 THEN 1 ELSE 0 END)  AS soNgayDiLam,\n" +
                    "TSX.*\n" +
                    "FROM [dbo].[TamUngCongNhan] AS TU\n" +
                    "JOIN [dbo].[CongNhan] AS CN ON CN.maCN = TU.maCN \n" +
                    "JOIN [dbo].[BangPhanCongCongNhan] AS BPC ON BPC.maCN = CN.maCN\n" +
                    "JOIN [dbo].[BangChamCongCongNhan] AS BCC ON BCC.maBPCCN = BPC.maBPCCN\n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX\n" +
                    "WHERE MONTH (BCC.ngayChamCong) = "+LocalDate.now().getMonth().getValue()+" \n" +
                    "AND YEAR (BCC.ngayChamCong) = "+ LocalDate.now().getYear() +" \n" +
                    "AND CN.trangThaiCN != 1\n" +
                    "GROUP BY TU.maTUCN, TU.maCN, TU.maCN, TU.ngayTamUng, TU.soTienTamUng\n" +
                    ", TU.lyDo, CN.tenCN, CN.hoCN,TSX.maTSX, TSX.tenTSX";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maTU = rs.getString("maTUCN");

                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCN");
                String tenCN = rs.getString("tenCN");


                String maTSX = rs.getString("maTSX");
                String tenTSX = rs.getString("tenTSX");
                ToSanXuat tSX = new ToSanXuat(maTSX,tenTSX);
                CongNhan cn = new CongNhan(maCN,hoCN,tenCN,tSX);

                Date ngayTamUng = rs.getDate("ngayTamUng");
                String lyDo = rs.getString("lyDo");
                double soTienTamUng = rs.getDouble("soTienTamUng");

                TamUngCongNhan TU = new TamUngCongNhan(maTU,cn, ngayTamUng,lyDo,soTienTamUng);

                int soNgayDiLam = rs.getInt("soNgayDiLam");

                BangTamUngCongNhanKemSoNgay bangTamUngNhanVienKemSoNgayDiLam = new BangTamUngCongNhanKemSoNgay(TU,soNgayDiLam);

                dsTamUng.add(bangTamUngNhanVienKemSoNgayDiLam);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsTamUng;
    }

    public BangTamUngCongNhanKemSoNgay layThongTinUngLuongTheoMaCN(String maCN){
        BangTamUngCongNhanKemSoNgay btukndl = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT CN.maCN, CN.hoCN, CN.tenCN, TSX.*\t\n" +
                    "FROM [dbo].[CongNhan] AS CN \n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX\n" +
                    "WHERE  CN.trangThaiCN != 1\n" +
                    "AND CN.maCN = '"+ maCN +"'\n" +
                    "GROUP BY  CN.maCN, CN.tenCN, CN.hoCN,TSX.maTSX, TSX.tenTSX";
            ResultSet rs = st.executeQuery(truyVan);

            //Kiẻm tra nếu di chuyển con trỏ tối dòng đầu tiên ko có dữ liệu thì dừng lại
            if (!rs.isBeforeFirst()){
                Alerts.showConfirmation("Thông báo", "Không tìm thấy mã Công nhân: "+maCN);
                return null;
            }

            rs.next();

            String maCongNhan = rs.getString("maCN");
            String hoCN = rs.getString("hoCN");
            String tenCN = rs.getString("tenCN");
            String maTSX = rs.getString("maTSX");
            String tenTSX = rs.getString("tenTSX");
            ToSanXuat tSX = new ToSanXuat(maTSX,tenTSX);
            CongNhan cn = new CongNhan(maCongNhan,hoCN,tenCN,tSX);

            String truyVan2 = "SELECT SUM(CASE WHEN BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) +   \n" +
                    "SUM(CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END) AS soNgayDiLam\n" +
                    "FROM [dbo].[BangChamCongCongNhan] AS BCCCN\n" +
                    "JOIN [dbo].[BangPhanCongCongNhan] AS BPC ON BCCCN.maBPCCN = BPC.maBPCCN\n"+
                    "JOIN [dbo].[CongNhan] AS CN ON BPC.maCN = CN.maCN\n" +
                    "WHERE MONTH (BCCCN.ngayChamCong) = "+ LocalDate.now().getMonth().getValue() +" \n" +
                    "AND YEAR (BCCCN.ngayChamCong) = "+ LocalDate.now().getYear() +" AND CN.trangThaiCN != 1\n" +
                    "AND CN.maCN = '"+maCongNhan+"'";
            ResultSet rs2 = st.executeQuery(truyVan2);
            rs2.next();
            int soNgayDiLam = rs2.getInt("soNgayDiLam");

            btukndl = new BangTamUngCongNhanKemSoNgay(new TamUngCongNhan("aaaaa",cn),soNgayDiLam);


        }catch (SQLException e){
            e.printStackTrace();
        }


        return btukndl;
    }

    public boolean luuThongTinTamUng(TamUngCongNhan tuCN){
        try {
            Connection con = Db.getConnection();
            String truyVan = "INSERT [dbo].[TamUngCongNhan] ([maTUCN], [maCN], [ngayTamUng],[lyDo],[soTienTamUng])\n" +
                    "VALUES\n" +
                    "(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(truyVan);

            String maTuCN = tuCN.getMaTUCN();
            String maCN = tuCN.getMaCN().getMaCN().trim();
            Date ngayTamUng = tuCN.getNgayTamUng();
            String lyDo = tuCN.getLyDo();
            double soTienTamUng = tuCN.getSoTienTamUng();

            st.setString(1,maTuCN);
            st.setString(2,maCN);
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
