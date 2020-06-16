<%--
  Created by IntelliJ IDEA.
  User: quan5
  Date: 6/7/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action ="/display-discount" method="post">
    <label>Product Description </label>
    <input type="text" name="product">
    <label>List Price </label>
    <input type="number" name="Price">
    <label>Discount Percent </label>
    <input type="number" name="Discount">
    <input type="submit" name="Calculate" value="Calculate Discount" >
<%
  for ()
%>
  </form>
  </body>
</html>
