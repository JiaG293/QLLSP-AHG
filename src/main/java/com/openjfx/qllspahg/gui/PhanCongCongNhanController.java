package com.openjfx.qllspahg.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PhanCongCongNhanController {

    @FXML
    private Button btnLuuPCCN;

    @FXML
    private Button btnPhanCongPCCN;

    @FXML
    private Button btnResetPCCN;

    @FXML
    private Button btnSuaPCCN;

    @FXML
    private ComboBox<?> cbxCongDoanPCCN;

    @FXML
    private ComboBox<?> cbxHopDongPCCN;

    @FXML
    private ComboBox<?> cbxSanPhanPCCN;

    @FXML
    private ComboBox<?> cbxToPCCN;

    @FXML
    private TableColumn<?, ?> colHoVaTenCongNhanPCCN;

    @FXML
    private TableColumn<?, ?> colHovaTenMoiCNPCCN;

    @FXML
    private TableColumn<?, ?> colMaCongNhanPCCN;

    @FXML
    private TableColumn<?, ?> colMaPhanCongMoiCNPCCN;

    @FXML
    private TableColumn<?, ?> colNgayPhanCongMoiCNPCCN;

    @FXML
    private TableColumn<?, ?> colSTTCongNhanPCCN;

    @FXML
    private TableColumn<?, ?> colSoLuongLamMoiCNPCCN;

    @FXML
    private DatePicker datepickNgayPhanCongPCCN;

    @FXML
    private RadioButton radPCTuDongPCCN;

    @FXML
    private RadioButton radPCTungCongNhanPCCN;

    @FXML
    private TableView<?> tblViewTTCongNhanPC;

    @FXML
    private TableView<?> tblViewTTPhanCongMoiCNPCCN;

    @FXML
    private TextField tfHoVaTenPCCN;

    @FXML
    private TextField tfMaCongNhanPCCN;

    @FXML
    private TextField tfSoLuongCanLamPCCN;

    @FXML
    private TextField tfSoLuongCanPhanCongPCCN;

    @FXML
    private TextField tfSoLuongChuaPhanCongPCCN;

    @FXML
    private TextField tfSoLuongMoiNGuoiPCCN;

    @FXML
    private TextField tfSoLuongPhanCongPCCN;

    @FXML
    private TextField tfSoNguoiCanPhanCongPCCN;

    @FXML
    private TextField tfToPCCN;

    @FXML
    private TextField tfTongSoLuongPhanCongPCCN;

}
