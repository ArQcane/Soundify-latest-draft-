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

public class Playlist2Activity extends AppCompatActivity {

    public SongCollection songCollection;
    RecyclerView recyclerView;
    List<Song> listSongPlaylist2;
    RecyclerviewAdapter adapter;
    Button previousPageBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playlist2);

        previousPageBtn=findViewById(R.id.previousPageBtn);
        previousPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        songCollection=new SongCollection();
        listSongPlaylist2= Arrays.asList(songCollection.songPlaylist2);
        adapter=new RecyclerviewAdapter(listSongPlaylist2,Playlist2Activity.this,2);
        // sets adapter data to song collection for playlist 2 array list only so that the recyclerview shows playlist 2 songs


        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    public void gotoFavoriteActivity(View view) {
        startActivity(new Intent(Playlist2Activity.this, FavoriteActivity.class));
    }
}