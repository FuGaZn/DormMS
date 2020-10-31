package com.demo.servlet.login;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.Access;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.demo.util.MyMD5;
import com.demo.util.factory.DaoFactory;
import com.demo.util.factory.ServiceFactory;
import com.demo.util.factory.impl.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class LoginServlet extends HttpServlet {
    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = MyMD5.encrypt(req.getParameter("password"));
        User user = serviceFactory.getUserService().getUser(name);
        if (user == null){
            resp.sendRedirect("/error/userNotFound.jsp");
        }else if(!user.getPassword().equals(password)){
            resp.sendRedirect("/error/passwdError.jsp");
        }else{
            Set<Access> accessSet = serviceFactory.getUserService().getAllAccesses(user.getId());
            Cookie cookie = new Cookie("autoLogin", name);
            Cookie cookie1 = new Cookie("password", password);
            cookie.setMaxAge(3600*24*7);
            cookie1.setMaxAge(3600*24*7);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("access_set", accessSet);
            resp.sendRedirect("/user/home.jsp");
        }
    }
}
