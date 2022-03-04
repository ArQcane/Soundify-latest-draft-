package com.example.soundify.Recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundify.Database.DBHelper;
import com.example.soundify.PlaySongActivity;
import com.example.soundify.R;
import com.example.soundify.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolderClass> implements Filterable {
    List<Song> list;
    Context context;
    int playListNumber;
    DBHelper dbHelper;
    List<Song> listFull;
    public static  Song song;


    public RecyclerviewAdapter(List<Song> list, Context context, int playListNumber) {
        this.list = list;
        this.context = context;
        this.playListNumber = playListNumber;
        dbHelper = new DBHelper(context);
        listFull = new ArrayList<>(list);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.signle_view_recyclerview, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerviewAdapter.ViewHolderClass holder, int position) {
        holder.thumbnail.setImageResource(list.get(position).getDrawable());
        holder.title.setText(list.get(position).getTitle() + "");
        holder.artist.setText(list.get(position).getArtiste() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song=list.get(position);
                Intent intent = new Intent(context, PlaySongActivity.class);
                intent.putExtra("index", position);
                intent.putExtra("playListNumber", playListNumber);
                context.startActivity(intent);



            }
        });

        holder.addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Song song = new Song();
                song = list.get(position);
                //save song into playlist
                dbHelper.insertSong(song.getId(), song.getTitle(), song.getArtiste(), song.getFileLink(), song.getSongLength(), playListNumber, song.getDrawable());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return FilterSongs;
    }


    private Filter FilterSongs = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Song> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Song item : listFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title, artist;
        ImageView addImageView;

        public ViewHolderClass(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            artist = itemView.findViewById(R.id.artistName);
            addImageView = itemView.findViewById(R.id.imageViewAdd);


        }
    }
}
