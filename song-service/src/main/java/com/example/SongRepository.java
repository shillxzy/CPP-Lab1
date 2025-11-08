package com.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SongRepository {
    public List<Song> getAllSongs() {
        return List.of(
                new Song(1, "Song A", "Artist X", "Pop"),
                new Song(2, "Song B", "Artist Y", "Rock")
        );
    }
}
