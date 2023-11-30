package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.dao.DanhSachHopDongImpl;
import com.openjfx.qllspahg.dao.QuanLySanPhamDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class UUIDUtils {
    public static String taoMaHopDong(ObservableList<String> danhSachMaHopDongDaCo) {

        Random random = new Random();
        String maHopDong;

        do {
            StringBuilder sb = new StringBuilder();
            sb.append("HD");

            // Tao ngau nhien 6 ki tu con lai
            for (int i = 0; i < 6; i++) {
//                sb.append((char) (random.nextInt(26) + 'A')); //Random ki tự
                sb.append(random.nextInt(10)); //Random 9 0-9
            }

            maHopDong = sb.toString();
        } while (danhSachMaHopDongDaCo.contains(maHopDong)); // kiem tra ma hop moi ton tai trong danh sach hay chua

        return maHopDong;
    }
    public static String taoMaSanPham() {
        Random random = new Random();
        String maSanPham = null;
        try {
            ObservableList<String> danhSachMaSanPhamDaCo = QuanLySanPhamDaoImpl.getInstance().layDanhSachMaSanPham();
            if(danhSachMaSanPhamDaCo != null)
            {
                do {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SP");

                    // Tao ngau nhien 4 ki tu con lai
                    for (int i = 0; i < 4; i++) {
//                sb.append((char) (random.nextInt(26) + 'A')); //Random ki tự
                        sb.append(random.nextInt(10)); //Random 9 0-9
                    }

                    maSanPham = sb.toString();
                } while (danhSachMaSanPhamDaCo.contains(maSanPham)); // kiem tra ma hop moi ton tai trong danh sach hay chua
            }
            else return null;


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return maSanPham;
    }

    public static String taoMaCongDoan(String maSanPham) {
        ObservableList<String> danhSachMaCongDoan = QuanLySanPhamDaoImpl.getInstance().layDanhSachMaCongDoanTheoSanPham(maSanPham);

        int soThuTuKyTuTang = 1;
        if (!danhSachMaCongDoan.isEmpty()) {
            String maCongDoanCuoi = danhSachMaCongDoan.get(danhSachMaCongDoan.size() - 1); //lay vi tri cuoi cua danh sach ma cong doan

            String soCuoiCung = maCongDoanCuoi.substring(maCongDoanCuoi.length() - 1); //Lay vi tri cuoi cung cua ma cong doan
            soThuTuKyTuTang = Integer.parseInt(soCuoiCung) + 1;
        }

        return "CD" + maSanPham + soThuTuKyTuTang;
    }

    public static String taoMaSanPhamTuMaCongDoan(String maCongDoan) {
        if (maCongDoan.startsWith("CD")) {
            try {
                //lay tu vi tri bat dau va ket thuc -- maSp co 6 ki tu nen la loai bo di cd va ki tu cuoi cung
                String maSP = maCongDoan.substring( 2, 8);

                // Tra ve ma san pham tu ma cong doan
                return maSP;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null; // tra ve null neu co van de
    }






}
