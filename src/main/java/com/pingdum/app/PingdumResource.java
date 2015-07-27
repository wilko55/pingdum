package com.pingdum.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pingdum.models.Status;
import com.pingdum.requestResources.MakeRequest;

import java.io.IOException;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PingdumResource {

    private final MakeRequest makeRequest;

    public PingdumResource(MakeRequest makeRequest) {
        this.makeRequest = makeRequest;
    }

    @GET
    public Status test() throws IOException {
        return makeRequest.getStatus();
    }

}
