package com.openjfx.qllspahg.entity;

import java.sql.Date;

public class BangLuongCongNhan {
    private BangChamCongCongNhan maBangChamCongCongNhan;
    private TamUngCongNhan maTamUngCongNhan;
    private Date ngayTinhLuong;
    private double luongCN;
    private double bhxhCN;
    private double bhytCN;
    private double tongLuongCN;

    public BangLuongCongNhan(BangChamCongCongNhan maBangChamCongCongNhan, TamUngCongNhan maTamUngCongNhan, Date ngayTinhLuong) {
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
        this.maTamUngCongNhan = maTamUngCongNhan;
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public BangChamCongCongNhan getMaBangChamCongCongNhan() {
        return maBangChamCongCongNhan;
    }

    public void setMaBangChamCongCongNhan(BangChamCongCongNhan maBangChamCongCongNhan) {
        this.maBangChamCongCongNhan = maBangChamCongCongNhan;
    }

    public TamUngCongNhan getMaTamUngCongNhan() {
        return maTamUngCongNhan;
    }

    public void setMaTamUngCongNhan(TamUngCongNhan maTamUngCongNhan) {
        this.maTamUngCongNhan = maTamUngCongNhan;
    }

    public Date getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(Date ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }
}
