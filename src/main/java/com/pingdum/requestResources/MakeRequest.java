package com.pingdum.requestResources;
import com.pingdum.database.HibernateUtil;
import com.pingdum.models.Sites;
import com.pingdum.models.Status;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.List;

public class MakeRequest {

    private final HttpRequestService httpRequestService;

    public MakeRequest(HttpRequestService httpRequestService) {

        this.httpRequestService = httpRequestService;
    }



    public List getUrls() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Criteria cr = session.createCriteria(Sites.class);
        cr.setProjection(Projections.property("url"));
        List results = cr.list();
        System.out.println(results);
        tx.commit();
        return results;
    }

    public Status getStatus() throws IOException {

        Status status = new Status();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        int id = (Integer) session.save(status);
        session.getTransaction().commit();

        System.out.println(id);
        return status;
    }
}

