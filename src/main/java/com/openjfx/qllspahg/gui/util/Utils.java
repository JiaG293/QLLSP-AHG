package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.entity.NhanVien;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static Stage currentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static Integer tryParseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double tryParseToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static <T> void formatTableColumnDate(TableColumn<T, Date> tableColumn, String format) {
        tableColumn.setCellFactory(column -> {
            TableCell<T, Date> cell = new TableCell<T, Date>() {
                private SimpleDateFormat sdf = new SimpleDateFormat(format);

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(sdf.format(item));
                    }
                }
            };
            return cell;
        });
    }

    public static <T> void formatTableColumnDouble(TableColumn<T, Double> tableColumn, int decimalPlaces) {
        tableColumn.setCellFactory(column -> {
            TableCell<T, Double> cell = new TableCell<T, Double>() {
                @Override
                protected void updateItem(Double item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        Locale.setDefault(Locale.US);
                        setText(String.format("%." + decimalPlaces + "f", item));
                    }
                }
            };
            return cell;
        });
    }

    public static void formatDatePicker(DatePicker datePicker, String format) {
        datePicker.setConverter(new StringConverter<LocalDate>() {

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);

            {
                datePicker.setPromptText(format.toLowerCase());
            }

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }

    public static String FormatCurrency(Double price) {
        String cf = null;
        try {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            cf = currencyFormat.format(price);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return cf;
    }

    //Tạo ma bang cham cong gom 8 số đầu là mã nhân sự 6 số sau là ngày tháng năm hiện tại yy-MM-dd
    public static String TaoMaBangChamCong(String maNhanSu) {
        LocalDate ngayHienTai = LocalDate.now();

        return maNhanSu + DinhDangNgayHienTai(ngayHienTai, "yyMMdd");
    }


    public static CheckBox TaoCheckBox(boolean selected) {
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(selected);
        return checkBox;
    }

    public static String TaoNgayHienTai() {
        LocalDate ngayHienTai = LocalDate.now();
//        String maNgayHienTai = String.format(ngayHienTai.getYear() + "-" + ngayHienTai.getMonthValue() + "-" + ngayHienTai.getDayOfMonth());
        return DinhDangNgayHienTai(ngayHienTai, "yyyy-MM-dd");
    }

    public static String DinhDangNgayHienTai(LocalDate date, String pattern){
        DateTimeFormatter patternFormat = DateTimeFormatter.ofPattern(pattern);
        return patternFormat.format(date);
    }








}