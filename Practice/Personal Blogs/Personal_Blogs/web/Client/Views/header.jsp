<%-- 
    Document   : header
    Created on : Oct 17, 2022, 8:45:58 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link rel="stylesheet" href="Public/CSS/header.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' >
        <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Poppins'>
    </head>
    <body>
        <div >
        <div class="container_bar">
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

            </div>
            

        </div>
        <div class="header_bar">
            <div class="header_left">
                <div class="header_logo">
                    <a class="logo_blog" href="home.jsp">Laputa</a>

                </div>
                <div class="header_menu">
                    <ul class="menu_blog">
                        <li class="menu_category" style="pointer-events: unset;">
                            <a class="link_topic" href="">
                                Lập trình
                                <!--<span class="new_topic">new</span>-->
                                <i class="topic_down bx bx-chevron-down">

                                </i>
                            </a>
                            <ul class="category_child" style="display: block;"> 
                                <li><a class="linkCategory" href="/posts?category=html">
                                    <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;position:relative;max-width:100%">
                                        <span style="box-sizing:border-box;display:block;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;max-width:100%">
                                            <img style="display:block;max-width:100%;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0" alt="" aria-hidden="true" src="data:image/svg+xml,%3csvg%20xmlns=%27http://www.w3.org/2000/svg%27%20version=%271.1%27%20width=%2720%27%20height=%2720%27/%3e"></span>
                                            <img alt="img-category" src="/Images/html.webp" decoding="async" data-nimg="intrinsic" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%" srcset="/Images/html.webp 1x, /Images/html.webp 2x"></span>
                                            <span style="margin-left:1.4rem">Html</span></a></li>

                            </ul>

                        </li>
                        <li class="menu_category" style="pointer-events: unset;">
                            <a class="link_topic" href="">
                                Thuật toán
                                
                                <i class="topic_down bx bx-chevron-down">

                                </i>
                            </a>


                        </li>
                        <li class="menu_category" style="pointer-events: unset;">
                            <a class="link_topic" href="">
                                Giải trí
                                
                                <!-- <i class="topic_down bx bx-chevron-down"> -->

                                <!-- </i> -->
                            </a>


                        </li>
                        
                        <li class="menu_category" style="pointer-events: unset;">
                            <a class="link_topic" href="">
                                Du lịch
                                
                                <i class="topic_down bx bx-chevron-down">

                                </i>
                            </a>


                        </li>
                        
                        <li class="menu_category" style="pointer-events: unset;">
                            <a class="link_topic" href="about.jsp">
                                About Me
                                
                                <!-- <i class="topic_down bx bx-chevron-down"> -->

                                <!-- </i> -->
                            </a>
                            

                            

                        </li>
                    </ul>

                </div>

            </div>
            <div class="header_right">
                <div class="darkmode">
                    <i class="bx bxs-sun"></i>

                </div>
                <div class="bookmarks">
                    <i class="bx bx-bookmarks"></i>

                </div>
                <div class="search">
                    <i class="bx bx-search"></i>

                </div>
                <div class="notification">
                    <i class="bx bxs-bell"></i>

                </div>
                <div class="button_login">
                    
                    <a href="login.jsp">
                        Login
                        <i class='bx bxs-user'></i>
                    </a>

                    
                </div>

            </div>

        </div>

    </div>
    
    </body>
    <script src="./Public/JS/datetime.js"></script>
</html>
