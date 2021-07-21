package com.developer;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connect connectDAO;

    public void init() {
    	connectDAO = new Connect();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	int contactId = 0;
    	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
        Contactinfo ci = new Contactinfo();
        ci.setname(name);
        ci.setemail(email);
        ci.setsubject(subject);
        ci.setmessage(message);
        try {
        	contactId = connectDAO.contact(ci);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(contactId > 0) {
        request.setAttribute("name",ci.getname());
          request.setAttribute("email",ci.getemail());
          request.setAttribute("subject",ci.getsubject());
          request.setAttribute("message", ci.getmessage());
         

          RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactDetail.jsp");
          requestDispatcher.forward(request, response);
        }
    }
}