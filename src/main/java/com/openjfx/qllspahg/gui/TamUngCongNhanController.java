package com.openjfx.qllspahg.gui;

import static com.openjfx.qllspahg.dao.interfaces.DSTamUngCongNhan.*;


import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.TamUngCongNhanDao;

import com.openjfx.qllspahg.entity.*;
import com.openjfx.qllspahg.entity.model.tamUngCongNhan.BangTamUngCongNhanKemSoNgay;
import com.openjfx.qllspahg.gui.util.Alerts;
import com.openjfx.qllspahg.gui.util.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class TamUngCongNhanController implements Initializable {

    @FXML
    private Button btnHuyXem;

    @FXML
    private Button btnLayThongTin;

    @FXML
    private Button btnUngLuong;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colGhiChu;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colMaNhanVien;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colNgayTamUng;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colPhpngBan;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colSoNgayDaDiLam;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colSoTienTazmUng;

    @FXML
    private TableColumn<BangTamUngCongNhanKemSoNgay, String> colTenNhanVien;

    @FXML
    private Label lblThongBan;

    @FXML
    private Label lblThongBaoThanHCong;

    @FXML
    private Label lblTieuDeNgayTamUng;

    @FXML
    private TableView<BangTamUngCongNhanKemSoNgay> tblviewTamUngNhanVien;

    @FXML
    private TextField tfGhiChu;

    @FXML
    private TextField tfMaNhanVien;

    @FXML
    private TextField tfMaTamUng;

    @FXML
    private TextField tfNgayTamUng;

    @FXML
    private TextField tfPhongBan;

    @FXML
    private TextField tfSoNgayDiLam;

    @FXML
    private TextField tfSoTienTamUng;

    @FXML
    private TextField tfTenNhanVien;

    private int soTienTamUngCuaCN = 2500000;
    private String maCongNhanTam = "";
    private ToSanXuat toSanXuat = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTieuDeNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));
        tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));

        docDuLieuVaoTableView();
    }

    /**
     * Chuẩn bị
     */


    private void docDuLieuVaoTableView(){
        DSTamUng.clear();
        DSTamUng.addAll(TamUngCongNhanDao.getInstance().layTatCaThongTinTamUng());

        colGhiChu.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getLyDo());
            }
        });

        colMaNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getMaCN().getMaCN() );
            }
        });

       colNgayTamUng.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
               return new SimpleStringProperty((new SimpleDateFormat("dd/MM/yyyy").format(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getNgayTamUng())));
           }
       });

        colPhpngBan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getMaCN().getToSanXuat().getTenTSX());
            }
        });

       colSoNgayDaDiLam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
               return new SimpleStringProperty(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getSoNgaydiLam()+"");
           }
       });

        colSoTienTazmUng.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getSoTienTamUng()+ " VND");
            }
        });

        colTenNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngCongNhanKemSoNgay, String> bangTamUngCongNhanKemSoNgayStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getMaCN().getHoCN() + " " +
                        bangTamUngCongNhanKemSoNgayStringCellDataFeatures.getValue().getTamUng().getMaCN().getTenCN());
            }
        });

        tblviewTamUngNhanVien.setItems(DSTamUng);
    }


    /**
     * Sự kiện
     *
     */


    //Sự kiện trên table
    @FXML
    void skChonRowtblviewTamUngNhanVien(MouseEvent event) {
        if (!DSTamUng.isEmpty() && !tblviewTamUngNhanVien.getSelectionModel().isEmpty()) {
            btnUngLuong.setDisable(true);
            btnHuyXem.setDisable(false);
            tfMaNhanVien.setDisable(true);
            tfSoTienTamUng.setDisable(true);
            tfGhiChu.setDisable(true);

            BangTamUngCongNhanKemSoNgay btu = tblviewTamUngNhanVien.getSelectionModel().getSelectedItem();

            tfMaTamUng.setText(btu.getTamUng().getMaTUCN());
            tfMaNhanVien.setText(btu.getTamUng().getMaCN().getMaCN());
            tfTenNhanVien.setText(btu.getTamUng().getMaCN().getHoCN() + " " +
                    btu.getTamUng().getMaCN().getTenCN());

            tfPhongBan.setText(btu.getTamUng().getMaCN().getToSanXuat().getTenTSX());
            tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").format(btu.getTamUng().getNgayTamUng()));
            tfSoNgayDiLam.setText(String.valueOf(btu.getSoNgaydiLam()));

            tfSoTienTamUng.setText(String.valueOf(btu.getTamUng().getSoTienTamUng()));
        }
    }


    //Sự kiện trên Button
    @FXML
    void skbtnHuyXem(ActionEvent event) {
        tblviewTamUngNhanVien.getSelectionModel().clearSelection();

        tfMaTamUng.setText("");
        tfMaNhanVien.setText("");
        lblThongBan.setText("");
        tfTenNhanVien.setText("");
        tfPhongBan.setText("");
        tfSoNgayDiLam.setText("");
        tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));
        tfSoTienTamUng.setText("");
        tfGhiChu.setText("");

        tfMaNhanVien.setDisable(false);
        tfSoTienTamUng.setEditable(true);
        tfSoTienTamUng.setDisable(false);
        tfGhiChu.setEditable(true);
        tfGhiChu.setDisable(false);

        btnHuyXem.setDisable(true);
        btnUngLuong.setDisable(false);

    }

    @FXML
    void skbtnLayThongTin(ActionEvent event) {

        maCongNhanTam = "";
        toSanXuat = new ToSanXuat();
        if (tfMaNhanVien.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa nhập mã nhân viên");
            return;
        }
        if (!kiemTra(tfMaNhanVien.getText().trim())){
            return;
        }
        if (!tfMaNhanVien.getText().trim().isEmpty()){
            //Trường hợp Đã tạm ứng
            for (BangTamUngCongNhanKemSoNgay btuksn : DSTamUng){

                if (btuksn.getTamUng().getMaCN().getMaCN().equals(tfMaNhanVien.getText().trim())){

                    lblThongBan.setText("Nhân viên "+ btuksn.getTamUng().getMaCN().getHoCN()+ " "+btuksn.getTamUng().getMaCN().getTenCN() +
                            " với mã số: "+ btuksn.getTamUng().getMaCN().getMaCN()+ " \nđã ứng lương.");

                    tblviewTamUngNhanVien.getSelectionModel().select(btuksn);
                    btnUngLuong.setDisable(true);
                    btnHuyXem.setDisable(false);
                    tfSoTienTamUng.setEditable(false);
                    tfSoTienTamUng.setDisable(true);
                    tfGhiChu.setEditable(false);
                    tfSoTienTamUng.setDisable(true);
                    tfGhiChu.setEditable(false);
                    tfGhiChu.setDisable(true);

                    tfMaTamUng.setText(btuksn.getTamUng().getMaTUCN());
                    tfTenNhanVien.setText(btuksn.getTamUng().getMaCN().getHoCN()+ " "+ btuksn.getTamUng().getMaCN().getTenCN());
                    tfPhongBan.setText(btuksn.getTamUng().getMaCN().getToSanXuat().getTenTSX());
                    tfSoNgayDiLam.setText(String.valueOf(btuksn.getSoNgaydiLam()));
                    tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").format(btuksn.getTamUng().getNgayTamUng()));
                    tfSoTienTamUng.setText(btuksn.getTamUng().getSoTienTamUng()+" " +"VND");
                    tfGhiChu.setText(btuksn.getTamUng().getLyDo());

                    return;
                }

            }
            //Trường hợp chưa tạm ứng
            BangTamUngCongNhanKemSoNgay bangTamUngCongNhanKemSoNgay =
                    TamUngCongNhanDao.getInstance().layThongTinUngLuongTheoMaCN(tfMaNhanVien.getText().trim());

            if (bangTamUngCongNhanKemSoNgay == null){
                return;
            }
            int soNgayDiLam = bangTamUngCongNhanKemSoNgay.getSoNgaydiLam();
            if (soNgayDiLam < 10){
                Alerts.showConfirmation("Thông báo","Số ngày đi làm của công nhân phải lớn hơn 10 để tạm ứng"+ ".\nCông nhân với mã: " +
                        tfMaNhanVien.getText().trim()+ " có số ngày đi làm là: " +soNgayDiLam );
                return;
            }

            //Biến toàn cục để cho việc xử lý
            maCongNhanTam = tfMaNhanVien.getText().trim();

            toSanXuat.setMaTSX(bangTamUngCongNhanKemSoNgay.getTamUng().getMaCN().getToSanXuat().getMaTSX());
            toSanXuat.setTenTSX(bangTamUngCongNhanKemSoNgay.getTamUng().getMaCN().getToSanXuat().getTenTSX());

            btnUngLuong.setDisable(false);
            btnHuyXem.setDisable(true);
            tfSoTienTamUng.setEditable(true);
            tfSoTienTamUng.setDisable(false);
            tfGhiChu.setEditable(true);
            tfSoTienTamUng.setDisable(false);
            tfGhiChu.setEditable(true);
            tfGhiChu.setDisable(false);

            tfMaTamUng.setText(Utils.taoMaBangChamCong(bangTamUngCongNhanKemSoNgay.getTamUng().getMaCN().getMaCN(),
                    Utils.dinhDangNgayHienTai(LocalDate.now(),"ddMMYY")));

            tfTenNhanVien.setText(bangTamUngCongNhanKemSoNgay.getTamUng().getMaCN().getHoCN()+" "+
                    bangTamUngCongNhanKemSoNgay.getTamUng().getMaCN().getTenCN());

            tfPhongBan.setText(toSanXuat.getTenTSX());
            tfSoNgayDiLam.setText(String.valueOf(soNgayDiLam));

            //Số tiền mọi công nhân có thẻ ứng tối đa là 2tr500k
            tfSoTienTamUng.setText(String.valueOf(soTienTamUngCuaCN));
        }

    }

    @FXML
    void skbtnUngLuong(ActionEvent event) {
        if (tfMaNhanVien.getText().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa nhập mã công nhân\n"+
                    "Bạn hãy nhập mã công nhân và ấn nút lấy thông tin");
            tfMaNhanVien.requestFocus();
            return;
        }

        if(!tfMaNhanVien.getText().trim().equals(maCongNhanTam)){
            Alerts.showConfirmation("Thông báo","Không thể thay đổi giá trị mã công nhân trong lúc ứng lương\n"+
                    "Nếu bạn muốn hãy nhập mã công nhân và bấm lấy thông tin lại!!");
            tfMaNhanVien.setText(maCongNhanTam);
            return;
        }
        if (!StringUtils.isNumeric(tfSoTienTamUng.getText().trim())){
            Alerts.showConfirmation("Thông báo", "Tiền tạm ứng phải là số và không được để trống");
            return;
        }
        if (Double.parseDouble(tfSoTienTamUng.getText().trim())<0){
            Alerts.showConfirmation("Thông báo", "Tiền tạm ứng phải lớn hơn 0");
            return;
        }
        if (Double.parseDouble(tfSoTienTamUng.getText().trim()) > soTienTamUngCuaCN){
            Alerts.showConfirmation("Thông báo"," Số tiền tạm ứng không được quá: " +soTienTamUngCuaCN +" VND" );
            return;
        }

        String maTamUng = tfMaTamUng.getText().trim();

        String maCongNhan = tfMaNhanVien.getText().trim();
        String hoCongNhan = tfTenNhanVien.getText().trim().substring(0,tfTenNhanVien.getText().trim().lastIndexOf(" "));
        String tenCongNhan = tfTenNhanVien.getText().trim().substring(tfTenNhanVien.getText().trim().lastIndexOf(" "));
        CongNhan cn = new CongNhan(maCongNhan,hoCongNhan,tenCongNhan,toSanXuat);

        java.util.Date ngayTamUng = null;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
            ngayTamUng = df.parse(tfNgayTamUng.getText().trim());
        }catch (ParseException e){
            e.printStackTrace();
        }

        java.sql.Date ngayTamUngSQL = new java.sql.Date(ngayTamUng.getTime());
        String lyDo = tfGhiChu.getText().trim();
        double soTienTamUng = Double.parseDouble(tfSoTienTamUng.getText().trim());

        TamUngCongNhan tUCN = new TamUngCongNhan(maTamUng,cn,ngayTamUngSQL,lyDo,soTienTamUng);
        int soNgayDiLam = Integer.parseInt(tfSoNgayDiLam.getText());
        BangTamUngCongNhanKemSoNgay bTUKemsoNgayCN = new BangTamUngCongNhanKemSoNgay(tUCN,soNgayDiLam);

        DSTamUng.add(bTUKemsoNgayCN);

        if (TamUngCongNhanDao.getInstance().luuThongTinTamUng(tUCN)){
            Alerts.showConfirmation("Thông báo","Ứng lương thành công");


        } else{
            Alerts.showConfirmation("Thông báo","Ứng lương không thành công");
        }

        maCongNhanTam= "";
        toSanXuat = new ToSanXuat();

        tfTenNhanVien.setText("");
        tfMaNhanVien.setText("");
        tfMaTamUng.setText("");
        tfNgayTamUng.setText("");
        tfPhongBan.setText("");
        tfSoNgayDiLam.setText("");
        tfSoTienTamUng.setText("");
        tfGhiChu.setText("");


    }


    /**
     * Phương thức
     */
    private boolean kiemTra(String ma){
        if (!ma.matches("(CN)[0-9]{6}")){
            Alerts.showConfirmation("Thông báo","Mã công nhân không đúng định dạng: NV + 6 chữ số");
            tfMaNhanVien.requestFocus();
            return false;
        }
        return true;
    }



}
