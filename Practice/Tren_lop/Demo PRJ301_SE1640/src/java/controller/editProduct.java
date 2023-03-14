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
public class editProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String click = req.getParameter("click");

        if (click.equals("Update")) {
            
            String productid = req.getParameter("productid");
            String productname = req.getParameter("productname");
            String unitprice = req.getParameter("unitprice");
            Product p = new Product();
            
            p.updateProductNP(productid, productname, unitprice);
            
            
            req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);
            
        }

        if (click.equals("Delete")) {

            String productid = req.getParameter("productid");

            Product p = new Product();

            p.deleteProductbyId(productid);

            
            req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Product p = new Product();

        p.getProductbyId(id);

        req.setAttribute("product", p);
        req.getRequestDispatcher("Edit.jsp").forward(req, resp);
    }

}
