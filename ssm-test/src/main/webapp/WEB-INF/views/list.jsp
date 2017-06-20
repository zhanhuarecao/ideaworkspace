<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
    <table cellpadding="1" cellspacing="0" border="1">
        <tr>
            <th>id</th>
            <th>lastName</th>
            <th>gender</th>
            <th>email</th>
            <th>departmentName</th>
        </tr>
        <c:forEach items="${emps}" var="emp">
        <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.gender==0?'Man':'Woman'}</td>
                <td>${emp.email}</td>
                <td>${emp.department.departmentName}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
