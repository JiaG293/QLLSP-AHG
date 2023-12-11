package com.openjfx.qllspahg.gui;

import static com.openjfx.qllspahg.dao.interfaces.DSTamUngNhanVien.*;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.openjfx.qllspahg.dao.TamUngNhanVienDao;
import com.openjfx.qllspahg.entity.NhanVien;
import com.openjfx.qllspahg.entity.PhongBan;
import com.openjfx.qllspahg.entity.TamUngNhanVien;
import com.openjfx.qllspahg.entity.model.TamUngNhanVien.BangTamUngNhanVienKemSoNgayDiLam;
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
import javafx.scene.paint.Color;
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

public class TamUngNhanVienController implements Initializable {

    @FXML
    private Button btnHuyXem;

    @FXML
    private Button btnLayThongTin;

    @FXML
    private Button btnUngLuong;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colGhiChu;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colMaNhanVien;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colNgayTamUng;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colPhpngBan;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colSoNgayDaDiLam;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colSoTienTazmUng;

    @FXML
    private TableColumn<BangTamUngNhanVienKemSoNgayDiLam, String> colTenNhanVien;

    @FXML
    private Label lblTieuDeNgayTamUng;

    @FXML
    private Label lblThongBan;

    @FXML
    private TableView<BangTamUngNhanVienKemSoNgayDiLam> tblviewTamUngNhanVien;

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

    @FXML
    private TextField tfLuongCoBan;

    @FXML
    private TextField tfGhiChu;

    @FXML
    private Label lblThongBaoThanHCong;

    private String maNhanVienTam = "";
    private double soTienTamUngCuaNV = 0;

