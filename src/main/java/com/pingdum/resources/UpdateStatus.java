package com.pingdum.resources;

import com.pingdum.database.HibernateUtil;
import com.pingdum.models.Sites;
import com.pingdum.models.Status;
import com.pingdum.requestResources.HttpRequestService;
import com.pingdum.requestResources.MakeRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/updateStatus/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class UpdateStatus {

    @GET
    public Status get(@PathParam("id") int id) throws IOException {


        // get array of urls

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Criteria cr = session.createCriteria(Sites.class);
        cr.add(Restrictions.eq("id", id));
        cr.setProjection(Projections.property("url"));
        List<String> list = (List<String>) cr.list();

        String listAsString = "";

        for (String str : list) {
            listAsString += str + "\n";
        }
        System.out.println(listAsString);
        tx.commit();



        HttpRequestService httpRequestService = new HttpRequestService(listAsString);

        // scroll through array and insert that number of statuses

        Session insert = HibernateUtil.getSessionFactory().openSession();
        insert.beginTransaction();

        Status status = new Status();
        status.setSiteId(id);
        status.setStatus(new HttpRequestService(listAsString).makeRequest());

        insert.save(status);
        insert.getTransaction().commit();

        return status;
    }
}

// new class - get all urls from site ids
// run makeRequest.getStatus() for each one