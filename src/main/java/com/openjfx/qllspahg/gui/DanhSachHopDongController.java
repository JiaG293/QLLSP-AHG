package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.DanhSachHopDongImpl;
import com.openjfx.qllspahg.entity.ChiTietHopDong;
import com.openjfx.qllspahg.entity.HopDong;
import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.gui.util.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;

public class DanhSachHopDongController implements Initializable {

    @FXML
    private TextField tfMaHopDongCTHD;

    @FXML
    private ComboBox<String> cbxLocTrangThaiHD;

    @FXML
    private ComboBox<String> cbxTenSP;

    @FXML
    private TableColumn<HopDong, String> colDiaChiHD;

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
    private TableColumn<HopDong, String> colNgayBatDauHD;

    @FXML
    private TableColumn<HopDong, String> colNgayKetThucHD;

    @FXML
    private TableColumn<HopDong, String> colSDTHD;

    @FXML
    private TableColumn<HopDong, Integer> colSTTHopDong;

    @FXML
    private TableColumn<ChiTietHopDong, Integer> colSTTSanPham;

    @FXML
    private TableColumn<ChiTietHopDong, Integer> colSoLuongCongDoan;

    @FXML
    private TableColumn<ChiTietHopDong, Integer> colSoLuongDatSP;

    @FXML
    private TableColumn<ChiTietHopDong, Integer> colSoLuongDaSanXuatSP;

    @FXML
    private TableColumn<ChiTietHopDong, String> colTenSP;

    @FXML
    private TableColumn<HopDong, String> colTrangThaiHD;

    @FXML
    private DatePicker datepickLocNgayBatDau;

    @FXML
    private DatePicker datepickLocNgayKetThuc;

    @FXML
    private DatePicker datepickNgayBatDauHD;

    @FXML
    private DatePicker datepickNgayKetThucHD;

    @FXML
    private TableView<ChiTietHopDong> tblChiTietHopDong;

    @FXML
    private TableView<HopDong> tblHopDong;

    @FXML
    private TextField tfDiaChiHD;

    @FXML
    private TextField tfEmailHD;

    @FXML
    private TextField tfHoTenKH;

    @FXML
    private TextField tfMaHD;

    @FXML
    private TextField tfMaSP;

    @FXML
    private TextField tfSDTHD;

    @FXML
    private Spinner<Integer> tfSoLuongSP;

    @FXML
    void capNhatHopDong(ActionEvent event) {

    }

