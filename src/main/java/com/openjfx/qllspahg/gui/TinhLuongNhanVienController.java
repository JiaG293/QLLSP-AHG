package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;
import com.openjfx.qllspahg.dao.TinhLuongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.TinhLuongNhanVienDaoImpl;
import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.model.ChiTietLuongCongNhan;
import com.openjfx.qllspahg.entity.model.ChiTietLuongNhanVien;
import com.openjfx.qllspahg.gui.util.Alerts;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCHITIETLUONGCONGNHAN;

public class TinhLuongNhanVienController implements Initializable {

    @FXML
    private Button btnLuuBangLuongDuocChon;

    @FXML
    private Button btnLuuDanhSachBangLuong;


    @FXML
    private ComboBox<String> cbxLocNamTinhLuongNV;

    @FXML
    private ComboBox<String> cbxLocPhongBanNV;

    @FXML
    private ComboBox<String> cbxLocThangTinhLuongNV;

    @FXML
    private ComboBox<String> cbxTrangThaiLocNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colBHXHNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colBHYTNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colTienChuyenCanNV;

    @FXML
    private TableColumn<?, ?> colHoVaTenNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colHoNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colTenNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colLuongChinhNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colLuongThucTeNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colLuongNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colLuongNhanDuocNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colMaNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colPhongBanNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colChuyenCanNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colPhuCapNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, Integer> colSoNgayDiLamNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, Integer> colSoNgayTangCaNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, Integer> colSoNgayCoPhepNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, Integer> colSoNgayNghiNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colTamUngNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colTienConNho;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, String> colTienNhaTro;

    @FXML
    private TableColumn<?, ?> colTruyLanhNV;

    @FXML
    private TableColumn<ChiTietLuongNhanVien, Integer> collSTTLuongNV;

    @FXML
    private TableView<ChiTietLuongNhanVien> tblLuongNhanVien;

    @FXML
    private Label lblThangNamLuongNV;

    @FXML
    private TextField tfLocMaNhanVien;

