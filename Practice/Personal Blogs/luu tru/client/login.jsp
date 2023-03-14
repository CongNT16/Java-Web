<%-- 
    Document   : login_client
    Created on : Oct 13, 2022, 10:30:56 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="assets/css/login.css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
    </head>
    <body>
        
        <jsp:include page="layout/header.jsp" />
        
        
        <div class="cont">
            <div class="form sign-in">
                <form action="controll_login" method="get">
                <h2>Sign In</h2>
                <label>
                    <span>Account</span>
                    <input type="text" name="acc" value="${account}">
                </label>
                <label>
                    <span>Password</span>
                    <input type="password" name="pass" value="${pass}">
                </label>
                <button class="submit" type="submit" name="login" value="login">Sign In</button>
                <!--<input class="submit" type="submit" name="login" value="login">-->

                <p class="forgot-pass">Forgot Password ?</p>

                <!-- <div class="social-media">
                  <ul>
                    <li><img src="assets/images/login/facebook.png"></li>
                    <li><img src="assets/images/login/twitter.png"></li>
                    <li><img src="assets/images/login/linkedin.png"></li>
                    <li><img src="assets/images/login/instagram.png"></li>
                  </ul>
                </div> -->
                </form>
            </div>

            <div class="sub-cont">
                <div class="img">
                    <div class="img-text m-up">
                        <h2>New here?</h2>
                        <p>Sign up and interact with us!</p>
                    </div>
                    <div class="img-text m-in">
                        <h2>One of us?</h2>
                        <p>If you already has an account, just sign in. We've missed you!</p>
                    </div>
                    <div class="img-btn">
                        <span class="m-up">Sign Up</span>
                        <span class="m-in">Sign In</span>
                    </div>
                </div>
                <div class="form sign-up">
                    <h2>Sign Up</h2>
                    <label>
                        <span>Name</span>
                        <input type="text">
                    </label>
                    <label>
                        <span>Email</span>
                        <input type="email">
                    </label>
                    <label>
                        <span>Password</span>
                        <input type="password">
                    </label>
                    <label>
                        <span>Confirm Password</span>
                        <input type="password">
                    </label>
                    <button type="button" class="submit">Sign Up Now</button>
                </div>
            </div>
        </div>
        
        <jsp:include page="layout/footer.jsp" />

        
    </body>
    <script type="text/javascript" src="./assets/js/login.js"></script>
    <script type="text/javascript" src="./assets/js/datetime.js"></script>   
    <script type="text/javascript" src="./assets/js/layout.js"></script>
</html>