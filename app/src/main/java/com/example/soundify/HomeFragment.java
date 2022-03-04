package com.example.soundify;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundify.Recyclerview.RecyclerviewAdapter;
import com.example.soundify.Recyclerview.RecyclerviewAdapterHome;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class HomeFragment extends Fragment {

    public SongCollection songCollection;
    RecyclerView recyclerView;
    static List<Song> listSongPlaylistHome;
    RecyclerviewAdapterHome adapter;
    TextView logout;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        logout=view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(),LoginActivity.class));
                getActivity().finish();
            }
        });

        songCollection = new SongCollection();
        listSongPlaylistHome = Arrays.asList(songCollection.songPlaylistAll);
        Collections.shuffle(listSongPlaylistHome);
        //shuffles songs in the home page so everytime homepage is open new songs are displayed

        adapter = new RecyclerviewAdapterHome(listSongPlaylistHome, getContext(), 5);


        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
        //makes the layout a grid one
    }


}