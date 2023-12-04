package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;
import com.openjfx.qllspahg.dao.DanhSachHopDongImpl;
import com.openjfx.qllspahg.entity.BangChamCongCongNhan;
import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCHAMCONGCONGNHAN;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCHAMCONGCONGNHANUPDATE;

public class ChamCongCongNhanController implements Initializable {

    @FXML
    private ComboBox<String> cbxLocToSanXuat;

    @FXML
    private TableColumn<BangChamCongCongNhan, String> colHoVaTen;

    @FXML
    private TableColumn<BangChamCongCongNhan, String> colMaCN;

    @FXML
    private TableColumn<BangChamCongCongNhan, String> colNgayChamCong;

    @FXML
    private TableColumn<BangChamCongCongNhan, Boolean> colNghiPhep;

    @FXML
    private TableColumn<BangChamCongCongNhan, Integer> colSTTChamCongCN;

    @FXML
    private TableColumn<BangChamCongCongNhan, Integer> colSoLuongLam;

    @FXML
    private TableColumn<BangChamCongCongNhan, Integer> colSoLuongLamTangCa;

    @FXML
    private TableColumn<BangChamCongCongNhan, String> colToSanXuat;

    @FXML
    private TableView<BangChamCongCongNhan> tblBangChamCongCongNhan;

    @FXML
    private DatePicker datepickNgayChamCong;

    @FXML
    private TextField tfLocHoTenCN;

