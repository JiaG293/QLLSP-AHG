package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.entity.TamUngNhanVien;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.util.ResourceBundle;

public class TamUngNhanVienController implements Initializable {

    @FXML
    private Button btnLayDuLieu;

    @FXML
    private Button btnTamUng;

    @FXML
    private ComboBox<?> cbxPhongBan;

    @FXML
    private TableColumn<TamUngNhanVien, ?> colGhiChu;

    @FXML
    private TableColumn<?, ?> colMaNhanVien;

    @FXML
    private TableColumn<?, ?> colNgayTamUng;

    @FXML
    private TableColumn<?, ?> colPhpngBan;

    @FXML
    private TableColumn<?, ?> colSoNgayDaDiLam;

    @FXML
    private TableColumn<?, ?> colSoTienTazmUng;

    @FXML
    private TableColumn<?, ?> colTenNhanVien;

    @FXML
    private TableView<?> tblviewTamUngNhanVien;

    @FXML
    private TextField tfMaNhanVien;

    @FXML
    private TextField tfTenNhanVien;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}