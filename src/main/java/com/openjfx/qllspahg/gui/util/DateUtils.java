package com.openjfx.qllspahg.gui.util;

import java.sql.Date;
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
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(vietnameseDate, inputFormatter);
        return localDate.format(outputFormatter);
    }
}
