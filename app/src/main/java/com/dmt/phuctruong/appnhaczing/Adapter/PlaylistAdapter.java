package com.dmt.phuctruong.appnhaczing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.phuctruong.appnhaczing.Model.Playlist;
import com.dmt.phuctruong.appnhaczing.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    List<Playlist> playlistList;

    public PlaylistAdapter(List<Playlist> playlistList) {
        this.playlistList = playlistList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewBackgroundPlaylist, imageViewPlaylist;
        TextView textViewTenPlaylist;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewBackgroundPlaylist = itemView.findViewById(R.id.imageViewBackgroundPlaylist);
            imageViewPlaylist = itemView.findViewById(R.id.imageViewPlaylist);
            textViewTenPlaylist = itemView.findViewById(R.id.textViewTenPlaylist);
        }
    }

    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHolder holder, int position) {
        Playlist playlist = playlistList.get(position);
        Picasso.get().load(playlist.getHinhPlaylist()).into(holder.imageViewBackgroundPlaylist);
        Picasso.get().load(playlist.getHinhIcon()).into(holder.imageViewPlaylist);
        holder.textViewTenPlaylist.setText(playlist.getTenPlaylist());
    }

    @Override
    public int getItemCount() {
        return playlistList.size();
    }
}
