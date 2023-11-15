package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.dao.QuanLySanPhamDaoImpl;

import static com.openjfx.qllspahg.dao.interfaces.DSDao.DSSANPHAM;

import com.openjfx.qllspahg.entity.SanPham;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class SanPhamController implements Initializable {
    @FXML
    private Button btnXoaSP;

    @FXML
    private TableView<SanPham> sanPhamTableView;

    @FXML
    private TableColumn<SanPham, Integer> sttSPColumn;

    @FXML
    private TableColumn<SanPham, Double> giaSPColumn;

    @FXML
    private TableColumn<SanPham, String> maSPColumn;

    @FXML
    private TableColumn<SanPham, String> tenSPColumn;

    @FXML
    private TextField tfGiaSP;

    @FXML
    private TextField tfMaSP;

    @FXML
    private TextField tfTenSP;


    //Khoi tao du lieu man hinh
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khoiTaoKieuDuLieuChoCot();
        taiDuLieuSanPham();
        chinhSuaDuLieuGiaoDien();
    }

    //Dinh nghia kieu du lieu cho cot tren tableview de co the truyen vao SanPham
    private void khoiTaoKieuDuLieuChoCot() {
        maSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, String>("maSP"));
        tenSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, String>("tenSP"));
        giaSPColumn.setCellValueFactory(new PropertyValueFactory<SanPham, Double>("giaSP"));
    }


    //Tai du lieu san pham
    private void taiDuLieuSanPham() {
        //Kiem tra ObservableArraylist neu co du lieu thi se xoa di
        if (!DSSANPHAM.isEmpty()) {
            DSSANPHAM.clear();
        }
        //Goi toi phuong thuoc DaoImplement de thuc hien ket noi lay du lieu tu jdbc
        DSSANPHAM.addAll(QuanLySanPhamDaoImpl.getInstance().layTatCaSP());

        //dua du lieu san pham tu observablelist len tableview
        sanPhamTableView.setItems(DSSANPHAM);
        System.out.println(DSSANPHAM.toString());

    }

    //Chi cap nhat tren observablelist khong thao tac o csdl
    private void chinhSuaDuLieuGiaoDien() {
//        maSPColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        maSPColumn.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setMaSP(e.getNewValue()));

        tenSPColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tenSPColumn.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setTenSP(e.getNewValue()));

        giaSPColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter())); // Doi kieu du lieu sang String
        giaSPColumn.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setGiaSP(e.getNewValue()));

        //Cho phep table duoc sua doi
        sanPhamTableView.setEditable(true);
    }

    //Lay lay du lieu tu csdl va thao tac
    private void taiDuLieuSanPhamChinhSua() {

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
                    setText(Utils.FormatCurrency(price));
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

    }


    //Button xoa san pham ra khoi Observablelist
    @FXML
    private void xoaSanPham(ActionEvent event) {
        //Lay vi tri san pham duoc chon
        SanPham spDuocChon = sanPhamTableView.getSelectionModel().getSelectedItem();

        //Xoa sp tren csdl
        QuanLySanPhamDaoImpl.getInstance().xoaSP(spDuocChon);

        //Tai lai du lieu bang
        taiDuLieuSanPham();


    }

    @FXML
    private void luuDSSanPham(ActionEvent event) {
//        chinhSuaDuLieuGiaoDien();
//        System.out.println(DSSANPHAM.toString());
        SanPham spDuocChon = sanPhamTableView.getSelectionModel().getSelectedItem();
        System.out.println("San pham duoc chon: " + spDuocChon);

        QuanLySanPhamDaoImpl.getInstance().suaSP(spDuocChon);
    }

    @FXML
    private void lamMoiDSSanPham(ActionEvent event) {
        taiDuLieuSanPham();
        System.out.println(DSSANPHAM.toString());

    }


    //button them 1 san pham vao observable list
    @FXML
    private void themSanPham(ActionEvent event) {
        String masp = tfMaSP.getText(); //dung tam chua them ham tu dong tao ma sp
        String tensp = tfTenSP.getText();
        double giasp = Double.parseDouble(tfGiaSP.getText());

        SanPham spMoi = new SanPham(masp, tensp, giasp);

        //Them sp vao csdl
        QuanLySanPhamDaoImpl.getInstance().themSP(spMoi);
        //Lam moi tableview
        xoaTrang();
        taiDuLieuSanPham();
    }

    @FXML
    private void chonMotSanPham(MouseEvent event) {
        //Lay vi tri san pham duoc chon
        SanPham spDuocChon = sanPhamTableView.getSelectionModel().getSelectedItem();
        System.out.println("san pham duoc chon" + spDuocChon.toString());

        tfMaSP.setText(spDuocChon.getMaSP());
        tfTenSP.setText(spDuocChon.getTenSP());
        tfGiaSP.setText(String.valueOf(spDuocChon.getGiaSP()));

    }

    private void xoaTrang() {
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

    @FXML
    void sampleTest(ActionEvent event) {
        layDuLieuTF();
    }


}
