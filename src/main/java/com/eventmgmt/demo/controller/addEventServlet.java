package com.eventmgmt.demo.controller;

import com.eventmgmt.demo.DAO.EventDAO;
import com.eventmgmt.demo.model.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.eventmgmt.demo.model.User;

@WebServlet("/addEvent") 
public class addEventServlet extends HttpServlet {
    private EventDAO eventDAO = new EventDAO();

    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        User user = (session == null) ? null : (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String eventDateStr = request.getParameter("eventDate");

        if (title == null || title.isBlank() || location == null || location.isBlank() || eventDateStr == null || eventDateStr.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/admin-dashboard?error=missing");
            return;
        }

        // Convert eventDateStr to Timestamp
        Timestamp eventDate;
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(eventDateStr);
            eventDate = Timestamp.valueOf(localDateTime);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/admin-dashboard?error=date");
            return;
        }

        Event newEvent = new Event();
        newEvent.setTitle(title.trim());
        newEvent.setDescription(description == null ? "" : description.trim());
        newEvent.setLocation(location.trim());
        newEvent.setEventDate(eventDate);
        newEvent.setStatus("PENDING");

        if(eventDAO.createEvent(newEvent)) {
            response.sendRedirect(request.getContextPath() + "/admin-dashboard?success=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin-dashboard?error=failed");
        }
        
    }
}
