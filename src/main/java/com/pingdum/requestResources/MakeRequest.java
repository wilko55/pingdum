package com.pingdum.requestResources;
import com.pingdum.models.Status;

import java.io.IOException;

public class MakeRequest {

    private final HttpRequestService httpRequestService;

    public MakeRequest(HttpRequestService httpRequestService) {

        this.httpRequestService = httpRequestService;
    }

    public Status getStatus() throws IOException {

         Status status = new Status(httpRequestService.makeRequest());

        // check db to get api name from siteId
         status.setSiteId(2);
        status.setApiName("google.com");

        return status;
    }
}

