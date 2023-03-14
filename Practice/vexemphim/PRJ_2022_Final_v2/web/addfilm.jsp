<%-- 
    Document   : addfilm
    Created on : Oct 31, 2022, 4:07:51 PM
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%> 
<%@page import ="Model.movie"%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=fire">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Shalimar">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Allerta Stencil' rel='stylesheet'>
        <title>JSP Page</title>
        <style>
            .body{
                background-color: #9af1f5;
                color: black;
            }
            .header{
                display: flex;
                justify-content: space-between;
                background-color: #c5e3f6;
                padding-top:10px;
                padding-right: 10px;
            }
            .header h1{
                margin-right: 20px;
                padding-right: 10px;
            }

            .header-logo img{
                align-items: center;
                max-width: 100px;
            }
            .sign{

                margin-right: 40px;
                margin-top: -20px;
            }
            .menu-display{
                display: flex;
                text-decoration: none;
                background-color: #B0D4B8;
            }
            .menu-list{
                font-size: 30px;
                padding: 10px 20px;
                text-decoration: none;
                margin-left: 40px;
                margin-right: 20px;
            }
            .menu-list:hover{
                background-color: #eae7d6;
            }
            .footer{
                text-align:center;
                background-color: rgb(0, 140, 255);
                color: white;
            }
            .footer__content{
                padding: 10px 0;
            }

            .menu{
                font-family: "Mukta", sans-serif;

            }
            .menu_2{
                font-family: "Mukta", sans-serif;
                border: 3px solid black;
                border-radius: 10px;
                padding-bottom: -20px;
            }
            .underline{
                background-color: red;
                padding: 2px;
            }
            .menu-add{
                padding-right: 100px;
                margin-right: 20px;
            }
        </style>
    </head>
    <body>
        <%
        ArrayList<movie> list = new ArrayList<movie>();
        if(request.getAttribute("list")!=null){
        list = (ArrayList<movie>) request.getAttribute("list");
            }
        %>
        <div class="body">
            
        
        <div class="header">
            <h1 style="font-family: Sofia; sans-serif" class="font-effect-fire">BAV Cinema</h1>

          
            <div class="login" style="font-size: 20px">
                ${account}<i class='fa fa-user'></i>
            </div>
        </div>
        <div class="underline"></div>
        <div class="header__logo" style="display: flex">
            <img style="width:1000px;height: 500px" src="assets/img/Images/avatar-2-trailer.jpg"/>
            <img style="width:1000px;height: 500px" src="assets/img/Images/black-adam.jpg" alt=""/>
        </div>




        <!--        Danh sach cac bo phim dang chieu-->

        <div style="padding:5px; background-color: #ff8d83;margin-top: 10px; margin-bottom: 10px"></div>

        <div class="row">
            <div class="col-sm-2">

            </div>
            <div class="col-sm-8">

                <div class="menu">
                    <div class="menu_2">
                        <h1 style="text-align: center;font-family: 'Allerta Stencil';color:red">Add new film here</h1>

                        <div class="menu-add">


                            <form action="addMovie" method="post">
                                <table border="0">
                                    <tbody>
                                        <tr>
                                            <td><b>Movie Name:</b> </td>
                                            <td> <input type="text" name="moviename"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Description:</b> </td>
                                            <td><input type="text" name="detail"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Time:</b></td>
                                            <td><input type="text" name="thoiluong"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Genre:</b></td>
                                            <td><input type="text" name="loai"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Dao dien:</b></td>
                                            <td><input type="text" name="daodien"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Trailer:</b></td>
                                            <td><input type="text" name="trailer"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Poster:</b></td>
                                            <td><input type="text" name="poster"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Actor:</b></td>
                                            <td><input type="text" name="actor"></td>
                                        </tr>
                                    </tbody> 
                                </table>
                                <br> <input type="submit" value="Add"> 
                            </form>
                        </div>
                    </div>


                    <table border = "1">
                        <tr>
                            <td> <b>ID</b> </td>
                            <td> <b>Movie Name</b> </td>
                            <td> <b>Description</b> </td>
                            <td> <b>Time</b> </td>
                            <td> <b>Genre</b> </td>
                            <td> <b>Daodien</b> </td>
                            <td> <b>Trailer</b> </td>
                            <td> <b>Poster</b> </td>
                            <td> <b>Actor</b> </td>
                           

                        </tr>
                        
                            <c:forEach items="${list}" var="item">
                            <tr>
                                <td><b>${item.getMovieID()}</b></td>
                                <td>${item.getMoviename()}</td>
                                <td>${item.getDetail()}</td>
                                <td>${item.getThoiluong()}</td>
                                <td>${item.getLoai()}</td>
                                <td>${item.getDaodien()}</td>
                                <td>${item.getTrailer()}</td>
                                <td><img style="width:100px" src="images/${item.getPoster()}" alt=""/></td>
                                <td>${item.getActor()}</td>
                                
                                <td><a href="delete?movieID=${item.getMovieID()}">Delete</a></td>
                            </tr> 
                        </c:forEach>
                        </form>
                        


                    </table>
                </div>
                <div class="col-sm-2 le">

                </div>
            </div>
        </div>   






        <div class="col-sm-2">

        </div>
    </div>
</div>




<div class="footer">
    <div class="footer__content">
        <p>Email : vubahe163495@fpt.edu.vn</p>
        <p>FPT University - Hoa Lac - Ha Moi</p>
        <h5>&copy; Copyright 2021. CozzyCinema.com</h5>
    </div>


</div>
</div>
</body>
</html>
