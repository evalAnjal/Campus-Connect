package com.eventmgmt.demo.controller;

import com.eventmgmt.demo.DAO.*;
import com.eventmgmt.demo.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginProcess") // This matches the "action" in your index.jsp form
public class LoginServlet extends HttpServlet {
    
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get data from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 2. Talk to the Database (via DAO)
        User user = userDAO.validateUser(email, password);

        if (user != null) {
           
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 4. Check role and redirect
            if ("ADMIN".equals(user.getRole())) {
                response.sendRedirect("admin-dashboard.jsp");
            } else {
                response.sendRedirect("member-dashboard.jsp");
            }
        } else {
            // 5. Login failed - Go back to login with an error
            request.setAttribute("errorMessage", "Invalid email or password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}