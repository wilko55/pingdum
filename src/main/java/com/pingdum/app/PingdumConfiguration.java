package com.pingdum.app;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class PingdumConfiguration extends Configuration {

    @Valid
    @NotNull
//    @JsonProperty
//    private DataSourceFactory database = new DataSourceFactory();
//
//    @JsonProperty("database")
//    public DataSourceFactory getDataSourceFactory() {
//        return database;
//    }

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