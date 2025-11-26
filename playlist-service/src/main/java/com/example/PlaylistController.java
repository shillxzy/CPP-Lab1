package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlaylistController {

    @GET
    public List<Playlist> getAll() {
        return Playlist.listAll();
    }

    @POST
    @Transactional
    public Playlist create(Playlist playlist) {
        playlist.persist();
        return playlist;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Playlist update(@PathParam("id") Long id, Playlist data) {
        Playlist p = Playlist.findById(id);
        if (p == null) throw new NotFoundException();
        p.userId = data.userId;
        p.name = data.name;
        return p;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Playlist.deleteById(id);
    }
}
