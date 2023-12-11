package com.openjfx.qllspahg.gui.util;

public class SqlQueryBuilder {
    public static String stringQueryLocBangChamCongNhanVien(String cauTruyVanTruocWhere, String tenPB, String ngayChamCong, String hoTenNV, String maNV) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE ");

        if (tenPB != null && !tenPB.equals("Trống")) {
            sqlBuilder.append("PB.tenPB = N'").append(tenPB).append("' AND ");
        }

        if (ngayChamCong.isEmpty() != true) {
            sqlBuilder.append("BCCNV.ngayChamCong = '").append(ngayChamCong).append("' AND ");
        }

        if (hoTenNV.isEmpty() != true) {
            sqlBuilder.append("(NV.hoNV + ' ' + NV.tenNV) LIKE N'%").append(hoTenNV).append("%' AND ");
        }

        if (maNV.isEmpty() != true) {
            sqlBuilder.append("NV.maNV = '").append(maNV).append("' AND ");
        }

        // Xoa an cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

    public static String stringQueryLocDanhSachHopDong(String cauTruyVanTruocWhere, String trangThaiHopDong, String ngayBatDau, String ngayKetThuc) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE ");

        if (trangThaiHopDong != null && !trangThaiHopDong.equals("Tất cả")) {
            sqlBuilder.append("HD.trangThaiHD = '").append(trangThaiHopDong).append("' AND ");
        }

