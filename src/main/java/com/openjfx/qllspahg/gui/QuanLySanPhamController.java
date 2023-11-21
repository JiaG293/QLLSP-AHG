package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.QuanLySanPhamDaoImpl;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSCONGDOAN;
import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSSANPHAM;

import com.openjfx.qllspahg.dao.SanPhamDaoImpl;
import com.openjfx.qllspahg.entity.CongDoan;
import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.UUIDUtils;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.List;
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
    private TableColumn<?, ?> colSTTCongDoan;

    @FXML
    private TableColumn<?, ?> colSTTSanPham;

    @FXML
    private TableColumn<CongDoan, String> colTenCongDoan;

    @FXML
    private TableColumn<SanPham, String> colTenSanPham;

    @FXML
    private TableView<?> tblCongDoan;

    @FXML
    private TableView<SanPham> tblSanPham;

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
    private TextField tfMaSP;

    @FXML
    private TextField tfTenCD;

    @FXML
    private TextField tfTenSP;

    @FXML
    void CapNhatDuLieuTableView(ActionEvent event) {

    }

    @FXML
    void chonMotSanPham(MouseEvent event) {
        SanPham spDuocChon = tblSanPham.getSelectionModel().getSelectedItem();
        if (spDuocChon != null) {
            System.out.println("San pham duoc chon: \n" + spDuocChon.toString());

            tfMaSP.setText(spDuocChon.getMaSP());
            tfTenSP.setText(spDuocChon.getTenSP());
            tfGiaSP.setText(String.valueOf(spDuocChon.getGiaSP()));
            cbxLoaiSP.setValue(spDuocChon.getTenLoaiSP());
        } else {
            System.out.println("Khong co san pham nao duoc chon \n");
        }

    }

    @FXML
    void lamMoiTableView(ActionEvent event) {

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
    void layDuLieuLoc(ActionEvent event) {

    }

    @FXML
    void sampleTest(ActionEvent event) {
        double giaString = Double.parseDouble(tfGiaSP.getText());
        System.out.println(giaString);
    }

    @FXML
    void suaCongDoanDuocChon(ActionEvent event) {

    }

    @FXML
    void suaSanPhamDuocChon(ActionEvent event) {

    }

    @FXML
    void thanhLySanPhamDuocChon(ActionEvent event) {

    }

    @FXML
    void themCongDoan(ActionEvent event) {

    }

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

        if(themsp){
            Alerts.showAlert("Thông báo", "Thành công", "Đã thêm sản phẩm có mã hợp đồng " + spMoi.getMaSP(), Alert.AlertType.INFORMATION);
            xoaTrang();
            taiDuLieuSanPham();
        } else {
            Alerts.showAlert("Thông báo", "Thất bại", "Lỗi khi thêm sản phẩm có mã hợp đồng " + spMoi.getMaSP() , Alert.AlertType.ERROR);
        }
    }

    @FXML
    void xoaCongDoanDuocChon(ActionEvent event) {

    }


    //Button xoa phan pham
    @FXML
    void xoaSanPhamDuocChon(ActionEvent event) {
        SanPham spDuocChon = tblSanPham.getSelectionModel().getSelectedItem();
        QuanLySanPhamDaoImpl.getInstance().xoaSP(spDuocChon);
        taiDuLieuSanPham();
    }

    @FXML
    void xoaTrangTFCongDoan(ActionEvent event) {

    }

    @FXML
    void xoaTrangTFSanPham(ActionEvent event) {

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

        //combo box
        cbxLoaiSP.setPromptText("Chọn loại sản phẩm");
        cbxLocLoaiSanPham.setPromptText("Chọn loại sản phẩm");
        cbxLoaiSP.setItems(QuanLySanPhamDaoImpl.getInstance().taiDanhSachLoaiSanPham());
        cbxLocLoaiSanPham.setItems(QuanLySanPhamDaoImpl.getInstance().taiDanhSachLoaiSanPham());
    }


    //Tai du lieu san pham
    private void taiDuLieuSanPham() {
        //Kiem tra ObservableArraylist neu co du lieu thi se xoa di
        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }
        if (!DSCONGDOAN.isEmpty()) {
            DSCONGDOAN.clear();
        }

        //Goi toi phuong thuoc DaoImplement de thuc hien ket noi lay du lieu tu jdbc
        DSSANPHAM.addAll(QuanLySanPhamDaoImpl.getInstance().layTatCaSP());

        //dua du lieu san pham tu observablelist len tableview
        tblSanPham.setItems(DSSANPHAM);
        System.out.println(DSSANPHAM.toString());

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


        try {
            SanPham spSua = layDuLieuTF();

            if (spSua != null) {
                QuanLySanPhamDaoImpl.getInstance().suaSP(spSua);
                //Lam moi tableview
                xoaTrang();
                taiDuLieuSanPham();

            }
        } catch (Exception e) {
            Alerts.showConfirmation("Dữ liệu không hợp lệ!!!", "Vui lòng nhập dữ liệu vào");
        }
    }

    private SanPham layDuLieuTF() {
        if (!tfMaSP.getText().isEmpty() || !tfTenSP.getText().isEmpty() || !tfGiaSP.getText().isEmpty()) {
            String masp = tfMaSP.getText(); //dung tam chua them ham tu dong tao ma sp
            String tensp = tfTenSP.getText();
            double giasp = Double.parseDouble(tfGiaSP.getText().trim());
            SanPham sp = new SanPham(masp, tensp, giasp);
            System.out.println(sp.toString());
            return sp;
        } else {
            return null;
        }
    }


}
