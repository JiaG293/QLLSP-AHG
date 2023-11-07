package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.SanPham;
import javafx.collections.ObservableList;

public interface SanPhamDao<SanPham> {
    public void themSP(SanPham sạnPham);

    public void xoaSP(SanPham sanPham);

    public void suaSP(SanPham sanPham);
    public ObservableList<SanPham> layTatCaSP();

    public SanPham laySPBangMa(String maSanPham);

    public SanPham laySPBangTen(String tenSanPham);

    public ObservableList<SanPham> timSPBangMa(String maSanPham);

    public ObservableList<SanPham> timSPBangTen(String tenSanPham);



}
