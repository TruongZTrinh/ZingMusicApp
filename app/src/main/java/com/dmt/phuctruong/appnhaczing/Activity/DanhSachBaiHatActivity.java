package com.dmt.phuctruong.appnhaczing.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dmt.phuctruong.appnhaczing.Adapter.DanhSachBaiHatAdapter;
import com.dmt.phuctruong.appnhaczing.Model.BaiHat;
import com.dmt.phuctruong.appnhaczing.Model.QuangCao;
import com.dmt.phuctruong.appnhaczing.R;
import com.dmt.phuctruong.appnhaczing.Service.APIService;
import com.dmt.phuctruong.appnhaczing.Service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewDanhSachBaiHat;
    FloatingActionButton floatingActionButton;
    ImageView imageViewDanhSachBaiHat;
    ImageView imageViewNenDanhSachBaiHat;

    ArrayList<BaiHat> baiHatArrayList;
    QuangCao quangCao;

    DanhSachBaiHatAdapter danhSachBaiHatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);

        DataIntent();
        anhxa();
        init();

        if (quangCao != null && !quangCao.getTenBaiHat().equals("")) {
            setValueInView(quangCao.getTenBaiHat(), quangCao.getHinhBaiHat());
        }
    }

    private void setValueInView(final String ten, final String hinh) {
        collapsingToolbarLayout.setTitle(ten);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(hinh);
                    final Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
                            collapsingToolbarLayout.setBackground(bitmapDrawable);
                        }
                    });
                } catch (final MalformedURLException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (final IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }).start();

        Picasso.get().load(hinh).into(imageViewNenDanhSachBaiHat);
        Picasso.get().load(hinh).into(imageViewDanhSachBaiHat);
    }

    private void GetDataQuangCao(String idquangcao) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callback = dataService.GetDanhSachBaiHatTheoQuangCao(idquangcao);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = (ArrayList<BaiHat>) response.body();

                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this, baiHatArrayList);
                recyclerViewDanhSachBaiHat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewDanhSachBaiHat.setAdapter(danhSachBaiHatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    public void init() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        toolbar = findViewById(R.id.toolbarDanhSachBaiHat);
        recyclerViewDanhSachBaiHat = findViewById(R.id.recyclerViewDanhSachBaiHat);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        imageViewDanhSachBaiHat = findViewById(R.id.imageViewDanhSachBaiHat);
        imageViewNenDanhSachBaiHat = findViewById(R.id.imageViewNenDanhSachBaiHat);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
                assert quangCao != null;
                Toast.makeText(this, quangCao.getTenBaiHat(), Toast.LENGTH_LONG).show();
            }
        }
    }
}