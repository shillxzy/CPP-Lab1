package com.example.services.song;

public class Song {
    private int id;
    private String title;
    private String artistName;
    private String genre;

    public Song(int id, String title, String artistName, String genre){
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.genre = genre;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtistName() { return artistName; }
    public String getGenre() { return genre; }
}