        if (ngayBatDau != null && ngayKetThuc != null) {
            sqlBuilder.append("HD.ngayKKHD BETWEEN '").append(ngayBatDau).append("' AND '").append(ngayKetThuc).append("' OR ").append("HD.ngayTLHD BETWEEN '").append(ngayBatDau).append("' AND '").append(ngayKetThuc).append("'");
        }
        // Xoa where cuoi neu co
        if (sqlBuilder.toString().endsWith("WHERE ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 6);
        }

        // Xoa and cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

    public static String stringQueryLocDanhSachSanPham(String cauTruyVanTruocWhere, String maSanPham, String tenSanPham, String loaiSanPham) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE trangThaiSP = 0 AND ");

        if (maSanPham != null && !maSanPham.isEmpty() && !maSanPham.equals(" ")) {
            sqlBuilder.append("SP.maSP = '").append(maSanPham).append("' AND ");
        }

        if (tenSanPham != null && !tenSanPham.isEmpty() && !tenSanPham.equals(" ")) {
            sqlBuilder.append("SP.tenSP LIKE '%").append(tenSanPham).append("%' AND ");
        }
        if (loaiSanPham != null && !loaiSanPham.equals("Trống") && !loaiSanPham.isEmpty()) {
            sqlBuilder.append("SP.tenLoai = N'").append(loaiSanPham).append("' AND ");
        }

        // Xoa where cuoi neu co
        if (sqlBuilder.toString().endsWith("WHERE ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 6);
        }

        // Xoa and cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

    public static String stringQueryLocBangChamCongCongNhan(String cauTruyVanTruocWhere, String maCongNhan, String tenCongNhan, String tenToSanXuat, String ngayChamCong) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE CN.trangThaiCN = 0 AND ");

        if (maCongNhan != null && !maCongNhan.isEmpty() && !maCongNhan.equals(" ")) {
            sqlBuilder.append("BPCCN.maCN = '").append(maCongNhan).append("' AND ");
        }

        if (tenCongNhan != null && !tenCongNhan.isEmpty() && !tenCongNhan.equals(" ")) {
            sqlBuilder.append("CN.tenCN LIKE '%").append(tenCongNhan).append("%' AND ");
        }
        if (tenToSanXuat != null && !tenToSanXuat.equals("Trống") && !tenToSanXuat.isEmpty()) {
            sqlBuilder.append("TSX.tenTSX = N'").append(tenToSanXuat).append("' AND ");
        }
        if (ngayChamCong != null && !ngayChamCong.isEmpty() && !ngayChamCong.equals(" ")) {
            sqlBuilder.append("BCCCN.ngayChamCong = '").append(ngayChamCong).append("' AND ");
        }

        // Xoa where cuoi neu co
        if (sqlBuilder.toString().endsWith("WHERE ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 6);
        }

        // Xoa and cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

    public static String stringQueryLocTinhLuongCongNhan(String cauTruyVanTruocWhere, String maCongNhan, String tenCongNhan, String tenToSanXuat, String thangBangLuong, String namBangLuong) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE ");

        if (maCongNhan != null && !maCongNhan.isEmpty() && !maCongNhan.equals(" ")) {
            sqlBuilder.append("CTLCN.maCN = '").append(maCongNhan).append("' AND ");
        }

        if (tenCongNhan != null && !tenCongNhan.isEmpty() && !tenCongNhan.equals(" ")) {
            sqlBuilder.append("CTLCN.tenCN LIKE '%").append(tenCongNhan).append("%' AND ");
        }
        if (tenToSanXuat != null && !tenToSanXuat.equals("Trống") && !tenToSanXuat.isEmpty()) {
            sqlBuilder.append("CTLCN.tenTSX = N'").append(tenToSanXuat).append("' AND ");
        }
        if (thangBangLuong != null && !thangBangLuong.isEmpty() && !thangBangLuong.equals(" ") &&
                namBangLuong != null && !namBangLuong.isEmpty() && !namBangLuong.equals(" ")) {
            sqlBuilder.append("CTLCN.thangChamCong = '").append(thangBangLuong).append("' AND CTLCN.namChamCong = '").append(namBangLuong).append("' AND ");
        }

        // Xoa where cuoi neu co
        if (sqlBuilder.toString().endsWith("WHERE ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 6);
        }

        // Xoa and cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

    public static String stringQueryLocTinhLuongCongNhanTuyChon(String cauTruyVanTruocWhere, String maCongNhan, String tenCongNhan, String tenToSanXuat, String thangBangLuong, String namBangLuong, String trangThaiLoc) {

        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere);
        if(trangThaiLoc.equals("Tất cả") || trangThaiLoc.equals("tất cả")){
            sqlBuilder.append(" WHERE ");
        } else {
            sqlBuilder.append(" WHERE BLCN.maBLCN IS NULL AND ");
        }

        if (maCongNhan != null && !maCongNhan.isEmpty() && !maCongNhan.equals(" ")) {
            sqlBuilder.append("CTLCN.maCN = '").append(maCongNhan).append("' AND ");
        }

        if (tenCongNhan != null && !tenCongNhan.isEmpty() && !tenCongNhan.equals(" ")) {
            sqlBuilder.append("CTLCN.tenCN LIKE '%").append(tenCongNhan).append("%' AND ");
        }
        if (tenToSanXuat != null && !tenToSanXuat.equals("Trống") && !tenToSanXuat.isEmpty()) {
            sqlBuilder.append("CTLCN.tenTSX = N'").append(tenToSanXuat).append("' AND ");
        }
        if (thangBangLuong != null && !thangBangLuong.isEmpty() && !thangBangLuong.equals(" ") &&
                namBangLuong != null && !namBangLuong.isEmpty() && !namBangLuong.equals(" ")) {
            sqlBuilder.append("CTLCN.thangChamCong = '").append(thangBangLuong).append("' AND CTLCN.namChamCong = '").append(namBangLuong).append("' AND ");
        }

        // Xoa where cuoi neu co
        if (sqlBuilder.toString().endsWith("WHERE ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 6);
        }

        // Xoa and cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

    public static void main(String[] args) {
        String sql = "WITH ChiTietLuongCongNhan AS\n" +
                "(SELECT\n" +
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
                "\tCASE WHEN SUM( BPCCN.chiTieu) <= (SUM(BCCCN.soLuongLamCa3) + SUM(BCCCN.soLuongLamDuoc)) THEN PC.tienNangSuat ELSE 0 END AS tienNangSuat, \n" +
                "\tPC.tienConNho, PC.tienNhaTro,\n" +
                "\tBCCCN.ngayChamCong\n" +
                "FROM CongNhan AS CN\n" +
                "\tLEFT JOIN BangPhanCongCongNhan AS BPCCN ON CN.maCN = BPCCN.maCN-- AND MONTH(BPCCN.ngayKetThuc) = 12 AND YEAR(BPCCN.ngayKetThuc) = 2023 \n" +
                "\tLEFT JOIN BangChamCongCongNhan AS BCCCN ON BPCCN.maBPCCN = BCCCN.maBPCCN-- AND MONTH(BCCCN.ngayChamCong) = 12 AND YEAR(BCCCN.ngayChamCong) = 2023 \n" +
                "\tLEFT JOIN PhuCap AS PC ON CN.maPhuCap = PC.maPhuCap\n" +
                "\tLEFT JOIN TamUngCongNhan AS TUCN ON CN.maCN = TUCN.maCN --AND MONTH(TUCN.ngayTamUng) = 12 AND YEAR(TUCN.ngayTamUng) = 2023 \n" +
                "\tLEFT JOIN ChucVu AS CV ON CN.maCV = CV.maCV\n" +
                "\tLEFT JOIN ToSanXuat AS TSX ON CN.maTSX = TSX.maTSX\n" +
                "\tLEFT JOIN CongDoan AS CD ON BPCCN.maCD = CD.maCD\n" +
                "WHERE trangThaiCN = 0 AND BPCCN.maBPCCN IS NOT NULL\n" +
                "GROUP BY \n" +
                "\tCN.maCN, CN.hoCN, CN.tenCN,\n" +
                "\tTSX.tenTSX,\n" +
                "\tCV.maCV, CV.heSoCV, \n" +
                "\tPC.tienNangSuat, PC.tienConNho, PC.tienNhaTro,\n" +
                "\tTUCN.soTienTamUng, TUCN.ngayTamUng,BCCCN.ngayChamCong\n" +
                ")\n" +
                "SELECT *\n" +
                "FROM ChiTietLuongCongNhan AS CTLCN\n";

        System.out.println(stringQueryLocTinhLuongCongNhanTuyChon(sql, null, "",
                null, "11", "2023", "Đã tạo"));



    }


    /**
     * Của Lộc
     */


    //Lọc của quản lý công nhân
    public static String stringQueryLocDanhSachTTCongNhan(String truyVanTruocWhere, String gt, String vaiTro, String toSanXuat) {
        StringBuilder sql = new StringBuilder().append(truyVanTruocWhere).append(" and ");

        if (gt != null)
            sql.append("cn.gioiTinh = '").append(gt).append("' and ");

        if (vaiTro != null)
            sql.append("cv.tenCV = N'").append(vaiTro).append("' and ");

        if (toSanXuat != null)
            sql.append("tsx.tenTSX = N'").append(toSanXuat).append("' and ");

        if (sql.toString().endsWith(" and "))
            sql.setLength(sql.length() - 5);

        return sql.toString();
    }

    //lọc của quản lý
}
