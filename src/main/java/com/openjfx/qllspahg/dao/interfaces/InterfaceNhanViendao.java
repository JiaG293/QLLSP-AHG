package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.NhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface InterfaceNhanViendao {
    //Khoi tao
    public ObservableList<NhanVien> DSNhanVien = FXCollections.observableArrayList();
    public ObservableList<NhanVien> getAllNhanVien();
    public ObservableList<NhanVien> getNhanVienTheoGT(String GT);
    public ObservableList<NhanVien> getNhanVienTheoCV(String CV);
    public ObservableList<NhanVien> getNhanVienTheoPB(String PB);
    public ObservableList<NhanVien> getNhanVienTheoGTvaCV(String GT, String CV);
    public ObservableList<NhanVien> getNhanVienTheoGTvaPB(String GT, String PB);
    public ObservableList<NhanVien> getNhanVienTheoCVvaPB(String CV, String PB);
    public ObservableList<NhanVien> getNhanVienTheoGTvaCVvaPB(String GT, String CV, String PB);

}
