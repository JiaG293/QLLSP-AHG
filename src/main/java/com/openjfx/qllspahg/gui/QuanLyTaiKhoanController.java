package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.QuanLyTaiKhoanDaoImpl;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.TaiKhoan;
import com.openjfx.qllspahg.gui.util.Alerts;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;

public class QuanLyTaiKhoanController implements Initializable {
    @FXML
    private ComboBox<String> cbxLocTrangThai;

    @FXML
    private ComboBox<String> cbxTrangThai;

    @FXML
    private ComboBox<String> cbxVaiTro;

    @FXML
    private TableColumn<TaiKhoan, String> colMaTK;

    @FXML
    private TableColumn<TaiKhoan, String> colMatKhau;

    @FXML
    private TableColumn<TaiKhoan, Integer> colSTT;

    @FXML
    private TableColumn<TaiKhoan, String> colTrangThai;

    @FXML
    private TableColumn<TaiKhoan, String> colVaiTro;

    @FXML
    private TableView<TaiKhoan> tblTaiKhoan;

    @FXML
    private TextField tfLocMaTK;

    @FXML
    private TextField tfMaTK;

    @FXML
    private TextField tfMatKhau;

    @FXML
    void capNhatTaiKhoan(ActionEvent event) {
        String maTK = tfMaTK.getText();
        String matKhau = tfMatKhau.getText();
        String trangThai = cbxTrangThai.getValue();
        String vaiTro = cbxVaiTro.getValue();;
        boolean vt = true;

        if(!maTK.isEmpty() && !matKhau.isEmpty() && !trangThai.isEmpty() ){
            if(vaiTro.equals("Đang hoạt động")){
                vt = true;
            } else {
                vt = false;
            }
            NhanVien nv = new NhanVien(maTK);
            TaiKhoan tk = new TaiKhoan(nv, matKhau, vaiTro, vt);
            boolean flag = QuanLyTaiKhoanDaoImpl.getInstance().capNhatTaiKhoan(tk);
            if(flag){
                Alerts.showAlert("Thông báo", "Thành công", "Tài khoản được cập nhật", Alert.AlertType.INFORMATION);
            } else {
                Alerts.showAlert("Thông báo", "Thất bại", "Tài khoản gặp lỗi trong quá trình cập nhật", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void chonMotTaiKhoan(MouseEvent event) {
        TaiKhoan tkDuocChon = tblTaiKhoan.getSelectionModel().getSelectedItem();
        if(tkDuocChon != null){
            tfMaTK.setText(tkDuocChon.getMaTK().getMaNV());
            tfMatKhau.setText(tkDuocChon.getMatKhau());
            cbxTrangThai.setValue(tkDuocChon.getTrangThaiTK() ? "Đang hoạt động" : "Không hoạt động");
            cbxVaiTro.setValue(tkDuocChon.getVaiTro());;
        }

    }

    @FXML
    void kiemTraTaiKhoan(ActionEvent event) {
        String maTK = tfMaTK.getText();
        if (maTK != null && !maTK.isEmpty()) {
            if (QuanLyTaiKhoanDaoImpl.getInstance().kiemTraTaiKhoanTonTai(maTK)) {
                tfMaTK.clear();
                Alerts.showAlert("Thông báo", "Tồn tại", "Chỉ được đổi trạng thái hoạt động", Alert.AlertType.INFORMATION);
                TaiKhoan tk = QuanLyTaiKhoanDaoImpl.getInstance().layTaiKhoanTonTai(maTK);
                tfMaTK.setText(tk.getMaTK().getMaNV());
                tfMatKhau.setText(tk.getMatKhau());
                cbxTrangThai.setValue(tk.getTrangThaiTK() ? "Đang hoạt động" : "Không hoạt động");
                cbxVaiTro.setValue(tk.getVaiTro());
            }
        }
    }

    @FXML
    void layDuLieuLoc(ActionEvent event) {
        DSTAIKHOAN.clear();

        //get gia tri tung truong
        String maTK = tfLocMaTK.getText();
        String trangThai = cbxLocTrangThai.getValue();

        if(trangThai.equals("Đang hoạt động")){
            trangThai = "1";
        }else {
            trangThai = "0";
        }

        ObservableList<TaiKhoan> listTK = FXCollections.observableArrayList();
        listTK.addAll(QuanLyTaiKhoanDaoImpl.getInstance().layDuLieuLocTaiKhoan(maTK, trangThai));
        if (listTK.isEmpty()) {
            Alerts.showAlert("Thông báo", "Không có dữ liệu", "Dữ liệu tìm kiếm không tìm thấy", Alert.AlertType.INFORMATION);
        } else {
            khoiTaoComboBoxTrangThai();
            khoiTaoComboBoxVaiTro();
            taiDuLieuTaiKhoan(listTK);


        }
    }

    private void taiDuLieuTaiKhoan(ObservableList<TaiKhoan> listTK) {
        if (!DSTAIKHOAN.isEmpty()) {
            DSTAIKHOAN.clear();
        }
        DSTAIKHOAN.addAll(listTK);

        tblTaiKhoan.setItems(DSTAIKHOAN);
        System.out.println(DSTAIKHOAN.toString());

    }

    @FXML
    void taoTaiKhoan(ActionEvent event) {
        String maTK = tfMaTK.getText();
        String matKhau = tfMatKhau.getText();
        String trangThai = cbxTrangThai.getValue();
        String vaiTro = cbxVaiTro.getValue();;
        boolean vt = true;

        if(!maTK.isEmpty() && !matKhau.isEmpty() && !trangThai.isEmpty() ){
            if(vaiTro.equals("Đang hoạt động")){
                vt = true;
            } else {
                vt = false;
            }
            NhanVien nv = new NhanVien(maTK);
            TaiKhoan tk = new TaiKhoan(nv, matKhau, trangThai, vt);
            if(QuanLyTaiKhoanDaoImpl.getInstance().taoTaiKhoanNhanVien(tk)){
                Alerts.showAlert("Thông báo", "Thành công", "Tài khoản được tạo", Alert.AlertType.INFORMATION);
            } else {
                Alerts.showAlert("Thông báo", "Thất bại", "Tài khoản gặp lỗi trong quá trình tạo", Alert.AlertType.ERROR);
            }
        }


    }

    @FXML
    void xemMatKhau(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableTaiKhoan();
    }


    private void khoiTaoComboBoxTrangThai() {
        cbxTrangThai.setPromptText("Chọn trạng thái");
        ObservableList<String> listVaiTro = FXCollections.observableArrayList();
        listVaiTro.clear();
        listVaiTro.addAll("Đang hoạt động", "Không hoạt động");
        cbxTrangThai.setItems(listVaiTro);
    }

    private void khoiTaoComboBoxLocTrangThai() {
        cbxLocTrangThai.setPromptText("Chọn trạng thái");
        ObservableList<String> listVaiTro = FXCollections.observableArrayList();
        listVaiTro.addAll("Đang hoạt động", "Không hoạt động");
        cbxLocTrangThai.setItems(listVaiTro);
        cbxLocTrangThai.setValue("Đang hoạt động");
    }

    private void khoiTaoComboBoxVaiTro() {
        cbxVaiTro.setPromptText("Chọn vai trò");
        ObservableList<String> listVaiTro = FXCollections.observableArrayList();
        listVaiTro.clear();
        listVaiTro.addAll("Quản lý hành chính", "Quản lý sản xuất", "Kế toán", "Nhân viên hành chính");
        cbxVaiTro.setItems(listVaiTro);
    }

    private void khoiTaoTableTaiKhoan() {
        khoiTaoComboBoxTrangThai();
        khoiTaoComboBoxVaiTro();
        khoiTaoComboBoxLocTrangThai();



        colSTT.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });

        colMaTK.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TaiKhoan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TaiKhoan, String> TaiKhoanStringCellDataFeatures) {
                return new SimpleStringProperty(TaiKhoanStringCellDataFeatures.getValue().getMaTK().getMaNV());
            }
        });

        colMatKhau.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TaiKhoan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TaiKhoan, String> TaiKhoanStringCellDataFeatures) {
                return new SimpleStringProperty(TaiKhoanStringCellDataFeatures.getValue().getMatKhau());
            }
        });

        colVaiTro.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TaiKhoan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TaiKhoan, String> TaiKhoanStringCellDataFeatures) {
                return new SimpleStringProperty(TaiKhoanStringCellDataFeatures.getValue().getVaiTro());
            }
        });

        colTrangThai.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TaiKhoan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TaiKhoan, String> TaiKhoanStringCellDataFeatures) {
                return new SimpleStringProperty(TaiKhoanStringCellDataFeatures.getValue().getTrangThaiTK() ? "Đang hoạt động" : "Không hoạt động");
            }
        });
    }
}
