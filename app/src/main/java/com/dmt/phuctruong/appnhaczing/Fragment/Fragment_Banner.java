package com.dmt.phuctruong.appnhaczing.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.dmt.phuctruong.appnhaczing.Adapter.BannerAdapter;
import com.dmt.phuctruong.appnhaczing.Model.QuangCao;
import com.dmt.phuctruong.appnhaczing.R;
import com.dmt.phuctruong.appnhaczing.Service.APIService;
import com.dmt.phuctruong.appnhaczing.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {

    View view;
    ViewPager2 viewPager2;
    CircleIndicator3 circleIndicator3;
    BannerAdapter bannerAdapter;

    Runnable runnable;
    Handler handler;
    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        anhxa();
        GetData();
        return view;
    }

    private void anhxa() {
        viewPager2 = view.findViewById(R.id.viewPager2);
        circleIndicator3 = view.findViewById(R.id.indicatorDefault);
    }

    private void GetData() {
        DataService dataService = APIService.getService();

        Call<List<QuangCao>> callBack = dataService.GetDataBanner();

        callBack.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();

                bannerAdapter = new BannerAdapter(getActivity(), banners, viewPager2);

                viewPager2.setAdapter(bannerAdapter);

                circleIndicator3.setViewPager(viewPager2);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager2.getCurrentItem();
                        currentItem++;
                        if (currentItem >= viewPager2.getAdapter().getItemCount()) {
                            currentItem = 0;
                        }
                        viewPager2.setCurrentItem(currentItem, true);
                        handler.postDelayed(runnable, 4500);
                    }
                };
                handler.postDelayed(runnable, 4500);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

            }
        });
    }
}
