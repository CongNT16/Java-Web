<%-- 
    Document   : Create
    Created on : Oct 26, 2022, 11:40:10 AM
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
        <h2 class="text-center text-dark mt-5">Create Account</h2>
        
        <div class="card my-5">

            <form class="card-body cardbody-color p-lg-5" action="register" method="get" >

            <div class="text-center">
              <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                width="200px" alt="profile">
            </div>

            <div class="mb-3">
                <input type="text" class="form-control" id="Username" name="studentId" aria-describedby="emailHelp"
                placeholder="User Name">
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" id="password" name="password" placeholder="password">
              <br>
              <input type="text" class="form-control" id="name" name="name" placeholder="Name">
              <br>
              <br>Gender<input type="radio" name="gender" value="1">Male
              <input type="radio" name="gender" value="2">Female
              <br>
              <input type="text" class="form-control" id="dob" name="dob" placeholder="DateOfBirth">
              <br>
              <input type="text" class="form-control" id="adress" name="address" placeholder="Address">
              <br>
              <input type="text" class="form-control" id="campus" name="campus" placeholder="Campus">
              
            </div>
            <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button></div>
            
            </div>
          </form>
        </div>

      </div>
    </div>
  </div>
    </body>
</html>
