
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Users"%>
<%@page import="Models.Posts"%>
<%@page import="DataAccess.PostDAO"%>
<%@page import="DataAccess.UserDAO"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="./assets/css/post.css">

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
        <!--<div class="underline-page"> <p style="border-top: 1px solid var(--action-primary);"></p>-->
    </div>






    <main style="background-color: var(--background-secondary)">
        <p style="padding-bottom: 100px "></p>
        <c:if test="${post_id != null}">
            <div class="container">
                <div class="category-name">
                    <h4>${category}</h4>
                    <h4><i class='bx bx-chevron-right'></i></h4>
                    <h4>${topic}</h4>
                    <h4><i class='bx bx-chevron-right'></i></h4>
                    <h4>${post_title}</h4>
                </div>
            </div>
            <div class="container">
                <div class="post-detail">
                    <div class="title-post">
                        <h1 >${post_title}</h1>
                    </div>
                    <div class="wrapper-flex" >

                        <div class="profile-wrapper">
                            
                            <img src="./assets/images/${avatar_author}" alt="${name_author}" width="50">
                        </div>

                        <div class="wrapper">
                            <a href="#" class="h4">${name_author}</a>

                            <p class="text-sm">
                                <time datetime="${post_create_date}">${post_create_date}</time>
                                <span class="separator"></span>
                            <ion-icon name="time-outline"></ion-icon>
                            <!--<time datetime="PT3M">3 min</time>-->
                            </p>
                        </div>
                    </div>
                    <div class="content-post">
                        <div class="img1-post">
                            <img src="./assets/images/${imagename}" alt="title"class="image-post">
                        </div>
                        <div class="text-post">
                            <p>
                                ${post_body}
                            </p>
                        </div>
                        <!--                        <div class="timecreate-post">
                                                    <time datetime="2019-10-12">2019-10-12</time>
                                                </div>-->

                    </div>

                </div>
            </c:if>

            <div class="container">

                <div class="title-listcomment">
                    <h2>Comment</h2>

                </div>
                <div class="bar-comment">



                    <div class="list-comment">

                        <div class="comment-box">

                            <div class="wrapper-comment">

                                <div class="profile-wrapper">
                                    <img src="./assets/images/author.png" alt="" width="50">
                                </div>

                                <div class="wrapper">
                                    <a href="#" class="h4">tên user</a>

                                    <p class="text-sm">
                                        <time datetime="dateup">11-11-2011</time>
                                        <span class="separator"></span>
                                    <ion-icon name="time-outline"></ion-icon>
                                    <!--<time datetime="PT3M">3 min</time>-->
                                    </p>
                                </div>

                            </div>
                            <div class="user-commnet-text">
                                <p>
                                    nội dung coment
                                </p>
                            </div>
                        </div>



                    </div>
                </div>

            </div>


            <div class="container">
                <div class="container-comment-par">
                    <div class="container-comment">
                        <h2 >Add Comment</h2>
                        <form>
                            <textarea placeholder='Add Your Comment' class="comment-text"></textarea>
                            <div class="comment-button btn">
                                <input type="submit" value='Send'class="send-comment">
                                <button id='clear' class="out-comment">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>




        </div>

        <!--<div class="underline-page"> <p style="border-top: 1px solid var(--action-primary);"></p></div>-->

    </main>






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
