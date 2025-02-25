package com.studentlearningmanagementsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("password")) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("courses.html");
        } else {
            resp.sendRedirect("login.html");
        }
    }
}