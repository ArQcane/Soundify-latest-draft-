package com.example.soundify.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    static final String TABLE_USERS = "song";
    static final String KEY_ID = "id";
    static final int DB_VERSION = 1;
    static final String DB_NAME = "mydb";
    Context context;


    public DBHelper(Context context1) {
        super(context1, DB_NAME, null, DB_VERSION);
        context = context1;
    }

    public void insertSong(String songID, String title, String artiste, String fileLink, double songLength, int Playnumber, int drawable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", songID);
        values.put("title", title);
        values.put("artiste", artiste);
        values.put("fileLink", fileLink);
        values.put("songLength", songLength);
        values.put("playListNumber", Playnumber);
        values.put("drawable", drawable);

        long insert = db.insert(TABLE_USERS, null, values);

        Toast.makeText(context, "Added Song", Toast.LENGTH_SHORT).show();

        db.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " +
                TABLE_USERS + "("
                + "id_auto" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id" + " TEXT,"
                + "title" + " TEXT,"
                + "artiste" + " TEXT,"
                + "fileLink" + " TEXT,"
                + "songLength" + " DOUBLE, "
                + "playListNumber" + " INTEGER, "
                + "drawable" + " INTEGER " + ")";

        db.execSQL(CREATE_TABLE);


    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }


    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_USERS);
        db.close();
    }


}
