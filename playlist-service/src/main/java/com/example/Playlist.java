package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist extends PanacheEntity {
    public Long userId;
    public String name;

    @ElementCollection
    @CollectionTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id")
    )
    @Column(name = "song_id")
    public Set<Long> songIds = new HashSet<>();
}
