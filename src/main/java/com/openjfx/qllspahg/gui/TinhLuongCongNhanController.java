package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;
import com.openjfx.qllspahg.dao.QuanLySanPhamDaoImpl;
import com.openjfx.qllspahg.dao.TinhLuongCongNhanDaoImpl;
import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.entity.model.ChiTietLuongCongNhan;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.*;


public class TinhLuongCongNhanController implements Initializable {

    @FXML
    private Button btnLuuDanhSachBangLuongCongNhan;

    @FXML
    private Button btnLuuBangLuongDuocChon;

    @FXML
    private ComboBox<String> cbxLocNamTinhLuongCN;

    @FXML
    private ComboBox<String> cbxLocThangTinhLuongCN;

    @FXML
    private ComboBox<String> cbxLocToSanXuatCN;

    @FXML
    private ComboBox<String> cbxTrangThaiTaoBangLuongCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colBHXHCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colBHYTCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colChiTieuPhanCongCN;

    @FXML
    private TableColumn<?, ?> colChuyenCanNangSuatCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colHoCN;

    @FXML
    private TableColumn<?, ?> colHoVaTenCN;

    @FXML
    private TableColumn<?, ?> colLuongCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colLuongNhanDuocCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colLuongThucTeCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colMaCN;

    @FXML
    private TableColumn<?, ?> colPhuCapCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colSoLuongLamCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colSoLuongLamCaBaCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colSoNgayCoPhepCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colSoNgayDiLamCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colSoNgayNghiCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> colSoNgayTangCaCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colTamUngCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colTenCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colTienNangSuatCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colTienConNhoCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colTienNhaTroCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, String> colToSanXuatCN;

    @FXML
    private TableColumn<?, ?> colTruyLanhCN;

    @FXML
    private TableColumn<ChiTietLuongCongNhan, Integer> collSTTLuongCN;

    @FXML
    private Label lblThangNamLuongCN;

    @FXML
    private TableView<ChiTietLuongCongNhan> tblLuongCongNhan;

    @FXML
    private TextField tfLocMaCN;

