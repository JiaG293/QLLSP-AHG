package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.QuanLyTTCongNhanDao;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.ToSanXuat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinCongNhan.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class QuanLyCongNhanController implements Initializable {
    @FXML
    private Button btnLamMoiTTCongNhan;

    @FXML
    private Button btnLayDuLieuTTCongNhan;

    @FXML
    private Button btnLuuTTCongNhan;

    @FXML
    private Button btnResetTTCongNhan;

    @FXML
    private Button btnSuaTTCongNhan;

    @FXML
    private Button btnThemTTCongNhan;

    @FXML
    private Button btnXoaTTCongNhan;

    @FXML
    private ComboBox<String> cbxLoadGioiTinhTTCongNhan;

    @FXML
    private ComboBox<String> cbxLoadToSanXuatTTCongNhan;

    @FXML
    private ComboBox<String> cbxLoadVaiTroTTCongNhan;

    @FXML
    private ComboBox<String> cbxVaiTroTTCongNhan;

    @FXML
    private CheckBox ckGioiTinhTTCongNhan;

    @FXML
    private TableColumn<?, ?> colChucVuChiTietTTCongNhan;

    @FXML
    private TableColumn<?, ?> colChucVuTTCongNhan;

    @FXML
    private TableColumn<?, ?> colEmailChiTietTTCongNhan;

    @FXML
    private TableColumn<?, ?> colGioiTinhTTChiTietCongNhan;

    @FXML
    private TableColumn<?, ?> colGioiTinhTTCongNhan;

    @FXML
    private TableColumn<?, ?> colHoTTCongNhan;

    @FXML
    private TableColumn<?, ?> colHovaTenChiTietTTCongNhan;

    @FXML
    private TableColumn<?, ?> colMaChiTietTTCongNhan;

    @FXML
    private TableColumn<?, ?> colMaTTCongNhan;

    @FXML
    private TableColumn<?, ?> colNgaySinhTTChiTietCongNhan;

    @FXML
    private TableColumn<?, ?> colNgayVaoLamTTChiTietCongNha;

    @FXML
    private TableColumn<?, ?> colPhuCapChiTietTTCongNhan;

    @FXML
    private TableColumn<?, ?> colSoDienThoaiChiTieTTTCongNhan;

    @FXML
    private TableColumn<?, ?> colSoTaiKhoanChiTietTTCongNhan;

    @FXML
    private TableColumn<?, ?> colTenTTCongNhan;

    @FXML
    private TableColumn<?, ?> colToSanXuatTTChiTietCongNhan;

    @FXML
    private TableColumn<?, ?> colToSanXuatTTCongNhan;

    @FXML
    private DatePicker datepickNgaySinhTTCongNhan;

    @FXML
    private DatePicker datepickNgayVaoLamTTCongNhan;

    @FXML
    private TableView<?> tblViewChiTietTTCongNhan;

    @FXML
    private TableView<?> tblViewTTCongNhan;

    @FXML
    private TextField tfEmailTTCongNhan;

    @FXML
    private TextField tfMaSoTTCongNhan;

    @FXML
    private ComboBox<?> tfPhuCapTTCongNhan;

    @FXML
    private TextField tfSoDienThoaiTTCongNhan;

    @FXML
    private TextField tfSoTaiKhoanTTCongNhan;

    @FXML
    private TextField tfTenTTCongNhan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepickNgayVaoLamTTCongNhan.setValue(LocalDate.now());
        loadcbxGioiTinhCongNhan();
        loadcbxToSanXuat();
        loadVaiTroCongNhan();

    }

    private void loadcbxGioiTinhCongNhan(){
        ObservableList<String> dsGT = FXCollections.observableArrayList("Nam","Nữ");
        cbxLoadGioiTinhTTCongNhan.setItems(dsGT);
    }
    private void loadcbxToSanXuat(){
        DSToSanXuat.addAll(QuanLyTTCongNhanDao.getInstance().getAllToSanXuat());
        ObservableList<String> dsToString = FXCollections.observableArrayList();
        for (ToSanXuat to : DSToSanXuat)
            dsToString.add(to.getTenTSX());

        cbxLoadToSanXuatTTCongNhan.setItems(dsToString);
    }
    private void loadVaiTroCongNhan(){
        DSChucVu.addAll(QuanLyTTCongNhanDao.getInstance().getAllChucVuCongNhan());
        ObservableList<String> dsTenChucVuString = FXCollections.observableArrayList();
        for (ChucVu cv : DSChucVu)
            dsTenChucVuString.add(cv.getTenCV());

        cbxLoadVaiTroTTCongNhan.setItems(dsTenChucVuString);
    }
}
