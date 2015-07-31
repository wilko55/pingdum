package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("status")
public class Status {

    @Id
    private ObjectId id;

    @JsonProperty
    private final int status;

    public Status(int status){
        this.status = status;
    }

}
