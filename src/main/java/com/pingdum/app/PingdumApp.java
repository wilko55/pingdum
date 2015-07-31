package com.pingdum.app;
import com.mongodb.*;
import com.pingdum.mongo.MongoHealthCheck;
import com.pingdum.mongo.MongoManaged;
import com.pingdum.requestResources.MakeRequest;
import com.pingdum.requestResources.RequestService;
import com.pingdum.resources.PingdumResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

public class PingdumApp extends Application<PingdumConfiguration> {
    public static void main(String[] args) throws Exception {
        new PingdumApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<PingdumConfiguration> pingdumConfigurationBootstrap) {
    }

    @Override
    public void run(PingdumConfiguration config, Environment environment) throws UnknownHostException {
        String defaultUrl = config.getDefaultUrl();
        RequestService requestService = new RequestService(defaultUrl);
        Mongo mongo = new MongoClient(config.mongohost, config.mongoport);
        Morphia morphia = new Morphia();

        // mongo collection takes name of defaultUrl
        DB db = new DB(mongo, "google");

        MakeRequest makeRequest = new MakeRequest(requestService, morphia, db);
        PingdumResource pingdumResource = new PingdumResource(makeRequest);
        environment.jersey().register(pingdumResource);

        Datastore datastore = morphia.createDatastore((MongoClient) mongo, "google");

        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.lifecycle().manage(mongoManaged);

        morphia.mapPackage("com.pingdum.models.Status");

        environment.healthChecks().register("mongo", new MongoHealthCheck(mongo));

        datastore.ensureIndexes();

    }
}