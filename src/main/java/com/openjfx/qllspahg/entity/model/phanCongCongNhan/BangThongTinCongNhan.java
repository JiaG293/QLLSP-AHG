package com.openjfx.qllspahg.entity.model.phanCongCongNhan;

import com.openjfx.qllspahg.entity.CongNhan;

import java.util.Objects;

public class BangThongTinCongNhan {
    private int stt;
    private CongNhan congNhan;

    public BangThongTinCongNhan(int stt, CongNhan congNhan) {
        this.stt = stt;
        this.congNhan = congNhan;
    }

    public BangThongTinCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangThongTinCongNhan that = (BangThongTinCongNhan) o;
        return Objects.equals(congNhan, that.congNhan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(congNhan);
    }

    @Override
    public String toString() {
        return "BangThongTinCongNhan{" +
                "stt=" + stt +
                ", congNhan=" + congNhan +
                '}';
    }
}
