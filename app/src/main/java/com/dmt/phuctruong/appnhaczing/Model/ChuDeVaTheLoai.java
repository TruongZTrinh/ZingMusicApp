package com.dmt.phuctruong.appnhaczing.Model;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ChuDeVaTheLoai {

    @SerializedName("TheLoai")
    @Expose
    private List<TheLoai> theLoai;
    @SerializedName("ChuDe")
    @Expose
    private List<ChuDe> chuDe;

    public List<TheLoai> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(List<TheLoai> theLoai) {
        this.theLoai = theLoai;
    }

    public List<ChuDe> getChuDe() {
        return chuDe;
    }

    public void setChuDe(List<ChuDe> chuDe) {
        this.chuDe = chuDe;
    }

}
