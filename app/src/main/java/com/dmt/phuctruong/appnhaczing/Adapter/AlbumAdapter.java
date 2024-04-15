package com.dmt.phuctruong.appnhaczing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.phuctruong.appnhaczing.Model.Album;
import com.dmt.phuctruong.appnhaczing.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> albumArrayList;

    public AlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);

        holder.textViewTenCaSiAlbum.setText(album.getTenCaSiAlbum());
        holder.textViewTitleAlbum.setText(album.getTenAlbum());
        Picasso.get().load(album.getHinhAlbum()).into(holder.imageViewAlbum);
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewAlbum;
        TextView textViewTitleAlbum, textViewTenCaSiAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewAlbum = itemView.findViewById(R.id.imageViewAlbum);
            textViewTitleAlbum = itemView.findViewById(R.id.textViewTitleAlbum);
            textViewTenCaSiAlbum = itemView.findViewById(R.id.textViewTenCaSiAlbum);
        }
    }
}
