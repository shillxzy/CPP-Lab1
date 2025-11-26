package com.example;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SongRepository implements PanacheRepository<Song> {

    // можна додати кастомні методи
    public List<Song> findByGenre(String genre){
        return list("genre", genre);
    }
}
