package com.dmt.phuctruong.appnhaczing.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.phuctruong.appnhaczing.Adapter.BaiHatYeuThichAdapter;
import com.dmt.phuctruong.appnhaczing.Model.BaiHat;
import com.dmt.phuctruong.appnhaczing.R;
import com.dmt.phuctruong.appnhaczing.Service.APIService;
import com.dmt.phuctruong.appnhaczing.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Bai_Hat_Yeu_Thich extends Fragment {
    View view;
    RecyclerView recyclerViewBaiHatYeuThich;
    BaiHatYeuThichAdapter baiHatYeuThichAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bai_hat_yeu_thich, container, false);
        recyclerViewBaiHatYeuThich = view.findViewById(R.id.recyclerViewBaiHatYeuThich);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callBack = dataService.GetDataBaiHatYeuThich();
        callBack.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatYeuThichArrayList = (ArrayList<BaiHat>) response.body();

                baiHatYeuThichAdapter = new BaiHatYeuThichAdapter(getActivity(), baiHatYeuThichArrayList);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewBaiHatYeuThich.setLayoutManager(linearLayoutManager);

                recyclerViewBaiHatYeuThich.setAdapter(baiHatYeuThichAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
