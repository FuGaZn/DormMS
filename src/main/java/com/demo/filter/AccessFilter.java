package com.demo.filter;

import com.demo.model.Access;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class AccessFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String url = req.getRequestURI();
        String key = url.split("/")[2].split("\\.")[0];
        Set<Access> accessSet = (Set<Access>) req.getSession().getAttribute("access_set");
        boolean b = false;
        for (Access a: accessSet){
            if (a.getKey().equals(key)){
                b=true;
                break;
            }
        }
        if (b==false){
            resp.sendRedirect("/error/denied.jsp");
        }
        chain.doFilter(request,response);
    }
}
