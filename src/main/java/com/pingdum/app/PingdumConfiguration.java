package com.pingdum.app;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class PingdumConfiguration extends Configuration {

    @Valid
    @NotNull

    @NotEmpty
    @JsonProperty
    private String defaultUrl;

    @JsonProperty
    private int statusCode;

    @JsonProperty
    public int getStatusCode() {
        return statusCode;
    }

    @JsonProperty
    public String getDefaultUrl() {
        return defaultUrl;
    }

};