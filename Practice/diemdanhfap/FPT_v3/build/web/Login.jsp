<%-- 
    Document   : Login
    Created on : Oct 25, 2022, 10:04:42 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <h2 class="text-center text-dark mt-5">Login</h2>

                    <div class="card my-5">

                        <form class="card-body cardbody-color p-lg-5 " action="login" method="post">

                            <div class="text-center">
                                <img src="https://hcmuni.fpt.edu.vn/Data/Sites/1/skins/default/img/og-image.png" 
                                     width="400px" alt="profile">
                            </div>

                            <div class="mb-3">
                                <input type="text" class="form-control" id="Username" aria-describedby="emailHelp"
                                       name="studentId"   placeholder="User Name" value="${studentId}">
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" id="password" placeholder="password"  name="password" value="${password}">
                            </div>
                            <input type="text" name="campus" value="${campus}" hidden>

                            <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button></div>
                            <div id="emailHelp" class="form-text text-center mb-5 text-dark">Not
                                Registered? <a href="Create.jsp" class="text-dark fw-bold"> Create an
                                    Account</a>
                                <div id="emailHelp" class="form-text text-center mb-5 text-dark"> <a href="Forgot.jsp" class="text-dark fw-bold"> Forgot pass</a>
                                    <div id="emailHelp" class="form-text text-center mb-5 text-dark"> <a href="Change.jsp" class="text-dark fw-bold"> Change pass</a>
                                    </div>
                                    </form>
                                </div>

                            </div>
                    </div>
                </div>
                </body>
                </html>
