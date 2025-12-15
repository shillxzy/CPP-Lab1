package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class SongEventConsumer {

    @Incoming("song-created-in")
    public void consume(String json) {
        System.out.println("🎵 SONG CREATED (Kafka): " + json);
    }
}