package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.DangNhapDaoImpl;
import com.openjfx.qllspahg.entity.TaiKhoan;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.ControlFlow;
import com.openjfx.qllspahg.gui.util.FileIOUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
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

    private String testUser = "NV100000";
    private String testPwd = "123456";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfMaNhanSu.setText(testUser);
        tfMatKhau.setText(testPwd);
    }

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

        if(DangNhapDaoImpl.getInstance().kiemTraDangNhap(username, password)){
            FileIOUtils.writeTaiKhoanToFile(DangNhapDaoImpl.getInstance().layThongTinTaiKhoan(username), "userData.properties");
            ControlFlow.switchViewsSetSize(event, "/com/openjfx/qllspahg/fxml/ManHinhChinh.fxml", "Quản lý lương AHG", 1200, 700);
        } else{
            Alerts.showConfirmation("Vui lòng nhập lại!", "Mã nhân sự hoặc mật khẩu không chính xác!");
        }


    }




}
