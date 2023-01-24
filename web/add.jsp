<%--
  Created by IntelliJ IDEA.
  User: sscerbatiuc
  Date: 1/12/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add employee</title>
    <%@ include file="common/bootstrap_css.html" %>
</head>
<body>
<%@ include file="common/header.html"%>
<div class="container">
    <h1>Add employee</h1>
    <%@ include file="common/forms/employee_form.jsp"%>
    <a href="list">Go to list</a>
</div>

<%@ include file="common/bootstrap_js.html" %>
</body>
</html>
