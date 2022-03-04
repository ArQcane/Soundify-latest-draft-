package com.example.soundify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundify.Recyclerview.RecyclerviewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Playlist1Activity extends AppCompatActivity {
    public SongCollection songCollection;
    RecyclerView recyclerView;
    List<Song> listSongPlaylist1;
    RecyclerviewAdapter adapter;
    Button previousPageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playlist1);

        previousPageBtn = findViewById(R.id.previousPageBtn);
        previousPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        songCollection = new SongCollection();
        listSongPlaylist1 = Arrays.asList(songCollection.songPlaylist1);
        adapter = new RecyclerviewAdapter(listSongPlaylist1, Playlist1Activity.this, 1);
        //data set for recyclerview is only songs in the playlist1 song collection array list


        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

//    public void sendDataToActivity(int index) {
//        Intent intent = new Intent(this, PlaySongActivity.class);
//        intent.putExtra("index", index);
//        startActivity(intent);
//    }

    public void handleSelection(View myView) {
//        String resourceId = getResources().getResourceEntryName(myView.getId());
//        int currentArrayIndex = Playlist1.searchSongById(resourceId);
//        Log.d("temasek", "The id of the selected ImageButton is : " + resourceId);
//        sendDataToActivity(currentArrayIndex);
    }

    public void gotoFavoriteActivity(View view) {
        startActivity(new Intent(Playlist1Activity.this, FavoriteActivity.class));

    }
//
//    public void addToFavorites(View view) {
//        String SongID = view.getContentDescription().toString();
//        int song = Playlist1.searchSongById(SongID);  //problem is that class song is a int value and is not a String value like Song
//        favList.add(song);
//
//        Toast.makeText(this, "button is clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    public void gotoFavoriteActivity(View view) {
//        Intent intent = new Intent(this, FavoriteActivity.class);
//        startActivity(intent);
//    }
}