    @FXML
    private TextField tfLocTenCN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableLuongCongNhan();
    }

    public void khoiTaoTableLuongCongNhan() {

        //Khoi tao combox box trang thai loc
        khoiTaoComboxBoxTrangThaiBangLuong();

        //tat button
        btnLuuBangLuongDuocChon.setDisable(true);
        //Doi chu khi khong co du lieu tu tieng anh sang tieng viet
        tblLuongCongNhan.setPlaceholder(new Label("Không có dữ liệu\nVui lòng thực hiện lấy dữ liệu"));

        //KhoiTao label thang-nam bang luong
        khoiTaoLabelThangNamBangLuong();

        //chinh sua du lieu cho 2 cot
        khoiTaoComboBoxToSanXuat();

        //textField Loc Ma va ten
        tfLocMaCN.setPromptText("Nhập mã công nhân");
        tfLocTenCN.setPromptText("Nhập tên công nhân");
        tfLocMaCN.setText(null);
        tfLocTenCN.setText(null);


        //Khoi tao du lieu combobox thang nam
        khoiTaoComboBoxThangNam();

        //Khoi tao cot ao stt cho bang cham cong
        collSTTLuongCN.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });


        colMaCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getMaCN());
            }
        });

        colHoCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getHoCN());
            }
        });

        colTenCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getTenCN());
            }
        });


        colToSanXuatCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaCongNhan().getToSanXuat().getMaTSX());
            }
        });

        colSoNgayDiLamCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("soNgayDiLam"));
        colSoNgayTangCaCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("soNgayTangCa"));
        colSoNgayCoPhepCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("soNgayCoPhep"));
        colSoNgayNghiCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("soNgayNghi"));
        colChiTieuPhanCongCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("chiTieuPhanCong"));
        colSoLuongLamCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("soLuongLamDuoc"));
        colSoLuongLamCaBaCN.setCellValueFactory(new PropertyValueFactory<ChiTietLuongCongNhan, Integer>("soLuongLamDuocCaBa"));
        colLuongNhanDuocCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getLuongNhanDuoc()));
            }
        });

        colLuongThucTeCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getLuongThucTe()));
            }
        });

        colBHXHCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getPhiBHXH()));
            }
        });

        colBHYTCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getPhiBHYT()));
            }
        });

        colTamUngCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getMaTamUngCongNhan().getSoTienTamUng()) +
                        "\nNgày tạm ứng: " +
                        (
                                CongNhanStringCellDataFeatures.getValue().getMaTamUngCongNhan().getNgayTamUng() == null ?
                                        "" :
                                        DateUtils.formatStringVietnamDateCustom(CongNhanStringCellDataFeatures.getValue().getMaTamUngCongNhan().getNgayTamUng(), "dd-MM-yy"))
                );
            }
        });

        colTienNangSuatCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getMaPhuCapCongNhan().getTienChuyenCan()));
            }
        });

        colTienConNhoCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getMaPhuCapCongNhan().getTienConNho()));
            }
        });

        colTienNhaTroCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getMaPhuCapCongNhan().getTienNhaTro()));
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
        for (int i = 2000; i <= namHienTai; i++) {
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

    private void khoiTaoComboxBoxTrangThaiBangLuong(){
        ObservableList<String> listTrangThai = FXCollections.observableArrayList();
        listTrangThai.clear();
        cbxTrangThaiTaoBangLuongCN.setPromptText("Chọn trạng thái lọc");
        listTrangThai.addAll("Tất cả", "Chưa tạo");
        cbxTrangThaiTaoBangLuongCN.setItems(listTrangThai);
        cbxTrangThaiTaoBangLuongCN.getSelectionModel().select(0);
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
        String trangThaiLoc = cbxTrangThaiTaoBangLuongCN.getValue();

        System.out.println(maCN + " " + tenCN + " " + toSanXuat + " " + thangLbl + " " + namLbl);

        if (!DSCHITIETLUONGCONGNHAN.isEmpty()) {
            DSCHITIETLUONGCONGNHAN.clear();
        }


        ObservableList<ChiTietLuongCongNhan> listCTLCN = TinhLuongCongNhanDaoImpl.getInstance().locDuLieuDanhSachChiTietLuongCongNhanTuyChon(maCN, tenCN, toSanXuat, thangLbl, namLbl, trangThaiLoc);
        if (listCTLCN.isEmpty()) {
            Alerts.showAlert("Thông báo", "Lọc thành công", "Không tìm thấy bảng lương phù hợp.", Alert.AlertType.INFORMATION);
        } else {
            DSCHITIETLUONGCONGNHAN.addAll(listCTLCN);
            tblLuongCongNhan.setItems(DSCHITIETLUONGCONGNHAN);
            Alerts.showAlert("Thông báo", "Lọc thành công", "Tìm thấy " + listCTLCN.size() + " bảng lương.", Alert.AlertType.INFORMATION);
            ;
        }
        System.out.println("DS san pham sau khi loc:" + DSCHITIETLUONGCONGNHAN.toString() + "\n");
    }

    private void taiDuLieuTinhLuongCongNhanTuyChon(ObservableList<ChiTietLuongCongNhan> listTinhLuong) {
        if (!DSCHITIETLUONGCONGNHAN.isEmpty()) {
            DSCHITIETLUONGCONGNHAN.clear();
        }
        DSCHITIETLUONGCONGNHAN.addAll(listTinhLuong);
        tblLuongCongNhan.setItems(DSCHITIETLUONGCONGNHAN);
    }

    @FXML
    void luuDanhSachLuong(ActionEvent event) {
        int soLuongBangLuongTonTai = 0;
        String title = "Xác nhận";
        String content = "Bạn có chắc muốn lưu danh sách lương";


        if (!DSCHITIETLUONGCONGNHAN.isEmpty()) {
            for (ChiTietLuongCongNhan ctlcn : DSCHITIETLUONGCONGNHAN) {
                if (TinhLuongCongNhanDaoImpl.getInstance().kiemTraBangLuongTonTai(UUIDUtils.taoMaBangLuongCongNhan(ctlcn.getMaCongNhan().getMaCN()))) {
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
                    boolean sc = TinhLuongCongNhanDaoImpl.getInstance().luuDanhSachBangLuongCongNhan(DSCHITIETLUONGCONGNHAN);
                    int slThem = DSCHITIETLUONGCONGNHAN.size() - finalSoLuongBangLuongTonTai;
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
    void lamMoiDanhSach(ActionEvent event) {

    }

    @FXML
    void luuBangLuongCongNhanDuocChon(ActionEvent event) {
        ChiTietLuongCongNhan ctlcnDuocChon = tblLuongCongNhan.getSelectionModel().getSelectedItem();
        if (ctlcnDuocChon != null) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn lưu thông tin");
            rs.ifPresent(btnType -> {
                if (btnType == btnType.OK) {
                    TinhLuongCongNhanDaoImpl.getInstance().kiemTraBangLuongTonTai(UUIDUtils.taoMaBangLuongCongNhan(ctlcnDuocChon.getMaCongNhan().getMaCN()));
                    boolean sc = TinhLuongCongNhanDaoImpl.getInstance().luuBangLuongCongNhanDuocChon(ctlcnDuocChon);
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
    void chiTietBangLuongCongNhanDuocChon(MouseEvent event) {
        kiemTraBangLuongDuocChon();
        kiemTraCamSuaDoi();
    }

    @FXML
    void kiemTraThang(ActionEvent event) {
        //kiemTraCamSuaDoi();
        //Khi nao hoan thanh chuong trinh bo xoa
    }

    private void kiemTraBangLuongDuocChon() {
        ChiTietLuongCongNhan ctlcnDuocChon = tblLuongCongNhan.getSelectionModel().getSelectedItem();
        System.out.println(ctlcnDuocChon);
        if (ctlcnDuocChon != null) {
            boolean flag = TinhLuongCongNhanDaoImpl.getInstance().kiemTraBangLuongTonTai(UUIDUtils.taoMaBangLuongCongNhan(ctlcnDuocChon.getMaCongNhan().getMaCN()));
            if (flag) {
                btnLuuBangLuongDuocChon.setDisable(true);
            } else {
                btnLuuBangLuongDuocChon.setDisable(false);
            }
        }
    }

    private void kiemTraCamSuaDoi(){
        String nam = cbxLocNamTinhLuongCN.getValue();
        LocalDate lc = LocalDate.now();
        int thangDuocChon = 0;
        if(!cbxLocThangTinhLuongCN.getValue().equals("Trống")){
            thangDuocChon = Integer.parseInt(cbxLocThangTinhLuongCN.getValue());
            int thangHienTai = lc.getMonthValue();

            if(thangHienTai > thangDuocChon && thangHienTai - thangDuocChon > 1){
                btnLuuDanhSachBangLuongCongNhan.setDisable(true);
                btnLuuBangLuongDuocChon.setDisable(true);
            } else if (thangHienTai == thangDuocChon){
                btnLuuDanhSachBangLuongCongNhan.setDisable(true);
                btnLuuBangLuongDuocChon.setDisable(true);
            } else {
                btnLuuDanhSachBangLuongCongNhan.setDisable(false);
                btnLuuBangLuongDuocChon.setDisable(false);
            }
        }



    }

}
