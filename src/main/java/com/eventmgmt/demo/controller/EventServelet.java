package com.eventmgmt.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.eventmgmt.demo.DAO.EventDAO;
import com.eventmgmt.demo.DAO.registrationDAO;
import com.eventmgmt.demo.model.Event;
import com.eventmgmt.demo.model.User;

@WebServlet("/Member-dashboard")
public class EventServelet extends HttpServlet{
    private final EventDAO eventDAO = new EventDAO();
    private final registrationDAO regDAO = new registrationDAO();

    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        List<Event> eventList = eventDAO.getAllApprovedEvents();
        List<Integer> joinedIds = regDAO.getJoinedEventIds(user.getId());

        request.setAttribute("events", eventList);
        request.setAttribute("joinedIds", joinedIds);

        request.getRequestDispatcher("/member-dashboard.jsp").forward(request, response);
    }
}
