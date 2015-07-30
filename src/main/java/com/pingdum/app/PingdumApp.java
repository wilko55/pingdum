package com.pingdum.app;
import com.mongodb.*;
import com.pingdum.mongo.MongoHealthCheck;
import com.pingdum.mongo.MongoManaged;
import com.pingdum.requestResources.MakeRequest;
import com.pingdum.requestResources.RequestService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class PingdumApp extends Application<PingdumConfiguration> {
    public static void main(String[] args) throws Exception {
        Mongo mongo = new Mongo();
        DB db = mongo.getDB("pingdumDb");
        DBCollection data = db.getCollection("data");
        new PingdumApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<PingdumConfiguration> pingdumConfigurationBootstrap) {
    }

    @Override
    public void run(PingdumConfiguration config, Environment environment) throws UnknownHostException {
        String defaultUrl = config.getDefaultUrl();
        RequestService requestService = new RequestService(defaultUrl);
        MakeRequest makeRequest = new MakeRequest(requestService);
        PingdumResource pingdumResource = new PingdumResource(makeRequest);
        environment.jersey().register(pingdumResource);

        String dbName = new String("bank");
        Mongo mongo = new MongoClient(config.mongohost, config.mongoport);
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore((MongoClient) mongo, defaultUrl);

        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.lifecycle().manage(mongoManaged);

        morphia.mapPackage("com.pingdum.entity");

        environment.healthChecks().register("mongo", new MongoHealthCheck(mongo));

        datastore.ensureIndexes();

    }
}