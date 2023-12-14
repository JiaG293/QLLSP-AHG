package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.dao.ChamCongNhanVienDaoImpl;
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
import java.util.*;

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

    public static String formatCurrency(Double price) {
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
    public static String taoMaBangChamCong(String maNhanSu, String ngayChamCong) {
        return maNhanSu + ngayChamCong;
    }


    public static CheckBox taoCheckBox(boolean selected) {
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(selected);
        return checkBox;
    }

    public static String taoNgayHienTai() {
        LocalDate ngayHienTai = LocalDate.now();
//        String maNgayHienTai = String.format(ngayHienTai.getYear() + "-" + ngayHienTai.getMonthValue() + "-" + ngayHienTai.getDayOfMonth());
        return dinhDangNgayHienTai(ngayHienTai, "yyyy-MM-dd");
    }

    public static String taoNgayHomTruoc() {
        LocalDate ngayHienTai = LocalDate.now();
        LocalDate ngayHomTruoc = ngayHienTai.minusDays(1);
//        String maNgayHienTai = String.format(ngayHienTai.getYear() + "-" + ngayHienTai.getMonthValue() + "-" + ngayHienTai.getDayOfMonth());
        return dinhDangNgayHienTai(ngayHomTruoc, "yyyy-MM-dd");
    }


    public static String dinhDangNgayHienTai(LocalDate date, String pattern){
        DateTimeFormatter patternFormat = DateTimeFormatter.ofPattern(pattern);
        return patternFormat.format(date);
    }

    public static List<String> taoDanhSachNgayTrongThang(int year, int month) {
        List<String> daysInMonth = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // Tháng trong Calendar bắt đầu từ 0
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int day = 1; day <= lastDay; day++) {
            calendar.set(year, month - 1, day); // Đặt ngày trong tháng
            Date date = calendar.getTime();
            daysInMonth.add(dateFormat.format(date));
        }

        return daysInMonth;
}

    public static List<String> taoDanhSachNgayTrongThangHienTai(String pattern) {
        List<String> currentDates = new ArrayList<>();

        // Lấy ngày đầu tiên của tháng hiện tại
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);
        int numberOfDaysInMonth = firstDayOfMonth.lengthOfMonth();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

        for (int i = 0; i < numberOfDaysInMonth; i++) {
            LocalDate currentDate = firstDayOfMonth.plusDays(i);
            currentDates.add(dateFormatter.format(currentDate));
        }

        return currentDates;
    }

    public static List<String> taoDanhSachNgayTrongThangTiepTheo(String pattern) {
        List<String> nextMonthDates = new ArrayList<>();

        // Lấy ngày đầu tiên của tháng tiếp theo
        LocalDate firstDayOfNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        int numberOfDaysInNextMonth = firstDayOfNextMonth.lengthOfMonth();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

        for (int i = 0; i < numberOfDaysInNextMonth; i++) {
            LocalDate currentDate = firstDayOfNextMonth.plusDays(i);
            nextMonthDates.add(dateFormatter.format(currentDate));
        }

        return nextMonthDates;
    }

    public static List<String> taoDanhSachNgayTrongThangTruoc(String pattern) {
        List<String> nextMonthDates = new ArrayList<>();

        // Lấy ngày đầu tiên của tháng tiếp theo
        LocalDate firstDayOfNextMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        int numberOfDaysInNextMonth = firstDayOfNextMonth.lengthOfMonth();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

        for (int i = 0; i < numberOfDaysInNextMonth; i++) {
            LocalDate currentDate = firstDayOfNextMonth.plusDays(i);
            nextMonthDates.add(dateFormatter.format(currentDate));
        }

        return nextMonthDates;
    }












}