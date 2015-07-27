package com.pingdum.requestResources;
import com.pingdum.models.Status;
import com.pingdum.requestResources.RequestService;
import jdk.nashorn.internal.ir.RuntimeNode;
import java.io.IOException;

public class MakeRequest {

    private final RequestService requestService;

    public MakeRequest(RequestService requestService) {

        this.requestService = requestService;
    }

    public Status getStatus() throws IOException {

        return new Status(requestService.makeRequest());
    }
}

