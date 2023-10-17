package com.openjfx.qllspahg.entity;

import java.time.LocalDate;

public class BangLuongCongNhan {
    private BangChamCongCongNhan maBangChamCongCongNhan;
    private TamUngCongNhan maTamUngCongNhan;
    private LocalDate ngayTinhLuong;
    private Double luongCN;
    private Double bhxhCN;
    private Double bhytCN;
    private Double tongLuongCN;

    public BangLuongCongNhan(BangChamCongCongNhan maBangChamCongCongNhan, TamUngCongNhan maTamUngCongNhan, LocalDate ngayTinhLuong) {
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

    public LocalDate getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(LocalDate ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }
}
