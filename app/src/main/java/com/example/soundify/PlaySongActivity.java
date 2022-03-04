package com.example.soundify;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soundify.Recyclerview.RecyclerviewAdapter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlaySongActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;
    int playListNumber;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;

    public SongCollection songCollection = new SongCollection();
    SongCollection originalCollection = new SongCollection();
    List<Song> shuffleList = Arrays.asList(songCollection.songs);
    SeekBar seekBar;
    Handler handler = new Handler();
    Button shuffleBtn;
    Button repeatBtn;
    Boolean repeatFlag = false;
    Boolean shuffleFlag = false;
    boolean isOpenalready;
    Song song = null;
    TextView currentprogress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play_song);
        btnPlayPause = findViewById(R.id.btnPlayPause);

        currentIndex = getIntent().getIntExtra("index", -1);
        playListNumber = getIntent().getIntExtra("playListNumber", -1);

        displaySongBasedOnIndex(currentIndex, playListNumber);
        playSong(fileLink);
        seekBar = findViewById(R.id.seekBar1);
        currentprogress = findViewById(R.id.currentProgress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                currentprogress.setText("" +  progress/1000 +"s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (player != null) {
                    player.seekTo(seekBar.getProgress());
                }
            }
        });


        seekBar.setMax(player.getDuration());
        handler.removeCallbacks(p_bar);
        handler.postDelayed(p_bar, 1000);


        repeatBtn = findViewById(R.id.repeatBtn);
        shuffleBtn = findViewById(R.id.shuffleBtn);
    }

    Runnable p_bar = new Runnable() {
        @Override
        public void run() {
            if (player.isPlaying()) {
                seekBar.setProgress(player.getCurrentPosition());
            }
            handler.postDelayed(this, 1000);
        }
    };

    public void displaySongBasedOnIndex(int index, int playNumber) {

        if (playNumber == 1) {
            song = songCollection.songPlaylist1[index];
        }
        if (playNumber == 2) {
            song = songCollection.songPlaylist2[index];
        }
        if (playNumber == 3) {
            song = songCollection.songPlaylist3[index];
        }

        if (playNumber == 4) {
            song = FavoriteActivity.list.get(index);
        }
        if (playNumber == 5) {
            song = HomeFragment.listSongPlaylistHome.get(index);
        }
        if (playNumber == 6) {
            if (isOpenalready) {
                song = songCollection.songPlaylistAll[index];
            }
            else {
                song = RecyclerviewAdapter.song;
                updateIndexForCurrentSong();
            }

            isOpenalready = true;
            //if isOpenalready is false it searches for the song index from the arraylist with all songs in the song collection
            //if isOpenalready is true it searches from the current recyclerview data activity user is in and play the songs from that array list

        }


        title = song.getTitle();
        artiste = song.getArtiste();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();

        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);
        TextView txtArtiste = findViewById(R.id.txtArtiste);
        txtArtiste.setText(artiste);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);


    }

    private void updateIndexForCurrentSong() {

        currentIndex = songCollection.getSongPostionForSearch(song.getId());
        Toast.makeText(this, "current index=" + currentIndex, Toast.LENGTH_SHORT).show();
    }

    private void gracefullyStopWhenMusicEnds() {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (repeatFlag) {
                    playOrPauseMusic(null);
                } else if (!repeatFlag && shuffleFlag) {
                    playShuffleNext();
                } else {
                    btnPlayPause.setBackgroundResource(R.drawable.ic_outline_play_circle_outline_24);
                }
            }
        });
    }

    private void playShuffleNext() {
        int size = 0;
        int randomNumber = 0;

        //if playlist from first three playlist then get size of any of them
        if (playListNumber == 1 || playListNumber == 2 || playListNumber == 3) {
            size = songCollection.songPlaylist1.length;

        }

        //if playlist from favourite long
        if (playListNumber == 4) {
            size = FavoriteActivity.list.size();
        }
        if (playListNumber == 5) {
            size = HomeFragment.listSongPlaylistHome.size();
        }


        final int min = 0;
        final int max = size-1;

        final int random = new Random().nextInt((max - min) + 1) + min;

        //don't repeat same song in shuffle
        if (currentIndex == random) {
            playShuffleNext();
        } else {
            displaySongBasedOnIndex(random, playListNumber);
            playSong(fileLink);
        }
    }

    public void playSong(String songUrl) {
        try {
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            gracefullyStopWhenMusicEnds();
            btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_pause_circle_outline_24);
            setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View view) {
        if (!player.isPlaying()) { //if player is NOT playing
            btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_pause_circle_outline_24);
            player.start();
            seekBar.setMax(player.getDuration());
            handler.removeCallbacks(p_bar);
            handler.postDelayed(p_bar, 1000);
        } else {
            player.pause();
            gracefullyStopWhenMusicEnds();
            btnPlayPause.setBackgroundResource(R.drawable.ic_outline_play_circle_outline_24);
        }
    }
//here check which playlist is active

    public void playNext(View view) {

        if (shuffleFlag) {
            playShuffleNext();
        } else {
            if (playListNumber == 5) {
                currentIndex = getNextSongIndexForHome(currentIndex);
            } else if (playListNumber == 4) {
                currentIndex = getNextSongIndexForFav(currentIndex);
            } else if (playListNumber == 6) {

                currentIndex = getNextSongIndexForSearch(currentIndex);
            } else {
                currentIndex = songCollection.getNextSong(currentIndex);
            }

            displaySongBasedOnIndex(currentIndex, playListNumber);
            playSong(fileLink);
        }
    }

    public int getNextSongIndexForHome(int currentSongIndex) {
        if (currentSongIndex >= HomeFragment.listSongPlaylistHome.size() - 1) {
            return currentSongIndex;
        } else {
            return currentSongIndex + 1;
        }
    }

    public int getNextSongIndexForSearch(int currentSongIndex) {

        if (currentSongIndex >= songCollection.songPlaylistAll.length - 1) {

            return currentSongIndex;
        } else {

            return currentSongIndex + 1;
        }
    }

    public int getNextSongIndexForFav(int currentSongIndex) {
        if (currentSongIndex >= FavoriteActivity.list.size() - 1) {
            return currentSongIndex;
        } else {
            return currentSongIndex + 1;
        }
    }


    public void playPrevious(View view) {
        currentIndex = songCollection.getPrevSong(currentIndex);
        displaySongBasedOnIndex(currentIndex, playListNumber);
        playSong(fileLink);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player != null) {
            handler.removeCallbacks(p_bar);
            player.stop();
            player.release();
            player = null;
        }
    }

    public void repeatSong(View view) {
        if (repeatFlag) {
            repeatBtn.setBackgroundResource(R.drawable.repeat_off);
        } else {
            repeatBtn.setBackgroundResource(R.drawable.repeat_on);
        }
        repeatFlag = !repeatFlag;
    }

    public void shuffleFlag(View view) {
        if (shuffleFlag) {
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_off);
            songCollection = new SongCollection();
            shuffleFlag=false;
        } else {
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_on);
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);
            shuffleFlag=true;
        }

    }
}