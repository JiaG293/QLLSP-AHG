package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.dao.DanhSachHopDongImpl;
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
}
