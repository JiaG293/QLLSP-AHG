package com.openjfx.qllspahg.gui;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.*;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.SoLuonNguoitTrongTo;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan.*;

public class PhanCongCongNhanController implements Initializable {

    @FXML
    private Button btnLayDuLieuPhanCongCongNhan;

    @FXML
    private Button btnLuu;

    @FXML
    private ImageView btnLuuPhanCongCongNhan;

    @FXML
    private Button btnResetPhanCongCongNhan;

    @FXML
    private Button btnSuaTTNhanVien;

    @FXML
    private ComboBox<String> cbxLayTTHopDongPhanCongCongNh;

    @FXML
    private CheckBox ckGioiTinhTTNhanVien;

    @FXML
    private TableColumn<?, ?> colCongDoanTTPhanCongToCongNhan;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colHovaTenTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colMaChamCongTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<CongDoan, String> colMaCongDoanPhanCongCongNhan;

    @FXML
    private TableColumn<ChiTietHopDong, String> colMaSanPhamPhanCongCongNhan1;

    @FXML
    private TableColumn<SoLuonNguoitTrongTo, String> colMaToPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colNgayKetThucTTPhanCongToCongNhan;

    @FXML
    private TableColumn<BangPhanCongCongNhan, Date> colNgayKetThucTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<BangPhanCongCongNhan, Date> colNgayPhamCongChamCongTTPhanCongTungCongNhan;


    @FXML
    private TableColumn<ChiTietHopDong, Integer> colSLSanPhamPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colSanPhamTTPhanCongToCongNhan11;

    @FXML
    private TableColumn<BangPhanCongCongNhan, Integer> colSoLuongLamTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<SoLuonNguoitTrongTo, String> colSoLuongNguoiTrongToPhanCongCongNhan;

    @FXML
    private TableColumn<CongDoan, String> colTenCongDoanPhanCongCongNhan;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colTenCongDoanTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<ChiTietHopDong, String> colTenSanPhamPhanCongCongNhan;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colTenSanPhamTTPhanCongTungCongNhan;

    @FXML
    private TableColumn<SoLuonNguoitTrongTo, String> colTenToPhanCongCongNhan;

    @FXML
    private TableColumn<?, ?> colToTTPhanCongToCongNhan;

    @FXML
    private TableColumn<?, ?> colTongSoLuongLamTTPhanCongToCongNhan;

    @FXML
    private DatePicker datepickNgayKetThuc;

    @FXML
    private DatePicker datepickNgayPhanCong;

    @FXML
    private TableView<CongDoan> tblViewTTCongDoanPhanCongCongNhan;

    @FXML
    private TableView<?> tblViewTTPhanCongToCongNhan;

    @FXML
    private TableView<BangPhanCongCongNhan> tblViewTTPhanCongTungCongNhan;

    @FXML
    private TableView<ChiTietHopDong> tblViewTTSanPhamPhanCongCongNhan;

    @FXML
    private TableView<SoLuonNguoitTrongTo> tblViewTTToPhanCongCongNhan;

    @FXML
    private TextField tfSoLuongPhanCongTungNguoi;

    @FXML
    private TextField tfCongDoanPhanCong;