    private PhongBan phongBan = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTieuDeNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));
        tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));

        docDuLieuVaotblviewTamUngNhanVien();

    }

    /**
     * Định dạng bảng
     */

    private void docDuLieuVaotblviewTamUngNhanVien(){
        DSTamUng.clear();
        DSTamUng.addAll(TamUngNhanVienDao.getInstance().layTatCaThongTinTamUng());
        colMaNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getMaNV().getMaNV());
            }
        });

        colTenNhanVien.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getMaNV().getHoNV() + " " +
                        bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getMaNV().getTenNV());
            }
        });

        colPhpngBan.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getMaNV().getPhongBan().getTenPB());
            }
        });

        colSoNgayDaDiLam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getSoNgayDiLam()));
            }
        });

        colNgayTamUng.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(new SimpleDateFormat("dd/MM/yyyy").format(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getNgayTamUng()));
            }
        });

        colSoTienTazmUng.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getSoTienTamUng()) + " " + "VND");
            }
        });

        colGhiChu.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BangTamUngNhanVienKemSoNgayDiLam, String> bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures) {
                return new SimpleStringProperty(bangTamUngNhanVienKemSoNgayDiLamStringCellDataFeatures.getValue().getTamUng().getLyDo());
            }
        });

        tblviewTamUngNhanVien.setItems(DSTamUng);

    }



    /**
     *
     * Sự kiện
     */


    // Sự kiện trên button

    public void skbtnLayThongTin(ActionEvent actionEvent) {
        soTienTamUngCuaNV = 0;
        maNhanVienTam = "";
        phongBan = new PhongBan();
        if (tfMaNhanVien.getText().trim().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa nhập mã nhân viên");
            return;
        }
        if (!kiemTra(tfMaNhanVien.getText().trim())){
            return;
        }
        if (!tfMaNhanVien.getText().trim().isEmpty()){
            //Trường hợp Đã tạm ứng
            for (BangTamUngNhanVienKemSoNgayDiLam btuksn : DSTamUng){

                if (btuksn.getTamUng().getMaNV().getMaNV().equals(tfMaNhanVien.getText().trim())){

                    lblThongBan.setText("Nhân viên "+ btuksn.getTamUng().getMaNV().getHoNV()+ " "+btuksn.getTamUng().getMaNV().getTenNV() +
                            " với mã số: "+ btuksn.getTamUng().getMaNV().getMaNV()+ " \nđã ứng lương.");

                    tblviewTamUngNhanVien.getSelectionModel().select(btuksn);
                    btnUngLuong.setDisable(true);
                    btnHuyXem.setDisable(false);
                    tfSoTienTamUng.setEditable(false);
                    tfSoTienTamUng.setDisable(true);
                    tfGhiChu.setEditable(false);
                    tfSoTienTamUng.setDisable(true);
                    tfGhiChu.setEditable(false);
                    tfGhiChu.setDisable(true);

                    tfMaTamUng.setText(btuksn.getTamUng().getMaTUNV());
                    tfTenNhanVien.setText(btuksn.getTamUng().getMaNV().getHoNV()+ " "+ btuksn.getTamUng().getMaNV().getTenNV());
                    tfPhongBan.setText(btuksn.getTamUng().getMaNV().getPhongBan().getTenPB());
                    tfSoNgayDiLam.setText(String.valueOf(btuksn.getSoNgayDiLam()));
                    tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").format(btuksn.getTamUng().getNgayTamUng()));
                    tfLuongCoBan.setText(btuksn.getTamUng().getMaNV().getLuongCoBan()+"");
                    tfSoTienTamUng.setText(btuksn.getTamUng().getSoTienTamUng()+" " +"VND");
                    tfGhiChu.setText(btuksn.getTamUng().getLyDo());

                    return;
                }

            }
            //Trường hợp chưa tạm ứng
            BangTamUngNhanVienKemSoNgayDiLam bangTamUngNhanVienKemSoNgayDiLam =
                    TamUngNhanVienDao.getInstance().layThongTinUngLuongTheoMaNV(tfMaNhanVien.getText().trim());

            if (bangTamUngNhanVienKemSoNgayDiLam == null){
                return;
            }
            int soNgayDiLam = bangTamUngNhanVienKemSoNgayDiLam.getSoNgayDiLam();
            if (soNgayDiLam < 10){
                Alerts.showConfirmation("Thông báo","Số ngày đi làm của nhân viên phải lớn hơn 10 để tạm ứng"+ ".\nNhân viên với mã: " +
                        tfMaNhanVien.getText().trim()+ " có số ngày đi làm là: " +soNgayDiLam );
                return;
            }

            //Biến toàn cục để cho việc xử lý
            maNhanVienTam = tfMaNhanVien.getText().trim();

            phongBan.setMaPB(bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getPhongBan().getMaPB());
            phongBan.setTenPB(bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getPhongBan().getTenPB());

            btnUngLuong.setDisable(false);
            btnHuyXem.setDisable(true);
            tfSoTienTamUng.setEditable(true);
            tfSoTienTamUng.setDisable(false);
            tfGhiChu.setEditable(true);
            tfSoTienTamUng.setDisable(false);
            tfGhiChu.setEditable(true);
            tfGhiChu.setDisable(false);

            tfMaTamUng.setText(Utils.taoMaBangChamCong(bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getMaNV(),
                    Utils.dinhDangNgayHienTai(LocalDate.now(),"ddMMYY")));

            tfTenNhanVien.setText(bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getHoNV()+" "+
                    bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getTenNV());

            tfPhongBan.setText(phongBan.getTenPB());
            tfSoNgayDiLam.setText(String.valueOf(soNgayDiLam));

            tfLuongCoBan.setText(String.valueOf(bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getLuongCoBan()+" VND"));
            soTienTamUngCuaNV = Math.ceil(bangTamUngNhanVienKemSoNgayDiLam.getTamUng().getMaNV().getLuongCoBan() * 0.45);
            tfSoTienTamUng.setText(String.valueOf(soTienTamUngCuaNV));
        }
    }

    public void skbtnHuyXem(ActionEvent actionEvent) {
        tblviewTamUngNhanVien.getSelectionModel().clearSelection();

        tfMaTamUng.setText("");
        tfMaNhanVien.setText("");
        lblThongBan.setText("");
        tfTenNhanVien.setText("");
        tfPhongBan.setText("");
        tfSoNgayDiLam.setText("");
        tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").
                format(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())))));
        tfLuongCoBan.setText("");
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

    public void skbtnUngLuong(ActionEvent actionEvent)  {
        if (tfMaNhanVien.getText().isEmpty()){
            Alerts.showConfirmation("Thông báo", "Chưa nhập mã nhân viên\n"+
                    "Bạn hãy nhập mã nhân viên và ấn nút lấy thông tin");
            tfMaNhanVien.requestFocus();
            return;
        }

        if(!tfMaNhanVien.getText().trim().equals(maNhanVienTam)){
            Alerts.showConfirmation("Thông báo","Không thể thay đổi giá trị mã nhân viên trong lúc ứng lương\n"+
                    "Nếu bạn muốn hãy nhập mã nhân viên và bấm lấy thông tin lại!!");
            tfMaNhanVien.setText(maNhanVienTam);
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
        if (Double.parseDouble(tfSoTienTamUng.getText().trim()) > soTienTamUngCuaNV){
            Alerts.showConfirmation("Thông báo"," Số tiền tam5 ứng không được quá 45% tiền lương cơ bản: " +soTienTamUngCuaNV );
            return;
        }

        String maTamUng = tfMaTamUng.getText().trim();

        String maNhanVien = tfMaNhanVien.getText().trim();
        String hoNhanVien = tfTenNhanVien.getText().trim().substring(0,tfTenNhanVien.getText().trim().lastIndexOf(" "));
        String tenNhanVien = tfTenNhanVien.getText().trim().substring(tfTenNhanVien.getText().trim().lastIndexOf(" "));
        double luongCoBan = Double.parseDouble(tfLuongCoBan.getText().trim().substring(0,tfLuongCoBan.getText().trim().lastIndexOf(" ")));
        NhanVien nv = new NhanVien(maNhanVien,hoNhanVien,tenNhanVien,phongBan,luongCoBan);

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

        TamUngNhanVien tUNV = new TamUngNhanVien(maTamUng,nv,ngayTamUngSQL,lyDo,soTienTamUng);
        int soNgayDiLam = Integer.parseInt(tfSoNgayDiLam.getText());
        BangTamUngNhanVienKemSoNgayDiLam bTUKemsoNgayNV = new BangTamUngNhanVienKemSoNgayDiLam(tUNV,soNgayDiLam);

        DSTamUng.add(bTUKemsoNgayNV);

        if (TamUngNhanVienDao.getInstance().luuThongTinTamUng(tUNV)){
           Alerts.showConfirmation("Thông báo","Ứng lương thành công");


        } else{
            Alerts.showConfirmation("Thông báo","Ứng lương không thành công");
        }

        maNhanVienTam= "";
        soTienTamUngCuaNV = 0;
        phongBan = new PhongBan();

        tfTenNhanVien.setText("");
        tfMaNhanVien.setText("");
        tfMaTamUng.setText("");
        tfNgayTamUng.setText("");
        tfPhongBan.setText("");
        tfSoNgayDiLam.setText("");
        tfSoTienTamUng.setText("");
        tfLuongCoBan.setText("");
        tfGhiChu.setText("");

    }


    //Sự kiện trên table

    public void skChonRowtblviewTamUngNhanVien(MouseEvent mouseEvent) {
        if (!DSTamUng.isEmpty() && !tblviewTamUngNhanVien.getSelectionModel().isEmpty()){
            btnUngLuong.setDisable(true);
            btnHuyXem.setDisable(false);
            tfMaNhanVien.setDisable(true);
            tfSoTienTamUng.setDisable(true);
            tfGhiChu.setDisable(true);

            BangTamUngNhanVienKemSoNgayDiLam btu = tblviewTamUngNhanVien.getSelectionModel().getSelectedItem();

            tfMaTamUng.setText(btu.getTamUng().getMaTUNV());
            tfMaNhanVien.setText(btu.getTamUng().getMaNV().getMaNV());
            tfTenNhanVien.setText(btu.getTamUng().getMaNV().getHoNV()+" "+
                    btu.getTamUng().getMaNV().getTenNV());

            tfPhongBan.setText(btu.getTamUng().getMaNV().getPhongBan().getTenPB());
            tfNgayTamUng.setText(new SimpleDateFormat("dd/MM/yyyy").format(btu.getTamUng().getNgayTamUng()));
            tfSoNgayDiLam.setText(String.valueOf(btu.getSoNgayDiLam()));

            tfLuongCoBan.setText(String.valueOf(btu.getTamUng().getMaNV().getLuongCoBan()+" VND"));
            tfSoTienTamUng.setText(String.valueOf(btu.getTamUng().getSoTienTamUng()));
        }
    }


    /**
     * Phương thức
     */
    private boolean kiemTra(String ma){
        if (!ma.matches("(NV)[0-9]{6}")){
            Alerts.showConfirmation("Thông báo","Mã nhân viên không đúng định dạng: NV + 6 chữ số");
            tfMaNhanVien.requestFocus();
            return false;
        }
        return true;
    }



}



