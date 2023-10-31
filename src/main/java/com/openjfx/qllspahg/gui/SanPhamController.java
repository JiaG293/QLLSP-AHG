package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.SanPhamDaoImpl;
import static com.openjfx.qllspahg.dao.interfaces.DSSanPham.DSSANPHAM;

import com.openjfx.qllspahg.dao.interfaces.DSSanPham;
import com.openjfx.qllspahg.entity.SanPham;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

public class SanPhamController implements Initializable {
    @FXML
    private TableView<SanPham> sanPhamTableView;

    @FXML
    private TableColumn<SanPham, Double> giaSPColumn;

    @FXML
    private TableColumn<SanPham, String> maSPColumn;

    @FXML
    private TableColumn<SanPham, String> tenSPColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taiDuLieuSanPham();

        maSPColumn.setCellValueFactory(new PropertyValueFactory<>("maSP"));
        tenSPColumn.setCellValueFactory(new PropertyValueFactory<>("tenSP"));
        giaSPColumn.setCellValueFactory(new PropertyValueFactory<>("giaSP"));
        sanPhamTableView.setItems(DSSANPHAM);



    }
    private void taiDuLieuSanPham() {

        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }
        DSSANPHAM.addAll(SanPhamDaoImpl.getInstance().getAllSanPham());
    }
}
