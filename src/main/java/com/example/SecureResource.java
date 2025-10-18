package com.example;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/secure")
public class SecureResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("user")
    public String helloSecure() {
        return "Це захищений ресурс! Доступ лише з токеном.";
    }
}
