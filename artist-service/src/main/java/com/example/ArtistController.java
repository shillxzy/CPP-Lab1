package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import java.util.List;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
public class ArtistController {

    @Inject
    ArtistRepository artistRepository;

    @GET
    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }
}
