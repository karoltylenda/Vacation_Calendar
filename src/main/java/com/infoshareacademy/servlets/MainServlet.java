package com.infoshareacademy.servlets;

import com.infoshareacademy.service.CalendarService;
import com.infoshareacademy.service.DayOffService;
import com.infoshareacademy.service.UserService;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Inject
    private CalendarService calendarService;
    @Inject
    private UserService userService;
    @Inject
    private DayOffService dayOffService;

    private static final Logger LOGGER = Logger.getLogger(MainServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestDispatcher(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestDispatcher(req, resp);
    }

    private void setRequestDispatcher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        RequestDispatcher view;
        if (req.getSession().getAttribute("username") != null){
            view = getServletContext().getRequestDispatcher("/main.jsp");
        }
        else {
            view = getServletContext().getRequestDispatcher("/badrequest_404");
        }

        req.setAttribute("calendarView", calendarService.calendarView(120));
        req.setAttribute("users", userService.getAll());
        req.setAttribute("map", dayOffService.mapUsersWithDaysOff());

        view.forward(req, resp);
    }
}
