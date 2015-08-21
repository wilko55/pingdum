package com.pingdum.database;

import com.pingdum.models.Status;

import java.util.List;

public interface StatusDao {
    public List<Status> getAllHttpCodes();
    public Status getCodesById(int siteId);
}