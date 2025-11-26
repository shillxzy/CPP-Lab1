package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistController {

    @GET
    public List<Artist> getAll() {
        return Artist.listAll();
    }

    @POST
    @Transactional
    public Artist create(Artist artist) {
        artist.persist();
        return artist;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Artist update(@PathParam("id") Long id, Artist data) {
        Artist a = Artist.findById(id);
        if (a == null) throw new NotFoundException();
        a.name = data.name;
        a.genre = data.genre;
        return a;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Artist.deleteById(id);
    }
}
