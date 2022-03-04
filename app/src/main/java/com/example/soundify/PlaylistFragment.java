package com.example.soundify;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class PlaylistFragment extends Fragment {

    ImageButton mPlaylist1;
    ImageButton mPlaylist2;
    ImageButton mPlaylist3;
    ImageView imageViewFav;
    public PlaylistFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        mPlaylist1= view.findViewById(R.id.playlist1Btn);
        mPlaylist2 = view.findViewById(R.id.playlist2Btn);
        mPlaylist3 = view.findViewById(R.id.playlist3Btn);
        imageViewFav = view.findViewById(R.id.imageView);

        imageViewFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FavoriteActivity.class));
            }
        });

        mPlaylist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Playlist1Activity.class));
            }
        });


        mPlaylist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Playlist2Activity.class));
            }
        });

        mPlaylist3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Playlist3Activity.class));
            }
        });
        return view;
    }
}