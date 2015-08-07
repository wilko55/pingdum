package com.pingdum.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Status1 implements Serializable {

    private int id;
    private int status;
    private int siteId;
    private String apiName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Status1(int status){
        this.status = status;
    }

    public String getApiNasme() { return apiName; }
    public void setApiName(String apiName) { this.apiName = apiName; }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
}