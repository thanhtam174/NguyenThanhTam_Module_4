<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/28/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich Condiment</h2>
<c:forEach var="condiment" items="${condiments}">
    <p>${condiment}</p>
</c:forEach>
<c:if test="${none != null}">
    <p>${none}</p>
</c:if>
</body>
</html>
