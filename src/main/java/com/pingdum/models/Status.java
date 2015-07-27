package com.pingdum.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {

    @JsonProperty
    private final int status;

    public Status(int status){
        this.status = status;
    }

}