    @FXML
    void chonMotChiTietHopDong(MouseEvent event) {
        ChiTietHopDong cthdDuocChon = tblChiTietHopDong.getSelectionModel().getSelectedItem();
        if (cthdDuocChon != null)
        {
            tfMaSP.setText(cthdDuocChon.getMaSanPham().getMaSP());
            cbxTenSP.setValue(cthdDuocChon.getMaSanPham().getTenSP());
            tfSoLuongSP.getValueFactory().setValue(3); //cthdDuocChon.getSoLuong()
        }
        else{
            Alerts.showAlert("Thông báo", "Không có dữ liệu", "Chưa chọn một hợp đồng cụ thể", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void chonMotHopDong(MouseEvent event) {
        HopDong hdDuocChon = tblHopDong.getSelectionModel().getSelectedItem();
        if(hdDuocChon != null){
            tfMaHD.setText(hdDuocChon.getMaHD());
            tfHoTenKH.setText(hdDuocChon.getTenKH());
            tfSDTHD.setText(hdDuocChon.getsDT());
            tfDiaChiHD.setText(hdDuocChon.getDiaChi());
            tfEmailHD.setText(hdDuocChon.getEmail());
            datepickNgayBatDauHD.setValue(hdDuocChon.getNgayKKHD().toLocalDate());
            datepickNgayKetThucHD.setValue(hdDuocChon.getNgayTLHD().toLocalDate());
            DSCTHOPDONG.clear();
            tblChiTietHopDong.refresh();
            System.out.println(hdDuocChon.getMaHD());
        }


    }

    @FXML
    void chonMotSanPhamThem(ActionEvent event) {
        String maSP = DanhSachHopDongImpl.getInstance().timMaSanPhamDuaTrenTen(cbxTenSP.getValue());
        tfMaSP.setText(maSP);
    }

    @FXML
    void lamMoiDanhSachHD(ActionEvent event) {

    }

    @FXML
    void lamMoiMaHD(ActionEvent event) {
        tfMaHD.setText(UUIDUtils.taoMaHopDong(DanhSachHopDongImpl.getInstance().layDanhSachMaHopDong()));
    }

    @FXML
    void layDuLieuLocDSHD(ActionEvent event) {
        String trangThaiHD = null;

        String ngayBatDau = null;
        String ngayKetThuc = null;

        if (ngayBatDau != null && ngayKetThuc != null) {
            ngayBatDau = Utils.dinhDangNgayHienTai(datepickLocNgayBatDau.getValue(), "yyyy-MM-dd");
            ngayKetThuc = Utils.dinhDangNgayHienTai(datepickLocNgayKetThuc.getValue(), "yyyy-MM-dd");
        }

        if (cbxLocTrangThaiHD.getValue().equals("Thanh lý"))
            trangThaiHD = "1";
        else {
            trangThaiHD = "0";
        }
        taiDuLieuHopDong(DanhSachHopDongImpl.getInstance().locDuLieuDanhSachHopDong(trangThaiHD, ngayBatDau, ngayKetThuc));
        Alerts.showAlert("Thông báo", "Lọc thành công", "Lấy dữ liệu lọc thành công", Alert.AlertType.INFORMATION);
    }

    @FXML
    void luuDanhSachHopDong(ActionEvent event) {

    }

    @FXML
    void thanhLyHopDong(ActionEvent event) {
        HopDong hdDuocChon = tblHopDong.getSelectionModel().getSelectedItem();

        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn thanh lý hợp đồng này?");
        otp.ifPresent(btnType -> {
            String trangThaiHD;
            if (cbxLocTrangThaiHD.getValue().equals("Thanh lý"))
                trangThaiHD = "1";
            else {
                trangThaiHD = "0";
            }
            if (btnType == btnType.OK) {
                boolean check = DanhSachHopDongImpl.getInstance().thanhLyHopDong(hdDuocChon.getMaHD());
                if (check == true) {
                    Alerts.showAlert("Thông báo", "Thành công", "Đã thanh lý hợp đồng", Alert.AlertType.INFORMATION);
                    xoaTrangDuLieuTextField();
                    taiDuLieuHopDong(DanhSachHopDongImpl.getInstance().layDuLieuHopDongTrangThaiTuyChon(trangThaiHD));
                } else
                    Alerts.showAlert("Thông báo", "Thất bại", "Gặp lỗi trong quá trình cập nhật", Alert.AlertType.ERROR);
            }
        });
    }

    @FXML
    void themHopDong(ActionEvent event) {
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn thêm hợp đồng này");
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                boolean check = DanhSachHopDongImpl.getInstance().taoHopDongMoi(layDuLieuTextFieldHopDong());
                if (check == true) {
                    Alerts.showAlert("Thông báo", "Thành công", "Đã lưu thành công", Alert.AlertType.INFORMATION);
                    tfMaHD.setText(UUIDUtils.taoMaHopDong(DanhSachHopDongImpl.getInstance().layDanhSachMaHopDong())); //khoi tao lai ma hd moi
                    taiDuLieuHopDong(DanhSachHopDongImpl.getInstance().layDuLieuHopDong());
                    xoaTrangDuLieuTextField();
                } else
                    Alerts.showAlert("Thông báo", "Thất bại", "Gặp lỗi trong quá trình tạo", Alert.AlertType.ERROR);
            }
        });
    }

    @FXML
    void themSanPhamChoHopDong(ActionEvent event) {
        String maSP = tfMaSP.getText();
        int soLuong = tfSoLuongSP.getValue();
        String maHD = tfMaHopDongCTHD.getText();
        SanPham sp = new SanPham(maSP);
        HopDong hd = new HopDong(maHD);

        ChiTietHopDong cthd = new ChiTietHopDong(hd, sp, soLuong);
        System.out.println(cthd.getMaSanPham().getMaSP());

        boolean flag = DanhSachHopDongImpl.getInstance().themMotSanPhamChoMotHopDong(maHD, cthd);
        if (flag) {
            taiDuLieuChiTietHopDong(DanhSachHopDongImpl.getInstance().layDuLieuChiTietHopDong(maHD));
            System.out.println("list sp duoc them:\n" + DSCTHOPDONG.size());
        } else {
            Alerts.showAlert("Thông báo", "Lỗi hoặc trùng sản phẩm", "Lỗi khi thêm 1 sản phẩm vào hợp đồng", Alert.AlertType.ERROR);
        }
        tfMaHD.clear();
        cbxTenSP.getSelectionModel().select(0);
    }

    @FXML
    void xemChiTietHopDong(ActionEvent event) {
        HopDong hdDuocChon = tblHopDong.getSelectionModel().getSelectedItem();
        if (hdDuocChon != null){
            taiDuLieuChiTietHopDong(DanhSachHopDongImpl.getInstance().layDuLieuChiTietHopDong(hdDuocChon.getMaHD()));
            tfMaHopDongCTHD.setText(hdDuocChon.getMaHD());
        }
        else
            Alerts.showAlert("Thông báo", "Không có dữ liệu", "Chưa chọn một hợp đồng cụ thể", Alert.AlertType.WARNING);
    }

    @FXML
    void xoaSanPhamChoHopDong(ActionEvent event) {

    }

    @FXML
    void xoaTrangTextFieldDuLieu(ActionEvent event) {
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn trắng ô nhập");
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                xoaTrangDuLieuTextField();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoKieuDuLieuChoTableView();
//        taiDuLieuHopDong(DanhSachHopDongImpl.getInstance().layDuLieuHopDongTrangThaiTuyChon("False"));


    }


