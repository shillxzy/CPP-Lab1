package com.example;

import com.example.clients.PlaylistServiceClient;
import com.example.models.Playlist;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

@Path("/api/playlists")
public class PlaylistPage
{

    @Inject
    @RestClient
    PlaylistServiceClient playlistServiceClient;

    @GET
    @Path("/api/playlists")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getPlaylists(@Context SecurityContext sec) {
        int userId = 1;
        return playlistServiceClient.getPlaylistsByUser(userId);
    }

}
