package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.Main;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.ControlFlow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DangNhapController implements Initializable {
    @FXML
    private AnchorPane DangNhap;

    @FXML
    private Button btnDangNhap;

    @FXML
    private CheckBox cboxGhiNho;

    @FXML
    private TextField tfMaNhanSu;

    @FXML
    private PasswordField tfMatKhau;

    private String testUser = "test";
    private String testPwd = "test";
    @FXML
    void xuLiDangNhap(ActionEvent event) throws IOException {
        String username = tfMaNhanSu.getText().trim();
        String password = tfMatKhau.getText().trim();

        if(tfMaNhanSu.getText().isEmpty()) {
            Alerts.showAlert("Lỗi!", "Không được để trống!","Vui lòng nhập mã nhân sự!", Alert.AlertType.ERROR);
            return;
        }
        if(tfMatKhau.getText().isEmpty()) {
            Alerts.showAlert("Lỗi!", "Không được để trống!","Vui lòng nhập mật khẩu!", Alert.AlertType.ERROR);
            return;
        }

        if(testUser.equals(username) && testPwd.equals(password)){
            ControlFlow.switchViews(event, "/com/openjfx/qllspahg/fxml/ManHinhChinhTest.fxml", "Màn Hình Chính");
        } else{
            Alerts.showConfirmation("Vui lòng nhập lại!", "Mã nhân sự hoặc mật khẩu không chính xác!");
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