    @FXML
    private TextField tfLocMaCN;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoTableChamCongCongNhan();
    }

    public void khoiTaoTableChamCongCongNhan() {
        //Doi chu khi khong co du lieu tu tieng anh sang tieng viet
        tblBangChamCongCongNhan.setPlaceholder(new Label("Không có dữ liệu\nVui lòng thực hiện lấy dữ liệu"));


        //chinh sua du lieu cho 2 cot
        chinhSuaDuLieuTableView();

        //textField Loc Ma va ten
        tfLocMaCN.setPromptText("Nhập mã công nhân");
        tfLocHoTenCN.setPromptText("Nhập tên công nhân");


        //Khoi tao ngay duoc chon
        datepickNgayChamCong.setValue(LocalDate.parse(Utils.taoNgayHomTruoc()));

        //Khoi tao du lieu combobox to san xuat
        cbxLocToSanXuat.setPromptText("Chọn tổ sản xuất");
        taiDuLieuComboBoxToSanXuat();

        //Khoi tao cot ao stt cho bang cham cong
        colSTTChamCongCN.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });


        colMaCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaBangPhanCongCongNhan().getMaCongNhan().getMaCN());
            }
        });
        colHoVaTen.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(
                        CongNhanStringCellDataFeatures.getValue().getMaBangPhanCongCongNhan().getMaCongNhan().getHoCN()
                                + " " + CongNhanStringCellDataFeatures.getValue().getMaBangPhanCongCongNhan().getMaCongNhan().getTenCN()
                );
            }
        });
        colToSanXuat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(CongNhanStringCellDataFeatures.getValue().getMaBangPhanCongCongNhan().getMaCongNhan().getToSanXuat().getTenTSX());
            }
        });

        colNgayChamCong.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongCongNhan, String> CongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDate(CongNhanStringCellDataFeatures.getValue().getNgayChamCong()));
            }
        });

        colSoLuongLam.setCellValueFactory(new PropertyValueFactory<BangChamCongCongNhan, Integer>("soLuongLamDuoc"));


        colSoLuongLamTangCa.setCellValueFactory(new PropertyValueFactory<BangChamCongCongNhan, Integer>("soLuongLamCaBa"));



        //tao gia tri cho cot nghi phep
        colNghiPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongCongNhan, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongCongNhan, Boolean> param) {
                BangChamCongCongNhan bcccn = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(bcccn.isNghiPhep());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        bcccn.setNghiPhep(newValue);
                        if (bcccn.isNghiPhep() == true) {
                            // neu gia tri cua o nghi phep la true thi dat gia tri 2 o kia la 0
                            bcccn.setSoLuongLamDuoc(0);
                            bcccn.setSoLuongLamCaBa(0);
                            //Lam moi table view
                            tblBangChamCongCongNhan.refresh();
                        }
                    }
                });
                return booleanProp;
            }
        });


        colNghiPhep.setCellFactory(new Callback<TableColumn<BangChamCongCongNhan, Boolean>, TableCell<BangChamCongCongNhan, Boolean>>() {
            @Override
            public TableCell<BangChamCongCongNhan, Boolean> call(TableColumn<BangChamCongCongNhan, Boolean> p) {
                CheckBoxTableCell<BangChamCongCongNhan, Boolean> cell = new CheckBoxTableCell<BangChamCongCongNhan, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });


    }

    private void taiDuLieuChamCongCongNhan() {
        if (!DSCHAMCONGCONGNHAN.isEmpty() || !DSCHAMCONGCONGNHANUPDATE.isEmpty()) {
            DSCHAMCONGCONGNHAN.clear();
            DSCHAMCONGCONGNHANUPDATE.clear();
        }
        DSCHAMCONGCONGNHAN.addAll(ChamCongCongNhanDaoImpl.getInstance().layDuLieuBangChamCongCongNhan());
        DSCHAMCONGCONGNHANUPDATE.addAll(DSCHAMCONGCONGNHAN);

        tblBangChamCongCongNhan.setItems(DSCHAMCONGCONGNHAN);
        System.out.println(DSCHAMCONGCONGNHAN.toString());

    }

    private void taiDuLieuChamCongCongNhanTuyChon(ObservableList<BangChamCongCongNhan> listBCCN) {
        if (!DSCHAMCONGCONGNHAN.isEmpty() || !DSCHAMCONGCONGNHANUPDATE.isEmpty()) {
            DSCHAMCONGCONGNHAN.clear();
            DSCHAMCONGCONGNHANUPDATE.clear();
        }
        DSCHAMCONGCONGNHAN.addAll(listBCCN);
        DSCHAMCONGCONGNHANUPDATE.addAll(DSCHAMCONGCONGNHAN);

        tblBangChamCongCongNhan.setItems(DSCHAMCONGCONGNHAN);
        System.out.println(DSCHAMCONGCONGNHAN.toString());

    }

    private void chinhSuaDuLieuTableView() {
        colSoLuongLam.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colSoLuongLam.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setSoLuongLamDuoc(e.getNewValue()));

        colSoLuongLamTangCa.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colSoLuongLamTangCa.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setSoLuongLamCaBa(e.getNewValue()));
    }

    private void taiDuLieuComboBoxToSanXuat() {
        cbxLocToSanXuat.setPromptText("Chọn tổ sản xuất");
        ObservableList<String> listTenTSX = FXCollections.observableArrayList();
        listTenTSX.clear();
        listTenTSX.add("Trống");
        ObservableList<String> listTsx = ChamCongCongNhanDaoImpl.getInstance().layDuLieuToSanXuatCongNhanDuocPhanCong(String.valueOf(datepickNgayChamCong.getValue()));
        if (!listTsx.isEmpty() || listTsx != null) {
            listTenTSX.addAll(listTsx);
        } else {
            cbxLocToSanXuat.setPromptText("Không có tổ được phân công");
        }

        cbxLocToSanXuat.setItems(listTenTSX);
    }


    @FXML
    void aaTest(ActionEvent event) {
//        System.out.println("DS:" + DSCHAMCONGCONGNHAN);
//        System.out.println("DSUPDATE:" + DSCHAMCONGCONGNHANUPDATE);
//        System.out.println(String.valueOf(datepickNgayChamCong.getValue()));
//        System.out.println("OBJ:" + tblBangChamCongCongNhan.getSelectionModel().getSelectedItem());
        System.out.println(String.valueOf(datepickNgayChamCong.getValue()));
    }

    @FXML
    void lamMoiDuLieuTableView(ActionEvent event) {
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận lưu", "Bạn có chắc lưu bảng chấm công\nTất cả dữ liệu hiện hành sẽ bị làm mới!!");
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {

                if (!DSCHAMCONGCONGNHAN.isEmpty() || !DSCHAMCONGCONGNHANUPDATE.isEmpty()) {
                    DSCHAMCONGCONGNHAN.clear();
                    DSCHAMCONGCONGNHANUPDATE.clear();
                }
                DSCHAMCONGCONGNHAN.addAll(ChamCongCongNhanDaoImpl.getInstance().layDuLieuBangChamCongCongNhanTheoNgayChamCong(String.valueOf(datepickNgayChamCong.getValue())));
                DSCHAMCONGCONGNHANUPDATE.addAll(DSCHAMCONGCONGNHAN);

                tblBangChamCongCongNhan.setItems(DSCHAMCONGCONGNHAN);
                System.out.println(DSCHAMCONGCONGNHAN.toString());
            }
        });
    }

    @FXML
    private void taiDuLieuToSanXuatKhiChonNgayChamCong(ActionEvent event) {
        LocalDate ndc = datepickNgayChamCong.getValue();
        System.out.println("Ngay duoc chon cham cong: " + ndc);
        try {
            //Chi tai du lieu to san xuat co phan cong thay vi tai toan bo to san xuat
            taiDuLieuComboBoxToSanXuat();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void layDuLieuLocChamCongCongNhan(ActionEvent event) {
        DSCHAMCONGCONGNHAN.clear();
        DSCHAMCONGCONGNHANUPDATE.clear();

        //get gia tri tung truong
        String maCN = tfLocMaCN.getText();
        String tenCN = tfLocHoTenCN.getText();
        String tenTSX = cbxLocToSanXuat.getValue();
        String ngayCC = Utils.dinhDangNgayHienTai(datepickNgayChamCong.getValue(), "yyyy-MM-dd");

        ObservableList<BangChamCongCongNhan> listBCCCN = FXCollections.observableArrayList();
        listBCCCN.addAll(ChamCongCongNhanDaoImpl.getInstance().locBangChamCongCongNhan(maCN, tenCN, tenTSX, ngayCC));
        if (listBCCCN.isEmpty()) {
            Alerts.showAlert("Thông báo", "Không có dữ liệu", "Dữ liệu tìm kiếm không tìm thấy", Alert.AlertType.INFORMATION);
        } else {
            taiDuLieuComboBoxToSanXuat();
            taiDuLieuChamCongCongNhanTuyChon(listBCCCN);
//            tfLocMaCN.clear();
//            tfLocHoTenCN.clear();
        }
    }

    @FXML
    void luuBangChamCongCongNhan(ActionEvent event) {
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận lưu", "Bạn có chắc lưu bảng chấm công");
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                if (!DSCHAMCONGCONGNHAN.isEmpty()) {
                    boolean cc = ChamCongCongNhanDaoImpl.getInstance().capNhatBangChamCongCongNhan(DSCHAMCONGCONGNHAN);
                    if (cc) {
                        Alerts.showAlert("Thành công", "Đã lưu", "Đã cập nhật thành công", Alert.AlertType.INFORMATION);
                    }
                } else {
                    Alerts.showAlert("Thông báo", "Rỗng", "Không có dữ liệu để cập nhật", Alert.AlertType.ERROR);
                }
                tblBangChamCongCongNhan.refresh();
            }
        });


    }

    @FXML
    void taoBangChamCongKhiCoPhanCong(ActionEvent event) {
        taoBangChamCongTheoNgay("2023-12-02");
    }
    private void taoBangChamCongTheoNgay(String ngayChamCong){
        Optional<ButtonType> otp = Alerts.showConfirmation("Xác nhận tạo", "Bạn có chắc tạo bảng chấm công cho ngày hôm trước");
        otp.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                boolean flag = ChamCongCongNhanDaoImpl.getInstance().taoBangChamCongCongNhanTheoNgay(
                        ChamCongCongNhanDaoImpl.getInstance().layDuLieuBangPhanCongCongNhan(ngayChamCong),
                        ngayChamCong
                );

                if(flag){
                    Alerts.showAlert("Thông báo", "Thành công", "Đã tạo bảng chấm công", Alert.AlertType.INFORMATION);
                } else {
                    Alerts.showAlert("Thông báo", "Thất bại", "Chấm công đã tồn tại hoặc chưa được phân công ngày hôm nay", Alert.AlertType.ERROR);
                }
            }
        });
    }

    @FXML
    void datLaiNgayChamCong(ActionEvent event) {
        LocalDate ngayChamCong = LocalDate.parse(Utils.taoNgayHomTruoc());

        datepickNgayChamCong.setValue(ngayChamCong);
        System.out.println("Da dat lai ngay cham cong can lam viec " + ngayChamCong);
    }


}

