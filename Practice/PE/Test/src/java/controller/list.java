/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.accountDAO;
import dao.articleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Article;

/**
 *
 * @author nguye
 */
public class list extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        if(session.getAttribute("username")==null){
            resp.sendRedirect("Accessdenied.jsp");
            return;
        }
        
        String username = (String) session.getAttribute("username");
        
        accountDAO a = new accountDAO();
        
        String String username = 
        articleDAO ar = new articleDAO();
        
        ArrayList<Article> list = (ArrayList<Article>) ar.getListArticle();
        
        req.setAttribute("list", list);
        req.setAttribute("displayName", displayName);
        
        
        
        req.getRequestDispatcher("List.jsp").forward(req, resp);
    }
    
    
    
}
