<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title> Login Page </title>
  <style>
    body {
      background-color: #c72e0c;
      background-image: url(assets/img/Images/dark-sunset.jpg);
      font-family: 'Ubuntu', sans-serif;
    }

    .main {
      background-color: #eecbcb;
      width: 500px;
      height: 900px;
      margin: 7em auto;
      border-radius: 1.5em;
      box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);

    }

    .sign {
      padding-top: 40px;
      color: #080202;
      font-family: 'Ubuntu', sans-serif;
      font-weight: bold;
      font-size: 23px;
    }

    .un {
      width: 76%;
      color: rgb(0, 5, 7);
      font-weight: 700;
      font-size: 14px;
      letter-spacing: 1px;
      background: rgba(136, 126, 126, 0.04);
      padding: 10px 20px;
      border: none;
      border-radius: 20px;
      outline: none;
      box-sizing: border-box;
      border: 2px solid rgba(0, 0, 0, 0.02);
      margin-bottom: 50px;
      margin-left: 46px;
      text-align: center;
      margin-bottom: 27px;
      font-family: 'Ubuntu', sans-serif;
    }

    form.form1 {
      padding-top: 40px;
    }

    .pass {
      width: 76%;
      color: rgb(1, 3, 4);
      font-weight: 700;
      font-size: 14px;
      letter-spacing: 1px;
      background: rgba(136, 126, 126, 0.04);
      padding: 10px 20px;
      border: none;
      border-radius: 20px;
      outline: none;
      box-sizing: border-box;
      border: 2px solid rgba(0, 0, 0, 0.02);
      margin-bottom: 50px;
      margin-left: 46px;
      text-align: center;
      margin-bottom: 27px;
      font-family: 'Ubuntu', sans-serif;
    }


    .un:focus,
    .pass:focus {
      border: 2px solid rgba(4, 4, 4, 0.18) !important;

    }

    .submit {
      font-weight: bolder;
      cursor: pointer;
      border-radius: 5em;
      color: rgb(24, 21, 20);
      background: linear-gradient(to right, #df0a0d, #e0b005);
      border: 0;
      padding-left: 40px;
      padding-right: 40px;
      padding-bottom: 10px;
      padding-top: 10px;
      font-family: 'Ubuntu', sans-serif;
      margin-left: 35%;

      font-size: 14px;
      box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);

    }


    .forgot {
      text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
      color: #ee0c0c;
      padding-top: 15px;
    }

    a {
      text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
      color: rgb(195, 16, 52);
      text-decoration: none
    }

    @media (max-width: 600px) {
      .main {
        border-radius: 0px;
      }
    }
    
  </style>
</head>

<body>

  <form action="register" method="get">
    <div class="main">
      <p style="font-size: 30px; color: black" class="sign" align="center">Register</p>
      <p style="font-size: 15px; margin-top: -60px; color: rgb(67, 69, 71);" class="sign" align="center">Please fill in this form to create an account.</p>
       <br><label for="email"></label>
      <input class="un " type="text" name="email" placeholder="Email (VD:anhvubui382@gmail.com)">

      <br><label for="fullname"></label>
      <input class="un " type="text" name="fullname" placeholder="Fullname (VD: Bui Anh Vu)">
      <br><label for="email"></label>
      <input class="un " type="text" name="acc" placeholder="Username">

      <br><label for="psw"></label>
      <input class="un " type="text" name="pass" placeholder="Password">

      <br><label for="psw"></label>
      <input class="un " type="text" name="sdt" placeholder="Phone Number">

     

      <br><label for="psw"></label>
      <input class="un " type="text" name="dob" placeholder="Birth of date">

      <br><label for="psw"></label>
      <input class="un " style="margin-bottom: -20px;"type="text" name="address" placeholder="Address">
      <p class="sign" align="center">Gender</p>
      <input style="margin-left: 180px; margin-bottom: 40px;" type="radio" name="gender" value="0"> <b>Female</b>
      <input class="gender" type="radio" name="gender" value="1"> <b>Male</b>
      <br><input style="margin-left:115px ; margin-bottom: 20px;"  type="checkbox">I accept <a href="https://www.performancefoodservice.com/Company/Terms-of-Use-and-Privacy">Terms of Use & Privacy Policy</a>
      <br><input class="submit" type="submit" value="Register">
      ${mess}

    </div>
  </form>
</body>

</html>