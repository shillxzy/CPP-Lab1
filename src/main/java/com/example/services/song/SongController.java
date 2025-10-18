package com.example.services.song;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import java.util.List;

@Path("/songs")
@Produces(MediaType.APPLICATION_JSON)
public class SongController {

    @Inject
    SongRepository songRepository;

    @GET
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }
}
