package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManHinhChinhTestController implements Initializable {
    @FXML
    private BorderPane guiChinh;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //CongNhan
    @FXML
    void ChangeSceneQuanLyCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/QuanLyCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeScenePhanCongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/PhanCongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneChamCongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/ChamCongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneQuanLyToSanXuat(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/QuanLyToSanXuat.fxml")));
        guiChinh.setCenter(view);
    }
    @FXML
    void ChangeSceneTamUngCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/TamUngCongNhan.fxml")));
        guiChinh.setCenter(view);
    }
    @FXML
    void ChangeSceneTimKiemCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/TimKiemCongNhan.fxml")));
        guiChinh.setCenter(view);
    }
    @FXML
    void ChangeSceneTinhLuongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/TinhLuongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    //HopDong
    @FXML
    void ChangeSceneDanhSachHopDong(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/HopDong/DanhSachHopDong.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneThongKeHopDong(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/HopDong/ThongKeHopDong.fxml")));
        guiChinh.setCenter(view);
    }
    @FXML
    void ChangeSceneTimKiemHopDong(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/HopDong/TimKiemHopDong.fxml")));
        guiChinh.setCenter(view);
    }


    //NhanVien
    @FXML
    void ChangeSceneQuanLyNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/QuanLyNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneChamCongNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/ChamCongNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneQuanLyPhongBan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/QuanLyPhongBan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTamUngNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/TamUngNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneThongKeNhanVien(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/ThongKeNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTimKiemNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/TimKiemNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTinhLuongNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/TinhLuongNhanVien.fxml")));
        guiChinh.setCenter(view);
    }


    //SanPham
    @FXML
    void ChangeSceneQuanLySanPham(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/SanPham/QuanLySanPham.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneThongKeSanPham(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/SanPham/ThongKeSanPham.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTimKiemSanPham(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/SanPham/TimKiemSanPham.fxml")));
        guiChinh.setCenter(view);
    }


    //ThongKe
    /*@FXML
    void ChangeSceneThongKe(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/ThongKe.fxml")));
        guiChinh.setCenter(view);
    }*/
}