    @FXML
    private TextField tfSanPhamPhanCong;
    @FXML
    private TextField tfToPhanCong;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepickNgayPhanCong.setValue(LocalDate.now());
        Utils.formatDatePicker(datepickNgayPhanCong,"dd/MM/YYYY");
        Utils.formatDatePicker(datepickNgayKetThuc,"dd/MM/YYYY");
        loadcbxDSHopDong();
        docDuLieuVaoTblTTSanPhamPCCND();
        docDuLieuVaotblViewTTCongDoanPhanCongCongNhan();
        docDuLieuVaotblViewTTToPhanCongCongNhan();
        docDULieuVaotblViewTTPhanCongTungCongNhan();
    }

    private void loadcbxDSHopDong (){
        DSMaHopDong.addAll(PhanCongCongNhanDao.getInstance().getAllMaHD());
        ObservableList<String> dsMaHopDong = FXCollections.observableArrayList();
        for (HopDong hd :DSMaHopDong){
            dsMaHopDong.add(hd.getMaHD());
        }
        cbxLayTTHopDongPhanCongCongNh.setItems(dsMaHopDong);
    }
    public void xoaDuLieuDSChiTietHopDongNeuDaCoDuL (){
        if (!DSChiTietHopDong.isEmpty())
            DSChiTietHopDong.clear();
    }
    public void LayDuLeiuPhanCongCongNhanmaHD(ActionEvent actionEvent) {
        xoaDuLieuDSChiTietHopDongNeuDaCoDuL();
        if (cbxLayTTHopDongPhanCongCongNh.getSelectionModel().isEmpty())
            Alerts.showConfirmation("Thông báo", "Chưa chọn hợp đồng");
        else {
            String maHD = cbxLayTTHopDongPhanCongCongNh.getValue().trim();
            DSChiTietHopDong.addAll(PhanCongCongNhanDao.getInstance().getAllChiTietHopDong(maHD));

        }
    }
    private void docDuLieuVaotblTTToPCCN(){

    }
    private void docDuLieuVaoTblTTSanPhamPCCND(){
        colMaSanPhamPhanCongCongNhan1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongStringCellDataFeatures) {
                return new SimpleStringProperty(chiTietHopDongStringCellDataFeatures.getValue().getMaSanPham().getMaSP());
            }
        });
        colTenSanPhamPhanCongCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHopDong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ChiTietHopDong, String> chiTietHopDongStringCellDataFeatures) {
                return new SimpleStringProperty(chiTietHopDongStringCellDataFeatures.getValue().getMaSanPham().getTenSP());
            }
        });
        colSLSanPhamPhanCongCongNhan.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        tblViewTTSanPhamPhanCongCongNhan.setItems(DSChiTietHopDong);
    }
    private void docDuLieuVaotblViewTTCongDoanPhanCongCongNhan(){
        colMaCongDoanPhanCongCongNhan.setCellValueFactory(new PropertyValueFactory<>("maCD"));
        colTenCongDoanPhanCongCongNhan.setCellValueFactory(new PropertyValueFactory<>("tenCD"));
        tblViewTTCongDoanPhanCongCongNhan.setItems(DSCongDoan);

    }

    public void chonROWTTChiTietSanPham(MouseEvent mouseEvent) {
        DSCongDoan.clear();
        if (!DSChiTietHopDong.isEmpty()){
            ChiTietHopDong cthd = tblViewTTSanPhamPhanCongCongNhan.getSelectionModel().getSelectedItem();

            String maSP = cthd.getMaSanPham().getMaSP().trim();
            DSCongDoan.addAll(PhanCongCongNhanDao.getInstance().getCongDoanTheoMaSP(maSP));

            String tenSP = cthd.getMaSanPham().getTenSP().trim();
            tfSanPhamPhanCong.setText(tenSP);

        }

    }
    public void chonROWTTCongDoanSanPham(MouseEvent mouseEvent) {
        if (!DSCongDoan.isEmpty()){

            CongDoan cd = tblViewTTCongDoanPhanCongCongNhan.getSelectionModel().getSelectedItem();
            tfCongDoanPhanCong.setText(cd.getTenCD().trim());
        } else {
            return;
        }
    }

    private void docDuLieuVaotblViewTTToPhanCongCongNhan(){

        DSSoLuongNguoiTrongTo.addAll(PhanCongCongNhanDao.getInstance().getSoLuongCoTrongTo());
        colMaToPhanCongCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SoLuonNguoitTrongTo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SoLuonNguoitTrongTo, String> soLuonNguoitTrongToStringCellDataFeatures) {
                return new SimpleStringProperty(soLuonNguoitTrongToStringCellDataFeatures.getValue().getTsx().getMaTSX());
            }
        });

        colTenToPhanCongCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SoLuonNguoitTrongTo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SoLuonNguoitTrongTo, String> soLuonNguoitTrongToStringCellDataFeatures) {
                return new SimpleStringProperty(soLuonNguoitTrongToStringCellDataFeatures.getValue().getTsx().getTenTSX());
            }
        });

        colSoLuongNguoiTrongToPhanCongCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SoLuonNguoitTrongTo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SoLuonNguoitTrongTo, String> soLuonNguoitTrongToStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(soLuonNguoitTrongToStringCellDataFeatures.getValue().getSoLuongNguoi()));
            }
        });

        tblViewTTToPhanCongCongNhan.setItems(DSSoLuongNguoiTrongTo);
    }


    public void chonROWTTSolUongNguoiTrongTo(MouseEvent mouseEvent) {
        if (!DSSoLuongNguoiTrongTo.isEmpty()){
            SoLuonNguoitTrongTo slntt = tblViewTTToPhanCongCongNhan.getSelectionModel().getSelectedItem();
            String tenTo = slntt.getTsx().getTenTSX();
            tfToPhanCong.setText(tenTo);
        } else return;
    }
    private boolean kiemTraTTTruocKhiPhanCong(){
        if (tfSanPhamPhanCong.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn sản phẩm");
            return false;
        } else if (tfCongDoanPhanCong.getText().trim().isEmpty()) {
            Alerts.showConfirmation("Thông báo", "Chưa chọn công đoạn");
            return false;
        }else if(tfToPhanCong.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưc chọn tổ");
            return false;
        } else if (tfSoLuongPhanCongTungNguoi.getText().trim().isEmpty()) {
            Alerts.showConfirmation("Thông báo:","Chưa nhập số lượng phân công cho mỗi người");
            return false;
        } else if (!StringUtils.isNumeric(tfSoLuongPhanCongTungNguoi.getText().trim())) {
            Optional<ButtonType> rs = Alerts.showConfirmation("Thông báo:","Số lượng phân công phải là số");
            if (rs.isPresent() && rs.get() == ButtonType.OK){
                tfSoLuongPhanCongTungNguoi.setText("");
                tfSoLuongPhanCongTungNguoi.requestFocus();
                return false;
            }else
                return false;
        } else if (datepickNgayKetThuc.getValue() == null) {
            Alerts.showConfirmation("Thông báo:","Chưa chọn ngày kết thúc");
            return false;
        } else if (datepickNgayKetThuc.getValue() != null){
            LocalDate lc = datepickNgayKetThuc.getValue();
            int thangkt = lc.getMonth().getValue(); //Hoac la getMonthValue()


            LocalDate lcc = datepickNgayPhanCong.getValue();
            int thangPhanCong = lcc.getMonthValue();

            if (thangPhanCong <= thangkt ){
                return true;
            } else {
                Alerts.showConfirmation("Thông báo:","ngày tháng kết thúc phải trước ngày tháng phân công");
                datepickNgayKetThuc.requestFocus();
                return false;
            }

        }



        return true;
    }

    public void phanCongCongNhan(ActionEvent actionEvent) {
        if (kiemTraTTTruocKhiPhanCong()){
            SoLuonNguoitTrongTo slngtt = tblViewTTToPhanCongCongNhan.getSelectionModel().getSelectedItem();
            ToSanXuat to = slngtt.getTsx();
            ObservableList<CongNhan> DSCongNhanTheoMaTo = FXCollections.observableArrayList();

            DSCongNhanTheoMaTo.addAll(PhanCongCongNhanDao.getInstance().getDSNhanVienTheoTo(to.getMaTSX().trim()));
            CongDoan cd =tblViewTTCongDoanPhanCongCongNhan.getSelectionModel().getSelectedItem();
            String ngaypc = Utils.dinhDangNgayHienTai(datepickNgayPhanCong.getValue(),"ddMMYY");

            LocalDate localDate = datepickNgayPhanCong.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date ngayPhanCong = Date.from(instant);

            LocalDate localDate1 = datepickNgayKetThuc.getValue();
            Instant instant1 = Instant.from(localDate1.atStartOfDay(ZoneId.systemDefault()));
            Date ngayKetThuc = Date.from(instant1);

            for (int i =0; i < DSCongNhanTheoMaTo.size(); i++){
                CongNhan cn = DSCongNhanTheoMaTo.get(i);
                String maBangPC = "PC"+Utils.taoMaBangChamCong(cn.getMaCN(),ngaypc);
                BangPhanCongCongNhan bpccn = new BangPhanCongCongNhan(maBangPC,cn,cd,Integer.parseInt(tfSoLuongPhanCongTungNguoi.getText().trim()),ngayPhanCong,ngayKetThuc);
                DSPhanCongTungCongNhan.add(bpccn);

            }
        }
        tblViewTTSanPhamPhanCongCongNhan.getSelectionModel().clearSelection();
        tblViewTTCongDoanPhanCongCongNhan.getSelectionModel().clearSelection();
        tblViewTTToPhanCongCongNhan.getSelectionModel().clearSelection();
        tfSanPhamPhanCong.setText(""); tfSoLuongPhanCongTungNguoi.setText(""); tfToPhanCong.setText(""); tfCongDoanPhanCong.setText("");
    }
    private void docDULieuVaotblViewTTPhanCongTungCongNhan(){
        colMaChamCongTTPhanCongTungCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangPhanCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangPhanCongCongNhan, String> bangPhanCongCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaBPCCN());
            }
        });

        colNgayPhamCongChamCongTTPhanCongTungCongNhan.setCellValueFactory(new PropertyValueFactory<>("ngayPC"));
        Utils.formatTableColumnDate(colNgayPhamCongChamCongTTPhanCongTungCongNhan,"dd/MM/YYYY");

        colTenSanPhamTTPhanCongTungCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangPhanCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangPhanCongCongNhan, String> bangPhanCongCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongDoan().getMaSanPham().getTenSP());
            }
        });

        colTenCongDoanTTPhanCongTungCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangPhanCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangPhanCongCongNhan, String> bangPhanCongCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongDoan().getTenCD());
            }
        });

        colHovaTenTTPhanCongTungCongNhan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangPhanCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangPhanCongCongNhan, String> bangPhanCongCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongNhan().getHoCN()+ " " +bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongNhan().getTenNV());
            }
        });

        colSoLuongLamTTPhanCongTungCongNhan.setCellValueFactory(new PropertyValueFactory<>("chiTieu"));

        colNgayKetThucTTPhanCongTungCongNhan.setCellValueFactory(new PropertyValueFactory<>("ngayKT"));
        Utils.formatTableColumnDate(colNgayKetThucTTPhanCongTungCongNhan,"dd/MM/YYYY");


        tblViewTTPhanCongTungCongNhan.setItems(DSPhanCongTungCongNhan);
    }

    public void LuuDSPhanCong(ActionEvent actionEvent) {
        PhanCongCongNhanDao.getInstance().saveDSPhanCong(DSPhanCongTungCongNhan);

    }
}
