package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.TamUngNhanVienDao;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TamUngNhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.util.ResourceBundle;

public class TamUngNhanVienController implements Initializable {

    @FXML
    private Button btnLayDuLieu;

    @FXML
    private Button btnTamUng;

    @FXML
    private ComboBox<PhongBan> cbxPhongBan;

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
        loadDuLieuBanDau();
    }

    //Load Du LieuBanDau
    private void loadDuLieuBanDau() {
        ObservableList<PhongBan> dsPhongBan = FXCollections.observableArrayList();
        dsPhongBan.addAll(TamUngNhanVienDao.getInstance().getAllPB());
        cbxPhongBan.setItems(dsPhongBan);
        cbxPhongBan.setConverter(new StringConverter<PhongBan>() {
            @Override
            public String toString(PhongBan phongBan) {
                return phongBan !=null ? phongBan.getTenPB() : "";
            }

            @Override
            public PhongBan fromString(String s) {
                int select = cbxPhongBan.getSelectionModel().getSelectedIndex();
                if (select >0 && select <dsPhongBan.size() )
                    return dsPhongBan.get(select);
                return null;
            }
        });
    }



}