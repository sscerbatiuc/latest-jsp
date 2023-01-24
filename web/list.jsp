<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: sscerbatiuc
  Date: 12/15/2022
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View employees</title>
    <%@ include file="common/bootstrap_css.html" %>
</head>
<body>
<%@ include file="common/header.html" %>
<div class="container">
    <h1>Employees list</h1>
    <c:if test="${param.search != null}">
        Filtered by: <c:out value="${param.search}"/>
        <a href="list">Clear</a>
    </c:if>

    <c:choose>
        <c:when test="${!requestScope.list.isEmpty()}">
            <table id="employee_table" class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Birthdate</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="employee"> <%--for(String el: list)--%>
                    <tr>
                        <td><c:out value="${employee.name}"/></td>
                        <td><c:out value="${employee.surname}"/></td>
                        <td><c:out value="${employee.birthdate}"/></td>
                        <td>
                                <%--                   POST: in corp --%>
                                <%--                   GET: in adresa --%>
                            <a class="btn btn-primary" href="edit?id=${employee.id}">
                                Edit
                            </a>
                            <a class="btn btn-danger" href="delete?id=${employee.id}" <%--onclick="confirmDelete(${employee.id})"--%>>
                                Danger
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link">Previous</a>
                    </li>
                    <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                        <c:choose>
                            <c:when test="${requestScope.activePage == i}">
                                <li class="page-item active">
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${param.search != null}">
                                <a class="page-link " href="list?search=${param.search}&p=${i}">
                            </c:when>
                            <c:otherwise>
                                <a class="page-link " href="list?p=${i}">
                            </c:otherwise>
                        </c:choose>

                        <c:out value="${i}"/>
                        </a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert">
                No data!
            </div>
        </c:otherwise>
    </c:choose>

</div>
<%@ include file="common/bootstrap_js.html" %>
</body>
<script>
    function confirmDelete(id) {
        if (confirm("Are you sure you want to delete the employee with id=?" + id)) {
            window.location.href = 'delete?id=' + id;
        }
    }
</script>
</html>
