package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;

import com.openjfx.qllspahg.dao.interfaces.DSDao;
import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.gui.util.CheckCell;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCCNHANVIEN;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSNHANVIEN;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ChamCongNhanVienController implements Initializable {
    @FXML
    private TableColumn<?, ?> colHoTenChamCongNV;

    @FXML
    private TableColumn<?, ?> colMaChamCongNV;

    @FXML
    private TableColumn<NhanVien, String> colPhongBanChamCongNV;

    @FXML
    private TableView<NhanVien> tblviewChamCongNV;


    @FXML
    private BorderPane borderChamCongNhanVien;

    @FXML
    private TableColumn<BangChamCongNhanVien, Date> colNgayChamCong;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckDiLam;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckNghiPhep;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckTangCa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chamCongNhanVien();

    }

    public void tabChamCongNhanVien() {


        colMaChamCongNV.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        colHoTenChamCongNV.setCellValueFactory(new PropertyValueFactory<>("hoNV"));
        colPhongBanChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getPhongBan().getTenPB());
            }
        });
        colNgayChamCong.setCellValueFactory(new PropertyValueFactory<>("ngayCC"));

        colCheckDiLam.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> param) {
                return new CheckCell();
            }
        });

        colCheckNghiPhep.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> param) {
                return new CheckCell();
            }
        });
        colCheckTangCa.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> param) {
                return new CheckCell();
            }
        });


    }


    public void chamCongNhanVien() {
        if (!DSNHANVIEN.isEmpty()) {
            DSNHANVIEN.clear();
        }
        tabChamCongNhanVien();
        DSNHANVIEN.addAll(ChamCongNhanVienDaoImpl.getInstance().LayDuLieuNhanVien());
        tblviewChamCongNV.setItems(DSNHANVIEN);
    }

    @FXML
    void chonMotNhanVien(MouseEvent event) {
        NhanVien nvDuocChon = tblviewChamCongNV.getSelectionModel().getSelectedItem();
        System.out.println("nhan vien duoc chon:\n" + nvDuocChon.toStringChamCongNhanVien());

//        System.out.println(ChamCongNhanVienDaoImpl.getInstance().TaoBangChamCongNhanVien(ChamCongNhanVienDaoImpl.getInstance().LayDuLieuNhanVien()));
    }

}
