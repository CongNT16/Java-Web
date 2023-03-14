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
import java.time.LocalDateTime;
import model.Order;
import model.Product;

/**
 *
 * @author nguye
 */
public class OrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
//        String codeproduct = req.getParameter("codeproduct");
//        String íntockproduct = req.getParameter("íntockproduct");

        Order o = new Order();
        Product p = new Product();
        LocalDateTime getdatetime = LocalDateTime.now();

        String orderdate = String.valueOf(getdatetime);

        o.insertOrder(customerId, orderdate);
//        p.updateStock(codeproduct, íntockproduct);

        resp.sendRedirect("Success.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    

}
