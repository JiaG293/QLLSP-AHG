package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan;
import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhan;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinSoLuongLamDuocTheoTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class PhanCongCongNhanDao {

    public static PhanCongCongNhanDao getInstance (){
        return new PhanCongCongNhanDao();
    }
    //Phần nhập
    public ObservableList<HopDong> getAllMaHopDong (){
        ObservableList<HopDong> dsMaHopDong = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT HD.maHD, HD.ngayTLHD\n" +
                    "FROM [dbo].[HopDong] AS HD\n" +
                    "WHERE HD.trangThaiHD !=1 \n" +
                    "ORDER BY HD.ngayTLHD ASC";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsMaHopDong.add(new HopDong(rs.getString("maHD"),rs.getDate(2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsMaHopDong;
    }
    public ObservableList<ToSanXuat> getAllTo(){
        ObservableList<ToSanXuat> dsTenTo = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT  TSX.maTSX, TSX.tenTSX\n" +
                    "FROM [dbo].[ToSanXuat] as TSX";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsTenTo.add(new ToSanXuat(rs.getString("maTSX"),rs.getString("tenTSX")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsTenTo;
    }

    public ObservableList<SanPham> getSPCanLamTheoMaHD(String maHD){
        ObservableList<SanPham> dsSanPham = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT DISTINCT SP.maSP, SP.tenSP\n" +
                    "FROM [dbo].[ChiTietHopDong] AS CT\n" +
                    "INNER JOIN [dbo].[HopDong] AS HD ON HD.maHD = CT.maHD\n" +
                    "INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP\n" +
                    "WHERE HD.trangThaiHD !=1 AND CT.maHD = '"+maHD+"'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsSanPham.add(new SanPham(rs.getString("maSP"),rs.getString("tenSP")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsSanPham;
    }
    public int getSoLuongCanlam(String maHD, String maSP){
        int a = 0;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT CT.soLuongDat - SUM(CT.soLuongDaLam)  as soLuongCanLam\n" +
                    "FROM [dbo].[ChiTietHopDong] AS CT\n" +
                    "INNER JOIN [dbo].[HopDong] AS HD ON CT.maHD = HD.maHD\n" +
                    "INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CT.maSP\n" +
                    "WHERE HD.trangThaiHD !=1 AND CT.maHD ='"+ maHD +"' AND SP.maSP = N'"+ maSP +"'\n" +
                    "GROUP BY CT.soLuongDaLam, CT.soLuongDat";
            ResultSet rs= st.executeQuery(truyVan);
            rs.next();
            a = rs.getInt("soLuongCanLam");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return a;
    }

    public ObservableList<CongDoan> getCongDoan (String maSp,String maHD){
        ObservableList<CongDoan> dsCongDoan = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT DISTINCT CD.maCD, CD.tenCD\n" +
                    "FROM [dbo].[CongDoan] AS CD\n" +
                    "INNER JOIN [dbo].[SanPham] AS SP ON CD.maSP = SP.maSP\n" +
                    "INNER JOIN [dbo].[ChiTietHopDong] AS CT ON SP.maSP = CT.maSP\n" +
                    "where SP.maSP=N'"+maSp+"' AND CT.maHD='"+maHD+"'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                dsCongDoan.add(new CongDoan(rs.getString("maCD"),rs.getString("tenCD")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsCongDoan;
    }

    public int getSoLuongDaPhanCong( String maSP, String maCD, String maHD){
        int soLuongCanLam = 0;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();

            String truyVan1 = "SELECT CD.maCD\n" +
                    "FROM [dbo].[SanPham] as SP\n" +
                    "INNER JOIN [dbo].[CongDoan] AS CD on SP.maSP = CD.maSP \n" +
                    "WHERE SP.maSP=N'"+maSP+"' and CD.maCD = N'"+maCD+"'";
            ResultSet rs1 = st.executeQuery(truyVan1);
            rs1.next();

            String maCongDoan = rs1.getString("maCD");

            String truyVan2 ="SELECT SUM(PC.chiTieu) As soLuongDaLam\n" +
                    "FROM [dbo].[BangPhanCongCongNhan] AS PC \n" +
                    "WHERE  PC.maHD='"+maHD+"' AND PC.maCD= '"+maCongDoan+"'";
            ResultSet rs2 = st.executeQuery(truyVan2);
            rs2.next();
            soLuongCanLam = rs2.getInt("soLuongDaLam");


        }catch (SQLException e){
            e.printStackTrace();
        }

        return soLuongCanLam;
    }

    public int getSoLuongNguoiDaPhanCongTrongTo(String maTo, String ngayHienTai){
        int soLuongNguoiDaPhanCongTrongTo = 0;
        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "SELECT COUNT(CN.maCN) AS soLuongDaPhanCongTrongTo\n" +
                    "FROM [dbo].[CongNhan] AS CN\n" +
                    "INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN\n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX\n" +
                    "where  CN.trangThaiCN !=1 AND TSX.maTSX = '"+maTo+"' AND PC.maBPCCN LIKE '%"+ngayHienTai+"'";
            ResultSet rs = st.executeQuery(truyVan);
            rs.next();
            soLuongNguoiDaPhanCongTrongTo = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return soLuongNguoiDaPhanCongTrongTo;
    }

    public int getSoLuongNguoiCoTrongTo(String maTo){
        int soLuongNguoiCoTrongTo = 0;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT COUNT(CN.maCN) AS soLuongNguoiTrongTo\n" +
                    "FROM [dbo].[CongNhan] AS CN\n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX\n" +
                    "where  CN.trangThaiCN !=1 AND TSX.maTSX = '"+maTo+"'";
            ResultSet rs =st.executeQuery(truyVan);
            rs.next();
            soLuongNguoiCoTrongTo = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return soLuongNguoiCoTrongTo;
    }

    public ObservableList<BangThongTinCongNhan>   getallCongNhanChuaPhanCongTheomaTo(String maTo, String ngayPhanCong) {
        ObservableList<BangThongTinCongNhan> dsCN = FXCollections.observableArrayList();
        ObservableList<String> dsCNDaPhanCong = FXCollections.observableArrayList();

        StringBuilder cauGhepTruyVan = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();

            String truyVan1 = "SELECT CN.maCN\n" +
                    "FROM [dbo].[CongNhan] AS CN\n" +
                    "INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN\n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX\n" +
                    "where  CN.trangThaiCN !=1 AND TSX.maTSX = '" + maTo + "' AND PC.maBPCCN LIKE '%" + ngayPhanCong + "'";
            ResultSet rs1 = st.executeQuery(truyVan1);
            while (rs1.next()) {
                dsCNDaPhanCong.add(rs1.getString("maCN"));
            }

            cauGhepTruyVan = new StringBuilder();
            for (int i = 0; i < dsCNDaPhanCong.size(); i++) {
                String maCN = "'" + dsCNDaPhanCong.get(i) + "'";
                cauGhepTruyVan.append(" AND CN.maCN != ").append(maCN);
            }


            String truyVan2 = "SELECT DISTINCT CN.maCN, CN.hoCN, CN.tenCN\n" +
                    "FROM [dbo].[CongNhan] AS CN\n" +
                    "where  CN.trangThaiCN !=1 AND CN.maTSX = '"+maTo+"'" + cauGhepTruyVan.toString();
            ResultSet rs2 = st.executeQuery(truyVan2);
            int stt = 0;
            while (rs2.next()){
                stt ++;
                dsCN.add(new BangThongTinCongNhan(stt,new CongNhan(rs2.getString("maCN"),rs2.getString("hoCN"),rs2.getString("tenCN"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsCN;
    }

    public boolean saveDSPhanCong(ObservableList<BangPhanCongCongNhan> dsPhanCong){
        int a = 0 ;
        if (dsPhanCong.isEmpty()){
            return true;
        }else {
            for (BangPhanCongCongNhan bpc : dsPhanCong){
                String maBPC = bpc.getMaBPCCN();
                String maCN = bpc.getMaCongNhan().getMaCN();
                String maCD = bpc.getMaCongDoan().getMaCD();
                String maHD = bpc.getMaHopDong().getMaHD();
                int chiTieu = bpc.getChiTieu();
                boolean tangCa = bpc.isTangCa();

                java.util.Date ngayPhanCong = bpc.getNgayPC();
                java.sql.Date ngayPhanCongSQL = new java.sql.Date(ngayPhanCong.getTime());

                java.util.Date ngayKetThuc = bpc.getNgayKT();
                java.sql.Date ngayKetThucSQL = new java.sql.Date(ngayKetThuc.getTime());

                try {
                    Connection con = Db.getConnection();
                    String truyVan = "INSERT [dbo].[BangPhanCongCongNhan] ([maBPCCN], [maCN], [maCD], [maHD], [chiTieu], [tangCa], [ngayPhanCong], [ngayKetThuc] )\n" +
                            "VALUES \n" +
                            "(?,?,?,?,?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(truyVan);
                    st.setString(1,maBPC);
                    st.setString(2,maCN);
                    st.setString(3,maCD);
                    st.setString(4,maHD);
                    st.setInt(5,chiTieu);
                    st.setBoolean(6,tangCa);
                    st.setDate(7,ngayPhanCongSQL);
                    st.setDate(8,ngayKetThucSQL);

                    a+=st.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                    return false;
                }

            }
            if (a>0){
                return true;
            }
        }

        return false;
    }

    public boolean saveDSUpdatePC(ObservableList<BangPhanCongCongNhan> dsUpdate){
        int a =0;
        if (dsUpdate.isEmpty())
            return true;

        else{
            for (BangPhanCongCongNhan bpc: dsUpdate){
                String mabpc = bpc.getMaBPCCN();;

                String maCD =bpc.getMaCongDoan().getMaCD();
                String maHD = bpc.getMaHopDong().getMaHD();

                int chiTieu = bpc.getChiTieu();
                boolean tangCa = bpc.isTangCa();

                java.util.Date ngayPC = bpc.getNgayPC();
                Date ngayPCSQL =new Date(ngayPC.getTime());
                java.util.Date ngayKT = bpc.getNgayKT();
                Date ngayKTSQL = new Date(ngayKT.getTime());

                try {
                    Connection con =Db.getConnection();
                    String truyVan = "UPDATE [dbo].[BangPhanCongCongNhan] \n" +
                            "SET\n" +
                            "[maCD] = '"+maCD+"',\n" +
                            "[maHD] = '"+maHD+"',\n" +
                            "[chiTieu] = "+chiTieu +",\n" +
                            "[tangCa] ="+tangCa+",\n"+
                            "[ngayPhanCong] = '"+ngayPCSQL+"',\n" +
                            "[ngayKetThuc] ='"+ngayKTSQL+"'\n" +
                            "WHERE [maBPCCN] LIKE '%"+mabpc+"'";


                    PreparedStatement st = con.prepareStatement(truyVan);

                    a+= st.executeUpdate();
                }catch (SQLException e ){
                    e.printStackTrace();
                    return false;
                }

            }
            if(a>0)
                return true;
        }


        return false;
    }

    public ObservableList<BangThongTinSoLuongLamDuocTheoTo> getAllSoLuongDaPhanCongTheoTo(String ngay){
        ObservableList<BangThongTinSoLuongLamDuocTheoTo> dsSoLuongTheoTo = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st1 =con.createStatement();
            Statement st2 = con.createStatement();
            Statement st3 = con.createStatement();

            String truyVan1 = "Select * from [dbo].[ToSanXuat]";
            ResultSet rs1 = st1.executeQuery(truyVan1);
            while (rs1.next()){
                String maTo = rs1.getString("maTSX");
                String tenTo = rs1.getNString("tenTSX");
                ToSanXuat tsx = new ToSanXuat(maTo,tenTo);

                String truyVan2 = "SELECT COUNT(CN.maCN) AS soLuongDaPhanCong\n" +
                        "FROM [dbo].[CongNhan] AS CN\n" +
                        "INNER JOIN [dbo].[BangPhanCongCongNhan] AS PC ON PC.maCN = CN.maCN\n" +
                        "JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX\n" +
                        "WHERE  CN.trangThaiCN !=1 AND TSX.maTSX = '"+maTo+"' AND PC.maBPCCN LIKE '%"+ngay+"'";
                ResultSet rs2 = st2.executeQuery(truyVan2);
                rs2.next();
                int soLuongDaPhanCong = rs2.getInt(1);

                String truyVan3= "Select COUNT(CN.maCN) \n" +
                        "from [dbo].[CongNhan] AS CN\n" +
                        "JOIN [dbo].[ToSanXuat] AS TSX on CN.maTSX = TSX.maTSX\n" +
                        "where CN.trangThaiCN !=1 AND TSX.maTSX = '"+maTo+"'";
                ResultSet rs3 = st3.executeQuery(truyVan3);
                rs3.next();
                int soLuongNguoiCoTrongTo = rs3.getInt(1);



                dsSoLuongTheoTo.add(new BangThongTinSoLuongLamDuocTheoTo(tsx,soLuongDaPhanCong,soLuongNguoiCoTrongTo));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsSoLuongTheoTo;
    }

    public SanPham getSanPham(String maHopDong, String maCongDoan) {
        SanPham sp = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT CT.maSP, SP.tenSP\n" +
                    "FROM [dbo].[ChiTietHopDong] AS CT\n" +
                    "JOIN [dbo].[CongDoan] AS CD ON CD.maSP =CT.maSP\n" +
                    "JOIN [dbo].[SanPham] AS SP ON SP.maSP= CT.maSP\n" +
                    "WHERE CT.maHD='" + maHopDong + "' AND CD.maCD='" + maCongDoan + "'";
            ResultSet rs = st.executeQuery(truyVan);
            rs.next();
            sp = new SanPham(rs.getString(1), rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return sp;
    }

    public ObservableList<BangPhanCongCongNhan> getDSPhanCongDaLuuTheoTo(String maTo, String ngayPC){
        ObservableList<BangPhanCongCongNhan> dsBPCCN = FXCollections.observableArrayList();
        try {
            Connection con = Db.getConnection();
            Statement st =con.createStatement();
            String truyVan = "Select PC.*, CN.hoCN, CN.tenCn\n" +
                    "from [dbo].[BangPhanCongCongNhan] AS PC\n" +
                    "JOIN [dbo].[CongNhan] AS CN ON CN.maCN=PC.maCN\n" +
                    "JOIN [dbo].[ToSanXuat] AS TSX ON TSX.maTSX = CN.maTSX\n" +
                    "WHERE TSX.maTSX = '"+maTo+"' AND PC.maBPCCN LIKE '%"+ngayPC+"'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                String maBPCCN =rs.getString("maBPCCN");
                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("hoCn");
                String tenCN = rs.getString("tenCN");
                String maCD = rs.getString("maCD");
                String maHD = rs.getString("maHD");
                int chiTieu = rs.getInt("chiTieu");
                boolean tangCa = rs.getBoolean("tangCa");
                java.util.Date ngayPhanCong = rs.getDate("ngayPhanCong");
                java.util.Date ngayKetThuc = rs.getDate("ngayKetThuc");

                dsBPCCN.add(new BangPhanCongCongNhan(maBPCCN,new CongNhan(maCN,hoCN,tenCN), new CongDoan(maCD), new HopDong(maHD), chiTieu,tangCa,ngayPhanCong,ngayKetThuc ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return dsBPCCN;
    }

    public CongNhan  getCongNhanTheoMa(String maCN){
        CongNhan cn = null;
        try {
            Connection con = Db.getConnection();
            Statement st = con.createStatement();
            String truyVan = "SELECT CN.maCN, CN.hoCN, CN.tenCN\n" +
                    "FROM [dbo].[CongNhan] AS CN\n" +
                    "WHERE CN.maCN ='"+maCN+"'";

            ResultSet rs = st.executeQuery(truyVan);
            rs.next();
            cn = new CongNhan(rs.getString(1), rs.getString(2), rs.getString(3));


        }catch (SQLException e){
            e.printStackTrace();
        }

        return cn;
    }

    public CongDoan getSPvaCDVaoTablePhanCong( String maCD){
        CongDoan cd = null;
        try {
            Connection con =Db.getConnection();
            Statement st = con.createStatement();
            String truyVan ="SELECT  CD.maCD, CD.tenCD,SP.maSP, SP.[tenSP]\n" +
                    "FROM [dbo].[CongDoan] AS CD\n" +
                    "INNER JOIN [dbo].[SanPham] AS SP ON SP.maSP = CD.maSP\n" +
                    "WHERE CD.maCD ='"+maCD+"'";
            ResultSet rs = st.executeQuery(truyVan);
            while (rs.next()){
                SanPham sp = new SanPham(rs.getString(3),rs.getString(2));
                cd = new CongDoan(rs.getString(1),sp,rs.getString(4));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return cd;
    }

}
