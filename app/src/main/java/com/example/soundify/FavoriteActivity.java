package com.example.soundify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.soundify.Database.DBHelper;
import com.example.soundify.Recyclerview.RecyclerviewAdapter;
import com.example.soundify.Recyclerview.RecyclerviewAdapterFav;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {


    DBHelper dbHelper;
    RecyclerView recyclerview;
    RecyclerviewAdapterFav adapter;
    Button btnClearData;
    Button previousPageBtn;
    public static List<Song> list;

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_favorite);

        previousPageBtn = findViewById(R.id.previousPageBtn);
        previousPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        //init all variables
        dbHelper = new DBHelper(FavoriteActivity.this);
        recyclerview = findViewById(R.id.recyclerview1);
        btnClearData = findViewById(R.id.button4);

        recyclerview.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));
        list = getAllSong();

        adapter = new RecyclerviewAdapterFav(list, this, 4);
        recyclerview.setAdapter(adapter);

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete();
                List<Song> list = getAllSong(); //clears all the data stored in the database for favourite activity

                adapter = new RecyclerviewAdapterFav(list, FavoriteActivity.this, 3);
                recyclerview.setAdapter(adapter);
                //sets recyclerview data to the favourite activity layout and song indexes

                Toast.makeText(FavoriteActivity.this, "Deleted Song", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public ArrayList<Song> getAllSong() {
        ArrayList<Song> songlist = new ArrayList<Song>();
        // Select All Query
        String selectQuery = "SELECT  * FROM song";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Song song = new Song();
                song.setId(cursor.getString(1));
                song.setTitle(cursor.getString(2));
                song.setArtiste(cursor.getString(3));
                song.setFileLink(cursor.getString(4));
                song.setSongLength(cursor.getDouble(5));
                song.setDrawable(cursor.getInt(7));

                // Adding contact to list
                songlist.add(song);
            } while (cursor.moveToNext());
        }

        // return contact list
        return songlist;
    }
}