package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class SongEventProducer {

    @Inject
    @Channel("song-created-out")
    Emitter<String> emitter;

    @Inject
    ObjectMapper objectMapper;

    public void sendSongCreated(com.example.Song song) {
        try {
            SongCreatedEvent event = new SongCreatedEvent(
                    song.getId(),
                    song.getTitle(),
                    song.getArtistName(),
                    song.getGenre()
            );
            String json = objectMapper.writeValueAsString(event);
            emitter.send(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
