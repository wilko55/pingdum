package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pingdum.requestResources.HttpRequestService;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.io.IOException;

@Entity("sites")
public class Sites {

    @Id
    private int id;

    @JsonProperty
    private String url;
    private String apiName;
    private int lastStatus;


    public Sites() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiName() { return apiName; }

    public void setApiName(String apiName) { this.apiName = apiName; }

    public int getLastStatus() throws IOException {

        lastStatus = new HttpRequestService(url).makeRequest();

        return lastStatus;
    }

}

