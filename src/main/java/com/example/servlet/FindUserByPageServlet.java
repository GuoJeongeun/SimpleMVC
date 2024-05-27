package com.example.servlet;

import com.example.pojo.PageBean;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        Map<String, String[]> condition = req.getParameterMap();

        UserService userService = new UserServiceImpl();
        PageBean<User> pb = userService.findUserByPage(currentPage, rows, condition);

        req.setAttribute("pb", pb);
        req.setAttribute("condition", condition);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