    private void taiDuLieuHopDong(ObservableList<HopDong> method) {
        if (!DSHOPDONG.isEmpty()) {
            DSHOPDONG.clear();
        }
        DSHOPDONG.addAll(method);
        tblHopDong.setItems(DSHOPDONG);
    }

    private void taiDuLieuChiTietHopDong(ObservableList<ChiTietHopDong> method) {
        if (!DSCTHOPDONG.isEmpty()) {
            DSCTHOPDONG.clear();
        }
        DSCTHOPDONG.addAll(method);
        tblChiTietHopDong.setItems(DSCTHOPDONG);
    }

    public void khoiTaoKieuDuLieuChoTableView() {
        //Tao cot ao tableview
        colSTTSanPham.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });

        colSTTHopDong.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });

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
        colMaHD.setCellValueFactory(new PropertyValueFactory<HopDong, String>("maHD"));
        colHoTenKHHD.setCellValueFactory(new PropertyValueFactory<HopDong, String>("tenKH"));

        colSDTHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(hopDongStringCellDataFeatures.getValue().getsDT());
            }
        });

        colDiaChiHD.setCellValueFactory(new PropertyValueFactory<HopDong, String>("diaChi"));

        colEmailHD.setCellValueFactory(new PropertyValueFactory<HopDong, String>("email"));

        colNgayBatDauHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDateCustom(hopDongStringCellDataFeatures.getValue().getNgayKKHD(), "dd-MM-yyyy"));
            }
        });

        colNgayKetThucHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDateCustom(hopDongStringCellDataFeatures.getValue().getNgayTLHD(), "dd-MM-yyyy"));
            }
        });

        colTrangThaiHD.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<HopDong, String> hopDongStringCellDataFeatures) {
                return new SimpleStringProperty((hopDongStringCellDataFeatures.getValue().isTrangThaiHD()) == true ? "Thanh lý" : "Chưa thanh lý");
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


        colSoLuongDatSP.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ChiTietHopDong, Integer> chiTietHopDongIntegerCellDataFeatures) {
                return new SimpleIntegerProperty(chiTietHopDongIntegerCellDataFeatures.getValue().getSoLuongDat()).asObject();
            }
        });

        colSoLuongDaSanXuatSP.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ChiTietHopDong, Integer> chiTietHopDongIntegerCellDataFeatures) {
                return new SimpleIntegerProperty(chiTietHopDongIntegerCellDataFeatures.getValue().getSoLuongDaLam()).asObject();
            }
        });

        colSoLuongCongDoan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ChiTietHopDong, Integer> chiTietHopDongIntegerCellDataFeatures) {
                return new SimpleIntegerProperty(chiTietHopDongIntegerCellDataFeatures.getValue().getSoLuongCongDoan()).asObject();
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
    private void lamMoiTableView(ActionEvent event) {
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận", "Bạn có chắc làm mới dữ liệu hợp đồng");
        String trangThai;
        if (cbxLocTrangThaiHD.getValue().equals("Chưa thanh lý")) {
            trangThai = "0";
        } else {
            trangThai = "1";
        }
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                taiDuLieuHopDong(DanhSachHopDongImpl.getInstance().layDuLieuHopDongTrangThaiTuyChon(trangThai));
                Alerts.showAlert("Thông báo", "Đã tải lại dữ liệu", "Tải lại dữ liệu danh sách hợp đồng thành công", Alert.AlertType.INFORMATION);
                tfMaHD.setText(UUIDUtils.taoMaHopDong(DanhSachHopDongImpl.getInstance().layDanhSachMaHopDong())); //khoi tao lai ma hd moi
            }
        });

    }


    private void taiDuLieuComboBoxTrangThaiHopDong() {
        cbxLocTrangThaiHD.setPromptText("Chọn trạng thái");
        ObservableList<String> listTrangThaiHD = FXCollections.observableArrayList();
        listTrangThaiHD.addAll("Thanh lý", "Chưa thanh lý");
        cbxLocTrangThaiHD.setValue("Chưa thanh lý");
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

    private void xoaTrangDuLieuTextField() {
        tfMaHD.clear();
        tfHoTenKH.clear();
        tfSDTHD.clear();
        tfDiaChiHD.clear();
        tfEmailHD.clear();
        tfMaHD.setText(UUIDUtils.taoMaHopDong(DanhSachHopDongImpl.getInstance().layDanhSachMaHopDong()));

        //Khoi tao gia tri tang len giam xuong toi thieu toi da cua spinner tf soluong
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20000, 0);
        tfSoLuongSP.setValueFactory(valueFactory);

        //Khoi tao ngay duoc chon
        datepickNgayBatDauHD.setValue(LocalDate.parse(Utils.taoNgayHienTai()));
        datepickNgayKetThucHD.setValue(LocalDate.now().plusDays(30)); //ngay hien tai + 30 ngay
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
