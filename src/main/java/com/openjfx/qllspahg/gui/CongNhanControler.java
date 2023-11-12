package com.openjfx.qllspahg.gui;

import static com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan.DSMaHopDong;
import static com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan.DSChiTietHopDong;

import com.openjfx.qllspahg.dao.PhanCongCongNhanChiTietHDDaoimpl;
import com.openjfx.qllspahg.dao.PhanCongCongNhanHopDongimpl;
import com.openjfx.qllspahg.entity.ChiTietHopDong;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.gui.util.Alerts;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CongNhanControler implements Initializable {

    @FXML
    private Button btnLamMoiTTNhanVien;

    @FXML
    private Button btnLayDuLieuPhanCongCongNhan;

    @FXML
    private Button btnLuu;

    @FXML
    private ImageView btnLuuPhanCongCongNhan;

    @FXML
    private Button btnResetPhanCongCongNhan;

    @FXML
    private Button btnSuaTTNhanVien;

    @FXML
    private Button btnThemTTNhanVien;

    @FXML
    private Button btnXoaTTNhanVien;

    @FXML
    private ComboBox<?> cbxChucVuTTNhanVien;

    @FXML
    private ComboBox<String> cbxLayTTHopDongPhanCongCongNh;

    @FXML
    private ComboBox<?> cbxPhongBanTTNhanVien;

    @FXML
    private ComboBox<?> cbxPhuCapTTNhanVien;

    @FXML
    private CheckBox ckGioiTinhTTNhanVien;

    @FXML
    private TableColumn<?, ?> colHovaTenTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colMaChamCongTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colMaCongDoanPhanCongCongNhan;

    @FXML
    private TableColumn<ChiTietHopDong, String> colMaSanPhamPhanCongCongNhan;

    @FXML
    private TableColumn<ChiTietHopDong, String> colMaSanPhamPhanCongCongNhan1;

    @FXML
    private TableColumn<?, ?> colMaToPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colNgayKetThucTTPhanCongToCongNhan;

    @FXML
    private TableColumn<?, ?> colNgayKetThucTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colNgayPhamCongChamCongTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colNgayPhanCongTTPhanCongToCongNhan;

    @FXML
    private TableColumn<?, ?> colSoLuongLamTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colSoLuongNguoiTrongToPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colTenCongDoanPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colTenCongDoanTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colTenSanPhamCDPhanCongCongNhan;

    @FXML
    private TableColumn<ChiTietHopDong, Integer> colTenSanPhamPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colTenSanPhamTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colTenToPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colToTTPhanCongToCongNhan;

    @FXML
    private TableColumn<?, ?> colToTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<?, ?> colTongSoLuongLamTTPhanCongToCongNhan;

    @FXML
    private DatePicker datepickNgayKetThuc;

    @FXML
    private DatePicker datepickNgayPhanCong;

    @FXML
    private DatePicker datepickNgaySinhTTNhanVien;

    @FXML
    private DatePicker datepickNgayVaoLamTTNhanVien;

    @FXML
    private TableView<?> tblViewTTCongDoanPhanCongCongNhan;

    @FXML
    private TableView<?> tblViewTTPhanCongToCongNhan;

    @FXML
    private TableView<?> tblViewTTPhanCongTungCongNhan;

    @FXML
    private TableView<ChiTietHopDong> tblViewTTSanPhamPhanCongCongNhan;

    @FXML
    private TableView<?> tblViewTTToPhanCongCongNhan;

    @FXML
    private TextField tfEmailTTNhanVien;

    @FXML
    private TextField tfMaTTNhanVien;

    @FXML
    private TextField tfSoDienThoaiTTNhanVien;

    @FXML
    private TextField tfSoLuongPhanCongTungNguoi;

    @FXML
    private TextField tfSoTaiKhoanTTNhanVien;

    @FXML
    private TextField tfTenTTNhanVien;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepickNgayPhanCong.setValue(LocalDate.now());
        loadcbxDSHopDong();
        docDuLieuVaoTblTTSanPhamPCCND();
    }

    private void loadcbxDSHopDong (){
        DSMaHopDong.addAll(PhanCongCongNhanHopDongimpl.getInstance().getAllMaHD());
        ObservableList<String> dsMaHopDong = FXCollections.observableArrayList();
        for (HopDong hd :DSMaHopDong){
            dsMaHopDong.add(hd.getMaHD());
        }
        cbxLayTTHopDongPhanCongCongNh.setItems(dsMaHopDong);
    }
    public void xoaDuLieuDSChiTietHopDongNeuDaCoDuL (){
        if (!DSChiTietHopDong.isEmpty())
            DSChiTietHopDong.clear();
    }
    public void LayDuLeiuPhanCongCongNhanmaHD(ActionEvent actionEvent) {
        xoaDuLieuDSChiTietHopDongNeuDaCoDuL();
        if (cbxLayTTHopDongPhanCongCongNh.getSelectionModel().isEmpty())
            Alerts.showConfirmation("Thông báo", "Chưa chọn hợp đồng");
        else {
            String maHD = cbxLayTTHopDongPhanCongCongNh.getValue().trim();
            DSChiTietHopDong.addAll(PhanCongCongNhanChiTietHDDaoimpl.getInstance().getAllChiTietHopDong(maHD));

        }
    }
    private void docDuLieuVaoTblTTSanPhamPCCND(){
        colMaSanPhamPhanCongCongNhan1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongStringCellDataFeatures) {
                return new SimpleStringProperty(chiTietHopDongStringCellDataFeatures.getValue().getMaSanPham().getMaSP());
            }
        });
        colMaSanPhamPhanCongCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongStringCellDataFeatures) {
                return new SimpleStringProperty(chiTietHopDongStringCellDataFeatures.getValue().getMaSanPham().getTenSP());
            }
        });
        colMaSanPhamPhanCongCongNhan.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        tblViewTTSanPhamPhanCongCongNhan.setItems(DSChiTietHopDong);
    }
}
