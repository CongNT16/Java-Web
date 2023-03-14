<%-- 
    Document   : Fee
    Created on : Oct 31, 2022, 11:03:49 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Course" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
   <div class="row">
           <div class ="col-md-2"></div>
            <div class="col-md-6">

                <h1><span>FPT University Academic Portal</span>
                </h1>

            </div>
            <div class="col-md-4">
                <table>
                    <tbody><tr>
                        <td colspan="2" class="auto-style1"><strong>FAP mobile app (myFAP) is ready at</strong></td>

                    </tr>
                    <tr>
                        <td><a href="https://apps.apple.com/app/id1527723314">
                             <img src='img/appStore.jpg' style="width: 120px; height: 40px" alt="apple store"></a></td>
                        <td><a href="https://play.google.com/store/apps/details?id=com.fuct">
                            <img src='img/GoogleStore.jpg' style="width: 120px; height: 40px" alt="google store"></a></td>

                    </tr>
                </tbody></table>
            </div>
        </div>
        
        <div class="row" style="margin-top: 30px">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="background-color: #f7f6f9 ; padding: 30px ">
            <div style="float: right">
            <table >
                 <button  type="button" class="btn btn-success h-15 pt-0 me-1 ms-1 mt-1"  style="height: 20px; ;font-size: 12px; background-color: rgb(92,184,92);">  <a href="Detail.jsp"  target="target" style="color: white" > ${studentId} </a> </button>|
                     <button  type="button" class="btn btn-success h-15 pt-0 me-1 ms-1 mt-1" style="height: 20px; ;font-size: 12px; background-color: rgb(92,184,92);">  <a href="Login.jsp" target="target" style="color: white">Logout </a></button>|
                 <button  type="button" class="btn btn-success h-15 pt-0 me-1 ms-1 mt-1" style="height: 20px; ;font-size: 12px; background-color: rgb(92,184,92);">  <a style="color: white">${campus} </a> </button>
        </table>
            </div>
            

        </div>
        <div class="col-md-2"></div>
        </div>
        
        
        
        
        <div class="row" style="margin-top: 50px"> 
            <div class="col-md-2"></div>
            <div class="col-md-8"> 
         <table class="table table-hover">
             <tr style="background-color: #3399ff; color: white" > 
                 <td>CourseID</td>
                 <td>Coursename</td>
                 <td>Credit</td>
                 <td>Fee</td>
                 
             </tr>
             <c:forEach items="${list}" var="item">
                 <tr>
                     <td>${item.getCourseID()}</a</td>
                     <td>${item.getCoursename()}</td>
                     <td>${item.getCredit()}</td>
                     <td>${item.getFee()}</td>    
                 </tr>
             </c:forEach>
                
         </table>
            </div> 
        
        <div class="col-md-2"></div>
        </div>
    </body>
</html>
