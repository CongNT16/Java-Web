

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : header
    Created on : Oct 17, 2022, 8:45:58 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Users"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>


        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' >
        <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Poppins'>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">
    </head>
    <body class="light-theme">

        <!--
          - #HEADER
        -->
        <header>
            <div class="container contai_bar">

                <nav class="container_bar">
                    <div class="contai_left">

                        <i class="bx bxs-hot"></i>
                        <span>Popular</span>

                        <div class="contai_post">

                        </div>

                    </div>
                    <div class="contai_right">

                        <div class="contai_social">
                            <a href="https://www.facebook.com/nguyencong.1606" alt="facebook" title="facebook" target="_blank" >
                                <i class="bx bxl-facebook"></i>
                            </a>
                            <a href="https://www.linkedin.com/in/nguyencong1606/" alt="linkedin" title="linkedin" target="_blank" >
                                <i class="bx bxl-linkedin"></i>
                            </a>
                            <a href="https://github.com/Laputa16" alt="github" title="github" target="_blank" >
                                <i class="bx bxl-github"></i>
                            </a>
                            <a href="https://twitter.com/Laputa_1606" alt="twitter" title="twitter" target="_blank" >
                                <i class="bx bxl-twitter"></i>
                            </a>
                        </div>



                        <div class="contai_split"> </div>

                        <div id="contai_time">
                            <div class="row-1">
                                <span id="dateCurr"></span>
                            </div>
                            <div class="row-2">
                                <span id="monthCurr"></span>
                                <strong id="yearCurr"></strong>
                            </div>
                        </div>

                        <div class="contai_split"> </div>

                        <button class="theme-btn theme-btn-desktop light">
                            <ion-icon name="moon" class="moon"></ion-icon>
                            <ion-icon name="sunny" class="sun"></ion-icon>
                        </button>

                    </div>
                </nav>


            </div>

            <div class="container">

                <nav class="navbar">

                    <a href="#">
                        <img src="./assets/images/logo-light.svg" alt="Devblog's logo" width="150" class="logo-light">
                        <img src="./assets/images/logo-dark.svg" alt="Devblog's logo" width="150" class="logo-dark">
                    </a>

                    <div class="btn-group">

                        <button class="theme-btn theme-btn-mobile light">
                            <ion-icon name="moon" class="moon"></ion-icon>
                            <ion-icon name="sunny" class="sun"></ion-icon>
                        </button>

                        <button class="nav-menu-btn">
                            <ion-icon name="menu-outline"></ion-icon>
                        </button>

                    </div>

                    <div class="flex-wrapper">

                        <ul class="desktop-nav">
                            
                            <c:if test="${sessionScope.user_login_roleid eq 1}">
                            <li>
                                <a href="ManageController" class="nav-link">Manage</a>
                            </li>    
                            </c:if>

                            <li>
                                <a href="HomeController" class="nav-link">Home</a>
                            </li>

                            <li>
                                <a href="category.jsp" class="nav-link">Category</a>
                            </li>

                            <li>
                                <a href="aboutme.jsp" class="nav-link">About Me</a>
                            </li>

                            <li>
                                <a href="contact.jsp" class="nav-link">Contact</a>
                            </li>

                            <li>

                                <c:if test="${sessionScope.user_login_account == null}">


                                    <a href="login.jsp" class="nav-link">Login</a>

                                </c:if>

                                <c:if test="${sessionScope.user_login_account != null}">



                                    <div class="action">
                                        <div class="desktop-nav" onclick="menuToggle();">
                                            <span class="nav-link">${user_login_account}</span>
                                        </div>

                                        <div class="menu">
                                            <!--                                            <h3>
                                                                                            User Account
                                                                                            <div>
                                                                                                Operational Team
                                                                                            </div>
                                                                                        </h3>-->
                                            <ul >
                                                <li >
                                                    <span class="material-icons icons-size">person</span>
                                                    <a href="ProfileUserController?userid=${user_login_id}">My Profile</a>
                                                </li>
                                                <li >
                                                    <span class="material-icons icons-size" >logout</span>

                                                    <a href="logout.jsp" >Logout</a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>




                                </c:if>







                            </li>

                        </ul>

                        <!--                        <button class="theme-btn theme-btn-desktop light">
                                                    <ion-icon name="moon" class="moon"></ion-icon>
                                                    <ion-icon name="sunny" class="sun"></ion-icon>
                                                </button>-->

                    </div>

                    <div class="mobile-nav">

                        <button class="nav-close-btn">
                            <ion-icon name="close-outline"></ion-icon>
                        </button>

                        <div class="wrapper">

                            <p class="h3 nav-title">Main Menu</p>

                            <ul>
                                <li class="nav-item">
                                    <a href="#" class="nav-link">Home</a>
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">Home</a>
                                </li>

                                <li class="nav-item">
                                    <a href="aboutme.jsp" class="nav-link">About Me</a>
                                </li>

                                <li class="nav-item">
                                    <a href="contact.jsp" class="nav-link">Contact</a>
                                </li>

                                <li class="nav-item">
                                    <a href="login.jsp" class="nav-link">Login</a>
                                </li>
                            </ul>

                        </div>

                        <div>

                            <p class="h3 nav-title">Topics</p>

                            <ul>
                                <li class="nav-item">
                                    <a href="#" class="nav-link">Database</a>
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">Accessibility</a>
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">Web Performance</a>
                                </li>
                            </ul>

                        </div>

                    </div>

                </nav>

            </div>

        </header>







    </body>
    <script>
        function menuToggle() {
            const toggleMenu = document.querySelector('.menu');
            toggleMenu.classList.toggle('active');
        }
    </script>
    <script src="../assets/js/datetime.js"></script>   
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</html>
