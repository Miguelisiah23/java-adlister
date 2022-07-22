
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="partials/head.jsp"%>
    <title>Register for account</title>
</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp"%>
<form action="register" method="post">
    <h1>Register For An Account!</h1>
    <label for="email">Email</label>
    <input id="email" name="email" type="text">
    <label for="username">Username</label>
    <input name="username" type="text" id="username">
    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <button type="submit">Create Account!</button>
</form>

</body>
</html>
