package com.example.soundify;


import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;

public class SongCollection {

    public Song[] songs = new Song[5];
    public Song[] songPlaylist1 = new Song[5];
    public Song[] songPlaylist2 = new Song[5];
    public Song[] songPlaylist3 = new Song[5];
    public Song[] songPlaylistAll = new Song[30];


    public SongCollection() {
        Song song1 = new Song("S1001", "The way you look tonight",
                    "Michael buble", "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                    4.66, R.drawable.the_way_you_look_tonight);


        Song song2 = new Song("S1002", "Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/f504e6b8e037771318656394f532dede4f9bcaea?cid=2afe87a64b0042dabf51f37318616965",
                4.9, R.drawable.billie_jean);

        Song song3 = new Song("S1003", "Photograph",
                "Ed sheeran",
                "https://p.scdn.co/mp3-preview/097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965",
                4.32, R.drawable.photograph);


        Song song4 = new Song("S1004", "mankyman",
                "MrHeadA$$Trendy",
                "https://p.scdn.co/mp3-preview/70c4538a74d06030c8f95dcfd5715b9298b4d9df?cid=2afe87a64b0042dabf51f37318616965",
                2.19, R.drawable.mankyman);


        Song song5 = new Song("S1005", "First date",
                "frad",
                "https://p.scdn.co/mp3-preview/0e3d24ca0e9c8210a692556d92b69fbf6641995c?cid=2afe87a64b0042dabf51f37318616965",
                2.89, R.drawable.first_date);

        Song song6 = new Song("S1006", "Bossa_uh",
                "Potsu",
                "https://p.scdn.co/mp3-preview/8d786c301bbdb569a944a2819a8a8a927d86ebcb?cid=2afe87a64b0042dabf51f37318616965",
                3.5, R.drawable.bosaa_uh);

        Song song7 = new Song("S1007", "Plain plaid purple morning",
                "biosphere",
                "https://p.scdn.co/mp3-preview/e32aabb04d78a042e8218814a9b070a82d2980e5?cid=2afe87a64b0042dabf51f37318616965",
                2.25, R.drawable.plain_plaid_purple_morning);

        Song song8 = new Song("S1008", "Somnolent nova",
                " City Girl",
                "https://p.scdn.co/mp3-preview/fd5c249a13adb2bbe08cfa728be49a433232df06?cid=2afe87a64b0042dabf51f37318616965",
                3.05, R.drawable.somnolent_nova);

        Song song9 = new Song("S1009", "Just friends",
                "potsu",
                "https://p.scdn.co/mp3-preview/76511fa8aaeebda4a754b03f12a6362eda2bdd82?cid=2afe87a64b0042dabf51f37318616965",
                2.88, R.drawable.just_friends);

        Song song10 = new Song("S10010", "Ji Eun's Sunset",
                "City Girl",
                "https://p.scdn.co/mp3-preview/c89da34f6eba97d4626262817b1d792c14297637?cid=2afe87a64b0042dabf51f37318616965",
                2.81, R.drawable.ji_eun);

        Song song11 = new Song("S10011", "777",
                "Joji",
                "https://p.scdn.co/mp3-preview/c6befc7dd58d922eb8c9b83d1f871bb18ba63258?cid=2afe87a64b0042dabf51f37318616965",
                3.03, R.drawable.triple_seven);

        Song song12= new Song("S10012", "Do me right",
                "brb",
                "https://p.scdn.co/mp3-preview/f097deebf40a7ba67926e594ca3321efc68eb729?cid=2afe87a64b0042dabf51f37318616965",
                2.98, R.drawable.do_me_right);

        Song song13 = new Song("S10013", "I think too much",
                "Christian French",
                "https://p.scdn.co/mp3-preview/95ea10775884874ed9fa980823b29ccf1cc66e03?cid=2afe87a64b0042dabf51f37318616965",
                3.38, R.drawable.i_think_too_much);

        Song song14 = new Song("S10014", "All I need",
                "Khai dreams",
                "https://p.scdn.co/mp3-preview/a18a1bef1a27bea2e5c5a7aa2023b06f47f93a11?cid=2afe87a64b0042dabf51f37318616965",
                2.47, R.drawable.all_i_need);

        Song song15 = new Song("S10015", "lemonade",
                "Zamir",
                "https://p.scdn.co/mp3-preview/48d471984897608e5bc93cdd035e4f65329f4cce?cid=2afe87a64b0042dabf51f37318616965",
                3.03, R.drawable.lemonade);

        Song song16 = new Song("S10016", "Fuccboi Lullaby",
                "LAUSSE THE CAT",
                "https://p.scdn.co/mp3-preview/e901d5372f71c44a991a1198903b1e6648d27f88?cid=2afe87a64b0042dabf51f37318616965",
                4.12, R.drawable.fuccboi_lullaby);

        Song song17 = new Song("S10017", "Redstripe Rhapsody",
                "LAUSSE THE CAT",
                "https://p.scdn.co/mp3-preview/c73a165102c7f2d84ff499b07db9be8c4b838a96?cid=2afe87a64b0042dabf51f37318616965",
                3.54, R.drawable.redstripe_rhapsody);

        Song song18 = new Song("S10018", "Toy's Story",
                "LAUSSE THE CAT",
                "https://p.scdn.co/mp3-preview/87de3eea276fb19531e7f14da0fe32f0a2f8e9d7?cid=2afe87a64b0042dabf51f37318616965",
                8, R.drawable.toys_story);

        Song song19 = new Song("S10019", "If You Wouldn't Mind",
                "2nd Exit",
                "https://p.scdn.co/mp3-preview/df04ee34ab450e2aca091b78b991c2c3707d427c?cid=2afe87a64b0042dabf51f37318616965",
                3.97, R.drawable.if_you_wouldnt_mind);

        Song song20 = new Song("S10020", "Talk About Us",
                "Kofi Stone, Loyle Carner",
                "https://p.scdn.co/mp3-preview/086f22cc4cca55a931713f24fa63d93e3d6a969a?cid=2afe87a64b0042dabf51f37318616965",
                3.26, R.drawable.talk_about_us);

        Song song21 = new Song("S10021", "Emocean",
                "Bel Cobain",
                "https://p.scdn.co/mp3-preview/ed3c1545ae81cce3fe04d5df9853b16241dbfd76?cid=2afe87a64b0042dabf51f37318616965",
                3.14, R.drawable.emocean);

        Song song22 = new Song("S10022", "Double take",
                "dhruv",
                "https://p.scdn.co/mp3-preview/5f6cf85d696b35726841fe6b26d10b921f84e424?cid=2afe87a64b0042dabf51f37318616965",
                2.86, R.drawable.double_take);

        Song song23 = new Song("S10023", "Shouldn't Be",
                "Luke Chiang",
                "https://p.scdn.co/mp3-preview/129319922caddd7dce0520554cfc5fe84481b51c?cid=2afe87a64b0042dabf51f37318616965",
                3.51, R.drawable.shouldnt_be);

        Song song24 = new Song("S10017", "Why don't you love me",
                "slchld",
                "https://p.scdn.co/mp3-preview/bcf2ac7f2db44007d30d7828720a2f210e909871?cid=2afe87a64b0042dabf51f37318616965",
                3.01, R.drawable.why_dont_you_love_me);

        Song song25 = new Song("S10025", "Butterflies",
                "Samsa",
                "https://p.scdn.co/mp3-preview/5afef668840c0bcad19c40dfd4cce41a6662ab15?cid=2afe87a64b0042dabf51f37318616965",
                3.32, R.drawable.butterflies);

        Song song26 = new Song("S10026", "G.O.A.T",
                "Polyphia",
                "https://p.scdn.co/mp3-preview/86b55cd41e98f1fd272d764adb08cd6fc45715b2?cid=2afe87a64b0042dabf51f37318616965",
                3.59, R.drawable.goat);

        Song song27 = new Song("S10027", "So Strange",
                "Polyphia",
                "https://p.scdn.co/mp3-preview/b55ff92dca352dc030a7a9ff1386d625c963410b?cid=2afe87a64b0042dabf51f37318616965",
                4, R.drawable.so_strange);

        Song song28 = new Song("S10028" , "thinking of you",
                "Nito",
                "https://p.scdn.co/mp3-preview/953c07d854d89c3d604663a816593dbbe68c8fc0?cid=2afe87a64b0042dabf51f37318616965",
                1.88, R.drawable.thinking_of_you);

        Song song29 = new Song("S10029", "Lost" ,
                "Nito",
                "https://p.scdn.co/mp3-preview/e66f073c4733bc01b254d210035e73a4c8f4ac69?cid=2afe87a64b0042dabf51f37318616965",
                2.05, R.drawable.lost);

        Song song30 = new Song("S10030" , "syrupy",
                "ichika" ,
                "https://p.scdn.co/mp3-preview/6c40bc64a400b44c5893d2641137b71c2497d956?cid=2afe87a64b0042dabf51f37318616965",
                2.82, R.drawable.syrupsy);



        songPlaylist1[0]=song1;
        songPlaylist1[1]=song2;
        songPlaylist1[2]=song3;
        songPlaylist1[3]=song4;
        songPlaylist1[4]=song5;


        songPlaylist2[0]=song6;
        songPlaylist2[1]=song7;
        songPlaylist2[2]=song8;
        songPlaylist2[3]=song9;
        songPlaylist2[4]=song10;

        songPlaylist3[0]=song11;
        songPlaylist3[1]=song12;
        songPlaylist3[2]=song13;
        songPlaylist3[3]=song14;
        songPlaylist3[4]=song15;

        songPlaylist3[0]=song11;
        songPlaylist3[1]=song12;
        songPlaylist3[2]=song13;
        songPlaylist3[3]=song14;
        songPlaylist3[4]=song15;


        songPlaylistAll[0]=song1;
        songPlaylistAll[1]=song2;
        songPlaylistAll[2]=song3;
        songPlaylistAll[3]=song4;
        songPlaylistAll[4]=song5;
        songPlaylistAll[5]=song6;
        songPlaylistAll[6]=song7;
        songPlaylistAll[7]=song8;
        songPlaylistAll[8]=song9;
        songPlaylistAll[9]=song10;
        songPlaylistAll[10]=song11;
        songPlaylistAll[11]=song12;
        songPlaylistAll[12]=song13;
        songPlaylistAll[13]=song14;
        songPlaylistAll[14]=song15;
        songPlaylistAll[15]=song16;
        songPlaylistAll[16]=song17;
        songPlaylistAll[17]=song18;
        songPlaylistAll[18]=song19;
        songPlaylistAll[19]=song20;
        songPlaylistAll[20]=song21;
        songPlaylistAll[21]=song22;
        songPlaylistAll[22]=song23;
        songPlaylistAll[23]=song24;
        songPlaylistAll[24]=song25;
        songPlaylistAll[25]=song26;
        songPlaylistAll[26]=song27;
        songPlaylistAll[27]=song28;
        songPlaylistAll[28]=song29;
        songPlaylistAll[29]=song30;
    }


   public Song getCurrentSong(int currentSongId){

        return songs[currentSongId];

    }


    public int searchSongById(String id) {
        for(int index = 0; index < songs.length; index++) {
            Song tempsong = songs[index];
            if(tempsong.getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    public int getNextSong(int currentSongIndex) {
        if (currentSongIndex >= songs.length-1) {
            return currentSongIndex;
        }
        else {
            return  currentSongIndex+1;
        }
    }
    public int getPrevSong(int currentSongIndex) {
        if (currentSongIndex<= 0){
            return currentSongIndex;
        }
        else {
            return  currentSongIndex-1 ;
        }
    }

    public int getSongPostionForSearch(String id) {
        int postion = 0;
       for (int i=0;i<songPlaylistAll.length;i++)
       {
           if(id==songPlaylistAll[i].getId())
           {
               postion=i;
           }
       }
       return postion;
    }
}
