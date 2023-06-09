<%-- 
    Document   : manage_header
    Created on : Oct 22, 2022, 9:21:24 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Header</title>
    </head>
    <body>
        <header>
            <ul class="dropdown-content" id="user_dropdown">
                <li><a class="indigo-text" href="#!">Profile</a></li>
                <li><a class="indigo-text" href="#!">Logout</a></li>
            </ul>

            <nav class="indigo" role="navigation">
                <div class="nav-wrapper">
                    <a data-activates="slide-out" class="button-collapse show-on-" href="#!"><img style="margin-top: 17px; margin-left: 5px;" src="https://res.cloudinary.com/dacg0wegv/image/upload/t_media_lib_thumb/v1463989873/smaller-main-logo_3_bm40iv.gif" /></a>

                    <ul class="right hide-on-med-and-down">
                        <li>
                            <a class='right dropdown-button' href='' data-activates='user_dropdown'><i class=' material-icons'>account_circle</i></a>
                        </li>
                    </ul>

                    <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
                </div>
            </nav>

            <nav>
                <div class="nav-wrapper indigo darken-2">
                    <a style="margin-left: 20px;" class="breadcrumb" href="#!">Admin</a>
                    <a class="breadcrumb" href="#!">Index</a>

                    <div style="margin-right: 20px;" id="timestamp" class="right"></div>
                </div>
            </nav>
        </header>

    </body>
</html>
