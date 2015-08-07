package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Date;

@Entity
@Table(name="statuses",
        uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Status1 {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="status", length=20, nullable=true)
    private int status;

    @Column(name="siteId", length=20, nullable=true)
    private int siteId;

    @Column(name="apiName", nullable=true)
    private String apiName;

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
