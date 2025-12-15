package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SongEventConsumer {

    @Incoming("song-created-in")
    @Transactional
    public void consume(String json) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            SongCreatedEvent event = mapper.readValue(json, SongCreatedEvent.class);

            Playlist playlist = Playlist.find("name", "My Rock Playlist").firstResult();
            if (playlist == null)
            {
                System.out.println("❌ Not found 'My Rock Playlist'.");
                return;
            }

            playlist.addSong(event.id);

            System.out.println("🎵 Added song to playlist: " + event.title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
