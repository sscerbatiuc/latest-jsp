<%--
  Created by IntelliJ IDEA.
  User: sscerbatiuc
  Date: 1/12/2023
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit employee</title>
</head>
<body>
    <h1>Edit employee</h1>
    <form method="post">
        <input type="hidden" name="id" value="${requestScope.id}">
        <div>
            <label>Name: </label>
            <input type="text" name="name" placeholder="Name.." value="${requestScope.name}"/>
        </div>
        <div>
            <label>Surname: </label>
            <input type="text" name="surname" placeholder="Surname.."  value="${requestScope.surname}"/>
        </div>
        <div>
            <label>Birthdate: </label>
            <input type="date" name="birthdate" placeholder="Birthdate.."  value="${requestScope.birthdate}"/>
        </div>
        <button type="submit">Save</button>
        <button type="reset">Clear</button>
    </form>
</body>
</html>
