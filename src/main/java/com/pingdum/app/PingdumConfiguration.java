package com.pingdum.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class PingdumConfiguration extends Configuration {

    @Valid
    @NotNull

    @JsonProperty
    private int statusCode;

    @JsonProperty
    public int getStatusCode() {
        return statusCode;
    }

};