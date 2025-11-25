package com.example;

import com.example.clients.SongServiceClient;
import com.example.models.Song;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

@Path("/api/songs")
@Produces(MediaType.APPLICATION_JSON)
public class SongPage {

    @Inject
    @RestClient
    SongServiceClient songServiceClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> getSongs()
    {
        return songServiceClient.getAllSongs();
    }
}
