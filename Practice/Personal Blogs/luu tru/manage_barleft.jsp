<%-- 
    Document   : bar-left
    Created on : Oct 22, 2022, 8:50:07 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bar left</title>
    </head>
    <body>
        <ul id="slide-out" class="side-nav fixed z-depth-2">
            <li class="center no-padding">
                <div class="indigo darken-2 white-text" style="height: 180px;">
                    <div class="row">
                        <img style="margin-top: 5%;" width="100" height="100" src="./assets/images/gura_logo.png" class="circle responsive-img" />

                        <p style="margin-top: -13%;">
                            Gura Blog
                        </p>
                    </div>
                </div>
            </li>

            <li id="dash_dashboard"><a class="waves-effect" href="#!"><b>Dashboard</b></a></li>

            <ul class="collapsible" data-collapsible="accordion">
                
                <li id="dash_users">
                    <div id="dash_users_header" class="collapsible-header waves-effect"><b>Posts</b></div>
                    <div id="dash_users_body" class="collapsible-body">
                        <ul>
                            <li id="users_seller">
                                <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=1">List post</a>
                            </li>

                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=2">Create a new post</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=3">Delete a post</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=4">Edit a post</a>
                            </li>
                            
                            
                        </ul>
                    </div>
                </li>
                
                <li id="dash_products">
                    <div id="dash_products_header" class="collapsible-header waves-effect"><b>Users</b></div>
                    <div id="dash_products_body" class="collapsible-body">
                        <ul>
                            <li id="products_product">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=1">List user</a>
                            </li>
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=2">Create a new user</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=3">Delete a user</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=4">Edit a user</a>
                            </li>
                        </ul>
                    </div>
                </li>
                
                <li id="dash_products">
                    <div id="dash_products_header" class="collapsible-header waves-effect"><b>Comments</b></div>
                    <div id="dash_products_body" class="collapsible-body">
                        <ul>
                            <li id="products_product">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=1">List comment</a>
                            </li>
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=2">Create a new comment</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=3">Delete a comment</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=4">Edit a comment</a>
                            </li>
                        </ul>
                    </div>
                </li>
                
                

                <li id="dash_products">
                    <div id="dash_products_header" class="collapsible-header waves-effect"><b>Categories</b></div>
                    <div id="dash_products_body" class="collapsible-body">
                        <ul>
                            <li id="products_product">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=1">List category</a>
                            </li>
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=2">Create a new category</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=3">Delete a category</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=4">Edit a category</a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li id="dash_users">
                    <div id="dash_users_header" class="collapsible-header waves-effect"><b>Topics</b></div>
                    <div id="dash_users_body" class="collapsible-body">
                        <ul>
                            <li id="users_seller">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=1">List topic</a>
                            </li>

                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=2">Create a new topic</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=3">Delete a topic</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=4">Edit a topic</a>
                            </li>
                            
                            
                        </ul>
                    </div>
                </li>

                <li id="dash_users">
                    <div id="dash_users_header" class="collapsible-header waves-effect"><b>Tags</b></div>
                    <div id="dash_users_body" class="collapsible-body">
                        <ul>
                            <li id="users_seller">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=1">List tag</a>
                            </li>

                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=2">Create a new tag</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=3">Delete a tag</a>
                            </li>
                            
                            <li id="users_customer">
                                <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=4">Edit a tag</a>
                            </li>
                            
                            
                        </ul>
                    </div>
                </li>
                

                
            </ul>
        </ul>
    </body>
</html>
