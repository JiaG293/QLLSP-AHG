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

    @FXML
    void ChangeSceneCongNhan(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneHopDong(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/HopDong.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneNhanVien(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneSanPham(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/SanPham.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneThongKe(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/ThongKe.fxml")));
        guiChinh.setCenter(view);
    }
}
