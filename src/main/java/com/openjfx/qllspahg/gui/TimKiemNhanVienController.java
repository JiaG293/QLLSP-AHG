package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.TimKiemNhanVienDao;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.model.timKiemNhanVien.BangTimKiemNhanVien;
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

public class TimKiemNhanVienController implements Initializable {
    @FXML
    private Button btnTimKiem;

    @FXML
    private ComboBox<ChucVu> cbxChucVu;

    @FXML
    private ComboBox<PhongBan> cbxPhongBan;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colChucVu;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colHoVaTen;

    @FXML
    private TableColumn<BangTimKiemNhanVien , String> colLienLac;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colMaNhanVien;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colPhongBan;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colSoNgayDiLam;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colSoNgayNghiCoPhep;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colSoNgayNghiKoPhep;

    @FXML
    private TableColumn<BangTimKiemNhanVien, String> colTrangThai;

    @FXML
    private TableView<BangTimKiemNhanVien> tblViewTimKiem;

    @FXML
    private TextField tfMaNhanVie;
    private ObservableList<BangTimKiemNhanVien> dsBangTimKiem = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        layDuLieuVaoCombobox();
        docDULieuvaoTable();
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
    private void docDULieuvaoTable(){
        colChucVu.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getChucVuNV().getTenCV());
            }
        });

        colHoVaTen.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getHoNV() + " " +
                        bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getTenNV());
            }
        });

        colLienLac.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
                return new SimpleStringProperty("Email: "+bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getEmail()
                +"\nSDT: "+bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getsDT()
                        +"\nSTK: "+bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getsTK()
                );
            }
        });

       colMaNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
               return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getMaNV());
           }
       });

       colPhongBan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
               return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getNhanVien().getPhongBan().getTenPB());
           }
       });

      colSoNgayDiLam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
          @Override
          public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
              return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getSoNgayDiLam()+"");
          }
      });

         colSoNgayNghiCoPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
             @Override
             public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
                 return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getSoNgaynghiPhep()+"");
             }
         });

        colSoNgayNghiKoPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().getSoNgayNghiKoPhep()+"");
            }
        });
        colTrangThai.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTimKiemNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTimKiemNhanVien, String> bangTimKiemNhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(bangTimKiemNhanVienStringCellDataFeatures.getValue().isTrangThai() ?"Đã nghĩ" : "Đang làm");
            }
        });

        tblViewTimKiem.setItems(dsBangTimKiem);
    }

    @FXML
    void skbtnTimKiem(ActionEvent event) {
        dsBangTimKiem.clear();
        String maNhanVien = null;
        if (!tfMaNhanVie.getText().isEmpty()){
            maNhanVien = tfMaNhanVie.getText().trim();
        }
        String maPhongBan = null;
        if (!cbxPhongBan.getSelectionModel().isEmpty()){
            maPhongBan = cbxPhongBan.getSelectionModel().getSelectedItem().getMaPB();
        }
        String chucVu = null;
        if(!cbxChucVu.getSelectionModel().isEmpty()){
            chucVu = cbxChucVu.getSelectionModel().getSelectedItem().getMaCV();
        }
        tfMaNhanVie.setText("");
        cbxChucVu.getSelectionModel().clearSelection();
        cbxPhongBan.getSelectionModel().clearSelection();
        if (TimKiemNhanVienDao.getInstance().timKiemNhanVien(maNhanVien,chucVu,maPhongBan)== null){
            return;
        }
        dsBangTimKiem.addAll(TimKiemNhanVienDao.getInstance().timKiemNhanVien(maNhanVien,chucVu,maPhongBan));


    }


}
