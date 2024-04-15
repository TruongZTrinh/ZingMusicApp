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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatYeuThichAdapter extends RecyclerView.Adapter<BaiHatYeuThichAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public BaiHatYeuThichAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_yeu_thich, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = baiHatArrayList.get(position);

        holder.textViewTenBaiHatYeuThich.setText(baiHat.getTenBaiHat());
        holder.textViewCaSiBaiHatYeuThich.setText(baiHat.getCaSi());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.imageViewBaiHatYeuThich);
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewBaiHatYeuThich, imageViewLuotThich;
        TextView textViewTenBaiHatYeuThich, textViewCaSiBaiHatYeuThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewBaiHatYeuThich = itemView.findViewById(R.id.imageViewBaiHatYeuThich);
            imageViewLuotThich = itemView.findViewById(R.id.imageViewLuotThich);
            textViewTenBaiHatYeuThich = itemView.findViewById(R.id.textViewTenBaiHatYeuThich);
            textViewCaSiBaiHatYeuThich = itemView.findViewById(R.id.textViewCaSiBaiHatYeuThich);
        }
    }
}
