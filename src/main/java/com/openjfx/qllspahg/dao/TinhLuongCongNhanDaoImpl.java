package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.ChiTietLuongCongNhan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class TinhLuongCongNhanDaoImpl {
    public static TinhLuongCongNhanDaoImpl getInstance() {
        return new TinhLuongCongNhanDaoImpl();
    }

    public ObservableList<ChiTietLuongCongNhan> tinhLuongCongNhanTuDong(String thang, String nam) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<ChiTietLuongCongNhan> listCTLCN = FXCollections.observableArrayList();
        try {
            String sql = "SELECT\n" +
                    "\tCN.maCN, CN.hoCN, CN.tenCN,\n" +
                    "\tTSX.tenTSX,\n" +
                    "\tCV.maCV, CV.heSoCV, \n" +
                    "\tTUCN.soTienTamUng,\n" +
                    "\tTUCN.ngayTamUng,\n" +
                    "\tSUM( BPCCN.chiTieu ) AS tongChiTieuPhanCong,\n" +
                    "\tSUM( BCCCN.soLuongLamDuoc) AS soLuongLamDuoc,\n" +
                    "\tSUM( CASE WHEN BCCCN.soLuongLamDuoc > 0 THEN 1 ELSE 0 END) AS soNgayDiLam,\n" +
                    "\tSUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) AS soNgayNghi,\n" +
                    "\tSUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END ) AS soNgayNghiPhep,\n" +
                    "\tSUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) AS tienCongCongDoan,\n" +
                    "\tSUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN 1 ELSE 0 END ) AS phanTangCaCoDiLam,\n" +
                    "\tSUM( BCCCN.soLuongLamCa3) AS soLuongLamCa3,\n" +
                    "\tSUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 \n" +
                    "\t\tTHEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) \n" +
                    "\t\tELSE 0 END\n" +
                    "\t\t) AS tienCongCongDoanTangCa,\n" +
                    "\n" +
                    "\t((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + \n" +
                    "\t\tSUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100\n" +
                    "\t) AS phiBHXH,\n" +
                    "\n" +
                    "\t((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + \n" +
                    "\t\tSUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100\n" +
                    "\t) AS phiBHYT,\n" +
                    "\t\n" +
                    "\t((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + \n" +
                    "\t\tSUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV\n" +
                    "\t) AS tongLuongCN,\n" +
                    "\n" +
                    "\t(\n" +
                    "\t\t((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV) - \n" +
                    "\t\t((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 8.5 / 100) - \n" +
                    "\t\t((SUM( BCCCN.soLuongLamDuoc * CD.giaCongDoan ) + SUM( CASE WHEN BPCCN.trangThaiTangCa = 1 AND BCCCN.soLuongLamCa3 > 0 THEN ( BCCCN.soLuongLamCa3 * CD.giaCongDoan * 1.5 ) ELSE 0 END)) * CV.heSoCV * 1.5 / 100) -\n" +
                    "        (\n" +
                    "            CASE WHEN (\n" +
                    "                SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - \n" +
                    "                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )\n" +
                    "            ) > -1 \n" +
                    "            THEN (\n" +
                    "\t\t\t(SUM( CASE WHEN BCCCN.soLuongLamDuoc IS NULL OR BCCCN.soLuongLamDuoc <= 0 THEN 1 ELSE 0 END) - \n" +
                    "                SUM( CASE WHEN BCCCN.nghiPhep = 'True' OR BCCCN.nghiPhep = 1 THEN 1 ELSE 0 END )) * 50000) ELSE 0 END\n" +
                    "\t\t) +\n" +
                    "\t\t(COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)) +\n" +
                    "\t\t(CASE WHEN (SUM(BCCCN.soLuongLamDuoc) + SUM(BCCCN.soLuongLamCa3)) >= SUM(BPCCN.chiTieu) THEN PC.tienNangSuat ELSE 0 END) -\n" +
                    "\t\t(COALESCE(TUCN.soTienTamUng, 0))\n" +
                    "\t) AS luongNhanThucTe,\n" +
                    "\n" +
                    "\tCASE WHEN SUM( BPCCN.chiTieu) <= (SUM(BCCCN.soLuongLamCa3) + SUM(BCCCN.soLuongLamDuoc)) THEN PC.tienNangSuat ELSE 0 END AS tienNangSuat,\n" +
                    "\tPC.tienConNho, PC.tienNhaTro\n" +
                    "FROM CongNhan AS CN\n" +
                    "\tLEFT JOIN BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN AND MONTH(BPCCN.ngayKetThuc) = ? AND YEAR(BPCCN.ngayKetThuc) = ? \n" +
                    "\tLEFT JOIN BangChamCongCongNhan AS BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN AND MONTH(BCCCN.ngayChamCong) = ? AND YEAR(BCCCN.ngayChamCong) = ? \n" +
                    "\tLEFT JOIN PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap\n" +
                    "\tLEFT JOIN TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN AND MONTH(TUCN.ngayTamUng) = ? AND YEAR(TUCN.ngayTamUng) = ? \n" +
                    "\tLEFT JOIN ChucVu AS CV ON CN.maCV = CV.maCV\n" +
                    "\tLEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX\n" +
                    "\tLEFT JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD\n" +
                    "WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL\n" +
                    "GROUP BY \n" +
                    "\tCN.maCN, CN.hoCN, CN.tenCN,\n" +
                    "\tTSX.tenTSX,\n" +
                    "\tCV.maCV, CV.heSoCV, \n" +
                    "\tPC.tienNangSuat, PC.tienConNho, PC.tienNhaTro,\n" +
                    "\tTUCN.soTienTamUng, TUCN.ngayTamUng;";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, thang);
            pst.setString(2, nam);
            pst.setString(3, thang);
            pst.setString(4, nam);
            pst.setString(5, thang);
            pst.setString(6, nam);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maCN = rs.getString("maCN");
                String hoCN = rs.getString("maCN");
                String tenCN = rs.getString("tenCN");
                String tenTSX = rs.getString("tenTSX");

                String maCV = rs.getString("maCV");
                double heSoCV = rs.getDouble("heSoCV");

                double soTienTamUng = rs.getDouble("soTienTamUng");
                Date ngayTamUng = rs.getDate("ngayTamUng");

                int tongChiTieuPhanCong = rs.getInt("tongChiTieuPhanCong");
                int soLuongLamDuoc = rs.getInt("soLuongLamDuoc");
                int SoLuongLamCaBa = rs.getInt("soLuongLamCa3");
                int soNgayDiLam = rs.getInt("soNgayDiLam");
                int soNgayNghi = rs.getInt("soNgayNghi");
                int soNgayCoPhep = rs.getInt("soNgayNghiPhep");
                int soNgayTangCa = rs.getInt("phanTangCaCoDiLam");

                double tienNangSuat = rs.getDouble("tienNangSuat");
                double tienConNho = rs.getDouble("tienConNho");
                double tienNhaTro = rs.getDouble("tienNhaTro");

                double phiBHXH = rs.getDouble("phiBHXH");
                double phiBHYT = rs.getDouble("phiBHYT");
                double luongNhanDuoc = rs.getDouble("tongLuongCN");
                double luongThucTe = rs.getDouble("luongNhanThucTe");

                ToSanXuat tsx = new ToSanXuat(tenTSX);
                ChucVu cv = new ChucVu(heSoCV);
                CongNhan cn = new CongNhan(maCN, hoCN, tenCN, cv, tsx);
                TamUngCongNhan tucn = new TamUngCongNhan(cn, soTienTamUng, ngayTamUng);
                PhuCap pc = new PhuCap(tienNangSuat, tienNhaTro, tienConNho);
                ChiTietLuongCongNhan ctlcn = new ChiTietLuongCongNhan(cn, tucn, pc, soNgayDiLam, soNgayTangCa, soNgayNghi, soNgayCoPhep, tongChiTieuPhanCong, soLuongLamDuoc, SoLuongLamCaBa, luongNhanDuoc, luongThucTe, phiBHYT, phiBHXH);
                listCTLCN.add(ctlcn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List Chi tiet luong cong nhan:\n" + listCTLCN + "\n");
        return listCTLCN;
    }
}
