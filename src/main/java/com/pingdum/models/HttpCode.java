package com.pingdum.models;

public class HttpCode
{
    private long id;
    private int siteId;
    private int httpCode;
    private String timeStamp;

    public SampleModel( long id, String name, String data ) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setData( String data ) {
        this.data = data;
    }
}