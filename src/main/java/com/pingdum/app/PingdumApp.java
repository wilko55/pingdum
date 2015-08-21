package com.pingdum.app;
import com.pingdum.resources.ApiList;
import com.pingdum.resources.GetStatuses;
import com.pingdum.resources.UpdateStatus;
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

        GetStatuses getStatus = new GetStatuses();
        ApiList apiList = new ApiList();
        UpdateStatus updateStatus = new UpdateStatus();
        environment.jersey().register(getStatus);
        environment.jersey().register(apiList);
        environment.jersey().register(updateStatus);

    }
}
