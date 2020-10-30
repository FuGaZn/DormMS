<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/17
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Demo</title>

  </head>
  <body>
  <div>

  </div>
  <div>
    <h1>Login</h1>
    <form action="/login" method="post">
      <input type="text" name="username" placeholder="输入姓名">
      <input name="password" placeholder="输入密码" type="password">
      <input type="submit" value="登陆">
    </form>
    <a href="/user/register.jsp">注册-></a>
  </div>

  </body>
</html>
