package com.dmt.phuctruong.appnhaczing.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.phuctruong.appnhaczing.Adapter.PlaylistAdapter;
import com.dmt.phuctruong.appnhaczing.Model.Playlist;
import com.dmt.phuctruong.appnhaczing.R;
import com.dmt.phuctruong.appnhaczing.Service.APIService;
import com.dmt.phuctruong.appnhaczing.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Playlist extends Fragment {
    View view;
    RecyclerView recyclerViewPlaylist;
    TextView tvTiltlePlaylist, tvXemThemPlaylist;
    PlaylistAdapter playlistAdapter;
    ArrayList<Playlist> mangPlaylist;

    @Nullable
    @Override
    // Hàm onCeateView dùm để gắn layout vào cho Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerViewPlaylist = view.findViewById(R.id.recyclerViewPlaylist);
        tvTiltlePlaylist = view.findViewById(R.id.textViewTitlePlaylist);
        tvXemThemPlaylist = view.findViewById(R.id.textViewViewMorePlaylist);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewPlaylist.setLayoutManager(layoutManager);

        GetData();
        return view;
    }

    // Sử dụng retrofit cho việc đọc dữ liệu về
    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Playlist>> callback = dataService.GetPlaylistCurrentDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                mangPlaylist = (ArrayList<Playlist>) response.body();
                Log.d("Fragment_Playlist", "Playlist size: " + mangPlaylist.size());

                if (getActivity() != null) {
                    playlistAdapter = new PlaylistAdapter(mangPlaylist);
                    recyclerViewPlaylist.setAdapter(playlistAdapter);
                } else {
                    Log.e("Fragment_Playlist", "onResponse: getActivity() is null");
                }
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
            }
        });
    }
}
