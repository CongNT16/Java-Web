
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DevBlog - Laputa's Personal Blog</title>

        <!--
          - favicon
        -->
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">

        <!--
          - custom css link
        -->
        <link rel="stylesheet" href="./assets/css/layout.css">
        <link rel="stylesheet" href="./assets/css/home.css">

        <!--
          - google font link
        -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">
    </head>

    <body class="light-theme">

        <!--
          - #HEADER
        -->


        <jsp:include page="layout/header.jsp" /> 





        <main>

            <!--
              - #HERO SECTION
            -->


            <div class="hero">

                <div class="container">

                    <div class="left">

                        <h1 class="h1">
                            Hi, I'm <b>Laputa</b>.
                            <br>Software Engineer
                        </h1>

                        <p class="h3">
                            This blog is where I share my knowledge and life experiences.

                        </p>

                        <!--                        <div class="btn-group">
                                                    <a href="#" class="btn btn-primary">Contact Me</a>
                                                    <a href="#" class="btn btn-secondary">About Me</a>
                                                </div>-->

                    </div>

                    <div class="right">

                        <div class="pattern-bg"></div>
                        <div class="img-box">
                            <img src="./assets/images/gura_logo.png" alt="Laputa" class="hero-img">
                            <div class="shape shape-1"></div>
                            <div class="shape shape-2"></div>
                        </div>

                    </div>

                </div>

            </div>





            <div class="main">

                <div class="container">


                    <!--- BLOG SECTION-->


                    <div class="blog">

                        <h2 class="h2">Latest Blog Post</h2>

                        <div class="blog-card-group">


                            <c:forEach var="post" items="${listPagePost}">
                                <div class="blog-card">
                                    <input type="text" hidden name="postid" value="${post.getPost_id()}">



                                    <div class="blog-card-banner">
                                        
                                        <c:forEach items="${listimages}" var="image">
                                                <c:if test="${post.getPost_id().equals(image.getPost_id())}">
                                                        <img src="./assets/images/${image.getImg_filename()}" alt="${post.getPost_title()}" width="250" class="blog-banner-img">
                                                </c:if>
                                        </c:forEach>
                                        
                                    </div>

                                    <div class="blog-content-wrapper">
                                        
                                        <c:forEach items="${listtopic}" var="topic">
                                            <c:if test="${post.getPost_id().equals(topic.getPost_id())}">
                                                     <button class="blog-topic text-tiny">${topic.getTopic_name()}</button>            
                                            </c:if>
                                        </c:forEach>

                                        

                                        <h3>
                                            <a href="PostController?postid=${post.getPost_id()}" ass="h3">
                                                ${post.getPost_title()}
                                            </a>
                                        </h3>

                                        <p class="blog-text">
                                            ${post.getPost_body()}
                                        </p>

                                        <div class="wrapper-flex">

                                            <div class="profile-wrapper">
                                                <c:forEach items="${listuser}" var="user">
                                                    <c:if test="${post.getPost_author_id().equals(user.getUser_id())}">
                                                        <img src="./assets/images/${user.getUser_avatar()}" alt="${user.getUser_firstname()}&nbsp;${user.getUser_lastname()}" width="50">                                                               
                                                    </c:if>
                                                </c:forEach>
                                                
                                                
                                            </div>

                                            <div class="wrapper">
                                                <c:forEach items="${listuser}" var="user">
                                                        <c:if test="${post.getPost_author_id().equals(user.getUser_id())}">
                                                            <a href="#" class="h4">${user.getUser_firstname()}&nbsp;${user.getUser_lastname()}</a>
                                                            
                                                        </c:if>
                                                </c:forEach>
                                                

                                                <p class="text-sm">
                                                    <time datetime="${post.getPost_create_date()}">${post.getPost_create_date()}</time>
                                                    <span class="separator"></span>
                                                <ion-icon name="time-outline"></ion-icon>
                                                <!--<time datetime="PT3M">3 min</time>-->
                                                </p>
                                            </div>

                                        </div>

                                    </div>

                                </div>
                            </c:forEach>




                        </div>

                        <!--<button class="btn load-more">Load More</button>-->



                        <div class="pagination flex-row">
                            <c:if test="${tagPage>1}">
                                <a href="HomeController?index=${tagPage-1}"><i class='bx bx-chevron-left'"></i></a>
                                </c:if>
                                <c:forEach begin = "1" end="${endPage}" var="i">
                                <a href="HomeController?index=${i}" class="pages ${tagPage == i?"active":""}">${i}</a>
                            </c:forEach>
                            <!--<a href="#" class="pages">2</a>-->
                            <!--<a href="#" class="pages">3</a>-->
                            <c:if test="${tagPage < endPage}">
                                <a href="HomeController?index=${tagPage+1}"><i class='bx bx-chevron-right'></i></a>
                                </c:if>
                        </div>

                    </div>





                    <!--
                      - ASIDE
                    -->

                    <div class="aside">

                        <div class="topics">

                            <h2 class="h2">Topics</h2>

                            <a href="#" class="topic-btn">
                                <div class="icon-box">
                                    <ion-icon name="server-outline"></ion-icon>
                                </div>

                                <p>Database</p>
                            </a>

                            <a href="#" class="topic-btn">
                                <div class="icon-box">
                                    <ion-icon name="accessibility-outline"></ion-icon>
                                </div>

                                <p>Accessibility</p>
                            </a>

                            <a href="#" class="topic-btn">
                                <div class="icon-box">
                                    <ion-icon name="rocket-outline"></ion-icon>
                                </div>

                                <p>Web Performance</p>
                            </a>

                        </div>

                        <div class="tags">

                            <h2 class="h2">Tags</h2>

                            <div class="wrapper">

                                <button class="hashtag">#mongodb</button>
                                <button class="hashtag">#nodejs</button>
                                <button class="hashtag">#a11y</button>
                                <button class="hashtag">#mobility</button>
                                <button class="hashtag">#inclusion</button>
                                <button class="hashtag">#webperf</button>
                                <button class="hashtag">#optimize</button>
                                <button class="hashtag">#performance</button>

                            </div>

                        </div>

                        <div class="contact">

                            <h2 class="h2">Let's Talk</h2>

                            <div class="wrapper">

                                <p>
                                    Do you want to learn more about how I can help your company overcome problems? Let us have a
                                    conversation.
                                </p>

                                <ul class="social-link">

                                    <li>
                                        <a href="#" class="icon-box discord">
                                            <ion-icon name="logo-discord"></ion-icon>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="icon-box twitter">
                                            <ion-icon name="logo-twitter"></ion-icon>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="icon-box facebook">
                                            <ion-icon name="logo-facebook"></ion-icon>
                                        </a>
                                    </li>

                                </ul>

                            </div>

                        </div>

                        <div class="newsletter">

                            <h2 class="h2">Newsletter</h2>

                            <div class="wrapper">

                                <p>
                                    Subscribe to our newsletter to be among the first to keep up with the latest updates.
                                </p>

                                <form action="#">
                                    <input type="email" name="email" placeholder="Email Address" required>

                                    <button type="submit" class="btn btn-primary">Subscribe</button>
                                </form>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </main>





        <!--
          - #FOOTER
        -->

        <jsp:include page="layout/footer.jsp" />  





        <!--
          - custom js link
        -->
        <script src="./assets/js/datetime.js"></script>   
        <script src="./assets/js/layout.js"></script>

        <!--
          - ionicon link
        -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


    </body>

</html>
