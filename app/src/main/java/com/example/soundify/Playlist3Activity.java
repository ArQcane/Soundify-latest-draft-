package com.example.soundify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.soundify.Recyclerview.RecyclerviewAdapter;

import java.util.Arrays;
import java.util.List;

public class Playlist3Activity extends AppCompatActivity {

    public SongCollection songCollection;
    RecyclerView recyclerView;
    List<Song> listSongPlaylist3;
    RecyclerviewAdapter adapter;
    Button previousPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playlist3);


        previousPageBtn=findViewById(R.id.previousPageBtn);
        previousPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        songCollection=new SongCollection();

        listSongPlaylist3= Arrays.asList(songCollection.songPlaylist3);
        adapter=new RecyclerviewAdapter(listSongPlaylist3,Playlist3Activity.this,3);
        // sets adapter data to song collection for playlist 3 array list only so that the recyclerview shows playlist 3 songs


        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void gotoFavoriteActivity(View view) {
        startActivity(new Intent(Playlist3Activity.this, FavoriteActivity.class));
    }
}