package com.dmt.phuctruong.appnhaczing.Model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Album {

    @SerializedName("IDAlbum")
    @Expose
    private String iDAlbum;
    @SerializedName("TenAlbum")
    @Expose
    private String tenAlbum;
    @SerializedName("TenCaSiAlbum")
    @Expose
    private String tenCaSiAlbum;
    @SerializedName("NamPhatHanhAlbum")
    @Expose
    private String namPhatHanhAlbum;
    @SerializedName("HinhAlbum")
    @Expose
    private String hinhAlbum;

    public String getIDAlbum() {
        return iDAlbum;
    }

    public void setIDAlbum(String iDAlbum) {
        this.iDAlbum = iDAlbum;
    }

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }

    public String getTenCaSiAlbum() {
        return tenCaSiAlbum;
    }

    public void setTenCaSiAlbum(String tenCaSiAlbum) {
        this.tenCaSiAlbum = tenCaSiAlbum;
    }

    public String getNamPhatHanhAlbum() {
        return namPhatHanhAlbum;
    }

    public void setNamPhatHanhAlbum(String namPhatHanhAlbum) {
        this.namPhatHanhAlbum = namPhatHanhAlbum;
    }

    public String getHinhAlbum() {
        return hinhAlbum;
    }

    public void setHinhAlbum(String hinhAlbum) {
        this.hinhAlbum = hinhAlbum;
    }

}
