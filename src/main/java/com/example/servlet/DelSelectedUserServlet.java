package com.example.servlet;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delSelectedUserServlet")
public class DelSelectedUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("uid");
        UserService userService = new UserServiceImpl();
        userService.delSelectedUser(ids);
        resp.sendRedirect(req.getContextPath() + "/findUserByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
