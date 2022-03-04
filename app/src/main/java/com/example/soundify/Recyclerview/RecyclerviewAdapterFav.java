package com.example.soundify.Recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundify.Database.DBHelper;
import com.example.soundify.PlaySongActivity;
import com.example.soundify.R;
import com.example.soundify.Song;

import java.util.List;

public class RecyclerviewAdapterFav extends RecyclerView.Adapter<RecyclerviewAdapterFav.ViewHolderClass> {
    List<Song> list;
    Context context;
    int playListNumber;
    DBHelper dbHelper;

    public RecyclerviewAdapterFav(List<Song> list, Context context, int playListNumber) {
        this.list = list;
        this.context = context;
        this.playListNumber = playListNumber;
        dbHelper=new DBHelper(context);

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.signle_view_recyclerview2, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerviewAdapterFav.ViewHolderClass holder, int position) {
        holder.thumbnail.setImageResource(list.get(position).getDrawable());
        holder.title.setText(list.get(position).getTitle() + "");
        holder.artist.setText(list.get(position).getArtiste() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Song song = new Song();
                song = list.get(position);
                Intent intent = new Intent(context, PlaySongActivity.class);
                intent.putExtra("index", position);
                intent.putExtra("playListNumber",playListNumber);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title, artist;


        public ViewHolderClass(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            artist = itemView.findViewById(R.id.artistName);



        }
    }
}
