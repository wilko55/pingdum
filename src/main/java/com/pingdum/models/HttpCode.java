package com.pingdum.models;

public class HttpCode
{
    private long id;
    private int siteId;
    private int httpCode;
    private String timeStamp;

    public HttpCode( long id, int siteId, int httpCode, String timeStamp ) {
        this.id = id;
        this.siteId = siteId;
        this.httpCode = httpCode;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public int getSiteId() {
        return siteId;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setSiteId( int siteId ) {
        this.siteId = siteId;
    }

    public void getHttpCode( int httpCode ) {
        this.httpCode = httpCode;
    }

    public void getTimeStamp( String timeStamp ) {
        this.timeStamp = timeStamp;
    }
}