package com.openjfx.qllspahg.gui.util;

public class SqlQueryBuilder {
    public static String stringQueryLocBangChamCongNhanVien(String cauTruyVanTruocWhere, String tenPB, String ngayChamCong, String hoTenNV, String maNV) {
        StringBuilder sqlBuilder = new StringBuilder().append(cauTruyVanTruocWhere).append(" WHERE ");

        if (tenPB != null) {
            sqlBuilder.append("PB.tenPB = N'").append(tenPB).append("' AND ");
        }

        if (ngayChamCong != null) {
            sqlBuilder.append("BCCNV.ngayChamCong = '").append(ngayChamCong).append("' AND ");
        }

        if (hoTenNV != null) {
            sqlBuilder.append("(NV.hoNV + ' ' + NV.tenNV) LIKE N'%").append(hoTenNV).append("%' AND ");
        }

        if (maNV != null) {
            sqlBuilder.append("NV.maNV = '").append(maNV).append("' AND ");
        }

        // Xoa an cuoi neu co
        if (sqlBuilder.toString().endsWith("AND ")) {
            sqlBuilder.setLength(sqlBuilder.length() - 4);
        }

        return sqlBuilder.toString();
    }

}
