<%-- 
    Document   : historyBooking
    Created on : Nov 8, 2022, 11:22:20 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Booking</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .container {
                width: 80%;
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
                margin: auto;
            }
            h2 {
                text-align: center;
            }
            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                max-width: 300px;
                margin: auto;
                text-align: center;
                font-family: arial;
                padding: 20px;
            }

            .main {
                padding: 0 16px;
            }

            .main::after {
                color: #000;
                ontent: "";
                clear: both;
                display: table;
            }

            .title {
                color: grey;
                font-size: 18px;
            }

            button {
                border: none;
                outline: 0;
                display: inline-block;
                padding: 8px;
                color: white;
                background-color: #000;
                text-align: center;
                cursor: pointer;
                width: 100%;
                font-size: 18px;
            }

            a {
                text-decoration: none;
                font-size: 22px;
                color: black;
            }

            button:hover, a:hover {
                opacity: 0.7;
            }

            body {
                background-color: #c72e0c;
                background-image: url(assets/img/Images/dark-sunset.jpg);
                font-family: 'Ubuntu', sans-serif;
            }

            .main {
                background-color: #eecbcb;
                width: 1000px;
                height: 900px;
                margin: 7em auto;
                border-radius: 1.5em;
                box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);

            }

            .sign {
                padding-top: 40px;
                color: #080202;
                font-family: 'Ubuntu', sans-serif;
                font-weight: bold;
                font-size: 23px;
            }

            .un {
                width: 76%;
                color: rgb(0, 5, 7);
                font-weight: 700;
                font-size: 14px;
                letter-spacing: 1px;
                background: rgba(136, 126, 126, 0.04);
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                outline: none;
                box-sizing: border-box;
                border: 2px solid rgba(0, 0, 0, 0.02);
                margin-bottom: 50px;
                margin-left: 46px;
                text-align: center;
                margin-bottom: 27px;
                font-family: 'Ubuntu', sans-serif;
            }

            form.form1 {
                padding-top: 40px;
            }

            .pass {
                width: 76%;
                color: rgb(1, 3, 4);
                font-weight: 700;
                font-size: 14px;
                letter-spacing: 1px;
                background: rgba(136, 126, 126, 0.04);
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                outline: none;
                box-sizing: border-box;
                border: 2px solid rgba(0, 0, 0, 0.02);
                margin-bottom: 50px;
                margin-left: 46px;
                text-align: center;
                margin-bottom: 27px;
                font-family: 'Ubuntu', sans-serif;
            }


            .un:focus,
            .pass:focus {
                border: 2px solid rgba(4, 4, 4, 0.18) !important;

            }

            .submit {
                font-weight: bolder;
                cursor: pointer;
                border-radius: 5em;
                color: rgb(24, 21, 20);
                background: linear-gradient(to right, #df0a0d, #e0b005);
                border: 0;
                padding-left: 40px;
                padding-right: 40px;
                padding-bottom: 10px;
                padding-top: 10px;
                font-family: 'Ubuntu', sans-serif;
                margin-left: 40%;

                font-size: 14px;
                box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);

            }


            .forgot {
                text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
                color: #ee0c0c;
                padding-top: 15px;
            }

            a {
                text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
                color: rgb(195, 16, 52);
                text-decoration: none
            }

            @media (max-width: 600px) {
                .main {
                    border-radius: 0px;
                }
            }


        </style>
    </head>
    <body>

        <div class="main">
            <p style="font-size: 30px; color: black" class="sign" align="center">Booking History</p>

            <br><label for="email"></label>
            Account: <input class="un " type="text" name="account" value="${account}" readonly>
            <div>
                <div class="historyContain">

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Film</th>
                                <th scope="col">Cinema</th>
                                <th scope="col">Seat</th>
                                <th scope="col">Movie Time</th>
                                <th scope="col">Booking Time</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${listHistoryBooking}" var="his">
                                <tr>
                                    <td>${his.getMovieName()}</td>
                                    <td>${his.getCinemaName()}</td>
                                    <td>${his.getSeatName()}</td>
                                    <td>
                                        <ul style="list-style: none;">
                                            <li>
                                                ${his.getDate()}
                                            </li>
                                            <li>
                                                ${his.getTime()}
                                            </li>
                                        </ul>

                                    </td>
                                    <td>
                                        <ul style="list-style: none;">
                                            <li>
                                                ${his.getBookingdate()}
                                            </li>
                                            <li>
                                                ${his.getBookingtime()}
                                            </li>
                                        </ul>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>

                </div>

                <br><a href="sucess.jsp"><input class="submit" type="submit" value="Home"></a>
            </div>

        </div>

    </body>
</html>
