<%-- 
    Document   : manage_listpost
    Created on : Oct 22, 2022, 9:26:19 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <div style="padding: 50px 10px;">

                <div class="manage-posts-listpost">
                    <c:if test="${thread == '1'}">
                        <div class="container">
                            <div class="manage-list-group">

                                <div >
                                    <h2 class="item-name-listh2" style="color: white;">List Post </h2>
                                    <div class="list-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <table class="table table-striped" >
                                            <thead>
                                                <tr>
                                                    <th scope="col"  style="width: 5%">#</th>
                                                    <th scope="col"  style="width: 5%">ID</th>    
                                                    <th scope="col"  style="width: 15%">Title</th>                                       
                                                    <th scope="col"  style="width: 5%">Category</th>
                                                    <th scope="col"  style="width: 5%">Topic</th>
                                                    <th scope="col"  style="width: 5%">Tag</th>
                                                    <th scope="col"  style="width: 5%">Author</th>
                                                    <th scope="col"  style="width: 5%">Create</th>                                            
                                                    <th scope="col"  style="width: 40%">Detail</th>                                                  
                                                    <th scope="col"  style="width: 5%">Image</th>
                                                    <th scope="col"  style="width: 5%">Del</th>
                                                    <th scope="col"  style="width: 5%">Edit</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <%--<c:forEach begin="1" end="${toltalpost}" var="i">--%>
                                                <%--<c:set var="i" value="1">--%>
                                                <c:forEach items="${listpost}" var="post" varStatus="count">
                                                    <tr>

                                                        <th scope="row" >${count.count}</th>
                                                            <%--<c:set value="i+1"></c:set>--%>
                                                        <td>${post.getPost_id()}</td>    
                                                        <td>${post.getPost_title()}</td>                                                                      
                                                        <td>${post.getTopic_name()}</td>
                                                        <td>${post.getCategory_name()}</td>
                                                        <td >
                                                            <ul style="list-style: none; ">

                                                                <c:forEach items="${listPostTag}" var="tag">
                                                                    <c:if test="${post.getPost_id().equals(tag.getPost_id())}">
                                                                        <li>${tag.getTag_name()}</li>
                                                                        </c:if>
                                                                    </c:forEach>


                                                            </ul>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${listuser}" var="user">
                                                                <c:if test="${post.getPost_author_id().equals(user.getUser_id())}">
                                                                    ${user.getUser_firstname()}&nbsp;${user.getUser_lastname()}
                                                                </c:if>
                                                            </c:forEach>

                                                        </td>
                                                        <td>
                                                            <ul style="list-style: none; ">
                                                                <li>${post.getPost_create_date()}</li>
                                                                <li>${post.getPost_create_time()}</li>

                                                            </ul>
                                                        </td>

                                                        <td style="font-size: 9pt">${post.getPost_body()}</td>

                                                        <td>
                                                            <ul style="list-style: none; ">
                                                                <c:forEach items="${listimages}" var="image">
                                                                    <c:if test="${post.getPost_id().equals(image.getPost_id())}">
                                                                        <li><img src="./assets/images/${image.getImg_filename()}" alt="alt" width="100px" height="100px"/></li>
                                                                        </c:if>
                                                                    </c:forEach>



                                                            </ul>
                                                        </td>
                                                        <td><a  onclick="delWithPostId(${post.getPost_id()})"><i class="uil uil-trash-alt"></i></a></td>
                                                        <td><a onclick="editWithPostId(${post.getPost_id()})"><i class="uil uil-file-edit-alt"></i></a></td>
                                                    </tr>

                                                </c:forEach>
                                                <%--</c:set>--%>
                                                <%--</c:forEach>--%>


                                            </tbody>

                                        </table>



                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '2'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Create Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form id="createpost" action="ManagePostsController" method="get">
                                            <input name="thread" value="6" hidden>
                                            <input name="post_author_id" value="${sessionScope.user_login_id}" hidden>


                                            <table class="table " >

                                                <tr>
                                                    <td>Post Topic</td>
                                                    <td>
                                                        <c:forEach items="${listtopic}" var="topic">
                                                            <input type="radio" name="post_topic" value="${topic.getTopic_id()}"> ${topic.getTopic_name()}
                                                        </c:forEach>
                                                    </td>
                                                </tr>  
                                                <tr>
                                                    <td style="width: 10%">Post Title</td>
                                                    <td><input type="text" name="post_title"></td>
                                                </tr>

                                                <tr>

                                                    <td>Post Tag</td>
                                                    <td>
                                                        <c:forEach items="${listtag}" var="tag">
                                                            <input type="checkbox" name="post_tag" value="${tag.getTag_id()}"> ${tag.getTag_name()}
                                                        </c:forEach>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Post Detail</td>
                                                    <td><textarea name="post_detail" ></textarea>
                                                </tr>
                                                <tr>
                                                    <td>Post Image</td>
                                                    <td><input type="text" name="post_image"></td>
                                                </tr>
                                            </table>
                                            <input  name="submit" type="submit" value="Create" style="margin: 20px 100px 20px ">
                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>

                    <!-- comment test=thread == '3'
                    
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Delete Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManagePostsController">
                                            <input type="text" hidden name="thread" value="3">
                                            <div style="margin: 20px 100px 10px">
                                                <label>Nhập ID Post muốn xoá</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="idpostdel">
                                                &emsp;<input  name="click" type="submit" value="Check" style="margin: 20px 100px 20px ">
                                            </div>
                                            <div class="mess-error">
                                                &emsp;<input type="text" name="mess-err" readonly style="margin: 10px 300px 50px">
                                            </div>

                                            
                                                <br>
                                                <input  name="click" type="submit" value="Delete" style="margin: 20px 400px 20px ">
                                                <br>
                                                <table class="table table-striped" >
                                                    <thead>
                                                        <tr>
                                                            <th scope="col"  style="width: 5%">#</th>
                                                            <th scope="col"  style="width: 5%">ID</th>    
                                                            <th scope="col"  style="width: 15%">Title</th>                                       
                                                            <th scope="col"  style="width: 5%">Category</th>
                                                            <th scope="col"  style="width: 5%">Topic</th>
                                                            <th scope="col"  style="width: 5%">Tag</th>
                                                            <th scope="col"  style="width: 5%">Author</th>
                                                            <th scope="col"  style="width: 5%">Create</th>                                            
                                                            <th scope="col"  style="width: 40%">Detail</th>
                                                            <th scope="col"  style="width: 5%">Thumbnail </th>
                                                            <th scope="col"  style="width: 5%">Image</th> 
                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">1</th>
                                                            <td>postid</td>    
                                                            <td>posttitle</td>                                       
                                                            <td>Post Category</td>
                                                            <td>Post Topic</td>
                                                            <td >
                                                                <ul style="list-style: none; ">
                                                                    <li>Post Tag</li>
                                                                    <li>Post Tag</li>
                                                                    <li></li>
                                                                    <li></li>
                                                                    <li></li>
                                                                </ul>
                                                            </td>
                                                            <td>Post Author</td>
                                                            <td>
                                                                <ul style="list-style: none; ">
                                                                    <li>postdate</li>
                                                                    <li>posttime</li>

                                                                </ul>
                                                            </td>

                                                            <td>postdetail</td>
                                                            <td>
                                                                <ul style="list-style: none; ">
                                                                    <li>Post Image</li>


                                                                </ul>
                                                            </td>
                                                        </tr>

                                                    </tbody>

                                                </table>
                                            




                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                   
                    -->

                    <c:if test="${thread == '4'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Edit Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManagePostsController" method="get">
                                            <input name="thread" value="7" hidden>
                                            <input name="post_author_id" value="${sessionScope.user_login_id}" >
                                            
                                            <div style="margin: 20px 100px 10px">
                                                <label>Post ID</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="idpostedit" readonly value="${idpostedit}">
                                                <br><label>Post Topic</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="postedittopic" readonly value="${post_topicname}">
                                                 <br><label>Post Tag</label>
                                                &emsp;&emsp;&emsp;
                                                <c:forEach items="${posttag}" var="tag">
                                                    <c:if test="${tag.getPost_id() == idpostedit}">
                                                        ${tag.getTag_name()}&emsp;
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <br><br>



                                            <table class="table " >


                                             
                                                <tr>
                                                    <td>Post Topic</td>
                                                    <td>
                                                        <c:forEach items="${listtopic}" var="topic">
                                                            <input type="radio" name="post_topic" value="${topic.getTopic_id()}" > ${topic.getTopic_name()}
                                                        </c:forEach>
                                                    </td>
                                                </tr>  
                                                <tr>
                                                    <td style="width: 10%">Post Title</td>
                                                    <td><input type="text" name="post_title" value="${post_title}"></td>
                                                </tr>

                                                <tr>

                                                    <td>Post Tag</td>
                                                    <td>
                                                        <c:forEach items="${listtag}" var="tags">
                                                            <input type="checkbox" name="post_tag" value="${tags.getTag_id()}"> ${tags.getTag_name()}
                                                        </c:forEach>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Post Detail</td>
                                                    <td><input name="post_detail" value="${post_detail}">
                                                </tr>
                                                <tr>
                                                    <td>Post Image</td>
                                                    <td><input type="text" name="post_image" value="${post_image}"></td>


                                            </table>
                                            <input  name="submit" type="submit" value="Save" style="margin: 20px 100px 20px ">
                                        </form>




                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '5'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Create Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManagePostsController" method="get">
                                            <input name="thread" value="2" hidden>


                                            <table class="table " >


                                                <tr>
                                                    <td>Post Category</td>
                                                    <td>
                                                        <select name="getcategoryid"">
                                                            <option hidden>Chọn Category</option>
                                                            <c:forEach items="${listcategory}" var="category">
                                                                <option value="${category.getCategory_id()}">${category.getCategory_name()}</option>
                                                            </c:forEach>
                                                        </select> 
                                                    </td>
                                                </tr> 
                                            </table>
                                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                            <button type="submit">Get Category</button>

                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>


                    </c:if>




                </div>





            </div>
        </section>


        <!-- partial -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
        <!--<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>-->
        <script  src="./assets/js/manage_aside.js"></script>
        <script  src="./assets/js/manage_posts.js"></script>



    </body>
</html>
