<%-- 
    Document   : addproduct
    Created on : Oct 26, 2022, 3:04:23 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Product</title>
    </head>
    <body>
        <form action="addproduct" method="post">
                <!--Product ID<input type="text" name="id">-->
            <br>Product Name<input type="text" name="name">
            <br>Unit Price<input type="text" name="price">
            <br>Units IN Stock<input type="text" name="instock">
            <br>Image<input type="text" name="image">
            <br>CategoryID<input type="radio" name="categoryid" value="1">Laptop
                          <input type="radio" name="categoryid" value="2">PC
                          <input type="radio" name="categoryid" value="3">Mobile
                          <input type="radio" name="categoryid" value="4">Tablet
            
            <br>Discountinued<input type="radio" name="discountinued" value="1">True
                             <input type="radio" name="discountinued" value="0">False
            
            
            <br><input type="submit" value="ADDPRODUCT" name="ADDPRODUCT">
            <br><br>${mess}
            
        </form>
    </body>
</html>
