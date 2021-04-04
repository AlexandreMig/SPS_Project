package com.google.sps.servlets;

import java.io.IOException;
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

    // Print form value to server logs
      System.out.println(name + "'s location is" + location + ". They would like to donate " + item + " and their phone number is " + number +".");

    // Redirect them to home page once form is submitted
      response.sendRedirect("/home_page.html");

    }
}