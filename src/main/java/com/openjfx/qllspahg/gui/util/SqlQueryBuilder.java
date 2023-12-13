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
            sqlBuilder.append("HD.ngayKKHD BETWEEN '").append(ngayBatDau).append("' AND '").append(ngayKetThuc);
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
        String sql = "";

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

    public static String TimKiemNhanVien(String truyVanTruocWhere, String maNhanVien, String maChucVu, String maphongBan) {
        StringBuilder sql = new StringBuilder().append(truyVanTruocWhere).append(" and ");

        if (maNhanVien != null)
            sql.append("NV.maNV LIKE '%").append(maNhanVien).append("%' and ");

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

    public static String TimKiemCongNhan(String truyVanTruocWhere, String maCongNhan, String maChucVu, String maToSanXuat) {
        StringBuilder sql = new StringBuilder().append(truyVanTruocWhere).append(" and ");

        if (maCongNhan != null)
            sql.append("CN.maCN LIKE '%").append(maCongNhan).append("%' and ");

        if (maChucVu != null)
            sql.append("CV.maCV = '").append(maChucVu).append("' and ");

        if (maToSanXuat != null)
            sql.append("TSX.maTSX = '").append(maToSanXuat).append("' and ");

        if (sql.toString().endsWith(" and "))
            sql.setLength(sql.length() - 5);
        sql.append("GROUP BY CN.email, CN.hoCN,CN.maCN,CN.sDT, CN.sTK, CN.tenCN, CN.trangThaiCN,\n" +
                "TSX.maTSX, TSX.tenTSX,CV.maCV,CV.tenCV ");

        return sql.toString();
    }

    //lọc của quản lý
}
