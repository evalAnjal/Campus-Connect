package com.eventmgmt.demo;


import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formProcessor", value = "/processForm")

public class formProcessor extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String userName = request.getParameter("username");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");


        PrintWriter out = response.getWriter();
        if (userName != null && !userName.trim().isEmpty()) {
            out.print("Success: User " + userName + " has been processed.");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("Error: Username is missing.");
        }
    }
}
