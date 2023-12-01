package com.openjfx.qllspahg.gui;

import static com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan.*;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.PhanCongCongNhanDao;
import com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan;
import com.openjfx.qllspahg.dao.interfaces.DSQLThongTinCongNhan;
import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhan;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhanCoTo;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinSoLuongLamDuocTheoTo;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.util.StringConverter;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class PhanCongCongNhanController implements Initializable {

    @FXML
    private Button btnLuuPCCN;

    @FXML
    private Button btnPhanCongPCCN;

    @FXML
    private Button btnResetPCCN;

    @FXML
    private Button btnSuaPCCN;

    @FXML
    private ComboBox<CongDoan> cbxCongDoanPCCN;

    @FXML
    private ComboBox<String> cbxHopDongPCCN;

    @FXML
    private ComboBox<SanPham> cbxSanPhanPCCN;

    @FXML
    private ComboBox<ToSanXuat> cbxToPCCN;

    @FXML
    private TableColumn<BangThongTinCongNhan, String> colHoVaTenCongNhanPCCN;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colHovaTenMoiCNPCCN;

    @FXML
    private TableColumn<BangThongTinCongNhan, String> colMaCongNhanPCCN;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colMaPhanCongMoiCNPCCN;

    @FXML
    private TableColumn<BangPhanCongCongNhan, Date> colNgayPhanCongMoiCNPCCN;

    @FXML
    private TableColumn<BangThongTinCongNhan, String> colSTTCongNhanPCCN;

    @FXML
    private TableColumn<BangPhanCongCongNhan, Integer> colSoLuongLamMoiCNPCCN;

    @FXML
    private TableColumn<BangThongTinSoLuongLamDuocTheoTo,String> colTotblViewTTSoNguoiDaPC;

    @FXML
    private  TableColumn<BangThongTinSoLuongLamDuocTheoTo,String> colSoNguoitblviewSoNguoiDaPC;

    @FXML
    private DatePicker datepickNgayPhanCongPCCN;

    @FXML
    private RadioButton radPCTuDongPCCN;

    @FXML
    private RadioButton radPCTungCongNhanPCCN;

    @FXML
    private TableView<BangThongTinCongNhan> tblViewTTCongNhanPC;

    @FXML
    private TableView<BangPhanCongCongNhan> tblViewTTPhanCongMoiCNPCCN;

    @FXML
    private TableView<BangThongTinSoLuongLamDuocTheoTo> tblViewTTSoNguoiDaPC;

    @FXML
    private TextField tfHoVaTenPCCN;

    @FXML
    private TextField tfMaCongNhanPCCN;

    @FXML
    private TextField tfSoLuongCanLamPCCN;

    @FXML
    private TextField tfSoLuongCanPhanCongPCCN;

    @FXML
    private TextField tfSoLuongChuaPhanCongPCCN;

    @FXML
    private TextField tfSoLuongMoiNGuoiPCCN;

    @FXML
    private TextField tfSoLuongPhanCongPCCN;

    @FXML
    private TextField tfSoNguoiCanPhanCongPCCN;

    @FXML
    private TextField tfToPCCN;

    @FXML
    private TextField tfTongSoLuongPhanCongPCCN;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepickNgayPhanCongPCCN.setValue(LocalDate.now());
        batDauSKRad();
        loadDuLieuBanDau();

        docDuLieuVaoBangThongTinCongNhan();
        docDuLieuVaoBangTTPhanCongMoiCNPCCN();
        docDuLieuVaoBangTTSoNguoiDaPhanCong();
    }

    /**
     * Chuẩn bị
     */
    private void batDauSKRad(){
        radPCTungCongNhanPCCN.setSelected(true);
        radPCTuDongPCCN.setSelected(false);
        tfSoLuongPhanCongPCCN.setEditable(true);
        tfSoLuongPhanCongPCCN.setDisable(false);
        tfSoLuongMoiNGuoiPCCN.setEditable(false);
        tfSoLuongMoiNGuoiPCCN.setDisable(true);
    }

    private void loadDuLieuBanDau(){
        cbxHopDongPCCN.setItems(PhanCongCongNhanDao.getInstance().getAllMaHopDong());

        ObservableList<ToSanXuat> dsTSX = FXCollections.observableArrayList();
        dsTSX.addAll(PhanCongCongNhanDao.getInstance().getAllTo());
        cbxToPCCN.setItems(dsTSX);
        cbxToPCCN.setConverter(new StringConverter<ToSanXuat>() {
            @Override
            public String toString(ToSanXuat toSanXuat) {
                return toSanXuat != null ? toSanXuat.getTenTSX() : "";
            }

            @Override
            public ToSanXuat fromString(String s) {
                int selectIndex = cbxToPCCN.getSelectionModel().getSelectedIndex();
                if (selectIndex >= 0 && selectIndex < dsTSX.size())
                    return dsTSX.get(selectIndex);
                return null;
            }
        });
    }

    /**
     * Dinh dang bang
     */

    //Bảng thông tin Phân công
    public void docDuLieuVaoBangThongTinCongNhan(){
        colSTTCongNhanPCCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangThongTinCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangThongTinCongNhan, String> bangThongTinCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(bangThongTinCongNhanStringCellDataFeatures.getValue().getStt()));
            }
        });
        colMaCongNhanPCCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangThongTinCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangThongTinCongNhan, String> bangThongTinCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangThongTinCongNhanStringCellDataFeatures.getValue().getCongNhan().getMaCN());
            }
        });
        colHoVaTenCongNhanPCCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangThongTinCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangThongTinCongNhan, String> bangThongTinCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangThongTinCongNhanStringCellDataFeatures.getValue().getCongNhan().getHoCN()+ " " + bangThongTinCongNhanStringCellDataFeatures.getValue().getCongNhan().getTenCN());
            }
        });
        DSThongTinCongNhan.clear();
        tblViewTTCongNhanPC.setItems(DSThongTinCongNhan);
    }

    public void docDuLieuVaoBangTTPhanCongMoiCNPCCN(){
        colMaPhanCongMoiCNPCCN.setCellValueFactory(new PropertyValueFactory<>("maBPCCN"));
        colHovaTenMoiCNPCCN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangPhanCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangPhanCongCongNhan, String> bangPhanCongCongNhanStringCellDataFeatures) {
                return new SimpleStringProperty(bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongNhan().getHoCN()+ " "+ bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongNhan().getHoCN());
            }
        });
        colNgayPhanCongMoiCNPCCN.setCellValueFactory(new PropertyValueFactory<>("ngayPC"));
        Utils.formatTableColumnDate(colNgayPhanCongMoiCNPCCN,"dd//MM/YYYY");
        colSoLuongLamMoiCNPCCN.setCellValueFactory(new PropertyValueFactory<>("chiTieu"));

        DSTTPhanCongCongNhan.clear();
        tblViewTTPhanCongMoiCNPCCN.setItems(DSTTPhanCongCongNhan);
    }

    public void docDuLieuVaoBangTTSoNguoiDaPhanCong(){
        DSLoadSoLuongDaPhanCong.clear();
        DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo());

        colTotblViewTTSoNguoiDaPC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangThongTinSoLuongLamDuocTheoTo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangThongTinSoLuongLamDuocTheoTo, String> bangThongTinSoLuongLamDuocTheoToStringCellDataFeatures) {
                return new SimpleStringProperty(bangThongTinSoLuongLamDuocTheoToStringCellDataFeatures.getValue().getTSX().getTenTSX());
            }
        });
        colSoNguoitblviewSoNguoiDaPC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangThongTinSoLuongLamDuocTheoTo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangThongTinSoLuongLamDuocTheoTo, String> bangThongTinSoLuongLamDuocTheoToStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(bangThongTinSoLuongLamDuocTheoToStringCellDataFeatures.getValue().getSoLuongDaPhanCong()));
            }
        });

        tblViewTTSoNguoiDaPC.setItems(DSLoadSoLuongDaPhanCong);
    }


    /**
     * Sự kiện
     *
     */


    // sự kiện radio button
    public void skRadPCTuDong(ActionEvent actionEvent) {
        tblViewTTCongNhanPC.getSelectionModel().clearSelection();

        radPCTungCongNhanPCCN.setSelected(false);
        tfSoLuongPhanCongPCCN.setEditable(false);
        tfSoLuongPhanCongPCCN.setDisable(true);
        tfSoLuongMoiNGuoiPCCN.setEditable(true);
        tfSoLuongMoiNGuoiPCCN.setDisable(false);

        tfMaCongNhanPCCN.setText("");
        tfHoVaTenPCCN.setText("");
        tfSoLuongPhanCongPCCN.setText("");

        if (!cbxToPCCN.getSelectionModel().isEmpty() && radPCTuDongPCCN.isSelected()){

            tfToPCCN.setText(cbxToPCCN.getSelectionModel().getSelectedItem().getTenTSX());
            tfSoNguoiCanPhanCongPCCN.setText(tfSoLuongChuaPhanCongPCCN.getText().trim());

        } else if(!cbxToPCCN.getSelectionModel().isEmpty() && !radPCTuDongPCCN.isSelected()){
            tfToPCCN.setText("");
            tfSoNguoiCanPhanCongPCCN.setText("");
            tfSoLuongMoiNGuoiPCCN.setText("");
            tfTongSoLuongPhanCongPCCN.setText("");
        }

        if (!radPCTuDongPCCN.isSelected()){
            tfSoLuongPhanCongPCCN.setEditable(true);
            tfSoLuongPhanCongPCCN.setDisable(true);
            tfSoLuongMoiNGuoiPCCN.setEditable(true);
            tfSoLuongMoiNGuoiPCCN.setDisable(true);
        }

    }

    public void skRadPCTungCongNhan(ActionEvent actionEvent) {
        radPCTuDongPCCN.setSelected(false);
        tfSoLuongPhanCongPCCN.setEditable(true);
        tfSoLuongPhanCongPCCN.setDisable(false);
        tfSoLuongMoiNGuoiPCCN.setEditable(false);
        tfSoLuongMoiNGuoiPCCN.setDisable(true);

        tfToPCCN.setText("");
        tfSoNguoiCanPhanCongPCCN.setText("");
        tfSoLuongMoiNGuoiPCCN.setText("");
        tfTongSoLuongPhanCongPCCN.setText("");


        if (!radPCTungCongNhanPCCN.isSelected()){
            tfSoLuongPhanCongPCCN.setEditable(true);
            tfSoLuongPhanCongPCCN.setDisable(true);
            tfSoLuongMoiNGuoiPCCN.setEditable(true);
            tfSoLuongMoiNGuoiPCCN.setDisable(true);

            tblViewTTCongNhanPC.getSelectionModel().clearSelection();

            tfMaCongNhanPCCN.setText("");
            tfHoVaTenPCCN.setText("");
            tfSoLuongPhanCongPCCN.setText("");
        }

        if (!tblViewTTCongNhanPC.getSelectionModel().isEmpty() && radPCTungCongNhanPCCN.isSelected()){
            tfMaCongNhanPCCN.setText(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getMaCN());
            tfHoVaTenPCCN.setText(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getHoCN()+" "+
                    tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getTenCN());
        }

    }


    // Sự kiện cbx
    public void skcbxMaHopDong(ActionEvent actionEvent) {
        if (!cbxHopDongPCCN.getSelectionModel().isEmpty()){
            cbxSanPhanPCCN.setItems(null);
            ObservableList<SanPham> dsSP = FXCollections.observableArrayList();
            dsSP.addAll(PhanCongCongNhanDao.getInstance().getSPCanLamTheoMaHD(cbxHopDongPCCN.getSelectionModel().getSelectedItem().toString()));
            cbxSanPhanPCCN.setItems(dsSP);
            cbxSanPhanPCCN.setConverter(new StringConverter<SanPham>() { //Thay doi hien thi tren combobox
                @Override
                public String toString(SanPham sp) { //Phuong thuc
                    return sp != null ? sp.getTenSP() : "null"; // so sanh value obj cong doan de gan len combox hien thi
                }

                @Override
                public SanPham fromString(String string) { //tra ve obj khi chon tren ds combo box => o day so sanh vi tri duoc chon de lay

                    int selectedIndex = cbxSanPhanPCCN.getSelectionModel().getSelectedIndex();

                    //xem vi tri chon co nam trong ds khong
                    if (selectedIndex >= 0 && selectedIndex < dsSP.size()) {
                        //tra ra obj duoc chon
                        return dsSP.get(selectedIndex);
                    }
                    return null;
                }
            });
        }
    }

    public void skcbxSanPham(ActionEvent actionEvent) {
        if (!cbxHopDongPCCN.getSelectionModel().isEmpty() && !cbxSanPhanPCCN.getSelectionModel().isEmpty()){
            //lấy dữ liệu cho text field so luong can lam nếu cbx hop dong duoc chon va cbx san pham dc chon
            int soLuongCanLam = PhanCongCongNhanDao.getInstance().getSoLuongCanlam(cbxHopDongPCCN.getSelectionModel().getSelectedItem().toString(),
                    cbxSanPhanPCCN.getSelectionModel().getSelectedItem().getMaSP());
            if (soLuongCanLam >=0){
                tfSoLuongCanLamPCCN.setText(String.valueOf(soLuongCanLam));
            } else
                tfSoLuongCanLamPCCN.setText("Dư "+String.valueOf(-1*soLuongCanLam));
            // lấy dữ liệu cho cbx Cong đoạn
            ObservableList<CongDoan> dsCD = FXCollections.observableArrayList();
            cbxCongDoanPCCN.setItems(null);
            dsCD.addAll(PhanCongCongNhanDao.getInstance().getCongDoan(cbxSanPhanPCCN.getSelectionModel().getSelectedItem().getMaSP(),
                    cbxHopDongPCCN.getSelectionModel().getSelectedItem().toString()));
            cbxCongDoanPCCN.setItems(dsCD);
            cbxCongDoanPCCN.setConverter(new StringConverter<CongDoan>() {
                @Override
                public String toString(CongDoan congDoan) {
                    return congDoan !=null ? congDoan.getTenCD() : "null";
                }

                @Override
                public CongDoan fromString(String s) {
                    int selectedIndex = cbxCongDoanPCCN.getSelectionModel().getSelectedIndex();

                    //xem vi tri chon co nam trong ds khong
                    if (selectedIndex >= 0 && selectedIndex < dsCD.size()) {
                        //tra ra obj duoc chon
                        return dsCD.get(selectedIndex);
                    }
                    return null;
                }
            });

        } else if (!cbxHopDongPCCN.getSelectionModel().isEmpty() && cbxSanPhanPCCN.getSelectionModel().isEmpty()){
            //set text field so luong can lam = 0 nếu cbx hop dong duoc chon va cbx san pham ko dc chon
            tfSoLuongCanLamPCCN.setText(String.valueOf(0));
            cbxCongDoanPCCN.setItems(null);
        }else{
            tfSoLuongCanLamPCCN.setText(String.valueOf(0));
            cbxSanPhanPCCN.setItems(null);
        }

    }

    public void skcbxCongDoan(ActionEvent actionEvent) {
        int soLuongCanLam = Integer.parseInt(tfSoLuongCanLamPCCN.getText().trim());
        if (!cbxCongDoanPCCN.getSelectionModel().isEmpty()){
            int soLuongDaPhanCongChuaLuu = 0;
            if (!DSTTPhanCongCongNhan.isEmpty()){
                for( BangPhanCongCongNhan bpc : DSTTPhanCongCongNhan){
                    if (cbxHopDongPCCN.getSelectionModel().getSelectedItem().equals(bpc.getMaHopDong().getMaHD()) && cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD().equals(bpc.getMaCongDoan().getMaCD()))
                        soLuongDaPhanCongChuaLuu += bpc.getChiTieu();
                }
            }

            int soLuongCanPhanCong = soLuongCanLam - PhanCongCongNhanDao.getInstance().getSoLuongDaPhanCong(
                    cbxSanPhanPCCN.getSelectionModel().getSelectedItem().getMaSP(),
                    cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD(),
                    cbxHopDongPCCN.getSelectionModel().getSelectedItem().toString()
            ) - soLuongDaPhanCongChuaLuu;
            if (soLuongCanPhanCong >=0){
                tfSoLuongCanPhanCongPCCN.setText(String.valueOf(soLuongCanPhanCong));
            }else {
                tfSoLuongCanPhanCongPCCN.setText("Đã dư "+ String.valueOf(-1*soLuongCanPhanCong) );
            }
        }else if(cbxCongDoanPCCN.getSelectionModel().isEmpty()){
            tfSoLuongCanPhanCongPCCN.setText("0");
        }
    }

    public void skcbxTo(ActionEvent actionEvent) {
        if (!cbxToPCCN.getSelectionModel().isEmpty()){
            int soNguoiPhanCuaToNhungChuaLuu = 0;
            ObservableList<BangThongTinCongNhan> dsCongNhanTheoToChuaLuu = FXCollections.observableArrayList();

            if (!DSPhanCongCanSave.isEmpty()){
                for (BangThongTinCongNhanCoTo btnpc : DSTTPhanCongChuaLuuCoTo){
                    if (btnpc.getTSX().equals(cbxToPCCN.getSelectionModel().getSelectedItem())){
                        soNguoiPhanCuaToNhungChuaLuu ++;
                    }
                }
                dsCongNhanTheoToChuaLuu.addAll(DSTTPhanCongChuaLuu);

            }
            int soNguoiCanPhanCong = PhanCongCongNhanDao.getInstance().getSoLuongNguoiCoTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX())
                    - PhanCongCongNhanDao.getInstance().getSoLuongNguoiDaPhanCongTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX(), Utils.dinhDangNgayHienTai(LocalDate.now(),"ddMMYY"))
                    -soNguoiPhanCuaToNhungChuaLuu;

            if (!cbxToPCCN.getSelectionModel().isEmpty()){
                tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(soNguoiCanPhanCong));

            } else if (cbxToPCCN.getSelectionModel().isEmpty() ) {
                tfSoLuongChuaPhanCongPCCN.setText("0");
            }


            if (radPCTuDongPCCN.isSelected()){
                tfToPCCN.setText(cbxToPCCN.getSelectionModel().getSelectedItem().getTenTSX());
                tfSoNguoiCanPhanCongPCCN.setText(String.valueOf(soNguoiCanPhanCong));
            }
            if (Integer.parseInt(tfSoLuongChuaPhanCongPCCN.getText().trim()) >0){
                DSThongTinCongNhan.clear();
                ObservableList<BangThongTinCongNhan> dsTTCongNhanTheoToChuaPhanCong = FXCollections.observableArrayList();
                dsTTCongNhanTheoToChuaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getallCongNhanChuaPhanCongTheomaTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX()));
                if (!dsCongNhanTheoToChuaLuu.isEmpty()){
                    for (BangThongTinCongNhan bangThongTinCongNhan : dsCongNhanTheoToChuaLuu) {
                        dsTTCongNhanTheoToChuaPhanCong.remove(bangThongTinCongNhan);
                    }
                }
                DSThongTinCongNhan.addAll(dsTTCongNhanTheoToChuaPhanCong);
            } else {
                DSThongTinCongNhan.clear();
            }
        }
    }


    //Sự kiện trên table
    public void skChonROWtblViewTTCongNhan(MouseEvent mouseEvent) {
        if(!DSThongTinCongNhan.isEmpty() && ! tblViewTTCongNhanPC.getSelectionModel().getSelectedIndices().isEmpty()){
            //rad su kiện
            radPCTungCongNhanPCCN.setSelected(true);
            radPCTuDongPCCN.setSelected(false);

            tfSoLuongPhanCongPCCN.setEditable(true);
            tfSoLuongPhanCongPCCN.setDisable(false);
            tfSoLuongMoiNGuoiPCCN.setEditable(false);
            tfSoLuongMoiNGuoiPCCN.setDisable(true);

            tfToPCCN.setText("");
            tfSoNguoiCanPhanCongPCCN.setText("");
            tfSoLuongMoiNGuoiPCCN.setText("");
            tfTongSoLuongPhanCongPCCN.setText("");

            if (!radPCTungCongNhanPCCN.isSelected()){
                tfSoLuongPhanCongPCCN.setEditable(true);
                tfSoLuongPhanCongPCCN.setDisable(true);
                tfSoLuongMoiNGuoiPCCN.setEditable(true);
                tfSoLuongMoiNGuoiPCCN.setDisable(true);
            }

            //tf nhập sự kiện
            tfMaCongNhanPCCN.setText(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getMaCN());
            tfHoVaTenPCCN.setText(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getHoCN()+" "+
                    tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getTenCN());

        }
    }

    //Chưa làm
    public void skChonRowtbtViewTTPhanCong(MouseEvent mouseEvent) {
//        if (!DSTTPhanCongCongNhan.isEmpty() && !tblViewTTPhanCongMoiCNPCCN.getSelectionModel().isEmpty()){
//            BangPhanCongCongNhan bangPCCN = new BangPhanCongCongNhan();
//            bangPCCN = tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem();
//
//
//            cbxHopDongPCCN.getSelectionModel().select(bangPCCN.getMaHopDong().getMaHD());
//            cbxSanPhanPCCN.getSelectionModel().select(bangPCCN.getMaCongDoan().getMaSanPham());
//            cbxCongDoanPCCN.getSelectionModel().select(bangPCCN.getMaCongDoan());
//
//        }
    }
    // Chưa làm


    //Sự kiện trên textfield
    public void skNhaptfSoLuongMoiNGuoiPCCN(ActionEvent actionEvent) {
        int soNguoiCanPhanCong = Integer.parseInt(tfSoNguoiCanPhanCongPCCN.getText().trim());
        if (!StringUtils.isNumeric(tfSoNguoiCanPhanCongPCCN.getText().trim())){
            Alerts.showConfirmation("Thông báo","Phải nhập số lượng là số");
            tfSoNguoiCanPhanCongPCCN.setText("");
            tfSoNguoiCanPhanCongPCCN.requestFocus();
            return;
        }
        int soLuongPhanCongChoMoiNguoi = Integer.parseInt(tfSoLuongMoiNGuoiPCCN.getText().trim());
        tfTongSoLuongPhanCongPCCN.setText(String.valueOf(soLuongPhanCongChoMoiNguoi*soNguoiCanPhanCong));

    }


    //Sự kiện button
    public void skbtnPhanCongCN(ActionEvent actionEvent) {
        if (radPCTungCongNhanPCCN.isSelected() && !DSThongTinCongNhan.isEmpty()){
            if (kiemTraPCTungNguoi()){
                CongNhan maCN = new CongNhan( tfMaCongNhanPCCN.getText().trim(),
                        tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getHoCN(),
                        tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getTenCN());
                String maBPCCN ="PC"+ Utils.taoMaBangChamCong(maCN.getMaCN(),Utils.dinhDangNgayHienTai(LocalDate.now(),"ddMMYY"));
                CongDoan maCD = new CongDoan(cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD());
                HopDong maHD = new HopDong(cbxHopDongPCCN.getSelectionModel().getSelectedItem().trim());
                int chiTieu = 0;
                if (!tfSoLuongPhanCongPCCN.getText().equals("")){
                    chiTieu = Integer.parseInt(tfSoLuongPhanCongPCCN.getText().trim());
                }
                if (chiTieu == 0) {
                    Alerts.showConfirmation("Thông báo", "Chỉ tiêu phải lớn hơn 0 và không được bỏ trống");
                    return;
                }

                try {
                    int soLuongCanPhanCongSauKhiPC = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText().trim()) - chiTieu;
                    if (soLuongCanPhanCongSauKhiPC >= 0){
                        tfSoLuongCanPhanCongPCCN.setText(String.valueOf(soLuongCanPhanCongSauKhiPC));
                    } else{
                        tfSoLuongCanPhanCongPCCN.setText("Đã dư " + String.valueOf(-1*soLuongCanPhanCongSauKhiPC));
                    }
                } catch (NumberFormatException e){
                    Alerts.showConfirmation("Thông báo", "Số lương phân công đã dư");
                    return;
                }
                LocalDate localDate = LocalDate.now();
                Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date ngayPhanCong = Date.from(instant);
                LocalDate lc = LocalDate.now().plusDays(1);
                Instant in = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date ngayKetThuc = Date.from(in);

                BangPhanCongCongNhan pc = new BangPhanCongCongNhan(maBPCCN,maCN,maCD,maHD,chiTieu,ngayPhanCong,ngayKetThuc);

                DSTTPhanCongCongNhan.add(pc);
                DSPhanCongCanSave.add(pc);
                DSTTPhanCongChuaLuu.add(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem());
                DSTTPhanCongChuaLuuCoTo.add(new BangThongTinCongNhanCoTo(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem(),cbxToPCCN.getSelectionModel().getSelectedItem()));
                DSThongTinCongNhan.remove(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem());

                tblViewTTCongNhanPC.getSelectionModel().clearSelection();
                tfMaCongNhanPCCN.setText("");
                tfHoVaTenPCCN.setText("");
                tfSoLuongPhanCongPCCN.setText("");
                tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(Integer.parseInt(tfSoLuongChuaPhanCongPCCN.getText())-1));

            }
        }

        if (radPCTuDongPCCN.isSelected() && !DSThongTinCongNhan.isEmpty()){
            if (kiemTraPCTuDong()){
                int j = -1;
                for(int i = 0 ; i< DSThongTinCongNhan.size(); i++){
                    CongNhan maCN = DSThongTinCongNhan.get(i).getCongNhan();
                    String maBPCCN = "PC"+ Utils.taoMaBangChamCong(maCN.getMaCN(),Utils.dinhDangNgayHienTai(LocalDate.now(),"ddMMYY"));
                    CongDoan maCD = new CongDoan(cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD());
                    HopDong maHD = new HopDong(cbxHopDongPCCN.getSelectionModel().getSelectedItem().trim());

                    int chiTieu = 0;
                    if (!tfSoLuongMoiNGuoiPCCN.getText().equals("")){
                        chiTieu = Integer.parseInt(tfSoLuongMoiNGuoiPCCN.getText().trim());
                    }
                    if (chiTieu == 0) {
                        Alerts.showConfirmation("Thông báo", "Chỉ tiêu phải lớn hơn 0 và không được bỏ trống");
                        return;
                    }

                    try {
                        int soLuongCanPhanCongSauKhiPC = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText().trim()) - chiTieu;
                        if (soLuongCanPhanCongSauKhiPC >= 0){
                            tfSoLuongCanPhanCongPCCN.setText(String.valueOf(soLuongCanPhanCongSauKhiPC));
                        } else{
                            tfSoLuongCanPhanCongPCCN.setText("Đã dư " + String.valueOf(-1*soLuongCanPhanCongSauKhiPC));
                        }
                    } catch (NumberFormatException e){
                        Alerts.showConfirmation("Thông báo", "Số lương phân công đã dư");
                        return;
                    }

                    LocalDate localDate = LocalDate.now();
                    Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                    Date ngayPhanCong = Date.from(instant);
                    LocalDate lc = LocalDate.now().plusDays(1);
                    Instant in = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                    Date ngayKetThuc = Date.from(in);

                    BangPhanCongCongNhan pc = new BangPhanCongCongNhan(maBPCCN,maCN,maCD,maHD,chiTieu,ngayPhanCong,ngayKetThuc);

                    DSTTPhanCongCongNhan.add(pc);
                    DSPhanCongCanSave.add(pc);
                    DSTTPhanCongChuaLuu.add(DSThongTinCongNhan.get(i));
                    DSTTPhanCongChuaLuuCoTo.add(new BangThongTinCongNhanCoTo(DSThongTinCongNhan.get(i),cbxToPCCN.getSelectionModel().getSelectedItem()));

                    tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(Integer.parseInt(tfSoLuongChuaPhanCongPCCN.getText())-1));

                    if (DSThongTinCongNhan.contains(new BangThongTinCongNhan(pc.getMaCongNhan()))){
                        DSThongTinCongNhan.remove((new BangThongTinCongNhan(pc.getMaCongNhan())));
                    }
                    i--;

                }

                tfSoNguoiCanPhanCongPCCN.setText(tfSoLuongChuaPhanCongPCCN.getText());
                tfSoLuongMoiNGuoiPCCN.setText("");

            }
        }
    }

    public void skbtnLuu(ActionEvent actionEvent) throws InterruptedException {
        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo:","Bạn có muốn lưu không?");
        if (result.isPresent() && result.get() == ButtonType.OK){
            TimeUnit.MICROSECONDS.sleep(500);
            if (PhanCongCongNhanDao.getInstance().saveDSPhanCong(DSPhanCongCanSave)){
                Alerts.showConfirmation("Thông báo:","Lưu thành công!!@!");
                DSTTPhanCongCongNhan.clear();
                DSPhanCongCanSave.clear();

                DSLoadSoLuongDaPhanCong.clear();
                DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo());

            }else
                Alerts.showConfirmation("Thông báo:","Lưu thành công!!@!");
        }

    }

    public void skbtnReset(ActionEvent actionEvent) {
        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo", "Sau khi reset sẽ mất hết dữ liệu chưa lưu");
        if (result.isPresent() && result.get() == ButtonType.OK){
            //reset ComboBox
            cbxHopDongPCCN.getSelectionModel().clearSelection();
            cbxHopDongPCCN.setItems(null);
            cbxHopDongPCCN.setItems(PhanCongCongNhanDao.getInstance().getAllMaHopDong());

            cbxSanPhanPCCN.getSelectionModel().clearSelection();
            cbxSanPhanPCCN.setItems(null);

            cbxCongDoanPCCN.getSelectionModel().clearSelection();
            cbxCongDoanPCCN.setItems(null);

            ObservableList<ToSanXuat> dsTSX = FXCollections.observableArrayList();
            dsTSX.addAll(PhanCongCongNhanDao.getInstance().getAllTo());
            cbxToPCCN.getSelectionModel().clearSelection();
            cbxToPCCN.setItems(null);
            cbxToPCCN.setItems(dsTSX);
            cbxToPCCN.setConverter(new StringConverter<ToSanXuat>() {
                @Override
                public String toString(ToSanXuat toSanXuat) {
                    return toSanXuat != null ? toSanXuat.getTenTSX() : "";
                }

                @Override
                public ToSanXuat fromString(String s) {
                    int selectIndex = cbxToPCCN.getSelectionModel().getSelectedIndex();
                    if (selectIndex >= 0 && selectIndex < dsTSX.size())
                        return dsTSX.get(selectIndex);
                    return null;
                }
            });

            //reset textfield
            tfHoVaTenPCCN.setText("");
            tfMaCongNhanPCCN.setText("");
            tfSoLuongCanLamPCCN.setText("");
            tfSoLuongCanPhanCongPCCN.setText("");
            tfSoLuongChuaPhanCongPCCN.setText("");
            tfSoLuongMoiNGuoiPCCN.setText("");
            tfSoLuongPhanCongPCCN.setText("");
            tfSoNguoiCanPhanCongPCCN.setText("");
            tfToPCCN.setText("");
            tfTongSoLuongPhanCongPCCN.setText("");

            //reset DanhSach
            DSLoadSoLuongDaPhanCong.clear();
            DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo());

            DSPhanCongCanSave.clear();
            DSTTPhanCongCongNhan.clear();

            DSThongTinCongNhan.clear();
        }



    }

    //Chưa làm
    public void skbtnSuaPCCN(ActionEvent actionEvent) {
    }
    //Chưa làm

    /**
     * Phương thức
     */


    //kiểm tra thông tin nhập khi ấn button nhập từng người
    private boolean kiemTraPCTungNguoi(){
         if(cbxHopDongPCCN.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn hợp đồng");
            return false;
        } else if (cbxCongDoanPCCN.getSelectionModel().isEmpty() || cbxCongDoanPCCN.getSelectionModel().isEmpty() && cbxSanPhanPCCN.getSelectionModel().isEmpty()){
             Alerts.showConfirmation("Thông báo", "Chưa chọn công đoạn");
             return false;
        } else if (tfMaCongNhanPCCN.getText().isEmpty()){
             Alerts.showConfirmation("Thông báo","Chưa chọn công nhân phân công");
             return false;
         } else if (!StringUtils.isNumeric(tfSoLuongPhanCongPCCN.getText().trim())) {
             Alerts.showConfirmation("Thông báo", "Số lượng phân công phải là số");
             return false;
         }
        return true;
    }

    private  boolean kiemTraPCTuDong(){
        if(cbxHopDongPCCN.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn hợp đồng");
            return false;
        } else if (cbxCongDoanPCCN.getSelectionModel().isEmpty() || cbxCongDoanPCCN.getSelectionModel().isEmpty() && cbxSanPhanPCCN.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn công đoạn");
            return false;
        } else if (!StringUtils.isNumeric(tfSoLuongMoiNGuoiPCCN.getText().trim())) {
            Alerts.showConfirmation("Thông báo", "Số lượng phân công phải là số");
            return false;
        }
        return true;
    }





}
