package com.example.servlet;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登录
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 输入的验证码
        String verifycode = req.getParameter("verifycode");

        //生成的验证码
        HttpSession session = req.getSession();
        String check_server = (String) session.getAttribute("CHECKCODE_SERVER");

        //验证码对比
        if (check_server.equalsIgnoreCase(verifycode)) {
            //存储提示信息到域，然后转发
            req.setAttribute("login_msg", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        //封装输入的对象
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //进行登录操作
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);

        //判断是否密码正确,根据返回的对象登录成功
        if (loginUser != null) {
            //将用户信息存储到session
            session.setAttribute("user", loginUser);
            //重定向跳转页面
            resp.sendRedirect(req.getContextPath() + "/findUserByPageServlet");
        } else {
            //登录失败,存储提示信息到域，转发到登录页面
            req.setAttribute("login_msg", "用户名或者密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
