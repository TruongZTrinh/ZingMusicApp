package com.dmt.phuctruong.appnhaczing.Model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Playlist {

    @SerializedName("IDPlaylist")
    @Expose
    private String iDPlaylist;
    @SerializedName("TenPlaylist")
    @Expose
    private String tenPlaylist;
    @SerializedName("HinhPlaylist")
    @Expose
    private String hinhPlaylist;
    @SerializedName("HinhIcon")
    @Expose
    private String hinhIcon;

    public String getIDPlaylist() {
        return iDPlaylist;
    }

    public void setIDPlaylist(String iDPlaylist) {
        this.iDPlaylist = iDPlaylist;
    }

    public String getTenPlaylist() {
        return tenPlaylist;
    }

    public void setTenPlaylist(String tenPlaylist) {
        this.tenPlaylist = tenPlaylist;
    }

    public String getHinhPlaylist() {
        return hinhPlaylist;
    }

    public void setHinhPlaylist(String hinhPlaylist) {
        this.hinhPlaylist = hinhPlaylist;
    }

    public String getHinhIcon() {
        return hinhIcon;
    }

    public void setHinhIcon(String hinhIcon) {
        this.hinhIcon = hinhIcon;
    }

}
