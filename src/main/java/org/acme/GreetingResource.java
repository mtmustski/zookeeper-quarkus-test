package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.annotation.PostConstruct;
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
            zookeeperService.getClient().getData("/test", false, zookeeperService.getClient().exists("/test", false));
        } catch (KeeperException | InterruptedException e) {
            Log.error(e.getMessage());
        }

        return "Hello RESTEasy";
    }
}
