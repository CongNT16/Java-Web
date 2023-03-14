<%-- 
    Document   : manage_comments_listcomment
    Created on : Oct 22, 2022, 11:16:32 PM
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
                    <c:if test="${thread eq 1}">
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
                                                    <th scope="col"  style="width: 5%">Thumbnail </th>
                                                    <th scope="col"  style="width: 5%">Image</th> 
                                                </tr>
                                            </thead>
                                            <c:forEach items="listPost" var="post">
                                                <tbody>
                                                    <tr>
                                                        <th scope="row">1</th>
                                                        <td>Post ID</td>    
                                                        <td>Post Title</td>                                       
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
                                                                <li>Post Create Date</li>
                                                                <li>Post Create Time</li>

                                                            </ul>
                                                        </td>

                                                        <td>Post Detail</td>
                                                        <td>Post Thumbnail </td>
                                                        <td>
                                                            <ul style="list-style: none; ">
                                                                <li>Post Image</li>


                                                            </ul>
                                                        </td>
                                                    </tr>

                                                </tbody>
                                            </c:forEach>
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

                                        <form>


                                            <table class="table " >

                                                <thead>
                                                    <tr>
                                                        <th scope="col"  style="width: 30%"></th>
                                                        <th scope="col"  style="width: 70%"></th>    

                                                    </tr>
                                                </thead>


                                                <tbody>
                                                    <tr>
                                                        <th style="width: 10%">Post Title</th>
                                                        <td><input type="text" name="post-create-title"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Topic</td>
                                                        <td><input type="text" name="post-create-title"></td>
                                                    </tr>     

                                                    <tr>

                                                        <td>Post Tag</td>
                                                        <td>

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Detail</td>
                                                        <td><textarea name="detail" ></textarea>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Thumbnail</td>
                                                        <td><input type="file" name="post-create-title"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Image</td>
                                                        <td><input type="file" name="post-create-title"></td>
<!--                                                        <td><input type="file" name="post-create-title"></td>
                                                        <td><input type="file" name="post-create-title"></td>
                                                        <td><input type="file" name="post-create-title"></td>
                                                        <td><input type="file" name="post-create-title"></td>-->
                                                    </tr>

                                                </tbody>

                                            </table>
                                            <input  name="submit" type="submit" value="Create" style="margin: 20px 100px 20px ">
                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>

                    <c:if test="${thread == '3'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Delete Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form>
                                            <div style="margin: 20px 100px 10px">
                                                <label>Nhập ID Post muốn xoá</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="id-delete-post">
                                            </div>
                                            <br><br>

                                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input  name="submit" type="submit" value="Delete" style="margin: 20px 100px 20px ">
                                            <br><br>

                                            <div class="mess-error">
                                                <input type="text" readonly style="margin: 10px 100px 50px">
                                            </div>


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
                                                <c:forEach items="listPost" var="post">
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">1</th>
                                                            <td>Post ID</td>    
                                                            <td>Post Title</td>                                       
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
                                                                    <li>Post Create Date</li>
                                                                    <li>Post Create Time</li>

                                                                </ul>
                                                            </td>

                                                            <td>Post Detail</td>
                                                            <td>Post Thumbnail </td>
                                                            <td>
                                                                <ul style="list-style: none; ">
                                                                    <li>Post Image</li>


                                                                </ul>
                                                            </td>
                                                        </tr>

                                                    </tbody>
                                                </c:forEach>
                                            </table>



                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '4'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Delete Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form>
                                            <div style="margin: 20px 100px 10px">
                                                <label>Nhập ID Post muốn xoá</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="id-delete-post">
                                            </div>
                                            <br><br>

                                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input  name="submit" type="submit" value="Delete" style="margin: 20px 100px 20px ">
                                            <br><br>

                                            <div class="mess-error">
                                                <input type="text" readonly style="margin: 10px 100px 50px">
                                            </div>


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
                                                <c:forEach items="listPost" var="post">
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">1</th>
                                                            <td>Post ID</td>    
                                                            <td>Post Title</td>                                       
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
                                                                    <li>Post Create Date</li>
                                                                    <li>Post Create Time</li>

                                                                </ul>
                                                            </td>

                                                            <td>Post Detail</td>
                                                            <td>Post Thumbnail </td>
                                                            <td>
                                                                <ul style="list-style: none; ">
                                                                    <li>Post Image</li>


                                                                </ul>
                                                            </td>
                                                        </tr>

                                                    </tbody>
                                                </c:forEach>
                                            </table>


                                            <br><br><br>

                                            <table class="table " >

                                                <thead>
                                                    <tr>
                                                        <th scope="col"  style="width: 30%"></th>
                                                        <th scope="col"  style="width: 70%"></th>    

                                                    </tr>
                                                </thead>


                                                <tbody>
                                                    <tr>
                                                        <th style="width: 10%">Post Title</th>
                                                        <td><input type="text" name="post-create-title"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Topic</td>
                                                        <td><input type="text" name="post-create-title"></td>
                                                    </tr>     

                                                    <tr>

                                                        <td>Post Tag</td>
                                                        <td>

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1

                                                            <input type="checkbox" name=""> Tag 1
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Detail</td>
                                                        <td><textarea name="detail" ></textarea>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Thumbnail</td>
                                                        <td><input type="file" name="post-create-title"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Post Image</td>
                                                        <td><input type="file" name="post-create-title"></td>
                                                        
                                                    </tr>

                                                </tbody>

                                            </table>
                                            <input  name="submit" type="submit" value="Create" style="margin: 20px 100px 20px ">




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
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
        <script  src="./assets/js/manage_aside.js"></script>


    </body>
</html>