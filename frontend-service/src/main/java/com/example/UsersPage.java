package com.example;

import com.example.clients.UserServiceClient;
import com.example.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

@Path("/api/users")
public class UsersPage {

    @Inject
    @RestClient
    UserServiceClient userServiceClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userServiceClient.getAllUsers();
    }
}
