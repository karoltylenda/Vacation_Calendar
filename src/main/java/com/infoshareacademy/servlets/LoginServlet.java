package com.infoshareacademy.servlets;

import com.infoshareacademy.service.UserService;
import com.infoshareacademy.service.ValidationService;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @Inject
    private ValidationService validationService;

    @Inject
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //TODO jeżeli użytkownik jest zalogowany to informacja, że taki użytkonik zalogowany w sesji
        RequestDispatcher view = getServletContext().getRequestDispatcher("/login.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.getSession(true);

        if (validationService.isAuthenticated(username, password)) {
            RequestDispatcher view = getServletContext().getRequestDispatcher("/main");

            req.getSession().setAttribute("levelOfAccess", userService.getByEmail(username).getLevelOfAccess());
            //FIXME
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("firstName", userService.getByEmail(username).getFirstName());
            req.getSession().setAttribute("lastName", userService.getByEmail(username).getLastName());

            view.forward(req, resp);

        } else {
            RequestDispatcher view = getServletContext().getRequestDispatcher("/login.jsp");
            view.forward(req, resp);
        }
    }
}
