/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

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
        
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String sdt = req.getParameter("sdt");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        
        

        User u = new User();
        if(u.checkAccount(account)){
            //Co ton tai
            String mess="";
            mess+="tai khoan da ton tai";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);  
        }
        else{                      
            //Update pass moi cho account tuong ung
            u.insert(account,pass,fullname,email,sdt,address,gender,dob);
            //Tra pass moi ve cho View
            req.setAttribute("account", account);
            req.setAttribute("pass", pass);
            req.setAttribute("fullname", fullname);
            req.setAttribute("email", email);
            req.setAttribute("sdt", sdt);
            req.setAttribute("gender", gender);
            req.setAttribute("dob", dob);
            req.setAttribute("address", address);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

}
