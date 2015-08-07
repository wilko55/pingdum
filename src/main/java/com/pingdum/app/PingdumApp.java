package com.pingdum.app;
import com.pingdum.models.Status;
import com.pingdum.requestResources.HttpRequestService;
import com.pingdum.requestResources.MakeRequest;
import com.pingdum.resources.PingdumResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.net.UnknownHostException;
import java.sql.SQLException;

public class PingdumApp extends Application<PingdumConfiguration> {
    public static void main(String[] args) throws Exception {
        new PingdumApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<PingdumConfiguration> pingdumConfigurationBootstrap) {
        pingdumConfigurationBootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    @Override
    public void run(PingdumConfiguration config, Environment environment) throws UnknownHostException, SQLException {

        String defaultUrl = config.getDefaultUrl();
        HttpRequestService httpRequestService = new HttpRequestService(defaultUrl);

        MakeRequest makeRequest = new MakeRequest(httpRequestService);
        PingdumResource pingdumResource = new PingdumResource(makeRequest);
        environment.jersey().register(pingdumResource);

    }
}
