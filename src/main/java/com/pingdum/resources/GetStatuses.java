package com.pingdum.resources;

import com.codahale.metrics.annotation.Timed;
import com.pingdum.database.HibernateUtil;
import com.pingdum.models.HttpCode;
import com.pingdum.models.Status;
import com.pingdum.requestResources.MakeRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/getCodes/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class GetStatuses {
    @GET
    public List get(@PathParam("id") int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Criteria cr = session.createCriteria(Status.class);
        cr.add(Restrictions.eq("siteId", id));
        List results = cr.list();

        System.out.println(results);
        tx.commit();
        return results;
    }

}


