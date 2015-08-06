package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity("status")
public class Status {

    @Id
    private ObjectId id;

    @JsonProperty
    private int status;
    @JsonProperty
    private String siteId;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public Status(int status){
        this.status = status;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

}
//
//        import java.util.Date;
//
//@Entity("status")
//public class Status {
//
//    @JsonProperty
//    private int id;
//    private long siteId;
//    private int status;
//    private Date timeStamp;
//
//    public int getId() {
//        return id;
//    }
//
//    private void setId(int id){
//        this.id = id;
//    }
//
//    public Status(int status){
//        this.status = status;
//    }
//
//    public Long getSiteId() {
//        return siteId;
//    }
//
//    private void setSiteId(Long siteId) {
//        this.siteId = siteId;
//    }
//
//    public Date getDate() {
//        return timeStamp;
//    }
//
//    public void setDate(Date timeStamp) {
//        this.timeStamp = timeStamp;
//    }