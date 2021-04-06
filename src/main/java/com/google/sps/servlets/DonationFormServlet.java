package com.google.sps.servlets;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.KeyFactory;
import com.google.gson.Gson;
import org.eclipse.jetty.util.thread.Scheduler.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/donation-form")
public class DonationFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Donation form info
      String name = request.getParameter("name");
      String location = request.getParameter("location");
      String item = request.getParameter("item");
      String number = request.getParameter("number");
    
      Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
      KeyFactory keyFactory = datastore.newKeyFactory().setKind("Listing");
      FullEntity listingEntity = Entity.newBuilder(keyFactory.newKey())
         .set("name", name)
        .set("location", location)
        .set("item", item)
        .set("number", number)
        .build();
      datastore.put(listingEntity);

    response.sendRedirect("/index.html");
  }

}