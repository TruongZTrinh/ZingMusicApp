package com.dmt.phuctruong.appnhaczing.Model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BaiHat {

    @SerializedName("IDBaiHat")
    @Expose
    private String iDBaiHat;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("CaSi")
    @Expose
    private String caSi;
    @SerializedName("HinhBaiHat")
    @Expose
    private String hinhBaiHat;
    @SerializedName("DuongDanLuuTru")
    @Expose
    private String duongDanLuuTru;
    @SerializedName("LuotThich")
    @Expose
    private String luotThich;

    public String getIDBaiHat() {
        return iDBaiHat;
    }

    public void setIDBaiHat(String iDBaiHat) {
        this.iDBaiHat = iDBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getHinhBaiHat() {
        return hinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        this.hinhBaiHat = hinhBaiHat;
    }

    public String getDuongDanLuuTru() {
        return duongDanLuuTru;
    }

    public void setDuongDanLuuTru(String duongDanLuuTru) {
        this.duongDanLuuTru = duongDanLuuTru;
    }

    public String getLuotThich() {
        return luotThich;
    }

    public void setLuotThich(String luotThich) {
        this.luotThich = luotThich;
    }

}