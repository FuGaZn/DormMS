package com.demo.servlet;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.User;
import com.demo.util.MyMD5;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = MyMD5.encrypt(req.getParameter("password"));
        User user = userDao.findByName(name);
        if (user != null){
            resp.sendRedirect("/error/userExist.jsp");
        }else{
            User user1 = userDao.createUser(new User(name,req.getParameter("password")));
            System.out.println("register");
            Cookie cookie = new Cookie("autoLogin", name);
            Cookie cookie1 = new Cookie("password", password);
            cookie.setMaxAge(3600*24*7);
            cookie1.setMaxAge(3600*24*7);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            req.getSession().setAttribute("user", user1);
            resp.sendRedirect("/user/home.jsp");
        }
    }
}
