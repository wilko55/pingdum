package com.pingdum.database;

import com.pingdum.models.HttpCode;

import java.util.List;

public interface HttpCodeDao {
    public List<HttpCode> getAllHttpCodes();
    public HttpCode getCodesById(int siteId);
}