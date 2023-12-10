package com.openjfx.qllspahg.gui;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.QuanLyTTNhanVienDao;

import  static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSNhanVien;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSNhanVienThem;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSNhanVienXoa;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSNhanVienSua;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSNhanVienreset;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSNhanVienphu;

import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSPhongBan;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSChucVu;
import static com.openjfx.qllspahg.dao.interfaces.DSQLThongTinNhanVien.DSPhuCap;


import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.Utils;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class QuanLyNhanVienController implements Initializable{

    @FXML
    private Button btnLamMoiTTNhanVien;

    @FXML
    private Button btnLayDuLieuTTNhanVien;

    @FXML
    private Button btnLuuTTNhanVien;

    @FXML
    private Button btnResetTTNhanVien;

    @FXML
    private Button btnSuaTTNhanVien;

    @FXML
    private Button btnThemTTNhanVien;

    @FXML
    private Button btnXoaTTNhanVien;

    @FXML
    private ComboBox<String> cbxChucVuTTNhanVien;

    @FXML
    private ComboBox<String> cbxLoadChucVuTTNhanVien;

    @FXML
    private ComboBox<String> cbxLoadGioiTinhTTNhanVien;

    @FXML
    private ComboBox<String> cbxLoadPhongBanTTNhanVien;

    @FXML
    private ComboBox<String> cbxPhongBanTTNhanVien;

    @FXML
    private ComboBox<String> cbxPhuCapTTNhanVien;

    @FXML
    private CheckBox ckGioiTinhTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietChucVuTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String > colChiTietEmailTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietGioiTinhTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietHovaTenTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietMaTTNhanVien;

    @FXML
    private TableColumn<NhanVien, Double> colChiTietLuongTTNhanVien;

    @FXML
    private TableColumn<NhanVien, Date> colChiTietNgaySinhTTNhanVien;

    @FXML
    private TableColumn<NhanVien, Date> colChiTietNgayVaoLamTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietPhongBanTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietPhuCapTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietSoDienThoaiTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietSoTaiKhoanTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChucVuTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colGioiTinhTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colHoTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colMaTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colPhongBanTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colTenTTNhanVien;

    @FXML
    private DatePicker datepickNgaySinhTTNhanVien;

    @FXML
    private DatePicker datepickNgayVaoLamTTNhanVien;

    @FXML
    private TextField tfMaTTNhanVien;

    @FXML
    private TextField tfPhuCapTTNhanVien;

    @FXML
    private TextField tfLuongCoBanTTNhanVien;

    @FXML
    private TableView<NhanVien> tblViewTTNhanVien;

    @FXML
    private TableView<NhanVien> tblviewChiTietNhanVien;

    @FXML
    private TextField tfEmailTTNhanVien;

    @FXML
    private TextField tfSoDienThoaiTTNhanVien;

    @FXML
    private TextField tfSoTaiKhoanTTNhanVien;

    @FXML
    private TextField tfTenTTNhanVien;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loaComboboxGioiTinh();
        loadComboboxChucVu();
        loadComboboxPhongBan();
        loadComboxChucVuNhapTTNhanVien();
        loadComboboxPhongBanNhapTTNhanVien();
        loadComboboxPhuCapNhapTTNhanVien();
        datepickNgayVaoLamTTNhanVien.setValue(LocalDate.now());
        docDuLieuNVVaoTableTTNhanVien();

        docDuLieuVaoTableChiTiet();

    }

    /**
     * Bảng thông tin nhân viên
     */

    /**
     * Phan load du lieu
     */

    private void loadComboxChucVuNhapTTNhanVien(){
        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
        DSChucVu.addAll(QuanLyTTNhanVienDao.getInstance().getAllChucVuNhanVien());
        ObservableList<String> dsChucVu = FXCollections.observableArrayList();
        for (ChucVu cv : DSChucVu){
            dsChucVu.add(cv.getTenCV());
        }
        cbxChucVuTTNhanVien.setItems(dsChucVu);
    }
    private void loadComboboxPhongBanNhapTTNhanVien(){
        if (!DSPhongBan.isEmpty())
            DSPhongBan.clear();
        DSPhongBan.addAll(QuanLyTTNhanVienDao.getInstance().getAllPhongBan());
        ObservableList<String> dsPB = FXCollections.observableArrayList();
        for(PhongBan pb : DSPhongBan)
            dsPB.add(pb.getTenPB());
        cbxPhongBanTTNhanVien.setItems(dsPB);

    }
    private void loadComboboxPhuCapNhapTTNhanVien(){
        if (!DSPhuCap.isEmpty())
            DSPhuCap.clear();
        DSPhuCap.addAll(QuanLyTTNhanVienDao.getInstance().getAllPhuCapNhanVien());
        ObservableList<String> dsPC = FXCollections.observableArrayList();
        for (PhuCap pc : DSPhuCap)
            dsPC.add(pc.getMaPhuCap());
        cbxPhuCapTTNhanVien.setItems(dsPC);
    }
    private void loaComboboxGioiTinh(){
        ObservableList<String> gioiTinh= FXCollections.observableArrayList(
                "Nam","Nữ"
        );
        cbxLoadGioiTinhTTNhanVien.setItems(gioiTinh);
    }
    private void loadComboboxChucVu(){
        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
        DSChucVu.addAll(QuanLyTTNhanVienDao.getInstance().getAllChucVuNhanVien());
        ObservableList<String> dsTenChucVu = FXCollections.observableArrayList();
        for (ChucVu cv :DSChucVu){
            dsTenChucVu.add(cv.getTenCV());
        }
        cbxLoadChucVuTTNhanVien.setItems(dsTenChucVu);
    }
    private void loadComboboxPhongBan(){
        if (!DSPhongBan.isEmpty())
            DSPhongBan.clear();
        DSPhongBan.addAll(QuanLyTTNhanVienDao.getInstance().getAllPhongBan());
        ObservableList<String> dsTenPB = FXCollections.observableArrayList();
        for (PhongBan pb : DSPhongBan){
            dsTenPB.add(pb.getTenPB());
        }
        cbxLoadPhongBanTTNhanVien.setItems(dsTenPB);
    }


    public void layDuLieuTTNhanVien(ActionEvent actionEvent) {
        /**
         * Nếu comboBox không được chon thì lay tat ca du lieu nhan vien vao  DSNhanVien
         * Ngược lại làm từng trường hợp, sau khi thêm vào bảng cho combobox đó clearselction
         * có tổng 8 trường hợp phải viết code cho từng trường hợp
         * ở đây tôi dùng điều kiện chọn/ko được chọn của 3 cbx load dữ liệu và dùng && để logic câu if không bị sai. Nếu dùng <3 dảm bảo điều kiện load sẽ sai
         */
        //cbx load giới tính, phòng ban,chức vụ không được chọn là lấy hết
        if (cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getAllNhanVien());
            docDuLieuNVVaoTableTTNhanVien();

         //cbx load phòng ban không được chọn và cbx chúc vụ và giới tính được chọn
        }  else if (cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty())  {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoGTvaCV(cbxLoadGioiTinhTTNhanVien.getValue().trim().equals("Nu") ? "1" : "0",cbxLoadChucVuTTNhanVien.getValue().trim()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load phòng ban được chọn, cbx chức vụ,giới tính ko được chọn
        } else if (!cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoPB(cbxLoadPhongBanTTNhanVien.getValue().trim()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load chức vụ ko được chọn, cbx giới tính và phòng ban được chọn
        } else if (cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoGTvaPB(cbxLoadGioiTinhTTNhanVien.getValue().trim().equals("Nu") ? "1" : "0",cbxLoadPhongBanTTNhanVien.getValue().trim()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load chúc vụ được chọn và, cbx giới tính, phòng ban không đoc75 chọn
        } else if (!cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoCV(cbxLoadChucVuTTNhanVien.getValue().trim()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load giới tính không được chọn, cbx load chức vụ, phòng ban được chọn
        } else if (cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoCVvaPB(cbxLoadChucVuTTNhanVien.getValue().trim(),cbxLoadPhongBanTTNhanVien.getValue().trim()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load giới tính được chọn, cbx load chức vụ, phòng ban không được chọn
        } else if (!cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoGT(cbxLoadGioiTinhTTNhanVien.getValue().trim().equals("Nu") ? "1" : "0"));
            docDuLieuNVVaoTableTTNhanVien();

            // cbx load giới tính, phòng ban, chúc vụ được chọn
        } else if (!(cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty())) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(QuanLyTTNhanVienDao.getInstance().getNhanVienTheoGTvaCVvaPB(cbxLoadGioiTinhTTNhanVien.getValue().trim().equals("Nu") ? "1" :"0",cbxLoadChucVuTTNhanVien.getValue().trim(),cbxLoadPhongBanTTNhanVien.getValue().trim()));
            docDuLieuNVVaoTableTTNhanVien();

        }
        DSNhanVienreset.clear();
        DSNhanVienreset.addAll(DSNhanVien);
        xoaChonCbxLoadDuLieu();
    }
    private void xoaDuLieuDSPhongBanNeuDaCoDuL (){
        if (!DSPhongBan.isEmpty())
            DSPhongBan.clear();
    }
    private void xoaDuLieuDSChucVuNeuDaCoDuL(){
        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
    }
    private void xoaDuLieuDSNhanVienNeuDaCoDuL(){
        if(!DSNhanVien.isEmpty())
            DSNhanVien.clear();
    }
    private void xoaChonCbxLoadDuLieu(){
        cbxLoadGioiTinhTTNhanVien.getSelectionModel().clearSelection();
        cbxLoadChucVuTTNhanVien.getSelectionModel().clearSelection();
        cbxLoadPhongBanTTNhanVien.getSelectionModel().clearSelection();
    }

    public void docDuLieuNVVaoTableTTNhanVien(){

        colMaTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        colHoTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("hoNV"));
        colTenTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("tenNV"));

        colGioiTinhTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getGioiTinh() ? "Nu" :"Nam");
            }
        });

        /**
         *  colGioiTinh ket noi voi entity NhanVien du lieu hien thi len string
         *  CallBack<p,t>
         *      p: đối số được cung cấp cho phương thức call *đối số: là dữ liệu truyền vào khi gọi hàm
         *      t: loại dữ liệu trả về của phương thức call
         *  ObservableValue<T> giá trị quan sát kiểu T *một entity kiểu T
         *   Call<p>
         *         p dối số duy nhất mà giá trị trả về phải duy nhất
         *       Call trả về một đối tượng type x (kiểu x).
         *
         *       nhanVienStringCellDataFeatures.getValue() lấy kiểu dữ liệu kết nối của
         *       TableColumn.CellDataFeatures<NhanVien, String> là NhanVien sau đó lay kieu du lieu ma minh muon
         */

        colChucVuTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getChucVuNV().getTenCV());
            }
        });
        colPhongBanTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getPhongBan().getTenPB());
            }
        });

        tblViewTTNhanVien.setItems(DSNhanVien);
    }

    public void docDuLieuVaoTableChiTiet(){
        colChiTietMaTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        colChiTietHovaTenTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getHoNV() + " " + nhanVienStringCellDataFeatures.getValue().getTenNV());
            }
        });
        colChiTietGioiTinhTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getGioiTinh()? "Nu" : "Nam");
            }
        });
        colChiTietNgaySinhTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        Utils.formatTableColumnDate(colChiTietNgaySinhTTNhanVien,"dd/MM/YYYY");
        colChiTietNgayVaoLamTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("ngayVaoLam"));
        Utils.formatTableColumnDate(colChiTietNgayVaoLamTTNhanVien,"dd/MM/YYYY");
        colChiTietSoDienThoaiTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getsDT());
            }
        });
        colChiTietEmailTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("email"));
        colChiTietSoTaiKhoanTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getsTK());
            }
        });
        colChiTietPhongBanTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getPhongBan().getTenPB());
            }
        });
        colChiTietChucVuTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getChucVuNV().getTenCV());
            }
        });
        colChiTietPhuCapTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getPhuCap().getMaPhuCap());
            }
        });
        colChiTietLuongTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("luongCoBan"));
        tblviewChiTietNhanVien.setItems(DSNhanVienphu);

    }

    /**
     * Phần xử lý Thêm xóa sửa nhân viên
     */


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

    private boolean kiemTraNhapTTNhanVien() {
        //Kiểm tra tên nhan viên
        if (tfTenTTNhanVien.getText().trim().isEmpty()) {
            Alerts.showConfirmation("Thông báo", "Chưa nhập tên nhân viên");
            tfTenTTNhanVien.setText("");
            tfTenTTNhanVien.requestFocus();
            return false;
        }  else if (!(tfTenTTNhanVien.getText().trim().matches("([A-Z]{1}[a-z' ]*)+"))) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo", "Tên phải bắt đầu là chữ cái in hoa và không chứa số");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfTenTTNhanVien.setText("");
                tfTenTTNhanVien.requestFocus();
            }else
                tfTenTTNhanVien.requestFocus();
            return false;
        }else if (tachTenTuHovaTen(tfTenTTNhanVien.getText().trim()).isEmpty()) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo", "Tên phải gồm họ và tên");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfTenTTNhanVien.setText("");
                tfTenTTNhanVien.requestFocus();
            }else
                tfTenTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra ngày sinh
        if (datepickNgaySinhTTNhanVien.getValue() == null) {
            Alerts.showConfirmation("Thông báo", "Chưa chọn ngày sinh nhân viên");
            datepickNgaySinhTTNhanVien.requestFocus();
            return false;
        } else {
            LocalDate lc = datepickNgaySinhTTNhanVien.getValue();
            int namSinh = lc.getYear();
            int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
            int tuoi = namHienTai - namSinh;

            if (!(tuoi >= 18 && tuoi < 60)) {
                Alerts.showConfirmation("Thong bao", "Nhân viên phải có tuổi từ 18 và dưới 60");
                datepickNgaySinhTTNhanVien.requestFocus();
                return false;
            }
        }
        //Kiểm tra số điện thoại
        if (tfSoDienThoaiTTNhanVien.getText().trim().isEmpty()) {
            Alerts.showConfirmation("Thông báo", "Chưa nhập số điện thoại");
            tfSoDienThoaiTTNhanVien.setText("");
            tfSoDienThoaiTTNhanVien.requestFocus();
            return false;
        } else if (!StringUtils.isNumeric(tfSoDienThoaiTTNhanVien.getText().trim())){
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo","Số điện thoại phải là số");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfSoDienThoaiTTNhanVien.setText("");
                tfSoDienThoaiTTNhanVien.requestFocus();
            }else
                tfSoDienThoaiTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra email
        if (tfEmailTTNhanVien.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưa nhập email");
            tfEmailTTNhanVien.requestFocus();
            tfEmailTTNhanVien.setText("");
            return false;
        } else if (!(tfEmailTTNhanVien.getText().trim().matches("^(?!\\.)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo","Nhập sai định dạng email");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfEmailTTNhanVien.requestFocus();
                tfEmailTTNhanVien.setText("");
            }else
                tfEmailTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra số tài khoản ngân hàng
        if (tfSoTaiKhoanTTNhanVien.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báp","Chưa nhập tài khoản");
            tfSoTaiKhoanTTNhanVien.requestFocus();
            tfSoTaiKhoanTTNhanVien.setText("");
            return false;
        }else if (!StringUtils.isNumeric(tfSoTaiKhoanTTNhanVien.getText().trim())){
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo", "Số tài khoản phải là số và phải nhập liền kề nhau");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfSoTaiKhoanTTNhanVien.setText("");
                tfSoTaiKhoanTTNhanVien.requestFocus();
            }else
                tfSoTaiKhoanTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra phòng ban có chọn không
        if (cbxPhongBanTTNhanVien.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn phòng ban");
            cbxPhongBanTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra phụ cấp có được chọn không
        if (cbxPhuCapTTNhanVien.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn phụ cấp cho nhân viên");
            cbxPhuCapTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra chức vụ có được chọn không
        if (cbxChucVuTTNhanVien.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưa chọn chức vụ");
            cbxChucVuTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra lương cơ bản
        if (tfLuongCoBanTTNhanVien.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưa nhập lương cơ bản của nhân viên");
            tfLuongCoBanTTNhanVien.requestFocus();
            return false;
        }else if (!StringUtils.isNumeric(tfLuongCoBanTTNhanVien.getText().trim())){
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo","Số tài lương cơ bản của nhân viên phải lả số");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfLuongCoBanTTNhanVien.setText("");
                tfLuongCoBanTTNhanVien.requestFocus();
            }else
                tfLuongCoBanTTNhanVien.requestFocus();
            return false;
        }

        return true;
    }
    private int timMANhanVienLonNhatTrenBang() {
        /**
         * Nếu mã DSnhanVien rỗng thì trả về ma = 0
         * nếu không tìm mã lớn nhất trong đây
         */
        int maNVLonNhatTuBang;
        if (DSNhanVien.isEmpty()) {
            return maNVLonNhatTuBang = 0;
        } else {
            /**
             * Lấy mã của nhân viên thứ 0 trong DSNhanVien cho gán cho mã lớn nhất
             * Sau đó thực hiện thuật toán tìm mã lớn nhấ lấy trên mạng trong c
             */
            NhanVien nv = DSNhanVien.get(0);
            maNVLonNhatTuBang = Integer.parseInt(nv.getMaNV().substring(2));
            for (NhanVien nv1 : DSNhanVien)
                if (maNVLonNhatTuBang < Integer.parseInt(nv1.getMaNV().substring(2)))
                    maNVLonNhatTuBang = Integer.parseInt(nv1.getMaNV().substring(2));

        }
        return maNVLonNhatTuBang;
    }
    private String taoMaNhanVien(){

        String maNVLonNhatTuCSDL = QuanLyTTNhanVienDao.getInstance().getMaNhanVienLonNhat();

        int maNVLonNhaTtuCSDLChuyenSangSo;
        if (maNVLonNhatTuCSDL == null){
            maNVLonNhaTtuCSDLChuyenSangSo =0;
        }else {
            maNVLonNhaTtuCSDLChuyenSangSo = Integer.parseInt(maNVLonNhatTuCSDL.substring(2)); //Lấy sau phần tử thứ 2 tới hết vì mã có định dạng chung là CN****
        }
        int maNVLonNhattuBang = timMANhanVienLonNhatTrenBang();
        int maNVLonNhat = 0;
        if (maNVLonNhaTtuCSDLChuyenSangSo > maNVLonNhattuBang){
            maNVLonNhat = maNVLonNhaTtuCSDLChuyenSangSo;
        } else if (maNVLonNhaTtuCSDLChuyenSangSo < maNVLonNhattuBang) {
            maNVLonNhat =maNVLonNhattuBang;
        } else {
            maNVLonNhat = maNVLonNhaTtuCSDLChuyenSangSo;
        }
         int maSoNVfinal = maNVLonNhat+1;

        String maNVfinal = "";
        if (String.valueOf(maSoNVfinal).length() ==1 ){
            maNVfinal ="NV"+ "00000" + maSoNVfinal;
        }else if (String.valueOf(maSoNVfinal).length() == 2) {
            maNVfinal = "MV" + "0000" + maSoNVfinal;
        }else if (String.valueOf(maSoNVfinal).length() == 3) {
            maNVfinal = "NV" + "000"+ maSoNVfinal;
        }else if (String.valueOf(maSoNVfinal).length()==4) {
            maNVfinal = "NV"+ "00"+ maSoNVfinal;
        }else if (String.valueOf(maSoNVfinal).length() ==5){
            maNVfinal = "NV" + "0" + maSoNVfinal;
        } else if (String.valueOf(maSoNVfinal).length() ==6) {
            maNVfinal = "NV" + maSoNVfinal;
        } else {
            Alerts.showConfirmation("Thong̉ báo", "Đã đầy mã số nhân viên không thể tạo thêm");
            return maNVfinal = "NV1000000";
        }
        return maNVfinal;
    }

    private NhanVien taoNhanVien(){
        xoaDuLieuDSChucVuNeuDaCoDuL();
        DSChucVu.addAll(QuanLyTTNhanVienDao.getInstance().getAllChucVuNhanVien());
        xoaDuLieuDSPhongBanNeuDaCoDuL();
        DSPhongBan.addAll(QuanLyTTNhanVienDao.getInstance().getAllPhongBan());


        String maNV = taoMaNhanVien();
        String hoNV = tachHoTuHovaTen(tfTenTTNhanVien.getText().trim());
        String tenNV = tachTenTuHovaTen(tfTenTTNhanVien.getText().trim());
        boolean gioiTinh = ckGioiTinhTTNhanVien.isSelected();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate = datepickNgaySinhTTNhanVien.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date ngaySinh = Date.from(instant);

        String sDT = tfSoDienThoaiTTNhanVien.getText().trim();
        String email = tfEmailTTNhanVien.getText().trim();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate2 = datepickNgayVaoLamTTNhanVien.getValue();
        Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
        Date ngayVaoLam=  Date.from(instant2);

        String sTK = tfSoTaiKhoanTTNhanVien.getText().trim();

        // lấy thông chức vụ từ combobox và chạy vòng lặp để tìm object chức vụ trùng với tên chức vụ
        String chucVu = cbxChucVuTTNhanVien.getValue().trim();
        ChucVu cv = new ChucVu();
        for (ChucVu cv1 : DSChucVu)
            if (cv1.getTenCV().equals(chucVu))
                cv = cv1;

        // lấy thông phòng ban từ combobox và chạy vòng lặp để tìm object Phòng ban trùng với tên chức vụ
        String phongBan = cbxPhongBanTTNhanVien.getValue().trim();
        PhongBan pb = new PhongBan();
        for (PhongBan pb1 : DSPhongBan)
            if (pb1.getTenPB().equals(phongBan))
                pb = pb1;

        /**
         * Nếu phụ cấp được check thì maPhucap la PCNVI ngược lại không được check la PCNVTT
         * PCNVCI: phụ cấp nhân viên chính
         * PCNVTT: phụ cấp nhân viên thực tập
         */

        PhuCap pc = new PhuCap(cbxPhuCapTTNhanVien.getValue().toString());

        double luongCoBan = Double.parseDouble(tfLuongCoBanTTNhanVien.getText().trim());

        return new NhanVien(maNV,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,pb,pc,luongCoBan);

    }

    public void themTTNhanVien(ActionEvent actionEvent) {
        if (kiemTraNhapTTNhanVien()){
            Optional<ButtonType> result = Alerts.showConfirmation("Thong bao","Đã thêm nhân viên");
            if (result.isPresent() && result.get()==ButtonType.OK){
                NhanVien nv = taoNhanVien();
                DSNhanVien.add(nv);
                DSNhanVienThem.add(nv);
                DSNhanVienphu.add(nv);
                docDuLieuNVVaoTableTTNhanVien();
            }else
                return;
        }

    }
    public void xoaTTNhanVien(ActionEvent actionEvent) {
        if (!tblViewTTNhanVien.getSelectionModel().isEmpty()){
            //Trường hợp chọn ở tbale thông tin nhân viên
            NhanVien nv = tblViewTTNhanVien.getSelectionModel().getSelectedItem();
            //Nếu nv ko tồn tại trong DSNhanVienThem thì lưu vào DSXoa
            if (!DSNhanVienThem.contains(nv))
                DSNhanVienXoa.add(nv);
                //Nếu tồn tại thì xóa khỏi DSnhanvien thêm
            else if (DSNhanVienThem.contains(nv))
                DSNhanVienThem.remove(nv);
            else if (DSNhanVienSua.contains(nv)) {
                DSNhanVienSua.remove(nv);
            }
            DSNhanVien.remove(nv);
            DSNhanVienphu.remove(nv);
        }
        if (!tblviewChiTietNhanVien.getSelectionModel().isEmpty()){
            //Trường hợp chọn tablechitietthongtinnhanvien
            NhanVien nv1 =tblviewChiTietNhanVien.getSelectionModel().getSelectedItem();
            if (!DSNhanVienThem.contains(nv1))
                DSNhanVienXoa.add(nv1);
            else if (DSNhanVienThem.contains(nv1)) {
                DSNhanVienThem.remove(nv1);
            } else if (DSNhanVienSua.contains(nv1))
                DSNhanVienSua.remove(nv1);

            DSNhanVien.remove(nv1);
            DSNhanVienphu.remove(nv1);
        }

    }

    public void xoaTrangTTNhanVien(ActionEvent actionEvent) {
        tfMaTTNhanVien.clear();
        tfTenTTNhanVien.clear();
        tfLuongCoBanTTNhanVien.clear();
        tfSoTaiKhoanTTNhanVien.clear();
        tfEmailTTNhanVien.clear();
        tfSoDienThoaiTTNhanVien.clear();
        datepickNgaySinhTTNhanVien.setValue(LocalDate.now());
        datepickNgayVaoLamTTNhanVien.setValue(LocalDate.now());
        cbxChucVuTTNhanVien.getSelectionModel().clearSelection();
        cbxPhongBanTTNhanVien.getSelectionModel().clearSelection();
        cbxPhuCapTTNhanVien.getSelectionModel().clearSelection();

    }

    public void chonROWTTNhanVien(MouseEvent mouseEvent) {
        //Chọn table thông tin nhân viên thì xóa chọn bên bảng chi tiết nhân viên
        tblviewChiTietNhanVien.getSelectionModel().clearSelection();
        //DSNhanVienphu chua co neu chon vao se bi loi
        NhanVien nvDuocChon;
        if (!DSNhanVien.isEmpty() && tblViewTTNhanVien.getSelectionModel().getSelectedItem() != null) {
            nvDuocChon = tblViewTTNhanVien.getSelectionModel().getSelectedItem();
            //Chọn xong thêm vào bảng chi tiết nhân viên bên dưới
            if (!DSNhanVienphu.contains(nvDuocChon))
                DSNhanVienphu.add(nvDuocChon);
            else if (DSNhanVienphu.contains(nvDuocChon)) {
                DSNhanVienphu.set(DSNhanVienphu.indexOf(nvDuocChon), nvDuocChon);
            }

            tfMaTTNhanVien.setText(nvDuocChon.getMaNV());
            tfTenTTNhanVien.setText(nvDuocChon.getHoNV() + " " + nvDuocChon.getTenNV());
            tfSoDienThoaiTTNhanVien.setText(nvDuocChon.getsDT());
            tfEmailTTNhanVien.setText(nvDuocChon.getEmail());
            tfSoTaiKhoanTTNhanVien.setText(nvDuocChon.getsTK());
            tfLuongCoBanTTNhanVien.setText(String.valueOf(nvDuocChon.getLuongCoBan()));
            ckGioiTinhTTNhanVien.setSelected(nvDuocChon.getGioiTinh());
            String phuCap = nvDuocChon.getPhuCap().getMaPhuCap();
            cbxChucVuTTNhanVien.setValue(nvDuocChon.getChucVuNV().getTenCV());
            cbxPhongBanTTNhanVien.setValue(nvDuocChon.getPhongBan().getTenPB());
            cbxPhuCapTTNhanVien.setValue(nvDuocChon.getPhuCap().getMaPhuCap());
            //ngay sinh

            LocalDate lcNgaySinh = new java.util.Date(nvDuocChon.getNgaySinh().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgaySinhTTNhanVien.setValue(lcNgaySinh);

            //ngay vao lam
            LocalDate lcNgayVaoLam = new java.util.Date(nvDuocChon.getNgayVaoLam().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgayVaoLamTTNhanVien.setValue(lcNgayVaoLam);

        } else
            return;
    }

    public void chonROWChiTietTTNhanVien(MouseEvent mouseEvent) {
        //Chọn table chi tiết nhân viên thì xóa  chọn table tt nhân viên
        tblViewTTNhanVien.getSelectionModel().clearSelection();
        //DSNhanVien chua co neu chon vao se bi loi
        if (!DSNhanVienphu.isEmpty() && tblviewChiTietNhanVien.getSelectionModel().getSelectedItem() != null){
            NhanVien nvDuocChon = tblviewChiTietNhanVien.getSelectionModel().getSelectedItem();

            tfMaTTNhanVien.setText(nvDuocChon.getMaNV());
            tfTenTTNhanVien.setText(nvDuocChon.getHoNV() + " " + nvDuocChon.getTenNV());
            tfSoDienThoaiTTNhanVien.setText(nvDuocChon.getsDT());
            tfEmailTTNhanVien.setText(nvDuocChon.getEmail());
            tfSoTaiKhoanTTNhanVien.setText(nvDuocChon.getsTK());
            tfLuongCoBanTTNhanVien.setText(String.valueOf(nvDuocChon.getLuongCoBan()));
            ckGioiTinhTTNhanVien.setSelected(nvDuocChon.getGioiTinh());
            String phuCap = nvDuocChon.getPhuCap().getMaPhuCap();
            cbxChucVuTTNhanVien.setValue(nvDuocChon.getChucVuNV().getTenCV());
            cbxPhongBanTTNhanVien.setValue(nvDuocChon.getPhongBan().getTenPB());
            cbxPhuCapTTNhanVien.setValue(nvDuocChon.getPhuCap().getMaPhuCap());

            //ngay sinh

            LocalDate lcNgaySinh = new java.util.Date(nvDuocChon.getNgaySinh().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgaySinhTTNhanVien.setValue(lcNgaySinh);

            //ngay vao lam
            LocalDate lcNgayVaoLam = new java.util.Date(nvDuocChon.getNgayVaoLam().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datepickNgayVaoLamTTNhanVien.setValue(lcNgayVaoLam);

        }else
            return;
    }
    /**
     * Lưu và reset tt nhân viên
    **/

    public void luuTTNhanVien(ActionEvent actionEvent) throws InterruptedException {
        Optional<ButtonType> reslut = Alerts.showConfirmation("Thông báo","Bạn có muốn lưu không?");
        if (reslut.isPresent() && reslut.get() == ButtonType.OK){
            //Có thể sai lưu dưới csdl sai vì cha biet khi nao bug
            // ...nên mấy cái lưu này tôi để true false, 3 cái đúng hết mới thông báo lưu thành công
            TimeUnit.SECONDS.sleep(1); // cho dung lai 1 giay truoc khi hien len va nay phai throws InterrupteddException
            if(QuanLyTTNhanVienDao.getInstance().saveDSNhanVienThem(DSNhanVienThem) && QuanLyTTNhanVienDao.getInstance().saveDSNhanVienXoa(DSNhanVienXoa) && QuanLyTTNhanVienDao.getInstance().svaeDSNhanVienSua(DSNhanVienSua)){
                Alerts.showConfirmation("Thông báo","Lưu thành công");
                DSNhanVienreset.clear();
                DSNhanVienreset.addAll(DSNhanVien);
                DSNhanVienThem.clear();
                DSNhanVienXoa.clear();
                DSNhanVienSua.clear();
            }else
                Alerts.showConfirmation("Thông báo","Lưu thất bại");
            //Luu DS Xoa
            //LuuDS Sua

        }else{
            return;
        }

    }
    public void resetBangTTNhanVien(ActionEvent actionEvent) {

        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo", "Xác nhận muốn reset, sau khi reset sẽ mất hết dữ liệu chưa lưu");
        if (result.isPresent() && result.get() == ButtonType.OK) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(DSNhanVienreset);
            DSNhanVienSua.clear();
            DSNhanVienThem.clear();
            DSNhanVienXoa.clear();
            DSNhanVienphu.clear();
        }else {
            return;
        }
        loadComboboxChucVu();
        loadComboboxPhongBan();
        loadComboxChucVuNhapTTNhanVien();
        loadComboboxPhongBanNhapTTNhanVien();
        loadComboboxPhuCapNhapTTNhanVien();
    }


    public void suaTTNhanVien(ActionEvent actionEvent) {
        NhanVien nvSUa = new NhanVien();
        // ở đây tôi không check dữ liệu nào thay đổi vì vậy sẽ mất ram xử lý cho phần đó
        // và phải ràng buộc phần nhập...tất nhiên rồi
        if (kiemTraNhapTTNhanVien()){

            xoaDuLieuDSChucVuNeuDaCoDuL();
            DSChucVu.addAll(QuanLyTTNhanVienDao.getInstance().getAllChucVuNhanVien());
            xoaDuLieuDSPhongBanNeuDaCoDuL();
            DSPhongBan.addAll(QuanLyTTNhanVienDao.getInstance().getAllPhongBan());

            String hoNV = tachHoTuHovaTen(tfTenTTNhanVien.getText().trim());
            String tenNV = tachTenTuHovaTen(tfTenTTNhanVien.getText().trim());
            boolean gioiTinh = ckGioiTinhTTNhanVien.isSelected();

            LocalDate localDate = datepickNgaySinhTTNhanVien.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date ngaySinh = Date.from(instant);

            String sDT = tfSoDienThoaiTTNhanVien.getText().trim();
            String email = tfEmailTTNhanVien.getText().trim();

            LocalDate localDate2 = datepickNgayVaoLamTTNhanVien.getValue();
            Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
            Date ngayVaoLam=  Date.from(instant2);

            String sTK = tfSoTaiKhoanTTNhanVien.getText().trim();

            String chucVu = cbxChucVuTTNhanVien.getValue().trim();
            ChucVu cv = new ChucVu();
            for (ChucVu cv1 : DSChucVu)
                if (cv1.getTenCV().equals(chucVu))
                    cv = cv1;

            String phongBan = cbxPhongBanTTNhanVien.getValue().trim();
            PhongBan pb = new PhongBan();
            for (PhongBan pb1 : DSPhongBan)
                if (pb1.getTenPB().equals(phongBan))
                    pb = pb1;

            PhuCap pc = new PhuCap(cbxPhuCapTTNhanVien.getValue().toString());
            double luongCoBan = Double.parseDouble(tfLuongCoBanTTNhanVien.getText().trim());

            nvSUa.setMaNV(tfMaTTNhanVien.getText().trim());
            nvSUa.setHoNV(hoNV); nvSUa.setTenNV(tenNV); nvSUa.setGioiTinh(gioiTinh); nvSUa.setNgaySinh(ngaySinh);
            nvSUa.setsDT(sDT); nvSUa.setEmail(email); nvSUa.setNgayVaoLam(ngayVaoLam); nvSUa.setsTK(sTK); nvSUa.setChucVuNV(cv);
            nvSUa.setPhongBan(pb); nvSUa.setPhuCap(pc); nvSUa.setLuongCoBan(luongCoBan);

            //Ở đây có 2 hướng xử lí là
            // Cách 1: lấy thằng nv trong DS ra bằng NhanVien nv =DSNhanVien.get(Indexof(nvSua): get lấy element trong ds bằng giá trị int,  Indexof: trả về vi
            // trí thằng nv tồn tại trong ds vì nó so sánh bằng cái hashcxode,equal mà NhanVien HashCode, equal của là maNV nên nó
            //so sánh mã của thằng nvSua voi từng element trong DSNhanVien nào trùng mã thì nó trả về vị trí thằng đó, sau đó
            //ta thực hiện DSNhanVien.remove(nv) sau đó thêm lại thằng nvSua vào DSNhanVien.Những việc này sẽ làm thằng mình sửa mất
            //taị vị trí cũ và bị đẩy xuống cuối bảng làm cho t ko thể quan sát được việc thay đổi của nó.
            //
            // Cách 2: Vì tôi tìm hiểu rằng thằng Obserlist biết lắng nghe nên ta chỉ cần set lại giá trị trong DS đó
            //Bằng cách DSNhanVien.set(vị trí muốn sửa,Giá trị mới muốn sửa).tôi chọn cách 2 vì nó quan sát dược việc thay đổi
            //nhưng ko biết có phải HSK ko giải thích trước để mốt có quên nói lại

            DSNhanVien.set(DSNhanVien.indexOf(nvSUa),nvSUa);
            DSNhanVienphu.set(DSNhanVienphu.indexOf(nvSUa),nvSUa);

            //Trường hợp nv sửa nằm trong DSNhanVienThem ta thay đổi giá trị nó
            if (DSNhanVienThem.contains(nvSUa))
                DSNhanVienThem.set(DSNhanVienThem.indexOf(nvSUa),nvSUa);
            //Trường hợp nv sửa ko nằm trong DSNhanVienThem và có trong DSNhanVienSua ta set lai trong DSNhanVienSua
            else if (!DSNhanVienThem.contains(nvSUa) && DSNhanVienSua.contains(nvSUa))
                DSNhanVienSua.set(DSNhanVienSua.indexOf(nvSUa),nvSUa);
            //Trường hợp cuối ko nằm trong cả 2 DSNhanVienSua và DSNhanVienThem ta add nó vô DSNhanVienSua
            else if (!DSNhanVienThem.contains(nvSUa) && !DSNhanVienSua.contains(nvSUa))
                DSNhanVienSua.add(nvSUa);


        }
    }
}
