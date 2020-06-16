<%--
  Created by IntelliJ IDEA.
  User: quan5
  Date: 6/11/2020
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>selected condiments:</h2>
<c:forEach items="${condiment}" var="cond">
   <c:out value="${cond}"/>
</c:forEach>
</body>
</html>
