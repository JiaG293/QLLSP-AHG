package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChucVuDao;
import com.openjfx.qllspahg.dao.NhanVienDao;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSSANPHAM;
import  static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVien;
import static com.openjfx.qllspahg.dao.interfaces.InterfacePhongBandao.DSPhongBan;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceChucVudao.DSChucVu;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSChamCongNhanVien;
import static com.openjfx.qllspahg.dao.interfaces.InterfacePhuCapDao.DSPhuCap;

import com.openjfx.qllspahg.dao.PhongBanDao;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.CheckCell;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
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
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class NhanVienController implements Initializable{

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
    private CheckBox ckGioiTinhTTNhanVien;

    @FXML
    private CheckBox ckPhuCapTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietChucVuTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietEmailTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietGioiTinhTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietHovaTenTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietMaTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietNgaySinhTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietNgayVaoLamTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietPhongBanTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietPhuCapTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietSoDienThoaiTTNhanVien;

    @FXML
    private TableColumn<?, ?> colChiTietSoTaiKhoanTTNhanVien;

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
    private TextField tfLuongCoBanTTNhanVien;

    @FXML
    private TableView<NhanVien> tblViewTTNhanVien;

    @FXML
    private TableView<?> tblviewChiTietNhanVien;

    @FXML
    private TableColumn<?, ?> colHoTenChamCongNV;

    @FXML
    private TableColumn<?, ?> colMaChamCongNV;

    @FXML
    private TableColumn<NhanVien, String> colPhongBanChamCongNV;

    @FXML
    private TableView<NhanVien> tblviewChamCongNV;

    @FXML
    private TextField tfEmailTTNhanVien;

    @FXML
    private TextField tfSoDienThoaiTTNhanVien;

    @FXML
    private TextField tfSoTaiKhoanTTNhanVien;

    @FXML
    private TextField tfTenTTNhanVien;
    private int giaTriReset = 0;

    @FXML
    private Tab tabChamCongNhanVien;

    @FXML
    private TableColumn<BangChamCongNhanVien, Date> colNgayChamCong;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckDiLam;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckNghiPhep;

    @FXML
    private TableColumn<BangChamCongNhanVien, Boolean> colCheckTangCa;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*loaComboboxGioiTinh();
        loadComboboxChucVu();
        loadComboboxPhongBan();
        loadComboxChucVuNhapTTNhanVien();
        loadComboboxPhongBanNhapTTNhanVien();
        datepickNgayVaoLamTTNhanVien.setValue(LocalDate.now());
        docDuLieuNVVaoTableTTNhanVien();*/


        chamCongNhanVien();

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
        DSChucVu.addAll(ChucVuDao.getInstance().getAllChucVuNhanVien());
        ObservableList<String> dsChucVu = FXCollections.observableArrayList();
        for (ChucVu cv : DSChucVu){
            dsChucVu.add(cv.getTenCV());
        }
        cbxChucVuTTNhanVien.setItems(dsChucVu);
    }
    private void loadComboboxPhongBanNhapTTNhanVien(){
        if (!DSPhongBan.isEmpty())
            DSPhongBan.clear();
        DSPhongBan.addAll(PhongBanDao.getInstance().getAllPhongBan());
        ObservableList dsPB = FXCollections.observableArrayList();
        for(PhongBan pb : DSPhongBan)
            dsPB.add(pb.getTenPB());
        cbxPhongBanTTNhanVien.setItems(dsPB);

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
        DSChucVu.addAll(ChucVuDao.getInstance().getAllChucVuNhanVien());
        ObservableList<String> dsChucVu = FXCollections.observableArrayList();
        for (ChucVu cv :DSChucVu){
            dsChucVu.add(cv.getTenCV());
        }
        cbxLoadChucVuTTNhanVien.setItems(dsChucVu);
    }
    private void loadComboboxPhongBan(){
        if (!DSPhongBan.isEmpty())
            DSPhongBan.clear();
        DSPhongBan.addAll(PhongBanDao.getInstance().getAllPhongBan());
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
            DSNhanVien.addAll(NhanVienDao.getInstance().getAllNhanVien());
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 1;
         //cbx load phòng ban không được chọn và cbx chúc vụ và giới tính được chọn
        }  else if (cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty())  {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGTvaCV(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu"? "1" : "0",cbxLoadChucVuTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 2 ;
            //cbx load phòng ban được chọn, cbx chức vụ,giới tính ko được chọn
        } else if (!cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoPB(cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 3;
            //cbx load chức vụ ko được chọn, cbx giới tính và phòng ban được chọn
        } else if (cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGTvaPB(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu" ? "1" : "0",cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 4;
            //cbx load chúc vụ được chọn và, cbx giới tính, phòng ban không đoc75 chọn
        } else if (!cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoCV(cbxLoadChucVuTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 5;
            //cbx load giới tính không được chọn, cbx load chức vụ, phòng ban được chọn
        } else if (cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoCVvaPB(cbxLoadChucVuTTNhanVien.getValue().toString(),cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 6;
            //cbx load giới tính được chọn, cbx load chức vụ, phòng ban không được chọn
        } else if (!cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGT(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu"? "1" : "0"));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 7;
            // cbx load giới tính, phòng ban, chúc vụ được chọn
        } else if (!(cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty())) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGTvaCVvaPB(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu"? "1" :"0",cbxLoadChucVuTTNhanVien.getValue().toString(),cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();
            giaTriReset = 8;

        }
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
    private void xoaDuLieuDSPhuCapNeuDaCoDuL(){
        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
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
    /**
     * Phần xử lý Thêm xóa sửa nhân viên
     */

    public void resetBangTTNhanVien(ActionEvent actionEvent) {

    }

    private String tachHoTuHovaTen(String hoVaTen){
        String ho = hoVaTen.substring(0,hoVaTen.indexOf(" "));
        /**
         * subtring truyền vào thứ tự bắt đầu của chuỗi và thứ tự kết thúc của chuỗi muốn ngắt
         * hoVaten.indexof trả về thứ tự mà khoảng trắng xuất hiện đầu tiên
         */
        return ho;
    }
    public String tachTenTuHovaTen (String hovaTen){
        String ten ;
        if (!(hovaTen.lastIndexOf(" ") == -1)){
            ten = hovaTen.substring(hovaTen.indexOf(" "));
        }else {
            ten = "";
        }
        /**
         * Loại subtring truyền vào thứ tự bắt đầu của chuỗi muốn ngắt và trả về toàn bộ chuỗi phía sau.
         */
        return ten;
    }

    private boolean kiemTraNhapTTNhanVien(){
        //Kiểm tra tên nhan viên
        if (!(tfTenTTNhanVien.getText().trim().length()>0)){
            Alerts.showConfirmation("Thông báo","Chưa nhập tên nhân viên");
            tfTenTTNhanVien.setText("");
            tfTenTTNhanVien.requestFocus();
            return false;
        } else if (!(tachTenTuHovaTen(tfTenTTNhanVien.getText().trim()).length()>0)) {
            Alerts.showConfirmation("Thông báo","Tên phải gồm họ và tên");
            tfTenTTNhanVien.setText("");
            tfTenTTNhanVien.requestFocus();
            return false;
        } else if (!(tfTenTTNhanVien.getText().toString().matches("([A-Z]{1}[a-z' ]+)+"))){
            Alerts.showConfirmation("Thông báo", "Tên phải bắt đầu là chữ cái in hoa và không chứa số");
            tfTenTTNhanVien.setText("");
            tfTenTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra ngày sinh
        if (datepickNgaySinhTTNhanVien.getValue() == null){
            Alerts.showConfirmation("Thông báo", "Chưa chọn ngày sinh nhân viên");
            datepickNgaySinhTTNhanVien.requestFocus();
            return false;
        }else {
            LocalDate lc = datepickNgaySinhTTNhanVien.getValue();
            int namSinh = lc.getYear();
            int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
            int tuoi = namHienTai-namSinh;

            if (!(tuoi>=18 && tuoi <60)  ){
                Alerts.showConfirmation("Thong bao","Nhân viên phải có tuổi từ 18 và dưới 60");
                datepickNgaySinhTTNhanVien.requestFocus();
                return false;
            }
        }
        //Kiểm tra số điện thoại
        if (!(tfSoDienThoaiTTNhanVien.getText().trim().length()>0)){
            Alerts.showConfirmation("Thông báo","Chưa nhập số điện thoại");
            tfSoDienThoaiTTNhanVien.setText("");
            tfSoDienThoaiTTNhanVien.requestFocus();
            return false;
        } else  {
            try {
                int sdt = Integer.parseInt(tfSoDienThoaiTTNhanVien.getText().trim());
                if (!(String.valueOf(sdt).matches("\\d{10}"))){
                    Alerts.showConfirmation("Thông báo", "Số diện thoại phải 10 số");
                    tfSoDienThoaiTTNhanVien.requestFocus();
                    tfSoDienThoaiTTNhanVien.setText("");
                    return false;
                }
            }catch (NumberFormatException e){
                Alerts.showConfirmation("Thông báo", "Số diện thoại phải là số");
                tfSoDienThoaiTTNhanVien.requestFocus();
                tfSoDienThoaiTTNhanVien.setText("");
                return false;
            }
        }
        //Kiểm tra email
        if (!(tfEmailTTNhanVien.getText().trim().length()>0)){
            Alerts.showConfirmation("Thông báo","Chưa nhập email");
            tfEmailTTNhanVien.requestFocus();
            tfEmailTTNhanVien.setText("");
            return false;
        } else if (!(tfEmailTTNhanVien.getText().trim().matches("^(?!\\.)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            Alerts.showConfirmation("Thông báo","Nhập sai định dạng email");
            tfEmailTTNhanVien.requestFocus();
            tfEmailTTNhanVien.setText("");
            return false;
        }
        //Kiểm tra số tài khoản ngân hàng
        if (!(tfSoTaiKhoanTTNhanVien.getText().trim().length()>0)){
            Alerts.showConfirmation("Thông báp","Chưa nhập tài khoản");
            tfSoTaiKhoanTTNhanVien.requestFocus();
            tfSoTaiKhoanTTNhanVien.setText("");
            return false;
        }else {
            try {
                int soTK = Integer.parseInt(tfSoTaiKhoanTTNhanVien.getText().trim());
            }catch (NumberFormatException e){
                Alerts.showConfirmation("Thông báp","Số tài khoản là phải là số");
                tfSoTaiKhoanTTNhanVien.requestFocus();
                tfSoTaiKhoanTTNhanVien.setText("");
                return false;
            }
        }
        //Kiểm tra phòng ban có chọn không
        if (cbxPhongBanTTNhanVien.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Phải chọn phòng ban");
            cbxPhongBanTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra chức vụ có được chọn không
        if (cbxChucVuTTNhanVien.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo","Phải chọn chức vụ");
            cbxChucVuTTNhanVien.requestFocus();
            return false;
        }
        //Kiểm tra lương cơ bản
        if (!(tfLuongCoBanTTNhanVien.getText().trim().length()>0)){
            Alerts.showConfirmation("Thông báo","Chưa nhập lương cơ bản của nhân viên");
            tfLuongCoBanTTNhanVien.requestFocus();
            tfLuongCoBanTTNhanVien.setText("");
            return false;
        }else {
            try {
                int luong = Integer.parseInt(tfLuongCoBanTTNhanVien.getText().trim());
            }catch (NumberFormatException e){
                Alerts.showConfirmation("Thông báo","Lương cơ bản phải là số");
                tfLuongCoBanTTNhanVien.requestFocus();
                tfLuongCoBanTTNhanVien.setText("");
                return false;
            }
        }

        return true;
    }
    private int timMANhanVienLonNhatTrenBang() {
        /**
         * Nếu mã DSnhanVien rỗng thì trả về ma = 0
         * nếu không tìm mã lớn nhất trong đây
         */
        int ma = 0;
        int maNVLonNhatTuBang;
        if (DSNhanVien.isEmpty()) {
            return ma = 0;
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
        String maNVLonNhatTuCSDL = NhanVienDao.getInstance().getMaNhanVienLonNhat();
        int maNVLonNhaTtuCSDLChuyenSangSo = Integer.parseInt(maNVLonNhatTuCSDL.substring(2)); //Lấy sau phần tử thứ 2 tới hết vì mã có định dạng chung là CN****
        int maNVLonNhattuBang = timMANhanVienLonNhatTrenBang();
        int maNVLonNhat = 0;
        if (maNVLonNhaTtuCSDLChuyenSangSo > maNVLonNhattuBang){
            maNVLonNhat = maNVLonNhaTtuCSDLChuyenSangSo;
        } else if (maNVLonNhaTtuCSDLChuyenSangSo < maNVLonNhattuBang) {
            maNVLonNhat =maNVLonNhattuBang;
        } else if (maNVLonNhaTtuCSDLChuyenSangSo == maNVLonNhattuBang) {
            maNVLonNhat = maNVLonNhaTtuCSDLChuyenSangSo;
        }
         int maSoNVfinal = maNVLonNhat+1;

        String maNVfinal = "";
        if (String.valueOf(maSoNVfinal).length() ==1 ){
            maNVfinal ="NV"+ "000" + String.valueOf(maSoNVfinal);
        }else if (String.valueOf(maSoNVfinal).length() == 2) {
            maNVfinal = "MV" + "00" + String.valueOf(maSoNVfinal);
        }else if (String.valueOf(maSoNVfinal).length() == 3) {
            maNVfinal = "NV" + "0"+ String.valueOf(maSoNVfinal);
        }else if (String.valueOf(maSoNVfinal).length()==4) {
            maNVfinal = "CN"+ String.valueOf(maSoNVfinal);
        }

        return maNVfinal;
    }
    private NhanVien taoNhanVien(){
        xoaDuLieuDSChucVuNeuDaCoDuL();
        DSChucVu.addAll(ChucVuDao.getInstance().getAllChucVuNhanVien());
        xoaDuLieuDSPhongBanNeuDaCoDuL();
        DSPhongBan.addAll(PhongBanDao.getInstance().getAllPhongBan());


        String maNV = taoMaNhanVien();
        String hoNV = tachHoTuHovaTen(tfTenTTNhanVien.getText().trim());
        String tenNV = tachTenTuHovaTen(tfTenTTNhanVien.getText().trim());
        boolean gioiTinh = ckGioiTinhTTNhanVien.isSelected();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate = datepickNgaySinhTTNhanVien.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date ngaySinh =  java.sql.Date.from(instant);

        int sDT = Integer.parseInt(tfSoDienThoaiTTNhanVien.getText().trim());
        String email = tfEmailTTNhanVien.getText().trim();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate2 = datepickNgayVaoLamTTNhanVien.getValue();
        Instant instant2 = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date ngayVaoLam= Date.from(instant2);

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
        boolean phuCap = ckPhuCapTTNhanVien.isSelected();
        String maPhuCap = "";
        if (phuCap){
            maPhuCap = "PCNVCI";
        }else {
            maPhuCap = "PCNVTT";
        }
        PhuCap pc = new PhuCap(maPhuCap);

        double luongCoBan = Double.parseDouble(tfLuongCoBanTTNhanVien.getText().trim());

        return new NhanVien(maNV,hoNV,tenNV,gioiTinh,ngaySinh,sDT,email,ngayVaoLam,sTK,cv,pb,pc,luongCoBan);

    }

    public void themTTNhanVien(ActionEvent actionEvent) {
        if (kiemTraNhapTTNhanVien()){
            Alerts.showConfirmation("Thong bao","Đã thêm nhân viên");
            NhanVien nv = taoNhanVien();
            DSNhanVien.add(nv);
            docDuLieuNVVaoTableTTNhanVien();
        }

    }


    /*Cham Cong Nhan Vien*/
    public void tabChamCongNhanVien() {

        colMaChamCongNV.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        colHoTenChamCongNV.setCellValueFactory(new PropertyValueFactory<>("hoNV"));
        colTenTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        colPhongBanChamCongNV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getPhongBan().getTenPB());
            }
        });
        colNgayChamCong.setCellValueFactory(new PropertyValueFactory<>("ngayCC"));

        colCheckDiLam.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> param) {
                return new CheckCell();
            }
        });

        colCheckNghiPhep.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
            @Override
            public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> param) {
                return new CheckCell();
            }
        });
        colCheckTangCa.setCellFactory(new Callback<TableColumn<BangChamCongNhanVien, Boolean>, TableCell<BangChamCongNhanVien, Boolean>>() {
                    @Override
                    public TableCell<BangChamCongNhanVien, Boolean> call(TableColumn<BangChamCongNhanVien, Boolean> param) {
                        return new CheckCell();
                    }
                });


    }


    public void chamCongNhanVien(){
        if (!DSChamCongNhanVien.isEmpty()) {
            DSChamCongNhanVien.clear();
        }
        tabChamCongNhanVien();
        DSChamCongNhanVien.addAll(NhanVienDao.getInstance().getBangChamCongNV());
        tblviewChamCongNV.setItems(DSChamCongNhanVien);
    }

    public void taoTableChamCong(){

    }

    @FXML
    void chonMotNhanVien(MouseEvent event) {
        //Lay vi tri san pham duoc chon
        NhanVien nvDuocChon = tblviewChamCongNV.getSelectionModel().getSelectedItem();
        System.out.println("nhan vien duoc chon" + nvDuocChon.toString());

        System.out.println(NhanVienDao.getInstance().InsertBangChamCong(NhanVienDao.getInstance().getBangChamCongNV()));
    }




}
