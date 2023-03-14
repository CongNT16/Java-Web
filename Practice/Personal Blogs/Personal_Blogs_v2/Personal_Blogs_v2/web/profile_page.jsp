<%-- 
    Document   : profile_page
    Created on : Oct 20, 2022, 12:14:55 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Users"%>
<%@page import="Models.Posts"%>
<%@page import="DataAccess.PostDAO"%>
<%@page import="DataAccess.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" type="text/css" href="assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="assets/css/profile_page.css">
        <link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
    </head>
    <body>

        <jsp:include page="layout/header.jsp" />

        <main class="container-main">
            <c:if test="${sessionScope.user_infor_id != null}">
                <div class="container-profile">

                    <!--        <div class="link-arrow">
                                <a href="/">Home</a>
                                /
                                <a href="#">Profile</a>
                            </div>-->
                    <div class="info-user">
                        <div class="avatar-user">
                            <img src="assets/images/gura_logo.png" alt="avatar">
                            <!--<button class="upload-avatar hidden-action" type="submit">Upload avatar</button>-->
                            <!--<input type="file" id="img" name="img" class="input-file hidden-action"/>-->

                        </div> 
                        <div class="main-info">
                            <h1>Profile 
                                <div class="text-edit"><a href="EditProfileController?userid=${user_infor_id}">Edit <i class='bx bxs-edit'></a></i></div></h1>
                            <div class="info-content">
                                <table style="border-spacing:30px 0;">

                                    <tr>
                                    <div class="useraccount">
                                        <td>
                                            <div class="label" for="">Account</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_account}</div>
                                        </td>

                                    </div>
                                    </tr>
                                    <tr>
                                    <div class="username">
                                        <td>
                                            <div class="label" for="">Name</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_name}</div>
                                        </td>

                                    </div>
                                    </tr>
                                    <tr>
                                    <div class="usergender">
                                        <td>
                                            <div class="label" for="">Gender</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_gender}</div>
                                        </td>

                                    </div>
                                    </tr>
                                    <tr>
                                    <div class="userdob">
                                        <td>
                                            <div class="label" for="">Birthday</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_dob}</div>
                                        </td>

                                    </div>
                                    </tr>
                                    <tr>
                                    <div class="useremail">
                                        <td>
                                            <div class="label" for="">Email</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_email}</div>
                                        </td>

                                    </div>
                                    </tr>
                                    <tr>
                                    <div class="userphone">
                                        <td>
                                            <div class="label" for="">Phonenumber</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_phone}</div>
                                        </td>

                                    </div>
                                    </tr>
                                    <tr>
                                    <div class="useraddress">
                                        <td>
                                            <div class="label" for="">Address</div> 
                                        </td>
                                        <td>
                                            <div class="info">${user_infor_address}</div>
                                        </td>

                                    </div>
                                    </tr>
                                </table>
                                <input type="text" hidden class="id-user">
                            </div>
                            <!--<button class="submit-modify hidden-action" type="submit">Save</button>-->
                        </div>            
                    </div>
                    <!--       <button class="show-order">Show order success</button>
                            <div class="order-success hidden-action">
                                <h1>Order Success</h1>
                                
                                
                            </div>-->

                </div>
            </c:if>
        </main>

        <jsp:include page="layout/footer.jsp" />

    </body>

    <script src="./assets/js/datetime.js"></script>   
    <script src="./assets/js/layout.js"></script>
</html>
