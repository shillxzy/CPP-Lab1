package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class PlaylistSongs extends PanacheEntity {
    public Long playlistId;
    public Long songId;
}
