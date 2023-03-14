<%-- 
    Document   : manage_lefrbarv2
    Created on : Oct 23, 2022, 11:20:49 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Aside</title>
    </head>
    <body>

        <aside class="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left" id="show-side-navigation1">
            <i class="uil-bars close-aside d-md-none d-lg-none" data-close="show-side-navigation1"></i>
            <div class="sidebar-header d-flex justify-content-center align-items-center px-3 py-4">
                <img
                    class="rounded-pill img-fluid"
                    width="65"
                    src="./assets/images/gura_logo.png"
                    alt="">
                <div class="ms-2">
                    <h5 class="fs-6 mb-0">
                        <a class="text-decoration-none" href="#">Admin</a>
                    </h5>
                    <p class="mt-1 mb-0">trình quảng lý tác vụ</p>
                </div>
            </div>

            <!--            <div class="search position-relative text-center px-4 py-3 mt-2">
                            <input type="text" class="form-control w-100 border-0 bg-transparent" placeholder="Search here">
                            <i class="fa fa-search position-absolute d-block fs-6"></i>
                        </div>-->

            <ul class="categories list-unstyled">
                <li class="manage-asidetohome">
                    <i class="uil uil-tachometer-fast-alt"></i><a href="ManageController"> Dashboard</a>

                </li>
                <li class="has-dropdown">
                    <i class="uil uil-file-alt"></i><a href="#"> Posts</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="users_seller">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=1">List post</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=5">Create a new post</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=3">Delete a post</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=4">Edit a post</a>
                        </li>-->
                    </ul>
                </li>
                <li class="has-dropdown">
                    <i class="uil uil-user"></i><a href="#"> Users</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=1">List user</a>
                        </li>
                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=2">Create a new user</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=3">Delete a user</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=4">Edit a user</a>-->
                        </li>
                    </ul>
                </li>
                <li class="has-dropdown">
                    <i class="uil uil-comment-alt-lines"></i><a href="#"> Comments</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=1">List comment</a>
                        </li>
                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=2">Create a new comment</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=3">Delete a comment</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=4">Edit a comment</a>
                        </li>-->
                    </ul>
                </li>
                <li class="has-dropdown">
                    <i class="uil uil-books"></i><a href="#"> Categories</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=1">List category</a>
                        </li>
                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=2">Create a new category</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=3">Delete a category</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=4">Edit a category</a>
                        </li>-->
                    </ul>
                </li>
                <li class="has-dropdown">
                    <i class="uil uil-swatchbook"></i><a href="#"> Topics</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="users_seller">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=1">List topic</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=2">Create a new topic</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=3">Delete a topic</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=4">Edit a topic</a>
                        </li>-->
                    </ul>
                </li>
                <li class="has-dropdown">
                    <i class="uil uil-tag"></i><a href="#"> Tags</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="users_seller">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=1">List tag</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=2">Create a new tag</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=3">Delete a tag</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=4">Edit a tag</a>
                        </li>-->
                    </ul>
                </li>
                
            </ul>
        </aside>

    </body>
</html>
