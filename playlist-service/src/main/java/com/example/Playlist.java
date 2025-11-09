package com.example;

import java.util.List;

public class Playlist {
    private int id;
    private int userId;
    private String name;
    private List<Integer> songIds; // зберігаємо ID пісень

    public Playlist(int id, int userId, String name, List<Integer> songIds){
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.songIds = songIds;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Integer> getSongIds() { return songIds; }
}
