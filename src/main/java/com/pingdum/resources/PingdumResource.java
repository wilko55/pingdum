package com.pingdum.resources;

import com.codahale.metrics.annotation.Timed;
import com.pingdum.models.Status;
import com.pingdum.requestResources.MakeRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PingdumResource {

    private final MakeRequest makeRequest;

    public PingdumResource(MakeRequest makeRequest) {
        this.makeRequest = makeRequest;
    }

    @GET
    public List test() throws IOException {
        return makeRequest.getUrls();
    }

}


