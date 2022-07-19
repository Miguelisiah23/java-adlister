<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Here's your ads</h1>
<c:forEach var="ad" items="${ads}">
    <h3>${ad.title}</h3>
    <p>${ad.description}</p>

</c:forEach>

</body>
</html>
