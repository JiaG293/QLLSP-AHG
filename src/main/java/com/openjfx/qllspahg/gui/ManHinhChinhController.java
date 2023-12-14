package com.openjfx.qllspahg.gui;

import com.openjfx.qllspahg.Main;
import com.openjfx.qllspahg.entity.TaiKhoan;
import com.openjfx.qllspahg.gui.util.ControlFlow;
import com.openjfx.qllspahg.gui.util.FileIOUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManHinhChinhController implements Initializable {
    @FXML
    private BorderPane guiChinh;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private MenuItem mItemDangXuat;

    @FXML
    private Label lblChucVu;

    @FXML
    private Label lblHoVaTen;

    @FXML
    private Label lblMaNV;

    @FXML
    private Label lblPhongBan;

    @FXML
    private Label lblVaiTro;

    @FXML
    private MenuItem mItemBLCN;

    @FXML
    private MenuItem mItemBLNV;

    @FXML
    private MenuItem mItemCCCN;

    @FXML
    private MenuItem mItemCCNV;

    @FXML
    private MenuItem mItemDSCN;

    @FXML
    private MenuItem mItemDSHD;

    @FXML
    private MenuItem mItemDSNV;

    @FXML
    private MenuItem mItemDSSP;

    @FXML
    private MenuItem mItemPCCN;

    @FXML
    private MenuItem mItemTKCN;

    @FXML
    private MenuItem mItemTKNV;

    @FXML
    private MenuItem mItemTLCN;

    @FXML
    private MenuItem mItemTLNV;

    @FXML
    private MenuItem mItemTUCN;

    @FXML
    private MenuItem mItemTUNV;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            dangXuatTaiKhoan();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        taiThongTinTaiKhoan();
    }

    private void taiThongTinTaiKhoan() {

        TaiKhoan readTaiKhoan = FileIOUtils.readTaiKhoanFromFile("userData.properties");
        lblMaNV.setText(readTaiKhoan.getMaTK().getMaNV());
        lblHoVaTen.setText(readTaiKhoan.getMaTK().getHoNV() + " " + readTaiKhoan.getMaTK().getTenNV());
        lblChucVu.setText(readTaiKhoan.getMaTK().getChucVuNV().getTenCV());
        lblPhongBan.setText(readTaiKhoan.getMaTK().getPhongBan().getTenPB());
        lblVaiTro.setText(readTaiKhoan.getVaiTro());
        if (readTaiKhoan != null) {
            System.out.println("MaTK: " + readTaiKhoan.getMaTK());
        } else {
            System.out.println("Khong co du lieu duoc tim thay");
        }
        flowSceen();
    }


    private void dangXuatTaiKhoan() throws IOException {
        mItemDangXuat.setOnAction(event -> {
            try {
                Stage currentStage = (Stage) lblMaNV.getScene().getWindow();

                currentStage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/openjfx/qllspahg/fxml/TaiKhoan/DangNhap.fxml"));
                Parent root = fxmlLoader.load();

                Stage newStage = new Stage();
                newStage.setTitle("Đăng nhập");
                newStage.setScene(new Scene(root, 1200, 800));
                newStage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //"Quản lý hành chính", "Quản lý sản xuất", "Kế toán", "Nhân viên hành chính"
    private void flowSceen() {
        TaiKhoan readTaiKhoan = FileIOUtils.readTaiKhoanFromFile("userData.properties");
        if (readTaiKhoan.getVaiTro().equals("Nhân viên hành chính")) {
            mItemBLCN.setDisable(true);
            mItemBLNV.setDisable(true);
            mItemCCCN.setDisable(true);
            mItemCCNV.setDisable(true);
            mItemTLCN.setDisable(true);
            mItemTLNV.setDisable(true);
            mItemDSSP.setDisable(true);
            mItemTUNV.setDisable(true);
            mItemPCCN.setDisable(true);
            mItemTUCN.setDisable(true);
        } else if (readTaiKhoan.getVaiTro().equals("Quản lý sản xuất")) {
            mItemBLNV.setDisable(true);
            mItemCCNV.setDisable(true);
            mItemTLNV.setDisable(true);
            mItemDSSP.setDisable(true);
            mItemTUNV.setDisable(true);
            mItemTUCN.setDisable(true);
            mItemTLCN.setDisable(true);
            mItemDSCN.setDisable(true);
            mItemBLCN.setDisable(true);
        } else if (readTaiKhoan.getVaiTro().equals("Kế toán")) {
            mItemCCCN.setDisable(true);
            mItemCCNV.setDisable(true);
            mItemCCCN.setDisable(true);
            mItemCCNV.setDisable(true);
            mItemPCCN.setDisable(true);
            mItemDSSP.setDisable(true);
            mItemDSSP.setDisable(true);
            mItemDSHD.setDisable(true);
            mItemDSNV.setDisable(true);
            mItemDSCN.setDisable(true);
        }
    }

    //CongNhan
    @FXML
    void ChangeSceneQuanLyCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/QuanLyCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeScenePhanCongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/PhanCongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneChamCongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/ChamCongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTamUngCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/TamUngCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void changeSceenDanhSachTaiKhoan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/TaiKhoan/QuanLyTaiKhoan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTimKiemCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/TimKiemCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTinhLuongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/TinhLuongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    //HopDong
    @FXML
    void ChangeSceneDanhSachHopDong(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/HopDong/DanhSachHopDong.fxml")));
        guiChinh.setCenter(view);
    }

    //NhanVien
    @FXML
    void ChangeSceneQuanLyNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/QuanLyNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneChamCongNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/ChamCongNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTamUngNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/TamUngNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTimKiemNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/TimKiemNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneTinhLuongNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/TinhLuongNhanVien.fxml")));
        guiChinh.setCenter(view);
    }

    //SanPham
    @FXML
    void ChangeSceneQuanLySanPham(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/SanPham/QuanLySanPham.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceenChiTietPhienBan(ActionEvent event) {

    }

    @FXML
    void changeSceenTaiLieuHuongDan(ActionEvent event) {

    }

    @FXML
    void ChangeSceneBangLuongCongNhan(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/CongNhan/BangLuongCongNhan.fxml")));
        guiChinh.setCenter(view);
    }

    @FXML
    void ChangeSceneBangLuongNhanVien(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/NhanVien/BangLuongNhanVien.fxml")));
        guiChinh.setCenter(view);
    }


    //ThongKe
    /*@FXML
    void ChangeSceneThongKe(ActionEvent event) throws IOException {
        TabPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/openjfx/qllspahg/fxml/ThongKe.fxml")));
        guiChinh.setCenter(view);
    }*/
}
