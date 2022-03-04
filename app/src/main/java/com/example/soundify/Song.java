package com.example.soundify;

public class Song {
    //states for the class
    private String id;
    private String title;
    private String artiste;
    private String fileLink;
    private double songLength;
    private int drawable;

    //Constructor to create objects from this class
    public Song(String id, String title, String artiste, String fileLink, double songLength, int drawable) {
        this.id = id;
        this.title = title;
        this.artiste = artiste;
        this.fileLink = fileLink;
        this.songLength = songLength;
        this.drawable = drawable;
    }

    public Song() {
    }

    //Get methods to get the values from the states in the objects
    public String getId() {return id;}
    public String getTitle() {return title;}
    public String getArtiste() {return artiste;}
    public String getFileLink() {return fileLink;}
    public double getSongLength() {return songLength;}
    public int getDrawable() {return drawable;}


    //Set methods to change the values of the states in the object
    public void setId(String newId) {this.id = newId;}
    public void setTitle(String newTitle) {this.title = newTitle;}
    public void setArtiste(String newArtiste) {this.artiste = newArtiste;}
    public void setFileLink(String newFileLink) {this.fileLink = newFileLink;}
    public void setSongLength(double newSongLength) {this.songLength = newSongLength;}
    public void setDrawable(int newDrawable) {this.drawable = newDrawable;}

}
