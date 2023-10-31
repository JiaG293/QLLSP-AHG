package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.ObservableList;

public interface SanPhamDao<T> {
    public ObservableList<SanPham> getAllSanPham();

    public SanPham getSanPhamBangMa(String maSanPham);

    public SanPham getSanPhamBangTen(String tenSanPham);

    public void saveSanPham(SanPham sạnPham);

    public void updateSanPham(SanPham sanPham);

    public void deleteProduct(SanPham sanPham);

    public ObservableList<String> getTenSanPham();

}
