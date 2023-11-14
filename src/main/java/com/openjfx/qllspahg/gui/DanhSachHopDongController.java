package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;
import com.openjfx.qllspahg.dao.DanhSachHopDongImpl;
import com.openjfx.qllspahg.entity.ChiTietHopDong;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import com.openjfx.qllspahg.gui.util.Utils;
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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;

public class DanhSachHopDongController implements Initializable {

    @FXML
    private DatePicker datepickLocNgayBatDau;

    @FXML
    private DatePicker datepickLocNgayKetThuc;

    @FXML
    private ComboBox<String> cbxLocTrangThaiHD;

    @FXML
    private ComboBox<String> cbxTenSP;

    @FXML
    private TableColumn<ChiTietHopDong, String> colDonGiaSP;

    @FXML
    private TableColumn<HopDong, String> colEmailHD;

    @FXML
    private TableColumn<HopDong, String> colHoTenKHHD;

    @FXML
    private TableColumn<HopDong, String> colMaHD;

    @FXML
    private TableColumn<ChiTietHopDong, String> colMaSP;

    @FXML
    private TableColumn<HopDong, String> colDiaChiHD;

    @FXML
    private TableColumn<HopDong, String> colNgayBatDauHD;

    @FXML
    private TableColumn<HopDong, String> colNgayKetThucHD;

    @FXML
    private TableColumn<HopDong, String> colSDTHD;

    @FXML
    private TableColumn<?, ?> colSTT;

    @FXML
    private TableColumn<?, ?> colSTTSanPham;

    @FXML
    private TableColumn<ChiTietHopDong, Integer> colSoLuongSP;

    @FXML
    private TableColumn<ChiTietHopDong, String> colTenSP;

    @FXML
    private DatePicker datepickNgayBatDauHD;

    @FXML
    private DatePicker datepickNgayKetThucHD;

    @FXML
    private TextField tfEmailHD;

    @FXML
    private TextField tfHoTenKH;

    @FXML
    private TextField tfDiaChiHD;

    @FXML
    private TextField tfMaSP;

    @FXML
    private TextField tfSDTHD;

    @FXML
    private TextField tfMaHD;

    @FXML
    private Spinner<Integer> tfSoLuongSP;

    @FXML
    private TableView<ChiTietHopDong> tblviewChiTietHopDong;

