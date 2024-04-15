package com.dmt.phuctruong.appnhaczing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.phuctruong.appnhaczing.Model.BaiHat;
import com.dmt.phuctruong.appnhaczing.R;

import java.util.ArrayList;

public class DanhSachBaiHatAdapter extends RecyclerView.Adapter<DanhSachBaiHatAdapter.ViewHolder> {

    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public DanhSachBaiHatAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = baiHatArrayList.get(position);

        holder.textViewBaiHatIndex.setText(position + 1 + "");
        holder.textViewTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.textViewTenCaSi.setText(baiHat.getCaSi());
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBaiHatIndex, textViewTenBaiHat, textViewTenCaSi;
        ImageView imageViewLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBaiHatIndex = itemView.findViewById(R.id.textViewBaiHatIndex);
            textViewTenBaiHat = itemView.findViewById(R.id.textViewTenBaiHat);
            textViewTenCaSi = itemView.findViewById(R.id.textViewTenCaSi);
            imageViewLuotThich = itemView.findViewById(R.id.imageViewLuotThichBaiHat);
        }
    }
}
