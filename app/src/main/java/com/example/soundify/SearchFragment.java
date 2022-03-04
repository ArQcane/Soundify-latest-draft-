package com.example.soundify;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundify.Recyclerview.RecyclerviewAdapter;
import com.example.soundify.Recyclerview.RecyclerviewAdapterHome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SearchFragment extends Fragment {

    public SongCollection songCollection;
    RecyclerView recyclerView;

    RecyclerviewAdapter adapter;
    EditText inputSearch;

    List<Song> listSongPlaylisAll;

    public SearchFragment() {
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        AddSongintoPlayList();
        AssignDataData();


        inputSearch = view.findViewById(R.id.inputSearch);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    AddSongintoPlayList();
                    AssignDataData();
                } else {
                    adapter.getFilter().filter(s.toString());
                }
            }
        });
        return view;
    }

    private void AssignDataData() {
        adapter = new RecyclerviewAdapter(listSongPlaylisAll, getContext(), 6);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        //adapter data set to all songs in local cache for phone (25 songs)
    }

    private void AddSongintoPlayList() {

        listSongPlaylisAll = new ArrayList<>();
        songCollection = new SongCollection();


        for (int i = 0; i < songCollection.songPlaylistAll.length; i++) {
            listSongPlaylisAll.add(songCollection.songPlaylistAll[i]);
            // adds all songs in songcollection to the search page fragment
        }

    }
}