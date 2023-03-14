/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class delete extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("movieID");
        movie s = new movie();
        s.deleteProduct(id);
        ArrayList<movie> list = s.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("addfilm.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         movie s = new movie();
        ArrayList<movie> list = s.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("addfilm.jsp").forward(req, resp);
        req.getRequestDispatcher("book1.jsp").forward(req, resp);
     
    }
    
    
}
