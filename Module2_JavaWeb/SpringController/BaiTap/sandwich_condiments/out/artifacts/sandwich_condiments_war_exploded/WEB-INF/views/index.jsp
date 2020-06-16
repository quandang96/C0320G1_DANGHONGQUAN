<%--
  Created by IntelliJ IDEA.
  User: quan5
  Date: 6/11/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <form action="/save" method="post">

     <label>
         <input type="checkbox" name="condiments" value="Lettuce">
     </label>Lettuce
     <label>
         <input type="checkbox" name="condiments" value="Tomato">
     </label>Tomato
     <label>
         <input type="checkbox" name="condiments" value="Mustard">
     </label>Mustard
     <label>
         <input type="checkbox" name="condiments" value="Sprouts">
     </label>Sprouts<br>

     <button  type="submit" value="save">save</button>


 </form>
  </body>
</html>
