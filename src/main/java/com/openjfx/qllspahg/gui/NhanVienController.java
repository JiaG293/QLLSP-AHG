package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.ChucVuDao;
import com.openjfx.qllspahg.dao.NhanVienDao;
import  static com.openjfx.qllspahg.dao.interfaces.InterfaceNhanViendao.DSNhanVien;
import static com.openjfx.qllspahg.dao.interfaces.InterfacePhongBandao.DSPhongBan;
import static com.openjfx.qllspahg.dao.interfaces.InterfaceChucVudao.DSChucVu;

import com.openjfx.qllspahg.dao.PhongBanDao;
import com.openjfx.qllspahg.entity.ChucVu;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
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
    private ComboBox<?> cbxChucVuTTNhanVien;

    @FXML
    private ComboBox<String> cbxLoadChucVuTTNhanVien;

    @FXML
    private ComboBox<String> cbxLoadGioiTinhTTNhanVien;

    @FXML
    private ComboBox<String> cbxLoadPhongBanTTNhanVien;

    @FXML
    private ComboBox<?> cbxPhongBanTTNhanVien;

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
    private TableView<NhanVien> tblViewTTNhanVien;

    @FXML
    private TableView<?> tblviewChiTietNhanVien;

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

    }

    /**
     * Bảng thông tin nhân viên
     */

    /**
     * Phan load du lieu
     */
    public void loaComboboxGioiTinh(){
        ObservableList<String> gioiTinh= FXCollections.observableArrayList(
                "Nam","Nu"
        );
        cbxLoadGioiTinhTTNhanVien.setItems(gioiTinh);
    }
    public void loadComboboxChucVu(){
        DSChucVu.addAll(ChucVuDao.getInstance().getAllChucVuNhanVien());
        ObservableList<String> dsTenChucVu = FXCollections.observableArrayList();
        for (ChucVu cv :DSChucVu){
            dsTenChucVu.add(cv.getTenCV());
        }
        cbxLoadChucVuTTNhanVien.setItems(dsTenChucVu);
    }
    public void loadComboboxPhongBan(){
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
        xoaChonCbxLoadDuLieu();
    }


    public void xoaDuLieuDSNhanVienNeuDaCoDuL(){
        if(!DSNhanVien.isEmpty())
            DSNhanVien.clear();
    }
    public void xoaChonCbxLoadDuLieu(){
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
}
