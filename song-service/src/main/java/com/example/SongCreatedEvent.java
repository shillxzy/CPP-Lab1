package com.example;

public class SongCreatedEvent {

    public Long id;
    public String title;
    public String artistName;
    public String genre;

    public SongCreatedEvent() {}

    public SongCreatedEvent(Long id, String title, String artistName, String genre) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.genre = genre;
    }

}