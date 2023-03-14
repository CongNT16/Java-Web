<%-- 
    Document   : manage home
    Created on : Oct 21, 2022, 8:52:09 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Manage Home</title>
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>
            <link rel='stylesheet' href='https://unicons.iconscout.com/release/v3.0.6/css/line.css'>   
        <link href="./assets/css/manage_layout.css" rel="stylesheet">

    </head>
    <body>
        <!-- partial:index.partial.html -->

        <jsp:include page="layout/manage_aside.jsp" /> 

        <section id="wrapper">
            
            <jsp:include page="layout/manage_header.jsp" /> 


            <div class="p-4">
                <div class="welcome">
                    <div class="content rounded-3 p-3">
                        <h1 class="fs-3">Welcome to Dashboard</h1>
                        <p class="mb-0">Hello admin, welcome to your awesome dashboard!</p>
                    </div>
                </div>

                
            </div>
        </section>


        <!-- partial -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
        <script  src="./assets/js/manage_aside.js"></script>


    </body>
</html>