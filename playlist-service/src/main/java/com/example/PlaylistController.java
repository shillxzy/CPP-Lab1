package com.example.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
public class PlaylistController {

    @Inject
    PlaylistRepository playlistRepository;

    @GET
    @Path("/{userId}")
    public List<Playlist> getPlaylistsByUser(@PathParam("userId") int userId) {
        return playlistRepository.getAllPlaylists().stream()
                .filter(p -> p.getUserId() == userId)
                .collect(Collectors.toList());
    }
}
