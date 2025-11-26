package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/playlist-songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlaylistSongsController {

    @GET
    public List<PlaylistSongs> getAll() {
        return PlaylistSongs.listAll();
    }

    @POST
    @Transactional
    public PlaylistSongs create(PlaylistSongs ps) {
        ps.persist();
        return ps;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        PlaylistSongs.deleteById(id);
    }
}
