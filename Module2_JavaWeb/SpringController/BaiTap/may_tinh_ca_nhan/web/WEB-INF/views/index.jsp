<%--
  Created by IntelliJ IDEA.
  User: quan5
  Date: 6/11/2020
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
<label>
  <input type="text" name="number1" value="0">
</label>
  <label>
    <input type="text" name="number2" value="0">
  </label><br>
<button type="submit" name="add" value="addition">Addition(+)</button>
<button type="submit" name="add" value="subtraction">Subtraction(-)</button>
<button type="submit" name="add" value="multiplication">Multiplication(X)</button>
<button type="submit" name="add" value="division">Division(/)</button>
  </form>
  <c:if test="${result!=null}" >
    <h1>Result: </h1>
    <h3>${result}<h3>
      </c:if>
  </body>

</html>
