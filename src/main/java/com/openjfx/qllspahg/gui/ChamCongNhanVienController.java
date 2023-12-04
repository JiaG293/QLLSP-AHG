package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;

import com.openjfx.qllspahg.entity.BangChamCongNhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCCNHANVIEN;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSPHONGBAN;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class ChamCongNhanVienController implements Initializable {
    @FXML
    private TableColumn<BangChamCongNhanVien, String> colHoTenChamCongNV;

    @FXML
    private TableColumn<BangChamCongNhanVien, String> colMaChamCongNV;

    @FXML
    private TableColumn<BangChamCongNhanVien, String> colPhongBanChamCongNV;

    @FXML
    private TableView<BangChamCongNhanVien> tblviewChamCongNV;

    @FXML
    private BorderPane borderChamCongNhanVien;

    @FXML
    private TableColumn<BangChamCongNhanVien, String> colNgayChamCong;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckDiLam;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckNghiPhep;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckTangCa;

    @FXML
    private ComboBox<String> cbxLocPhongBan;

    @FXML
    private DatePicker datepickLocNgayChamCong;

    @FXML
    private TextField tfLocMaNV;

    @FXML
    private TextField tfLocTenNV;

    @FXML
    private Button btnLayDuLieu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kiemTraNgayHienTai(); //Kiem tra ngay hien tai so voi so ngay trong thang neu o cuoi thang thi se tu dong tao bang cham con tiep theo
        khoiTaoTableChamCongNhanVien();
        taiDuLieuChamCongNhanVien(ChamCongNhanVienDaoImpl.getInstance().layDuLieuChamCongNhanVienNgayHienTai());
    }

    @FXML
    private void taiDuLieuChamCongNVNgayDuocChon(ActionEvent event) {
        LocalDate ndc = datepickLocNgayChamCong.getValue();
        System.out.println("Ngay duoc chon: " + ndc);
        try {
            ObservableList<BangChamCongNhanVien> listTemp = FXCollections.observableArrayList();
            listTemp.addAll(ChamCongNhanVienDaoImpl.getInstance().layDuLieuChamCongNhanVienNgayTuyChon(Utils.dinhDangNgayHienTai(ndc, "yyyy-MM-dd")));
            if (listTemp.isEmpty()) {
                Alerts.showAlert("Cảnh báo", "Ngày chọn không phù hợp!!!", "Không có dữ liệu ngày được chọn!!!", Alert.AlertType.ERROR);
            } else {
                taiDuLieuChamCongNhanVien(listTemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void locDuLieuChamCongNV(ActionEvent event) {

        //get gia tri tung truong
        String manv = tfLocMaNV.getText();
        String hotennv = tfLocTenNV.getText();
        String tenpb = cbxLocPhongBan.getValue();
        String ngaycc = Utils.dinhDangNgayHienTai(datepickLocNgayChamCong.getValue(), "yyyy-MM-dd");

        ObservableList<BangChamCongNhanVien> listBCCNV = FXCollections.observableArrayList();
        listBCCNV.addAll(ChamCongNhanVienDaoImpl.getInstance().locDuLieuPhongBanNhanVien(manv, hotennv, ngaycc, tenpb));
        if (listBCCNV.isEmpty()) {
            Alerts.showAlert("Thông báo", "Không có dữ liệu", "Dữ liệu tìm kiếm không tìm thấy", Alert.AlertType.INFORMATION);
        } else {
            taiDuLieuChamCongNhanVien(listBCCNV);
            tfLocMaNV.clear();
            tfLocTenNV.clear();
        }

    }

    private void taiDuLieuComboBoxPhongBan() {
        cbxLocPhongBan.setPromptText("Chọn phòng ban");
        ObservableList<String> listPB = FXCollections.observableArrayList();
        listPB.add("Trống");
        ObservableList<String> listPb = ChamCongNhanVienDaoImpl.getInstance().layDuLieuPhongBanNhanVien();
        if (!listPb.isEmpty() || listPb != null){
            listPB.addAll(listPb);
        } else {
            cbxLocPhongBan.setPromptText("Không có dữ liệu");
        }
        cbxLocPhongBan.setItems(listPB);
    }

    public void khoiTaoTableChamCongNhanVien() {

        tfLocTenNV.clear();
        tfLocMaNV.clear();
        //Khoi tao du lieu combobox phong ban
        taiDuLieuComboBoxPhongBan();

        //Khoi tao ngay duoc chon
        datepickLocNgayChamCong.setValue(LocalDate.parse(Utils.taoNgayHienTai()));
        colMaChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getMaNV());
            }
        });
        colHoTenChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getHoNV() + " " + nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getTenNV());
            }
        });
        colMaChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getMaNV());
            }
        });
        colPhongBanChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaNhanVien().getPhongBan().getTenPB());
            }

        });
        colNgayChamCong.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(DateUtils.formatStringVietnamDate(nhanVienStringCellDataFeatures.getValue().getNgayCC()));
            }
        });


        colCheckDiLam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean> param) {
                BangChamCongNhanVien bccnv = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(bccnv.getDiLam());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        bccnv.setDiLam(newValue);
                    }
                });
                return booleanProp;
            }
        });
        colCheckDiLam.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> p) {
                CheckBoxTableCell<BangChamCongNhanVien, Boolean> cell = new CheckBoxTableCell<BangChamCongNhanVien, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });


        colCheckNghiPhep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean> param) {
                BangChamCongNhanVien bccnv = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(bccnv.getNghiPhep());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        bccnv.setNghiPhep(newValue);
                    }
                });
                return booleanProp;
            }
        });
        colCheckNghiPhep.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> p) {
                CheckBoxTableCell<BangChamCongNhanVien, Boolean> cell = new CheckBoxTableCell<BangChamCongNhanVien, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });


        colCheckTangCa.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BangChamCongNhanVien, Boolean> param) {
                BangChamCongNhanVien bccnv = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(bccnv.getTangCa());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        bccnv.setTangCa(newValue);
                    }
                });
                return booleanProp;
            }
        });
        colCheckTangCa.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> p) {
                CheckBoxTableCell<BangChamCongNhanVien, Boolean> cell = new CheckBoxTableCell<BangChamCongNhanVien, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

    }

    private void taiDuLieuChamCongNhanVien(ObservableList<BangChamCongNhanVien> method) {
        if (!DSCCNHANVIEN.isEmpty()) {
            DSCCNHANVIEN.clear();
        }
        DSCCNHANVIEN.addAll(method);
        tblviewChamCongNV.setItems(DSCCNHANVIEN);
    }

    public void kiemTraNgayHienTai() {
        LocalDate ld = LocalDate.now();
          //Ngay hien tai + 7   ma lon hon so ngay trong thang thi se tao ra bang cham cong thang tiep theo
        if (ld.getDayOfMonth() + 7 > ld.withDayOfMonth(ld.lengthOfMonth()).getDayOfMonth()) {
            ChamCongNhanVienDaoImpl.getInstance().taoBangChamCongNhanVienThangTiepTheo(ChamCongNhanVienDaoImpl.getInstance().layDuLieuNhanVien());
            System.out.println("Da tao bang cham cong thang " + (ld.getMonthValue() + 1));
        }
        System.out.println("Chua du dieu kien tao bang cham cong thang tiep theo " + (ld.getMonthValue() + 1));


    }


    @FXML
    private void chonMotNhanVien(MouseEvent event) {
        BangChamCongNhanVien nvDuocChon = tblviewChamCongNV.getSelectionModel().getSelectedItem();
        System.out.println("nhan vien cham cong duoc chon:\n" + nvDuocChon);
    }

    @FXML
    void luuBangChamCongNhanVien(ActionEvent event) {
        Optional<ButtonType> rs = Alerts.showConfirmation("Xác nhận", "Bạn có chắc muốn lưu thông tin");
        rs.ifPresent(btnType -> {
            if (btnType == btnType.OK) {
                ChamCongNhanVienDaoImpl.getInstance().capNhatBangChamCongNhanVien(DSCCNHANVIEN);
                Alerts.showAlert("Thông báo", "Thành công", "Đã lưu thành công", Alert.AlertType.CONFIRMATION);
            }
        });
    }

    @FXML
    void lamMoiDuLieuBangChamCongNhanVien(ActionEvent event) {
        khoiTaoTableChamCongNhanVien();
        taiDuLieuChamCongNhanVien(ChamCongNhanVienDaoImpl.getInstance().layDuLieuChamCongNhanVienNgayHienTai());
    }

    @FXML
    void taoChamCongHienTai(ActionEvent event) {
        ChamCongNhanVienDaoImpl.getInstance().taoBangChamCongNhanVienThangHienTai(ChamCongNhanVienDaoImpl.getInstance().layDuLieuNhanVien());
    }


}

