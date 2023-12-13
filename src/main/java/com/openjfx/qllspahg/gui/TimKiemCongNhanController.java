package com.openjfx.qllspahg.gui;
import com.openjfx.qllspahg.dao.TimKiemCongNhanDao;
import com.openjfx.qllspahg.dao.TimKiemNhanVienDao;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.ToSanXuat;
import com.openjfx.qllspahg.entity.model.bangTimKiemCongNhan.BangTimKiemCongNhan;
import com.openjfx.qllspahg.gui.util.Alerts;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class TimKiemCongNhanController implements Initializable {
    @FXML
    private Button btnTimKiem;

    @FXML
    private ComboBox<ToSanXuat> cbxToSanXuat;

    @FXML
    private ComboBox<ChucVu> cbxVaTro;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colHoVaTen;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colMaCongNhan;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colSoNgayNghiCoPhep;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colSoNgayNghiKoPhep;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colThongTinDiLam;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colThongTinLienLac;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colToSanXuat;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colTrangThai;

    @FXML
    private TableColumn<BangTimKiemCongNhan, String> colVaiTro;

    @FXML
    private TableView<BangTimKiemCongNhan> tblViewTimKiem;

    @FXML
    private TextField tfMaCongNhan;
    private ObservableList<BangTimKiemCongNhan> dsCongNhan = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        docDuLieuVaoComBoBox();
        docDuLieuVaoTable();
    }
    private void docDuLieuVaoComBoBox(){
        ObservableList<ToSanXuat> dsToSanXuat = FXCollections.observableArrayList();
        dsToSanXuat.addAll(TimKiemCongNhanDao.getInstance().layTatCaToSanXuat());
        cbxToSanXuat.setItems(dsToSanXuat);
        cbxToSanXuat.setConverter(new StringConverter<ToSanXuat>() {
            @Override
            public String toString(ToSanXuat toSanXuat) {
                return toSanXuat != null ? toSanXuat.getTenTSX() : "rỗng" ;
            }

            @Override
            public ToSanXuat fromString(String s) {
                int select = cbxToSanXuat.getSelectionModel().getSelectedIndex();
                if (select > 0 && select < dsToSanXuat.size()){
                    return dsToSanXuat.get(select);
                }
                return null;
            }
        });


        ObservableList<ChucVu> dsVaiTro = FXCollections.observableArrayList();
        dsVaiTro.addAll(TimKiemCongNhanDao.getInstance().layTatCaVaiTroCongNhan());
        cbxVaTro.setItems(dsVaiTro);
        cbxVaTro.setConverter(new StringConverter<ChucVu>() {
            @Override
            public String toString(ChucVu chucVu) {
                return chucVu !=null ? chucVu.getTenCV() : "Rỗng";
            }

            @Override
            public ChucVu fromString(String s) {
                int select = cbxVaTro.getSelectionModel().getSelectedIndex();
                if( select >0 && select < dsVaiTro.size()){
                    return dsVaiTro.get(select);
                }
                return null;
            }
        });
    }
    private void docDuLieuVaoTable(){
        colHoVaTen.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getHoCN()+ " "+
                        bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getTenCN());
            }
        });

        colMaCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getMaCN());
            }
        });

        colSoNgayNghiCoPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().getSoNgaynghiPhep()+"");
            }
        });

        colSoNgayNghiKoPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().getSoNgayNghiKoPhep()+"");
            }
        });

        colThongTinDiLam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty("Đi lảm: " +bangTimKiemCongNhanStringCellDataFeatures.getValue().getSoNgayDiLam()
                +"\nSố CD được phân công: "+ bangTimKiemCongNhanStringCellDataFeatures.getValue().getSoLuongDuocPhanCong()+
                        "\nSố CD đã làm: "+ bangTimKiemCongNhanStringCellDataFeatures.getValue().getSoLuongDaLam());
            }
        });

        colThongTinLienLac.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty("Enail: "+ bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getEmail()+
                        "\nSDT: "+bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getsDT()+
                        "\nSTK: "+bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getsTK());
            }
        });

        colToSanXuat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getToSanXuat().getTenTSX());
            }
        });

        colTrangThai.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().isTrangThai() == true ? "Đã nghỉ":"Đang làm");
            }
        });

        colVaiTro.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemCongNhan, String> bangTimKiemCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemCongNhanStringCellDataFeatures.getValue().getCongNhan().getChucVuCN().getTenCV());
            }
        });
        tblViewTimKiem.setItems(dsCongNhan);
    }

    @FXML
    void skbtnTimKiem(ActionEvent event) {
        dsCongNhan.clear();
        String maCN = null;
        if (!tfMaCongNhan.getText().trim().isEmpty())
            maCN = tfMaCongNhan.getText().trim();

        String maChucVu = null;
        if (!cbxVaTro.getSelectionModel().isEmpty())
            maChucVu =cbxVaTro.getSelectionModel().getSelectedItem().getMaCV();

        String maTSX = null;
        if (!cbxToSanXuat.getSelectionModel().isEmpty())
            maTSX = cbxToSanXuat.getSelectionModel().getSelectedItem().getMaTSX();

        tfMaCongNhan.setText("");
        cbxVaTro.getSelectionModel().clearSelection();
        cbxToSanXuat.getSelectionModel().clearSelection();

        if (TimKiemCongNhanDao.getInstance().TimKiemThongTinCOngNhan(maCN,maChucVu,maTSX) == null){
            Alerts.showConfirmation("Thông báo","Không tìm thấy");
            return;
        }
        dsCongNhan.addAll(TimKiemCongNhanDao.getInstance().TimKiemThongTinCOngNhan(maCN,maChucVu,maTSX) );

    }


}
