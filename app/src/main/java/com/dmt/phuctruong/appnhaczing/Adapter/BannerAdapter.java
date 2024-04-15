package com.dmt.phuctruong.appnhaczing.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.dmt.phuctruong.appnhaczing.Activity.DanhSachBaiHatActivity;
import com.dmt.phuctruong.appnhaczing.Model.QuangCao;
import com.dmt.phuctruong.appnhaczing.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    Context context;
    ArrayList<QuangCao> arrayListBanner;
    ViewPager2 viewPager2;

    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListBanner, ViewPager2 viewPager2) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dong_banner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuangCao quangCao = arrayListBanner.get(position);

        Picasso.get().load(quangCao.getHinhQuangCao()).into(holder.imgBackgroundBanner);
        Picasso.get().load(quangCao.getHinhBaiHat()).into(holder.imgSongBanner);
        holder.textViewTitleSongBanner.setText(quangCao.getTenBaiHat());
        holder.textViewNoiDungSong.setText(quangCao.getNoiDungQuangCao());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("banner", arrayListBanner.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListBanner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBackgroundBanner;
        ImageView imgSongBanner;
        TextView textViewTitleSongBanner;
        TextView textViewNoiDungSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBackgroundBanner = itemView.findViewById(R.id.imageViewBackgroundBanner);
            imgSongBanner = itemView.findViewById(R.id.imageViewBanner);
            textViewTitleSongBanner = itemView.findViewById(R.id.textViewTitleBannerBaiHat);
            textViewNoiDungSong = itemView.findViewById(R.id.textViewNoiDungSong);
        }
    }
}
