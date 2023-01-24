<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Name.." value="${requestScope.name}"/>
    </div>
    <div class="mb-3">
        <label for="surname" class="form-label">Password</label>
        <input type="text" class="form-control" id="surname" name="surname" placeholder="Surname.."  value="${requestScope.surname}"/>
    </div>
    <div class="mb-3">
        <label for="birthdate" class="form-label">Password</label>
        <input type="date" id="birthdate" class="form-control" name="birthdate" placeholder="Birthdate.."  value="${requestScope.birthdate}"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>



<%--<form method="post">--%>
<%--    <div>--%>
<%--        <label>Name: </label>--%>

<%--    </div>--%>
<%--    <div>--%>
<%--        <label>Surname: </label>--%>
<%--        <input type="text" name="surname" placeholder="Surname.."  value="${requestScope.surname}"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label>Birthdate: </label>--%>
<%--        <input type="date" name="birthdate" placeholder="Birthdate.."  value="${requestScope.birthdate}"/>--%>
<%--    </div>--%>
<%--    <button type="submit">Save</button>--%>
<%--    <button type="reset">Clear</button>--%>
<%--</form>--%>
