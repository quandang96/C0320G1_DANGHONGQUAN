<%--
  Created by IntelliJ IDEA.
  User: quan5
  Date: 6/8/2020
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int[] arr={1,2,3,4,5}; %>

<c:forEach items="${arr}" var="x">
    <h1> abc ${x}</h1>
</c:forEach>
</body>
</html>
