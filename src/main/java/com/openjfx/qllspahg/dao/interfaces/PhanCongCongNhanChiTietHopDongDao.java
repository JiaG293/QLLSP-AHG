package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.ChiTietHopDong;
import javafx.collections.ObservableList;

public interface PhanCongCongNhanChiTietHopDongDao {
   public ObservableList<ChiTietHopDong> getAllChiTietHopDong (String maHD);
}
