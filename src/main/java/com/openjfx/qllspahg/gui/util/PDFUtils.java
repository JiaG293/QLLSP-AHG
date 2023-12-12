package com.openjfx.qllspahg.gui.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.openjfx.qllspahg.entity.BangLuongCongNhan;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFUtils {

    public static boolean kiemTraTepTrung(String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }
    public static void taoPhieuLuongCongNhan(String filePath, ObservableList<BangLuongCongNhan> listBLCN) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font titleFont = new Font(BaseFont.createFont("src/main/resources/com/openjfx/qllspahg/fonts/vuArialBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 24);
            Font titleNormalFont = new Font(BaseFont.createFont("src/main/resources/com/openjfx/qllspahg/fonts/vuArialBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 18);
            Font contentFont = new Font(BaseFont.createFont("src/main/resources/com/openjfx/qllspahg/fonts/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 16);
            Font currencyFont = new Font(BaseFont.createFont("src/main/resources/com/openjfx/qllspahg/fonts/vuArialItalic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 16);
            for (BangLuongCongNhan blcn : listBLCN) {

                PdfPTable bang = new PdfPTable(2);
                bang.setWidthPercentage(100);


                Paragraph maBL = new Paragraph("Mã bảng lương: " + blcn.getMaBLCN(), contentFont);
                maBL.setAlignment(Element.YMARK);
                maBL.setSpacingAfter(10);
                document.add(maBL);

                Paragraph tieuDe = new Paragraph("PHIẾU LƯƠNG CÔNG NHÂN", titleFont);
                tieuDe.setAlignment(Element.ALIGN_CENTER);
                tieuDe.setSpacingAfter(30);
                document.add(tieuDe);


                String thangNamBL = "Ngày tính lương: " + DateUtils.formatStringVietnamDateCustom(blcn.getNgayTinhLuong(), "dd-MM-yyyy");
                String congTyBL = "Công Ty AHG";
                PdfPTable hangTieuDePhu = new PdfPTable(2);
                hangTieuDePhu.setSpacingAfter(20);
                hangTieuDePhu.setWidthPercentage(100);
                Paragraph tieuDePhuTrai = new Paragraph(congTyBL, titleNormalFont);
                Paragraph tieuDePhuPhai = new Paragraph(thangNamBL, titleNormalFont);
                PdfPCell oTieuDePhuTrai = new PdfPCell(tieuDePhuTrai);
                oTieuDePhuTrai.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                oTieuDePhuTrai.setBorder(PdfPCell.NO_BORDER);
                PdfPCell oTieuDephuPhai = new PdfPCell(tieuDePhuPhai);
                oTieuDephuPhai.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                oTieuDephuPhai.setBorder(PdfPCell.NO_BORDER);
                hangTieuDePhu.addCell(oTieuDePhuTrai);
                hangTieuDePhu.addCell(oTieuDephuPhai);
                document.add(hangTieuDePhu);

                //Chi Tiet
                /*bang.addCell(new Paragraph(": ", contentFont));
                bang.addCell(new Paragraph(blcn., contentFont));*/
                PdfPCell cell11 = new PdfPCell(new Paragraph("Thông tin: ", titleNormalFont));
                cell11.setPadding(10);
                bang.addCell(cell11);
                PdfPCell cell12 = new PdfPCell(new Paragraph("Chi tiết: ", titleNormalFont));
                cell12.setPadding(10);
                bang.addCell(cell12);

                PdfPCell cell21 = new PdfPCell(new Paragraph("Mã công nhân: ", contentFont));
                cell21.setPadding(10);
                bang.addCell(cell21);
                PdfPCell cell22 = new PdfPCell(new Paragraph(blcn.getMaCongNhan().getMaCN(), contentFont));
                cell22.setPadding(10);
                bang.addCell(cell22);

                PdfPCell cell31 = new PdfPCell(new Paragraph("Họ và tên", contentFont));
                cell31.setPadding(10);
                bang.addCell(cell31);
                PdfPCell cell32 = new PdfPCell(new Paragraph(blcn.getMaCongNhan().getHoCN() + " " + blcn.getMaCongNhan().getTenCN(), contentFont));
                cell32.setPadding(10);
                bang.addCell(cell32);

                PdfPCell cell41 = new PdfPCell(new Paragraph("Tổ sản xuất", contentFont));
                cell41.setPadding(10);
                bang.addCell(cell41);
                PdfPCell cell42 = new PdfPCell(new Paragraph(blcn.getMaCongNhan().getToSanXuat().getMaTSX(), contentFont));
                cell42.setPadding(10);
                bang.addCell(cell42);

                PdfPCell cell51 = new PdfPCell(new Paragraph("Tổng lương", contentFont));
                cell51.setPadding(10);
                bang.addCell(cell51);
                PdfPCell cell52 = new PdfPCell(new Paragraph(Utils.formatCurrency(blcn.getLuongCN()), currencyFont));
                cell52.setPadding(10);
                bang.addCell(cell52);

                PdfPCell cell61 = new PdfPCell(new Paragraph("Lương thực tế được nhận", contentFont));
                cell61.setPadding(10);
                bang.addCell(cell61);
                PdfPCell cell62 = new PdfPCell(new Paragraph(Utils.formatCurrency(blcn.getTongLuongCN()), contentFont));
                cell62.setPadding(10);
                bang.addCell(cell62);

               /* PdfPCell cell71 = new PdfPCell(new Paragraph("Ngày nhận lương", contentFont));
                cell71.setPadding(10);
                bang.addCell(cell71);
                PdfPCell cell72 = new PdfPCell(new Paragraph(DateUtils.formatStringVietnamDateCustom(blcn.getNgayNhanLuong(), "dd-MM-yyyy"), contentFont));
                cell72.setPadding(10);
                bang.addCell(cell72);*/


                document.add(bang);

                document.newPage();
            }
            document.close();
            System.out.println("Da tao phieu luong");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
