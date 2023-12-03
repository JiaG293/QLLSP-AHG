package com.openjfx.qllspahg.gui.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String VIETNAM_DATE_FORMAT = "dd/MM/yyyy";

    public static String formatStringVietnamLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(VIETNAM_DATE_FORMAT);
        return date.format(formatter);
    }

    public static LocalDate parseVietnamLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(VIETNAM_DATE_FORMAT);
        return LocalDate.parse(dateString, formatter);
    }

    public static Date parseVietnamDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(VIETNAM_DATE_FORMAT);
        return (Date) formatter.parse(dateString);
    }

    public static String formatStringVietnamDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(VIETNAM_DATE_FORMAT);
        return formatter.format(date);
    }

    public static String formatStringVietnamDateCustom(Date date, String stringFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(stringFormat);
        return formatter.format(date);
    }

    public static String chuyenDoiSangNgaySQL(String vietnameseDate, String inputPattern, String outputPattern) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputPattern);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern);

        LocalDate localDate = LocalDate.parse(vietnameseDate, inputFormatter);
        return localDate.format(outputFormatter);
    }

    public static boolean isFormatDateString(String inputDate, String inputPattern) { //true la dung dinh dang inputPartten nguoc lai la false
        DateFormat dateFormat = new SimpleDateFormat(inputPattern);
        dateFormat.setLenient(false); // kiem tra neu ngay thang khong hop le
        try {
            dateFormat.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
