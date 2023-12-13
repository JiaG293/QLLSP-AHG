package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.entity.ChucVu;

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

    public static String stringQueryLocBangLuongCongNhan(String cauTruyVanTruocWhere, String maCongNhan, String tenCongNhan, String tenToSanXuat, String thangBangLuong, String namBangLuong, String trangThaiBangLuong) {

        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere);
        if(trangThaiBangLuong.equals("Tất cả") || trangThaiBangLuong.equals("tất cả")){
            sqlBuilder.append(" WHERE ");
        } else if(trangThaiBangLuong.equals("Đã thanh toán") || trangThaiBangLuong.equals("đã thanh toán")){
            sqlBuilder.append(" WHERE BLCN.trangThaiLuong = 1 AND ");
        } else {
            sqlBuilder.append(" WHERE BLCN.trangThaiLuong = 0 AND ");
        }

        if (maCongNhan != null && !maCongNhan.isEmpty() && !maCongNhan.equals(" ")) {
            sqlBuilder.append("CN.maCN = '").append(maCongNhan).append("' AND ");
        }

        if (tenCongNhan != null && !tenCongNhan.isEmpty() && !tenCongNhan.equals(" ")) {
            sqlBuilder.append("CN.tenCN LIKE '%").append(tenCongNhan).append("%' AND ");
        }
        if (tenToSanXuat != null && !tenToSanXuat.equals("Trống") && !tenToSanXuat.isEmpty()) {
            sqlBuilder.append("TSX.tenTSX = N'").append(tenToSanXuat).append("' AND ");
        }
        if (thangBangLuong != null && !thangBangLuong.isEmpty() && !thangBangLuong.equals(" ") &&
                namBangLuong != null && !namBangLuong.isEmpty() && !namBangLuong.equals(" ")) {
            sqlBuilder.append("MONTH(BLCN.ngayTinhLuong) = '").append(thangBangLuong).append("' AND YEAR(BLCN.ngayTinhLuong)= '").append(namBangLuong).append("' AND ");
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

    public static String stringQueryLocTinhLuongNhanVienTuyChon(String cauTruyVanTruocWhere, String maNhanVien, String tenNhanVien, String tenPhongBan, String thangBangLuong, String namBangLuong, String trangThaiLoc) {

        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere);
        if(trangThaiLoc.equals("Tất cả") || trangThaiLoc.equals("tất cả")){
            sqlBuilder.append(" WHERE ");
        } else {
            sqlBuilder.append(" WHERE BLNV.maBLNV IS NULL AND ");
        }

        if (maNhanVien != null && !maNhanVien.isEmpty() && !maNhanVien.equals(" ")) {
            sqlBuilder.append("CTLNV.maNV = '").append(maNhanVien).append("' AND ");
        }

        if (tenNhanVien != null && !tenNhanVien.isEmpty() && !tenNhanVien.equals(" ")) {
            sqlBuilder.append("CTLNV.tenNV LIKE '%").append(tenNhanVien).append("%' AND ");
        }
        if (tenPhongBan != null && !tenPhongBan.equals("Trống") && !tenPhongBan.isEmpty()) {
            sqlBuilder.append("CTLNV.tenPB = N'").append(tenPhongBan).append("' AND ");
        }
        if (thangBangLuong != null && !thangBangLuong.isEmpty() && !thangBangLuong.equals(" ") &&
                namBangLuong != null && !namBangLuong.isEmpty() && !namBangLuong.equals(" ")) {
            sqlBuilder.append("CTLNV.thangChamCong = '").append(thangBangLuong).append("' AND CTLNV.namChamCong = '").append(namBangLuong).append("' AND ");
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

    public static String stringQueryLocBangLuongNhanVien(String cauTruyVanTruocWhere, String maNhanVien, String tenNhanVien, String tenPhongBan, String thangBangLuong, String namBangLuong, String trangThaiBangLuong) {

        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere);
        if(trangThaiBangLuong.equals("Tất cả") || trangThaiBangLuong.equals("tất cả")){
            sqlBuilder.append(" WHERE ");
        } else if(trangThaiBangLuong.equals("Đã thanh toán") || trangThaiBangLuong.equals("đã thanh toán")){
            sqlBuilder.append(" WHERE BLNV.trangThaiLuong = 1 AND ");
        } else {
            sqlBuilder.append(" WHERE BLNV.trangThaiLuong = 0 AND ");
        }

        if (maNhanVien != null && !maNhanVien.isEmpty() && !maNhanVien.equals(" ")) {
            sqlBuilder.append("NV.maNV = '").append(maNhanVien).append("' AND ");
        }

        if (tenNhanVien != null && !tenNhanVien.isEmpty() && !tenNhanVien.equals(" ")) {
            sqlBuilder.append("NV.tenNV LIKE '%").append(tenNhanVien).append("%' AND ");
        }
        if (tenPhongBan != null && !tenPhongBan.equals("Trống") && !tenPhongBan.isEmpty()) {
            sqlBuilder.append("PB.tenPB = N'").append(tenPhongBan).append("' AND ");
        }
        if (thangBangLuong != null && !thangBangLuong.isEmpty() && !thangBangLuong.equals(" ") &&
                namBangLuong != null && !namBangLuong.isEmpty() && !namBangLuong.equals(" ")) {
            sqlBuilder.append("MONTH(BLNV.ngayTinhLuong) = '").append(thangBangLuong).append("' AND YEAR(BLNV.ngayTinhLuong)= '").append(namBangLuong).append("' AND ");
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
        String sql = "WITH ChiTietLuongNhanVien AS (\n" +
                "SELECT \n" +
                "    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan,\n" +
                "\tTUNV.soTienTamUng, TUNV.ngayTamUng,\n" +
                "    CV.heSoCV,\n" +
                "    PB.tenPB,\n" +
                "    PC.tienConNho,\n" +
                "    PC.tienNhaTro,\n" +
                "\t(\n" +
                "\t\tCASE WHEN ( SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) -\n" +
                "\t\t\tSUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) )\n" +
                "\t\t\t> -1 THEN PC.tienChuyenCan\n" +
                "\t\t\tELSE 0 END\n" +
                "\t) AS tienChuyenCan,\n" +
                "    SUM(CASE WHEN BCCNV.diLam = 'True' OR BCCNV.diLam = 1 THEN 1 ELSE 0 END) AS soNgayDiLam,\n" +
                "    SUM(CASE WHEN BCCNV.diLam = 'False' OR BCCNV.diLam = 0 THEN 1 ELSE 0 END) AS soNgayNghi,\n" +
                "    SUM(CASE WHEN BCCNV.nghiPhep > 0 THEN BCCNV.nghiPhep ELSE 0 END) AS soNgayCoPhep,\n" +
                "    SUM(CASE WHEN BCCNV.tangCa > 0 THEN BCCNV.tangCa ELSE 0 END) AS soNgayTangCa,\n" +
                "\n" +
                "\tMONTH(BCCNV.ngayChamCong) AS thangChamCong,\n" +
                "\tYEAR(BCCNV.ngayChamCong) AS namChamCong,\n" +
                "\t\n" +
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
                "    BangChamCongNhanVien AS BCCNV ON NV.maNV = BCCNV.maNV --AND MONTH(BCCNV.ngayChamCong) = 12 AND YEAR(BCCNV.ngayChamCong) = 2023 \n" +
                "LEFT JOIN\n" +
                "    PhongBan AS PB ON PB.maPB = NV.maPB\n" +
                "LEFT JOIN \n" +
                "    ChucVu AS CV ON NV.maCV = CV.maCV\n" +
                "LEFT JOIN \n" +
                "    PhuCap AS PC ON NV.maPhuCap = PC.maPhuCap\n" +
                "LEFT JOIN \n" +
                "    TamUngNhanVien AS TUNV ON NV.maNV = TUNV.maNV --AND MONTH(TUNV.ngayTamUng) = 12 AND YEAR(TUNV.ngayTamUng) = 2023 \n" +
                "GROUP BY \n" +
                "    NV.maNV, NV.hoNV, NV.tenNV, NV.luongCoBan, CV.heSoCV, PB.tenPB,TUNV.soTienTamUng, TUNV.ngayTamUng,\n" +
                "\tPC.tienChuyenCan, PC.tienConNho, PC.tienNhaTro, MONTH(BCCNV.ngayChamCong), YEAR(BCCNV.ngayChamCong)\n" +
                ")\n" +
                "SELECT *\n" +
                "FROM ChiTietLuongNhanVien AS CTLNV\n" +
                "\tLEFT JOIN BangLuongNhanVien AS BLNV ON CTLNV.maNV = BLNV.maNV\n";

        System.out.println(stringQueryLocTinhLuongNhanVienTuyChon(sql, null, null,
                null, "11", "2023", "Tất cả"));
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

    public static String TimKiem(String truyVanTruocWhere, String maNhanVien, String maChucVu, String maphongBan) {
        StringBuilder sql = new StringBuilder().append(truyVanTruocWhere).append(" and ");

        if (maNhanVien != null)
            sql.append("NV.maNV '").append(maNhanVien).append("' and ");

        if (maChucVu != null)
            sql.append("CV.maCV = '").append(maChucVu).append("' and ");

        if (maphongBan != null)
            sql.append("PB.maPB = '").append(maphongBan).append("' and ");

        if (sql.toString().endsWith(" and "))
            sql.setLength(sql.length() - 5);
        sql.append("GROUP BY  NV.email, \n" +
                "NV.hoNV,NV.maNV,NV.sDT, NV.sTK, NV.tenNV, NV.trangThaiNV, PB.maPB, PB.tenPB, CV.maCV,CV.tenCV");

        return sql.toString();
    }

    //lọc của quản lý
}
