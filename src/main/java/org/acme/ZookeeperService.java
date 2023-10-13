package org.acme;

import io.quarkus.arc.AsyncObserverExceptionHandler;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.enterprise.inject.spi.EventContext;
import jakarta.enterprise.inject.spi.ObserverMethod;
import jakarta.inject.Inject;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;

@ApplicationScoped
public class ZookeeperService implements AsyncObserverExceptionHandler {

    @Inject
    ZooKeeper client;

    public void onZKEvent(@ObservesAsync WatchedEvent event) {
        Log.infof("Receiving [%s]", event.getState());
    }

    @Override
    public void handle(Throwable throwable, ObserverMethod<?> observerMethod, EventContext<?> eventContext) {
    }
}