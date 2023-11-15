package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.NhanVien;
import javafx.collections.ObservableList;

public interface QuanLyTTNhanVienNhanVienDao {

    public ObservableList<NhanVien> getAllNhanVien();
    public ObservableList<NhanVien> getNhanVienTheoGT(String GT);
    public ObservableList<NhanVien> getNhanVienTheoCV(String CV);
    public ObservableList<NhanVien> getNhanVienTheoPB(String PB);
    public ObservableList<NhanVien> getNhanVienTheoGTvaCV(String GT, String CV);
    public ObservableList<NhanVien> getNhanVienTheoGTvaPB(String GT, String PB);
    public ObservableList<NhanVien> getNhanVienTheoCVvaPB(String CV, String PB);
    public ObservableList<NhanVien> getNhanVienTheoGTvaCVvaPB(String GT, String CV, String PB);
    public String getMaNhanVienLonNhat();
    public boolean saveDSNhanVienThem(ObservableList<NhanVien> dsNhanVienSave);
    public boolean saveDSNhanVienXoa(ObservableList<NhanVien> dsNhanVienXoa);
    public boolean svaeDSNhanVienSua(ObservableList<NhanVien> dsNhanVienSua);

}
