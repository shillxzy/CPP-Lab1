package com.example.clients;

import com.example.models.Playlist;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@RegisterRestClient(configKey = "com.example.clients.PlaylistServiceClient")
@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PlaylistServiceClient
{

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Playlist> getPlaylistsByUser(@PathParam("userId") int userId);

}
