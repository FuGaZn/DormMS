package com.demo.filter;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    UserDao userDao = new UserDaoImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (!request.getRequestURI().equals("/") && !request.getRequestURI().equals("/index.jsp") && !request.getRequestURI().equals("/user/register.jsp")) {
            Cookie[] cookies = request.getCookies();
            Cookie autoLoginCookie = null;
            Cookie passwordCookie = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("autoLogin")) {
                        autoLoginCookie = cookie;
                    }
                    if (cookie.getName().equals("password")) {
                        passwordCookie = cookie;
                    }
                }
            }
            if (autoLoginCookie != null) {
                String username = autoLoginCookie.getValue();
                String password = passwordCookie.getValue();
                User user = userDao.findByName(username);
                boolean b = false;
                if (user != null && user.getPassword().equals(password)) {
                    request.getSession().setAttribute("user", user);
                    b = true;
                }
                if (b == false) {
                    response.sendRedirect("/");
                }
            } else {
                response.sendRedirect("/");
            }
        }
        filterChain.doFilter(request, response);
    }

}
