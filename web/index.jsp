<%--
  Created by IntelliJ IDEA.
  User: sscerbatiuc
  Date: 12/15/2022
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Employee manager</title>
    <%@ include file="common/bootstrap_css.html"%>
  </head>
  <body>
  <%@ include file="common/header.html"%>
  <div class="container">
    <h1>Welcome to employee manager</h1>
    <h3>Please select an option:</h3>
    <ul>
      <li><a href="list">View employees</a></li>
      <li><a href="add">Add</a></li>
      <li><a href="edit">Edit</a></li>
      <li><a href="delete">Delete</a></li>
      <li><a href="about.jsp">About</a></li>
    </ul>
  </div>
  <%@ include file="common/bootstrap_js.html"%>
  </body>
</html>
