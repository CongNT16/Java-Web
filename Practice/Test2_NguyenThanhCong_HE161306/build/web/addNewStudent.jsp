<%-- 
    Document   : addNewStudent
    Created on : Oct 27, 2022, 3:52:52 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Student</title>
    </head>
    <body>
        <form action="add" method="post">
            Add new Student
            ID:<input type='text' name='id'>
            <br> Name:<input type='text' name='name'>
            <br> Gender:<input type='radio' name='gender' Value='1'> Male 
            <input type='radio' name='gender' Value='0'> Female


            <br> Deparment:<select name="did">
                <option hidden>Information Technology</option>
                <c:forEach items="${listStudent}" var="student">
                    <option value="${student.getDid()}">
                        <c:forEach items="${listDepartment}" var="department">
                        <c:if test="${student.getDid().equals(department.getDid())}">
                                ${department.getName()}
                        </c:if>
                    </c:forEach>
                    </option>
                </c:forEach>
            </select>
            <br> <input type='submit' name='Add' value='Add'>

        </form>
        
        <table boder="1">
            <tr>
                <th>ID</th> 
                <th>Name</th> 
                <th>Gender</th> 
                <th>Department</th> 
            </tr>
            <tr>
                <c:forEach items="${listStudent}" var="student">
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getGender()}</td>
                <td>
                    <c:forEach items="${listDepartment}" var="department">
                        <c:if test="${student.getDid().equals(department.getDid())}">
                                ${department.getName()}
                        </c:if>
                    </c:forEach>
                </td>
                </c:forEach>
            </tr>
            
        </table>
    </body>
</html>
