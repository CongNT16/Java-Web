<%-- 
    Document   : hanoi
    Created on : Oct 30, 2022, 12:16:10 AM
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%> 
<%@page import ="Model.User"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                width: 500px;
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
                margin-left: 35%;

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
        <p style="font-size: 30px; color: black" class="sign" align="center">User's Information</p>
          
            <br><label for="email"></label>
            Account: <input class="un " type="text" name="account" value="${sessionScope.account}" readonly>
            <c:forEach items="${list}" var="x">
            <br><label for="email"></label>
            Fullname: <input class="un " type="text" value="${x.fullname}"readonly>
            <br><label for="email"></label>
            SDT:<input class="un " type="text" value="${x.email}"readonly>
            <br><label for="email"></label>
            Email:<input class="un " type="text" value="${x.sdt}"readonly>
            <br><label for="email"></label>
             Gender:<input class="un " type="text" value="${x.address}"readonly>
            <br><label for="email"></label>
            Address: <input class="un " type="text" value="${x.gender}"readonly>
            <br><label for="email"></label>
            DateOfBirth:<input class="un " type="text" value="${x.dateofbirth}"readonly>
            </c:forEach>
         
            <br>
            <div style="display: flex">
            <a href="sucess.jsp"><input class="submit" type="submit" value="Home"></a>
            
            <a href="bookingHistory" ><input class="submit" type="submit" value="History Booking"></a>
            </div>
            
        </div>
     

    


</body>
</html>
