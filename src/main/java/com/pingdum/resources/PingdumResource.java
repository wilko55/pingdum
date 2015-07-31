package com.pingdum.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.pingdum.models.Status;
import com.pingdum.requestResources.MakeRequest;
import org.mongodb.morphia.Morphia;

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

//    @GET
//    @Path("/mongo")
//    @Produces("application/json")
//    public Status findAll(@PathParam("status") String status) {
//        return db.findAll(Status);
//    }

}


