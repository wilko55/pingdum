package com.pingdum.app;
import com.pingdum.mongo.MongoHealthCheck;
import com.pingdum.mongo.MongoManaged;
import com.pingdum.requestResources.MakeRequest;
import com.pingdum.requestResources.RequestService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;

import java.net.UnknownHostException;

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

        Mongo mongo = new Mongo(config.mongohost, config.mongoport);
        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.lifecycle().manage(mongoManaged);

        environment.healthChecks().register("mongo", new MongoHealthCheck(mongo));
    }
}