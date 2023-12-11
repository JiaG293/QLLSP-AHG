package com.openjfx.qllspahg.gui;

import static com.openjfx.qllspahg.dao.interfaces.DSPhanCongCongNhan.*;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.ChamCongCongNhanDaoImpl;
import com.openjfx.qllspahg.dao.PhanCongCongNhanDao;

import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhan;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinCongNhanCoTo;
import com.openjfx.qllspahg.entity.model.PhanCongCongNhan.BangThongTinSoLuongLamDuocTheoTo;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.DateUtils;
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
    private ComboBox<HopDong> cbxHopDongPCCN;

    @FXML
    private ComboBox<SanPham> cbxSanPhanPCCN;

    @FXML
    private ComboBox<ToSanXuat> cbxToPCCN;

    @FXML
    private CheckBox ckcTangCa;

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
    private TableColumn<BangThongTinSoLuongLamDuocTheoTo,String> colSoNguoiTrongTo;

    @FXML
    private TableColumn<BangPhanCongCongNhan, String> colThongTinPhanCong;

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
    private TextField tfSoLuongPhanCongConLai;

    @FXML
    private TextField tfTongSoLuongPhanCongPCCN;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        /**
         * Hồ Tấn Lộc
         * Hoàn thành 3/12/2023
         * 11.36pm
         */

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
//        cbxHopDongPCCN.setItems(PhanCongCongNhanDao.getInstance().getAllMaHopDong());
        ObservableList<HopDong> dsHopDong = FXCollections.observableArrayList();
        dsHopDong.addAll(PhanCongCongNhanDao.getInstance().getAllMaHopDong());
        cbxHopDongPCCN.setItems(dsHopDong);
        cbxHopDongPCCN.setConverter(new StringConverter<HopDong>() {
            @Override
            public String toString(HopDong hopDong) {
                return hopDong != null ? hopDong.getMaHD() +" Ngày hết hạn HD: "+ DateUtils.formatStringVietnamDate(hopDong.getNgayTLHD()) : "";
            }

            @Override
            public HopDong fromString(String s) {
                int select = cbxHopDongPCCN.getSelectionModel().getSelectedIndex();
                if (select >0 && select <dsHopDong.size())
                    return dsHopDong.get(select);
                return null;
            }
        });

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
        colThongTinPhanCong.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangPhanCongCongNhan, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangPhanCongCongNhan, String> bangPhanCongCongNhanStringCellDataFeatures) {
                CongDoan cd = PhanCongCongNhanDao.getInstance().getSPvaCDVaoTablePhanCong(bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaCongDoan().getMaCD());
                return new SimpleStringProperty("Hợp dồng "+bangPhanCongCongNhanStringCellDataFeatures.getValue().getMaHopDong().getMaHD()+ "\n" +
                        "Sản phẩm: "+cd.getTenCD()+
                        "\nCông đoạn: " + cd.getMaSanPham().getTenSP());
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
        DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo(Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

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
        colSoNguoiTrongTo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangThongTinSoLuongLamDuocTheoTo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangThongTinSoLuongLamDuocTheoTo, String> bangThongTinSoLuongLamDuocTheoToStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(bangThongTinSoLuongLamDuocTheoToStringCellDataFeatures.getValue().getSoNguoiCoTrongTo()));
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
        tblViewTTPhanCongMoiCNPCCN.getSelectionModel().clearSelection();

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
        tfSoLuongPhanCongConLai.setText("");


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
            dsSP.addAll(PhanCongCongNhanDao.getInstance().getSPCanLamTheoMaHD(cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD()));
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
            int soLuongCanLam = PhanCongCongNhanDao.getInstance().getSoLuongCanlam(cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD(),
                    cbxSanPhanPCCN.getSelectionModel().getSelectedItem().getMaSP());
            if (soLuongCanLam >=0){
                tfSoLuongCanLamPCCN.setText(String.valueOf(soLuongCanLam));
            } else
                tfSoLuongCanLamPCCN.setText("Dư "+ -1 * soLuongCanLam);
            // lấy dữ liệu cho cbx Cong đoạn
            ObservableList<CongDoan> dsCD = FXCollections.observableArrayList();
            cbxCongDoanPCCN.setItems(null);
            dsCD.addAll(PhanCongCongNhanDao.getInstance().getCongDoan(cbxSanPhanPCCN.getSelectionModel().getSelectedItem().getMaSP(),
                    cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD()));
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
        if (!cbxCongDoanPCCN.getSelectionModel().isEmpty() && !datepickNgayPhanCongPCCN.getValue().isBefore(LocalDate.now())){
            int soLuongCanLam = Integer.parseInt(tfSoLuongCanLamPCCN.getText().trim());
            int soLuongDaPhanCongChuaLuu = 0;
            if (!DSPhanCongCanSave.isEmpty() || !DSPhanCongCongNhanUpdate.isEmpty()){
                for( BangPhanCongCongNhan bpc : DSPhanCongCanSave){
                    if (cbxHopDongPCCN.getSelectionModel().getSelectedItem().equals(bpc.getMaHopDong().getMaHD()) && cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD().equals(bpc.getMaCongDoan().getMaCD()))
                        soLuongDaPhanCongChuaLuu += bpc.getChiTieu();
                }
                int a =0;
                for (BangPhanCongCongNhan acc : DSPhanCongCongNhanUpdate){
                    for (BangPhanCongCongNhan bcc : DSPhanCongCongNhanDaLuu)
                        if (acc.getMaBPCCN().equals(bcc.getMaBPCCN()))
                            a = bcc.getChiTieu();
                    if (cbxHopDongPCCN.getSelectionModel().getSelectedItem().equals(acc.getMaHopDong().getMaHD()) && cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD().equals(acc.getMaCongDoan().getMaCD()))
                        if (a-acc.getChiTieu()>0){
                            soLuongDaPhanCongChuaLuu += (a-acc.getChiTieu()) *-1;
                        } else
                            soLuongDaPhanCongChuaLuu += acc.getChiTieu()-a;
                }
            }

            int soLuongCanPhanCong = soLuongCanLam - PhanCongCongNhanDao.getInstance().getSoLuongDaPhanCong(
                    cbxSanPhanPCCN.getSelectionModel().getSelectedItem().getMaSP(),
                    cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD(),
                    cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD()
            ) - soLuongDaPhanCongChuaLuu;
            if (soLuongCanPhanCong >=0){
                tfSoLuongCanPhanCongPCCN.setText(String.valueOf(soLuongCanPhanCong));
            }else {
                tfSoLuongCanPhanCongPCCN.setText("Đã dư "+ -1 * soLuongCanPhanCong);
            }
        }else if(cbxCongDoanPCCN.getSelectionModel().isEmpty()){
            tfSoLuongCanPhanCongPCCN.setText("0");
        }
    }

    public void skcbxTo(ActionEvent actionEvent) {
        if (!cbxToPCCN.getSelectionModel().isEmpty()){

            BangThongTinSoLuongLamDuocTheoTo bc = new BangThongTinSoLuongLamDuocTheoTo(new ToSanXuat(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX()));
            tblViewTTSoNguoiDaPC.getSelectionModel().select(bc);
            tblViewTTSoNguoiDaPC.scrollTo(bc);

            int soNguoiPhanCuaToNhungChuaLuu = 0;

            if (!DSPhanCongCanSave.isEmpty()){
                for (BangThongTinCongNhanCoTo btnpc : DSTTPhanCongChuaLuuCoTo){
                    if (btnpc.getTSX().equals(cbxToPCCN.getSelectionModel().getSelectedItem()) && btnpc.getNgay().equals(Date.from(datepickNgayPhanCongPCCN.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()))){
                        soNguoiPhanCuaToNhungChuaLuu ++;
                    }
                }

            }
            int soNguoiCanPhanCong = PhanCongCongNhanDao.getInstance().getSoLuongNguoiCoTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX())
                    - PhanCongCongNhanDao.getInstance().getSoLuongNguoiDaPhanCongTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX(), Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY"))
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
            if (Integer.parseInt(tfSoLuongChuaPhanCongPCCN.getText().trim()) >0 && !datepickNgayPhanCongPCCN.getValue().isBefore(LocalDate.now())){
                DSThongTinCongNhan.clear();
                ObservableList<BangThongTinCongNhan> dsTTCongNhanTheoToChuaPhanCong = FXCollections.observableArrayList();
                dsTTCongNhanTheoToChuaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getallCongNhanChuaPhanCongTheomaTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX(),
                        Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

                ObservableList<BangThongTinCongNhanCoTo> dsCongNhanTheoToChuaLuu = FXCollections.observableArrayList();
                dsCongNhanTheoToChuaLuu.addAll(DSTTPhanCongChuaLuuCoTo);
                if (!dsCongNhanTheoToChuaLuu.isEmpty()){
                    for (int i =0 ; i< dsTTCongNhanTheoToChuaPhanCong.size(); i++)
                        for (BangThongTinCongNhanCoTo bttcn : dsCongNhanTheoToChuaLuu) {
                            if (bttcn.getBangPCCN().equals(dsTTCongNhanTheoToChuaPhanCong.get(i)) && bttcn.getNgay().equals(Date.from(datepickNgayPhanCongPCCN.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()))){
                                dsTTCongNhanTheoToChuaPhanCong.remove(bttcn.getBangPCCN());
                                i--;
                            }

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
        tblViewTTPhanCongMoiCNPCCN.getSelectionModel().clearSelection();
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

    public void skChonRowtbtViewTTPhanCong(MouseEvent mouseEvent) {

        if (!DSTTPhanCongCongNhan.isEmpty() && !tblViewTTPhanCongMoiCNPCCN.getSelectionModel().isEmpty()){

            tblViewTTCongNhanPC.getSelectionModel().clearSelection();

            if (!datepickNgayPhanCongPCCN.getValue().isBefore(LocalDate.now())) {

                radPCTungCongNhanPCCN.setSelected(true);
                radPCTuDongPCCN.setSelected(false);
                tfSoLuongPhanCongPCCN.setEditable(true);
                tfSoLuongPhanCongPCCN.setDisable(false);
                tfSoLuongMoiNGuoiPCCN.setEditable(false);
                tfSoLuongMoiNGuoiPCCN.setDisable(true);
            }

            tfToPCCN.setText("");
            tfSoNguoiCanPhanCongPCCN.setText("");
            tfSoLuongMoiNGuoiPCCN.setText("");
            tfTongSoLuongPhanCongPCCN.setText("");
            tfSoLuongPhanCongConLai.setText("");


            BangPhanCongCongNhan bangPCCN = tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem();

            cbxHopDongPCCN.getSelectionModel().select(null);
            cbxHopDongPCCN.getSelectionModel().select(new HopDong(bangPCCN.getMaHopDong().getMaHD()));

            cbxSanPhanPCCN.getSelectionModel().select(null);
            cbxSanPhanPCCN.getSelectionModel().select(PhanCongCongNhanDao.getInstance().getSanPham(
                    cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD(),
                    bangPCCN.getMaCongDoan().getMaCD()));
            if (datepickNgayPhanCongPCCN.getValue().isBefore(LocalDate.now())){
                tfSoLuongCanLamPCCN.setText("");
            }

            cbxCongDoanPCCN.getSelectionModel().select(null);
            cbxCongDoanPCCN.getSelectionModel().select(bangPCCN.getMaCongDoan());
            if (datepickNgayPhanCongPCCN.getValue().isBefore(LocalDate.now())){
                tfSoLuongCanPhanCongPCCN.setText("");
            }

            ckcTangCa.setSelected(bangPCCN.isTangCa());

            tfMaCongNhanPCCN.setText(bangPCCN.getMaCongNhan().getMaCN());
            tfHoVaTenPCCN.setText(bangPCCN.getMaCongNhan().getHoCN()+" "+bangPCCN.getMaCongNhan().getTenCN());
            tfSoLuongPhanCongPCCN.setText(String.valueOf(bangPCCN.getChiTieu()));




        }
    }

    public void skChonRowtblViewTTSoNGuoiDaPC(MouseEvent mouseEvent) {

        if (!DSLoadSoLuongDaPhanCong.isEmpty() && !tblViewTTSoNguoiDaPC.getSelectionModel().isEmpty()){
            DSTTPhanCongCongNhan.removeAll(DSPhanCongCongNhanDaLuu);
            DSPhanCongCongNhanDaLuu.clear();

            cbxToPCCN.getSelectionModel().select(null);
            cbxToPCCN.getSelectionModel().select(tblViewTTSoNguoiDaPC.getSelectionModel().getSelectedItem().getTSX());

            DSPhanCongCongNhanDaLuu.addAll(PhanCongCongNhanDao.getInstance().getDSPhanCongDaLuuTheoTo(tblViewTTSoNguoiDaPC.getSelectionModel().getSelectedItem().getTSX().getMaTSX(),
                    Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

            if (!DSPhanCongCongNhanDaLuu.isEmpty()){
                ObservableList<BangPhanCongCongNhan> a = FXCollections.observableArrayList();
                a.addAll(DSPhanCongCongNhanDaLuu);
                for (int i = 0; i < a.size(); i++){
                    if (!a.isEmpty())
                        for (int j = 0 ; j<DSPhanCongCongNhanUpdate.size();j++){
                            if (DSPhanCongCongNhanUpdate.get(j).getMaCongNhan().getMaCN().equals(a.get(i).getMaCongNhan().getMaCN())){
                                DSTTPhanCongCongNhan.add(DSPhanCongCongNhanUpdate.get(j));
                                a.remove(a.get(i));

                            }
                        }
                }
                if (!a.isEmpty())
                    DSTTPhanCongCongNhan.addAll(a);
            }

        }

    }


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


        if (cbxCongDoanPCCN.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo","Chưa chọn công đoạn");
            return;
        }
        if (!StringUtils.isNumeric(tfSoLuongCanPhanCongPCCN.getText())){
            tfSoLuongPhanCongConLai.setText("Dư");
        }else {
            int soLuongCanPhanCongConLai = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText()) -
                    Integer.parseInt(tfTongSoLuongPhanCongPCCN.getText());
            if (soLuongCanPhanCongConLai >=0)
                tfSoLuongPhanCongConLai.setText(String.valueOf(soLuongCanPhanCongConLai));
            else {
                tfSoLuongPhanCongConLai.setText("Đã dư "+ -1 * soLuongCanPhanCongConLai);
            }
        }


    }


    //Sự kiện trên datepick
    public void skChondatePick(ActionEvent actionEvent) {
        if (datepickNgayPhanCongPCCN.getValue().isBefore(LocalDate.now())){
            DSThongTinCongNhan.clear();
            DSTTPhanCongCongNhan.clear();

            radPCTungCongNhanPCCN.setSelected(false);
            radPCTungCongNhanPCCN.setDisable(true);
            radPCTuDongPCCN.setSelected(false);
            radPCTuDongPCCN.setDisable(true);
            tfSoLuongMoiNGuoiPCCN.setDisable(true);
            tfSoLuongPhanCongPCCN.setDisable(true);

            btnPhanCongPCCN.setDisable(true);
            btnSuaPCCN.setDisable(true);

            cbxHopDongPCCN.setDisable(true);

            cbxSanPhanPCCN.getSelectionModel().select(null);
            tfSoLuongCanLamPCCN.setText("");
            cbxSanPhanPCCN.setDisable(true);

            cbxCongDoanPCCN.getSelectionModel().select(null);
            tfSoLuongCanPhanCongPCCN.setText("");
            cbxCongDoanPCCN.setDisable(true);

            cbxToPCCN.getSelectionModel().select(null);
            cbxToPCCN.setDisable(true);

            tfMaCongNhanPCCN.setText("");
            tfHoVaTenPCCN.setText("");
            tfSoLuongPhanCongPCCN.setText("");
            tfSoLuongChuaPhanCongPCCN.setText("");

            if (!cbxToPCCN.getSelectionModel().isEmpty()){
                int soNguoiCanPhanCong = PhanCongCongNhanDao.getInstance().getSoLuongNguoiCoTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX())
                        - PhanCongCongNhanDao.getInstance().getSoLuongNguoiDaPhanCongTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX(), Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY"));


                if (!cbxToPCCN.getSelectionModel().isEmpty()){
                    tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(soNguoiCanPhanCong));
                } else if (cbxToPCCN.getSelectionModel().isEmpty() ) {
                    tfSoLuongChuaPhanCongPCCN.setText("0");
                }
            }

            DSLoadSoLuongDaPhanCong.clear();
            DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo(Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

        }else if(datepickNgayPhanCongPCCN.getValue().isAfter(LocalDate.now())) {
            DSTTPhanCongCongNhan.clear();
            DSThongTinCongNhan.clear();

            radPCTungCongNhanPCCN.setDisable(false);
            radPCTuDongPCCN.setDisable(false);
            radPCTuDongPCCN.setSelected(false);
            radPCTungCongNhanPCCN.setSelected(true);
            tfSoLuongPhanCongPCCN.setDisable(false);
            tfSoLuongMoiNGuoiPCCN.setDisable(true);

            btnPhanCongPCCN.setDisable(false);
            btnSuaPCCN.setDisable(false);


            cbxHopDongPCCN.setDisable(false);

            cbxSanPhanPCCN.getSelectionModel().select(null);
            tfSoLuongCanLamPCCN.setText("");
            cbxSanPhanPCCN.setDisable(false);

            cbxCongDoanPCCN.getSelectionModel().select(null);
            tfSoLuongCanPhanCongPCCN.setText("");
            cbxCongDoanPCCN.setDisable(false);

            cbxToPCCN.getSelectionModel().select(null);
            cbxToPCCN.setDisable(false);

            tfMaCongNhanPCCN.setText("");
            tfHoVaTenPCCN.setText("");
            tfSoLuongPhanCongPCCN.setText("");
            tfSoLuongChuaPhanCongPCCN.setText("");

            if (!cbxToPCCN.getSelectionModel().isEmpty()){
                int soNguoiCanPhanCong = PhanCongCongNhanDao.getInstance().getSoLuongNguoiCoTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX())
                        - PhanCongCongNhanDao.getInstance().getSoLuongNguoiDaPhanCongTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX(), Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY"));


                if (!cbxToPCCN.getSelectionModel().isEmpty()){
                    tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(soNguoiCanPhanCong));
                } else if (cbxToPCCN.getSelectionModel().isEmpty() ) {
                    tfSoLuongChuaPhanCongPCCN.setText("0");
                }
            }

            DSLoadSoLuongDaPhanCong.clear();
            DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo(Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));
        } else{

            DSTTPhanCongCongNhan.clear();
            DSThongTinCongNhan.clear();

            DSTTPhanCongCongNhan.addAll(DSPhanCongCanSave);
            DSTTPhanCongCongNhan.addAll(DSPhanCongCongNhanUpdate);

            radPCTungCongNhanPCCN.setDisable(false);
            radPCTuDongPCCN.setDisable(false);
            radPCTungCongNhanPCCN.setSelected(true);
            tfSoLuongPhanCongPCCN.setDisable(false);

            btnPhanCongPCCN.setDisable(false);
            btnSuaPCCN.setDisable(false);


            cbxHopDongPCCN.setDisable(false);

            cbxSanPhanPCCN.getSelectionModel().select(null);
            tfSoLuongCanLamPCCN.setText("");
            cbxSanPhanPCCN.setDisable(false);

            cbxCongDoanPCCN.getSelectionModel().select(null);
            tfSoLuongCanPhanCongPCCN.setText("");
            cbxCongDoanPCCN.setDisable(false);

            cbxToPCCN.getSelectionModel().select(null);
            cbxToPCCN.setDisable(false);

            tfMaCongNhanPCCN.setText("");
            tfHoVaTenPCCN.setText("");
            tfSoLuongPhanCongPCCN.setText("");
            tfSoLuongChuaPhanCongPCCN.setText("");

            if (!cbxToPCCN.getSelectionModel().isEmpty()){
                int soNguoiCanPhanCong = PhanCongCongNhanDao.getInstance().getSoLuongNguoiCoTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX())
                        - PhanCongCongNhanDao.getInstance().getSoLuongNguoiDaPhanCongTrongTo(cbxToPCCN.getSelectionModel().getSelectedItem().getMaTSX(), Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY"));


                if (!cbxToPCCN.getSelectionModel().isEmpty()){
                    tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(soNguoiCanPhanCong));
                } else if (cbxToPCCN.getSelectionModel().isEmpty() ) {
                    tfSoLuongChuaPhanCongPCCN.setText("0");
                }
            }

            DSLoadSoLuongDaPhanCong.clear();
            DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo(Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

        }
    }


    //Sự kiện button
    public void skbtnPhanCongCN(ActionEvent actionEvent) {
        if (radPCTungCongNhanPCCN.isSelected() && !DSThongTinCongNhan.isEmpty() && !tblViewTTCongNhanPC.getSelectionModel().isEmpty()){
            if (kiemTraPCTungNguoi()){
                CongNhan maCN = new CongNhan( tfMaCongNhanPCCN.getText().trim(),
                        tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getHoCN(),
                        tblViewTTCongNhanPC.getSelectionModel().getSelectedItem().getCongNhan().getTenCN());
                String maBPCCN ="PC"+ Utils.taoMaBangChamCong(maCN.getMaCN(),Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY"));
                CongDoan maCD = new CongDoan(cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD());
                HopDong maHD = new HopDong(cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD().trim());
                int chiTieu = 0;
                if (!tfSoLuongPhanCongPCCN.getText().isEmpty()){
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
                        tfSoLuongCanPhanCongPCCN.setText("Đã dư " + -1 * soLuongCanPhanCongSauKhiPC);
                    }
                } catch (NumberFormatException e){
                    Alerts.showConfirmation("Thông báo", "Số lương phân công đã dư");
                    return;
                }

                boolean tangCa = ckcTangCa.isSelected();

                LocalDate localDate = datepickNgayPhanCongPCCN.getValue();
                Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date ngayPhanCong = Date.from(instant);

                LocalDate lc = datepickNgayPhanCongPCCN.getValue().plusDays(1);
                Instant in = Instant.from(lc.atStartOfDay(ZoneId.systemDefault()));
                Date ngayKetThuc = Date.from(in);

                BangPhanCongCongNhan pc = new BangPhanCongCongNhan(maBPCCN,maCN,maCD,maHD,chiTieu,tangCa,ngayPhanCong,ngayKetThuc);

                DSTTPhanCongCongNhan.add(pc);
                DSPhanCongCanSave.add(pc);
                DSTTPhanCongChuaLuuCoTo.add(new BangThongTinCongNhanCoTo(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem(),cbxToPCCN.getSelectionModel().getSelectedItem(),
                        Date.from(datepickNgayPhanCongPCCN.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())));
                DSThongTinCongNhan.remove(tblViewTTCongNhanPC.getSelectionModel().getSelectedItem());

                tblViewTTCongNhanPC.getSelectionModel().clearSelection();
                tfMaCongNhanPCCN.setText("");
                tfHoVaTenPCCN.setText("");
                tfSoLuongPhanCongPCCN.setText("");
                ckcTangCa.setSelected(false);
                tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(Integer.parseInt(tfSoLuongChuaPhanCongPCCN.getText())-1));

            }
        }

        if (radPCTuDongPCCN.isSelected() && !DSThongTinCongNhan.isEmpty()){
            if (kiemTraPCTuDong()){

                for(int i = 0 ; i< DSThongTinCongNhan.size(); i++){
                    CongNhan maCN = DSThongTinCongNhan.get(i).getCongNhan();
                    String maBPCCN = "PC"+ Utils.taoMaBangChamCong(maCN.getMaCN(),Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY"));
                    CongDoan maCD = new CongDoan(cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD());
                    HopDong maHD = new HopDong(cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD().trim());

                    int chiTieu = 0;
                    if (!tfSoLuongMoiNGuoiPCCN.getText().isEmpty()){
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
                            tfSoLuongCanPhanCongPCCN.setText("Đã dư " + -1 * soLuongCanPhanCongSauKhiPC);
                        }
                    } catch (NumberFormatException e){
                        Alerts.showConfirmation("Thông báo", "Số lương phân công đã dư");
                        return;
                    }

                    boolean tangCa = ckcTangCa.isSelected();

                    LocalDate localDate = datepickNgayPhanCongPCCN.getValue();
                    Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                    Date ngayPhanCong = Date.from(instant);

                    LocalDate lc = datepickNgayPhanCongPCCN.getValue().plusDays(1);
                    Instant in = Instant.from(lc.atStartOfDay(ZoneId.systemDefault()));
                    Date ngayKetThuc = Date.from(in);

                    BangPhanCongCongNhan pc = new BangPhanCongCongNhan(maBPCCN,maCN,maCD,maHD,chiTieu,tangCa,ngayPhanCong,ngayKetThuc);

                    DSTTPhanCongCongNhan.add(pc);
                    DSPhanCongCanSave.add(pc);
                    DSTTPhanCongChuaLuuCoTo.add(new BangThongTinCongNhanCoTo(DSThongTinCongNhan.get(i),cbxToPCCN.getSelectionModel().getSelectedItem(),
                            Date.from(datepickNgayPhanCongPCCN.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())));

                    tfSoLuongChuaPhanCongPCCN.setText(String.valueOf(Integer.parseInt(tfSoLuongChuaPhanCongPCCN.getText())-1));

                    if (DSThongTinCongNhan.contains(new BangThongTinCongNhan(pc.getMaCongNhan()))){
                        DSThongTinCongNhan.remove((new BangThongTinCongNhan(pc.getMaCongNhan())));
                    }
                    i--;

                }

                tfSoNguoiCanPhanCongPCCN.setText(tfSoLuongChuaPhanCongPCCN.getText());
                ckcTangCa.setSelected(false);
                tfSoLuongMoiNGuoiPCCN.setText("");
                tfTongSoLuongPhanCongPCCN.setText("");
                tfSoLuongPhanCongConLai.setText("");

            }
        }
    }

    public void skbtnLuu(ActionEvent actionEvent) throws InterruptedException {
        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo:","Bạn có muốn lưu không?");
        if (result.isPresent() && result.get() == ButtonType.OK){
            TimeUnit.MICROSECONDS.sleep(500);
            if (PhanCongCongNhanDao.getInstance().saveDSPhanCong(DSPhanCongCanSave) && PhanCongCongNhanDao.getInstance().saveDSUpdatePC(DSPhanCongCongNhanUpdate)){
                //Tao bang cham cong theo ngay
                ChamCongCongNhanDaoImpl.getInstance().taoBangChamCongCongNhanTheoNgay(DSPhanCongCanSave, String.valueOf(datepickNgayPhanCongPCCN.getValue()));

                //Thong bao
                Alerts.showConfirmation("Thông báo:","Lưu thành công!!@!");
                DSTTPhanCongCongNhan.clear();
                DSPhanCongCanSave.clear();
                DSPhanCongCongNhanUpdate.clear();

                DSLoadSoLuongDaPhanCong.clear();
                DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo(Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

            }else
                Alerts.showConfirmation("Thông báo:","Lưu thành công!!@!");
        }

    }

    public void skbtnReset(ActionEvent actionEvent) {
        Optional<ButtonType> result = Alerts.showConfirmation("Thông báo", "Sau khi reset sẽ mất hết dữ liệu chưa lưu");
        if (result.isPresent() && result.get() == ButtonType.OK){
            datepickNgayPhanCongPCCN.setValue(LocalDate.now());

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
            tfSoLuongPhanCongConLai.setText("");

            //reset DanhSach
            DSLoadSoLuongDaPhanCong.clear();
            DSLoadSoLuongDaPhanCong.addAll(PhanCongCongNhanDao.getInstance().getAllSoLuongDaPhanCongTheoTo(Utils.dinhDangNgayHienTai(datepickNgayPhanCongPCCN.getValue(),"ddMMYY")));

            for (BangPhanCongCongNhan bpc :DSPhanCongCanSave){
                DSTTPhanCongChuaLuuCoTo.removeIf(bpct -> bpc.getMaCongNhan().getMaCN().equals(bpct.getBangPCCN().getCongNhan().getMaCN()));
            }

            DSPhanCongCanSave.clear();
            DSPhanCongCongNhanUpdate.clear();
            DSTTPhanCongCongNhan.clear();

            DSThongTinCongNhan.clear();
        }



    }

    public void skbtnSuaPCCN(ActionEvent actionEvent) {
        if (tblViewTTPhanCongMoiCNPCCN.getSelectionModel().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa chọn người cần sửa");
            return;
        }

        if (!tblViewTTPhanCongMoiCNPCCN.getSelectionModel().isEmpty()){
            int chiTieuBanDau = tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem().getChiTieu();
            if (kiemTraPCTungNguoi()){
                for (BangPhanCongCongNhan pccn : DSPhanCongCanSave){
                    if (tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem().equals( pccn)){
                        String maBPCCN = tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem().getMaBPCCN();
                        CongNhan maCN = PhanCongCongNhanDao.getInstance().getCongNhanTheoMa(tfMaCongNhanPCCN.getText());
                        CongDoan maCD = new CongDoan(cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD());
                        HopDong maHD = new HopDong(cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD().trim());

                        int chiTieu = Integer.parseInt(tfSoLuongPhanCongPCCN.getText().trim());


                            if (!StringUtils.isNumeric(tfSoLuongCanPhanCongPCCN.getText())){
                                int soLuongCanPhanCong = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText().substring(tfSoLuongCanPhanCongPCCN.getText().lastIndexOf(" ")).trim()) *-1;
                                int a =0;
                                if (chiTieu == chiTieuBanDau)
                                    a = chiTieu * -1;
                                else if (chiTieu > chiTieuBanDau){
                                    a = (chiTieuBanDau -chiTieu ) *-1;
                                } else
                                    a = (chiTieu- chiTieuBanDau) *-1;

                                System.out.println(a+soLuongCanPhanCong);

                                if (a+soLuongCanPhanCong >=0){
                                    tfSoLuongCanPhanCongPCCN.setText(String.valueOf(a+soLuongCanPhanCong));
                                } else{
                                    tfSoLuongCanPhanCongPCCN.setText( "Đã dư " +String.valueOf(
                                            (soLuongCanPhanCong
                                                    + a) *-1
                                    ));
                                }
                            } else{
                                int a = 0;
                                int soLuongCanPhanCong = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText());
                                if (chiTieu == chiTieuBanDau)
                                    a = chiTieu * -1;
                                else if (chiTieu > chiTieuBanDau){
                                    a = (chiTieuBanDau -chiTieu) *-1;
                                } else
                                    a = (chiTieu- chiTieuBanDau) *-1;

                                if (a+soLuongCanPhanCong >0){
                                    tfSoLuongCanPhanCongPCCN.setText(String.valueOf(a+soLuongCanPhanCong));
                                } else{
                                    tfSoLuongCanPhanCongPCCN.setText( "Đã dư " +String.valueOf(
                                            (soLuongCanPhanCong
                                                    + a) *-1
                                    ));
                                }

                            }

                        boolean tangCa = ckcTangCa.isSelected();

                        LocalDate localDate = datepickNgayPhanCongPCCN.getValue();
                        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                        Date ngayPhanCong = Date.from(instant);

                        LocalDate lc = datepickNgayPhanCongPCCN.getValue().plusDays(1);
                        Instant in = Instant.from(lc.atStartOfDay(ZoneId.systemDefault()));
                        Date ngayKetThuc = Date.from(in);

                        BangPhanCongCongNhan pc = new BangPhanCongCongNhan(maBPCCN,maCN,maCD,maHD,chiTieu,tangCa,ngayPhanCong,ngayKetThuc);

                        DSTTPhanCongCongNhan.set(DSTTPhanCongCongNhan.indexOf(pc),pc );
                        DSPhanCongCanSave.set(DSPhanCongCanSave.indexOf(pc),pc );


                    }
                }

                for (BangPhanCongCongNhan bpccn : DSPhanCongCongNhanDaLuu){
                    if (tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem().equals(bpccn)){

                        String maBPCCN = tblViewTTPhanCongMoiCNPCCN.getSelectionModel().getSelectedItem().getMaBPCCN();
                        CongNhan maCN = PhanCongCongNhanDao.getInstance().getCongNhanTheoMa(tfMaCongNhanPCCN.getText());
                        CongDoan maCD = new CongDoan(cbxCongDoanPCCN.getSelectionModel().getSelectedItem().getMaCD());
                        HopDong maHD = new HopDong(cbxHopDongPCCN.getSelectionModel().getSelectedItem().getMaHD().trim());

                        int chiTieu = Integer.parseInt(tfSoLuongPhanCongPCCN.getText().trim());


                        if (!StringUtils.isNumeric(tfSoLuongCanPhanCongPCCN.getText())){
                            int soLuongCanPhanCong = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText().substring(tfSoLuongCanPhanCongPCCN.getText().lastIndexOf(" ")).trim()) *-1;
                            int a =0;
                            if (chiTieu == chiTieuBanDau)
                                a = chiTieu * -1;
                            else if (chiTieu > chiTieuBanDau){
                                a = (chiTieuBanDau -chiTieu ) *-1;
                            } else
                                a = (chiTieu- chiTieuBanDau) *-1;

                            System.out.println(a+soLuongCanPhanCong);

                            if (a+soLuongCanPhanCong >=0){
                                tfSoLuongCanPhanCongPCCN.setText(String.valueOf(a+soLuongCanPhanCong));
                            } else{
                                tfSoLuongCanPhanCongPCCN.setText( "Đã dư " +String.valueOf(
                                        (soLuongCanPhanCong
                                                + a) *-1
                                ));
                            }
                        } else{
                            int a = 0;
                            int soLuongCanPhanCong = Integer.parseInt(tfSoLuongCanPhanCongPCCN.getText());
                            if (chiTieu == chiTieuBanDau)
                                a = chiTieu * -1;
                            else if (chiTieu > chiTieuBanDau){
                                a = (chiTieuBanDau -chiTieu) *-1;
                            } else
                                a = (chiTieu- chiTieuBanDau) *-1;

                            if (a+soLuongCanPhanCong >0){
                                tfSoLuongCanPhanCongPCCN.setText(String.valueOf(a+soLuongCanPhanCong));
                            } else{
                                tfSoLuongCanPhanCongPCCN.setText( "Đã dư " +String.valueOf(
                                        (soLuongCanPhanCong
                                                + a) *-1
                                ));
                            }

                        }

                        boolean tangCa = ckcTangCa.isSelected();

                        LocalDate localDate = datepickNgayPhanCongPCCN.getValue();
                        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                        Date ngayPhanCong = Date.from(instant);

                        LocalDate lc = datepickNgayPhanCongPCCN.getValue().plusDays(1);
                        Instant in = Instant.from(lc.atStartOfDay(ZoneId.systemDefault()));
                        Date ngayKetThuc = Date.from(in);

                        BangPhanCongCongNhan pc = new BangPhanCongCongNhan(maBPCCN,maCN,maCD,maHD,chiTieu,tangCa,ngayPhanCong,ngayKetThuc);

                        DSTTPhanCongCongNhan.set(DSTTPhanCongCongNhan.indexOf(pc),pc );
                        DSPhanCongCongNhanUpdate.add(pc);
                    }
                }

            }
        }
        tblViewTTPhanCongMoiCNPCCN.getSelectionModel().clearSelection();
        tfMaCongNhanPCCN.setText("");
        tfHoVaTenPCCN.setText("");
        tfSoLuongPhanCongPCCN.setText("");
    }


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
             Alerts.showConfirmation("Thông báo", "Số lượng phân công phải là số và không được để trống");
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
