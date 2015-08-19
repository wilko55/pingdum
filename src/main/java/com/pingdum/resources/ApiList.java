package com.pingdum.resources;

import com.codahale.metrics.annotation.Timed;
import com.pingdum.database.HibernateUtil;
import com.pingdum.models.Sites;
import com.pingdum.models.Status;
import com.pingdum.requestResources.MakeRequest;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Path("/apilist")
@Produces(MediaType.APPLICATION_JSON)
public class ApiList {

    @GET
    public List get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Criteria cr = session.createCriteria(Sites.class);
        List results = cr.list();

        System.out.println(results);
        tx.commit();
        return results;
    }

}


