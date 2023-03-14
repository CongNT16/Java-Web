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
import java.util.ArrayList;
import model.Customer;
import model.Product;
import model.User;

/**
 *
 * @author nguye
 */
public class DetailController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String id = req.getParameter("id");
        
        Product p = new Product();
        User u = new User();
        Customer c = new Customer();
        
        p.getProductbyId(id);

//        ArrayList<User> listuser = (ArrayList<User>)u.getAll();
//        req.setAttribute("listuser", listuser);
        
        ArrayList<Customer> listcustomer = (ArrayList<Customer>)c.getAll();
        req.setAttribute("listcustomer", listcustomer);
        
        req.setAttribute("p",p);

        req.getRequestDispatcher("Detail.jsp").forward(req, resp);
        
        
    }
    
    
    
}
