package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    public List<User> getAll() {
        return User.listAll();
    }

    @POST
    @Transactional
    public User create(User user) {
        user.persist();
        return user;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public User update(@PathParam("id") Long id, User data) {
        User u = User.findById(id);
        if (u == null) throw new NotFoundException();
        u.username = data.username;
        u.email = data.email;
        return u;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        User.deleteById(id);
    }
}
