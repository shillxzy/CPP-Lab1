package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PlaylistRepository {
    public List<Playlist> getAllPlaylists() {
        return List.of(
                new Playlist(1, 1, "Favorites", List.of(1, 2)),
                new Playlist(2, 2, "Rock Hits", List.of(2))
        );
    }
}
