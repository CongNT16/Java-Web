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
            <br>ID:<input type='text' name='id'>
            <br> Name:<input type='text' name='name'>
            <br> Gender:<input type='radio' name='gender' Value='1'> Male 
            <input type='radio' name='gender' Value='0'> Female


            <br> Deparment:<select name="did">
                <!--<option hidden>Information Technology</option>-->
                <c:forEach items="${listDepartment}" var="department">
                    <option value="${department.getId()}">
                                ${department.getName()}
                    </option>
                </c:forEach>
            </select>
            <br> <input type='submit' name='Add' value='Add'>

        </form>
        
        <table border =1>
            <tr>
                <th>ID</th> 
                <th>Name</th> 
                <th>Gender</th> 
                <th>Department</th> 
            </tr>
            <c:forEach items="${listStudent}" var="student">
            <tr>
                
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getGender()}</td>
                <td>
                    <c:forEach items="${listDepartment}" var="department">
                        <c:if test="${student.getDid().equals(department.getId())}">
                                ${department.getName()}
                        </c:if>
                    </c:forEach>
                </td>
                
            </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
