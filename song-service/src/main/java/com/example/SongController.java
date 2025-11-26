package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import jakarta.inject.Inject;
import java.util.List;

@Path("/songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SongController {

    @Inject
    SongRepository repo;

    @GET
    public List<Song> getAll() {
        return repo.listAll();
    }

    @POST
    @Transactional
    public Song create(Song song) {
        repo.persist(song);
        return song;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Song update(@PathParam("id") Long id, Song data) {
        Song song = repo.findById(id);
        if(song == null) throw new NotFoundException();
        song.setTitle(data.getTitle());
        song.setArtistName(data.getArtistName());
        song.setGenre(data.getGenre());
        return song;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        repo.deleteById(id);
    }
}
