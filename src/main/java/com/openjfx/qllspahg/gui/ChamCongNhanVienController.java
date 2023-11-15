package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;

import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCCNHANVIEN;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSPHONGBAN;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class ChamCongNhanVienController implements Initializable {
    @FXML
    private TableColumn<BangChamCongNhanVien, String> colHoTenChamCongNV;

    @FXML
    private TableColumn<BangChamCongNhanVien, String> colMaChamCongNV;

    @FXML
    private TableColumn<BangChamCongNhanVien, String> colPhongBanChamCongNV;

    @FXML
    private TableView<BangChamCongNhanVien> tblviewChamCongNV;

    @FXML
    private BorderPane borderChamCongNhanVien;

    @FXML
    private TableColumn<BangChamCongNhanVien, String> colNgayChamCong;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckDiLam;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckNghiPhep;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckTangCa;

    @FXML
    private ComboBox<String> cbxLocPhongBan;

    @FXML
    private DatePicker datepickLocNgayChamCong;

    @FXML
    private TextField tfLocMaNV;

    @FXML
    private TextField tfLocTenNV;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        khoiTaoTableChamCongNhanVien();
        taiDuLieuNhanVien(ChamCongNhanVienDaoImpl.getInstance().LayDuLieuChamCongNhanVienNgayHienTai());
    }

    @FXML
    private void taiDuLieuChamCongNVNgayDuocChon(ActionEvent event) {
        LocalDate ndc = datepickLocNgayChamCong.getValue();
        System.out.println("Ngay duoc chon: " + ndc);
        try {
            ObservableList<BangChamCongNhanVien> listTemp = FXCollections.observableArrayList();
            listTemp.addAll(ChamCongNhanVienDaoImpl.getInstance().LayDuLieuChamCongNhanVienNgayTuyChon(Utils.DinhDangNgayHienTai(ndc, "yyyy-MM-dd")));
            if (listTemp.isEmpty()) {
                Alerts.showAlert("Cảnh báo", "Ngày chọn không phù hợp!!!", "Không có dữ liệu ngày được chọn!!!", Alert.AlertType.ERROR);
            } else {
                taiDuLieuNhanVien(listTemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void taiDuLieuChamCongNgayDuocChon() {

    }

    private void taiDuLieuComboBoxPhongBan() {
        cbxLocPhongBan.setPromptText("Chọn phòng ban");
        ObservableList<String> listPB= FXCollections.observableArrayList();
        listPB.add("Trống");
        listPB.addAll(ChamCongNhanVienDaoImpl.getInstance().LayDuLieuPhongBanNhanVien());
        cbxLocPhongBan.setItems(listPB);
    }

    public void khoiTaoTableChamCongNhanVien() {

        //Khoi tao du lieu combobox phong ban
        taiDuLieuComboBoxPhongBan();

        //Khoi tao ngay duoc chon
        datepickLocNgayChamCong.setValue(LocalDate.parse(Utils.TaoNgayHienTai()));
        colMaChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getMaNV());
            }
        });
        colHoTenChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getHoNV() + " " + nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getTenNV());
            }
        });
        colMaChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getMaNV());
            }
        });
        colPhongBanChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getPhongBan().getTenPB());
            }
        });
        colNgayChamCong.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDate(nhanVienStringCellDataFeatures.getValue().getNgayCC()));
            }
        });

        colCheckDiLam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean> nhanVienStringCellDataFeatures) {
                return new SimpleBooleanProperty(nhanVienStringCellDataFeatures.getValue().getDiLam());
            }
        });
        colCheckDiLam.setCellFactory(CheckBoxTableCell.forTableColumn(colCheckDiLam));

        colCheckNghiPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean> nhanVienStringCellDataFeatures) {
                return new SimpleBooleanProperty(nhanVienStringCellDataFeatures.getValue().getNghiPhep());
            }
        });
        colCheckNghiPhep.setCellFactory(CheckBoxTableCell.forTableColumn(colCheckNghiPhep));

        colCheckTangCa.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean> nhanVienStringCellDataFeatures) {
                return new SimpleBooleanProperty(nhanVienStringCellDataFeatures.getValue().getTangCa());
            }
        });
        colCheckTangCa.setCellFactory(CheckBoxTableCell.forTableColumn(colCheckTangCa));


    }

    private void taiDuLieuNhanVien(ObservableList<BangChamCongNhanVien> method) {
        if (!DSCCNHANVIEN.isEmpty()) {
            DSCCNHANVIEN.clear();
        }
        DSCCNHANVIEN.addAll(method);
        tblviewChamCongNV.setItems(DSCCNHANVIEN);
    }

    public void kiemTraNgayHienTai() {
    }

    /*public void LayDuLieuChamCongNhanVien() {
        if (!DSNHANVIEN.isEmpty()) {
            DSNHANVIEN.clear();
        }
        KhoiTaoTableChamCongNhanVien();
        DSNHANVIEN.addAll(ChamCongNhanVienDaoImpl.getInstance().LayDuLieuNhanVien());
        tblviewChamCongNV.setItems(DSNHANVIEN);
    }*/

    @FXML
    private void chonMotNhanVien(MouseEvent event) {
        /*BangChamCongNhanVien nvDuocChon = tblviewChamCongNV.getSelectionModel().getSelectedItem();
        System.out.println("nhan vien cham cong duoc chon:\n" + nvDuocCho);*/
    }

}
