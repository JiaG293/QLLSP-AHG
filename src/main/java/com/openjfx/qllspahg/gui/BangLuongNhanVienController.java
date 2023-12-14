package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.BangLuongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.BangLuongNhanVienDaoImpl;
import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;
import com.openjfx.qllspahg.entity.BangLuongCongNhan;
import com.openjfx.qllspahg.entity.BangLuongNhanVien;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.PDFUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSBANGLUONGNV;

public class BangLuongNhanVienController implements Initializable {
    @FXML
    private Button btnXacNhanThanhToan;

    @FXML
    private Button btnXuatBangLuong;

    @FXML
    private ComboBox<String> cbxLocNamTinhLuongNV;

    @FXML
    private ComboBox<String> cbxLocPhongBanNV;

    @FXML
    private ComboBox<String> cbxLocThangTinhLuongNV;

    @FXML
    private ComboBox<String> cbxTrangThaiThanhToan;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colHoNV;

    @FXML
    private TableColumn<?, ?> colHoVaTenNV;

    @FXML
    private TableColumn<BangLuongNhanVien, Boolean> colLuaChon;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colLuongNhanDuoc;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colLuongThucTe;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colMaNV;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colNgayTao;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colNgayTra;

    @FXML
    private TableColumn<BangLuongNhanVien, Integer> colSTTLuong;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colTenNV;

    @FXML
    private TableColumn<BangLuongNhanVien, String> colPhongBanNV;

    @FXML
    private TableColumn<BangLuongNhanVien, Boolean> colTrangThai;

    @FXML
    private Label lblThangNamLuongNV;

    @FXML
    private TableView<BangLuongNhanVien> tblBangLuongNhanVien;

    @FXML
    private TextField tfLocMaNV;

