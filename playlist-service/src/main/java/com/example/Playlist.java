package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Playlist extends PanacheEntity {
    public Long userId;
    public String name;
}
