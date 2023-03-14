/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Product;

/**
 *
 * @author nguye
 */
public class AddProduct extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        String productid = req.getParameter("id");
        String productname = req.getParameter("name");
        String unitprice = req.getParameter("price");
        String instock = req.getParameter("instock");
        String image = req.getParameter("image");
        String categoryid = req.getParameter("categoryid");
        String discountinued = req.getParameter("discountinued");
        String mess="";
        //check product tồn tại hay không
        Product p = new Product();
        
//        if(p.checkProductId(productid)){
//            
//            mess+="product id đã tồn tại xin vui lòng nhập số khác";
//            req.setAttribute("mess", mess);
//            req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
//        
//        }
//        else{
            if(p.checkProductname(productname)){
                
                mess+="product name đã tồn tại xin vui lòng nhập số khác";
                req.setAttribute("mess", mess);
                req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
 
            }else{
                p.insertproduct(productname,unitprice,instock,image,categoryid,discountinued);
                
                req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);
//            }
        
        
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);
    }
    
    
    
}
