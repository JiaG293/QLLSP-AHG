package com.openjfx.qllspahg.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Formatter;
import java.util.ResourceBundle;

public class TamUngNhanVienController implements Initializable {

    @FXML
    private Button btnHuyXem;

    @FXML
    private Button btnLayThongTin;

    @FXML
    private Button btnUngLuong;

    @FXML
    private TableColumn<?, ?> colGhiChu;

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
    private Label lblTieuDeNgayTamUng;

    @FXML
    private TableView<?> tblviewTamUngNhanVien;

    @FXML
    private TextField tfMaNhanVien;

    @FXML
    private TextField tfMaTamUng;

    @FXML
    private TextField tfNgayTamUng;

    @FXML
    private TextField tfPhongBan;

    @FXML
    private TextField tfSoNgayDiLam;

    @FXML
    private TextField tfSoNgayTamUng;

    @FXML
    private TextField tfTenNhanVien;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTieuDeNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));

        System.out.println(LocalDate.now().getMonth().getValue());
        System.out.println(LocalDate.now().getYear());


    }



    /**
     *
     * Sự kiện
     */


    // Sự kiện trne6 button
    public void skbtnLayThongTin(ActionEvent actionEvent) {
    }
}



