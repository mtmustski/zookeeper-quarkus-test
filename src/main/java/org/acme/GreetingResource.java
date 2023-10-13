package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import io.quarkus.logging.Log;
import org.apache.zookeeper.KeeperException;

@Path("/hello")
public class GreetingResource {

    @Inject
    ZookeeperService zookeeperService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        try {
            zookeeperService.client.getData("/test", false, zookeeperService.client.exists("/test", false));
        } catch (KeeperException | InterruptedException e) {
            Log.error(e.getMessage());
        }

        return "Hello RESTEasy";
    }
}
