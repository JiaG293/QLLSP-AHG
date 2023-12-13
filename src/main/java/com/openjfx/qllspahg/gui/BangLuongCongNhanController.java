package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.BangLuongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.entity.BangLuongCongNhan;
import com.openjfx.qllspahg.gui.util.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCHITIETLUONGCONGNHAN;

public class BangLuongCongNhanController implements Initializable {
    @FXML
    private ImageView img;

    @FXML
    private Button btnXacNhanThanhToan;

    @FXML
    private Button btnXuatBangLuong;

    @FXML
    private FileChooser fileChooser;

    @FXML
    private ComboBox<String> cbxLocNamTinhLuongCN;

    @FXML
    private ComboBox<String> cbxLocThangTinhLuongCN;

    @FXML
    private ComboBox<String> cbxLocToSanXuatCN;

    @FXML
    private ComboBox<String> cbxTrangThaiThanhToan;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colHoCN;

    @FXML
    private TableColumn<?, ?> colHoVaTenCN;

    @FXML
    private TableColumn<BangLuongCongNhan, Boolean> colLuaChon;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colLuongNhanDuoc;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colLuongThucTe;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colMaCN;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colNgayTao;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colNgayTra;

    @FXML
    private TableColumn<BangLuongCongNhan, Integer> colSTTLuong;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colTenCN;

    @FXML
    private TableColumn<BangLuongCongNhan, String> colToSanXuatCN;

    @FXML
    private TableColumn<BangLuongCongNhan, Boolean> colTrangThai;

    @FXML
    private Label lblThangNamLuongCN;

    @FXML
    private TableView<BangLuongCongNhan> tblBangLuongCongNhan;

    @FXML
    private TextField tfLocMaCN;

