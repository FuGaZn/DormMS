<%@ page import="com.demo.model.Access" %>
<%@ page import="javafx.scene.effect.SepiaTone" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.HashSet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/17
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<%
    Set<Access> accessSet = (Set<Access>) request.getSession().getAttribute("access_set");
    System.out.println("jsp "+accessSet.size());
    Set<String> accessAbleSet = new HashSet<>();
    if (accessSet!=null){
        for (Access access: accessSet){
            if (access.getStatus() == 1){
                System.out.println(access);
                accessAbleSet.add(access.getName());
            }
        }
    }

%>
<body>
<h1>RBAC</h1>
<ul>
    <c:if test='<%=accessAbleSet.contains("宿舍信息管理")==true%>'>
        <li><a href="">宿舍信息管理</a></li>
    </c:if>
    <c:if test='<%=accessAbleSet.contains("床位状态管理")==true%>'>
        <li><a href="">床位状态管理</a></li>
    </c:if>
    <c:if test='<%=accessAbleSet.contains("学生白名单管理")==true%>'>
        <li><a href="">学生白名单管理</a></li>
    </c:if>
</ul>

<a href="/logout">退出登陆</a>

</ul>
</body>
</html>
