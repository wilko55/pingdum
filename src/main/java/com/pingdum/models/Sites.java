package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("sites")
public class Sites {

    @Id
    private int id;

    @JsonProperty
    private String url;
    private String apiName;


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

}

