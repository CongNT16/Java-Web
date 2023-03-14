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
 * @author nguye
 */
public class Register extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //register
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        
        //check account ton tai hay khong
        
        User us = new User();
        if(us.checkUser(account,dob)){
            //có tồn tại
            
            //Thong bao
            String mess="";
            mess+="tai khoan da ton tai, vui long nhap ten khac";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }
        else{
            //insertdata
            us.insert(account,pass,name,gender,address,dob);
            
            req.setAttribute("account", account);
            req.setAttribute("pass", pass);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //change pass
        
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String newpass1 = req.getParameter("newpass1");
        String newpass2 = req.getParameter("newpass2");
        String mess="";
        //check account ton tai hay khong
        
        User us = new User();
        if(us.checkUser2(account,pass)){
            //có tồn tại
            
            if(newpass1.equals(newpass2) ){
            us.update(account,newpass1);
            
            req.setAttribute("account", account);
            req.setAttribute("pass", newpass1);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            
            }else{
            
            mess+="nhap lai pass";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
            }
           
            
            
        }
        else{
            //insertdata
            
            //Thong bao
            
            mess+="sai tai khoan hoac mat khau";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
            
        }
        
    }
    
    
}
