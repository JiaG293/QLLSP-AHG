package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private BorderPane MainView;

    @FXML
    private Button btnCongNhan;

    @FXML
    private Button btnNhanVien;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void btnCongNhan(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/HopDong.fxml")));
        MainView.setCenter(view);
    }

    @FXML
    void btnNhanVien(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/SanPham.fxml")));
        MainView.setCenter(view);
    }
}