    @FXML
    private TextField tfLocTenNhanVien;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableLuongNhanVien();
    }


    public void khoiTaoTableLuongNhanVien() {
        //Khoi tao combo box trang thai loc
        khoiTaoComboxBoxTrangThaiBangLuong();

        //Doi chu khi khong co du lieu tu tieng anh sang tieng viet
        tblLuongNhanVien.setPlaceholder(new Label("Không có dữ liệu\nVui lòng thực hiện lấy dữ liệu"));

        //KhoiTao label thang-nam bang luong
        khoiTaoLabelThangNamBangLuong();

        //chinh sua du lieu cho 2 cot
        khoiTaoComboBoxPhongBan();

        //textField Loc Ma va ten
        tfLocMaNhanVien.setPromptText("Nhập mã công nhân");
        tfLocTenNhanVien.setPromptText("Nhập tên công nhân");
        tfLocMaNhanVien.setText(null);
        tfLocTenNhanVien.setText(null);


        //Khoi tao du lieu combobox thang nam
        khoiTaoComboBoxThangNam();

        //Khoi tao cot ao stt cho bang cham cong
        collSTTLuongNV.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });


        colMaNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getMaNV());
            }
        });

        colHoNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getTenNV());
            }
        });

        colTenNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getTenNV());
            }
        });


        colPhongBanNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getPhongBan().getTenPB());
            }
        });

        colSoNgayDiLamNV.setCellValueFactory(new PropertyValueFactory<ChiTietLuongNhanVien, Integer>("soNgayDiLam"));
        colSoNgayTangCaNV.setCellValueFactory(new PropertyValueFactory<ChiTietLuongNhanVien, Integer>("soNgayTangCa"));
        colSoNgayCoPhepNV.setCellValueFactory(new PropertyValueFactory<ChiTietLuongNhanVien, Integer>("soNgayCoPhep"));
        colSoNgayNghiNV.setCellValueFactory(new PropertyValueFactory<ChiTietLuongNhanVien, Integer>("soNgayNghi"));

        colLuongChinhNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getLuongCoBan()));
            }
        });

        colLuongNhanDuocNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getLuongNhanDuoc()));
            }
        });

        colLuongThucTeNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getLuongThucTe()));
            }
        });

        colBHXHNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getPhiBHXH()));
            }
        });

        colBHYTNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getPhiBHYT()));
            }
        });

        colTamUngNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getMaTamUngNhanVien().getSoTienTamUng()));
            }
        });

        colTienChuyenCanNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getMaPhuCapNhanVien().getTienChuyenCan()));
            }
        });

        colTienConNho.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getMaPhuCapNhanVien().getTienConNho()));
            }
        });

        colTienNhaTro.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getMaPhuCapNhanVien().getTienNhaTro()));
            }
        });

    }

    private void khoiTaoComboxBoxTrangThaiBangLuong() {
        ObservableList<String> listTrangThai = FXCollections.observableArrayList();
        listTrangThai.clear();
        cbxTrangThaiLocNV.setPromptText("Chọn trạng thái lọc");
        listTrangThai.addAll("Tất cả", "Chưa tạo");
        cbxTrangThaiLocNV.setItems(listTrangThai);
        cbxTrangThaiLocNV.getSelectionModel().select(0);
    }

    private void khoiTaoLabelThangNamBangLuong() {
        String thangLbl = cbxLocThangTinhLuongNV.getValue();
        String namLbl = cbxLocNamTinhLuongNV.getValue();
        LocalDate dateHienTai = LocalDate.now();
        if (thangLbl == null || thangLbl.equals("Trống") || thangLbl.isEmpty()) {
            thangLbl = String.valueOf(dateHienTai.getMonthValue() - 1);
        }
        if (namLbl == null || namLbl.equals("Trống") || namLbl.isEmpty()) {
            namLbl = String.valueOf(dateHienTai.getYear());
        }
        lblThangNamLuongNV.setText("Bảng tính lương tháng " + thangLbl + "-" + namLbl);
    }

    private void khoiTaoComboBoxThangNam() {
        ObservableList<String> thang = FXCollections.observableArrayList();
        ObservableList<String> nam = FXCollections.observableArrayList();
        LocalDate dateHienTai = LocalDate.now();

        thang.clear();
        nam.clear();

        thang.add("Trống");
        nam.add("Trống");

        for (int i = 1; i <= 12; i++) {
            thang.add(String.format("%02d", i)); // dinh dang thanh 2 chu so
        }
        cbxLocThangTinhLuongNV.setItems(thang);
        cbxLocThangTinhLuongNV.setPromptText("Chọn tháng");
        cbxLocThangTinhLuongNV.setValue(String.valueOf(dateHienTai.getMonthValue() - 1)); // tra ve thang truoc de tinh bang luong
        int namHienTai = YearMonth.now().getYear();
        for (int i = 2000; i <= namHienTai + 1; i++) {
            nam.add(String.valueOf(i));
        }
        cbxLocNamTinhLuongNV.setItems(nam);
        cbxLocNamTinhLuongNV.setPromptText("Chọn năm");
        cbxLocNamTinhLuongNV.setValue(String.valueOf(dateHienTai.getYear())); // tra ve thang truoc de tinh bang luong
    }

    private void khoiTaoComboBoxPhongBan() {
        cbxLocPhongBanNV.setPromptText("Chọn phòng ban");
        ObservableList<String> listPB = FXCollections.observableArrayList();
        listPB.clear();
        listPB.add("Trống");
        ObservableList<String> listPb = ChamCongNhanVienDaoImpl.getInstance().layDuLieuPhongBanNhanVien();
        if (!listPb.isEmpty() || listPb != null) {
            listPB.addAll(listPb);
        } else {
            cbxLocPhongBanNV.setPromptText("Không có dữ liệu");
        }
        cbxLocPhongBanNV.setItems(listPB);
    }

    @FXML
    void layDuLieuLocLuongNhanVien(ActionEvent event) {
        /*String thang = cbxLocThangTinhLuongNV.getValue();
        String nam = cbxLocNamTinhLuongNV.getValue();
        System.out.println(thang + nam);
        taiDuLieuTinhLuongNhanVienTuyChon(TinhLuongNhanVienDaoImpl.getInstance().tinhLuongNhanVienTuDong(thang, nam));

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongNV.getValue();
        String namLbl = cbxLocNamTinhLuongNV.getValue();
        lblThangNamLuongNV.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);*/

        String thang = cbxLocThangTinhLuongNV.getValue();
        String nam = cbxLocNamTinhLuongNV.getValue();

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongNV.getValue();
        String namLbl = cbxLocNamTinhLuongNV.getValue();
        lblThangNamLuongNV.setText("Bảng tính lương tháng " + thangLbl + "-" + namLbl);

        //Du lieu loc textfield ma, ten
        String maNV = tfLocMaNhanVien.getText();
        String tenNV = tfLocTenNhanVien.getText();
        String phongBan = cbxLocPhongBanNV.getValue();

        // combo box trang thai loc de xac dinh co xem du lieu khong
        String trangThaiLoc = cbxTrangThaiLocNV.getValue();

        System.out.println(maNV + " " + tenNV + " " + phongBan + " " + thangLbl + " " + namLbl);

        if (!DSCHITIETLUONGNHANVIEN.isEmpty()) {
            DSCHITIETLUONGNHANVIEN.clear();
        }


        ObservableList<ChiTietLuongNhanVien> listCTLNV = TinhLuongNhanVienDaoImpl.getInstance().locDuLieuDanhSachChiTietLuongNhanVienTuyChon(maNV, tenNV, phongBan, thangLbl, namLbl, trangThaiLoc);
        if (listCTLNV.isEmpty()) {
            Alerts.showAlert("Thông báo", "Lọc thành công", "Không tìm thấy bảng lương phù hợp.", Alert.AlertType.INFORMATION);
        } else {
            DSCHITIETLUONGNHANVIEN.addAll(listCTLNV);
            tblLuongNhanVien.setItems(DSCHITIETLUONGNHANVIEN);
            Alerts.showAlert("Thông báo", "Lọc thành công", "Tìm thấy " + listCTLNV.size() + " bảng lương.", Alert.AlertType.INFORMATION);
            ;
        }
        System.out.println("DS san pham sau khi loc:" + DSCHITIETLUONGNHANVIEN.toString() + "\n");
    }

    @FXML
    void luuDanhSachLuong(ActionEvent event) {
        int soLuongBangLuongTonTai = 0;
        String title = "Xác nhận";
        String content = "Bạn có chắc muốn lưu danh sách lương";


        if (!DSCHITIETLUONGNHANVIEN.isEmpty()) {
            for (ChiTietLuongNhanVien ctlnv : DSCHITIETLUONGNHANVIEN) {
                if (TinhLuongCongNhanDaoImpl.getInstance().kiemTraBangLuongTonTai(UUIDUtils.taoMaBangLuongCongNhan(ctlnv.getMaNhanVien().getMaNV()))) {
                    soLuongBangLuongTonTai = soLuongBangLuongTonTai + 1;
                }
            }
            if (soLuongBangLuongTonTai > 0) {
                title = "Cảnh báo";
                content = "Có " + soLuongBangLuongTonTai + " bảng lương đã được tạo các bảng này sẽ không được lưu";
            }
            Optional<ButtonType> rs = Alerts.showConfirmation(title, content);
            int finalSoLuongBangLuongTonTai = soLuongBangLuongTonTai; // khai bao gan bien neu dung trong lamda
            rs.ifPresent(btnType -> {
                if (btnType == btnType.OK) {
                    boolean sc = TinhLuongNhanVienDaoImpl.getInstance().luuDanhSachBangLuongNhanVien(DSCHITIETLUONGNHANVIEN);
                    int slThem = DSCHITIETLUONGNHANVIEN.size() - finalSoLuongBangLuongTonTai;
                    if (sc) {
                        Alerts.showAlert("Thông báo", "Thành công", "Đã lưu " + slThem + " bảng lương", Alert.AlertType.INFORMATION);
                        kiemTraBangLuongDuocChon();
                    }
                }
            });

        } else {
            Alerts.showAlert("Cảnh báo", "Danh sách bảng lương rỗng", "Vui lòng thực hiện tính lương lại", Alert.AlertType.WARNING);
            kiemTraBangLuongDuocChon();
        }
    }

    @FXML
    void luuBangTinhLuongDuocCHon(ActionEvent event) {
        ChiTietLuongNhanVien ctlnvDuocChon = tblLuongNhanVien.getSelectionModel().getSelectedItem();
        if (ctlnvDuocChon != null) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn lưu thông tin");
            rs.ifPresent(btnType -> {
                if (btnType == btnType.OK) {
                    TinhLuongCongNhanDaoImpl.getInstance().kiemTraBangLuongTonTai(UUIDUtils.taoMaBangLuongCongNhan(ctlnvDuocChon.getMaNhanVien().getMaNV()));
                    boolean sc = TinhLuongNhanVienDaoImpl.getInstance().luuBangLuongNhanVienDuocChon(ctlnvDuocChon);
                    if (sc) {
                        Alerts.showAlert("Thông báo", "Thành công", "Đã thêm bảng lương được chọn", Alert.AlertType.INFORMATION);
                        kiemTraBangLuongDuocChon();
                    }
                }
            });

        } else {
            Alerts.showAlert("Cảnh báo", "Danh sách bảng lương rỗng", "Vui lòng thực hiện tính lương lại", Alert.AlertType.WARNING);
            kiemTraBangLuongDuocChon();
        }
    }

    @FXML
    void lamMoiDanhSachTinhLuong(ActionEvent event) {

        String thang = cbxLocThangTinhLuongNV.getValue();
        String nam = cbxLocNamTinhLuongNV.getValue();

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongNV.getValue();
        String namLbl = cbxLocNamTinhLuongNV.getValue();
        lblThangNamLuongNV.setText("Bảng tính lương tháng " + thangLbl + "-" + namLbl);

        //Du lieu loc textfield ma, ten
        String maNV = tfLocMaNhanVien.getText();
        String tenNV = tfLocTenNhanVien.getText();
        String phongBan = cbxLocPhongBanNV.getValue();

        // combo box trang thai loc de xac dinh co xem du lieu khong
        String trangThaiLoc = cbxTrangThaiLocNV.getValue();

        System.out.println(maNV + " " + tenNV + " " + phongBan + " " + thangLbl + " " + namLbl);

        if (!DSCHITIETLUONGNHANVIEN.isEmpty()) {
            DSCHITIETLUONGNHANVIEN.clear();
        }


        ObservableList<ChiTietLuongNhanVien> listCTLNV = TinhLuongNhanVienDaoImpl.getInstance().locDuLieuDanhSachChiTietLuongNhanVienTuyChon(maNV, tenNV, phongBan, thangLbl, namLbl, trangThaiLoc);
        if (listCTLNV.isEmpty()) {
            Alerts.showAlert("Thông báo", "Lọc thành công", "Không tìm thấy bảng lương phù hợp.", Alert.AlertType.INFORMATION);
        } else {
            DSCHITIETLUONGNHANVIEN.addAll(listCTLNV);
            tblLuongNhanVien.setItems(DSCHITIETLUONGNHANVIEN);
            Alerts.showAlert("Thông báo", "Lọc thành công", "Tìm thấy " + listCTLNV.size() + " bảng lương.", Alert.AlertType.INFORMATION);
            ;
        }
        System.out.println("DS san pham sau khi loc:" + DSCHITIETLUONGNHANVIEN.toString() + "\n");
    }

    private void taiDuLieuTinhLuongNhanVienTuyChon(ObservableList<ChiTietLuongNhanVien> listTinhLuong) {
        if (!DSCHITIETLUONGNHANVIEN.isEmpty()) {
            DSCHITIETLUONGNHANVIEN.clear();
        }
        DSCHITIETLUONGNHANVIEN.addAll(listTinhLuong);
        tblLuongNhanVien.setItems(DSCHITIETLUONGNHANVIEN);
    }

    private void kiemTraBangLuongDuocChon() {

        ChiTietLuongNhanVien ctlnvDuocChon = tblLuongNhanVien.getSelectionModel().getSelectedItem();
        System.out.println(ctlnvDuocChon);
        if (ctlnvDuocChon != null) {
            boolean flag = TinhLuongNhanVienDaoImpl.getInstance().kiemTraBangLuongTonTai(UUIDUtils.taoMaBangLuongNhanVien(ctlnvDuocChon.getMaNhanVien().getMaNV()));
            System.out.println(flag);
            if (flag) {
                btnLuuBangLuongDuocChon.setDisable(true);
            } else {
                btnLuuBangLuongDuocChon.setDisable(false);
            }
        }
    }

    @FXML
    void kiemTraThang(ActionEvent event) {
//        kiemTraCamSuaDoi();
        //Khi nao hoan thanh chuong trinh bo xoa
    }

    private void kiemTraCamSuaDoi() {
        String thang = cbxLocThangTinhLuongNV.getValue();
        LocalDate lc = LocalDate.now();
        int thangDuocChon = 0;
        if (!cbxLocThangTinhLuongNV.getValue().equals("Trống")) {
            thangDuocChon = Integer.parseInt(cbxLocThangTinhLuongNV.getValue());
            int thangHienTai = lc.getMonthValue();

            if (thangHienTai > thangDuocChon && thangHienTai - thangDuocChon > 1) {
                btnLuuDanhSachBangLuong.setDisable(true);
                btnLuuBangLuongDuocChon.setDisable(true);
            } else if (thangHienTai == thangDuocChon) {
                btnLuuDanhSachBangLuong.setDisable(true);
                btnLuuBangLuongDuocChon.setDisable(true);
            } else {
                btnLuuDanhSachBangLuong.setDisable(false);
                btnLuuBangLuongDuocChon.setDisable(false);
            }
        }
    }

    @FXML
    void chiTietBangLuongNhanVienDuocChon(MouseEvent event) {
        kiemTraBangLuongDuocChon();
//        kiemTraCamSuaDoi();
    }


}
