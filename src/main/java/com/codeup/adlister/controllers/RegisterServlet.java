package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("password", request.getParameter("password"));
        if (request.getAttribute("email") == null || request.getAttribute("username") == null || request.getAttribute("password") == null) {
            response.sendRedirect("/register");
        } else {
            User user = new User();
            user.setEmail(request.getAttribute("email").toString());
            user.setUsername(request.getAttribute("username").toString());
            user.setPassword(request.getAttribute("password").toString());
            Users usersDao = DaoFactory.getUsersDao();
            usersDao.insert(user);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/profile");
        }
    }
}