    @FXML
    private TextField tfLocTenNV;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableBangLuongNhanVien();
    }

    public void khoiTaoTableBangLuongNhanVien() {
        colSTTLuong.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });

        //Khoi tao combo box
        khoiTaoComboBoxThangNam();
        khoiTaoLabelThangNamBangLuong();
        khoiTaoComboxBoxTrangThaiBangLuong();
        khoiTaoComboBoxToSanXuat();


        //text field
        tfLocTenNV.setPromptText("Nhập tên nhân viên");
        tfLocMaNV.setPromptText("Nhập mã nhân viên");
        tfLocMaNV.setText(null);
        tfLocTenNV.setText(null);

        colMaNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getMaNV());
            }
        });

        colHoNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getHoNV());
            }
        });

        colTenNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getTenNV());
            }
        });


        colPhongBanNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(NhanVienStringCellDataFeatures.getValue().getMaNhanVien().getPhongBan().getTenPB());
            }
        });

        colNgayTao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(
                        (
                                NhanVienStringCellDataFeatures.getValue().getNgayTinhLuong() == null ?
                                        "" :
                                        DateUtils.formatStringVietnamDate(NhanVienStringCellDataFeatures.getValue().getNgayTinhLuong()))
                );

            }
        });
        colNgayTra.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty((
                        NhanVienStringCellDataFeatures.getValue().getNgayNhanLuong() == null ?
                                "" :
                                DateUtils.formatStringVietnamDate(NhanVienStringCellDataFeatures.getValue().getNgayNhanLuong())));
            }
        });
        colLuongNhanDuoc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getLuongNV()));
            }
        });

        colLuongThucTe.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongNhanVien, String> NhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(NhanVienStringCellDataFeatures.getValue().getTongLuongNV()));
            }
        });

        colTrangThai.setEditable(false);
        colTrangThai.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangLuongNhanVien, Boolean> param) {
                BangLuongNhanVien blnv = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(blnv.getTrangThaiLuong());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        blnv.setTrangThaiLuong(newValue);
                    }
                });
                return booleanProp;
            }
        });

        colTrangThai.setCellFactory(new Callback<TableColumn<BangLuongNhanVien, Boolean>, TableCell<BangLuongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangLuongNhanVien, Boolean> call(TableColumn<BangLuongNhanVien, Boolean> p) {
                CheckBoxTableCell<BangLuongNhanVien, Boolean> cell = new CheckBoxTableCell<BangLuongNhanVien, Boolean>();
                cell.setAlignment(Pos.CENTER);
                cell.setDisable(true);
                return cell;
            }
        });

        colLuaChon.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangLuongNhanVien, Boolean> param) {
                BangLuongNhanVien blnv = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(blnv.isLuaChon());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        blnv.setLuaChon(newValue);
                    }
                });
                return booleanProp;
            }
        });

        colLuaChon.setCellFactory(new Callback<TableColumn<BangLuongNhanVien, Boolean>, TableCell<BangLuongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangLuongNhanVien, Boolean> call(TableColumn<BangLuongNhanVien, Boolean> p) {
                CheckBoxTableCell<BangLuongNhanVien, Boolean> cell = new CheckBoxTableCell<BangLuongNhanVien, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });


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
        lblThangNamLuongNV.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);
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

    private void khoiTaoComboBoxToSanXuat() {
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

    private void khoiTaoComboxBoxTrangThaiBangLuong() {
        ObservableList<String> listTrangThai = FXCollections.observableArrayList();
        listTrangThai.clear();
        cbxTrangThaiThanhToan.setPromptText("Chọn trạng thái lọc");
        listTrangThai.addAll("Tất cả", "Đã thanh toán", "Chưa thanh toán");
        cbxTrangThaiThanhToan.setItems(listTrangThai);
        cbxTrangThaiThanhToan.getSelectionModel().select(0);
    }


    @FXML
    void bangLuongDuocChon(MouseEvent event) {
        BangLuongNhanVien blcn = tblBangLuongNhanVien.getSelectionModel().getSelectedItem();
        if (blcn != null) {
            for (BangLuongNhanVien bl : DSBANGLUONGNV) {
                if (bl.getMaBLNV().equals(blcn.getMaBLNV()) && bl.isLuaChon()) {
                    bl.setLuaChon(false);
                    DSBANGLUONGNVCHON.removeIf(elem -> elem.getMaBLNV().equals(blcn.getMaBLNV()));
                } else if (bl.getMaBLNV().equals(blcn.getMaBLNV()) && !bl.isLuaChon()) {
                    bl.setLuaChon(true);
                    DSBANGLUONGNVCHON.add(bl);
                }
                tblBangLuongNhanVien.refresh();
            }
        }

        System.out.println("bang luong chon " + DSBANGLUONGNVCHON);
    }

    @FXML
    void capNhatThanhToanLuong(ActionEvent event) {
        String title = "Xác nhận";
        String content = "Bạn có chắc muốn thanh toán các bảng lương đã chọn\n";


        if (!DSBANGLUONGNVCHON.isEmpty()) {

            Optional<ButtonType> rs = Alerts.showConfirmation(title, content);
            rs.ifPresent(btnType -> {
                if (btnType == btnType.OK) {
                    int soLuongCapNhat = 0;
                    for (BangLuongNhanVien blnv : DSBANGLUONGNVCHON) {
                        if (!BangLuongNhanVienDaoImpl.getInstance().kiemTraChiTraLuong(blnv.getMaBLNV()))
                            soLuongCapNhat += 1;
                    }
                    boolean sc = BangLuongNhanVienDaoImpl.getInstance().capNhatBangLuong(DSBANGLUONGNVCHON);
                    if (sc) {
                        Alerts.showAlert("Thông báo", "Thành công", "Đã thanh toán " + soLuongCapNhat + "/" + DSBANGLUONGNVCHON.size() + " bảng lương", Alert.AlertType.INFORMATION);
                        layDuLieuBangLuongNhanVien();
                    }
                }
            });

        } else {
            Alerts.showAlert("Cảnh báo", "Danh sách bảng lương rỗng", "Vui lòng thực hiện chọn bảng lương cần thanh toán", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void chonTatCaCacHang(ActionEvent event) {
        for (BangLuongNhanVien bl :  DSBANGLUONGNV) {
            if (bl.isLuaChon()) {
                bl.setLuaChon(false);
                DSBANGLUONGNVCHON.removeIf(elem -> elem.getMaBLNV().equals(bl.getMaBLNV()));
            } else {
                bl.setLuaChon(true);
                DSBANGLUONGNVCHON.add(bl);
            }
            tblBangLuongNhanVien.refresh();
        }

        System.out.println("Danh sach bang luong duoc chon :" + DSBANGLUONGNVCHON.size());
    }

    @FXML
    void kiemTraThang(ActionEvent event) {

    }

    @FXML
    void lamMoiDanhSachBangLuong(ActionEvent event) {
        layDuLieuBangLuongNhanVien();
    }

    @FXML
    void layDuLieuLocLuongNhanVien(ActionEvent event) {
        String thang = String.valueOf(Integer.parseInt(Integer.parseInt(cbxLocThangTinhLuongNV.getValue()) == 12 ? String.valueOf(0) : cbxLocThangTinhLuongNV.getValue()) + 1);
        String nam = cbxLocNamTinhLuongNV.getValue();
        //taiDuLieuTinhLuongCongNhanTuyChon(TinhLuongCongNhanDaoImpl.getInstance().tinhLuongCongNhanTuDong(thang, nam));

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongNV.getValue();
        String namLbl = cbxLocNamTinhLuongNV.getValue();
        lblThangNamLuongNV.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);

        //Du lieu loc textfield ma, ten
        String maNV = tfLocMaNV.getText();
        String tenNV = tfLocTenNV.getText();
        String phongBan = cbxLocPhongBanNV.getValue();

        // combo box trang thai loc de xac dinh co xem du lieu khong
        String trangThaiLuong = cbxTrangThaiThanhToan.getValue();

        System.out.println(maNV + " " + tenNV + " " + phongBan + " " + thangLbl + " " + namLbl);

        if (!DSBANGLUONGNV.isEmpty()) {
            DSBANGLUONGNV.clear();
            DSBANGLUONGNVCHON.clear();
        }


        ObservableList<BangLuongNhanVien> listBLNV = BangLuongNhanVienDaoImpl.getInstance().locDuLieuDanhSachBangLuongNhanVien(maNV, tenNV, phongBan, thang, namLbl, trangThaiLuong);
        if (listBLNV.isEmpty()) {
            Alerts.showAlert("Thông báo", "Lọc thành công", "Không tìm thấy bảng lương phù hợp.", Alert.AlertType.INFORMATION);
        } else {
            DSBANGLUONGNV.addAll(listBLNV);
            tblBangLuongNhanVien.setItems(DSBANGLUONGNV);
            Alerts.showAlert("Thông báo", "Lọc thành công", "Tìm thấy " + listBLNV.size() + " bảng lương.", Alert.AlertType.INFORMATION);
        }
        System.out.println("DS bang luong cn sau khi loc:" + DSCHITIETLUONGNHANVIEN.toString() + "\n");

        tblBangLuongNhanVien.setItems(DSBANGLUONGNV);
    }

    @FXML
    void xuatBangLuongDuocChon(ActionEvent event) {
        if(!DSBANGLUONGNVCHON.isEmpty()){
            Stage stage = (Stage) tblBangLuongNhanVien.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Lưu Tệp");
            FileChooser.ExtensionFilter filePDF = new FileChooser.ExtensionFilter("Tệp PDF", "*.pdf");
            fileChooser.getExtensionFilters().add(filePDF);
            fileChooser.setInitialFileName("BangLuongNhanVien_" + LocalDate.now());
            File selectedFile = fileChooser.showSaveDialog(stage);
            if (selectedFile != null) {
                String filePath = selectedFile.getAbsolutePath();
                PDFUtils.taoPhieuLuongNhanVien(filePath, DSBANGLUONGNVCHON);
                Alerts.showAlert("Thông báo", "Thành công", "File được lưu tại " + filePath + "\nĐã sao chép vào bảng tạm", Alert.AlertType.INFORMATION);

                //Sao chép đường dẫn vừa lưu vào bảng tạm
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(filePath);
                clipboard.setContent(content);
            }
        } else {
            Alerts.showAlert("Cảnh báo", "Rỗng", "Không có dữ liệu để in", Alert.AlertType.WARNING);
        }
    }

    private boolean layDuLieuBangLuongNhanVien(){
        String thang = cbxLocThangTinhLuongNV.getValue();
        String nam = cbxLocNamTinhLuongNV.getValue();

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongNV.getValue();
        String namLbl = cbxLocNamTinhLuongNV.getValue();
        lblThangNamLuongNV.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);

        //Du lieu loc textfield ma, ten
        String maNV = tfLocMaNV.getText();
        String tenNV = tfLocTenNV.getText();
        String phongBan = cbxLocPhongBanNV.getValue();

        // combo box trang thai loc de xac dinh co xem du lieu khong
        String trangThaiLuong = cbxTrangThaiThanhToan.getValue();

        System.out.println(maNV + " " + tenNV + " " + phongBan + " " + thangLbl + " " + namLbl);

        if (!DSBANGLUONGNV.isEmpty()) {
            DSBANGLUONGNV.clear();
            DSBANGLUONGNVCHON.clear();
        }


        ObservableList<BangLuongNhanVien> listBLNV = BangLuongNhanVienDaoImpl.getInstance().locDuLieuDanhSachBangLuongNhanVien(maNV, tenNV, phongBan, thangLbl, namLbl, trangThaiLuong);
        if (listBLNV.isEmpty()) {
            return false;
        } else {
            DSBANGLUONGNV.addAll(listBLNV);
            tblBangLuongNhanVien.setItems(DSBANGLUONGNV);
            return true;
        }
    }
}
