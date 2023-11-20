package com.openjfx.qllspahg.gui;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.QuanLyTTCongNhanDao;
import com.openjfx.qllspahg.dao.QuanLyTTNhanVienDao;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinCongNhan.*;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class QuanLyCongNhanController implements Initializable {
    @FXML
    private Button btnLamMoiTTCongNhan;

    @FXML
    private Button btnLayDuLieuTTCongNhan;

    @FXML
    private Button btnLuuTTCongNhan;

    @FXML
    private Button btnResetTTCongNhan;

    @FXML
    private Button btnSuaTTCongNhan;

    @FXML
    private Button btnThemTTCongNhan;

    @FXML
    private Button btnXoaTTCongNhan;

    @FXML
    private ComboBox<String> cbxLoadGioiTinhTTCongNhan;

    @FXML
    private ComboBox<String> cbxLoadToSanXuatTTCongNhan;

    @FXML
    private ComboBox<String> cbxLoadVaiTroTTCongNhan;

    @FXML
    private ComboBox<String> cbxVaiTroTTCongNhan;

    @FXML
    private ComboBox<String> cbxToSanXuatTTCongNhan;

    @FXML
    private CheckBox ckGioiTinhTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colChucVuChiTietTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colChucVuTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colEmailChiTietTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colGioiTinhTTChiTietCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colGioiTinhTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colHoTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colHovaTenChiTietTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colMaChiTietTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colMaTTCongNhan;

    @FXML
    private TableColumn<CongNhan, Date> colNgaySinhTTChiTietCongNhan;

    @FXML
    private TableColumn<CongNhan, Date> colNgayVaoLamTTChiTietCongNha;

    @FXML
    private TableColumn<CongNhan, String> colPhuCapChiTietTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colSoDienThoaiChiTieTTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colSoTaiKhoanChiTietTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colTenTTCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colToSanXuatTTChiTietCongNhan;

    @FXML
    private TableColumn<CongNhan, String> colToSanXuatTTCongNhan;

    @FXML
    private DatePicker datepickNgaySinhTTCongNhan;

    @FXML
    private DatePicker datepickNgayVaoLamTTCongNhan;

    @FXML
    private TableView<CongNhan> tblViewChiTietTTCongNhan;

    @FXML
    private TableView<CongNhan> tblViewTTCongNhan;

    @FXML
    private TextField tfEmailTTCongNhan;

    @FXML
    private TextField tfMaSoTTCongNhan;

    @FXML
    private ComboBox<String> cbxPhuCapTTCongNhan;

    @FXML
    private TextField tfSoDienThoaiTTCongNhan;

    @FXML
    private TextField tfSoTaiKhoanTTCongNhan;

    @FXML
    private TextField tfTenTTCongNhan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepickNgayVaoLamTTCongNhan.setValue(LocalDate.now());
        loadcbxGioiTinhCongNhan();
        loadcbxToSanXuat();
        loadVaiTroCongNhan();
        docDuLieuVaoTableViewTTCongNhan();
        loadCbxNhap();
        docDuLieuVaotblViewChiTietTTCongNhan();

    }

    private void loadcbxGioiTinhCongNhan(){
        ObservableList<String> dsGT = FXCollections.observableArrayList("Nam","Nữ");
        cbxLoadGioiTinhTTCongNhan.setItems(dsGT);
    }
    private void loadcbxToSanXuat(){
        DSToSanXuat.addAll(QuanLyTTCongNhanDao.getInstance().getAllToSanXuat());
        ObservableList<String> dsToString = FXCollections.observableArrayList();
        for (ToSanXuat to : DSToSanXuat)
            dsToString.add(to.getTenTSX());

        cbxLoadToSanXuatTTCongNhan.setItems(dsToString);
    }
    private void loadVaiTroCongNhan(){
        DSChucVu.addAll(QuanLyTTCongNhanDao.getInstance().getAllChucVuCongNhan());
        ObservableList<String> dsTenChucVuString = FXCollections.observableArrayList();
        for (ChucVu cv : DSChucVu)
            dsTenChucVuString.add(cv.getTenCV());

        cbxLoadVaiTroTTCongNhan.setItems(dsTenChucVuString);
    }


    private void docDuLieuVaoTableViewTTCongNhan(){
        colMaTTCongNhan.setCellValueFactory(new PropertyValueFactory<>("maCN"));
        colHoTTCongNhan.setCellValueFactory(new PropertyValueFactory<>("hoCN"));
        colTenTTCongNhan.setCellValueFactory(new PropertyValueFactory<>("tenCN"));
        colGioiTinhTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getGioiTinh() ? "Nữ" : "Nam");
            }
        });
        colChucVuTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getChucVuCN().getTenCV());
            }
        });
        colToSanXuatTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getToSanXuat().getTenTSX());
            }
        });
        tblViewTTCongNhan.setItems(DSCongNhan);
    }

    private void docDuLieuVaotblViewChiTietTTCongNhan(){
        colMaChiTietTTCongNhan.setCellValueFactory(new PropertyValueFactory<>("maCN"));
        colHovaTenChiTietTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getHoCN() +" "+ congNhanStringCellDataFeatures.getValue().getTenCN());
            }
        });
        colNgaySinhTTChiTietCongNhan.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        Utils.formatTableColumnDate(colNgaySinhTTChiTietCongNhan,"dd/MM/YYYY");
        colGioiTinhTTChiTietCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getGioiTinh() ? "Nữ" : "Nam");
            }
        });
        colNgayVaoLamTTChiTietCongNha.setCellValueFactory(new PropertyValueFactory<>("ngayVaoLam"));
        Utils.formatTableColumnDate(colNgayVaoLamTTChiTietCongNha,"dd/MM/YYYY");
        colSoDienThoaiChiTieTTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getsDT());
            }
        });
        colEmailChiTietTTCongNhan.setCellValueFactory(new PropertyValueFactory<>("email"));
        colSoTaiKhoanChiTietTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getsTK());
            }
        });
        colToSanXuatTTChiTietCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getToSanXuat().getTenTSX());
            }
        });
        colChucVuChiTietTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getChucVuCN().getTenCV());
            }
        });
        colPhuCapChiTietTTCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CongNhan, String> congNhanStringCellDataFeatures) {
                return new SimpleStringProperty(congNhanStringCellDataFeatures.getValue().getMaPhuCap().getMaPhuCap());
            }
        });

        tblViewChiTietTTCongNhan.setItems(DSCongNhanphu);
    }

    private void locDuLieu(){
        if (!DSCongNhan.isEmpty())
            DSCongNhan.clear();
        String gt = null;
         if (!cbxLoadGioiTinhTTCongNhan.getSelectionModel().isEmpty()){
            gt = cbxLoadGioiTinhTTCongNhan.getSelectionModel().getSelectedItem() == "Nam"? "0" : "1";
        }

        String vaiTro = null;
         if (!cbxLoadVaiTroTTCongNhan.getSelectionModel().isEmpty()){
             vaiTro = cbxLoadVaiTroTTCongNhan.getSelectionModel().getSelectedItem();
         }
        String toSanXuat = null;
         if (!cbxLoadToSanXuatTTCongNhan.getSelectionModel().isEmpty()){
             toSanXuat = cbxLoadToSanXuatTTCongNhan.getSelectionModel().getSelectedItem();
         }
        DSCongNhan.addAll(QuanLyTTCongNhanDao.getInstance().locDuLieuQuanLyCongNhan(gt,vaiTro,toSanXuat));

    }
    public void layDuLieuTTCongNhan(ActionEvent actionEvent) {
        locDuLieu();
        cbxLoadGioiTinhTTCongNhan.getSelectionModel().clearSelection();
        cbxLoadToSanXuatTTCongNhan.getSelectionModel().clearSelection();
        cbxLoadVaiTroTTCongNhan.getSelectionModel().clearSelection();
        DSCongNhanreset.clear();
        DSCongNhanreset.addAll(DSCongNhan);
    }

    private void loadCbxNhap(){
        if (!DSPhuCap.isEmpty())
            DSPhuCap.clear();
        DSPhuCap.addAll(QuanLyTTCongNhanDao.getInstance().getAllPhuCapCongNhan());
        ObservableList<String> dsPhuCapString = FXCollections.observableArrayList();
        for (PhuCap pc : DSPhuCap)
            dsPhuCapString.add(pc.getMaPhuCap());
        cbxPhuCapTTCongNhan.setItems(dsPhuCapString);

        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
        DSChucVu.addAll(QuanLyTTCongNhanDao.getInstance().getAllChucVuCongNhan());
        ObservableList<String> dsChucVuString = FXCollections.observableArrayList();
        for (ChucVu cv : DSChucVu)
            dsChucVuString.add(cv.getTenCV());
        cbxVaiTroTTCongNhan.setItems(dsChucVuString);

        if (!DSToSanXuat.isEmpty())
            DSToSanXuat.clear();
        DSToSanXuat.addAll(QuanLyTTCongNhanDao.getInstance().getAllToSanXuat());
        ObservableList<String> dsToSanXuatString =FXCollections.observableArrayList();
        for (ToSanXuat to : DSToSanXuat)
            dsToSanXuatString.add(to.getTenTSX());
        cbxToSanXuatTTCongNhan.setItems(dsToSanXuatString);

    }
    private String tachHoTuHovaTen(String hoVaTen){
        String ho = hoVaTen.substring(0,hoVaTen.lastIndexOf(" "));
        /**
         * subtring truyền vào thứ tự bắt đầu của chuỗi và thứ tự kết thúc của chuỗi muốn ngắt
         * hoVaten.indexof trả về thứ tự mà khoảng trắng xuất hiện đầu tiên
         */
        return ho.trim();
    }
    private String tachTenTuHovaTen (String hovaTen){
        String ten ;
        if (!(hovaTen.lastIndexOf(" ") == -1)){
            ten = hovaTen.substring(hovaTen.lastIndexOf(" "));
        }else {
            ten = "";
        }
        /**
         * Loại subtring truyền vào thứ tự bắt đầu của chuỗi muốn ngắt và trả về toàn bộ chuỗi phía sau.
         */
        return ten.trim();
    }
    private boolean kiemTraNhapTTCongNhan() {
        //Kiểm tra tên công nhân
        if (tfTenTTCongNhan.getText().trim().isEmpty()) {
            Alerts.showConfirmation("Thông báo", "Chưa nhập tên nhân viên");
            tfTenTTCongNhan.setText("");
            tfTenTTCongNhan.requestFocus();
            return false;
        }  else if (!(tfTenTTCongNhan.getText().trim().matches("([A-Z]{1}[a-z' ]*)+"))) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo", "Tên phải bắt đầu là chữ cái in hoa và không chứa số");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfTenTTCongNhan.setText("");
                tfTenTTCongNhan.requestFocus();
            }else
                tfTenTTCongNhan.requestFocus();
            return false;
        }else if (tachTenTuHovaTen(tfTenTTCongNhan.getText().trim()).isEmpty()) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo", "Tên phải gồm họ và tên");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfTenTTCongNhan.setText("");
                tfTenTTCongNhan.requestFocus();
            }else
                tfTenTTCongNhan.requestFocus();
            return false;
        }
        //Kiểm tra ngày sinh
        if (datepickNgaySinhTTCongNhan.getValue() == null) {
            Alerts.showConfirmation("Thông báo", "Chưa chọn ngày sinh nhân viên");
            datepickNgaySinhTTCongNhan.requestFocus();
            return false;
        } else {
            LocalDate lc = datepickNgaySinhTTCongNhan.getValue();
            int namSinh = lc.getYear();
            int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
            int tuoi = namHienTai - namSinh;

            if (!(tuoi >= 18 && tuoi < 60)) {
                Alerts.showConfirmation("Thong bao", "Nhân viên phải có tuổi từ 18 và dưới 60");
                datepickNgaySinhTTCongNhan.requestFocus();
                return false;
            }
        }
        //Kiểm tra số điện thoại
        if (tfSoDienThoaiTTCongNhan.getText().trim().isEmpty()) {
            Alerts.showConfirmation("Thông báo", "Chưa nhập số điện thoại");
            tfSoDienThoaiTTCongNhan.setText("");
            tfSoDienThoaiTTCongNhan.requestFocus();
            return false;
        } else if (!StringUtils.isNumeric(tfSoDienThoaiTTCongNhan.getText().trim())){
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo","Số điện thoại phải là số");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfSoDienThoaiTTCongNhan.setText("");
                tfSoDienThoaiTTCongNhan.requestFocus();
            }else
                tfSoDienThoaiTTCongNhan.requestFocus();
            return false;
        }
        //Kiểm tra email
        if (tfEmailTTCongNhan.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưa nhập email");
            tfEmailTTCongNhan.requestFocus();
            tfEmailTTCongNhan.setText("");
            return false;
        } else if (!(tfEmailTTCongNhan.getText().trim().matches("^(?!\\.)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo","Nhập sai định dạng email");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfEmailTTCongNhan.requestFocus();
                tfEmailTTCongNhan.setText("");
            }else
                tfEmailTTCongNhan.requestFocus();
            return false;
        }
        //Kiểm tra số tài khoản ngân hàng
        if (tfSoTaiKhoanTTCongNhan.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báp","Chưa nhập tài khoản");
            tfSoTaiKhoanTTCongNhan.requestFocus();
            tfSoTaiKhoanTTCongNhan.setText("");
            return false;
        }else if (!StringUtils.isNumeric(tfSoTaiKhoanTTCongNhan.getText().trim())){
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo", "Số tài khoản phải là số và phải nhập liền kề nhau");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfSoTaiKhoanTTCongNhan.setText("");
                tfSoTaiKhoanTTCongNhan.requestFocus();
            }else
                tfSoTaiKhoanTTCongNhan.requestFocus();
            return false;
        }
        //Kiểm tra phòng ban có chọn không
        if (cbxToSanXuatTTCongNhan.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn phòng ban");
            cbxToSanXuatTTCongNhan.requestFocus();
            return false;
        }
        //Kiểm tra phụ cấp có được chọn không
        if (cbxPhuCapTTCongNhan.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn phụ cấp cho nhân viên");
            cbxPhuCapTTCongNhan.requestFocus();
            return false;
        }
        //Kiểm tra chức vụ có được chọn không
        if (cbxVaiTroTTCongNhan.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưa chọn chức vụ");
            cbxVaiTroTTCongNhan.requestFocus();
            return false;
        }
        return true;
    }
    private int timMACongNhanLonNhatTrenBang() {
        /**
         * Nếu mã DSnhanVien rỗng thì trả về ma = 0
         * nếu không tìm mã lớn nhất trong đây
         */
        int maCNLonNhatTuBang;
        if (DSCongNhan.isEmpty()) {
            return maCNLonNhatTuBang = 0;
        } else {
            /**
             * Lấy mã của nhân viên thứ 0 trong DSNhanVien cho gán cho mã lớn nhất
             * Sau đó thực hiện thuật toán tìm mã lớn nhấ lấy trên mạng trong c
             */
            CongNhan cn = DSCongNhan.get(0);
            maCNLonNhatTuBang = Integer.parseInt(cn.getMaCN().substring(2));
            for (CongNhan cn1 : DSCongNhan)
                if (maCNLonNhatTuBang < Integer.parseInt(cn1.getMaCN().substring(2)))
                    maCNLonNhatTuBang = Integer.parseInt(cn1.getMaCN().substring(2));

        }
        return maCNLonNhatTuBang;
    }
    private String taoMaCongNhan(){

        String maCNLonNhatTuCSDL = QuanLyTTCongNhanDao.getInstance().getMaNhanVienLonNhat();

        int maCNLonNhaTtuCSDLChuyenSangSo;
        if (maCNLonNhatTuCSDL == null){
            maCNLonNhaTtuCSDLChuyenSangSo =0;
        }else {
            maCNLonNhaTtuCSDLChuyenSangSo = Integer.parseInt(maCNLonNhatTuCSDL.substring(2)); //Lấy sau phần tử thứ 2 tới hết vì mã có định dạng chung là CN****
        }
        int maCNLonNhattuBang = timMACongNhanLonNhatTrenBang();
        int maCNLonNhat = 0;
        if (maCNLonNhaTtuCSDLChuyenSangSo > maCNLonNhattuBang){
            maCNLonNhat = maCNLonNhaTtuCSDLChuyenSangSo;
        } else if (maCNLonNhaTtuCSDLChuyenSangSo < maCNLonNhattuBang) {
            maCNLonNhat =maCNLonNhattuBang;
        } else {
            maCNLonNhat = maCNLonNhaTtuCSDLChuyenSangSo;
        }
        int maSoCNfinal = maCNLonNhat+1;

        String maCNfinal = "";
        if (String.valueOf(maSoCNfinal).length() ==1 ){
            maCNfinal ="NV"+ "00000" + maSoCNfinal;
        }else if (String.valueOf(maSoCNfinal).length() == 2) {
            maCNfinal = "MV" + "0000" + maSoCNfinal;
        }else if (String.valueOf(maSoCNfinal).length() == 3) {
            maCNfinal = "NV" + "000"+ maSoCNfinal;
        }else if (String.valueOf(maSoCNfinal).length()==4) {
            maCNfinal = "NV"+ "00"+ maSoCNfinal;
        }else if (String.valueOf(maSoCNfinal).length() ==5){
            maCNfinal = "NV" + "0" + maSoCNfinal;
        } else if (String.valueOf(maSoCNfinal).length() ==6) {
            maCNfinal = "NV" + maSoCNfinal;
        } else {
            Alerts.showConfirmation("Thong̉ báo", "Đã đầy mã số nhân viên không thể tạo thêm");
            return maCNfinal = "NV1000000";
        }
        return maCNfinal;
    }
    private CongNhan taoCongNhan(){
        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
        DSChucVu.addAll(QuanLyTTCongNhanDao.getInstance().getAllChucVuCongNhan());
        if (!DSToSanXuat.isEmpty())
            DSToSanXuat.clear();
        DSToSanXuat.addAll(QuanLyTTCongNhanDao.getInstance().getAllToSanXuat());

        String maCN = taoMaCongNhan();
        String hoCN = tachHoTuHovaTen(tfTenTTCongNhan.getText().trim());
        String tenCN = tachTenTuHovaTen(tfTenTTCongNhan.getText().trim());
        boolean gioiTinh = ckGioiTinhTTCongNhan.isSelected();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate = datepickNgaySinhTTCongNhan.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date ngaySinh = Date.from(instant);

        String sDT = tfSoDienThoaiTTCongNhan.getText().trim();
        String email = tfEmailTTCongNhan.getText().trim();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate2 = datepickNgayVaoLamTTCongNhan.getValue();
        Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
        Date ngayVaoLam=  Date.from(instant2);

        String sTK = tfSoTaiKhoanTTCongNhan.getText().trim();

        // lấy thông chức vụ từ combobox và chạy vòng lặp để tìm object chức vụ trùng với tên chức vụ
        String chucVu = cbxVaiTroTTCongNhan.getValue().trim();
        ChucVu cv = new ChucVu();
        for (ChucVu cv1 : DSChucVu)
            if (cv1.getTenCV().equals(chucVu))
                cv = cv1;

        // lấy thông phòng ban từ combobox và chạy vòng lặp để tìm object Phòng ban trùng với tên chức vụ
        String toSanXuat = cbxToSanXuatTTCongNhan.getValue().trim();
        ToSanXuat to = new ToSanXuat();
        for (ToSanXuat to1 : DSToSanXuat)
            if (to1.getTenTSX().equals(toSanXuat))
                to = to1;

        /**
         * Nếu phụ cấp được check thì maPhucap la PCNVI ngược lại không được check la PCNVTT
         * PCNVCI: phụ cấp nhân viên chính
         * PCNVTT: phụ cấp nhân viên thực tập
         */

        PhuCap pc = new PhuCap(cbxPhuCapTTCongNhan.getValue().toString());

        return new CongNhan(maCN,hoCN,tenCN,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,to,pc);

    }

    /**
     * Thêm xóa sửa
     *
     */

    public void themTTCongNhan(ActionEvent actionEvent) {
        if (kiemTraNhapTTCongNhan()){
            Optional<ButtonType> result = Alerts.showConfirmation("Thong bao","Đã thêm Công Nhân");
            if (result.isPresent() && result.get()==ButtonType.OK){
                CongNhan cn = taoCongNhan();
                DSCongNhan.add(cn);
                DSCongNhanThem.add(cn);
                DSCongNhanphu.add(cn);
            }else
                return;


        }
    }

    public void xoaTTCongNhan(ActionEvent actionEvent) {
        CongNhan cn = tblViewTTCongNhan.getSelectionModel().getSelectedItem();
        //Nếu nv ko tồn tại trong DSNhanVienThem thì lưu vào DSXoa
        if (DSCongNhanXoa.contains(cn)){
            return;
        }else if (!DSCongNhanThem.contains(cn))
            DSCongNhanXoa.add(cn);
            //Nếu tồn tại thì xóa khỏi DSnhanvien thêm
        else if (DSCongNhanThem.contains(cn))
            DSCongNhanThem.remove(cn);
        else if (DSCongNhanSua.contains(cn)) {
            DSCongNhanSua.remove(cn);
        }
        DSCongNhan.remove(cn);
        DSCongNhanphu.remove(cn);
        //Trường hợp chọn tablechitietthongtinnhanvien
        CongNhan cn1 = tblViewChiTietTTCongNhan.getSelectionModel().getSelectedItem();
        if (!DSCongNhanThem.contains(cn1))
            DSCongNhanXoa.add(cn1);
        else if (DSCongNhanThem.contains(cn1)) {
            DSCongNhanThem.remove(cn1);
        } else if (DSCongNhanSua.contains(cn1))
            DSCongNhanSua.remove(cn1);

        DSCongNhan.remove(cn1);
        DSCongNhanphu.remove(cn1);
    }

    public void xoaTrangTTCongNhan(ActionEvent actionEvent) {
        tfEmailTTCongNhan.setText("");
        tfTenTTCongNhan.setText("");
        tfSoTaiKhoanTTCongNhan.setText("");
        tfSoDienThoaiTTCongNhan.setText("");
        tfMaSoTTCongNhan.setText("");
        datepickNgaySinhTTCongNhan.setValue(LocalDate.now());
        datepickNgayVaoLamTTCongNhan.setValue(LocalDate.now());
        cbxPhuCapTTCongNhan.getSelectionModel().clearSelection();
        cbxToSanXuatTTCongNhan.getSelectionModel().clearSelection();
        cbxVaiTroTTCongNhan.getSelectionModel().clearSelection();
    }

    public void chonROWTTCongNhan(MouseEvent mouseEvent) {
        //Chọn table thông tin nhân viên thì xóa chọn bên bảng chi tiết nhân viên
        tblViewChiTietTTCongNhan.getSelectionModel().clearSelection();
        //DSNhanVienphu chua co neu chon vao se bi loi
        CongNhan cnDuocChon;
        if (!DSCongNhan.isEmpty() && tblViewTTCongNhan.getSelectionModel().getSelectedItem() != null) {
            cnDuocChon = tblViewTTCongNhan.getSelectionModel().getSelectedItem();
            //Chọn xong thêm vào bảng chi tiết nhân viên bên dưới
            if (!DSCongNhanphu.contains(cnDuocChon))
                DSCongNhanphu.add(cnDuocChon);
            else if (DSCongNhanphu.contains(cnDuocChon)) {
                DSCongNhanphu.set(DSCongNhanphu.indexOf(cnDuocChon), cnDuocChon);
            }

            tfMaSoTTCongNhan.setText(cnDuocChon.getMaCN());
            tfTenTTCongNhan.setText(cnDuocChon.getHoCN() + " " + cnDuocChon.getTenCN());
            tfSoDienThoaiTTCongNhan.setText(cnDuocChon.getsDT());
            tfEmailTTCongNhan.setText(cnDuocChon.getEmail());
            tfSoTaiKhoanTTCongNhan.setText(cnDuocChon.getsTK());
            ckGioiTinhTTCongNhan.setSelected(cnDuocChon.getGioiTinh());
            String phuCap = cnDuocChon.getMaPhuCap().getMaPhuCap();
            cbxVaiTroTTCongNhan.setValue(cnDuocChon.getChucVuCN().getTenCV());
            cbxToSanXuatTTCongNhan.setValue(cnDuocChon.getToSanXuat().getTenTSX());
            cbxPhuCapTTCongNhan.setValue(cnDuocChon.getMaPhuCap().getMaPhuCap());
            //ngay sinh

            LocalDate lcNgaySinh = new java.util.Date(cnDuocChon.getNgaySinh().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgaySinhTTCongNhan.setValue(lcNgaySinh);

            //ngay vao lam
            LocalDate lcNgayVaoLam = new java.util.Date(cnDuocChon.getNgayVaoLam().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgayVaoLamTTCongNhan.setValue(lcNgayVaoLam);

        } else
            return;
    }

    public void chonROWChiTiteTTCongNhan(MouseEvent mouseEvent) {
        //Chọn table chi tiết nhân viên thì xóa  chọn table tt nhân viên
        tblViewTTCongNhan.getSelectionModel().clearSelection();
        //DSNhanVien chua co neu chon vao se bi loi
        if (!DSCongNhanphu.isEmpty() && tblViewChiTietTTCongNhan.getSelectionModel().getSelectedItem() != null){
            CongNhan cnDuocChon = tblViewChiTietTTCongNhan.getSelectionModel().getSelectedItem();

            tfMaSoTTCongNhan.setText(cnDuocChon.getMaCN());
            tfTenTTCongNhan.setText(cnDuocChon.getHoCN() + " " + cnDuocChon.getTenCN());
            tfSoDienThoaiTTCongNhan.setText(cnDuocChon.getsDT());
            tfEmailTTCongNhan.setText(cnDuocChon.getEmail());
            tfSoTaiKhoanTTCongNhan.setText(cnDuocChon.getsTK());
            ckGioiTinhTTCongNhan.setSelected(cnDuocChon.getGioiTinh());
            String phuCap = cnDuocChon.getMaPhuCap().getMaPhuCap();
            cbxVaiTroTTCongNhan.setValue(cnDuocChon.getChucVuCN().getTenCV());
            cbxToSanXuatTTCongNhan.setValue(cnDuocChon.getToSanXuat().getTenTSX());
            cbxPhuCapTTCongNhan.setValue(cnDuocChon.getMaPhuCap().getMaPhuCap());

            //ngay sinh

            LocalDate lcNgaySinh = new java.util.Date(cnDuocChon.getNgaySinh().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgaySinhTTCongNhan.setValue(lcNgaySinh);

            //ngay vao lam
            LocalDate lcNgayVaoLam = new java.util.Date(cnDuocChon.getNgayVaoLam().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgayVaoLamTTCongNhan.setValue(lcNgayVaoLam);

        }else
            return;
    }

    public void suaTTCongNhan(ActionEvent actionEvent) {
        CongNhan cnSua = new CongNhan();
        if(kiemTraNhapTTCongNhan()){

            if (!DSChucVu.isEmpty())
                DSChucVu.clear();
            DSChucVu.addAll(QuanLyTTCongNhanDao.getInstance().getAllChucVuCongNhan());
            if (!DSToSanXuat.isEmpty())
                DSToSanXuat.clear();
            DSToSanXuat.addAll(QuanLyTTCongNhanDao.getInstance().getAllToSanXuat());


            String hoCN = tachHoTuHovaTen(tfTenTTCongNhan.getText().trim());
            String tenCN = tachTenTuHovaTen(tfTenTTCongNhan.getText().trim());
            boolean gioiTinh = ckGioiTinhTTCongNhan.isSelected();

            //không biết chuyển datepick sang Date nên cop code mạng...
            LocalDate localDate = datepickNgaySinhTTCongNhan.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date ngaySinh = Date.from(instant);

            String sDT = tfSoDienThoaiTTCongNhan.getText().trim();
            String email = tfEmailTTCongNhan.getText().trim();

            //không biết chuyển datepick sang Date nên cop code mạng...
            LocalDate localDate2 = datepickNgaySinhTTCongNhan.getValue();
            Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
            Date ngayVaoLam=  Date.from(instant2);

            String sTK = tfSoTaiKhoanTTCongNhan.getText().trim();

            // lấy thông chức vụ từ combobox và chạy vòng lặp để tìm object chức vụ trùng với tên chức vụ
            String chucVu = cbxVaiTroTTCongNhan.getValue().trim();
            ChucVu cv = new ChucVu();
            for (ChucVu cv1 : DSChucVu)
                if (cv1.getTenCV().equals(chucVu))
                    cv = cv1;

            // lấy thông phòng ban từ combobox và chạy vòng lặp để tìm object Phòng ban trùng với tên chức vụ
            String toSanXuat = cbxToSanXuatTTCongNhan.getValue().trim();
            ToSanXuat to = new ToSanXuat();
            for (ToSanXuat to1 : DSToSanXuat)
                if (to1.getTenTSX().equals(toSanXuat))
                    to = to1;

            /**
             * Nếu phụ cấp được check thì maPhucap la PCNVI ngược lại không được check la PCNVTT
             * PCNVCI: phụ cấp nhân viên chính
             * PCNVTT: phụ cấp nhân viên thực tập
             */

            PhuCap pc = new PhuCap(cbxPhuCapTTCongNhan.getValue().toString());

            cnSua.setMaCN(tfMaSoTTCongNhan.getText().trim());
            cnSua.setHoCN(hoCN); cnSua.setTenCN(tenCN); cnSua.setGioiTinh(gioiTinh);cnSua.setNgaySinh(ngaySinh);
            cnSua.setsDT(sDT); cnSua.setEmail(email); cnSua.setNgayVaoLam(ngayVaoLam); cnSua.setsTK(sTK);
            cnSua.setChucVuCN(cv);cnSua.setToSanXuat(to);cnSua.setMaPhuCap(pc);

            DSCongNhan.set(DSCongNhan.indexOf(cnSua),cnSua);
            DSCongNhanphu.set(DSCongNhanphu.indexOf(cnSua),cnSua);

            if (DSCongNhanThem.contains(cnSua))
                DSCongNhanThem.set(DSCongNhanThem.indexOf(cnSua),cnSua);
            else if (!DSCongNhanThem.contains(cnSua) && DSCongNhanSua.contains(cnSua))
                DSCongNhanSua.set(DSCongNhanSua.indexOf(cnSua),cnSua);
            else if (!DSCongNhanThem.contains(cnSua) && !DSCongNhanSua.contains(cnSua))
                DSCongNhanSua.add(cnSua);
        }
    }

    /**
     * Lưu và reset
     */
    public void resetBangTTCongNhan(ActionEvent actionEvent) {
        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo", "Xác nhận muốn reset, sau khi reset sẽ mất hết dữ liệu chưa lưu");
        if (result.isPresent() && result.get() == ButtonType.OK){
            if (!DSCongNhan.isEmpty())
                DSCongNhan.clear();
            DSCongNhan.addAll(DSCongNhanreset);
            DSCongNhanThem.clear();
            DSCongNhanSua.clear();
            DSCongNhanXoa.clear();
            DSCongNhanphu.clear();
        }else {
            return;
        }
        loadVaiTroCongNhan();
        loadCbxNhap();
        loadcbxToSanXuat();
    }

    public void luuTTCongNhan(ActionEvent actionEvent) throws InterruptedException {
        Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo","Bạn có muốn lưu không?");
        if (rs.isPresent() && rs.get() == ButtonType.OK){
            TimeUnit.SECONDS.sleep(1);
            if (QuanLyTTCongNhanDao.getInstance().saveDSCongNhanThem(DSCongNhanThem) && QuanLyTTCongNhanDao.getInstance().saveDSCongNhanXoa(DSCongNhanXoa) && QuanLyTTCongNhanDao.getInstance().svaeDSCongNhanSua(DSCongNhanSua)) {
                Alerts.showConfirmation("Thông báo","Lưu thành công");
                DSCongNhanreset.clear();
                DSCongNhanreset.addAll(DSCongNhan);
                DSCongNhanThem.clear();
                DSCongNhanXoa.clear();
                DSCongNhanSua.clear();
            }
            else
                Alerts.showConfirmation("Thông báo","Lưu không thành công");
        }
    }
}
