<%-- 
    Document   : admin
    Created on : Oct 21, 2022, 8:52:09 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Admin Dashboard</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/font/material-design-icons/Material-Design-Icons.woff'><link rel="stylesheet" href="./style.css">

        <!-- partial:index.partial.html -->

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="./assets/css/manage_layout.css" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="layout/manage_barleft.jsp" /> 
        <jsp:include page="layout/manage_header.jsp" /> 

        <main>
            <div class="row">
                <div class="col s6">
                    <div style="padding: 35px;" align="center" class="card">
                        <div class="row">
                            <div class="left card-title">
                                <b>User Management</b>
                            </div>
                        </div>

                        <div class="row">
                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">person</i>
                                    <span class="indigo-text text-lighten-1"><h5>Seller</h5></span>
                                </div>
                            </a>
                            <div class="col s1">&nbsp;</div>
                            <div class="col s1">&nbsp;</div>

                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">people</i>
                                    <span class="indigo-text text-lighten-1"><h5>Customer</h5></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col s6">
                    <div style="padding: 35px;" align="center" class="card">
                        <div class="row">
                            <div class="left card-title">
                                <b>Product Management</b>
                            </div>
                        </div>
                        <div class="row">
                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">store</i>
                                    <span class="indigo-text text-lighten-1"><h5>Product</h5></span>
                                </div>
                            </a>

                            <div class="col s1">&nbsp;</div>
                            <div class="col s1">&nbsp;</div>

                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">assignment</i>
                                    <span class="indigo-text text-lighten-1"><h5>Orders</h5></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col s6">
                    <div style="padding: 35px;" align="center" class="card">
                        <div class="row">
                            <div class="left card-title">
                                <b>Brand Management</b>
                            </div>
                        </div>

                        <div class="row">
                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">local_offer</i>
                                    <span class="indigo-text text-lighten-1"><h5>Brand</h5></span>
                                </div>
                            </a>

                            <div class="col s1">&nbsp;</div>
                            <div class="col s1">&nbsp;</div>

                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">loyalty</i>
                                    <span class="indigo-text text-lighten-1"><h5>Sub Brand</h5></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col s6">
                    <div style="padding: 35px;" align="center" class="card">
                        <div class="row">
                            <div class="left card-title">
                                <b>Category Management</b>
                            </div>
                        </div>
                        <div class="row">
                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">view_list</i>
                                    <span class="indigo-text text-lighten-1"><h5>Category</h5></span>
                                </div>
                            </a>
                            <div class="col s1">&nbsp;</div>
                            <div class="col s1">&nbsp;</div>

                            <a href="#!">
                                <div style="padding: 30px;" class="grey lighten-3 col s5 waves-effect">
                                    <i class="indigo-text text-lighten-1 large material-icons">view_list</i>
                                    <span class="truncate indigo-text text-lighten-1"><h5>Sub Category</h5></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="fixed-action-btn click-to-toggle" style="bottom: 45px; right: 24px;">
                <a class="btn-floating btn-large pink waves-effect waves-light">
                    <i class="large material-icons">add</i>
                </a>

                <ul>
                    <li>
                        <a class="btn-floating red"><i class="material-icons">note_add</i></a>
                        <a href="" class="btn-floating fab-tip">Add a note</a>
                    </li>

                    <li>
                        <a class="btn-floating yellow darken-1"><i class="material-icons">add_a_photo</i></a>
                        <a href="" class="btn-floating fab-tip">Add a photo</a>
                    </li>

                    <li>
                        <a class="btn-floating green"><i class="material-icons">alarm_add</i></a>
                        <a href="" class="btn-floating fab-tip">Add an alarm</a>
                    </li>

                    <li>
                        <a class="btn-floating blue"><i class="material-icons">vpn_key</i></a>
                        <a href="" class="btn-floating fab-tip">Add a master password</a>
                    </li>
                </ul>
            </div>
        </main>

        <jsp:include page="layout/manage_footer.jsp" />
    </body>

</html>
<!-- partial -->
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js'></script><script  src="./script.js"></script>

</body>
</html>

