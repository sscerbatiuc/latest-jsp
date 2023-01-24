<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="common/bootstrap_css.html" %>
</head>
<body>
<div class="container">
    <c:if test="${requestScope.error != null}">
        <div class="alert alert-danger" role="alert">
            <c:out value="${requestScope.error}"/>
        </div>
    </c:if>
    <form action="login" method="post">

        <label>Username:</label> <input type="text" name="user">
        <br>
        <label>Password:</label> <input type="password" name="pwd">
        <br>
        <input type="submit" value="Login">
    </form>
</div>
</body>