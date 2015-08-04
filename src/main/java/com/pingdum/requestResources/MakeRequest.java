package com.pingdum.requestResources;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.pingdum.models.Status;
import org.mongodb.morphia.Morphia;

import java.io.IOException;

public class MakeRequest {

    private final HttpRequestService httpRequestService;

    public MakeRequest(HttpRequestService httpRequestService, Morphia morphia, DB db) {

        this.httpRequestService = httpRequestService;
        this.morphia = morphia;
        this.db = db;
    }

    private final Morphia morphia;
    private final DB db;

    public Status getStatus() throws IOException {

        // create new status object from makeRequest
         Status status = new Status(httpRequestService.makeRequest());

        // map the status model to a Mongo DBObject
        DBObject statusDBObject = morphia.toDBObject(status);

        // save to db
        db.getCollection("status").save(statusDBObject);

        return new Status(httpRequestService.makeRequest());
    }
}

