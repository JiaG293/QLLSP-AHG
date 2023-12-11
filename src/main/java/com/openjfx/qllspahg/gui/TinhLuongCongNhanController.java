package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.TinhLuongCongNhanDaoImpl;
import com.openjfx.qllspahg.entity.model.ChiTietLuongCongNhan;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCHITIETLUONGCONGNHAN;


public class TinhLuongCongNhanController implements Initializable {


    @FXML
    private ComboBox<String> cbxLocNamTinhLuongCN;

    @FXML
    private ComboBox<String> cbxLocThangTinhLuongCN;

    @FXML
    private ComboBox<String> cbxLocToSanXuatCN;

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
        //Doi chu khi khong co du lieu tu tieng anh sang tieng viet
        tblLuongCongNhan.setPlaceholder(new Label("Không có dữ liệu\nVui lòng thực hiện lấy dữ liệu"));

        //KhoiTao label thang-nam bang luong
        khoiTaoLabelThangNamBangLuong();

        //chinh sua du lieu cho 2 cot
        khoiTaoComboBoxToSanXuat();

        //textField Loc Ma va ten
        tfLocMaCN.setPromptText("Nhập mã công nhân");
        tfLocTenCN.setPromptText("Nhập tên công nhân");


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
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getMaTamUngCongNhan().getSoTienTamUng()));
            }
        });

        colTienNangSuatCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietLuongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(Utils.formatCurrency(CongNhanStringCellDataFeatures.getValue().getMaPhuCapCongNhan().getTienNangSuat()));
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

    @FXML
    void layDuLieuLocLuongCongNhan(ActionEvent event) {
        String thang = cbxLocThangTinhLuongCN.getValue();
        String nam = cbxLocNamTinhLuongCN.getValue();
        System.out.println(thang + nam);
        taiDuLieuTinhLuongCongNhanTuyChon(TinhLuongCongNhanDaoImpl.getInstance().tinhLuongCongNhanTuDong(thang, nam));

        //Set label bang luong
        String thangLbl = cbxLocThangTinhLuongCN.getValue();
        String namLbl = cbxLocNamTinhLuongCN.getValue();
        lblThangNamLuongCN.setText("Bảng lương tháng " + thangLbl + "-" + namLbl);
    }

    private void taiDuLieuTinhLuongCongNhanTuyChon(ObservableList<ChiTietLuongCongNhan> listTinhLuong) {
        if (!DSCHITIETLUONGCONGNHAN.isEmpty()) {
            DSCHITIETLUONGCONGNHAN.clear();
        }
        DSCHITIETLUONGCONGNHAN.addAll(listTinhLuong);
        tblLuongCongNhan.setItems(DSCHITIETLUONGCONGNHAN);
    }

    @FXML
    void luuBangLuongCongNhan(MouseEvent event) {

    }

    @FXML
    void luuDanhSachLuong(ActionEvent event) {

    }

    @FXML
    void temp(ActionEvent event) {

    }

    @FXML
    void tinhLuongCongNhan(ActionEvent event) {

    }

    @FXML
    void xuatBangLuongCongNhan(ActionEvent event) {

    }

}
