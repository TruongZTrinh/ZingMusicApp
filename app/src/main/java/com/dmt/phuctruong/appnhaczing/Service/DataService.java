package com.dmt.phuctruong.appnhaczing.Service;

import com.dmt.phuctruong.appnhaczing.Model.Album;
import com.dmt.phuctruong.appnhaczing.Model.BaiHat;
import com.dmt.phuctruong.appnhaczing.Model.Playlist;
import com.dmt.phuctruong.appnhaczing.Model.QuangCao;
import com.dmt.phuctruong.appnhaczing.Model.ChuDeVaTheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("songBanner.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("playlistForCurrentDay.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chuDeVaTheLoaiForDay.php")
    Call<ChuDeVaTheLoai> GetDataChuDeVaTheLoai();

    @GET("albumHot.php")
    Call<List<Album>> GetDataAlbumHot();

    @GET("baiHatYeuThich.php")
    Call<List<BaiHat>> GetDataBaiHatYeuThich();

    @FormUrlEncoded
    @POST("danhSachBaiHat.php")
    Call<List<BaiHat>> GetDanhSachBaiHatTheoQuangCao(@Field("idquangcao") String idquangcao);
}
