package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.SanPhamDaoImpl;
import static com.openjfx.qllspahg.dao.interfaces.DSSanPham.DSSANPHAM;

import com.openjfx.qllspahg.database.Db;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SanPhamController implements Initializable {
    @FXML
    private Button btnXoaSP;

    @FXML
    private TableView<SanPham> sanPhamTableView;

    @FXML
    private TableColumn<SanPham, Integer> sttSPColumn;

    @FXML
    private TableColumn<SanPham, Double> giaSPColumn;

    @FXML
    private TableColumn<SanPham, String> maSPColumn;

    @FXML
    private TableColumn<SanPham, String> tenSPColumn;

    @FXML
    private TextField tfGiaSP;

    @FXML
    private TextField tfMaSP;

    @FXML
    private TextField tfTenSP;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taiDuLieuSanPham();
    }

    private void taiDuLieuSanPham() {
        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }

        DSSANPHAM.addAll(SanPhamDaoImpl.getInstance().getAllSanPham());
//        sttSPColumn.setCellValueFactory(DSSANPHAM.size());
        maSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, String>("maSP"));
        tenSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, String>("tenSP"));
        giaSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, Double>("giaSP"));
        sanPhamTableView.setItems(DSSANPHAM);
    }

    @FXML
    void xoaSanPham(ActionEvent event) {
        SanPham selected = sanPhamTableView.getSelectionModel().getSelectedItem();
        DSSANPHAM.remove(selected);

    }

//    @FXML
//    void CapNhatDSSanPham(ActionEvent event) {
//
//    }

    @FXML
    void lamMoiDSSanPham(ActionEvent event) {
        taiDuLieuSanPham();

    }

    @FXML
    void themSanPham(ActionEvent event) {
        String masp = tfMaSP.getText(); //dung tam chua them ham tu dong tao ma sp
        String tensp = tfTenSP.getText();
        double giasp = Double.parseDouble(tfGiaSP.getText());
        SanPham spMoi = new SanPham(masp, tensp, giasp);
        DSSANPHAM.add(spMoi);
    }



}
