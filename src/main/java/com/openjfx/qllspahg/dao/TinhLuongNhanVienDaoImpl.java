package com.openjfx.qllspahg.dao;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.ChiTietLuongNhanVien;
import com.openjfx.qllspahg.gui.util.SqlQueryBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class TinhLuongNhanVienDaoImpl {

    public static TinhLuongNhanVienDaoImpl getInstance() {
        return new TinhLuongNhanVienDaoImpl();
    }


    public ObservableList<ChiTietLuongNhanVien> tinhLuongNhanVienTuDongTuyChon(String thang, String nam) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<ChiTietLuongNhanVien> listCTLNV = FXCollections.observableArrayList();
        try {
            String sql = "SELECT \n" +
                    "    NV.maNV,\n" +
                    "    NV.hoNV,\n" +
                    "    NV.tenNV,\n" +
                    "    NV.luongCoBan,\n" +
                    "\tTUNV.soTienTamUng,\n" +
                    "\tTUNV.ngayTamUng,\n" +
                    "    CV.heSoCV,\n" +
                    "    PB.tenPB,\n" +
                    "    PC.tienChuyenCan,\n" +
                    "    PC.tienConNho,\n" +
                    "    PC.tienNhaTro,\n" +
                    "    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,\n" +
                    "    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,\n" +
                    "    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,\n" +
                    "    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,\n" +
                    "\n" +
                    "\n" +
                    "    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,\n" +
                    "    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,\n" +
                    "    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,\n" +
                    "    (\n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV\n" +
                    "        ) +\n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV\n" +
                    "        ) +\n" +
                    "        (\n" +
                    "            COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)\n" +
                    "        ) -\n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100\n" +
                    "        ) - \n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100\n" +
                    "        ) - \n" +
                    "        (\n" +
                    "             COALESCE(TUNV.soTienTamUng, 0)\n" +
                    "        ) -\n" +
                    "        (\n" +
                    "            CASE WHEN (\n" +
                    "                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - \n" +
                    "                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)\n" +
                    "            ) > -1 \n" +
                    "            THEN (\n" +
                    "                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - \n" +
                    "                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)\n" +
                    "            ) * 50000\n" +
                    "            ELSE 0 \n" +
                    "            END\n" +
                    "        ) +\n" +
                    "        (\n" +
                    "            CASE WHEN\n" +
                    "                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) = 0 \n" +
                    "            THEN PC.tienChuyenCan\n" +
                    "            ELSE 0 \n" +
                    "            END\n" +
                    "        )\n" +
                    "    ) AS luongThucTe\n" +
                    "FROM \n" +
                    "\tNhanVien AS NV\n" +
                    "LEFT JOIN \n" +
                    "    BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV AND MONTH(BCCNV.ngayChamCong) = 12 AND YEAR(BCCNV.ngayChamCong) = 2023 \n" +
                    "LEFT JOIN\n" +
                    "    PhongBan AS PB ON PB.maPB = NV.maPB\n" +
                    "LEFT JOIN \n" +
                    "    ChucVu AS CV ON NV.maCV = CV.maCV\n" +
                    "LEFT JOIN \n" +
                    "    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap\n" +
                    "LEFT JOIN \n" +
                    "    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maNV AND MONTH(TUNV.ngayTamUng) = 12 AND YEAR(TUNV.ngayTamUng) = 2023 \n" +
                    "GROUP BY \n" +
                    "    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB,TUNV.soTienTamUng, TUNV.ngayTamUng,\n" +
                    "\tPC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, NV.maPhuCap;\n";

            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, thang);
            pst.setString(2, nam);

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

                /*ChiTietLuongNhanVien bccnv = new ChiTietLuongNhanVien();
                listCTLNV.add(bccnv);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List Chi tiet luong nhan vien:\n" + listCTLNV + "\n");
        return listCTLNV;
    }

    public ObservableList<ChiTietLuongNhanVien> tinhLuongNhanVienTuDong(String thang, String nam) {
        Connection con = null;
        PreparedStatement pst = null;
        ObservableList<ChiTietLuongNhanVien> listCTLNV = FXCollections.observableArrayList();
        try {
            String sql = "SELECT \n" +
                    "    NV.maNV,\n" +
                    "    NV.hoNV,\n" +
                    "    NV.tenNV,\n" +
                    "    NV.luongCoBan,\n" +
                    "\tTUNV.soTienTamUng,\n" +
                    "\tTUNV.ngayTamUng,\n" +
                    "    CV.heSoCV,\n" +
                    "    PB.tenPB,\n" +
                    "    PC.tienChuyenCan,\n" +
                    "    PC.tienConNho,\n" +
                    "    PC.tienNhaTro,\n" +
                    "    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,\n" +
                    "    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,\n" +
                    "    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,\n" +
                    "    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,\n" +
                    "\n" +
                    "\n" +
                    "    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV) AS luongNhanDuoc,\n" +
                    "    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100) AS phiBHYT,\n" +
                    "    ((NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100) AS phiBHXH,\n" +
                    "    (\n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV\n" +
                    "        ) +\n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.tangCa = 'True' OR BCCNV.tangCa = 1 THEN 1 ELSE 0 END) * CV.heSoCV\n" +
                    "        ) +\n" +
                    "        (\n" +
                    "            COALESCE(PC.tienConNho, 0) + COALESCE(PC.tienNhaTro, 0)\n" +
                    "        ) -\n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 1.5 / 100\n" +
                    "        ) - \n" +
                    "        (\n" +
                    "            (NV.luongCoBan / 26) * SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) * CV.heSoCV * 8.5 / 100\n" +
                    "        ) - \n" +
                    "        (\n" +
                    "              COALESCE(TUNV.soTienTamUng, 0) \n" +
                    "        ) -\n" +
                    "        (\n" +
                    "            CASE WHEN (\n" +
                    "                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - \n" +
                    "                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)\n" +
                    "            ) > -1 \n" +
                    "            THEN (\n" +
                    "                SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) - \n" +
                    "                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END)\n" +
                    "            ) * 50000\n" +
                    "            ELSE 0 \n" +
                    "            END\n" +
                    "        ) +\n" +
                    "        (\n" +
                    "            CASE WHEN\n" +
                    "                SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) = 0 \n" +
                    "            THEN PC.tienChuyenCan\n" +
                    "            ELSE 0 \n" +
                    "            END\n" +
                    "        )\n" +
                    "    ) AS luongThucTe\n" +
                    "FROM \n" +
                    "\tNhanVien AS NV\n" +
                    "LEFT JOIN \n" +
                    "    BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV AND MONTH(BCCNV.ngayChamCong) = ? AND YEAR(BCCNV.ngayChamCong) = ? \n" +//Join va loc thang nam trung voi yeu cau
                    "LEFT JOIN\n" +
                    "    PhongBan AS PB ON PB.maPB = NV.maPB\n" +
                    "LEFT JOIN \n" +
                    "    ChucVu AS CV ON NV.maCV = CV.maCV\n" +
                    "LEFT JOIN \n" +
                    "    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap\n" +
                    "LEFT JOIN \n" +
                    "    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maNV AND MONTH(TUNV.ngayTamUng) = ? AND YEAR(TUNV.ngayTamUng) = ? \n" + //Join va loc thang nam trung voi yeu cau
                    "GROUP BY \n" +
                    "    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB,TUNV.soTienTamUng, TUNV.ngayTamUng,\n" +
                    "\tPC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, NV.maPhuCap;\n";
            con = Db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, thang);
            pst.setString(2, nam);
            pst.setString(3, thang);
            pst.setString(4, nam);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maNV = rs.getString("maNV");
                String hoNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                double luongCoBan = rs.getDouble("luongCoBan");
                double heSoCV = rs.getDouble("heSoCV");
                String tenPB = rs.getString("tenPB");
                double soTienTamUng = rs.getDouble("soTienTamUng");
                double tienChuyenCan = rs.getDouble("tienChuyenCan");
                double tienConNho = rs.getDouble("tienConNho");
                double tienNhaTro = rs.getDouble("tienNhaTro");
                int soNgayDiLam = rs.getInt("soNgayDiLam");
                int soNgayNghi = rs.getInt("soNgayNghi");
                int soNgayCoPhep = rs.getInt("soNgayCoPhep");
                int soNgayTangCa = rs.getInt("soNgayTangCa");
                double luongNhanDuoc = rs.getDouble("luongNhanDuoc");
                double phiBHYT = rs.getDouble("phiBHYT");
                double phiBHXH = rs.getDouble("phiBHXH");
                double luongThucTe = rs.getDouble("luongThucTe");

                PhongBan pb = new PhongBan(tenPB);
                ChucVu cv = new ChucVu(heSoCV);
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, cv, pb, luongCoBan);
                TamUngNhanVien tunv = new TamUngNhanVien(maNV, soTienTamUng);
                PhuCap pc = new PhuCap(tienChuyenCan, tienConNho, tienNhaTro);
                ChiTietLuongNhanVien bccnv = new ChiTietLuongNhanVien(nv, tunv, pc, soNgayDiLam, soNgayTangCa, soNgayNghi, soNgayCoPhep, luongNhanDuoc, luongThucTe, phiBHYT, phiBHXH);
                listCTLNV.add(bccnv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("List Chi tiet luong nhan vien:\n" + listCTLNV + "\n");
        return listCTLNV;
    }
}
