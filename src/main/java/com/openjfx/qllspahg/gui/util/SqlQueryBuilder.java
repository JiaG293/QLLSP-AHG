package com.openjfx.qllspahg.gui.util;

public class SqlQueryBuilder {
    public static String stringQueryLocBangChamCongNhanVien(String cauTruyVanTruocWhere, String tenPB, String ngayChamCong, String hoTenNV, String maNV) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE ");

        if ( tenPB != null && !tenPB.equals("Trống")) {
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

        if ( trangThaiHopDong != null && !trangThaiHopDong.equals("Tất cả")) {
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


    /**Của Lộc
     *
     *
     */

    public static String stringQueryLocDanhSachTTCongNhan(String truyVanTruocWhere, String gt, String vaiTro, String toSanXuat){
        StringBuilder sql = new StringBuilder().append(truyVanTruocWhere).append(" and ");

        if(gt != null)
            sql.append("cn.gioiTinh = '").append(gt).append("' and ");

        if (vaiTro != null)
            sql.append("cv.tenCV = N'").append(vaiTro).append("' and ");

        if (toSanXuat != null)
            sql.append("tsx.tenTSX = N'").append(toSanXuat).append("' and ");

        if (sql.toString().endsWith(" and "))
            sql.setLength(sql.length() - 5);

        return sql.toString();
    }
}
