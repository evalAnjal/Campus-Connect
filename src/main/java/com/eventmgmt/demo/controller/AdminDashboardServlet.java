package com.eventmgmt.demo.controller;

import com.eventmgmt.demo.DAO.EventDAO;
import com.eventmgmt.demo.model.Event;
import com.eventmgmt.demo.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/admin-dashboard")
public class AdminDashboardServlet extends HttpServlet {
    private final EventDAO eventDAO = new EventDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (session == null) ? null : (User) session.getAttribute("user");

        if (user == null || !"ADMIN".equals(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        List<Event> events = eventDAO.getAllEvents();
        int totalEvents = eventDAO.getTotalEventsCount();
        int approvedEvents = eventDAO.getTotalApprovedEventsCount();
        int totalMembers = eventDAO.getTotalMembersCount();
        int totalRegistrations = eventDAO.getTotalRegistrationsCount();
        Map<Integer, Integer> registrationCounts = eventDAO.getRegistrationCountByEvent();
        Map<Integer, Integer> participantCounts = eventDAO.getParticipantCountByEvent();

        request.setAttribute("events", events);
        request.setAttribute("totalEvents", totalEvents);
        request.setAttribute("approvedEvents", approvedEvents);
        request.setAttribute("totalMembers", totalMembers);
        request.setAttribute("totalRegistrations", totalRegistrations);
        request.setAttribute("registrationCounts", registrationCounts);
        request.setAttribute("participantCounts", participantCounts);
        request.getRequestDispatcher("/admin-dashboard.jsp").forward(request, response);
    }
}
