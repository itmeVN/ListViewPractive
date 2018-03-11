package com.example.buitu.listviewpractive;

import java.io.Serializable;

/**
 * Created by buitu on 3/5/2018.
 */

public class ThongTin implements Serializable {
    private String MaSV,TenSV,DiaChi;
    private String sdt;

    public ThongTin(String maSV, String tenSV, String diaChi, String sdt) {
        MaSV = maSV;
        TenSV = tenSV;
        DiaChi = diaChi;
        this.sdt = sdt;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
