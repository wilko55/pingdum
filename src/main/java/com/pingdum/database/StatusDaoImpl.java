package com.pingdum.database;

import com.pingdum.models.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusDaoImpl implements StatusDao {

    //list is working as a database
    List<Status> statuses;

    public StatusDaoImpl() {
        statuses = new ArrayList<Status>();
    }

    @Override
    public List<Status> getAllHttpCodes() {
        return statuses;
    }

    @Override
    public Status getCodesById(int siteId) {
        return statuses.get(siteId);
    }
}