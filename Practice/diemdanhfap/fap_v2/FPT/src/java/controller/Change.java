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
public class Change extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String password = req.getParameter("password");  
        String newpass = req.getParameter("newpass");
        User u = new User();
        if(u.checkUser2(studentId, password)){
            //Co ton tai
            //Tao 1 password moi            
            //Update pass moi cho account tuong ung
            u.update(studentId,newpass);
            //Tra pass moi ve cho View
            req.setAttribute("password", newpass);
            req.setAttribute("studentId", studentId);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("Change.jsp").forward(req, resp);
        }
    }
    
}
