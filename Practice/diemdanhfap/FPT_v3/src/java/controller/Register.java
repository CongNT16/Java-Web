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
import model.User;

/**
 *
 * @author Admin
 */
public class Register extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String studentId = req.getParameter("studentId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
         String campus = req.getParameter("campus");
        

        User u = new User();
        if(u.checkUser(studentId)){
            //Co ton tai
            String mess="";
            mess+="tai khoan da ton tai";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Create.jsp").forward(req, resp);  
        }
        else{                      
            
           u.create(studentId, password, name, gender, dob, address, campus);
        
            req.setAttribute("studentId", studentId);
            req.setAttribute("password", password);
            req.setAttribute("name", name);
            req.setAttribute("gender", gender);
            req.setAttribute("dob", dob);
            req.setAttribute("address", address);
            req.setAttribute("campus", campus);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }
    
}
