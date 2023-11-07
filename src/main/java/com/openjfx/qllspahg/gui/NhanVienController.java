package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChucVuDao;
import com.openjfx.qllspahg.dao.NhanVienDao;
import  static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVien;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVienThem;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVienXoa;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVienSua;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVienreset;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVienphu;

import static com.openjfx.qllspahg.dao.interfaces.InterfacePhongBandao.DSPhongBan;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceChucVudao.DSChucVu;



import com.openjfx.qllspahg.dao.PhongBanDao;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.gui.util.Alerts;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
    private TableColumn<NhanVien, String> colChiTietNgaySinhTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietNgayVaoLamTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietPhongBanTTNhanVien;

    @FXML
    private TableColumn<NhanVien, String> colChiTietPhuCapTTNhanVien;

    @FXML
    private TableColumn<NhanVien, Integer> colChiTietSoDienThoaiTTNhanVien;

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
        datepickNgayVaoLamTTNhanVien.setValue(LocalDate.now());
        docDuLieuNVVaoTableTTNhanVien();

        ckPhuCapTTNhanVien.setSelected(true);

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
                "Nam","Nu"
        );
        cbxLoadGioiTinhTTNhanVien.setItems(gioiTinh);
    }
    private void loadComboboxChucVu(){
        if (!DSChucVu.isEmpty())
            DSChucVu.clear();
        DSChucVu.addAll(ChucVuDao.getInstance().getAllChucVuNhanVien());
        ObservableList<String> dsTenChucVu = FXCollections.observableArrayList();
        for (ChucVu cv :DSChucVu){
            dsTenChucVu.add(cv.getTenCV());
        }
        cbxLoadChucVuTTNhanVien.setItems(dsTenChucVu);
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

         //cbx load phòng ban không được chọn và cbx chúc vụ và giới tính được chọn
        }  else if (cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty())  {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGTvaCV(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu"? "1" : "0",cbxLoadChucVuTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load phòng ban được chọn, cbx chức vụ,giới tính ko được chọn
        } else if (!cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoPB(cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load chức vụ ko được chọn, cbx giới tính và phòng ban được chọn
        } else if (cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGTvaPB(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu" ? "1" : "0",cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load chúc vụ được chọn và, cbx giới tính, phòng ban không đoc75 chọn
        } else if (!cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoCV(cbxLoadChucVuTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load giới tính không được chọn, cbx load chức vụ, phòng ban được chọn
        } else if (cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && !cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoCVvaPB(cbxLoadChucVuTTNhanVien.getValue().toString(),cbxLoadPhongBanTTNhanVien.getValue().toString()));
            docDuLieuNVVaoTableTTNhanVien();

            //cbx load giới tính được chọn, cbx load chức vụ, phòng ban không được chọn
        } else if (!cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty()) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGT(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu"? "1" : "0"));
            docDuLieuNVVaoTableTTNhanVien();

            // cbx load giới tính, phòng ban, chúc vụ được chọn
        } else if (!(cbxLoadGioiTinhTTNhanVien.getSelectionModel().isEmpty() && cbxLoadChucVuTTNhanVien.getSelectionModel().isEmpty() && cbxLoadPhongBanTTNhanVien.getSelectionModel().isEmpty())) {
            xoaDuLieuDSNhanVienNeuDaCoDuL();
            DSNhanVien.addAll(NhanVienDao.getInstance().getNhanVienTheoGTvaCVvaPB(cbxLoadGioiTinhTTNhanVien.getValue().toString()=="Nu"? "1" :"0",cbxLoadChucVuTTNhanVien.getValue().toString(),cbxLoadPhongBanTTNhanVien.getValue().toString()));
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
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getHoNV()+ " " + nhanVienStringCellDataFeatures.getValue().getTenNV());
            }
        });
        colChiTietGioiTinhTTNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NhanVien, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NhanVien, String> nhanVienStringCellDataFeatures) {
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getGioiTinh()? "Nu" : "Nam");
            }
        });
        colChiTietNgaySinhTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        colChiTietNgayVaoLamTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("ngayVaoLam"));
        colChiTietSoDienThoaiTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("sDT"));
        colChiTietEmailTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("email"));
        colChiTietSoTaiKhoanTTNhanVien.setCellValueFactory(new PropertyValueFactory<>("sTK"));
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
                return new SimpleStringProperty(nhanVienStringCellDataFeatures.getValue().getMaPhuCap().getMaPhuCap() == "PCNVCI" ? "Co" : "Khong");
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
    public String tachTenTuHovaTen (String hovaTen){
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
        } else if (!(tfTenTTNhanVien.getText().toString().matches("([A-Z]{1}[a-z' ]*)+"))){
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
                double luong = Double.parseDouble(tfLuongCoBanTTNhanVien.getText().trim());
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

        int maNVLonNhaTtuCSDLChuyenSangSo;
        if (maNVLonNhatTuCSDL.equals(null)){
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
        Date ngaySinh = Date.from(instant);

        int sDT = Integer.parseInt(tfSoDienThoaiTTNhanVien.getText().trim());
        String email = tfEmailTTNhanVien.getText().trim();

        //không biết chuyển datepick sang Date nên cop code mạng...
        LocalDate localDate2 = datepickNgayVaoLamTTNhanVien.getValue();
        Instant instant2 = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
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
            Optional<ButtonType> result = Alerts.showConfirmation("Thong bao","Đã thêm nhân viên");
            if (result.isPresent() && result.get()==ButtonType.OK){
                NhanVien nv = taoNhanVien();
                DSNhanVien.add(nv);
                DSNhanVienThem.add(nv);
                docDuLieuNVVaoTableTTNhanVien();
            }else
                return;
        }

    }
    public void xoaTTNhanVien(ActionEvent actionEvent) {
        NhanVien nv = tblViewTTNhanVien.getSelectionModel().getSelectedItem();
        //Nếu nv ko tồn tại trong DSNhanVienThem thì lưu vào DSXoa
        if (!DSNhanVienThem.contains(nv))
            DSNhanVienXoa.add(nv);
        else if (DSNhanVienThem.contains(nv))
            DSNhanVienThem.remove(nv);

        DSNhanVien.remove(nv);
    }

    public void xoaTrangTTNhanVien(ActionEvent actionEvent) {
        tfTenTTNhanVien.clear();
        tfLuongCoBanTTNhanVien.clear();
        tfSoTaiKhoanTTNhanVien.clear();
        tfEmailTTNhanVien.clear();
        tfSoDienThoaiTTNhanVien.clear();
        datepickNgaySinhTTNhanVien.setValue(null);

    }
    public boolean KiemTraPhuCap(NhanVien nv){
        if ("PCNVTT" != nv.getMaPhuCap().getMaPhuCap())
            return true;
        return false;
    }

    public void chonROWTTNhanVien(MouseEvent mouseEvent) {
        //DSNhanVien chua co neu chon vao se bi loi
        if (!DSNhanVien.isEmpty()){
            NhanVien nvDuocChon = tblViewTTNhanVien.getSelectionModel().getSelectedItem();

                if (!DSNhanVienphu.contains(nvDuocChon))
                    DSNhanVienphu.add(nvDuocChon);



            tfTenTTNhanVien.setText(nvDuocChon.getHoNV() + " " + nvDuocChon.getTenNV());
            tfSoDienThoaiTTNhanVien.setText(String.valueOf(nvDuocChon.getsDT()));
            tfEmailTTNhanVien.setText(nvDuocChon.getEmail());
            tfSoTaiKhoanTTNhanVien.setText(nvDuocChon.getsTK());
            tfLuongCoBanTTNhanVien.setText(String.valueOf(nvDuocChon.getLuongCoBan()));
            ckGioiTinhTTNhanVien.setSelected(nvDuocChon.getGioiTinh());
            String phuCap = nvDuocChon.getMaPhuCap().getMaPhuCap();
            ckPhuCapTTNhanVien.setSelected(phuCap == "PCNVTT"? false : true);
            cbxChucVuTTNhanVien.setValue(nvDuocChon.getChucVuNV().getTenCV());
            cbxPhongBanTTNhanVien.setValue(nvDuocChon.getPhongBan().getTenPB());
//        //ngay sinh
//        java.util.Date ngaySinh =nvDuocChon.getNgaySinh();
//        Instant instant = ngaySinh.toInstant();
//        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
//        LocalDate localDate = zdt.toLocalDate();
//
//        datepickNgaySinhTTNhanVien.setValue(localDate);
//
//        //ngay vao lam
//        Instant ins = nvDuocChon.getNgayVaoLam().toInstant();
//        ZonedDateTime zdtime = ins.atZone(ZoneId.systemDefault());
////        LocalDate lc = zdtime.toLocalDate();
//
//        datepickNgayVaoLamTTNhanVien.setValue(lc);
        }else
            return;



    }
    /**
     * Lưu và reset tt nhân viên
    **/

    public void luuTTNhanVien(ActionEvent actionEvent) throws InterruptedException {
        Optional<ButtonType> reslut = Alerts.showConfirmation("Thông báo","Có muốn lưu không");
        if (reslut.isPresent() && reslut.get() == ButtonType.OK){
            //Có thể sai lưu dưới csdl sai vì cha biet khi nao bug
            // ...nên mấy cái lưu này tôi để true false, 3 cái đúng hết mới thông báo lưu thành công
            TimeUnit.SECONDS.sleep(1); // cho dung lai 1 giay truoc khi hien len va nay phai throws InterrupteddException
            if(NhanVienDao.getInstance().saveDSNhanVienThem(DSNhanVienThem) && NhanVienDao.getInstance().saveDSNhanVienXoa(DSNhanVienXoa)){
                Alerts.showConfirmation("Thông báo","Lưu thành công");
            }else
                Alerts.showConfirmation("Thông báo","Lưu thất bại");
            //Luu DS Xoa
            //LuuDS Sua
            DSNhanVienreset.clear();
            DSNhanVienreset.addAll(DSNhanVien);
            DSNhanVienThem.clear();
            DSNhanVienXoa.clear();
            DSNhanVienSua.clear();
        }else{
            return;
        }
    }
    public void resetBangTTNhanVien(ActionEvent actionEvent) {

        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo", "Xác nhận muốn reset, sau khi xóa sẽ mất hết dữ liệu chưa lưu");
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
    }

}
