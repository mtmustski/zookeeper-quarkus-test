package org.acme;

import java.nio.charset.StandardCharsets;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    ZookeeperService zookeeperService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return new String(zookeeperService.getData("/test"), StandardCharsets.UTF_8);
    }
}