    @FXML
    private TableView<HopDong> tblviewHopDong;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableDanhSachHopDong();
        taiDuLieuHopDong(DanhSachHopDongImpl.getInstance().layDuLieuHopDong());


    }

    private void taiDuLieuHopDong(ObservableList<HopDong> method) {
        if (!DSHOPDONG.isEmpty()) {
            DSHOPDONG.clear();
        }
        DSHOPDONG.addAll(method);
        tblviewHopDong.setItems(DSHOPDONG);
    }

    private void taiDuLieuChiTietHopDong(ObservableList<ChiTietHopDong> method) {
        if (!DSCTHOPDONG.isEmpty()) {
            DSCTHOPDONG.clear();
        }
        DSCTHOPDONG.addAll(method);
        tblviewChiTietHopDong.setItems(DSCTHOPDONG);
    }

    public void khoiTaoTableDanhSachHopDong() {

        //KhoiTaoMaHopDong
        tfMaHD.setText(UUIDUtils.taoMaHopDong(DanhSachHopDongImpl.getInstance().layDanhSachMaHopDong()));

        //Khoi tao gia tri tang len giam xuong toi thieu toi da cua spinner tf soluong
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20000, 0);
        tfSoLuongSP.setValueFactory(valueFactory);

        //Khoi tao ngay duoc chon
        datepickNgayBatDauHD.setValue(LocalDate.parse(Utils.taoNgayHienTai()));
        datepickNgayKetThucHD.setValue(LocalDate.now().plusDays(30)); //ngay hien tai + 30 ngay
        datepickLocNgayBatDau.setPromptText("Lọc ngày bắt đầu");
        datepickLocNgayKetThuc.setPromptText("Lọc ngày kết thúc");
        //Tai du lieu combobox
        taiDuLieuComboBoxSanPham();
        taiDuLieuComboBoxTrangThaiHopDong();

        //Bang HopDong
        colMaHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(hopDongStringCellDataFeatures.getValue().getMaHD());
            }
        });
        colHoTenKHHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(hopDongStringCellDataFeatures.getValue().getTenKH());
            }
        });

        colSDTHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(hopDongStringCellDataFeatures.getValue().getsDT());
            }
        });

        colDiaChiHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(hopDongStringCellDataFeatures.getValue().getDiaChi());
            }
        });

        colEmailHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(hopDongStringCellDataFeatures.getValue().getEmail());
            }
        });

        colNgayBatDauHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDate(hopDongStringCellDataFeatures.getValue().getNgayKKHD()));
            }
        });

        colNgayKetThucHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDate(hopDongStringCellDataFeatures.getValue().getNgayTLHD()));
            }
        });


        //Bang Chi Tiet Hop Dong
        colMaSP.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongmStringCellDataFeatures) {
                return new SimpleStringProperty(chiTietHopDongmStringCellDataFeatures.getValue().getMaSanPham().getMaSP());
            }
        });
        colTenSP.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongmStringCellDataFeatures) {
                return new SimpleStringProperty(chiTietHopDongmStringCellDataFeatures.getValue().getMaSanPham().getTenSP());
            }
        });

        colSoLuongSP.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ChiTietHopDong, Integer> chiTietHopDongIntegerCellDataFeatures) {
                return new SimpleIntegerProperty(chiTietHopDongIntegerCellDataFeatures.getValue().getSoLuong()).asObject();
            }
        });

        colDonGiaSP.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(chiTietHopDongStringCellDataFeatures.getValue().getMaSanPham().getGiaSP()));
            }
        });
    }


    @FXML
    private void capNhatHopDong(ActionEvent event) {

    }

    @FXML
    private void lamMoiDanhSachHD(ActionEvent event) {

    }

    @FXML
    private void layDuLieuLocDSHD(ActionEvent event) {

    }

    @FXML
    private void luuDanhSachHopDong(ActionEvent event) {

    }

    @FXML
    private void thanhLyHopDong(ActionEvent event) {

    }

    @FXML
    private void themHopDong(ActionEvent event) {
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn thêm hợp đồng này");
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                DanhSachHopDongImpl.getInstance().taoHopDongMoi(layDuLieuTextFieldHopDong());
                Alerts.showAlert("Thông báo", "Thành công", "Đã lưu thành công", Alert.AlertType.CONFIRMATION);
            }
        });
    }

    @FXML
    private void themSanPhamChoHopDong(MouseEvent event) {

    }

    @FXML
    private void xemChiTietHopDong(ActionEvent event) {
        HopDong hdDuocChon = tblviewHopDong.getSelectionModel().getSelectedItem();
        taiDuLieuChiTietHopDong(DanhSachHopDongImpl.getInstance().layDuLieuChiTietHopDong(hdDuocChon.getMaHD()));
    }

    @FXML
    private void xoaSanPhamChoHopDong(ActionEvent event) {

    }


    @FXML
    void chonMotHopDong(MouseEvent event) {
        HopDong hdDuocChon = tblviewHopDong.getSelectionModel().getSelectedItem();
        tfMaHD.setText(hdDuocChon.getMaHD());
        tfHoTenKH.setText(hdDuocChon.getTenKH());
        tfSDTHD.setText(hdDuocChon.getsDT());
        tfDiaChiHD.setText(hdDuocChon.getDiaChi());
        tfEmailHD.setText(hdDuocChon.getEmail());
        datepickNgayBatDauHD.setValue(hdDuocChon.getNgayKKHD().toLocalDate());
        datepickNgayKetThucHD.setValue(hdDuocChon.getNgayTLHD().toLocalDate());

        System.out.println(hdDuocChon.getMaHD());
    }

    @FXML
    private void chonMotChiTietHopDong(MouseEvent event) {
        ChiTietHopDong cthdDuocChon = tblviewChiTietHopDong.getSelectionModel().getSelectedItem();
        tfMaSP.setText(cthdDuocChon.getMaSanPham().getMaSP());
        cbxTenSP.setValue(cthdDuocChon.getMaSanPham().getTenSP());
        tfSoLuongSP.getValueFactory().setValue(cthdDuocChon.getSoLuong());
    }

    @FXML
    private void chonMotSanPhamThem(ActionEvent event) {
        String maSP = DanhSachHopDongImpl.getInstance().timMaSanPhamDuaTrenTen(cbxTenSP.getValue());
        tfMaSP.setText(maSP);
    }

    private void taiDuLieuComboBoxTrangThaiHopDong() {
        cbxLocTrangThaiHD.setPromptText("Chọn trạng thái");
        ObservableList<String> listTrangThaiHD = FXCollections.observableArrayList();
        listTrangThaiHD.addAll("Thanh lý", "Chưa thanh lý");
        cbxLocTrangThaiHD.setItems(listTrangThaiHD);

    }

    private void taiDuLieuComboBoxSanPham() {
        cbxTenSP.setPromptText("Chọn sản phẩm");
        ObservableList<SanPham> listSanPham = FXCollections.observableArrayList();
        ObservableList<String> listTenSP = FXCollections.observableArrayList();
        listSanPham.addAll(DanhSachHopDongImpl.getInstance().layDuLieuSanPham());
        for (SanPham sp : listSanPham) {
            listTenSP.add(sp.getTenSP());
        }
        cbxTenSP.setItems(listTenSP);
    }

    private HopDong layDuLieuTextFieldHopDong() {
        String maHD = UUIDUtils.taoMaHopDong(DanhSachHopDongImpl.getInstance().layDanhSachMaHopDong());
        String hoTenKH = tfHoTenKH.getText();
        String sDT = tfSDTHD.getText();
        String diaChi = tfDiaChiHD.getText();
        String email = tfEmailHD.getText();
        Date ngayKKHD = Date.valueOf(datepickNgayBatDauHD.getValue());
        Date ngayTLHD = Date.valueOf(datepickNgayBatDauHD.getValue());
        HopDong hd = new HopDong(maHD, hoTenKH, sDT, diaChi, email, ngayKKHD, ngayTLHD);
        if (hoTenKH.isEmpty())
            Alerts.showAlert("Vui lòng nhập", "Không được để trống", "Vui lòng nhập thông tin cho trường họ tên khách hàng", Alert.AlertType.WARNING);
        else if (sDT.isEmpty())
            Alerts.showAlert("Vui lòng nhập", "Không được để trống", "Vui lòng nhập thông tin cho trường số điện thoại", Alert.AlertType.WARNING);
        else if (diaChi.isEmpty())
            Alerts.showAlert("Vui lòng nhập", "Không được để trống", "Vui lòng nhập thông tin cho trường địa chỉ", Alert.AlertType.WARNING);
        else if (email.isEmpty())
            Alerts.showAlert("Vui lòng nhập", "Không được để trống", "Vui lòng nhập thông tin cho trường email", Alert.AlertType.WARNING);
        return hd;
    }

}
