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
//         status.setSiteId("Google");

        return new Status(httpRequestService.makeRequest());
    }
}

