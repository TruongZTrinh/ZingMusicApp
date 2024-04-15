package com.dmt.phuctruong.appnhaczing.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.dmt.phuctruong.appnhaczing.Model.ChuDe;
import com.dmt.phuctruong.appnhaczing.Model.ChuDeVaTheLoai;
import com.dmt.phuctruong.appnhaczing.Model.TheLoai;
import com.dmt.phuctruong.appnhaczing.R;
import com.dmt.phuctruong.appnhaczing.Service.APIService;
import com.dmt.phuctruong.appnhaczing.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_Today extends Fragment {
    View view;

    HorizontalScrollView horizontalScrollViewChuDeTheLoai;
    TextView textViewXemThemChuDeTheLoai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai, container, false);
        horizontalScrollViewChuDeTheLoai = view.findViewById(R.id.horizontalScrollViewChuDeTheLoai);
        textViewXemThemChuDeTheLoai = view.findViewById(R.id.textViewXemThemChuDeTheLoai);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<ChuDeVaTheLoai> callback = dataService.GetDataChuDeVaTheLoai();
        callback.enqueue(new Callback<ChuDeVaTheLoai>() {
            @Override
            public void onResponse(Call<ChuDeVaTheLoai> call, Response<ChuDeVaTheLoai> response) {
                ChuDeVaTheLoai chuDeVaTheLoai = response.body();

                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(chuDeVaTheLoai.getChuDe());

                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(chuDeVaTheLoai.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layoutChuDe = new LinearLayout.LayoutParams(500, 167);
                layoutChuDe.setMargins(10, 20, 10, 30);
                LinearLayout.LayoutParams layoutTheLoai = new LinearLayout.LayoutParams(167, 167);
                layoutTheLoai.setMargins(10, 20, 10, 30);
                for (int i = 0; i < (chuDeArrayList.size()); i++) {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);

                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chuDeArrayList.get(i).getHinhChuDe() != null) {
                        Picasso.get().load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutChuDe);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for (int j = 0; j < (theLoaiArrayList.size()); j++) {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);

                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theLoaiArrayList.get(j).getHinhTheLoai() != null) {
                        Picasso.get().load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutTheLoai);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollViewChuDeTheLoai.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<ChuDeVaTheLoai> call, Throwable t) {

            }
        });
    }
}