    @FXML
    private TextField tfLocTenCN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableBangLuongCongNhan();
    }

    public void khoiTaoTableBangLuongCongNhan() {


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

        //textfile
        tfLocTenCN.setPromptText("Nhập tên công nhân");
        tfLocMaCN.setPromptText("Nhập mã công nhân");
        tfLocMaCN.setText(null);
        tfLocTenCN.setText(null);

        colMaCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getMaCN());
            }
        });

        colHoCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getHoCN());
            }
        });

        colTenCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getTenCN());
            }
        });


        colToSanXuatCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getToSanXuat().getMaTSX());
            }
        });

        colNgayTao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(
                        (
                                CongNhanStringCellDataFeatures.getValue().getNgayNhanLuong() == null ?
                                        "" :
                                        DateUtils.formatStringVietnamDate(CongNhanStringCellDataFeatures.getValue().getNgayNhanLuong()))
                );

            }
        });
        colNgayTra.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDate(CongNhanStringCellDataFeatures.getValue().getNgayTinhLuong()));
            }
        });
        colLuongNhanDuoc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getLuongCN()));
            }
        });

        colLuongThucTe.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getTongLuongCN()));
            }
        });

        colTrangThai.setEditable(false);
        colTrangThai.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangLuongCongNhan, Boolean> param) {
                BangLuongCongNhan blcn = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(blcn.getTrangThaiLuong());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        blcn.setTrangThaiLuong(newValue);
                    }
                });
                return booleanProp;
            }
        });

        colTrangThai.setCellFactory(new Callback<TableColumn<BangLuongCongNhan, Boolean>, TableCell<BangLuongCongNhan, Boolean>>() {
            @Override
            public TableCell<BangLuongCongNhan, Boolean> call(TableColumn<BangLuongCongNhan, Boolean> p) {
                CheckBoxTableCell<BangLuongCongNhan, Boolean> cell = new CheckBoxTableCell<BangLuongCongNhan, Boolean>();
                cell.setAlignment(Pos.CENTER);
                cell.setDisable(true);
                return cell;
            }
        });

        colLuaChon.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangLuongCongNhan, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangLuongCongNhan, Boolean> param) {
                BangLuongCongNhan blcn = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(blcn.isLuaChon());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        blcn.setLuaChon(newValue);
                    }
                });
                return booleanProp;
            }
        });

        colLuaChon.setCellFactory(new Callback<TableColumn<BangLuongCongNhan, Boolean>, TableCell<BangLuongCongNhan, Boolean>>() {
            @Override
            public TableCell<BangLuongCongNhan, Boolean> call(TableColumn<BangLuongCongNhan, Boolean> p) {
                CheckBoxTableCell<BangLuongCongNhan, Boolean> cell = new CheckBoxTableCell<BangLuongCongNhan, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });


    }

    private void khoiTaoLabelThangNamBangLuong() {
        String thangLbl = cbxLocThangTinhLuongCN.getValue();
        String namLbl = cbxLocNamTinhLuongCN.getValue();
        LocalDate dateHienTai = LocalDate.now();
        if (thangLbl == null || thangLbl.equals("Trống") || thangLbl.isEmpty()) {
            thangLbl = String.valueOf(dateHienTai.getMonthValue() - 1);
        }
        if (namLbl == null || namLbl.equals("Trống") || namLbl.isEmpty()) {
            namLbl = String.valueOf(dateHienTai.getYear());
        }
        lblThangNamLuongCN.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);
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
        cbxLocThangTinhLuongCN.setItems(thang);
        cbxLocThangTinhLuongCN.setPromptText("Chọn tháng");
        cbxLocThangTinhLuongCN.setValue(String.valueOf(dateHienTai.getMonthValue() - 1)); // tra ve thang truoc de tinh bang luong
        int namHienTai = YearMonth.now().getYear();
        for (int i = 2000; i <= namHienTai + 1; i++) {
            nam.add(String.valueOf(i));
        }
        cbxLocNamTinhLuongCN.setItems(nam);
        cbxLocNamTinhLuongCN.setPromptText("Chọn năm");
        cbxLocNamTinhLuongCN.setValue(String.valueOf(dateHienTai.getYear())); // tra ve thang truoc de tinh bang luong
    }

    private void khoiTaoComboBoxToSanXuat() {
        cbxLocToSanXuatCN.setPromptText("Chọn tổ sản xuất");
        ObservableList<String> listTSX = FXCollections.observableArrayList();
        listTSX.clear();
        listTSX.add("Trống");
        ObservableList<String> listTsx = ChamCongCongNhanDaoImpl.getInstance().layDuLieuTatCaToSanXuatCongNhan();
        if (!listTsx.isEmpty() || listTsx != null) {
            listTSX.addAll(listTsx);
        } else {
            cbxLocToSanXuatCN.setPromptText("Không có dữ liệu");
        }
        cbxLocToSanXuatCN.setItems(listTSX);
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
    void capNhatThanhToanLuong(ActionEvent event) {
        String title = "Xác nhận";
        String content = "Bạn có chắc muốn thanh toán các bảng lương đã chọn\n";


        if (!DSBANGLUONGCNCHON.isEmpty()) {

            Optional<ButtonType> rs = Alerts.showConfirmation(title, content);
            rs.ifPresent(btnType -> {
                if (btnType == btnType.OK) {
                    int soLuongCapNhat = 0;
                    for (BangLuongCongNhan blcn : DSBANGLUONGCNCHON) {
                        if (!BangLuongCongNhanDaoImpl.getInstance().kiemTraChiTraLuong(blcn.getMaBLCN()))
                            soLuongCapNhat += 1;
                    }
                    boolean sc = BangLuongCongNhanDaoImpl.getInstance().capNhatBangLuong(DSBANGLUONGCNCHON);
                    if (sc) {
                        Alerts.showAlert("Thông báo", "Thành công", "Đã thanh toán " + soLuongCapNhat + "/" + DSBANGLUONGCNCHON.size() + " bảng lương", Alert.AlertType.INFORMATION);
                        layDuLieuBangLuongCongNhan();
                    }
                }
            });

        } else {
            Alerts.showAlert("Cảnh báo", "Danh sách bảng lương rỗng", "Vui lòng thực hiện chọn bảng lương cần thanh toán", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void bangLuongDuocChon(MouseEvent event) {
        BangLuongCongNhan blcn = tblBangLuongCongNhan.getSelectionModel().getSelectedItem();
        if (blcn != null) {
            for (BangLuongCongNhan bl : DSBANGLUONGCN) {
                if (bl.getMaBLCN().equals(blcn.getMaBLCN()) && bl.isLuaChon()) {
                    bl.setLuaChon(false);
                    DSBANGLUONGCNCHON.removeIf(elem -> elem.getMaBLCN().equals(blcn.getMaBLCN()));
                } else if (bl.getMaBLCN().equals(blcn.getMaBLCN()) && !bl.isLuaChon()) {
                    bl.setLuaChon(true);
                    DSBANGLUONGCNCHON.add(bl);
                }
                tblBangLuongCongNhan.refresh();
            }
        }

        System.out.println("bang luong chon " + DSBANGLUONGCNCHON);
    }

    @FXML
    void kiemTraThang(ActionEvent event) {

    }

    @FXML
    void lamMoiDanhSachBangLuong(ActionEvent event) {
        layDuLieuBangLuongCongNhan();
    }

    private boolean layDuLieuBangLuongCongNhan() {
        String thang = cbxLocThangTinhLuongCN.getValue();
        String nam = cbxLocNamTinhLuongCN.getValue();
        //taiDuLieuTinhLuongCongNhanTuyChon(TinhLuongCongNhanDaoImpl.getInstance().tinhLuongCongNhanTuDong(thang, nam));

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongCN.getValue();
        String namLbl = cbxLocNamTinhLuongCN.getValue();
        lblThangNamLuongCN.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);

        //Du lieu loc textfield ma, ten
        String maCN = tfLocMaCN.getText();
        String tenCN = tfLocTenCN.getText();
        String toSanXuat = cbxLocToSanXuatCN.getValue();

        // combo box trang thai loc de xac dinh co xem du lieu khong
        String trangThaiLuong = cbxTrangThaiThanhToan.getValue();

        System.out.println(maCN + " " + tenCN + " " + toSanXuat + " " + thangLbl + " " + namLbl);

        if (!DSBANGLUONGCN.isEmpty()) {
            DSBANGLUONGCN.clear();
            DSBANGLUONGCNCHON.clear();
        }


        ObservableList<BangLuongCongNhan> listBLCN = BangLuongCongNhanDaoImpl.getInstance().locDuLieuDanhSachBangLuongCongNhan(maCN, tenCN, toSanXuat, thangLbl, namLbl, trangThaiLuong);
        if (listBLCN.isEmpty()) {
            return false;
        } else {
            DSBANGLUONGCN.addAll(listBLCN);
            tblBangLuongCongNhan.setItems(DSBANGLUONGCN);
            return true;
        }
    }

    @FXML
    void layDuLieuLocLuongCongNhan(ActionEvent event) {
        String thang = cbxLocThangTinhLuongCN.getValue();
        String nam = cbxLocNamTinhLuongCN.getValue();
        //taiDuLieuTinhLuongCongNhanTuyChon(TinhLuongCongNhanDaoImpl.getInstance().tinhLuongCongNhanTuDong(thang, nam));

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongCN.getValue();
        String namLbl = cbxLocNamTinhLuongCN.getValue();
        lblThangNamLuongCN.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);

        //Du lieu loc textfield ma, ten
        String maCN = tfLocMaCN.getText();
        String tenCN = tfLocTenCN.getText();
        String toSanXuat = cbxLocToSanXuatCN.getValue();

        // combo box trang thai loc de xac dinh co xem du lieu khong
        String trangThaiLuong = cbxTrangThaiThanhToan.getValue();

        System.out.println(maCN + " " + tenCN + " " + toSanXuat + " " + thangLbl + " " + namLbl);

        if (!DSBANGLUONGCN.isEmpty()) {
            DSBANGLUONGCN.clear();
            DSBANGLUONGCNCHON.clear();
        }


        ObservableList<BangLuongCongNhan> listBLCN = BangLuongCongNhanDaoImpl.getInstance().locDuLieuDanhSachBangLuongCongNhan(maCN, tenCN, toSanXuat, thangLbl, namLbl, trangThaiLuong);
        if (listBLCN.isEmpty()) {
            Alerts.showAlert("Thông báo", "Lọc thành công", "Không tìm thấy bảng lương phù hợp.", Alert.AlertType.INFORMATION);
        } else {
            DSBANGLUONGCN.addAll(listBLCN);
            tblBangLuongCongNhan.setItems(DSBANGLUONGCN);
            Alerts.showAlert("Thông báo", "Lọc thành công", "Tìm thấy " + listBLCN.size() + " bảng lương.", Alert.AlertType.INFORMATION);
        }
        System.out.println("DS bang luong cn sau khi loc:" + DSCHITIETLUONGCONGNHAN.toString() + "\n");

        tblBangLuongCongNhan.setItems(DSBANGLUONGCN);
    }


    @FXML
    void xuatBangLuongDuocChon(ActionEvent event) throws IOException {
        if(!DSBANGLUONGCNCHON.isEmpty()){
            Stage stage = (Stage) tblBangLuongCongNhan.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Lưu Tệp");
            FileChooser.ExtensionFilter filePDF = new FileChooser.ExtensionFilter("Tệp PDF", "*.pdf");
            fileChooser.getExtensionFilters().add(filePDF);
            fileChooser.setInitialFileName("BangLuongCongNhan_" + LocalDate.now());
            File selectedFile = fileChooser.showSaveDialog(stage);
            if (selectedFile != null) {
                String filePath = selectedFile.getAbsolutePath();
                PDFUtils.taoPhieuLuongCongNhan(filePath, DSBANGLUONGCNCHON);
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


    @FXML
    void chonTatCaCacHang(ActionEvent event) {

        for (BangLuongCongNhan bl : DSBANGLUONGCN) {
            if (bl.isLuaChon()) {
                bl.setLuaChon(false);
                DSBANGLUONGCNCHON.removeIf(elem -> elem.getMaBLCN().equals(bl.getMaBLCN()));
            } else {
                bl.setLuaChon(true);
                DSBANGLUONGCNCHON.add(bl);
            }
            tblBangLuongCongNhan.refresh();
        }

        System.out.println("Danh sach bang luong duoc chon :" + DSBANGLUONGCNCHON.size());
    }


}
