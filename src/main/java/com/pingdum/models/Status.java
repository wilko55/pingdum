package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity("status")
public class Status {

    @Id
    private int id;

    @JsonProperty
    private int status;
    private int siteId;
    private String apiName;


    public Status() {
    }

//    public Status(int status) {
//        this.status = status;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

//    public void setTimeStamp();
//    public String getTimeStamp(String timeStamp) { this.timeStamp = timeStamp; }

    public void setStatus(int status) {
        this.status = status;
    }

    public Status(int status){
        this.status = status;
    }

    public String getApiName() { return apiName; }
    public void setApiName(String apiName) { this.apiName = apiName; }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

}
