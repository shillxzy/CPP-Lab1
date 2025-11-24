package com.example;

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

import java.net.URI;

@Path("/")
public class FrontendResource {

    @Inject
    @Location("Musicfy.html")
    Template musicfy;

    @GET
    @Path("/app")
    @Authenticated
    @Produces(MediaType.TEXT_HTML)
    public String dashboard(@Context SecurityContext sec) {
        String username = sec.getUserPrincipal() != null ? sec.getUserPrincipal().getName() : "Гість";
        return musicfy.data("user", username).render();
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
