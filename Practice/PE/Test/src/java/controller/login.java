/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.accountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author nguye
 */
public class login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        
        if (username == null && password == null) {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            return;
        }
        
        accountDAO a = new accountDAO();
        
        if (a.checkLogin(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            out.println("<h1>Login Succesfull!</h1>");
            return;
        }
        req.setAttribute("loginMsg", "username or password is invalid!");
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
    
    
    
}
