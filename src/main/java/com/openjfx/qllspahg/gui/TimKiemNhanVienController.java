package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.TimKiemNhanVienDao;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.PhongBan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class TimKiemNhanVienController implements Initializable {
    @FXML
    private Button btnTimKiem;

    @FXML
    private ComboBox<ChucVu> cbxChucVu;

    @FXML
    private ComboBox<PhongBan> cbxPhongBan;

    @FXML
    private TableColumn<?, ?> colChucVu;

    @FXML
    private TableColumn<?, ?> colHoVaTen;

    @FXML
    private TableColumn<?, ?> colLienLac;

    @FXML
    private TableColumn<?, ?> colMaNhanVien;

    @FXML
    private TableColumn<?, ?> colPhongBan;

    @FXML
    private TableColumn<?, ?> colSoNgayDiLam;

    @FXML
    private TableColumn<?, ?> colSoNgayNghiCoPhep;

    @FXML
    private TableColumn<?, ?> colSoNgayNghiKoPhep;

    @FXML
    private TableColumn<?, ?> colTrangThai;

    @FXML
    private TableView<?> tblViewTimKiem;

    @FXML
    private TextField tfMaNhanVie;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        layDuLieuVaoCombobox();
    }

    private void layDuLieuVaoCombobox(){
        ObservableList<PhongBan> dsPhongBan = FXCollections.observableArrayList();
        dsPhongBan.addAll(TimKiemNhanVienDao.getInstance().layTatCaPhongBan());
        cbxPhongBan.setItems(dsPhongBan);
        cbxPhongBan.setConverter(new StringConverter<PhongBan>() {
            @Override
            public String toString(PhongBan phongBan) {
                return phongBan != null ? phongBan.getTenPB() : "Rỗng";
            }

            @Override
            public PhongBan fromString(String s) {
                int select = cbxPhongBan.getSelectionModel().getSelectedIndex();
                if (select > 0 && select < dsPhongBan.size()){
                    return dsPhongBan.get(select);
                }
                return null;
            }
        });


        ObservableList<ChucVu> dsChucVu = FXCollections.observableArrayList();
        dsChucVu.addAll(TimKiemNhanVienDao.getInstance().layTatCaChucVu());
        cbxChucVu.setItems(dsChucVu);
        cbxChucVu.setConverter(new StringConverter<ChucVu>() {
            @Override
            public String toString(ChucVu chucVu) {
                return chucVu !=null ? chucVu.getTenCV() : "Rỗng";
            }

            @Override
            public ChucVu fromString(String s) {
                int select = cbxChucVu.getSelectionModel().getSelectedIndex();
                if (select >0 && select <dsChucVu.size()){
                    return dsChucVu.get(select);
                }
                return null;
            }
        });
    }

    @FXML
    void skbtnTimKiem(ActionEvent event) {

    }


}
