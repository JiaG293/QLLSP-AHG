package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.DanhSachHopDongImpl;
import com.openjfx.qllspahg.dao.QuanLySanPhamDaoImpl;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCONGDOAN;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSSANPHAM;

import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class QuanLySanPhamController implements Initializable {

    @FXML
    private ComboBox<String> cbxGiaiDoanCD;

    @FXML
    private ComboBox<String> cbxLoaiSP;

    @FXML
    private ComboBox<String> cbxLocLoaiSanPham;

    @FXML
    private TableColumn<SanPham, Double> colGiaCongDoan;

    @FXML
    private TableColumn<SanPham, Double> colGiaSanPham;

    @FXML
    private TableColumn<CongDoan, String> colGiaiDoanCongDoan;

    @FXML
    private TableColumn<SanPham, String> colLoaiSanPham;

    @FXML
    private TableColumn<CongDoan, String> colMaCongDoan;

    @FXML
    private TableColumn<SanPham, String> colMaSanPham;

    @FXML
    private TableColumn<CongDoan, Integer> colSTTCongDoan;

    @FXML
    private TableColumn<SanPham, Integer> colSTTSanPham;

    @FXML
    private TableColumn<CongDoan, String> colTenCongDoan;

    @FXML
    private TableColumn<SanPham, String> colTenSanPham;

    @FXML
    private TableView<CongDoan> tblCongDoan;

    @FXML
    private TableView<SanPham> tblSanPham;

    @FXML
    private TextField tfGiaiDoanKhacCD;

    @FXML
    private TextField tfGiaCD;

    @FXML
    private TextField tfGiaSP;

    @FXML
    private TextField tfLocMaSP;

    @FXML
    private TextField tfLocTenSP;

    @FXML
    private TextField tfMaCD;

    @FXML
    private TextField tfMaSPCD;

    @FXML
    private TextField tfMaSP;

    @FXML
    private TextField tfTenCD;

    @FXML
    private TextField tfTenSP;

    private static SanPham sanPhamDuocChonTableView;

    @FXML
    void CapNhatDuLieuTableView(ActionEvent event) {

    }

    @FXML
    void chonMotCongDoan(MouseEvent event) {
        CongDoan cd = chonMotCongDoanTableView();

        if (cd != null) {
            String[] giaiDoanCBX = {"Cắt", "May", "Hoàn thành", "Đóng gói"};

            tfMaCD.setText(cd.getMaCD());
            tfTenCD.setText(cd.getTenCD());
            tfGiaCD.setText(String.valueOf(cd.getGiaCD()));
            if (!Arrays.asList(giaiDoanCBX).contains(cd.getGiaiDoanCD())) {
                cbxGiaiDoanCD.setValue("Khác");
                tfGiaiDoanKhacCD.setText(cd.getGiaiDoanCD());
            } else {
                cbxGiaiDoanCD.setValue(String.valueOf(cd.getGiaiDoanCD()));
            }

        }
    }

    @FXML
    void chonMotSanPham(MouseEvent event) {
        SanPham sp = chonMotSanPhamTableView();
        if (sp != null) {
            tfMaSP.setText(sp.getMaSP());
            tfTenSP.setText(sp.getTenSP());
            tfGiaSP.setText(String.valueOf(sp.getGiaSP()));
            cbxLoaiSP.setValue(sp.getTenLoaiSP());
        }


    }

    @FXML
    void lamMoiTableView(ActionEvent event) {
        taiDuLieuSanPham();
    }

    @FXML
    void kiemTraComboBoxGiaiDoan(ActionEvent event) {
        if (cbxGiaiDoanCD.getValue().equals("Khác") || cbxGiaiDoanCD.getValue().equals("khác")) {
            tfGiaiDoanKhacCD.setEditable(true);
            tfGiaiDoanKhacCD.setPromptText("Nhập tên giai đoạn");
        } else {
            tfGiaiDoanKhacCD.setPromptText("Không thể nhập");
            tfGiaiDoanKhacCD.setEditable(false);
            tfGiaiDoanKhacCD.clear();
        }
    }


    // phuong thuc lam moi ma san pham
    private void lamMoiMaSP() {
        tfMaSP.setText(UUIDUtils.taoMaSanPham());
    }

    @FXML
    void lamMoiMaSanPham(ActionEvent event) {
        lamMoiMaSP();
        System.out.println("Da lam moi ma san pham");
    }

    @FXML
    void layMaCongDoan(ActionEvent event) {
        taoMaCongDoanChoSanPham();
    }

    @FXML
    void layDuLieuLoc(ActionEvent event) {

        String maSP = tfLocMaSP.getText();
        String tenSP = tfLocTenSP.getText();
        String loaiSP = cbxLocLoaiSanPham.getValue();

        System.out.println(maSP + " " + tenSP+ " " + loaiSP);

        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }
        ObservableList<SanPham> listsp = QuanLySanPhamDaoImpl.getInstance().locDuLieuDanhSachSanPham(maSP, tenSP, loaiSP);
        if(listsp.isEmpty()){
            Alerts.showAlert("Thông báo", "Lọc thành công", "Không tìm thấy sản phẩm phù hợp.", Alert.AlertType.INFORMATION);;
        }else {
            DSSANPHAM.addAll(listsp);
            tblSanPham.setItems(DSSANPHAM);
            Alerts.showAlert("Thông báo", "Lọc thành công", "Tìm thấy " + listsp.size() + " sản phẩm.", Alert.AlertType.INFORMATION);;
        }
        System.out.println("DS san pham sau khi loc:" + DSSANPHAM.toString() + "\n");



    }

    @FXML
    void suaCongDoanDuocChon(ActionEvent event) {

        String macd = tblCongDoan.getSelectionModel().getSelectedItem().getMaCD();
        String masanpham = tblCongDoan.getSelectionModel().getSelectedItem().getMaSanPham().getMaSP();
        String tencd = tfTenCD.getText();
        String giaString = tfGiaCD.getText();
        String cbxgiaidoan = cbxGiaiDoanCD.getValue();
        String tfgiaidoan = tfGiaiDoanKhacCD.getText();
        String giaidoan = null;

        if (masanpham == null || masanpham.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Mã sản phẩm phải tồn tại", "Vui lòng chọn lại sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (macd == null || macd.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Mã công đoạn bị trùng", "Vui lòng chọn lại sản phẩm và lấy mã công đoạn mới", Alert.AlertType.WARNING);
            return;
        }
        if (tencd == null || tencd.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Tên công đoạn không hợp lệ", "Vui lòng nhập lại tên công đoạn", Alert.AlertType.WARNING);
            return;
        }
        if (giaString == null || giaString.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng kiểm tra lại giá sản phẩm đã nhập", Alert.AlertType.WARNING);
            return;
        }
        try {
            double giacd = Double.parseDouble(giaString);
            if (giacd <= 0) {
                Alerts.showAlert("Cảnh báo", "Giá công đoạn không hợp lệ", "Vui lòng nhập giá công đoạn lớn hơn 0", Alert.AlertType.WARNING);
                return;
            }
        } catch (NumberFormatException e) {
            Alerts.showAlert("Cảnh báo", "Giá sản công đoạn hợp lệ", "Vui lòng nhập giá công đoạn là số", Alert.AlertType.WARNING);
            return;
        }

        if (cbxgiaidoan != null && (cbxgiaidoan.equalsIgnoreCase("Khác") || cbxgiaidoan.equalsIgnoreCase("khác") || cbxgiaidoan.equalsIgnoreCase("Trống"))) {
            if (tfgiaidoan == null || tfgiaidoan.isEmpty() || tfgiaidoan.equals("Trống")) {
                Alerts.showAlert("Cảnh báo", "Giai đoạn công đoạn phải được nhập và không được để trống", "Vui lòng nhập lại giai đoạn công đoạn", Alert.AlertType.WARNING);
                return;
            } else {
                giaidoan = tfgiaidoan;
            }
        } else {
            giaidoan = cbxgiaidoan;
        }

        CongDoan cd = new CongDoan(macd, new SanPham(masanpham), tencd, Double.parseDouble(giaString), giaidoan);
        boolean themcd = QuanLySanPhamDaoImpl.getInstance().suaCongDoanSanPham(cd);

        if (themcd) {
            Alerts.showAlert("Thông báo", "Thành công", "Đã sửa công đoạn có mã " + cd.getMaCD() + " cho mã sản phẩm " + cd.getMaSanPham().getMaSP(), Alert.AlertType.INFORMATION);
            taiDuLieuCongDoan(cd.getMaSanPham().getMaSP());
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi sửa " + cd.getMaCD() + " cho mã sản phẩm: " + cd.getMaSanPham().getMaSP(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void suaSanPhamDuocChon(ActionEvent event) {

        String masp = tfMaSP.getText();
        String tensp = tfTenSP.getText();
        String loaisp = cbxLoaiSP.getValue();
        String giaString = tfGiaSP.getText();

        if (masp == null || masp.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Mã sản phẩm bị trùng", "Vui lòng làm mới mã sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (tensp == null || tensp.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Tên sản phẩm không hợp lệ", "Vui lòng nhập lại tên sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (loaisp == null || loaisp.isEmpty() || loaisp.equals("Trống")) {
            Alerts.showAlert("Cảnh báo", "Loại sản phẩm phải đượcc chọn và không phải là trống", "Vui lòng chọn lại loại sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (giaString == null || giaString.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng kiểm tra lại giá sản phẩm đã nhập", Alert.AlertType.WARNING);
            return;
        }

        try {
            double giasp = Double.parseDouble(giaString);
            if (giasp <= 0) {
                Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng nhập giá sản phẩm lớn hơn 0", Alert.AlertType.WARNING);
                return;
            }
        } catch (NumberFormatException e) {
            Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng nhập giá sản phẩm là số", Alert.AlertType.WARNING);
            return;
        }
        SanPham spDuocSua = new SanPham(masp, tensp, loaisp, Double.parseDouble(giaString));
        boolean suasp = QuanLySanPhamDaoImpl.getInstance().suaSanPham(spDuocSua);

        if (suasp) {
            Alerts.showAlert("Thông báo", "Thành công", "Đã sửa sản phẩm có mã: " + spDuocSua.getMaSP(), Alert.AlertType.INFORMATION);
            xoaTrang();
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi sửa sản phẩm có mã: " + spDuocSua.getMaSP(), Alert.AlertType.ERROR);
        }


    }

    @FXML
    void thanhLySanPhamDuocChon(ActionEvent event) {

    }

    @FXML
    void themCongDoan(ActionEvent event) {
        String macd = tfMaCD.getText();
        String masanpham = tfMaSP.getText();
        String tencd = tfTenCD.getText();
        String giaString = tfGiaCD.getText();
        String cbxgiaidoan = cbxGiaiDoanCD.getValue();
        String tfgiaidoan = tfGiaiDoanKhacCD.getText();
        String giaidoan = null;

        if (masanpham == null || masanpham.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Mã sản phẩm phải tồn tại", "Vui lòng chọn lại sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (macd == null || macd.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Mã công đoạn bị trùng", "Vui lòng chọn lại sản phẩm và lấy mã công đoạn mới", Alert.AlertType.WARNING);
            return;
        }
        if (tencd == null || tencd.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Tên công đoạn không hợp lệ", "Vui lòng nhập lại tên công đoạn", Alert.AlertType.WARNING);
            return;
        }
        if (giaString == null || giaString.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng kiểm tra lại giá sản phẩm đã nhập", Alert.AlertType.WARNING);
            return;
        }
        try {
            double giacd = Double.parseDouble(giaString);
            if (giacd <= 0) {
                Alerts.showAlert("Cảnh báo", "Giá công đoạn không hợp lệ", "Vui lòng nhập giá công đoạn lớn hơn 0", Alert.AlertType.WARNING);
                return;
            }
        } catch (NumberFormatException e) {
            Alerts.showAlert("Cảnh báo", "Giá sản công đoạn hợp lệ", "Vui lòng nhập giá công đoạn là số", Alert.AlertType.WARNING);
            return;
        }

        if (cbxgiaidoan != null && (cbxgiaidoan.equalsIgnoreCase("Khác") || cbxgiaidoan.equalsIgnoreCase("khác") || cbxgiaidoan.equalsIgnoreCase("Trống"))) {
            if (tfgiaidoan == null || tfgiaidoan.isEmpty() || tfgiaidoan.equals("Trống")) {
                Alerts.showAlert("Cảnh báo", "Giai đoạn công đoạn phải được nhập và không được để trống", "Vui lòng nhập lại giai đoạn công đoạn", Alert.AlertType.WARNING);
                return;
            } else {
                giaidoan = tfgiaidoan;
            }
        } else {
            giaidoan = cbxgiaidoan;
        }

        CongDoan cd = new CongDoan(macd, new SanPham(masanpham), tencd, Double.parseDouble(giaString), giaidoan);
        boolean themcd = QuanLySanPhamDaoImpl.getInstance().themCongDoanSanPham(cd);

        if (themcd) {
            Alerts.showAlert("Thông báo", "Thành công", "Đã thêm công đoạn " + cd.getMaCD() + " cho mã sản phẩm " + cd.getMaSanPham().getMaSP(), Alert.AlertType.INFORMATION);
            taiDuLieuCongDoan(cd.getMaSanPham().getMaSP());
            taoMaCongDoanChoSanPham();
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi thêm " + cd.getMaCD() + " cho mã sản phẩm: " + cd.getMaSanPham().getMaSP(), Alert.AlertType.ERROR);
        }
    }


    //Them 1 san pham moi
    @FXML
    void themSanPham(ActionEvent event) {
        String masp = tfMaSP.getText();
        String tensp = tfTenSP.getText();
        String loaisp = cbxLoaiSP.getValue();
        String giaString = tfGiaSP.getText();
        if (masp == null || masp.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Mã sản phẩm bị trùng", "Vui lòng làm mới mã sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (tensp == null || tensp.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Tên sản phẩm không hợp lệ", "Vui lòng nhập lại tên sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (loaisp == null || loaisp.isEmpty() || loaisp.equals("Trống")) {
            Alerts.showAlert("Cảnh báo", "Loại sản phẩm phải đượcc chọn và không phải là trống", "Vui lòng chọn lại loại sản phẩm", Alert.AlertType.WARNING);
            return;
        }
        if (giaString == null || giaString.isEmpty()) {
            Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng kiểm tra lại giá sản phẩm đã nhập", Alert.AlertType.WARNING);
            return;
        }

        try {
            double giasp = Double.parseDouble(giaString);
            if (giasp <= 0) {
                Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng nhập giá sản phẩm lớn hơn 0", Alert.AlertType.WARNING);
                return;
            }
        } catch (NumberFormatException e) {
            Alerts.showAlert("Cảnh báo", "Giá sản phẩm không hợp lệ", "Vui lòng nhập giá sản phẩm là số", Alert.AlertType.WARNING);
            return;
        }
        SanPham spMoi = new SanPham(masp, tensp, loaisp, Double.parseDouble(giaString));
        boolean themsp = QuanLySanPhamDaoImpl.getInstance().themSanPhamMoi(spMoi);

        if (themsp) {
            Alerts.showAlert("Thông báo", "Thành công", "Đã thêm sản phẩm có mã: " + spMoi.getMaSP(), Alert.AlertType.INFORMATION);
            xoaTrang();
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi thêm sản phẩm có mã: " + spMoi.getMaSP(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void xemCongDoan(ActionEvent event) {
        if (chonMotSanPhamTableView() != null) {
            tfMaSPCD.setText(chonMotSanPhamTableView().getMaSP());
            taiDuLieuCongDoan(chonMotSanPhamTableView().getMaSP());
            taoMaCongDoanChoSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Rỗng", "Sản phẩm chưa tạo công đoạn", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void xoaCongDoanDuocChon(ActionEvent event) {
        CongDoan cdDuocChon = tblCongDoan.getSelectionModel().getSelectedItem();

        System.out.println(cdDuocChon);

        if (cdDuocChon == null) {
            Alerts.showAlert("Cảnh báo", "Chưa chọn công đoạn sản phẩm", "Vui lòng chọn công đoạn sản phẩm để xóa", Alert.AlertType.WARNING);
            return;
        }


        boolean xoacd = QuanLySanPhamDaoImpl.getInstance().xoaCongDoanSanPham(cdDuocChon.getMaCD());

        if (xoacd) {
            Alerts.showAlert("Thông báo", "Thành công", "Đã xóa sản phẩm có mã: " + cdDuocChon.getMaCD(), Alert.AlertType.INFORMATION);
            taiDuLieuCongDoan(cdDuocChon.getMaSanPham().getMaSP());
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi xóa sản phẩm có mã: " + cdDuocChon.getMaCD(), Alert.AlertType.ERROR);
        }
    }


    //Button xoa phan pham
    @FXML
    void xoaSanPhamDuocChon(ActionEvent event) {
        SanPham spDuocChon = tblSanPham.getSelectionModel().getSelectedItem();
//        QuanLySanPhamDaoImpl.getInstance().xoaSP(spDuocChon); //xoa san pham khoi database
        if (spDuocChon == null) {
            Alerts.showAlert("Cảnh báo", "Chưa chọn sản phẩm", "Vui lòng chọn sản phẩm để xóa", Alert.AlertType.WARNING);
            return;
        }


        boolean xoasp = QuanLySanPhamDaoImpl.getInstance().capNhatTrangThaiSanPham(spDuocChon.getMaSP());

        if (xoasp) {
            Alerts.showAlert("Thông báo", "Thành công", "Đã xóa sản phẩm có mã: " + spDuocChon.getMaSP(), Alert.AlertType.INFORMATION);
            xoaTrang();
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi xóa sản phẩm có mã: " + spDuocChon.getMaSP(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void xoaTrangTFCongDoan(ActionEvent event) {
        tfMaCD.clear();
        tfTenCD.clear();
        tfGiaCD.clear();
        cbxGiaiDoanCD.setPromptText("Chọn giai đoạn");

    }

    @FXML
    void xoaTrangTFSanPham(ActionEvent event) {
        tfMaSP.clear();
        tfGiaSP.clear();
        tfTenSP.clear();
        cbxLoaiSP.setPromptText("Chọn loại sản phẩm");
        lamMoiMaSP();
    }


    //Khoi tao du lieu man hinh
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoKieuDuLieuChoTableView();
        taiDuLieuSanPham();
        chinhSuaDuLieuTrenTableView();

    }


    //Dinh nghia kieu du lieu cho cot tren tableview de co the truyen vao SanPham
    private void khoiTaoKieuDuLieuChoTableView() {
        //cell ao stt
        colSTTSanPham.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });

        colSTTCongDoan.setCellValueFactory(cellData -> {
            int rowIndex = cellData.getTableView().getItems().indexOf(cellData.getValue());
            if (rowIndex >= 0) {
                return new SimpleIntegerProperty(rowIndex + 1).asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });

        //table SanPham
        colMaSanPham.setCellValueFactory(new PropertyValueFactory<SanPham, String>("maSP"));
        colTenSanPham.setCellValueFactory(new PropertyValueFactory<SanPham, String>("tenSP"));
        colLoaiSanPham.setCellValueFactory(new PropertyValueFactory<SanPham, String>("tenLoaiSP"));
        colGiaSanPham.setCellValueFactory(new PropertyValueFactory<SanPham, Double>("giaSP"));

        //table CongDoan
        colMaCongDoan.setCellValueFactory(new PropertyValueFactory<CongDoan, String>("maCD"));
        colTenCongDoan.setCellValueFactory(new PropertyValueFactory<CongDoan, String>("tenCD"));
        colGiaiDoanCongDoan.setCellValueFactory(new PropertyValueFactory<CongDoan, String>("giaiDoanCD"));
        colGiaCongDoan.setCellValueFactory(new PropertyValueFactory<SanPham, Double>("giaCD"));

        //textfield
        tfMaSP.setText(UUIDUtils.taoMaSanPham());
        tfGiaiDoanKhacCD.setPromptText("Không thể nhập");
        tfGiaiDoanKhacCD.setEditable(false);

        //combo box
        ObservableList<String> listLoai = QuanLySanPhamDaoImpl.getInstance().taiDanhSachLoaiSanPham();
        cbxLoaiSP.setItems(listLoai);
        cbxLoaiSP.setPromptText("Chọn loại sản phẩm");
        cbxLocLoaiSanPham.setItems(listLoai);
        cbxLocLoaiSanPham.setPromptText("Chọn loại sản phẩm");

        ObservableList<String> dsgd = FXCollections.observableArrayList("Trống", "Cắt", "May", "Hoàn thành", "Đóng gói", "Khác");
        cbxGiaiDoanCD.setItems(dsgd);
        cbxGiaiDoanCD.setPromptText("Chọn giai đoạn");


        //textfielf
        tfLocTenSP.setText(null);
        tfLocMaSP.setText(null);

    }


    //Tai du lieu san pham
    private void taiDuLieuSanPham() {
        //Kiem tra ObservableArraylist neu co du lieu thi se xoa di
        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }

        //Goi toi phuong thuoc DaoImplement de thuc hien ket noi lay du lieu tu jdbc
        DSSANPHAM.addAll(QuanLySanPhamDaoImpl.getInstance().layDanhSachSanPhamTheoTrangThai(0)); //0 la san pham chua xoa - 1 la san pham da xoa

        //dua du lieu san pham tu observablelist len tableview
        tblSanPham.setItems(DSSANPHAM);
        System.out.println(DSSANPHAM.toString());

    }

    private void taiDuLieuCongDoan(String maSanPham) {
        if (!DSCONGDOAN.isEmpty()) {
            DSCONGDOAN.clear();
        }
        ObservableList<CongDoan> listCD = QuanLySanPhamDaoImpl.getInstance().layCongDoanSanPhamTheoMa(maSanPham);
        System.out.println("fsdfsf" + listCD.isEmpty());
        if (listCD.isEmpty() || listCD == null) {
            Alerts.showAlert("Thông báo", "Sản phẩm chưa có công đoạn", "Vui lòng tạo công đoạn cho sản phẩm có mã: " + maSanPham, Alert.AlertType.WARNING);
        } else {
            DSCONGDOAN.addAll(listCD);
            tblCongDoan.setItems(DSCONGDOAN);
            System.out.println(DSCONGDOAN.toString());
        }

    }

    //Chi cap nhat tren observablelist khong thao tac o csdl
    private void chinhSuaDuLieuTrenTableView() {

        colTenSanPham.setCellFactory(TextFieldTableCell.forTableColumn());
        colTenSanPham.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setTenSP(e.getNewValue()));
        colGiaSanPham.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter())); // Doi kieu du lieu sang String
        colGiaSanPham.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setGiaSP(e.getNewValue()));

        tblSanPham.setEditable(true);
    }

    //Lay lay du lieu tu csdl va thao tac
    /*private void taiDuLieuSanPhamChinhSua() {

        //Kiem tra ObservableArraylist neu co du lieu thi se xoa di
        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }

        //Goi toi phuong thuoc DaoImplement de thuc hien ket noi lay du lieu tu jdbc
        DSSANPHAM.addAll(QuanLySanPhamDaoImpl.getInstance().layTatCaSP());
//        sttSPColumn.setCellValueFactory(DSSANPHAM.size());

        //Dinh dang kieu du lieu hien thi tren cot cua tableview
        maSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, String>("maSP"));


        tenSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, String>("tenSP"));

        //Dinh dang kieu du lieu hien thi tren o khi chinh sua
        tenSPColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Dinh dang kieu du lieu duoc sua sau khi xac nhan
        tenSPColumn.setOnEditCommit((TableColumn.CellEditEvent<SanPham, String> event) -> {
            //lay nghe hang va cot duoc chon o dau va nam o tableview nao
            TablePosition<SanPham, String> pos = event.getTablePosition();
            System.out.println("Vi tri pos: " + pos);

            //Lang nghe su kien noi duoc chon va lay du lieu tu cell do
            String tenSPMoi = event.getNewValue();
            System.out.println("Cell duoc chon va da thay doi du lieu: " + tenSPMoi);

            //Lay ra vi tri hang duoc chon - index bat dau la 0
            int row = pos.getRow();
            System.out.println("hang duoc chon: " + row);

            //Lay du lieu tu doi tuong san pham cua hang duoc chon tren tableview
            SanPham sp = event.getTableView().getItems().get(row);
            System.out.println("Du lieu cua san pham duoc chon: " + sp);

            sp.setTenSP(tenSPMoi);
            System.out.println(DSSANPHAM.toString());
        });

        giaSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, Double>("giaSP"));

//        giaSPColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter())); //Chuyen doi double sang string


        giaSPColumn.setCellFactory(tablecell -> new TableCell<SanPham, Double>() {
            @Override
            protected void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(Utils.formatCurrency(price));
                }
            }

        });


        giaSPColumn.setOnEditCommit((TableColumn.CellEditEvent<SanPham, Double> event) -> {
            TablePosition<SanPham, Double> pos = event.getTablePosition();

            Double giaSPMoi = event.getNewValue();

            int row = pos.getRow();
            SanPham sp = event.getTableView().getItems().get(row);

            sp.setGiaSP(giaSPMoi);
            System.out.println(DSSANPHAM.toString());
        });
        sanPhamTableView.setItems(DSSANPHAM);
        System.out.println(DSSANPHAM.toString());

    }*/

    @FXML
    private void luuDSSanPham(ActionEvent event) {
//        chinhSuaDuLieuGiaoDien();
//        System.out.println(DSSANPHAM.toString());
        SanPham spDuocChon = tblSanPham.getSelectionModel().getSelectedItem();
        System.out.println("San pham duoc chon: " + spDuocChon);

        QuanLySanPhamDaoImpl.getInstance().suaSP(spDuocChon);
    }

    @FXML
    private void lamMoiDSSanPham(ActionEvent event) {
        taiDuLieuSanPham();
        System.out.println(DSSANPHAM.toString());

    }


    //button them 1 san pham vao observable list


    private void xoaTrang() {
        lamMoiMaSP();
        tfMaSP.clear();
        tfGiaSP.clear();
        tfTenSP.clear();

    }

    private void taoMaCongDoanChoSanPham() {
        if (chonMotSanPhamTableView() != null) {
            tfMaCD.setText(UUIDUtils.taoMaCongDoan(chonMotSanPhamTableView().getMaSP()));
        } else
            Alerts.showAlert("Cảnh báo", "Chưa chọn sản phẩm", "Vui lòng chọn một sản phẩm trước khi tạo mã", Alert.AlertType.WARNING);
    }

    private SanPham chonMotSanPhamTableView() {
        SanPham spDuocChon = tblSanPham.getSelectionModel().getSelectedItem();
        if (spDuocChon != null) {
            System.out.println("San pham duoc chon: \n" + spDuocChon.toString());
            return spDuocChon;
        } else {
            System.out.println("Khong co san pham nao duoc chon \n");
            return null;
        }
    }

    private CongDoan chonMotCongDoanTableView() {
        CongDoan cdDuocChon = tblCongDoan.getSelectionModel().getSelectedItem();
        if (cdDuocChon != null) {
            System.out.println("Cong doan duoc chon: \n" + cdDuocChon.toString());
            return cdDuocChon;
        } else {
            System.out.println("Khong co cong doan nao duoc chon \n");
            return null;
        }
    }



    /*System.out.println("event" + event);
    SanPham spDuocChon = tblSanPham.getSelectionModel().getSelectedItem();
        if (spDuocChon != null) {
        System.out.println("San pham duoc chon: \n" + spDuocChon.toString());

        tfMaSP.setText(spDuocChon.getMaSP());
        tfTenSP.setText(spDuocChon.getTenSP());
        tfGiaSP.setText(String.valueOf(spDuocChon.getGiaSP()));
        cbxLoaiSP.setValue(spDuocChon.getTenLoaiSP());
    } else {
        System.out.println("Khong co san pham nao duoc chon \n");
    }*/

    @FXML
    private void thanhLySanPham(ActionEvent event) {

    }

    @FXML
    private void xoaTrangTF(ActionEvent event) {
        xoaTrang();
    }

    @FXML
    private void suaSanPham(ActionEvent event) {
//        String masp = tfMaSP.getText(); //dung tam chua them ham tu dong tao ma sp
//        String tensp = tfTenSP.getText();
//        double giasp = Double.parseDouble(tfGiaSP.getText());
//
//        SanPham spSua = new SanPham(masp, tensp, giasp);


    }

    private SanPham layDuLieuTFSanPham() {
        if (!tfMaSP.getText().isEmpty() && !tfTenSP.getText().isEmpty() && !tfGiaSP.getText().isEmpty() && cbxLoaiSP.getValue().isEmpty()) {
            String masp = tfMaSP.getText(); //dung tam chua them ham tu dong tao ma sp
            String tensp = tfTenSP.getText();
            double giasp = Double.parseDouble(tfGiaSP.getText().trim());
            String loaisp = cbxLoaiSP.getValue();
            SanPham sp = new SanPham(masp, tensp, loaisp, giasp);
            System.out.println(sp.toString());
            return sp;
        } else {
            return null;
        }
    }


}
