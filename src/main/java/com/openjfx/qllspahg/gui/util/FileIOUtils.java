package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TaiKhoan;

import java.io.*;
import java.util.Properties;

public class FileIOUtils {
    public static void writeTaiKhoanToFile(TaiKhoan taiKhoan, String filePath) {
        Properties properties = convertTaiKhoanToProperties(taiKhoan);
        writePropertiesToFile(properties, filePath);
    }

    public static TaiKhoan readTaiKhoanFromFile(String filePath) {
        Properties properties = readPropertiesFromFile(filePath);
        return convertPropertiesToTaiKhoan(properties);
    }

    private static Properties convertTaiKhoanToProperties(TaiKhoan taiKhoan) {
        Properties properties = new Properties();
        properties.setProperty("maNV", taiKhoan.getMaTK().getMaNV());
        properties.setProperty("hoNV", taiKhoan.getMaTK().getHoNV());
        properties.setProperty("tenNV", taiKhoan.getMaTK().getTenNV());
        properties.setProperty("maPB", taiKhoan.getMaTK().getPhongBan().getMaPB());
        properties.setProperty("maCV", taiKhoan.getMaTK().getChucVuNV().getMaCV());
        properties.setProperty("tenPB", taiKhoan.getMaTK().getPhongBan().getTenPB());
        properties.setProperty("tenCV", taiKhoan.getMaTK().getChucVuNV().getTenCV());
        properties.setProperty("vaiTro", taiKhoan.getVaiTro());
        return properties;
    }

    private static TaiKhoan convertPropertiesToTaiKhoan(Properties properties) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setMaTK(new NhanVien(properties.getProperty("maNV"),
                properties.getProperty("tenNV"),
                properties.getProperty("hoNV"),
                new ChucVu(
                        properties.getProperty("maCV"),
                        properties.getProperty("tenCV")
                ),
                new PhongBan(
                        properties.getProperty("maPB"),
                        properties.getProperty("tenPB")
                )
        ));
        taiKhoan.setVaiTro(properties.getProperty("vaiTro"));
        return taiKhoan;
    }

    private static void writePropertiesToFile(Properties properties, String filePath) {
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            properties.store(outputStream, "userData.properties");
            System.out.println("TaiKhoan da duoc duoc luu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties readPropertiesFromFile(String filePath) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
