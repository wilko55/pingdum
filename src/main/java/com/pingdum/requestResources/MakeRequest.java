package com.pingdum.requestResources;
import com.pingdum.database.HibernateUtil;
import com.pingdum.models.Status;
import org.hibernate.Session;

import java.io.IOException;

public class MakeRequest {

    private final HttpRequestService httpRequestService;

    public MakeRequest(HttpRequestService httpRequestService) {

        this.httpRequestService = httpRequestService;
    }

    public Status getStatus() throws IOException {


        // check db to get api name from siteId


        System.out.println("Maven + Hibernate + MySQL");

        Status status = new Status(httpRequestService.makeRequest());

        status.setSiteId(2);
        status.setApiName("google.com");

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            int id = (Integer) session.save(status);
            session.getTransaction().commit();

            System.out.println(id);
        return status;
    }
}

