package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ArtistRepository {
    public List<Artist> getAllArtists() {
        return List.of(
                new Artist(1, "Artist X", "Pop"),
                new Artist(2, "Artist Y", "Rock")
        );
    }
}
