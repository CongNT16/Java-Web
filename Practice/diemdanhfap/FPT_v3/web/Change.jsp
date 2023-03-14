<%-- 
    Document   : Change
    Created on : Oct 29, 2022, 10:06:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">Change Password</h2>
        
        <div class="card my-5">

            <form class="card-body cardbody-color p-lg-5 " action="change" method="get">

            <div class="text-center">
              <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                width="200px" alt="profile">
            </div>

            <div class="mb-3">
              <input type="text" class="form-control" id="Username" aria-describedby="emailHelp"
             name="studentId"   placeholder="User Name" >
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="password" placeholder="password"  name="password" ">
            </div>
                 <div class="mb-3">
                     <input type="password" class="form-control" id="newpassword" placeholder="newpassword"  name="newpass" " >
            </div>
            <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">Reset Pass</button></div>
            
            </div>
          </form>
        </div>

      </div>
    </div>
  </div>
    </body>
</html>