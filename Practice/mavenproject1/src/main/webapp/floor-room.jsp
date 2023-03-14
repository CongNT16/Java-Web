<%-- 
    Document   : floor-room
    Created on : Feb 8, 2023, 11:19:21 AM
    Author     : Laputa
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Apaman</title>
        <link rel="icon" type="image/x-icon" href="assets/system/icons8-home-pulsar-color-32.png">
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" href="assets/css/room-management.css">
        <style>
            th,
            td {
                color: white;
            }

            #example_length {
                color: wheat;
            }

            #example_length select {
                color: white;
                background: #191C24;
            }

            #example_filter {
                color: wheat !important;
            }

            #example_filter input {
                color: wheat !important;
            }

            #example_paginate {
                color: wheat !important;
            }

            #example_info {
                color: wheat !important;
            }
        </style>
    </head>

    <body>
        <div class="toast-container position-fixed top-0 end-0 p-3">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="color: black">
            </div>
        </div>
        <div class="container-fluid position-relative d-flex p-0">
            <!-- Sidebar Start -->
            <%@include file="component/common/sidebar.jsp" %>
            <!-- Sidebar End -->
            <div class="content">
                <!-- Navbar Start -->
                <%@include file="component/common/navbar.jsp" %>
                <!-- Navbar End -->
                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">APARTMENT ROOM CONTROL</div>
                <div style="background-color: #191C24; color: white;border-radius:0.375rem; padding: 20px;" class="box-rooom">
                    <table id="example" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Room Name</th>
                                <th>Room Type</th>
                                <th>Floor Id</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <!-------------------------MODAL-------------------------------------->
        <%@include file="component/modal/add-room.jsp" %>
        <%@include file="component/modal/edit-floor.jsp" %>
        <!-------------------------END MODAL---------------------------------->

        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/room-control.js"></script>
        <script src="assets/js/toast.js"></script>
        <script src="assets/js/main.js"></script>
        <!---------------------------------------------SHOW TOAST---------------------------------------------------------->
        <script>
            const messageUpdate = '<%= session.getAttribute("messageUpdate") %>';
            if (messageUpdate !== 'null') {
                const words = messageUpdate.split("|");
                showToast(words[0], words[1], words[2]);
                openModal(words[3]);
            }
        </script>
        <script>
            var editor; // use a global for the submit and return data rendering in the examples

            $(document).ready(function () {
                editor = new $.fn.dataTable.Editor({
                    ajax: "../php/staff.php",
                    table: "#example",
                    fields: [{
                            label: "Room Name:",
                            name: "first_name"
                        }, {
                            label: "Room Type:",
                            name: "last_name"
                        }, {
                            label: "Floor Id:",
                            name: "position"
                        }
                    ]
                });

                // Activate an inline edit on click of a table cell
                $('#example').on('click', 'tbody td:not(:first-child)', function (e) {
                    editor.inline(this);
                });

                $('#example').DataTable({
                    dom: "Bfrtip",
                    ajax: "../php/staff.php",
                    order: [[1, 'asc']],
                    columns: [
                        {
                            data: null,
                            defaultContent: '',
                            className: 'select-checkbox',
                            orderable: false
                        },
                        {data: "first_name"},
                        {data: "last_name"},
                        {data: "position"},
                        {data: "office"},
                        {data: "start_date"},
                        {data: "salary", render: $.fn.dataTable.render.number(',', '.', 0, '$')}
                    ],
                    select: {
                        style: 'os',
                        selector: 'td:first-child'
                    },
                    buttons: [
                        {extend: "create", editor: editor},
                        {extend: "edit", editor: editor},
                        {extend: "remove", editor: editor}
                    ]
                });
            });
        </script>

    </body>
    <%
            request.getSession().removeAttribute("messageUpdate");
    %>
</html>
