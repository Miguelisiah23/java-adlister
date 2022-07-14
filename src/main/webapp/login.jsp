<%--
  Created by IntelliJ IDEA.
  User: miguelromero
  Date: 7/13/22
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp"%>
<c:if test="${param.username != null && param.password != null}">
<c:choose>
    <c:when test='${param.username.equalsIgnoreCase("admin") && param.password.equalsIgnoreCase("password")}'>
                <% response.sendRedirect("profile.jsp");%>
    </c:when>
    <c:otherwise>
        <% response.sendRedirect("login.jsp");%>
    </c:otherwise>
</c:choose>
</c:if>
<form action="login.jsp" method="post">
   <h4><label for="username">username</label></h4>
    <input name="username" id="username" type="text" placeholder="Username..">
    <h4><label for="password">password</label></h4>
    <input name="password" id="password" type="password" placeholder="Password...">
    <button type="submit">Login/Signup</button>
</form>

</body>
</html>
