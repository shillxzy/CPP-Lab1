package com.example;

import com.example.clients.PlaylistServiceClient;
import com.example.clients.SongServiceClient;
import com.example.clients.UserServiceClient;
import com.example.models.Playlist;
import com.example.models.Song;
import com.example.models.User;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;
import java.util.List;

@Path("/")
public class FrontendResource {

    @Inject
    @Location("Musicfy.html")
    Template musicfy;

    @Inject
    @RestClient
    UserServiceClient userServiceClient;

    @Inject
    @RestClient
    PlaylistServiceClient playlistServiceClient;

    @Inject
    @RestClient
    SongServiceClient songServiceClient;

    @Inject
    @Location("Users.html")
    Template usersTemplate;

    @Inject
    @Location("Songs.html")
    Template songsTemplate;

    @GET
    @Path("/users")
    @Authenticated
    @Produces(MediaType.TEXT_HTML)
    public String usersPage() {
        List<User> users = userServiceClient.getAllUsers();
        return usersTemplate
                .data("users", users)
                .render();
    }

    @GET
    @Path("/songs")
    @Authenticated
    @Produces(MediaType.TEXT_HTML)
    public String songsPage(@Context SecurityContext sec) {
        String username = sec.getUserPrincipal() != null ? sec.getUserPrincipal().getName() : "Гість";

        List<Song> songs = songServiceClient.getAllSongs();

        return songsTemplate
                .data("user", username)
                .data("songs", songs)
                .render();
    }




    @GET
    @Path("/app")
    @Authenticated
    @Produces(MediaType.TEXT_HTML)
    public String dashboard(@Context SecurityContext sec) {
        String username = sec.getUserPrincipal() != null ? sec.getUserPrincipal().getName() : "Гість";
        List<Song> songs = songServiceClient.getAllSongs();

        return musicfy
                .data("user", username)
                .data("songs", songs)
                .render();
    }


    @GET
    @Path("/logout")
    public Response logout()
    {
        return Response.seeOther(URI.create("/login")).build();
    }




    @GET
    @Path("/")
    public Response home() {
        return Response.seeOther(URI.create("/app")).build();
    }
}
