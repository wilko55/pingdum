package com.pingdum.database;

import com.pingdum.models.HttpCode;

import java.util.ArrayList;
import java.util.List;

public class HttpCodeDaoImpl implements HttpCodeDao {

    //list is working as a database
    List<HttpCode> httpCodes;

    public HttpCodeDaoImpl() {
        httpCodes = new ArrayList<HttpCode>();
    }

    @Override
    public List<HttpCode> getAllHttpCodes() {
        return httpCodes;
    }

    @Override
    public HttpCode getCodesById(int siteId) {
        return httpCodes.get(siteId);
    }
}