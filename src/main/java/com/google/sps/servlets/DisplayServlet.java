package com.google.sps.servlets;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.KeyFactory;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML.Tag;

@WebServlet("/input")
public class Input extends HttpServlet {
    
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    Query<Entity> query = Query.newEntityQueryBuilder()
    .setKind("Listing")
    .build();
    QueryResults<Entity> results = datastore.run(query);

    List<Task> lists = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();

      String name = entity.getString("name");
      long location = entity.getLong("location");
      String item = entity.getString("item");
      long number = entity.getLong("number");

      Task list = new Task(name, location, item, number);
      lists.add(list);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(lists));
  }
}
